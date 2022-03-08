import java.sql.*;
import java.util.ArrayList;

public class CorsoDAO {
	
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	
	
	public void ricercaCorso(String nome, String areaTematica, String parolaChiave, String data) {
		
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CORSO WHERE nome ='"+nome+"'");
		
			while(rs.next()) {
				
			}
			
			st.close();
			rs.close();
			
			istanzaDB.closeDbConnection();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	
}
	
	
}
