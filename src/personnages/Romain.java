package personnages;

public class Romain {
	private String nom;
	private int force;
	
	
	public Romain(String nom, int force) {
		assert force >= 0 :"la force d’un Romain est toujours positive";
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
		assert force >= 0: "la force d’un Romain est positive";
		int forcePreCondition = force;		
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force <= forcePreCondition : "la force d’un Romain a diminué";
	}
	
	public static void main(String[] args) {
		Romain romulus = new Romain("romulus", 6);
		romulus.parler("je suis un romain");
		romulus.recevoirCoup(1);
		romulus.recevoirCoup(5);
	}
}
