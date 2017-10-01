package poids;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import poids.vue.RootLayoutControlleur;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private AnchorPane Formule;
	
	/**
	* Constructor
	 * @throws IOException 
	*/
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Poids idéal");
		// Set the application icon.
	    this.primaryStage.getIcons().add(new Image("file:resources/Images/Poids.png"));
		initRootLayout();
		
	}

	private void initRootLayout() {
		try {
			// Load root layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("vue/RootLayout.fxml"));
			 rootLayout = (BorderPane)loader.load();
			// Show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			RootLayoutControlleur controller = loader.getController();
	        controller.setMainApp(this);
			
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void showFormuleMD() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("./vue/VuePoidsMD.fxml"));
	    Formule = loader.load();
		rootLayout.setCenter(Formule);
		primaryStage.setTitle("Poids idéal - Méthode Monnerot-Dumaine");
		
		
	}

	
	
	public void showFormuleMC() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("vue/VuePoidsMC.fxml"));
		Formule = loader.load();
		rootLayout.setCenter(Formule);
		primaryStage.setTitle("Poids idéal - Méthode CREFF");
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
