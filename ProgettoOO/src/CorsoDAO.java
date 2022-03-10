import java.sql.*;
import java.util.ArrayList;

public class CorsoDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public void ricercaCorsoPerNome(String nome) throws SQLException {
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
	
	
	
	public void ricercaCorsoPerData(String data) throws SQLException {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CORSO WHERE data ='"+data+"'");
		
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
	
	public void ricercaCorsoPerParolaChiave(String parolaChiave) throws SQLException {
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM CORSO WHERE descrizione LIKE '%"+parolaChiave+"%'");
		
			while(rs.next()) {
				System.out.print(rs.getString("codicecorso")+" ");
				System.out.print(rs.getString("nome")+" ");
				System.out.print(rs.getString("descrizione")+" ");
				System.out.println(rs.getString("datainiziocorso"));
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
