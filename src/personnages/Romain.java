package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements = 0;

	
	public Romain(String nom, int force) {
		assert force >= 0 :"la force d�un Romain est toujours positive";
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert force >= 0: "la force d�un Romain est positive";
//		int forcePreCondition = force;		
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force <= forcePreCondition : "la force d�un Romain a diminu�";
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 1) {
			forceCoup = 1;
		} 
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		System.out.println("L'�quipement de " + this.nom + "s'envole sous la force du coup.");
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {
			if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] = equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
		}

	
	private void parleEquipement(String equipement) {
		System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipement + ".");
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
				System.out.println("Le soldat " + nom + " poss�de d�j� un " + equipement.toString() + " !");
			}
			break; 
		}
		default:
			System.out.println("Le soldat " + nom + " est d�j� bien prot�g� !");
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
