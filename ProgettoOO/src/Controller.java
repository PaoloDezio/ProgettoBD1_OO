import javax.swing.JFrame;

public class Controller {
	
	private LoginFrame lf;
	private HomeFrame hf;
	private RicercaCorsoFrame rcf;
	private IscrizioneFrame isf;
	private StatisticheFrame sf;
	private IdoneiFrame idof;
	
	public static void main(String[] args) {
		Controller c= new Controller();
		
	}

	public Controller() {
		lf=new LoginFrame(this);
		hf =new HomeFrame(this);
		rcf = new RicercaCorsoFrame(this);
		isf = new IscrizioneFrame(this);
		sf = new StatisticheFrame(this);
		idof = new IdoneiFrame(this);
		
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
	

	public void setVisibleRicercaCorso(boolean b) {
		rcf.setVisible(b);
	}
	
	public void setVisibleIscrizione(boolean b) {
		isf.setVisible(b);
	}
	
	public void setVisibleStatistiche(boolean b) {
		sf.setVisible(b);
	}
	public void setVisibleIdonei(boolean b) {
		idof.setVisible(b);
	}
	
}
