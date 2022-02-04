import javax.swing.JFrame;

public class Controller {
	private LoginFrame lf;
	private HomeFrame hf;
	
	
	public static void main(String[] args) {
		Controller c= new Controller();
		
	}

	public Controller() {
		lf=new LoginFrame(this);
		hf =new HomeFrame(this);
		
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
	
	
		
}
