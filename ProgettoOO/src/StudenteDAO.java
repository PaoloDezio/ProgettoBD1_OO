import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class StudenteDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	
	public StudenteDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public void salvaStudente(String nome,String cognome,Date dataDiNascita,String luogoDiNascita)  {
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO studente(nome,cognome,luogonascita,datanascita) "
							 +"VALUES('"+nome+"','"+cognome+"','"+luogoDiNascita+"','"+dataDiNascita+"')");
			
			st.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IsStudenteInDB(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement st= connessioneDB.createStatement();
			ResultSet rs= st.executeQuery("SELECT * "
									+ "    FROM studente "
									+ "    WHERE nome ='"+nome+"' AND cognome ='"+cognome+"' "
									+ "    AND dataNascita = '"+dataDiNascita+"'"
									+ "    AND luogoNascita = '"+luogoDiNascita+"'");

			if(rs.next()) {
				return true;
			}
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String recuperaCodiceStudente(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		String codiceStudente="";
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement st= connessioneDB.createStatement();
			ResultSet rs= st.executeQuery("SELECT codicestudente "
									+ "    FROM studente "
									+ "    WHERE nome ='"+nome+"' AND cognome ='"+cognome+"' "
									+ "    AND luogoNascita = '"+luogoDiNascita+"' "
									+ "    AND dataNascita = '"+dataDiNascita+"'");
			while(rs.next()) {
				codiceStudente=rs.getString("codicestudente");
			}
			
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceStudente;
	}
	
	public boolean isStudenteIscrittoAdUnCorso(String codiceStudente,String codiceCorso) {
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * "
					+ "					    FROM iscrivere "
					+ "					    WHERE codiceCorso="+codiceCorso+" "
					+ "						AND codiceStudente="+codiceStudente);
			
			if(rs.next()) {
				return true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void iscriviStudente(String codiceStudente,String codiceCorso) {
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement st= connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO iscrivere VALUES("+codiceCorso+","+codiceStudente+");");	
			
			st.close();
			istanzaDB.closeConnectionToDB();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Vector<Vector<String>> recuperaIscrittiAdUnCorso(String codiceCorso){
		Vector<Vector<String>> iscritti = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT s.codicestudente,s.cognome,s.nome "
					+ 									 "FROM studente AS s JOIN iscrivere AS i ON s.codicestudente=i.codicestudente "
					+ 									 "WHERE i.codicecorso="+codiceCorso);

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codicestudente"));
				vettore.add(resultSet.getString("cognome"));
				vettore.add(resultSet.getString("nome"));
				iscritti.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return iscritti;
	};
	
	
	public Vector<Vector<String>> recuperaStudentiIdonei(String codiceCorso){
		Vector<Vector<String>> studentiIdonei = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM studenti_idonei("+codiceCorso+")");

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codicestudente"));
				vettore.add(resultSet.getString("cognome"));
				vettore.add(resultSet.getString("nome"));
				studentiIdonei.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return studentiIdonei;
	};


}
