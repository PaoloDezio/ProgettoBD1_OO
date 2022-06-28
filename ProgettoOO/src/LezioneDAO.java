import java.sql.*;
import java.util.Vector;

public class LezioneDAO {

	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;

	public LezioneDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}

	public void aggiungiLezione(String titolo,String descrizione,String durata,String dataEOraInizio,String codiceCorso,String codiceDocente,String sede,String aula) {
		try {
			connessioneDB=istanzaDB.connectToDB();	
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO lezione(titolo,descrizione,durata,dataorainizio,codicecorso,codicedocente,online,aula,sede) "
				+					"VALUES ('"+titolo+"','"+descrizione+"','"+durata+"','"+dataEOraInizio+"',"+codiceCorso+","+codiceDocente+",'"+sede+"','"+aula+"')");
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
			ResultSet resultSet = statement.executeQuery("SELECT codicelezione,titolo,descrizione,to_char (dataorainizio,'YYYY-MM-DD HH24:MI') as dataorainizio,sede,aula "
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


	public void inserisciLezione(String codiceCorso,String titolo,String descrizione,String durata,String dataOraInizio,String online,String aula,String sede,String piattaforma ) {	
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO lezione (Titolo,descrizione,durata,dataorainizio,codicecorso,online,aula,sede,piattaforma)"
					+ "				VALUES('"+titolo+"','"+descrizione+"','"+durata+"','"+dataOraInizio+"','"+codiceCorso+"','"+online+"','"+aula+"','"+sede+"','"+piattaforma);
			statement.close();
			istanzaDB.closeConnectionToDB();

		}catch (SQLException e) {
			e.printStackTrace();
		}


}





















}
