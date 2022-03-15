import java.sql.*;
import java.util.ArrayList;

public class ResponsabileDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public ResponsabileDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	public boolean checkResponsabile(String username,String password)  {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM responsabile WHERE username='"+username+"' AND pwd='"+password+"';");
			
			while(rs.next()) {
				if(rs.getString("username").equals(username) && rs.getString("pwd").equals(password))
					return true;
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
