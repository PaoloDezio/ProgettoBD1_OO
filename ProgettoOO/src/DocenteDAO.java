import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DocenteDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public DocenteDAO() {
		istanzaDB = ConnessioneDB.getIstanza();
	}
	
	
	public int contaDocenti() {
		int numeroDocenti=0;
		
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM docente");
			
			
			resultSet.next();
			numeroDocenti = resultSet.getInt(1);
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroDocenti;
	}
	
	
	
	public String[] recuperaDocenti(int numeroDocenti) {
		String[] docenti = new String[numeroDocenti];
		int indice=0;
		
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM docente ORDER BY codiceDocente");	
		
			while(resultSet.next()) {
				docenti[indice]=resultSet.getString("cognome");
				indice++;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return docenti;
	}
	
	
	public String recuperaCodiceDocente(String cognome) {
		String codiceDocente="";
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement= connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT codicedocente FROM docente WHERE cognome ='"+cognome+"'");
			
			while(resultSet.next()) {
				codiceDocente=resultSet.getString("codicedocente");
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return codiceDocente;
	}
	
	public String recuperaDocente(String codiceDocente) {
		String docente=new String();
		try {
			connessioneDB=istanzaDB.connectToDB();

			Statement statement= connessioneDB.createStatement();
			ResultSet resultSet= statement.executeQuery("SELECT cognome FROM docente WHERE codicedocente ="+codiceDocente);
			
			while(resultSet.next()) {
				docente=resultSet.getString("cognome");
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return docente;
	}
}
