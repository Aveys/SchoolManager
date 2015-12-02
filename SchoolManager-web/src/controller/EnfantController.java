package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import entities.Classe;
import entities.Enfant;
import entities.User;
import services.impl.ClasseServicesImpl;
import services.impl.EnfantServicesImpl;

@ManagedBean
@SessionScoped
public class EnfantController {
	

	@EJB
	private EnfantServicesImpl enfServ;
	
	@EJB
	private ClasseServicesImpl claServ;
	
	private List<Enfant> filteredEnfants;
	private Enfant enfant = new Enfant();
	
	public List<Enfant> listEnfants() {
		return enfServ.getListEnfant();
	}
	
//	public String getClasse(Classe cla) {
//		System.out.println(cla.getIdClasse());
//		System.out.println("before service getclasse");
//		System.out.println(claServ.getClasse(1));
//		return Integer.toString(claServ.getClasse(cla.getIdClasse()).getNumClasse());
//	}
//	
	public List<Classe> getClasses() {
		return (claServ.getListClasses());
	}

	public List<Enfant> getFilteredEnfants() {
		return filteredEnfants;
	}

	public void setFilteredEnfants(List<Enfant> filteredEnfants) {
		
		this.filteredEnfants = filteredEnfants;
	}

	
	public List<Integer> getNumClasses() {
		return claServ.getNumListClasses();
	}
	
	public String detailsEnfant(Integer idPersonne){
		this.setEnfant(enfServ.findEnfant(idPersonne));
		return "DetailsEnfant";
	}
	
	public String updateEnfant(Enfant updatedEnfant){
		enfServ.updateEnfant(updatedEnfant);
		return "ListeEnfants";
	}
	
	public String removeEnfant(Integer idPersonne){
		enfServ.removeEnfant(idPersonne);
		return "ListeEnfants";
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
}
