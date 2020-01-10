package service;

import concessionaria.dao.DipendenteDAO;
import concessionaria.dao.MenuDAO;
import concessionaria.db.ConcessionariaException;
import concessionaria.model.Dipendente;
import concessionaria.model.Menu;

public class LoginService {

	public DTO comunicaServlet(String id) {
		
		DTO dto = new DTO();
		try {
			Dipendente dipendente = usaDaoDipendente(id);
			Menu menu = usaDaoMenu(dipendente.getRuolo());
			dto.addDipendente(dipendente);
			dto.addMenu(menu);
		} catch(Exception e) {
			dto.addException(e);
		}
		
		return dto;
	}
	
	private Menu usaDaoMenu(String ruolo) throws ConcessionariaException {
		MenuDAO dao = new MenuDAO();
		Menu menu = dao.menuSelect(ruolo, 1, null);
		return menu;
		
	}
	
	private Dipendente usaDaoDipendente(String id) throws
										ConcessionariaException {
		DipendenteDAO dao = new DipendenteDAO();
		Dipendente dip = dao.findById(Long.parseLong(id));
		if(dip==null) {
			throw new ConcessionariaException("ID: "+id+" not found");
		}
		return dip;
	}

	
	
}
