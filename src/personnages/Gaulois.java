package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

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
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] degat = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; degat != null && i < degat.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = degat[i];
		}
	}


	public void boirePotion(int forcePotion) {
		parler("Merci Druide, je sens que ma force est " + forcePotion +
		" fois decuplee.");
		effetPotion *= forcePotion;
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain romain = new Romain("Romulus", 10);
		asterix.parler("Je suis asterix le gauloi !");
		asterix.frapper(romain);
		asterix.boirePotion(5);
		asterix.frapper(romain);
	}
}

