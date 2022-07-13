
public class Corso {
	
	private String nome;
	private String descrizione;
	private Integer numeroMassimoIscritti;
	private Integer numeroLezioni; 
	private String dataInizio;
	private Integer codiceCorso;
	
	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Integer getCodiceCorso() {
		return codiceCorso;
	}
	
	public void setCodiceCorso(Integer codiceCorso) {
		this.codiceCorso = codiceCorso;
	}
	
	public Integer getNumeroLezioni() {
		return numeroLezioni;
	}
	
	public void setNumeroLezioni(Integer numeroLezioni) {
		this.numeroLezioni = numeroLezioni;
	}
	
	public String getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(String dataInizioCorso) {
		this.dataInizio = dataInizioCorso;
	}
	
	public Integer getNumeroMassimoIscritti() {
		return numeroMassimoIscritti;
	}
	
	public void setNumeroMassimoIscritti(Integer numeroMassimoIscritti) {
		this.numeroMassimoIscritti = numeroMassimoIscritti;
	}
	
	
	
}
