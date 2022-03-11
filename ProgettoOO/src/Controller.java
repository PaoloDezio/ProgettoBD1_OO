import java.sql.SQLException;

import javax.swing.JFrame;

public class Controller {
	private LoginFrame lf;
	private HomeFrame hf;
	private RicercaCorsoFrame rcf;
	private IscrizioneFrame isf;
	private StatisticheFrame sf;
	private IdoneiFrame idof;
	private AggiungiAreaTematicaFrame atf;
	
	public static void main(String[] args) throws SQLException {
		Controller c= new Controller();
		
	}

	public Controller() throws SQLException {
		lf=new LoginFrame(this);
		hf =new HomeFrame(this);
		rcf = new RicercaCorsoFrame(this);
		isf = new IscrizioneFrame(this);
		sf = new StatisticheFrame(this);
		idof = new IdoneiFrame(this);
		atf = new AggiungiAreaTematicaFrame(this);
		
		lf.setVisible(true);
	}
	
	
	
	
	public void tornaAlLoginFrame() {
		lf.setVisible(true);
		hf.setVisible(false);
	}
	
	public void setVisibleHome(boolean b) {
		hf.setVisible(b);
	}
	
	public void setVisibleLogin(boolean b) {
		lf.setVisible(b);
	}
	

	public void setVisibleRicercaCorso(Boolean b) {
		rcf.setVisible(b);
	}
	
	public void setVisibleIscrizione(Boolean b) {
		isf.setVisible(b);
	}
	
	public void setVisibleStatistiche(boolean b) {
		sf.setVisible(b);
	}
	
	public void setVisibleIdonei(boolean b) {
		idof.setVisible(b);
	}
	
	public void setVisibleAggiungiAreaTematica(boolean b) {
		atf.setVisible(b);
	}
		
}
