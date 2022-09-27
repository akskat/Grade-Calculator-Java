package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TrinnetTest {

	@Test
	public void Trinnet() {
		Trinnet trinnet = new Trinnet(120, 2000);
		assertEquals(120, trinnet.getAntall(), 0);
		assertEquals(2000, trinnet.getTrinnid(), 0);
		assertEquals(120, trinnet.getListe().size(), 0);
		Student student = new Student(5);
		assertEquals(student.getStudentid(), trinnet.getStudent(5).getStudentid(), 0);
		assertTrue(trinnet.getTrinnid()<=2000 && trinnet.getTrinnid()<=2000);
		assertThrows(IllegalArgumentException.class, () -> {
			trinnet.setTrinnid(1950);;
			;
		});
	}
	
	
	@Test
	public void setTrinnid() {
		Trinnet trinnet = new Trinnet(120, 2000);
		assertTrue(trinnet.getTrinnid()<=2000 && trinnet.getTrinnid()<=2000);
		assertThrows(IllegalArgumentException.class, () -> {
			trinnet.setTrinnid(1950);;
			;
		});
	}
	
	@Test
	public void antallKarakter() {
		Trinnet trinnet = new Trinnet(120, 2000);
		boolean karakter;
		if ((trinnet.antallKarakter(1).get(0)>=0 && trinnet.antallKarakter(1).get(0)<=100) && (trinnet.antallKarakter(2).get(0)>=0 && trinnet.antallKarakter(2).get(0)<=100) && (trinnet.antallKarakter(3).get(0)>=0 && trinnet.antallKarakter(3).get(0)<=100) ) {
			karakter = true;
		}
		else {
			karakter = false;
		}
		assertTrue(karakter);
	}
	
	@Test
	public void getListeKarakter() {
		Trinnet trinnet = new Trinnet(120, 2000);
		assertTrue(trinnet.getListeKarakter().get(0)=='A');
		assertTrue(trinnet.getListeKarakter().get(1)=='B');
		assertTrue(trinnet.getListeKarakter().get(5)=='F');
	}
	

	@Test
	public void getGjennomsnitt() {
		Trinnet trinnet = new Trinnet(120, 2000);
		boolean gjennomsnitt;
		if (0<=trinnet.getGjennomsnitt().get(0) && trinnet.getGjennomsnitt().get(0)<=100 ) {
			gjennomsnitt = true;
		}
		else {
			gjennomsnitt = false;
		}
		assertTrue(gjennomsnitt);
	}
	
	@Test
	public void getGjennomsnittKarakter() {
		Trinnet trinnet = new Trinnet(120, 2000);
		boolean karakter = false;
		if (trinnet.getGjennomsnittKarakter().get(0) == Student.Int2Char2(trinnet.getGjennomsnitt().get(0))) {
			karakter = true;
		}
		else {
			karakter = false;
		}
		assertTrue(karakter);
	}
	
	@Test
	public void Sorter() {
		Trinnet trinnet = new Trinnet(120, 2000);
		boolean sorter = false;
		for (int i = 0; i < trinnet.getAntall()-1; i++) {
	        if (trinnet.getListe().get(i).getAverage() < trinnet.getListe().get(i+1).getAverage()) {
	        	sorter = true;
	        }	
	    }
		
	    assertTrue(sorter);
	}
	
	@Test
	public void SorterPlasser() {
		Trinnet trinnet = new Trinnet(120, 2000);
		int i = trinnet.Sorter().get(0).getStudentid();
		int n = trinnet.SorterPlasser().get(0);
		assertEquals(i, n, 0);
		assertFalse(i!=n);
	}
	
	@Test
	public void MinPlass() {
		Trinnet trinnet = new Trinnet(120, 2000);
		int p = trinnet.getStudent(trinnet.SorterPlasser().indexOf(0)).getStudentid();
		int n = trinnet.MinPlass(0).get(0);
		assertEquals(p, n, 0);
		assertFalse(p!=n);
	}
	
	@Test
	public void MineStudier() {
		Trinnet trinnet = new Trinnet(120, 2000);
		Studier studier = new Studier();
		ArrayList<String> liste = new ArrayList<String>();
		liste = studier.StudierListe();
		int plass = trinnet.MinPlass(0).get(0);
		boolean test;
		
		
		if (plass<=15) {
			if (liste.size()==8) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=30) {
			liste = studier.StudierListe();
			for (int i = 0; i < 1; i++) {
				liste.remove(0);
			}
			if (liste.size()==7) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=45) {
			liste = studier.StudierListe();
			for (int i = 0; i < 2; i++) {
				liste.remove(0);
			}
			if (liste.size()==6) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=60) {
			liste = studier.StudierListe();
			for (int i = 0; i < 3; i++) {
				liste.remove(0);
			}
			if (liste.size()==5) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=75) {
			liste = studier.StudierListe();
			for (int i = 0; i < 4; i++) {
				liste.remove(0);
			}
			if (liste.size()==4) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=90) {
			liste = studier.StudierListe();
			for (int i = 0; i < 5; i++) {
				liste.remove(0);
			}
			if (liste.size()==3) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else if (plass<=105) {
			liste = studier.StudierListe();
			for (int i = 0; i < 6; i++) {
				liste.remove(0);
			}
			if (liste.size()==2) {
				test = true;
			}
			else {
				test = false;
			}
		}
		else {
			liste = studier.StudierListe();
			for (int i = 0; i < 7; i++) {
				liste.remove(0);
			}
			if (liste.size()==1) {
				test = true;
			}
			else {
				test = false;
			}
		}
		assertTrue(test);
	}
	
	@Test
	public void makeTrinn() {
		Trinnet trinnet = new Trinnet(120, 2000);
		ArrayList<Trinnet> liste = new ArrayList<Trinnet>();
		liste = trinnet.makeTrinn();
		assertEquals(22, liste.size(), 0);
		assertTrue(liste.get(0).getTrinnid()==2000);
		assertFalse(liste.get(0).getTrinnid()==2222);
	}

	
}
