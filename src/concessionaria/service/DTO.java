package concessionaria.service;

public abstract class DTO {

	private Exception eccezione;
	private String message;
	
	public Exception getEccezione() {
		return eccezione;
	}
	public void setEccezione(Exception eccezione) {
		this.eccezione = eccezione;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
