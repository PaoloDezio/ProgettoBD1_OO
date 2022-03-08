import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StatisticheDAO {
	
	private ConnessioneDB istanzaDB;
	private Connection connessioneDB = null;
	
	
	
	public StatisticheDAO() {
		istanzaDB=ConnessioneDB.getIstanza();
	}
	
	
	
	
	public void OttieniStatistiche() throws SQLException {
		
		try {
			connessioneDB=istanzaDB.ConnectToDB();
			Statement st;
			st = connessioneDB.createStatement();
			st.executeQuery("SELECT * FROM STATISTICHE");
			//INSERIRE CODICE CHE MOSTRA A SCHERMO I DATI
			
			st.close();
			istanzaDB.closeDbConnection();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}

}
