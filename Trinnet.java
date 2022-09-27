package project;

import java.io.Serializable;
import java.util.ArrayList;


public class Trinnet implements Serializable {
	
	//felt
	private ArrayList<Student> liste = new ArrayList<Student>();
	private int antall;
	private int trinnid;
	private Studier studier = new Studier();
	private static ArrayList<Trinnet> trinnliste = new ArrayList<Trinnet>();
	
	
	//konstuktør som tar inn antall elever som det skal være på trinnet
	public Trinnet(int antall, int trinnid) {
		setAntall(antall);
		setTrinnid(trinnid);
		for (int i = 0; i < antall; i++) {
			getListe().add(i, new Student(i));
		}
	}
	
	

	//getter og setter for trinnid 
	public int getTrinnid() {
		return trinnid;
	}
	public void setTrinnid(int trinnid) {
		if (trinnid < 2000 || trinnid > 2021) {
			throw new IllegalArgumentException();
		}
		else {
			this.trinnid = trinnid;
		}
		
	}
	
	//getter og setter for antall elever på trinnet
	public void setAntall(int antall) {
		this.antall = antall;
	}
	public int getAntall() {
		return antall;
	}
	
	
	//metode som returner en liste med alle studentene på trinnet
	public ArrayList<Student> getListe() {
		return liste;
	}
	
	//getter for å finne en bestemt student på trinnet
	public Student getStudent(int n) {
		return liste.get(n);
	}
	
	//sjekker svarresultatet på en bestemt elev på trinnet
	public boolean getSvarResultatStudent(int i) {
		return getStudent(i).getSvarResultat();
	}
	
	
	
	
	
	//sjekker antall karakterer på trinnet totalt, riktig nok KUN i et bestemt fag
	public ArrayList<Integer> antallKarakter(int tall){
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		
		ArrayList<Integer> antall = new ArrayList<Integer>();
		
		
		for (int i = 0; i < getAntall(); i++) {
			
			if (tall == 1) {
				if (100 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 89) {
					a++;
				}
				if (88 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 77) {
					b++;
				}
				if (76 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 65) {
					c++;
				}
				if (64 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 53) {
					d++;
				}
				if (52 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 41) {
					e++;
				}
				if (40 >= getStudent(i).getScore1() && getStudent(i).getScore1() >= 0) {
					f++;
				}	
			}
			
			
			
			if (tall == 2) {
				if (100 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 89) {
					a++;
				}
				if (88 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 77) {
					b++;
				}
				if (76 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 65) {
					c++;
				}
				if (64 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 53) {
					d++;
				}
				if (52 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 41) {
					e++;
				}
				if (40 >= getStudent(i).getScore2() && getStudent(i).getScore2() >= 0) {
					f++;
				}	
			}
			
			
			if (tall == 3) {
				if (100 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 89) {
					a++;
				}
				if (88 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 77) {
					b++;
				}
				if (76 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 65) {
					c++;
				}
				if (64 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 53) {
					d++;
				}
				if (52 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 41) {
					e++;
				}
				if (40 >= getStudent(i).getScore3() && getStudent(i).getScore3() >= 0) {
					f++;
				}
			}
		}
		antall.add(a);
		antall.add(b);
		antall.add(c);
		antall.add(d);
		antall.add(e);
		antall.add(f);
		return antall;
	}



	//returnerer en liste med alle mulige karakterer
	public ArrayList<Character> getListeKarakter(){
		ArrayList<Character> karakter = new ArrayList<Character>();
		karakter.add('A');
		karakter.add('B');
		karakter.add('C');
		karakter.add('D');
		karakter.add('E');
		karakter.add('F');
		return karakter;
	}


	//metode som returner en liste med gjennomsnittet i poeng til klassen i hvert enkelt fag
	public ArrayList<Integer> getGjennomsnitt(){
		ArrayList<Integer> gjennomsnitt = new ArrayList<Integer>();
		int r1 = 0;
		int r2 = 0;
		int fysikk = 0;
		
		
		for (int i = 0; i < getAntall(); i++) {
			int x = getStudent(i).getScore1();
			r1 = r1 + x;
			
			int y = getStudent(i).getScore2();
			r2 = r2 + y;
			
			int z = getStudent(i).getScore3();
			fysikk = fysikk + z;
		}
		
		int gjennomsnittr1 = r1 / getAntall();
		int gjennomsnittr2 = r2 / getAntall();
		int gjennomsnittfysikk = fysikk / getAntall();
		
		gjennomsnitt.add(gjennomsnittr1);
		gjennomsnitt.add(gjennomsnittr2);
		gjennomsnitt.add(gjennomsnittfysikk);
		
		return gjennomsnitt;
		
	}

	
	
	//metode som returner en liste med gjennomsnittet i karakterer til klassen i hvert enkelt fag
	public ArrayList<Character> getGjennomsnittKarakter(){
		ArrayList<Character> gjennomsnittkarakter = new ArrayList<Character>();
		for (int i = 0; i < 3; i++) {
			char x = Student.Int2Char2(getGjennomsnitt().get(i));
			gjennomsnittkarakter.add(x);
		}
		return gjennomsnittkarakter;
	}

	
	
	//returner en liste
	//metode for å sortere trinnet basert på gjennomsnittet. Den som har høyest gjennomsnitt er først i lista
	public ArrayList<Student> Sorter() {
		ArrayList<Student> sorted = new ArrayList<Student>();
		for (Student s : getListe()) {
			boolean uferdig = true;
			int iter = 0;
			
			while (uferdig) {
				if (sorted.isEmpty()) {
					sorted.add(s);
					uferdig = false;
				}
				else if (sorted.size() <= iter) {
					sorted.add(s);
					uferdig = false;
				}
				else if (s.getAverage() >= sorted.get(iter).getAverage()) {
					sorted.add(iter, s);
					uferdig = false;
				}
				iter += 1;
			}				
		}
		return sorted;	
	}
	
	//metode som bruker den sorterte lista med studenter, og returner en ny liste med studentiden til studentene rangert etter gjennomsnitt
	public ArrayList<Integer> SorterPlasser() {
		ArrayList<Integer> sorter = new ArrayList<Integer>();
		for (Student s: Sorter()) {
			sorter.add(s.getStudentid());
	}
		return sorter;
	}

	   
	//returner en liste med et element, som viser plassen til en bestemt student i den sorterte lista
	public ArrayList<Integer> MinPlass(int n) {
		ArrayList<Integer> minplass = new ArrayList<Integer>();
		int p = SorterPlasser().indexOf(n);
		minplass.add(p);
		return minplass;
	}
	
	
	//Returner en liste som viser studier studenten sannsynligvis kan komme inn på, antar at de beste søker indøk, nest best kyb ovs
	public ArrayList<String> MineStudier(int n){
		ArrayList<String> minestudier = new ArrayList<String>();
		minestudier = studier.StudierListe();
		int plass = MinPlass(n).get(0);
		
		if (plass < 15 ) {
			return minestudier;
		}
		else if (plass < 30 ) {
			for (int i = 0; i < 1; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else if (plass < 45 ) {
			for (int i = 0; i < 2; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else if (plass < 60 ) {
			for (int i = 0; i < 3; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else if (plass < 75 ) {
			for (int i = 0; i < 4; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else if (plass < 90 ) {
			for (int i = 0; i < 5; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else if (plass < 105 ) {
			for (int i = 0; i < 6; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
		else {
			for (int i = 0; i < 7; i++) {
				minestudier.remove(0);
			}
			return minestudier;
		}
	}
	
	//metode som lager 22 trinn, med trinnid fra og med 2000 til og med 2021. Lager årskull fra år 2000 til 2021
	public static ArrayList<Trinnet> makeTrinn() {
		for (int i = 2000; i < 2022; i++) {
			trinnliste.add(new Trinnet(120, i));
		} 
		return trinnliste;
	}
	
	//returner lista med alle trinne/årskullene
	public ArrayList<Trinnet> getTrinnListe(){
		return trinnliste;
	}

	//getter for å finne et bestemt trinn/årskull
	public Trinnet getTrinnet(int i) {
		return getTrinnListe().get(i-2000);
	}



}
