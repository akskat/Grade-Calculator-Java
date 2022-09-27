package project;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SkrivtilFil implements brukerinterface{

	//felt for å senere hente ut objektene fra filene
	private  Student student1;
	private  Trinnet trinnet2;
	private  Studier studier3;

	
	//metoder for å kunne hente ut objektene fra filene
	public Student getStudent1() {
		return student1;
	}
	public Trinnet getTrinnet2() {
		return trinnet2;
	}
	public Studier getStudier3() {
		return studier3;
	}

	
	//metode for å skrive til fil
	public void Write(Student student, Trinnet trinnet, Studier studier) {
		//prøver å skrive til fil, tar inn objektene og legger de til en fil, overskriver hvis den er skrevet på fra før
        try {
            FileOutputStream f = new FileOutputStream(new File("./src/main/java//project/minekarakterer.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            // Write objects to file
            o.writeObject(student);
            o.writeObject(trinnet);
            o.writeObject(studier);

            o.close();
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
	
	//metode for å lese til fil
	public void Read(Student student, Trinnet trinnet, Studier studier) {
		
		//prøver å lese fra fila angitt, henter ut objektene og setter at de objektene man henter ut er lik feltene
	try {
		FileInputStream fi = new FileInputStream(new File("./src/main/java//project/minekarakterer.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Student student1 = (Student) oi.readObject();
        Trinnet trinnet2 = (Trinnet) oi.readObject();
        Studier studier3 = (Studier) oi.readObject();
        
        this.student1 = student1;
        this.trinnet2= trinnet2;
        this.studier3 = studier3;
        
        oi.close();
        fi.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("Error initializing stream");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
	}

	

	//metode for å lage en fil
	public void CreateFile() {
		//prøver å lage en fil, sjekker om den er laget og hvis ikke lager den fila
		try {
		      File fil = new File("./src/main/java//project/minekarakterer.txt");
		      if (fil.createNewFile()) {
		        System.out.println("Laget filen: " + fil.getName());
		      } 
		      else {
		        System.out.println("Filen eksisterer");
		      }
		} 
		catch (IOException excep) {
		      System.out.println("Noe gikk galt");
		      excep.printStackTrace();
		}
	}		
}
