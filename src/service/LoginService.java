package service;

import concessionaria.dao.DipendenteDAO;
import concessionaria.dao.MenuDAO;
import concessionaria.db.ConcessionariaException;
import concessionaria.model.Dipendente;
import concessionaria.model.Menu;

public class LoginService {

	public DTO comunicaServlet(String id) throws ConcessionariaException {
		
		DTO dto = null;
		try {
			Dipendente dipendente = usaDaoDipendente(id);
			Menu menu = usaDaoMenu(dipendente.getRuolo());
			dto = new DTO(dipendente,menu,null);
		} catch(Exception e) {
			//dto.addEccezione(e);
		}
		
		return dto;
	}
	
	private Menu usaDaoMenu(String ruolo) throws ConcessionariaException {
		MenuDAO dao = new MenuDAO();
		Menu menu = dao.menuSelect(ruolo, 1, null);
		return menu;
		
	}
	
	private Dipendente usaDaoDipendente(String id) throws NumberFormatException, ConcessionariaException {
		DipendenteDAO dao = new DipendenteDAO();
		Dipendente dip = dao.findById(Long.parseLong(id));	
		return dip;
	}

	
	
}
