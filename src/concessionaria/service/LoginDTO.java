package concessionaria.service;

import concessionaria.model.Dipendente;
import concessionaria.model.Menu;

public class LoginDTO extends DTO{

	public static final String NAME = "concessionaria.service.LoginDTO";
	private Dipendente dipendente;
	private Menu menu;

	public void addDipendente(Dipendente dipendente) throws Exception {
		this.dipendente = dipendente;
	}
	
	public void addMenu(Menu menu) throws Exception {
		this.menu = menu;
	}
	
	public Dipendente getDipendente() {
		return dipendente;
	}

	public Menu getMenu() {
		return menu;
	}

	public boolean existsDipendente() {
		return this.dipendente!=null;
	}
	
	public boolean existsMenu() {
		return this.menu!=null;
	}
	
	public boolean success() {
		return this.getEccezione()==null;
	}
	
}
