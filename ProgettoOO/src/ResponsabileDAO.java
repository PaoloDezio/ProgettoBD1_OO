import java.sql.*;

public class ResponsabileDAO {
	
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public ResponsabileDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	
	public boolean checkResponsabile(String usn,String pwd) throws SQLException {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery(" SELECT * FROM responsabile ");
		
			while(rs.next()) {
				if(rs.getString("username").equals(usn) && rs.getString("pwd").equals(pwd)) {
					
					return true;
				}
			}
			st.close();
			rs.close();
			
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	

	
}
