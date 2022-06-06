import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class Controller {
	private LoginFrame loginFrame;
	private HomepageFrame homeFrame;
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
		setHomeFrame(new HomepageFrame(this));
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

	public HomepageFrame getHomeFrame() {
		return homeFrame;
	}

	public void setHomeFrame(HomepageFrame homeFrame) {
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
	
	//METODI CorsoDAO
	public void aggiungiCorso(String nome,String descrizione,String numeroMassimoPartecipanti,String numeroLezioni,String dataDiInizio,String codiceResponsabile) {
		corsoDAO.aggiungiCorso(nome, descrizione, numeroMassimoPartecipanti, numeroLezioni, dataDiInizio, codiceResponsabile);
	}

	public String recuperaCodiceCorso(String nome) {
		return corsoDAO.recuperaCodiceCorso(nome);
	}

//	public Vector<Vector<String>> recuperaCorsi(){
//		return corsoDAO.recuperaCorsi();
//	}
	
	public int contaCorsi() {
		return corsoDAO.contaCorsi();
	}

	public String[] recuperaCorsi(int numeroCorsi) {
		return corsoDAO.recuperaCorsi(numeroCorsi);
	}
	
	public Vector<Vector<String>> recuperaCorsiOrdinatiPer(String ordinamento,String nome,String data,String parolaChiave){
		return corsoDAO.recuperaCorsiOrdinatiPer(ordinamento,nome,data,parolaChiave);
	}
	
	public Vector<Vector<String>> recuperaCorsiPerCategorieOrdinatiPer(String ordinamento,String categorieSelezionate,String nome,String data,String parolaChiave){
		return corsoDAO.recuperaCorsiPerCategorieOrdinatiPer(ordinamento,categorieSelezionate, nome, data, parolaChiave);
	}
	
	public Vector<Vector<String>> recuperaCorsiPerUnaCategoriaOrdinatiPer(String ordinamento,String categorieSelezionate,String nome,String data,String parolaChiave){
		return corsoDAO.recuperaCorsiPerUnaCategoriaOrdinatiPer(ordinamento,categorieSelezionate, nome, data, parolaChiave);
	}

	public void eliminaCorsoSelezionato(String codiceCorso) {
		corsoDAO.eliminaCorso(codiceCorso);
	}

	public void modificaCorso(String codiceCorso,String nome,String descrizione,String data,String codiceResponsabile,String categoria,String oldCategoria) {
		corsoDAO.modificaCorso(codiceCorso,nome,descrizione,data,codiceResponsabile,categoria,oldCategoria);
	}

	public String recuperaNomeCorso(String codiceCorso) {
		return corsoDAO.recuperaNomeCorso(codiceCorso);
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
	public boolean isStudenteInDb(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		return studenteDAO.IsStudenteInDB(nome,cognome,dataDiNascita,luogoDiNascita);
	}
	public void salvaStudente(String nome,String cognome,Date dataDiNascita,String luogo) {
		studenteDAO.salvaStudente(nome,cognome,dataDiNascita,luogo);
	}
	
	public String recuperaCodiceStudente(String nome,String cognome,Date dataDiNascita,String luogoDiNascita) {
		return studenteDAO.recuperaCodiceStudente(nome,cognome,dataDiNascita,luogoDiNascita);
	}
	
	public boolean isStudenteIscrittoAdUnCorso(String codiceStudente,String codiceCorso) {
		return studenteDAO.isStudenteIscrittoAdUnCorso(codiceStudente,codiceCorso);
	}
	
	public void iscriviStudente(String codiceStudente,String codiceCorso) {
		studenteDAO.iscriviStudente(codiceStudente,codiceCorso);
	}

	//METODI AreaTematicaDAO
	public void assegnaAreeTematicheAdUnCorso(String areaTematica,String codiceCorso) {
		areaTematicaDAO.assegnaAreeTematicheAdUnCorso(areaTematica, codiceCorso);
	}
	
	public boolean IsAreaTematicaInDB(String areaTematica) {
		return areaTematicaDAO.IsAreaTematicaInDB(areaTematica);
	}
	
	public void aggiungiAreaTematica(String areaTematica) {
		areaTematicaDAO.aggiungiAreaTematica(areaTematica);
	}
	
	public int contaCategorie() {
		return areaTematicaDAO.contaCategorie();
	}
	
	public String[] recuperaAreeTematicheInArrayDiStringhe(Integer numeroCategorie) {
		return areaTematicaDAO.recuperaAreeTematicheInArrayDiStringhe(numeroCategorie);
	}
	
	public Vector<Vector<String>> recuperaAreeTematicheInVettoreDiVettoreDiStringhe(Integer numeroCategorie) {
		return areaTematicaDAO.recuperaAreeTematicheInVettoreDiVettoreDiStringhe(numeroCategorie);
	}
	

	
	
	public DefaultTableModel setDefaultTableModel(DefaultTableModel defaultTableModel,Vector<Vector<String>> vettoreDiVettoreDiStringhe){
		for (Vector<String> vettoreDiStringhe : vettoreDiVettoreDiStringhe) {
			defaultTableModel.addRow(vettoreDiStringhe);
		}
		
		return defaultTableModel;
	}
	
	
	
	public DefaultComboBoxModel setDefaultComboBoxModel(DefaultComboBoxModel defaultComboBoxModel,String[] arrayDiStringhe) {
		for(String stringa: arrayDiStringhe) {
			defaultComboBoxModel.addElement(stringa);
		}
		
		return defaultComboBoxModel;
	}

}

