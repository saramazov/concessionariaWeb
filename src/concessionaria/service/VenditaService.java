package concessionaria.service;

import java.util.Collection;

import concessionaria.dao.VeicoloDAO;
import concessionaria.db.ConcessionariaException;
import concessionaria.model.Veicolo;

public class VenditaService {
public VeicoloDTO comunicaServlet(String id) {
		
		VeicoloDTO dto = new VeicoloDTO();
		try {
			usaDaoVeicolo(id);
		} catch (ConcessionariaException e) {
			dto.addEccezione(e);
		}
		return dto;
	}
	
	private void usaDaoVeicolo(String id) throws 
												ConcessionariaException {
		VeicoloDAO dao = new VeicoloDAO();
		dao.remove(Long.parseLong(id));

	}

}
