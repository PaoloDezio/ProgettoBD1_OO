import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CorsoDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public void inserisciCorso(String nomeCorso,String descrizione,String numeroMassimoPartecipanti,String numeroLezioni,String dataDiInizio,String codiceResponsabile) {
		try {
			connessioneDB=istanzaDB.connectToDB();	
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO CORSO(nome,descrizione,numeromaxpartecipanti,numerolezioni,datainizio,codiceresponsabile)"
					+               "VALUES ('"+nomeCorso+"','"+descrizione+"',"
											  +numeroMassimoPartecipanti+","+numeroLezioni+",'"+dataDiInizio+"',"
											  +codiceResponsabile+")");
			statement.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public String recuperaCodiceCorso(String nome) {
		String codiceCorso="";
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement= connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT codicecorso FROM CORSO WHERE nome ='"+nome+"'");
			
			while(resultSet.next()) {
				codiceCorso=resultSet.getString("codicecorso");
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceCorso;
	}
	
	public Vector<Vector<String>> ricercaCorsi(String nome,String data,String parolaChiave){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome,r.codiceresponsabile "
					+ "									  FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio "
					+ "																   FROM tematica_corso AS tc JOIN corso AS co ON tc.codicecorso=co.codicecorso"
					+ "																  ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile "
					+ "									  WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%' "
					+ "									  ORDER BY ti.codiceCorso");
			
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
	
	
	public Vector<Vector<String>> ricercaCorsiPerCategoria(String categorieSelezionate,String nome,String data,String parolaChiave){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome,r.codiceresponsabile\r\n"
					+ "FROM RESPONSABILE AS r JOIN\r\n"
					+ "					(SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio\r\n"
					+ "						  FROM tematica_corso AS tc JOIN (SELECT * FROM ricerca_per_categoria('"+categorieSelezionate+"')) as co ON tc.codicecorso=co.codicecorso\r\n"
					+ "									      ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile\r\n"
					+ "WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%'"
					+ "ORDER BY ti.codicecorso;");
			
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
	
	
	
	
	public Vector<Vector<String>> recuperaCorsi(){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT c.codicecorso,c.nome,c.datainizio,"
					+ "							  		  c.descrizione,c.categoria,r.cognome,r.codiceresponsabile"
					+ "									  FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,c.nome,"
					+ "																		  c.descrizione,c.codiceresponsabile,"
					+ "																		  c.datainizio"
					+ "						    						 			   FROM tematica_corso AS tc JOIN corso AS c ON tc.codicecorso=c.codicecorso)"
					+ "					        						 			   AS c ON r.codiceresponsabile=c.codiceresponsabile\r\n"
					+ "									ORDER BY codicecorso");

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
	
	
	public Vector<Vector<String>> recuperaCorsiOrdinatiPerCodiceCorso(String nome,String data,String parolaChiave,String ordinamento){
		Vector<Vector<String>> corsiPerCodiceCorso = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome,r.codiceresponsabile "
					+ "									  FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio "
					+ "																   FROM tematica_corso AS tc JOIN corso AS co ON tc.codicecorso=co.codicecorso"
					+ "																  ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile "
					+ "									  WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%' "
					+ "									  ORDER BY ti."+ordinamento);

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codiceCorso"));
				vettore.add(resultSet.getString("nome"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("datainizio"));
				vettore.add(resultSet.getString("categoria"));
				vettore.add(resultSet.getString("cognome"));
				corsiPerCodiceCorso.add(vettore);
			}

			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerCodiceCorso;
	}
	
	public Vector<Vector<String>> recuperaCorsiOrdinatiPerNome(String nome,String data,String parolaChiave,String ordinamento){
		Vector<Vector<String>> corsiPerNome = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome,r.codiceresponsabile "
					+ "									  FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio "
					+ "																   FROM tematica_corso AS tc JOIN corso AS co ON tc.codicecorso=co.codicecorso"
					+ "																  ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile "
					+ "									  WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%' "
					+ " ORDER BY ti."+ordinamento);

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
		
	public Vector<Vector<String>> recuperaCorsiOrdinatiPerData(String nome,String data,String parolaChiave,String ordinamento){
		Vector<Vector<String>> corsiPerData = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome,r.codiceresponsabile "
					+ "									  FROM RESPONSABILE AS r JOIN (SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio "
					+ "																   FROM tematica_corso AS tc JOIN corso AS co ON tc.codicecorso=co.codicecorso"
					+ "																  ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile "
					+ "									  WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%' "
					+ " ORDER BY ti."+ordinamento);

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
	
	public void modificaCorso(String codiceCorso,String nome,String descrizione,String data,String codiceResponsabile,String categoria,String oldCategoria) {
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("UPDATE CORSO SET nome='"+nome+"',descrizione='"+descrizione+"',datainizio='"+data+"',codiceresponsabile="+codiceResponsabile+" WHERE codicecorso="+codiceCorso+";");
			statement.executeUpdate("UPDATE TEMATICA_CORSO SET categoria='"+categoria+"' WHERE codicecorso="+codiceCorso+" AND categoria='"+oldCategoria+"'");
			
			statement.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
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
