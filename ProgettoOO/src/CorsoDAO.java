import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CorsoDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	
	
	public void inserisciCorso(String nome,String descrizione,String numeroMassimoPartecipanti,String numeroLezioni,Date dataDiInizio,String codiceResponsabile) {
		try {
			connessioneDB=istanzaDB.connectToDB();	
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO CORSO(");
			
			}
		catch(SQLException e) {
			
		}
	}
	
	
	public String recuperaCodiceCorso(String nome) {
		String codiceCorso="";
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statetement= connessioneDB.createStatement();
			ResultSet resultSet= statetement.executeQuery("SELECT codicecorso FROM CORSO WHERE nome ='"+nome+"'");
			
			while(resultSet.next()) {
				codiceCorso=resultSet.getString("codicecorso");
			}
			
			statetement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceCorso;
	}
	
	public Vector<Vector<String>> recuperaCorsi(){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							   c.descrizione,c.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "						FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,\r\n"
					+ "															c.descrizione,c.codiceresponsabile,"
					+ "															c.datainizio\r\n"
					+ "						    						 FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)\r\n"
					+ "					        						 AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "						ORDER BY codicecorso");

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("cognome"));
				corsi.add(vettore);
			}
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return corsi;
	}
	
	public int contaCorsi() {
		Integer numeroCorsi=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CORSO");	
			resultSet.next();
			numeroCorsi=resultSet.getInt(1);
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroCorsi;
	}
	
	public String[] recuperaCorsi(int numeroCorsi) {
		String[] corsi = new String[numeroCorsi]; 
		int i=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CORSO ORDER BY codiceCorso");	
		
			while(resultSet.next()) {
				corsi[i]=resultSet.getString("nome");
				i++;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return corsi;
	}
	
	public Vector<Vector<String>> ricercaCorsoPerNome(String nome){
		Vector<Vector<String>> corsiPerNome = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							   c.descrizione,c.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "						FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,\r\n"
					+ "															c.descrizione,c.codiceresponsabile,"
					+ "															c.datainizio\r\n"
					+ "						    						 FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)\r\n"
					+ "					        						 AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "						WHERE Nome LIKE '%"+nome+"%'"
					+ "						ORDER BY codiceCorso");

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("cognome"));
				corsiPerNome.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerNome;
	}
	
	public Vector<Vector<String>> ricercaCorsoPerData (String data){
		Vector<Vector<String>> corsiPerData = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							   c.descrizione,c.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "						FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,\r\n"
					+ "															c.descrizione,c.codiceresponsabile,"
					+ "															c.datainizio\r\n"
					+ "						    						 FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)\r\n"
					+ "					        						 AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "						WHERE CAST(C.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' "
							+ "				ORDER BY codiceCorso");

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("cognome"));
				corsiPerData.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerData;
	}

	public Vector<Vector<String>> ricercaCorsoPerCategoria(String categoria){
		Vector<Vector<String>> corsiPerCategoria = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							   c.descrizione,c.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "						FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,\r\n"
					+ "															c.descrizione,c.codiceresponsabile,"
					+ "															c.datainizio\r\n"
					+ "						    						 FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)\r\n"
					+ "					        						 AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "						WHERE LDTC.categoria LIKE '%"+categoria+"%'"
					+ "						ORDER BY codiceCorso");


			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("cognome"));
				corsiPerCategoria.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerCategoria;
	}
	
	public Vector<Vector<String>> ricercaCorsoPerParolaChiave(String parolaChiave){
		Vector<Vector<String>> corsiPerParolaChiave = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							   c.descrizione,c.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "						FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,\r\n"
					+ "															c.descrizione,c.codiceresponsabile,"
					+ "															c.datainizio\r\n"
					+ "						    						 FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)\r\n"
					+ "					        						 AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "						WHERE C.descrizione LIKE '%"+parolaChiave+"%' "
					+ "						ORDER BY codiceCorso");

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("cognome"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("descrizione"));
				corsiPerParolaChiave.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerParolaChiave;
	}


	public void eliminaCorso(Object codiceCorso) {
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("DELETE FROM CORSO WHERE CODICECORSO="+codiceCorso);
		
			statement.close();
			istanzaDB.closeConnectionToDB();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void modificaCorso(Object codiceCorso,String nome,String codiceresponsabile,String data,String descrizione,String categoria) {
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("UPDATE CORSO SET nome='"+nome+"',datainizio='"+data+"',descrizione='"+descrizione+"',codiceresponsabile='"+codiceresponsabile+"' WHERE codicecorso="+codiceCorso);
			statement.executeUpdate("UPDATE TEMATICA_CORSO SET categoria='"+categoria+"' WHERE CODICECORSO= "+codiceCorso);
			
			statement.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String recuperaNomeCorso(String codiceCorso) {
		String nomeCorso="";
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT C.nome FROM CORSO AS C WHERE CODICECORSO="+codiceCorso);
			
			while(resultSet.next()) {
				nomeCorso=resultSet.getString("nome");
			}
				
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeCorso;
	}
	
	
}
