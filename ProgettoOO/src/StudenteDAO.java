import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudenteDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	
	public StudenteDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public void salvaStudente(String nome,String cognome,String luogoN,String dataN) throws SQLException {
		connessioneDB=istanzaDB.ConnectToDB();
		
		Statement st = connessioneDB.createStatement();
		st.executeUpdate("INSERT INTO studente(nome,cognome,luogonascita,datanascita) VALUES('"+nome+"','"+cognome+"','"+luogoN+"','"+dataN+"')");
		
		st.close();
		istanzaDB.closeDbConnection();
		
	}
	
	public void recuperaCodStudente(String nome,String cognome,String luogoN,String dataN) throws SQLException {
		connessioneDB=istanzaDB.ConnectToDB();

		Statement st= connessioneDB.createStatement();
		ResultSet rs= st.executeQuery("SELECT codicestudente "
									+ "FROM studente "
									+ "WHERE nome="+nome+" AND cognome="+cognome+
									" AND luogoNascita="+luogoN+" AND dataNascita="+dataN);
		System.out.println("Codice studente ="+rs.getString("codicestudente"));
		st.close();
		rs.close();
		istanzaDB.closeDbConnection();
	}
	
	
	public void iscriviStudente(String codCorso) throws SQLException{
		connessioneDB=istanzaDB.ConnectToDB();

		Statement st= connessioneDB.createStatement();
		st.executeUpdate("INSERT INTO iscrizione ;");	
		
	
		st.close();
		istanzaDB.closeDbConnection();
	}


}
