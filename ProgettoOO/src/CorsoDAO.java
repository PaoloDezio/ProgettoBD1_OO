import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class CorsoDAO {
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	public CorsoDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	public Vector ricercaCorsoPerNome(String nome) throws SQLException {
		Vector v= new Vector();
		int colonne=0;
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT nome,codicecorso FROM CORSO WHERE nome ='"+nome+"'");
			ResultSetMetaData rsmd=rs.getMetaData();
			colonne=rsmd.getColumnCount();
			
			while(rs.next()) {
				Vector record = new Vector();
				for(int i=0;i<colonne;i++) {
					record.add(rs.getString(i+1));
				}
				v.add(record);
			}
		
			st.close();
			rs.close();
			
			istanzaDB.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	return v;
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
