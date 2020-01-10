package concessionaria.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Menu implements Iterable<MenuItem> {

	Collection<MenuItem> elenco;
	
	public Menu() {
		elenco = new ArrayList<MenuItem>();
	}

	public void add(MenuItem item) {
		elenco.add(item);
	}
	
	public Integer menuSize() {
		return this.elenco.size();
	}

	@Override
	public String toString() {
		return "Menu [elenco=" + elenco + "]";
	}

	@Override
	public Iterator<MenuItem> iterator() {
		return this.elenco.iterator();
	}
	
}

