import java.sql.*;


public class ConnessioneDB {
	private static ConnessioneDB istanzaDB = null;
	private Connection connessioneDB = null;
	
	public static ConnessioneDB getIstanza() {
		if(istanzaDB == null) {
			istanzaDB = new ConnessioneDB();
		}
		return istanzaDB;
	}
	
	
	public Connection connectToDB() {	
		if(connessioneDB==null) {
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/BasiDiDati";
				connessioneDB = DriverManager.getConnection(url,"postgres","admin");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			catch(SQLException e) {
				System.out.println("SQL Exception: " + e);
				e.printStackTrace();
			}
		}
		return connessioneDB;
	}
	

	public boolean checkConnectionToDb() {	
		try {
			return connessioneDB.isValid(10);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean closeConnectionToDB() {
		try {
			connessioneDB.close();
			connessioneDB = null;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}




}