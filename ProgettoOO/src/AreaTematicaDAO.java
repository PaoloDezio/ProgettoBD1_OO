import java.sql.*;

public class AreaTematicaDAO {
	private ConnessioneDB istanzaDB ;
	private Connection connessioneDB= null;
	
	
	public AreaTematicaDAO() {
		istanzaDB= ConnessioneDB.getIstanza();
	}
	
	
	public boolean aggiungiAreaTematica(String areatematica) throws SQLException {
			connessioneDB = istanzaDB.ConnectToDB();
			
			Statement st = connessioneDB.createStatement();
			st.executeUpdate("INSERT INTO area_tematica(categoria) VALUES('"+areatematica+"');");	
			
			st.close();
			istanzaDB.closeDbConnection();
			return true;
	}
	
	
}
