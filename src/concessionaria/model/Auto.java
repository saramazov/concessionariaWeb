package concessionaria.model;

public class Auto extends Veicolo {

	private Integer numeroPorte;

	@Override
	public String toString() {
		return "Auto "+super.toString()+" [numeroPorte=" + numeroPorte + "]";
	}

	public Auto(String targa, String produttore,  Double prezzo, 
			String modello, String alimentazione, String colore,
			Integer numeroPorte) {
		super(targa, produttore,prezzo, modello, alimentazione, colore);
		this.numeroPorte = numeroPorte;
	}

	public Auto(Long id, String targa, String produttore, Double prezzo, 
			String modello, String alimentazione, String colore,
			Integer numeroPorte) {
		super(id, targa, produttore, modello, alimentazione, colore, prezzo);
		this.numeroPorte = numeroPorte;
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
