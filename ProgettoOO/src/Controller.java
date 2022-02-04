import javax.swing.JFrame;

public class Controller {
	private LoginFrame lf;
	private HomeFrame hf;
	private RicercaCorsoFrame rcf;
	private IscrizioneFrame isf;
	
	
	public static void main(String[] args) {
		Controller c= new Controller();
		
	}

	public Controller() {
		lf=new LoginFrame(this);
		hf =new HomeFrame(this);
		rcf = new RicercaCorsoFrame(this);
		isf = new IscrizioneFrame(this);
		
		lf.setVisible(true);
	}
	
	
	public void checkResponsabile(String usn,String pwd) {
		   	//codice jdbc
			lf.setVisible(false);
			hf.setVisible(true);

		}
	
	public void tornaAlLoginFrame() {
		lf.setVisible(true);
		hf.setVisible(false);
	}
	
	public void apriHome() {
		hf.setVisible(true);
	}
	
	public void apriRicercaCorso() {
		hf.setVisible(false);
		rcf.setVisible(true);
	}
	
	public void chiudiRicercaCorso() {
		rcf.setVisible(false);
	}
	
	
	public void apriIscrizione() {
		hf.setVisible(false);
		isf.setVisible(true);
	}
	
	public void chiudiIscrizione() {
		isf.setVisible(false);
	}
		
}
