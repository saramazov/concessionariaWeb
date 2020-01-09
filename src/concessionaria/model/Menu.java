package concessionaria.model;

import java.util.Collection;

public class Menu {

	Collection<MenuItem> elenco;
	
	public Menu() {}

	public void add(MenuItem item) {
		elenco.add(item);
	}
}

