package personnages;

public enum Equipement {
	CASQUE("caque"), BOUCLIER("bouclier");
	private String nom;

	@Override
	public String toString() {
//		pas sur de mon coup
		return nom;
	}
	
	private Equipement(String nom) {
		this.nom = nom;
	}
	
}
