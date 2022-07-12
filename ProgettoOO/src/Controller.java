import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
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
	private LezioniFrame lezioniFrame;
	private ModificaLezioneFrame modificaLezioneFrame;
	private AggiungiLezioneFrame aggiungiLezioneFrame;
	private PresenzeFrame presenzeFrame;

	private ResponsabileDAO responsabileDAO;
	private CorsoDAO corsoDAO;
	private AreaTematicaDAO areaTematicaDAO;
	private StudenteDAO studenteDAO;
	private LezioneDAO lezioneDAO;
	private DocenteDAO docenteDAO;


	public static void main(String[] args) {
		Controller controller= new Controller();
	}

	public Controller(){
		responsabileDAO = new ResponsabileDAO();
		studenteDAO= new StudenteDAO();
		corsoDAO = new CorsoDAO();
		areaTematicaDAO = new AreaTematicaDAO();
		lezioneDAO = new LezioneDAO();
		docenteDAO = new DocenteDAO();
		
		
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
		setLezioniFrame(new LezioniFrame(this));
		setModificaLezioneFrame(new ModificaLezioneFrame(this));
		setAggiungiLezioneFrame(new AggiungiLezioneFrame(this));
		setPresenzeFrame(new PresenzeFrame(this));
		
	}
	
	//Getters e Setters of Frame
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
	
	public LezioniFrame getLezioniFrame() {
		return lezioniFrame;
	}

	public void setLezioniFrame(LezioniFrame lezioniFrame) {
		this.lezioniFrame = lezioniFrame;
	}

	public PresenzeFrame getPresenzeFrame() {
		return presenzeFrame;
	}

	public void setPresenzeFrame(PresenzeFrame presenzeFrame) {
		this.presenzeFrame = presenzeFrame;
	}

	public AggiungiLezioneFrame getAggiungiLezioneFrame() {
		return aggiungiLezioneFrame;
	}

	public void setAggiungiLezioneFrame(AggiungiLezioneFrame aggiungiLezioneFrame) {
		this.aggiungiLezioneFrame = aggiungiLezioneFrame;
	}

	public ModificaLezioneFrame getModificaLezioneFrame() {
		return modificaLezioneFrame;
	}

	public void setModificaLezioneFrame(ModificaLezioneFrame modificaLezioneFrame) {
		this.modificaLezioneFrame = modificaLezioneFrame;
	}

	//METODI CorsoDAO
	public void aggiungiCorso(String nome,String descrizione,String numeroMassimoPartecipanti,String numeroLezioni,String dataDiInizio,String codiceResponsabile) {
		corsoDAO.aggiungiCorso(nome, descrizione, numeroMassimoPartecipanti, numeroLezioni, dataDiInizio, codiceResponsabile);
	}

	public String recuperaCodiceCorso(String nome) {
		return corsoDAO.recuperaCodiceCorso(nome);
	}

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
	
	public String calcolaPresenzeMinime(String codiceCorso) {
		return corsoDAO.calcolaPresenzeMinime(codiceCorso);
	}
	
	public String calcolaPresenzeMassime(String codiceCorso) {
		return corsoDAO.calcolaPresenzeMassime(codiceCorso);
	}
	
	public String calcolaFrequenzaMedia(String codiceCorso) {
		return corsoDAO.calcolaFrequenzaMedia(codiceCorso);
	}
	
	public String calcolaPercentualeRiempimentoMedia(String codiceCorso) {
		return corsoDAO.calcolaPercentualeRiempimentoMedia(codiceCorso);
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
	public void salvaStudente(String nome,String cognome,Date dataDiNascita,String luogo,String codiceFiscale) {
		studenteDAO.salvaStudente(nome,cognome,dataDiNascita,luogo,codiceFiscale);
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
	
	public Vector<Vector<String>> recuperaIscrittiAdUnCorso(String codiceCorso){
		return studenteDAO.recuperaIscrittiAdUnCorso(codiceCorso);
	}
	
	public Vector<Vector<String>> recuperaStudentiIdonei(String codiceCorso){
		return studenteDAO.recuperaStudentiIdonei(codiceCorso);
	}
	
	public ArrayList<String> recuperaPartecipantiAdUnaLezione(String codiceLezione){
		return studenteDAO.recuperaPartecipantiAdUnaLezione(codiceLezione);
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
	
	public String[] recuperaAreeTematiche(Integer numeroCategorie) {
		return areaTematicaDAO.recuperaAreeTematiche(numeroCategorie);
	}
	
	public Vector<Vector<String>> recuperaAreeTematicheInVettoreDiVettoreDiStringhe(Integer numeroCategorie) {
		return areaTematicaDAO.recuperaAreeTematicheInVettoreDiVettoreDiStringhe(numeroCategorie);
	}
	
	//METODI LezioneDAO
	public void modificaLezioneInPresenza(String codiceLezione,String titolo,String descrizione,String durata,String dataOraInizio,String codiceDocente,String online,String sede,String aula) {
		lezioneDAO.modificaLezioneInPresenza(codiceLezione,titolo,descrizione,durata,dataOraInizio,codiceDocente,sede,aula);
	}
	
	public void modificaLezioneInPresenzaEDaRemoto(String codiceLezione,String titolo,String descrizione,String durata,String dataOraInizio,String codiceDocente,String sede,String aula,String piattaforma ) {
		lezioneDAO.modificaLezioneInPresenzaEDaRemoto(codiceLezione,titolo,descrizione,durata,dataOraInizio,codiceDocente,sede,aula,piattaforma);
	}
		
	public Vector<Vector<String>> recuperaLezioni(String codiceCorso) {
		return lezioneDAO.recuperaLezioni(codiceCorso);
	}
	public void eliminaLezione(String codiceLezione) {
		lezioneDAO.eliminaLezione(codiceLezione);
	}
	
	public void aggiungiLezioneInPresenza(String titolo,String descrizione,String durata,String dataEOraInizio,String codiceCorso,String codiceDocente,String sede,String aula) {
		lezioneDAO.aggiungiLezioneInPresenza(titolo, descrizione, durata, dataEOraInizio, codiceCorso, codiceDocente, sede, aula);
	}
	
	public void aggiungiLezioneInPresenzaEDaRemoto(String titolo,String descrizione,String durata,String dataEOraInizio,String codiceCorso,String codiceDocente,String sede,String aula,String piattaforma) {
		lezioneDAO.aggiungiLezioneInPresenzaEDaRemoto(titolo, descrizione, durata, dataEOraInizio, codiceCorso, codiceDocente, sede, aula,piattaforma);
	}
	
	public String recuperaDurata(String codiceLezione) {
		return lezioneDAO.recuperaDurata(codiceLezione);
	}
	
	public String recuperaCodiceDocenteDaLezione(String codiceLezione) {
		return lezioneDAO.recuperaCodiceDocenteDaLezione(codiceLezione);
	}
	
	public void inserisciPresenza(String codiceLezione, String codiceStudente) {
		lezioneDAO.inserisciPresenza(codiceLezione, codiceStudente);
	}
	
	public void eliminaPresenza(String codiceLezione, String codiceStudente) {
		lezioneDAO.eliminaPresenza(codiceLezione, codiceStudente);
	}
	//METODI DocenteDAO
	public int contaDocenti() {
		return docenteDAO.contaDocenti();
	}
	
	public String[] recuperaDocenti(int numeroDocenti) {
		return docenteDAO.recuperaDocenti(numeroDocenti);
	}
	
	
	public String recuperaCodiceDocente(String cognome) {
		return docenteDAO.recuperaCodiceDocente(cognome);
	}
	
	public String recuperaDocente(String codiceDocente) {
		return docenteDAO.recuperaDocente(codiceDocente);
	}
	
	
	
	

	
	
	public DefaultTableModel setDefaultTableModel(DefaultTableModel defaultTableModel,Vector<Vector<String>> vettoreDiVettoreDiStringhe){
		for (Vector<String> vettoreDiStringhe : vettoreDiVettoreDiStringhe) {
			defaultTableModel.addRow(vettoreDiStringhe);
		}
		
		return defaultTableModel;
	}
	
	
	
	public DefaultComboBoxModel<String> setDefaultComboBoxModel(DefaultComboBoxModel<String> defaultComboBoxModel,String[] arrayDiStringhe) {
		for(String stringa: arrayDiStringhe) {
			defaultComboBoxModel.addElement(stringa);
		}
		
		return defaultComboBoxModel;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

