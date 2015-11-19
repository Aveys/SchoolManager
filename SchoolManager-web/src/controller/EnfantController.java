package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Enfant;
import services.impl.ClasseServicesImpl;
import services.impl.EnfantServicesImpl;

@ManagedBean
public class EnfantController {
	

	@EJB
	private EnfantServicesImpl enfServ;
	
	public List<Enfant> listEnfants() {
		System.out.println("Enfant");
		return enfServ.getListEnfant();
	}
	
	public String getClasse(int id) {
		ClasseServicesImpl claServ = new ClasseServicesImpl();
		return Integer.toString(claServ.getClasse(id).getNumClasse());
	}

}
