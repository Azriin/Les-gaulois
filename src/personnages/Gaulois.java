package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public String getNom() {
		return nom;
	}

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain romain = new Romain("Romulus", 2);
		asterix.parler("Je suis asterix le gauloi !");
		asterix.frapper(romain);
	}
}

