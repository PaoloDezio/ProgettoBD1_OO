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
	
	
	public Connection ConnectToDB() {	
		if(connessioneDB==null) {
			
				try {
					Class.forName("org.postgresql.Driver");
					String url = "jdbc:postgresql://localhost:5432/BasiDiDati";
					connessioneDB = DriverManager.getConnection(url,"postgres","admin");
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
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
	
	
	
	public boolean closeDbConnection() {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//			try {
//				Class.forName("org.postgresql.Driver");
//				
//				String url = "jdbc:postgresql://localhost:5432/BasiDiDati";
//				Connection con = DriverManager.getConnection(url,"postgres","admin");
//				
//				System.out.println("Connessione OK\n");
//			}
//			catch(ClassNotFoundException e) {
//				System.out.println("Driver non trovato\n");
//				System.out.println("ClassNotFoundException: "+e);
//			}
//			catch(SQLException e) {
//				System.out.println("Connessione fallita");
//				System.out.println("SQL Exception: "+e);
//			}
	

//SCHEMA CREAZIONE QUERY
//Statement st = con.createStatement();
//String query="CALL ELIMINA_CORSO(2)";
//		
//ResultSet rs =st.executeQuery(query);
//
//while(rs.next()) {
//
//}
//rs.close();
//st.close();


