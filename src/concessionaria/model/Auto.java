package concessionaria.model;

public class Auto extends Veicolo {

	private Integer numeroPorte;

	@Override
	public String toString() {
		return "Auto "+super.toString()+" [numeroPorte=" + numeroPorte + "]";
	}

	public Auto(String targa, String produttore, String modello, 
			String alimentazione, String colore, Double prezzo,
			Integer numeroPorte) {
		super(targa, produttore,prezzo, modello, alimentazione, colore);
		this.numeroPorte = numeroPorte;
	}

	public Auto(Long id, String targa, String produttore, String modello, String alimentazione, String colore,
			Double prezzo) {
		super(id, targa, produttore, modello, alimentazione, colore, prezzo);
	}

	public Auto() {}

	@Override
	public String getTipo() {
		return "A";
	}

	public Integer getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(Integer numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

}
