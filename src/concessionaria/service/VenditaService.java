package concessionaria.service;

import concessionaria.dao.VeicoloDAO;
import concessionaria.db.ConcessionariaException;
import concessionaria.model.Veicolo;

public class VenditaService {
public VeicoloVendutoDTO comunicaServlet(String id) {
		
		VeicoloVendutoDTO dto = new VeicoloVendutoDTO();
		try {
			dto.addVeicolo(usaDaoVeicolo(id));
		} catch (ConcessionariaException e) {
			dto.setEccezione(e);
		}
		return dto;
	}
	
	private Veicolo usaDaoVeicolo(String id) throws 
												ConcessionariaException {
		VeicoloDAO dao = new VeicoloDAO();
		Veicolo veicoloVenduto = dao.findById(Long.parseLong(id));
		dao.remove(Long.parseLong(id));
		return veicoloVenduto;
		
	}

}
