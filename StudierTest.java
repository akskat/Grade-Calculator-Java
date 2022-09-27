package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class StudierTest {

	
	
	@Test
	public void Studier() {
		Studier studier = new Studier();
		ArrayList<String> testliste = new ArrayList<String>();
		testliste.add("Indøk");
		testliste.add("Kyb");
		testliste.add("Data");
		testliste.add("Komtek");
		testliste.add("Emil");
		testliste.add("Marin");
		testliste.add("Bygg");
		testliste.add("Maskin");
		
		assertTrue(studier.getStudier().equals(testliste));
	}

	
	@Test
	public void StudierListe() {
		Studier studier = new Studier();
		ArrayList<String> testliste = new ArrayList<String>();
		testliste.add("Indøk");
		testliste.add("Kyb");
		testliste.add("Data");
		testliste.add("Komtek");
		testliste.add("Emil");
		testliste.add("Marin");
		testliste.add("Bygg");
		testliste.add("Maskin");
		
		assertTrue(studier.StudierListe().equals(testliste));
	}
	
	
	@Test
	public void PlasserListe() {
		Studier studier = new Studier();
		ArrayList<Integer> testliste = new ArrayList<Integer>();
		for (int i = 0; i < studier.getAntallStudier(); i++) {
			testliste.add(15);
		}
		assertTrue(studier.PlasserListe().equals(testliste));
	}
	
	@Test
	public void getAntallStudier() {
		Studier studier = new Studier();
		//skal være nøyaktig 8 ulike studier
		assertEquals(8, studier.getAntallStudier(), 0);
	}
	
	
	

}
