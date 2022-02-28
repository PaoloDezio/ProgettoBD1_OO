import java.sql.*;

public class ResponsabileDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
//	public void ResponsabileDAO() {
//		istanzaDB=ConnessioneDB.getIstanza();
//	}
	
	
	public boolean checkResponsabile(String usn,String pwd) throws Exception {
		Boolean b=false;
		try {
			istanzaDB=ConnessioneDB.getIstanza();
			connessioneDB=istanzaDB.ConnectToDB();
			
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery(" SELECT username,pwd FROM responsabile ");
			
			while(rs.next()) {
				if(rs.getString(1).equals(usn) && rs.getString(2).equals(pwd)) {
					b=true;
					System.out.print("b=true");
				}
			}
//			st.close();
//			rs.close();
			
			istanzaDB.closeDbConnection();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	
}
