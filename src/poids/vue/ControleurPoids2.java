package poids.vue;

import javafx.scene.control.Label;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import poids.modele.Poids;

public class ControleurPoids2 {
	@FXML
	private Slider slidCirconf;
	@FXML
	private Label lCirconf;
	@FXML
	private Spinner<Integer> spinTaille;
	@FXML
	private Label lPoids;
	
	private Poids poids;
	
	/**
	* Le constructeur est appel� avant la m�thode initialize()
	* 
	*/
	public ControleurPoids2(){	
	}
	
	/**
	* Initialise le controleur. Cette m�thode est automatiquement appel�e
	* d�s que le fichier fxml est charg�.
	*/
	@FXML
	private void initialize() {
		// Initialise les donn�es au d�marrage.
		float circonference	= 18.2f;
		int taille = 160;
		
		poids = new Poids(circonference, taille);
		
		// Ecouteur sur le slider pour modifier le label quand la circonference change et recalcul du poids.
		slidCirconf.valueProperty().addListener((observable, oldValue, newValue)-> circonfChanged(newValue));
		// Ecouteur sur le spinner pour modifier la taille et refaire le calcul du poids.
		spinTaille.valueProperty().addListener((observable, oldValue, newValue)-> tailleChanged(newValue));
		
		// Initialise les composants de la vue
		slidCirconf.setValue(circonference);
		SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(150, 220,taille);
		spinTaille.setValueFactory(svf);
		lCirconf.setText(String.valueOf(circonference));
		calculEtAffichage();
	}
	
	
	/**
	* Est ex�cut�e pour calculer et afficher le poids.
	* 
	*/

	private void calculEtAffichage() {
		lPoids.setText(poids.toString());
		
	}
	
	/**
	* Est ex�cut�e lors du d�placement du Spinner pour la taille.
	* 
	* @param newTaille
	*/
	public void tailleChanged(int newTaille) {
	// on indique au mod�le que la taille vient de changer
	poids.setTaille(newTaille);
	// on recalcule le poids id�al qui s�affiche dans le composant
	calculEtAffichage();
	}
	
	/**
	* Est ex�cut�e lors du d�placement du Slider pour la circonf�rence du poignet.
	* 
	* @param newCirconf
	*/
	public void circonfChanged(Number newCirconf) {
		
		final DecimalFormat df1 = new DecimalFormat("00.0");
		poids.setCirconference(newCirconf.floatValue());
		lCirconf.setText(String.valueOf(df1.format(newCirconf.floatValue())));
		calculEtAffichage();
	}
	
	
}