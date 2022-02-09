import java.sql.*;

public class ConnessioneDB {
	
	//private static ConnessioneDB istanzaDB = null;
	private Connection connessioneDB = null;

//	public static ConnessioneDB getIstanza() {
//		if(istanzaDB == null) {
//			istanzaDB = new ConnessioneDB();
//		}
//
//		return istanzaDB;
//	}

	public Connection connectToDb() throws Exception{
		if(connessioneDB == null) {
			try {
				Class.forName("org.postgres.Driver");
				String url = "jdbc:postgresql://localhost:5432/BasiDiDati";
				connessioneDB = DriverManager.getConnection(url,"admin","admin");
				connessioneDB.close();
			}catch(ClassNotFoundException e) {
				System.out.println("Driver non trovato\n");
				System.out.println("ClassNotFoundException: "+e);
			}
			catch(SQLException e) {
				System.out.println("Connessione fallita");
				System.out.println("SQL Exception: "+e);
			}
		}

		return connessioneDB;
	}

//	public boolean checkConnectionToDb() {	
//		try {
//			return connessioneDB.isValid(10);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

//	public boolean closeDbConnection() {
//		try {
//			connessioneDB.close();
//			connessioneDB = null;
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
}

