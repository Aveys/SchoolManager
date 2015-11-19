package controller;

import java.util.List;

import entities.Enfant;
import services.impl.ClasseServicesImpl;
import services.impl.EnfantServicesImpl;

public class EnfantController {
	
	public List<Enfant> getEnfants() {
		EnfantServicesImpl enfServ = new EnfantServicesImpl();
		return enfServ.getListEnfant();
	}
	
	public String getClasse(int id) {
		ClasseServicesImpl claServ = new ClasseServicesImpl();
		return Integer.toString(claServ.getClasse(id).getNumClasse());
	}

}
