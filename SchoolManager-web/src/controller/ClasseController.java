package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Classe;
import entities.User;
import services.ClasseServices;
import services.DroitServices;
import services.EcoleServices;
import services.EnseignantServices;
import services.NiveauServices;
import services.UserServices;
import services.impl.ClasseServicesImpl;

@ManagedBean
public class ClasseController {
	
	
	 
	@EJB
	private ClasseServices service;
	
	@EJB
	private EcoleServices ecoleService;

	@EJB
	private NiveauServices niveauService;

	@EJB
	private EnseignantServices enseignantService;

	
	private Classe classe = new Classe();
	private int idEnseignant;
	private int idEcole;
	private int idNiveau;
	
	public Classe getClasse() {
		return classe;
	}

	
	public List<Classe> getListClasses(){
		return service.getListClasses();
	}
	
	
	
	
	
	public int getIdEnseignant() {
		return idEnseignant;
	}


	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}


	public int getIdEcole() {
		return idEcole;
	}


	public void setIdEcole(int idEcole) {
		this.idEcole = idEcole;
	}


	public int getIdNiveau() {
		return idNiveau;
	}


	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}


	public String saveClasse(Classe classe, int idEcole, int idEnseignant, int idNiveau){
		System.out.println("Enregistrement d'une classe");
		service.addClasse(classe, idEcole, idEnseignant, idNiveau);
		
		return "ListeClasses";
	}
}
