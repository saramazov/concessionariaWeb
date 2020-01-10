package concessionaria.service;

import java.util.ArrayList;
import java.util.Collection;

import concessionaria.dao.DipendenteDAO;
import concessionaria.dao.VeicoloDAO;
import concessionaria.db.ConcessionariaException;
import concessionaria.model.Dipendente;
import concessionaria.model.Menu;
import concessionaria.model.Veicolo;

public class VeicoloService {

	public VeicoloDTO comunicaServlet() {
		
		VeicoloDTO dto = new VeicoloDTO();
		try {
			Collection<Veicolo> veicoli = usaDaoVeicolo();
			dto.addVeicoli(veicoli);
		} catch (ConcessionariaException e) {
			dto.addEccezione(e);
		}
		return dto;
	}
	
	private Collection<Veicolo> usaDaoVeicolo() throws 
												ConcessionariaException {
		VeicoloDAO dao = new VeicoloDAO();
		Collection<Veicolo> veicoli = dao.findAll();
		return veicoli;
	}
	
}
