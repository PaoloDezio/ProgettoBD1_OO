import java.sql.*;
import java.util.Vector;

public class LezioneDAO {

	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;

	public LezioneDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}

	public void aggiungiLezioneInPresenza(String titolo,String descrizione,String durata,String dataEOraInizio,String codiceCorso,String codiceDocente,String sede,String aula) {
		try {
			connessioneDB=istanzaDB.connectToDB();	
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO lezione(titolo,descrizione,durata,dataorainizio,codicecorso,codicedocente,online,sede,aula,piattaforma) "
				+					"VALUES ('"+titolo+"','"+descrizione+"',"+durata+"*'1 minute'::interval,'"+dataEOraInizio+"',"+codiceCorso+","+codiceDocente+",'FALSE','"+sede+"','"+aula+"','prova')");
			statement.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void aggiungiLezioneInPresenzaEDaRemoto(String titolo,String descrizione,String durata,String dataEOraInizio,String codiceCorso,String codiceDocente,String sede,String aula,String piattaforma) {
		try {
			connessioneDB=istanzaDB.connectToDB();	
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO lezione(titolo,descrizione,durata,dataorainizio,codicecorso,codicedocente,online,sede,aula,piattaforma) "
				+					"VALUES ('"+titolo+"','"+descrizione+"',"+durata+"*'1 minute'::interval,'"+dataEOraInizio+"',"+codiceCorso+","+codiceDocente+",'TRUE','"+sede+"','"+aula+"','"+piattaforma+"')");
			statement.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Vector<Vector<String>> recuperaLezioni(String codiceCorso) {
		Vector<Vector<String>> lezioni = new Vector<Vector<String>>();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT codicelezione,titolo,descrizione,to_char (dataorainizio,'YYYY-MM-DD HH24:MI') as dataorainizio,sede,aula,piattaforma "
					+ 									 "FROM lezione  "
					+ 									 "WHERE codiceCorso = "+codiceCorso);

			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("codicelezione"));
				vettore.add(resultSet.getString("titolo"));
				vettore.add(resultSet.getString("descrizione"));
				vettore.add(resultSet.getString("dataorainizio"));
				vettore.add(resultSet.getString("sede"));
				vettore.add(resultSet.getString("aula"));
				vettore.add(resultSet.getString("piattaforma"));
				lezioni.add(vettore);

			}
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lezioni;
	}

	public void eliminaLezione(String codiceLezione) {
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("DELETE FROM lezione WHERE codicelezione="+codiceLezione);
			statement.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}}


		
	public void modificaLezione(String codiceLezione,String titolo,String descrizione,String durata,String dataOraInizio,String codiceDocente,String online,String sede,String aula,String piattaforma )	{
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("UPDATE lezione "
					+			   	"SET titolo='"+titolo+"',descrizione='"+descrizione+"',durata="+durata+"*'1 minute'::interval,dataorainizio='"+dataOraInizio+"',codicedocente="+codiceDocente+",online='FALSE',sede='"+sede+"',aula='"+aula+"',piattaforma='"+piattaforma+"', "
					+ 				"WHERE codicelezione="+codiceLezione);
			statement.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public String recuperaDurata(String codiceLezione) {
		String durata = new String();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT durata FROM lezione WHERE codiceLezione="+codiceLezione);
			
			resultSet.next();
			durata=resultSet.getString("durata");
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return durata;
	}

	public void inserisciPresenza(String codiceLezione, String codiceStudente){
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO partecipare(codicelezione,codicestudente) VALUES("+codiceLezione+","+codiceStudente+")");
			statement.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}

	
	public void eliminaPresenza(String codiceLezione, String codiceStudente){
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("DELETE FROM partecipare WHERE codicelezione="+codiceLezione+" AND codicestudente="+codiceStudente);
			statement.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}





	
	
	

}
