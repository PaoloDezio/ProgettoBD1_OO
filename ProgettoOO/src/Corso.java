
public class Corso {
	
	private String nome;
	private String descrizione;
	private Integer capienza;
	private Integer numeroLezioni; 
	private Double presenzeMinime;
	private String dataInizioCorso;
	private Integer codiceCorso;
	

	
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
	public String getDataInizioCorso() {
		return dataInizioCorso;
	}
	public void setDataInizioCorso(String dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	
	}
	public Double getPresenzeMinime() {
		return presenzeMinime;
	}
	public void setPresenzeMinime(Double presenzeMinime) {
		this.presenzeMinime = presenzeMinime;
	
	}
	public Integer getCapienza() {
		return capienza;
	}
	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}
}
