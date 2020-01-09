package concessionaria.dao;

import concessionaria.db.ConcessionariaException;
import concessionaria.model.Menu;


public class DaoTest {

	public static void main(String[] args) throws ConcessionariaException {

		MenuDAO dao = new MenuDAO();
		Menu m = dao.menuSelect("D", 1, null);
		System.out.println(m);
		
	}

}
