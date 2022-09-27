package project;

import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {

	private int studentid;
	private int score1;
	private int score2;
	private int score3;
	private char grade1;
	private char grade2;
	private char grade3;
	// Matematikk R1 = score1 + grade1 
	// Matematikk R2 = score2 + grade2
	// Fysikk 1 = score3 + grade3
	private boolean svarResultat;
	
	//konstruktørene som tar inn studentid, og lager en student med tilfeldig karakterer i fagene
	public Student(int studentid) {
		setStudentid(studentid);
		LageVerdier();
		setSvarResultat(false);
		FagListe();
	}
	
	
	//metode for å lage tilfeldige karakterer
	public void LageVerdier() {
		Random tall1 = new Random();
		Random tall2 = new Random();
		Random tall3 = new Random();
		int poenggrense = 101;
		//setter en poenggrense mellom 20 og 100;
		setScore1(tall1.nextInt(poenggrense-20) + 20);
		setScore2(tall2.nextInt(poenggrense-20) + 20);
		setScore3(tall3.nextInt(poenggrense-20) + 20);
		InttoChar(1);
		InttoChar(2);
		InttoChar(3);
	}
	
	
	//sjekker om studenten har svart på eksamensresultatet, godta eller klage
	public boolean getSvarResultat() {
		return this.svarResultat;
	}
	public void setSvarResultat(boolean svarResultat) {
		this.svarResultat = svarResultat;
	}
	
	
	
	//sjekker studentiden og setter den
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getStudentid() {
		return studentid;
	}
	
	
	
	
	//settere og gettere for poengene i fagene til studenten
	public int setScore1(int score1) {
		return this.score1 = score1;
	}
	public int setScore2(int score2) {
		return this.score2 = score2;
	}
	public int setScore3(int score3) {
		return this.score3 = score3;
	}
	public int getScore1() {
		return score1;
	}
	public int getScore2() {
		return score2;
	}
	public int getScore3() {
		return score3;
	}
	
	
	
	//settere og gettere for karakterene i fagene til studenten
	public int setGrade1(char grade1) {
		return this.grade1 = grade1;
	}
	public int setGrade2(char grade2) {
		return this.grade2 = grade2;
	}
	public int setGrade3(char grade3) {
		return this.grade3 = grade3;
	}
	public char getGrade1() {
		return grade1;
	}
	public char getGrade2() {
		return grade2;
	}
	public char getGrade3() {
		return grade3;
	}
	
	
	
	//metode som godtar svarresultatet på eksamen
	public final void Godta() {
		if (getSvarResultat() == false) {
			setSvarResultat(true);;			
		}
		else {
			throw new IllegalStateException();
		}
	}
	
	
	//metode som klager på svarresultatet på eksamen
	public final void Klage() {
		if (getSvarResultat() == false) {
			LageVerdier();
			setSvarResultat(true);
		}
		else {
			throw new IllegalStateException("Du kan ikke klage flere ganger!");	
		}
	}
	
	
	//gjør om et bestemt fag fra poeng til en karakter
	public void InttoChar(int tall) {
		if (tall == 1) {
			setGrade1(Int2Char2(getScore1()));
		}
		if (tall == 2) {
			setGrade2(Int2Char2(getScore2()));
		}
		if (tall == 3) {
			setGrade3(Int2Char2(getScore3()));
		}
	}
	
	//gjør om en poengsum til en bestemt karakter
	public static char Int2Char2(int score) {
		char bokstav = 'Ø';
		
			if (100 >= score && score >= 89) {
				bokstav = 'A';
			}
			if (88 >= score && score >= 77) {
				bokstav = 'B';
			}
			if (76 >= score && score >= 65) {
				bokstav = 'C';
			}
			if (64 >= score && score >= 53) {
				bokstav = 'D';
			}
			if (52 >= score && score >= 41) {
				bokstav = 'E';
			}
			if (40 >= score && score >= 0) {
				bokstav = 'F';
			}
			if (bokstav == 'Ø') {
				throw new IllegalArgumentException("problemer med int to char");
			}
		return bokstav;
	}
		
		
	//metode som returner en liste med fagene til studenten	
	public ArrayList<String> FagListe() {
		ArrayList<String> fag = new ArrayList<String>();
		fag.add("Matematikk R1");
		fag.add("Matematikk R2");
		fag.add("Fysikk 1");
		return fag;
	}
	
	//metode som returner en liste med poengene til studenten i fagene
	public ArrayList<Integer> PoengListe() {
		ArrayList<Integer> poeng = new ArrayList<Integer>();
		poeng.add(getScore1());
		poeng.add(getScore2());
		poeng.add(getScore3());
		return poeng;
	}
	
	//metode som returner en liste med et element, gjennomsnittet til student i poeng
	public ArrayList<Integer> getAverageStudent(){
		ArrayList<Integer> snitt = new ArrayList<Integer>();
		snitt.add(getAverage());
		return snitt;
	}
	
	//metode for å regne ut gjennomsnittet i alle fagene til student, i poeng
	public int getAverage() {
		return (getScore1()+getScore2()+getScore3())/3;
	}
	
	
	//metode som returner en liste med et element, bestående av snittet (bokstavkarakter) i alle fagene til sammen til studenten
	public ArrayList<Character> getAverageStudentKarakter(){
		ArrayList<Character> snitt = new ArrayList<Character>();
		snitt.add(Int2Char2(getAverage()));
		return snitt;
	}
	
	
	//metode som returner en liste med karakterene i fagene til studenten
	public ArrayList<Character> ListeKarakter(){
		ArrayList<Character> karakter = new ArrayList<Character>();
		karakter.add(getGrade1());
		karakter.add(getGrade2());
		karakter.add(getGrade3());
		return karakter;
	}

	

}
