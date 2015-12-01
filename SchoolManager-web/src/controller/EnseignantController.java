package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Enseignant;
import services.EnseignantServices;
import services.impl.EnseignantServicesImpl;

@ManagedBean
public class EnseignantController {
	
	private Enseignant enseignant = new Enseignant();
	 
	@EJB
	private EnseignantServices service;
 
	public Enseignant getEnseignant() {
		return enseignant;
	}

	
	public List<Enseignant> getListEnseignants(){
		return service.getListEnseignants();
	}
}
