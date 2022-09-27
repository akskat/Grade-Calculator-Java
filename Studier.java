package project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Studier implements Serializable {

	//felt
	private ArrayList<String> studier;
	
	//konstruktør som lager en liste med studier
	public Studier() {
		setStudier(StudierListe());
	}
	
	//getter studielista
	public ArrayList<String> getStudier() {
		return studier;
	}
	//setter studielista
	public void setStudier(ArrayList<String> studier) {
		this.studier = studier;
	}
	//getter antall studier
	public int getAntallStudier() {
		return getStudier().size();
	}
	
	//returner en liste med antall plasser per studie
	public ArrayList<Integer> PlasserListe(){
		ArrayList<Integer> plasser = new ArrayList<Integer>();
		for (int i = 0; i < getAntallStudier(); i++) {
			plasser.add(15);
		}
		return plasser;
	}	
	
	//lager og returner en liste med forskjellige studier
	public ArrayList<String> StudierListe() {
		ArrayList<String> studier = new ArrayList<String>();
		studier.add("Indøk");
		studier.add("Kyb");
		studier.add("Data");
		studier.add("Komtek");
		studier.add("Emil");
		studier.add("Marin");
		studier.add("Bygg");
		studier.add("Maskin");
		
		return studier;
	}

}