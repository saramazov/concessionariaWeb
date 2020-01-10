package service;

import concessionaria.model.Dipendente;
import concessionaria.model.Menu;

public class DTO {

	private Dipendente dipendente;
	private Menu menu;
	private Exception eccezione;
	
	public DTO() {}
	
//	public DTO(Dipendente dipendente, Menu menu, Exception eccezione) {
//		this.dipendente = dipendente;
//		this.menu = menu;
//		this.eccezione = eccezione;
//	}

	public void addDipendente(Dipendente dipendente) throws Exception {
		this.dipendente = dipendente;
	}
	
	public void addMenu(Menu menu) throws Exception {
		this.menu = menu;
	}
	
	public void addException(Exception eccezione) {
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

	public boolean existsDipendente() {
		return this.dipendente!=null;
	}
	
	public boolean existsMenu() {
		return this.menu!=null;
	}
	
	public boolean success() {
		return this.eccezione==null;
	}
	
}
