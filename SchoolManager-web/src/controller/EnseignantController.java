package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Enseignant;
import services.EnseignantServices;
import services.impl.EnseignantServicesImpl;

@ManagedBean(name="enseignantController")
@SessionScoped
public class EnseignantController {
	
	private Enseignant enseignant = new Enseignant();
	
	private List<Enseignant> filteredEnseignants;
	 
	@EJB
	private EnseignantServices service;
 
	public Enseignant getEnseignant() {
		return enseignant;
	}

	
	public List<Enseignant> getListEnseignants(){
		return service.getListEnseignants();
	}


	public List<Enseignant> getFilteredEnseignants() {
		return filteredEnseignants;
	}


	public void setFilteredEnseignants(List<Enseignant> filteredEnseignants) {
		this.filteredEnseignants = filteredEnseignants;
	}
}
