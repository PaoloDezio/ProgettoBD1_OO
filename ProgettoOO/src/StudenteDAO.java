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
	
	public void salvaStudente(String nome,String cognome,String luogoN,SimpleDateFormat data)  {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO studente(nome,cognome,luogonascita,datanascita) VALUES('"+nome+"','"+cognome+"','"+luogoN+"','"+data+"')");
			
			st.close();
			istanzaDB.closeDbConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String recuperaCodStudente(String nome,String cognome,String luogoN,SimpleDateFormat data) {
		String codiceStudente="";
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st= connessioneDB.createStatement();
			ResultSet rs= st.executeQuery("SELECT codicestudente "
										+ "FROM studente "
										+ "WHERE nome='"+nome+"' AND cognome='"+cognome+
										"' AND luogoNascita= '"+luogoN+"' AND dataNascita= '"+data+"'");
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
	
	
	public boolean iscriviStudente(String codCorso,String codStudente) {
		try {
			connessioneDB=istanzaDB.ConnectToDB();

			Statement st= connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO iscrizione Values("+codCorso+","+codStudente+");");	
			
			st.close();
			istanzaDB.closeDbConnection();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
