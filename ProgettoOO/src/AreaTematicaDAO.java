import java.sql.*;
import java.util.Vector;

public class AreaTematicaDAO {
	private ConnessioneDB istanzaDB ;
	private Connection connessioneDB= null;
	
	
	public AreaTematicaDAO() {
		istanzaDB= ConnessioneDB.getIstanza();
	}
	
	public int contaCategorie() {
		Integer numeroCategorie=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM AREA_TEMATICA");	
			resultSet.next();
			numeroCategorie=resultSet.getInt(1);
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroCategorie;
	}
	
	public String[] recuperaAreeTematicheInArrayDiStringhe(Integer numeroCategorie) {
		String[] areeTematiche = new String[numeroCategorie]; 
		int i=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM area_tematica ORDER BY categoria");	
		
			while(resultSet.next()) {
				areeTematiche[i]=resultSet.getString("categoria");
				i++;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return areeTematiche;
	}
	
	public Vector<Vector<String>> recuperaAreeTematicheInVettoreDiVettoreDiStringhe(Integer numeroCategorie) {
		Vector<Vector<String>> areeTematiche = new Vector<Vector<String>>();
		
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM area_tematica ORDER BY categoria");	
		
			while(resultSet.next()) {
				Vector<String> vettore = new Vector<String>();
				vettore.add(resultSet.getString("categoria"));
				areeTematiche.add(vettore);
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return areeTematiche;
	}
	
	public boolean IsAreaTematicaInDB(String areaTematica) {
		try{
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM area_tematica");	
			
			while(resultSet.next()) {
				if(resultSet.getString("categoria").equals(areaTematica))
					return true;
			}
			
			statement.close();
			resultSet.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void aggiungiAreaTematica(String areaTematica) {
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("INSERT INTO area_tematica(categoria) VALUES('"+areaTematica+"');");	
				
			statement.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void assegnaAreeTematicheAdUnCorso(String areeTematiche,String codiceCorso) {
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement statement = connessioneDB.createStatement();
			statement.executeUpdate("CALL associa_categorie("+codiceCorso+",'"+areeTematiche+"')");	
				
			statement.close();
			istanzaDB.closeConnectionToDB();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	

	
}
