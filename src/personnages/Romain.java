package personnages;

public class Romain {
	private String nom;
	private int force;
	
	private int nbEquipements = 0;
	private Equipement equipements[];
	
	public Romain(String nom, int force) {
		assert force >= 0 :"la force d’un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
		
		equipements = new Equipement[2];
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
	
	private void parleEquipement(String equipement) {
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 0: {
			parleEquipement(equipement.toString());
			equipements[0] = equipement;
			nbEquipements += 1;
			break; 
		}
		case 1: {
			if (equipements[0] != equipement) {
				parleEquipement(equipement.toString());
				equipements[1] = equipement;
				nbEquipements += 1;
			} else {
				System.out.println("Le soldat " + nom + " possède déjà un " + equipement.toString() + " !");
			}
			break; 
		}
		default:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break; 
		}
	}
	
	public static void main(String[] args) {
		Romain romulus = new Romain("romulus", 6);
		romulus.parler("je suis un romain");
		
		romulus.sEquiper(Equipement.CASQUE);
		romulus.sEquiper(Equipement.CASQUE);
		romulus.sEquiper(Equipement.BOUCLIER);
		romulus.sEquiper(Equipement.CASQUE);
		
//		romulus.recevoirCoup(2);
//		romulus.recevoirCoup(5);
	}
}
