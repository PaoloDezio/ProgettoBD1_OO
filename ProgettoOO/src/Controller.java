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
	private ModificaCorsoFrame modificaCorsoFrame;
	private AggiungiCorsoFrame aggiungiCorsoFrame;
	private ResponsabileDAO responsabileDAO;
	private CorsoDAO corsoDAO;
	private AreaTematicaDAO areaTematicaDAO;
	private StudenteDAO studenteDAO;

	
	public void setCorsoDAO(CorsoDAO corsoDAO) {
		this.corsoDAO = corsoDAO;
	}
	
	public CorsoDAO getCorsoDAO() {
		return corsoDAO;
	}


	public static void main(String[] args) {
		Controller controller= new Controller();
	}

	public Controller(){
		responsabileDAO = new ResponsabileDAO();
		studenteDAO= new StudenteDAO();
		corsoDAO = new CorsoDAO();
		areaTematicaDAO = new AreaTematicaDAO();

		setLoginFrame(new LoginFrame(this));
		getLoginFrame().setVisible(true);
		setHomeFrame(new HomeFrame(this));
		setRicercaCorsoFrame(new RicercaCorsoFrame(this));
		setIscriviStudenteFrame(new IscriviStudenteFrame(this));
		setStatisticheFrame(new StatisticheFrame(this));
		setIdoneiFrame(new IdoneiFrame(this));
		setAggiungiAreaTematicaFrame(new AggiungiAreaTematicaFrame(this)); 
		setModificaFrame(new ModificaCorsoFrame(this));
		setAggiungiCorsoFrame(new AggiungiCorsoFrame(this));
		
	}
	
	//Getters e Setters dei Frame
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
			
	public ModificaCorsoFrame getModificaFrame() {
		return modificaCorsoFrame;
	}

	public void setModificaFrame(ModificaCorsoFrame modificaFrame) {
		this.modificaCorsoFrame = modificaFrame;
	}
	
	public ModificaCorsoFrame getModificaCorsoFrame() {
		return modificaCorsoFrame;
	}

	public void setModificaCorsoFrame(ModificaCorsoFrame modificaCorsoFrame) {
		this.modificaCorsoFrame = modificaCorsoFrame;
	}

	public AggiungiCorsoFrame getAggiungiCorsoFrame() {
		return aggiungiCorsoFrame;
	}

	public void setAggiungiCorsoFrame(AggiungiCorsoFrame aggiungiCorsoFrame) {
		this.aggiungiCorsoFrame = aggiungiCorsoFrame;
	}

	//METODI ResponsabileDAO
	public boolean checkResponsabile(String username,String password) {
		return responsabileDAO.checkResponsabile(username, password);
	}
	
	public Integer contaResponsabili() {
		return responsabileDAO.contaResponsabili();
	}
	
	public String[] salvaResponsabili(int numeroResponsabili) {
		return responsabileDAO.salvaResponsabili(numeroResponsabili);
	}
	
	public String recuperaCodiceResponsabile(String cognomeResponsabile) {
		return responsabileDAO.recuperaCodiceResponsabile(cognomeResponsabile);
	}
	
	//METODI StudenteDAO
	public void salvaStudente(String nome,String cognome,String luogo,Date data) {
		studenteDAO.salvaStudente(nome, cognome, luogo, data);
	}
	
	public String recuperaCodiceStudente(String nome,String cognome,String luogo,Date dataDiNascita) {
		return studenteDAO.recuperaCodiceStudente(nome, cognome, luogo, dataDiNascita);
	}
	
	public boolean iscriviStudente(String codiceCorso,String codStudente) {
		return studenteDAO.iscriviStudente(codiceCorso,codStudente);
	}

	//METODI AreaTematicaDAO
	public boolean IsAreaTematicaInDB(String areaTematica) {
		return areaTematicaDAO.IsAreaTematicaInDB(areaTematica);
	}
	
	public void aggiungiAreaTematica(String areaTematica) {
		areaTematicaDAO.aggiungiAreaTematica(areaTematica);
	}
	
	public int contaCategorie() {
		return areaTematicaDAO.contaCategorie();
	}
	
	public String[] recuperaAreeTematiche(Integer numeroCategorie) {
		return areaTematicaDAO.recuperaAreeTematiche(numeroCategorie);
	}
	
	
	
	//METODI CorsoDAO
	public Vector<Vector<String>> recuperaCorsi(){
		return corsoDAO.recuperaCorsi();
	}
	
	public int contaCorsi() {
		return corsoDAO.contaCorsi();
	}
	
	public String[] recuperaCorsi(int numeroCorsi) {
		return corsoDAO.recuperaCorsi(numeroCorsi);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerNome(String nome){
		return corsoDAO.ricercaCorsoPerNome(nome);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerData (String data){
		return corsoDAO.ricercaCorsoPerData(data);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerParolaChiave (String parolaChiave){
		return corsoDAO.ricercaCorsoPerParolaChiave(parolaChiave);
	}
	
	public Vector<Vector<String>> ricercaCorsoPerCategoria (String categoria){
		return corsoDAO.ricercaCorsoPerCategoria(categoria);
	}
	
	public void eliminaCorsoSelezionato(Object codiceCorso) {
		corsoDAO.eliminaCorso(codiceCorso);
	}
	
	public void modificaCorso(Object codiceCorso,String nome,String docente,String data,String categoria,String descrizione) {
		corsoDAO.modificaCorso(codiceCorso, nome, docente, data, descrizione, categoria);
	}
	
	public String recuperaNomeCorso(String codiceCorso) {
		return corsoDAO.recuperaNomeCorso(codiceCorso);
	}

	


}

