import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CorsoDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	public Vector<Vector<String>> recuperaTuttiICorsi(){
		Vector<Vector<String>> corsi = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT C.codiceCorso,C.nome,LDTC.cognome,C.datainizio,LDTC.categoria,C.descrizione"
					+ "					    FROM CORSO AS C JOIN (SELECT TC.codicecorso,LD.cognome,LD.codicedocente,TC.categoria"
					+ "											  FROM TEMATICA_CORSO AS TC JOIN (SELECT l.codicelezione,l.codicedocente,d.cognome,l.codicecorso \r\n"
					+ "													  						  FROM LEZIONE AS L JOIN DOCENTE AS D ON L.CODICEDOCENTE=D.CODICEDOCENTE"
					+ "																			  )AS LD ON TC.CODICECORSO=LD.CODICECORSO\r\n"
					+ "					 			              )AS LDTC ON LDTC.codicecorso=C.codicecorso\r\n"
					+ "					 	ORDER BY C.codicecorso");

			while(rs.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(rs.getString("codiceCorso"));
				vettore.add(rs.getString("nome"));
				vettore.add(rs.getString("cognome"));
				vettore.add(rs.getString("datainizio"));
				vettore.add(rs.getString("categoria"));
				vettore.add(rs.getString("descrizione"));
				corsi.add(vettore);
			}
			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}		
		return corsi;
	}
	
	
	
	
	public Vector<Vector<String>> ricercaCorsoPerNome(String nome){
		Vector<Vector<String>> corsiPerNome = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT C.codiceCorso,C.nome,LDTC.cognome,C.datainizio,LDTC.categoria,C.descrizione "
					+ "					    FROM CORSO AS C JOIN (SELECT TC.codicecorso,LD.cognome,LD.codicedocente,TC.categoria"
					+ "											  FROM TEMATICA_CORSO AS TC JOIN (SELECT l.codicelezione,l.codicedocente,d.cognome,l.codicecorso \r\n"
					+ "													  						  FROM LEZIONE AS L JOIN DOCENTE AS D ON L.CODICEDOCENTE=D.CODICEDOCENTE"
					+ "																			  )AS LD ON TC.CODICECORSO=LD.CODICECORSO\r\n"
					+ "					 			              )AS LDTC ON LDTC.codicecorso=C.codicecorso\r\n"
					+ "						WHERE Nome LIKE '%"+nome+"%'"
					+ "						ORDER BY codiceCorso");

			while(rs.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(rs.getString("codiceCorso"));
				vettore.add(rs.getString("nome"));
				vettore.add(rs.getString("cognome"));
				vettore.add(rs.getString("datainizio"));
				vettore.add(rs.getString("categoria"));
				vettore.add(rs.getString("descrizione"));
				corsiPerNome.add(vettore);
			}

			st.close();
			rs.close();
			istanzaDB.closeDbConnection();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerNome;
	}
	
	
	
	public Vector<Vector<String>> ricercaCorsoPerData (String data){
		Vector<Vector<String>> corsiPerData = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT C.codiceCorso,C.nome,LDTC.cognome,C.datainizio,LDTC.categoria,C.descrizione "
					+ "					    FROM CORSO AS C JOIN (SELECT TC.codicecorso,LD.cognome,LD.codicedocente,TC.categoria"
					+ "											  FROM TEMATICA_CORSO AS TC JOIN (SELECT l.codicelezione,l.codicedocente,d.cognome,l.codicecorso \r\n"
					+ "													  						  FROM LEZIONE AS L JOIN DOCENTE AS D ON L.CODICEDOCENTE=D.CODICEDOCENTE"
					+ "																			  )AS LD ON TC.CODICECORSO=LD.CODICECORSO\r\n"
					+ "					 			              )AS LDTC ON LDTC.codicecorso=C.codicecorso\r\n"
					+ "						WHERE CAST(C.datainizio AS VARCHAR(25)) LIKE '%"+data+"%' "
							+ "				ORDER BY codiceCorso");

			while(rs.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(rs.getString("codiceCorso"));
				vettore.add(rs.getString("nome"));
				vettore.add(rs.getString("cognome"));
				vettore.add(rs.getString("datainizio"));
				vettore.add(rs.getString("categoria"));
				vettore.add(rs.getString("descrizione"));
				corsiPerData.add(vettore);
			}

			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerData;
	}
	public Vector<Vector<String>> ricercaCorsoPerCategoria(String categoria){
		Vector<Vector<String>> corsiPerCategoria = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT C.codiceCorso,C.nome,LDTC.cognome,C.datainizio,LDTC.categoria,C.descrizione "
					+ "					    FROM CORSO AS C JOIN (SELECT TC.codicecorso,LD.cognome,LD.codicedocente,TC.categoria"
					+ "											  FROM TEMATICA_CORSO AS TC JOIN (SELECT l.codicelezione,l.codicedocente,d.cognome,l.codicecorso \r\n"
					+ "													  						  FROM LEZIONE AS L JOIN DOCENTE AS D ON L.CODICEDOCENTE=D.CODICEDOCENTE"
					+ "																			  )AS LD ON TC.CODICECORSO=LD.CODICECORSO\r\n"
					+ "					 			              )AS LDTC ON LDTC.codicecorso=C.codicecorso\r\n"
					+ "						WHERE LDTC.categoria LIKE '%"+categoria+"%'"
					+ "						ORDER BY codiceCorso");


			while(rs.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(rs.getString("codiceCorso"));
				vettore.add(rs.getString("nome"));
				vettore.add(rs.getString("cognome"));
				vettore.add(rs.getString("datainizio"));
				vettore.add(rs.getString("categoria"));
				vettore.add(rs.getString("descrizione"));
				corsiPerCategoria.add(vettore);
			}

			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerCategoria;
	}
	
	public Vector<Vector<String>> ricercaCorsoPerParolaChiave(String parolaChiave){
		Vector<Vector<String>> corsiPerParolaChiave = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT C.codiceCorso,C.nome,LDTC.cognome,C.datainizio,LDTC.categoria,C.descrizione "
					+ "					    FROM CORSO AS C JOIN (SELECT TC.codicecorso,LD.cognome,LD.codicedocente,TC.categoria"
					+ "											  FROM TEMATICA_CORSO AS TC JOIN (SELECT l.codicelezione,l.codicedocente,d.cognome,l.codicecorso \r\n"
					+ "													  						  FROM LEZIONE AS L JOIN DOCENTE AS D ON L.CODICEDOCENTE=D.CODICEDOCENTE"
					+ "																			  )AS LD ON TC.CODICECORSO=LD.CODICECORSO\r\n"
					+ "					 			              )AS LDTC ON LDTC.codicecorso=C.codicecorso\r\n"
					+ "						WHERE C.descrizione LIKE '%"+parolaChiave+"%' "
					+ "						ORDER BY codiceCorso");

			while(rs.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(rs.getString("codiceCorso"));
				vettore.add(rs.getString("nome"));
				vettore.add(rs.getString("cognome"));
				vettore.add(rs.getString("datainizio"));
				vettore.add(rs.getString("categoria"));
				vettore.add(rs.getString("descrizione"));
				corsiPerParolaChiave.add(vettore);
			}

			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return corsiPerParolaChiave;
	}


	public void eliminaCorsoSelezionato(Object codiceCorso) {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("DELETE FROM CORSO WHERE CODICECORSO="+codiceCorso);
		
			st.close();
			istanzaDB.closeDbConnection();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void modificaCorso(Object codiceCorso,String nome,String docente,String data,String descrizione,String categoria) {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("UPDATE CORSO SET nome='"+nome+"',datainizio='"+data+"',descrizione='"+descrizione+"' WHERE CODICECORSO="+codiceCorso);
			st.executeUpdate("UPDATE TEMATICA_CORSO SET categoria='"+categoria+"' WHERE CODICECORSO= "+codiceCorso);
//			st.executeUpdate("UPDATE DOCENTE SET cognome='"+docente+"' WHERE CODICECORSO= "+codiceCorso);
			
			st.close();
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String recuperaNomeCorso(String codiceCorso) {
		String nomeCorso="";
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs=st.executeQuery("SELECT C.nome FROM CORSO AS C WHERE CODICECORSO="+codiceCorso);
			
			while(rs.next()) {
				nomeCorso=rs.getString("nome");
			}
				
			
			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeCorso;
	}
	
	
}
