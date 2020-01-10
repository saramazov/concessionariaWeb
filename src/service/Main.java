package service;

import concessionaria.db.ConcessionariaException;

public class Main {

	public static void main(String[] args) {

		LoginService service = new LoginService();
		DTO dto = service.comunicaServlet("8");
		System.out.println(dto.getDipendente());
		System.out.println(dto.getMenu());
		System.out.println(dto.getEccezione());
	}

}
