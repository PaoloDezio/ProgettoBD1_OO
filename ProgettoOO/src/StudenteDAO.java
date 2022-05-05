import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class StudenteDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	
	public StudenteDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public void salvaStudente(String nome,String cognome,Date dataDiNascita,String luogoDiNascita)  {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO studente(nome,cognome,luogonascita,datanascita) "
							 +"VALUES('"+nome+"','"+cognome+"','"+luogoDiNascita+"','"+dataDiNascita+"')");
			
			st.close();
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean IsStudenteInDB(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		try {
			connessioneDB=istanzaDB.ConnectToDB();

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
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String recuperaCodiceStudente(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		String codiceStudente="";
		try {
			connessioneDB=istanzaDB.ConnectToDB();

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
			istanzaDB.closeDbConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceStudente;
	}
	
	public boolean isStudenteIscrittoAdUnCorso(String codiceStudente,String codiceCorso) {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * "
					+ "					    FROM ISCRIZIONE "
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
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st= connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO ISCRIZIONE VALUES("+codiceCorso+","+codiceStudente+");");	
			
			st.close();
			istanzaDB.closeDbConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
