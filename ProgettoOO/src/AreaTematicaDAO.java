import java.sql.*;

public class AreaTematicaDAO {
	private ConnessioneDB istanzaDB ;
	private Connection connessioneDB= null;
	
	
	public AreaTematicaDAO() {
		istanzaDB= ConnessioneDB.getIstanza();
	}
	
	public boolean AreaTematicaIsPresentInDB(String areaTematica) {
		try{
			connessioneDB = istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM area_tematica WHERE categoria='"+areaTematica+"'");	
			
			while(rs.next()) {
				if(rs.getString("categoria").equals(areaTematica))
					return true;
			}
			
			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void aggiungiAreaTematica(String areaTematica) {
		try {
			connessioneDB = istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO area_tematica(categoria) VALUES('"+areaTematica+"');");	
				
			st.close();
			istanzaDB.closeDbConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
}
