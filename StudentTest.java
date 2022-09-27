package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;


public class StudentTest {

	@Test
	public void Student() {
		Student stud = new Student(5);
		assertEquals(5, stud.getStudentid(), 0);
		boolean r;
		if ((20 <= stud.getScore1() && stud.getScore1()  <= 100) && (20 <= stud.getScore2() && stud.getScore2()  <= 100) && (20 <= stud.getScore3() && stud.getScore3()  <= 100) ) {
			r = true;
		}
		else {
			r = false;
		}
		assertTrue(r);
		assertFalse(stud.getSvarResultat());	
	}

	@Test
	public void InttoChar() {
		Student stud = new Student(5);
		char bokstavkarakter = 'E';
		stud.setScore1(44);
		stud.InttoChar(1);
		assertTrue(stud.getGrade1() == bokstavkarakter);
		
		bokstavkarakter = 'A';
		stud.setScore2(95);
		stud.InttoChar(2);
		assertTrue(stud.getGrade2() == bokstavkarakter);
		
		bokstavkarakter = 'F';
		stud.setScore3(20);
		stud.InttoChar(3);
		assertTrue(stud.getGrade3() == bokstavkarakter);
	}
	
	@Test
	public void Int2Char2() {
		Student stud = new Student(5);
		char bokstavkarakter = 'E';
		stud.setScore1(44);
		assertTrue(stud.Int2Char2(stud.getScore1())==bokstavkarakter);
		
		bokstavkarakter = 'A';
		stud.setScore2(95);
		assertTrue(stud.Int2Char2(stud.getScore2())==bokstavkarakter);
		
		bokstavkarakter = 'F';
		stud.setScore3(20);
		assertTrue(stud.Int2Char2(stud.getScore3())==bokstavkarakter);

	}
	
	@Test
	public void Godta() {
		Student stud = new Student(5);
		assertFalse(stud.getSvarResultat());
		stud.Godta();
		assertThrows(IllegalStateException.class, () -> {
			stud.Godta();;
			;
		});
	}
	
	@Test
	public void Klage() {
		Student stud = new Student(5);
		assertFalse(stud.getSvarResultat());
		stud.Klage();
		assertThrows(IllegalStateException.class, () -> {
			stud.Klage();;
			;
		});
	}
	
	
	@Test
	public void FagListe() {
		Student stud = new Student(5);
		ArrayList<String> testliste = new ArrayList<String>();
		testliste.add("Matematikk R1");
		testliste.add("Matematikk R2");
		testliste.add("Fysikk 1");
		assertTrue(stud.FagListe().equals(testliste));
		
		
	}
	
	@Test
	public void PoengListe() {
		Student stud = new Student(5);
		ArrayList<Integer> testliste = new ArrayList<Integer>();
		stud.setScore1(44);
		stud.setScore2(45);
		stud.setScore3(46);
		testliste.add(44);
		testliste.add(45);
		testliste.add(46);
		assertTrue(stud.PoengListe().equals(testliste));
	}
	
	@Test
	public void getAverageStudent() {
		Student stud = new Student(5);
		ArrayList<Integer> testliste = new ArrayList<Integer>();
		stud.setScore1(44);
		stud.setScore2(45);
		stud.setScore3(46);
		testliste.add(45);
		assertTrue(stud.getAverageStudent().equals(testliste));
	}
	
	@Test
	public void getAverage() {
		Student stud = new Student(5);
		stud.setScore1(44);
		stud.setScore2(45);
		stud.setScore3(46);
		assertEquals(45, stud.getAverage(), 0);
		
	}
	
	@Test
	public void getAverageStudentKarakter() {
		Student stud = new Student(5);
		ArrayList<Character> testliste = new ArrayList<Character>();
		testliste.add('E');
		stud.setScore1(44);
		stud.setScore2(45);
		stud.setScore3(46);
		assertTrue(stud.getAverageStudentKarakter().equals(testliste));
	}
	
	@Test
	public void ListeKarakter() {
		Student stud = new Student(5);
		ArrayList<Character> testliste = new ArrayList<Character>();
		testliste.add('E');
		testliste.add('E');
		testliste.add('E');
		stud.setScore1(44);
		stud.setScore2(45);
		stud.setScore3(46);
		stud.InttoChar(1);
		stud.InttoChar(2);
		stud.InttoChar(3);
		assertTrue(stud.ListeKarakter().equals(testliste));
	}
	
	

}