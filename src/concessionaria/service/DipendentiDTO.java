package concessionaria.service;


import java.util.Collection;


import concessionaria.model.Dipendente;

public class DipendentiDTO extends DTO{

	public static final String NAME= "concessionaria.service.DipendentiDTO";
	private Collection<Dipendente> dipendenti = null;
	private Exception eccezione = null;
	private Dipendente updatedEmployee = null;
	
	
	
	public Collection<Dipendente> getDipendenti() {
		return dipendenti;
	}
	public void setDipendenti(Collection<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
	
	public Exception getEccezione() {
		return eccezione;
	}
	public void setEccezione(Exception eccezione) {
		this.eccezione = eccezione;
	}
	public void setDipendenteUp(Dipendente d) {
		this.updatedEmployee = d;
	}
	
	public Dipendente getUpdatedDipendente() {
		return updatedEmployee;
	}
	
	
	public boolean existsDipendenti() {
		return dipendenti!=null;
	}
	
	public boolean success() {
		return eccezione==null;
	}
	
	
	
}
