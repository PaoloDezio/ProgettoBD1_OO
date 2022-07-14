import java.sql.*;
import java.util.Vector;

public class CorsoDAO {
	
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	//METODI
	public void aggiungiCorso(String nomeCorso,String descrizione,String numeroMassimoPartecipanti,String numeroLezioni,String dataDiInizio,String codiceResponsabile) {
		
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
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceCorso;
		
	}
	
	
	
	public int contaCorsi() {
		
		int numeroCorsi=0;
		
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
		int indice=0;
		
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CORSO ORDER BY nome");	
		
			while(resultSet.next()) {
				corsi[indice]=resultSet.getString("nome");
				indice++;
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
	
	
	
	public Vector<Vector<String>> recuperaCorsiOrdinatiPer(String ordinamento,String nome,String data,String parolaChiave){
		
		Vector<Vector<String>> corsiPerCodiceCorso = new Vector<Vector<String>>();
		
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome"
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
	
	
	
	public Vector<Vector<String>> recuperaCorsiPerCategorieOrdinatiPer(String ordinamento,String categorieSelezionate,String nome,String data,String parolaChiave){
		
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome\r\n"
					+ "FROM RESPONSABILE AS r JOIN\r\n"
					+ "					(SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio\r\n"
					+ "						  FROM tematica_corso AS tc JOIN (SELECT * FROM ricerca_per_categoria('"+categorieSelezionate+"')) as co ON tc.codicecorso=co.codicecorso\r\n"
					+ "									      ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile\r\n"
					+ "WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%'"
					+ "ORDER BY ti."+ordinamento);
			
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
	
	
	
	public Vector<Vector<String>> recuperaCorsiPerUnaCategoriaOrdinatiPer(String ordinamento,String categorieSelezionate,String nome,String data,String parolaChiave){
		
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome\r\n"
					+ "									 FROM RESPONSABILE AS r JOIN\r\n"
					+ "															(SELECT tc.codicecorso,tc.categoria,co.nome,co.descrizione,co.codiceresponsabile,co.datainizio\r\n"
					+ "						  									 FROM tematica_corso AS tc JOIN (SELECT * FROM ricerca_per_categoria('"+categorieSelezionate+"')) as co ON tc.codicecorso=co.codicecorso\r\n"
					+ "									    				   ) AS ti ON r.codiceresponsabile=ti.codiceresponsabile\r\n"
					+ "WHERE ti.nome LIKE '%"+nome+"%' AND CAST(ti.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' AND ti.descrizione LIKE '%"+parolaChiave+"%'"
					+" GROUP BY ti.codicecorso,ti.nome,ti.datainizio,ti.descrizione,ti.categoria,r.cognome"
					+" HAVING ti.categoria='"+categorieSelezionate+"'"
					+ "ORDER BY ti."+ordinamento);
			
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
	
	
	
	public void eliminaCorso(String codiceCorso) {
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("DELETE FROM CORSO WHERE codicecorso="+codiceCorso);
		
			statement.close();
			istanzaDB.closeConnectionToDB();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public String recuperaNomeCorso(String codiceCorso) {
		
		String nomeCorso = new String();
		
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
	
	
	
	public String calcolaPresenzeMinime(String codiceCorso) {
		
		String numerooPresenzeMinime = new String();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM calcola_presenze_minime_per_lezione("+codiceCorso+")");
			
			while(resultSet.next()) {
				numerooPresenzeMinime=resultSet.getString("numerostudenti");
			}
				
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numerooPresenzeMinime;
		
	}
	
	
	
	public String calcolaPresenzeMassime(String codiceCorso) {
		
		String numeroPresenzeMassime = new String();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM calcola_presenze_massime_per_lezione("+codiceCorso+")");
			
			while(resultSet.next()) {
				numeroPresenzeMassime=resultSet.getString("numerostudenti");
			}
				
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return numeroPresenzeMassime;
		
	}
	
	
	
	public String calcolaFrequenzaMedia(String codiceCorso) {
		
		String frequenzaMedia = new String();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT media "
					+ 									 "FROM media_studenti "
					+ 									 "WHERE codicecorso="+codiceCorso);
			
			while(resultSet.next()) {
				frequenzaMedia=resultSet.getString("media");
			}
				
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return frequenzaMedia;
		
	}
	
	
	
	public String calcolaPercentualeRiempimentoMedia(String codiceCorso) {
		
		String percentualeRiempimentoMedia = new String();
		
		try {
			connessioneDB=istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT (ms.media*100/c.numeromaxpartecipanti)::decimal(10,1) AS percentualeriempimento "
					+ 									 "FROM media_studenti AS ms JOIN corso AS c ON ms.codicecorso=c.codicecorso "
					+                                    "WHERE c.codicecorso="+codiceCorso);
			
			while(resultSet.next()) {
				percentualeRiempimentoMedia=resultSet.getString("percentualeriempimento");
			}
				
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return percentualeRiempimentoMedia;
		
	}
	
	
	
}
