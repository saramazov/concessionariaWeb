package concessionaria.model;

public class MenuItem {

	private Long id;
	private String descrizione;
	private String link;
	private String ruolo;
	private Integer livello;
	private String richiamo;
	private Integer ordine;
	
	public MenuItem(String descrizione, String link, String ruolo,
			Integer livello, String richiamo, Integer ordine) {
		this.descrizione = descrizione;
		this.link = link;
		this.ruolo = ruolo;
		this.livello = livello;
		this.richiamo = richiamo;
		this.ordine = ordine;	
	}
	
	public MenuItem(Long id, String descrizione, String link, String ruolo,
			Integer livello, String richiamo, Integer ordine) {
		this.id = id;
		this.descrizione = descrizione;
		this.link = link;
		this.ruolo = ruolo;
		this.livello = livello;
		this.richiamo = richiamo;
		this.ordine = ordine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Integer getLivello() {
		return livello;
	}

	public void setLivello(Integer livello) {
		this.livello = livello;
	}

	public String getRichiamo() {
		return richiamo;
	}

	public void setRichiamo(String richiamo) {
		this.richiamo = richiamo;
	}

	public Integer getOrdine() {
		return ordine;
	}

	public void setOrdine(Integer ordine) {
		this.ordine = ordine;
	}

	@Override
	public String toString() {
		return "\nMenuItem [id=" + id + ", descrizione=" + descrizione + ", link=" + link + ", ruolo=" + ruolo
				+ ", livello=" + livello + ", richiamo=" + richiamo + ", ordine=" + ordine + "]";
	}
	
}
