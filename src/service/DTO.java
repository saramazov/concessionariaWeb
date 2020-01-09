package service;

import concessionaria.model.Dipendente;
import concessionaria.model.Menu;

public class DTO {

	private Dipendente dipendente;
	private Menu menu;
	private Exception eccezione;
	
	public DTO() {}
	
	public DTO(Dipendente dipendente, Menu menu, Exception eccezione) {
		this.dipendente = dipendente;
		this.menu = menu;
		this.eccezione = eccezione;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public Menu getMenu() {
		return menu;
	}

	public Exception getEccezione() {
		return eccezione;
	}

	
}
