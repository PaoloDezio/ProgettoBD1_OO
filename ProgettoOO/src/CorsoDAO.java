import java.sql.SQLException;
import java.util.ArrayList;

public class CorsoDAO {

	
	public void salvaCorso(Corso c) throws Exception {
		
		
		try {
			//creo uno statement
			
			String st="INSERT INTO Corso VALUES("+c.getCodiceCorso()+","+c.getNome()+","+c.getDescrizione()+","+c.getCapienza()+","+c.getNumeroLezioni()+","+c.getPresenzeMinime()+","+c.getDataInizioCorso()+");";
		
		
			//Statement.execute(st);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	
	
	public ArrayList<Corso> getAllCorso(){
		
		ArrayList<Corso> result = new ArrayList<Corso>();
		//Select * from corso
		
		//statement.execute query;
		
		
		/*while(rs.next()){
		  	Corso c= new Corso();
		  	c.setNome(rs.getString(1));
		  	c.setDescrizione(rs.getString(2));		  
		  	..
		  	..
		  	..
		  	..
		  	
		  	
		  	result.add(c);
		  }		
		 */
		  return result;
	}
	
	
	
	
}
