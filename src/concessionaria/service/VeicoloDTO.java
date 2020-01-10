package concessionaria.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import concessionaria.model.Veicolo;

public class VeicoloDTO implements Iterable<Veicolo> {

	public static final String NAME = "concessionaria.service.VeicoloDTO";
	private Collection<Veicolo> veicoli;
	private Exception eccezione;
	
	public VeicoloDTO() {
		this.veicoli = new ArrayList<Veicolo>();
	}
	
	public void addVeicoli(Collection<Veicolo> veicoli) {
		this.veicoli = veicoli;
	}

	public Exception getEccezione() {
		return eccezione;
	}

	public void addEccezione(Exception eccezione) {
		this.eccezione = eccezione;
	}
	
	public boolean success() {
		return eccezione==null;
	}
	
	@Override
	public String toString() {
		return "VeicoloDTO [veicoli=" + veicoli + "]";
	}

	@Override
	
	public Iterator<Veicolo> iterator() {
		return this.veicoli.iterator();
	}
	
}
