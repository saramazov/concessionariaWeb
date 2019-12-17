package concessionaria.model;

import java.io.Serializable;

public class Dipendente implements Serializable{

	private Long id;  //uso oggetto perchè puo essere null (mancante)
	private String nome;
	private String cognome;
	private String matricola;
	private String ruolo;
	
	public Dipendente(Long id, String nome, String cognome, 
			String matricola, String ruolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.ruolo = ruolo;
	}
	
	public Dipendente(String nome, String cognome, 
			String matricola, String ruolo) {
		this(null, nome, cognome, matricola, ruolo);
	}
	
	public Dipendente() {
		super();
	}
	
	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", "
				+ "matricola=" + matricola + ", ruolo=" + ruolo + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}	

}
