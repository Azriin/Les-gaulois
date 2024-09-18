package personnages;

public class Romain {
	private String nom;
	private int force;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String textes) {
		System.out.println(prendreParole() + "<< " + textes + ">>");
	}


	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		
	}
	
	public static void main(String[] args) {
		Romain romulus = new Romain("romulus", 3);
		romulus.parler("je suis un romain");
		romulus.recevoirCoup(1);
		romulus.recevoirCoup(5);
	}
}
