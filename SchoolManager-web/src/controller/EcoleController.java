package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Classe;
import entities.Droit;
import entities.Ecole;
import entities.Enseignant;
import entities.TypeEcole;
import services.EcoleServices;
import services.impl.EcoleServicesImpl;

@ManagedBean
@SessionScoped
public class EcoleController {
	
	private Ecole ecole = new Ecole();
	private int idEnseignant;
	 
	@EJB
	private EcoleServices service;
 
	public Ecole getEcole() {
		return ecole;
	}
	
	public Ecole getEcole(int idEcole) {
		return service.getEcole(idEcole);
	}

	
	public List<Ecole> getEcoles(){
		return service.getEcoles();
	}
	
	public String updateEcole(Ecole ecole, int idEnseignant){
		service.updateEcole(ecole, idEnseignant);
		return "ListeEcoles";
	}
	
	public String detailsEcole(int idEcole){
		this.ecole = service.getEcole(idEcole);
		return "DetailsEcole";
	}
	
	public List<Enseignant> getListEnseignants(){
		return service.getListEnseignants();
	}

	public int getIdEnseignant() {
		return idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public List<TypeEcole> getListTypeEcole(int idEcole){
		return service.getListTypeEcole(idEcole);
	}
	
}
