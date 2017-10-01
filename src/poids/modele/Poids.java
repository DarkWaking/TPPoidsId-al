package poids.modele;

import java.text.DecimalFormat;
public class Poids {
	private float circonference	;
	private int taille;
	private int age;
	private double coefficient;
	
	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	private final DecimalFormat df = new DecimalFormat("##0.000 kg");
	
	public Poids(float circonference, int taille){
		this.circonference = circonference;
		this.setTaille(taille);
	}
	
	public Poids(int taille, int age, double coefficient){
		this.setTaille(taille);
		this.age = age;
		this.coefficient = coefficient;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getCirconference() {
		return circonference;
	}

	

	public void setCirconference(float circonference) {
		this.circonference = circonference;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public double calculPoids() {
	double poids;
	
	poids = ((taille-100) + (4*circonference)) / 2;
	return poids;
	}
	
	public double calculPoidsMC() {
		double poids;
		
		poids = ((taille-100) + (age/10)*coefficient);
		return poids;
	}
	
	@Override
	public String toString() {
	final String MSG = "Votre poids idéal : ";
	return MSG + df.format(calculPoids());
	}
	
	

}
