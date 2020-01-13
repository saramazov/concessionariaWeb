package concessionaria.service;

import concessionaria.model.Veicolo;

public class VeicoloVendutoDTO extends DTO {

	public static final String NAME = "concessionaria.service.VeicoloVendutoDTO";
	private Veicolo veicolo;

	public void addVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}

	public boolean success() {
		return getEccezione()==null;
	}

	@Override
	public String toString() {
		return "VeicoloVendutoDTO [veicolo=" + veicolo + ", eccezione= " + getEccezione()+ "]";
	}
	
	
	
	
}
