import java.sql.*;

public class AreaTematicaDAO {
	private ConnessioneDB istanzaDB ;
	private Connection connessioneDB= null;
	
	
	public AreaTematicaDAO() {
		istanzaDB= ConnessioneDB.getIstanza();
	}
	
	public int contaCategorie() {
		Integer numeroCategorie=0;
		try {
			connessioneDB = istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM AREA_TEMATICA");	
			rs.next();
			numeroCategorie=rs.getInt(1);
			
			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroCategorie;
	}
	
	public String[] recuperaAreeTematiche(Integer numeroCategorie) {
		String[] areeTematiche = new String[numeroCategorie]; 
		int i=0;
		try {
			connessioneDB = istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM area_tematica ORDER BY categoria");	
		
			while(rs.next()) {
				areeTematiche[i]=rs.getString("categoria");
				i++;
			}
			
			st.close();
			rs.close();
			istanzaDB.closeDbConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return areeTematiche;
	}
	
	public boolean IsAreaTematicaInDB(String areaTematica) {
		try{
			connessioneDB = istanzaDB.ConnectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM area_tematica");	
			
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
