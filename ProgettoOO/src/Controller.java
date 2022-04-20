import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JFrame;

public class Controller {
	private LoginFrame loginFrame;
	private HomeFrame homeFrame;
	private RicercaCorsoFrame ricercaCorsoFrame;
	private IscriviStudenteFrame iscriviStudenteFrame;
	private StatisticheFrame statisticheFrame;
	private IdoneiFrame idoneiFrame;
	private AggiungiAreaTematicaFrame aggiungiAreaTematicaFrame;
	private ModificaFrame modificaFrame;
	private ResponsabileDAO responsabileDAO;
	private StudenteDAO studenteDAO;

	
	
	public static void main(String[] args) throws SQLException {
		Controller controller= new Controller();
		
		controller.getLoginFrame().setVisible(true);

	}

	public Controller(){
		this.setLoginFrame(new LoginFrame(this));
		this.setHomeFrame(new HomeFrame(this));
		this.setRicercaCorsoFrame(new RicercaCorsoFrame(this));
		this.setIscriviStudenteFrame(new IscriviStudenteFrame(this));
		this.setStatisticheFrame(new StatisticheFrame(this));
		this.setIdoneiFrame(new IdoneiFrame(this));
		this.setAggiungiAreaTematicaFrame(new AggiungiAreaTematicaFrame(this)); 
		this.setModificaFrame(new ModificaFrame(this));
		responsabileDAO = new ResponsabileDAO();
		studenteDAO= new StudenteDAO();
		
	}
	
	
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}

	public HomeFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomeFrame homeFrame) {
		this.homeFrame = homeFrame;
	}

	public RicercaCorsoFrame getRicercaCorsoFrame() {
		return ricercaCorsoFrame;
	}

	public void setRicercaCorsoFrame(RicercaCorsoFrame ricercaCorsoFrame) {
		this.ricercaCorsoFrame = ricercaCorsoFrame;
	}

	public IscriviStudenteFrame getIscriviStudenteFrame() {
		return iscriviStudenteFrame;
	}

	public void setIscriviStudenteFrame(IscriviStudenteFrame iscriviStudenteFrame) {
		this.iscriviStudenteFrame = iscriviStudenteFrame;
	}

	public StatisticheFrame getStatisticheFrame() {
		return statisticheFrame;
	}

	public void setStatisticheFrame(StatisticheFrame statisticheFrame) {
		this.statisticheFrame = statisticheFrame;
	}

	public IdoneiFrame getIdoneiFrame() {
		return idoneiFrame;
	}

	public void setIdoneiFrame(IdoneiFrame idoneiFrame) {
		this.idoneiFrame = idoneiFrame;
	}

	public AggiungiAreaTematicaFrame getAggiungiAreaTematicaFrame() {
		return aggiungiAreaTematicaFrame;
	}

	public void setAggiungiAreaTematicaFrame(AggiungiAreaTematicaFrame aggiungiAreaTematicaFrame) {
		this.aggiungiAreaTematicaFrame = aggiungiAreaTematicaFrame;
	}
			
	public ModificaFrame getModificaFrame() {
		return modificaFrame;
	}

	public void setModificaFrame(ModificaFrame modificaFrame) {
		this.modificaFrame = modificaFrame;
	}

	public boolean checkResponsabile(String username,String password) {
		return responsabileDAO.checkResponsabile(username, password);
	}
	
	public void salvaStudente(String nome,String cognome,String luogo,Date data) {
		studenteDAO.salvaStudente(nome, cognome, luogo, data);
	}
	
	public String recuperaCodStudente(String nome,String cognome,String luogo,Date dataDiNascita) {
		return studenteDAO.recuperaCodStudente(nome, cognome, luogo, dataDiNascita);
	}
	
	public boolean iscriviStudente(String codCorso,String codStudente) {
		return studenteDAO.iscriviStudente(codCorso,codStudente);
	}

	public Vector<Vector<String>> mostraCorsi(){
		CorsoDAO corsoDAO = new CorsoDAO();
		return corsoDAO.mostraCorsi();
	}
	
	public Vector<Vector<String>> ricercaCorsoPerNome(String nome){
		CorsoDAO corsoDAO = new CorsoDAO();
		return corsoDAO.ricercaCorsoPerNome(nome);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerData (String data){
		CorsoDAO corsoDAO = new CorsoDAO();
		return corsoDAO.ricercaCorsoPerData(data);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerParolaChiave (String parolaChiave){
		CorsoDAO corsoDAO = new CorsoDAO();
		return corsoDAO.ricercaCorsoPerParolaChiave(parolaChiave);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerCategoria (String categoria){
		CorsoDAO corsoDAO = new CorsoDAO();
		return corsoDAO.ricercaCorsoPerCategoria(categoria);
	}
	
	public void eliminaCorsoSelezionato(Object codiceCorso) {
		CorsoDAO corsoDAO= new CorsoDAO();
		corsoDAO.eliminaCorsoSelezionato(codiceCorso);
	}
	
	public void modificaCorso(Object codiceCorso,String nome,String data,String categoria,String descrizione) {
	CorsoDAO corsoDAO = new CorsoDAO();
	corsoDAO.modificaCorso(codiceCorso, nome, data, descrizione, categoria);
	}
	
}
