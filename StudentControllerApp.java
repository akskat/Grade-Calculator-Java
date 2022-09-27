package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentControllerApp extends Application{
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Forkurs ingeniør NTNU");
		Parent root = FXMLLoader.load(getClass().getResource("Brukergrensesnitt.fxml"));
		Scene scene = new Scene(root);
		scene.setRoot(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}
	
}


