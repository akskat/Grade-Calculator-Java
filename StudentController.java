package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StudentController{
	
	
	//klasse-felt
	Student student;
	Studier studier;
	Trinnet trinnet;
	SkrivtilFil skrivetilfil;
	
	//diverse knapper og lister som blir brukt i FXML
	@FXML
	private Button knapp;
	@FXML
	private Button godta;
	@FXML
	private Button klage;
	@FXML
	private Button reset;
	@FXML
	private Button lagre;
	@FXML
	private Button skrive;
	@FXML
	private TextField input;
	@FXML
	private TextField årstall;
	@FXML
	private ListView<String> listefag;
	@FXML
	private ListView<String> listefaggjennomsnitt;
	@FXML
	private ListView<Integer> egetsnittpoeng;
	@FXML
	private ListView<Character> egetsnittkarakter;
	@FXML
	private ListView<Integer> listepoeng;
	@FXML
	private ListView<Character> listekarakter;
	@FXML
	private ListView<Character> listekarakterklassen;
	@FXML
	private ListView<Character> listekarakterklassen1;
	@FXML
	private ListView<Character> listekarakterklassen2;	
	@FXML
	private ListView<Integer> listeantallR1;
	@FXML
	private ListView<Integer> listeantallR2;
	@FXML
	private ListView<Integer> listeantallFysikk;
	@FXML
	private ListView<Integer> listegjennomsnittpoeng;
	@FXML
	private ListView<Character> listegjennomsnittkarakter;
	@FXML
	private ListView<String> listestudier;
	@FXML
	private ListView<Integer> listeplasser;
	@FXML
	private ListView<Integer> minplass;
	@FXML
	private ListView<String> minestudier;
	@FXML
	private ListView<String> listestudiersøke;
	
	
	//Metoder
	
	
	
	
	@FXML 
	int studenten(ActionEvent event) {
		//Oppretter først objektene skrivetilfil og studier, krever ingen input og er like i alle tilfeller
		this.skrivetilfil = new SkrivtilFil();
		this.studier = new Studier();
		//oppretter en bestemt student, studenten vi kommer til å bruke videre
		int i;
		if (input.getText().isEmpty()==true) {
			return 1000;
		}
		else {
			i = Integer.valueOf(input.getText());
			this.student = trinnet.getStudent(i);
			return i;
		}
	}
	@FXML 
	int årstallet() {
		//Oppretter hvilken trinn vi kommer til å bruke
		int i;
		if (årstall.getText().isEmpty()==true) {
			return 1000;
		}
		else {
			i = Integer.valueOf(årstall.getText());
			this.trinnet = new Trinnet(120,i);
			Trinnet.makeTrinn();
			this.trinnet = trinnet.getTrinnet(i);
			return i;
		}
	}
	
	
	@FXML
    void handleKnappAction(ActionEvent event) {
		//metode for hva som skjer når man trykker på "sjekk eksamensresultat"
    	knapp.setDisable(true);
    	if (trinnet.getSvarResultatStudent(studenten(event))==true) {
    		godta.setDisable(true);
    		klage.setDisable(true);
    	}
    }
	
	@FXML
    void handleKlageAction(ActionEvent event) {
		//metode for hva som skjer når man klager
		student.Klage();
		godta.setDisable(true);
		klage.setDisable(true);
		handleClearAction();
		handleMetoderAction(event);
    }
	
	@FXML
    void handleGodtaAction(ActionEvent event) {
		//metode for hva som skjer når man trykker på godta-knappen
		student.Godta();
		godta.setDisable(true);
		klage.setDisable(true);
    }
	
	@FXML
    void handleResetAction(ActionEvent event) {
		//metode for hva som skjer når man trykker på reset-knappen
		handleClearAction();
		input.setText(null);
		årstall.setText(null);
    	reset.setDisable(false);
    	knapp.setDisable(false);
    	godta.setDisable(false);
		klage.setDisable(false);
		skrive.setDisable(false);
		lagre.setDisable(false);
    }
	
	
	@FXML
	void handleClearAction() {
		//metode for å fjerne all input i listene. Gjøre listene tomme
		listepoeng.getItems().clear();	
		listekarakter.getItems().clear();
		egetsnittpoeng.getItems().clear();
		egetsnittkarakter.getItems().clear();
		minplass.getItems().clear();	
		minestudier.getItems().clear();
		listefag.getItems().clear();
		listekarakterklassen.getItems().clear();
		listeantallR1.getItems().clear();
		listeantallR2.getItems().clear();
		listeantallFysikk.getItems().clear();
		listefaggjennomsnitt.getItems().clear();
		listegjennomsnittpoeng.getItems().clear();
		listegjennomsnittkarakter.getItems().clear();
		listestudier.getItems().clear();
		listeplasser.getItems().clear();
	}
	
	
	
    @FXML
    void handleListePoengAction() {
    	//viser poengene i fagene til studenten
    	listepoeng.getItems().addAll(student.PoengListe());
    }
    @FXML
    void handleFagListeAction() {
    	//viser fagene til studenten
    	listefag.getItems().addAll(student.FagListe());	
    }
    @FXML
    void handleFagListeGjennomsnittAction() {
    	//viser fagene til klassen, samme som studenten selv
    	listefaggjennomsnitt.getItems().addAll(student.FagListe());	
    }
    @FXML
    void handleKarakterListeAction() {
    	//viser karakterene til studenten
    	listekarakter.getItems().addAll(student.ListeKarakter());
    }
    @FXML
    void handleKarakterKlassenListeAction() {
    	//viser karakterene til klassen
    	listekarakterklassen.getItems().addAll(trinnet.getListeKarakter());
    }   	
    @FXML
    void handleantallR1Action() {
    	//viser antall av karakterer i faget R1
    	listeantallR1.getItems().addAll(trinnet.antallKarakter(1));	
    }
    @FXML
    void handleantallR2Action() {
    	//viser antall av karakterer i faget R2
    	listeantallR2.getItems().addAll(trinnet.antallKarakter(2));	
    }
    @FXML
    void handleantallFysikkAction() {
    	//viser antall av karakterer i faget Fysikk
    	listeantallFysikk.getItems().addAll(trinnet.antallKarakter(1));	
    }
    @FXML
    void handleGjennomsnittPoengAction() {
    	//viser gjennomsnittet til klassen i poeng
    	listegjennomsnittpoeng.getItems().addAll(trinnet.getGjennomsnitt());		
    }
    @FXML
    void handleGjennomsnittKarakterAction() {
    	//viser gjennomsnittet til klassen i karakterer
    	listegjennomsnittkarakter.getItems().addAll(trinnet.getGjennomsnittKarakter());	
    }
    @FXML
    void handleListeStudierAction() {
    	//viser en liste av studier som finnes
    	listestudier.getItems().addAll(studier.StudierListe());	
    }
    @FXML
    void handleListePlasserAction() {
    	//viser hvor mange plasser det er på hvert enkelt studie
    	listeplasser.getItems().addAll(studier.PlasserListe());		
    }
    @FXML
    void handleMinPlassAction(ActionEvent event) {
    	//viser din plass i køen til å søke studie
    	minplass.getItems().addAll(trinnet.MinPlass(studenten(event)));	
    }
    @FXML
    void handleMineStudierAction(ActionEvent event) {
    	//viser de studiene du sannsynligvis kan komme inn på
    	minestudier.getItems().addAll(trinnet.MineStudier(studenten(event)));	
    }
    @FXML
    void handleEgetSnittPoengAction() {
    	//viser snittet til studenten i poeng
    	egetsnittpoeng.getItems().addAll(student.getAverageStudent());	
    }
    @FXML
    void handleEgetSnittKarakterAction() {
    	//viser snittet til studenten i karakter
    	egetsnittkarakter.getItems().addAll(student.getAverageStudentKarakter());	
    }
    
    @FXML
    void handleMetoderAction(ActionEvent event) {
    	//metode for å fylle inn alle listene
    	handleFagListeAction();
    	handleListePoengAction();
    	handleKarakterListeAction();
    	handleKarakterKlassenListeAction();
    	handleantallR1Action();
    	handleantallR2Action();
    	handleantallFysikkAction();
    	handleFagListeGjennomsnittAction();
    	handleGjennomsnittPoengAction();
    	handleGjennomsnittKarakterAction();
    	handleEgetSnittPoengAction();
    	handleEgetSnittKarakterAction();
    	handleListeStudierAction();
    	handleListePlasserAction();
    	handleMinPlassAction(event);
    	handleMineStudierAction(event);
    }
    
    @FXML
    void handleWriteAction() {
    	//metode for å skrive til fil
    	skrivetilfil.CreateFile();
    	skrivetilfil.Write(this.student, this.trinnet, this.studier);
    }
    @FXML
    void handleReadAction() {
    	//metode for å lese fra fil
    	skrivetilfil.Read(this.student, this.trinnet, this.studier);
    }
    @FXML
    void handleNyeVerdierAction() {
    	//metode for å lese fra fil hvilke verdier kan vil ha, og fyller inn disse verdiene i tekstboksene
    	handleReadAction();
    	input.setText(Integer.toString(skrivetilfil.getStudent1().getStudentid()));
		årstall.setText(Integer.toString(skrivetilfil.getTrinnet2().getTrinnid()));
    }
    
    
    
    
    
    
    
    //Metoder som brukes OnAction i FXML-fila
	
	@FXML
	public void initialize(ActionEvent event) {
		//metode for hva som skjer når du trykker "sjekk eksamensresultat"
		årstallet();
		studenten(event);
		handleKnappAction(event);
		handleMetoderAction(event);
	}
	
	@FXML
	public void godta(ActionEvent event) {
		//metode for hva som skjer når du trykker Godta
		handleGodtaAction(event);
	}
	@FXML
	public void klage(ActionEvent event) {
		//metode for hva som skjer når du trykker Klage
		handleKlageAction(event);
	}
	@FXML
	public void reset(ActionEvent event) {
		//metode for hva som skjer når du trykker Reset
		handleResetAction(event);
	}
	
	@FXML
	public void writeController(ActionEvent event) {
		//metode for hva som skjer når du trykker på Lagre mine karakterer
		lagre.setDisable(true);
		handleWriteAction();
	}
	@FXML
	public void readController(ActionEvent event) {
		//metode for hva som skjer når du trykker Hent mine karakterer
		skrive.setDisable(true);
		handleResetAction(event);
		handleNyeVerdierAction();
		initialize(event);
	}
	
	
}
