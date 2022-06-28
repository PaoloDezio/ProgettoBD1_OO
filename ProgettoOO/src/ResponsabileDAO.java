import java.sql.*;


public class ResponsabileDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public ResponsabileDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	public boolean checkResponsabile(String username,String password)  {
		try {
			connessioneDB=istanzaDB.connectToDB();
			
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM responsabile");
			
			while(resultSet.next()) {
				if(resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password))
					return true;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Integer contaResponsabili() {
		Integer numeroResponsabili=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT COUNT(*) FROM RESPONSABILE");	
			resultSet.next();
			numeroResponsabili=resultSet.getInt(1);
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroResponsabili;
	}
	
	
	
	public String[] salvaResponsabili(int numeroResponsabili) {
		String[] responsabili= new String[numeroResponsabili];
		int i=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM RESPONSABILE ORDER BY cognome");	
		
			while(resultSet.next()) {
				responsabili[i]=resultSet.getString("cognome");
				i++;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return responsabili;
	}
	
	
	public String recuperaCodiceResponsabile(String cognomeResponsabile) {
		String codiceResponsabile="";
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM RESPONSABILE WHERE cognome='"+cognomeResponsabile+"'");	
		
			while(resultSet.next()) {
				codiceResponsabile=resultSet.getString("codiceresponsabile");
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return codiceResponsabile;
	}
}
