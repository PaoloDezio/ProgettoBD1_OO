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
			connessioneDB=istanzaDB.connectToDB();
			
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM responsabile");
			
			while(rs.next()) {
				if(rs.getString("username").equals(username) && rs.getString("password").equals(password))
					return true;
			}
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Integer contaResponsabili() {
		Integer numeroResponsabili=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM RESPONSABILE");	
			rs.next();
			numeroResponsabili=rs.getInt(1);
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return numeroResponsabili;
	}
	
	
	
	public String[] salvaResponsabili(int numeroResponsabili) {
		String[] responsabili= new String[numeroResponsabili];
		int i=0;
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM RESPONSABILE ORDER BY cognome");	
		
			while(rs.next()) {
				responsabili[i]=rs.getString("cognome");
				i++;
			}
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return responsabili;
	}
	
	
	public String recuperaCodiceResponsabile(String cognomeResponsabile) {
		String codiceResponsabile="";
		try {
			connessioneDB = istanzaDB.connectToDB();
			Statement st = connessioneDB.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM RESPONSABILE WHERE cognome='"+cognomeResponsabile+"'");	
		
			while(rs.next()) {
				codiceResponsabile=rs.getString("codiceresponsabile");
			}
			
			st.close();
			rs.close();
			istanzaDB.closeConnectionToDB();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return codiceResponsabile;
	}
}
