package poids.vue;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import poids.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Valentin Vanderstock
 */
public class RootLayoutControlleur {

    // Reference to the main application
    private MainApp mainApp;


    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    

    @FXML
       private void goFormuleMD () throws IOException {
       	mainApp.showFormuleMD();
       }
       
    
   
    @FXML
    private void goFormuleMC() throws IOException {
    	mainApp.showFormuleMC();
    }
    
    
    
    
    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Calcul du Poids Idéal");
        alert.setHeaderText("A propos");
        alert.setContentText("Auteur: Vanderstock Valentin");

        alert.showAndWait();
    }
    
    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}