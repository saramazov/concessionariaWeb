package concessionaria.service;

import concessionaria.dao.ConcessionariaException;
import concessionaria.dao.DipendenteDAO;
import concessionaria.model.Dipendente;

public class DipendentiService {
	
	public DipendentiDTO listaDipendenti() {
		
		DipendentiDTO dto = new DipendentiDTO();
		DipendenteDAO dao = new DipendenteDAO();
		try {
			dto.setDipendenti(dao.findAll());
		} catch (ConcessionariaException e) {
			dto.setEccezione(e);
		}
		return dto;
	}
	
	public DipendentiDTO updateDipendente(Dipendente dip) {
		
		DipendentiDTO dto = new DipendentiDTO();
		DipendenteDAO dao = new DipendenteDAO();
		
	    dto.setDipendenteUp(dip);
	    dto.setMsg("Hai modificato il dipendente " + dip.getMatricola());
		try {
			dao.update(dip);
			
			dto.setDipendenti(dao.findAll());
		}
		catch(ConcessionariaException e) {
			dto.setEccezione(e);
		}
		return dto;
	}

	
}
