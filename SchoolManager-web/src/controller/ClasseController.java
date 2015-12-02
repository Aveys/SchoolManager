package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Classe;
import entities.Enfant;
import entities.User;
import services.ClasseServices;
import services.DroitServices;
import services.EcoleServices;
import services.EnfantServices;
import services.EnseignantServices;
import services.NiveauServices;
import services.UserServices;
import services.impl.ClasseServicesImpl;

@ManagedBean
@SessionScoped
public class ClasseController {
	
	
	 
	@EJB
	private ClasseServices service;
	
	@EJB
	private EcoleServices ecoleService;

	@EJB
	private NiveauServices niveauService;

	@EJB
	private EnseignantServices enseignantService;
	
	@EJB
	private EnfantServices enfantService;

	
	private Classe classe = new Classe();
	private int idEnseignant;
	private int idEcole;
	private int idNiveau;
	private List<Enfant> listEnfants;
	
	
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
	
	public String updateClasse(Classe classe, int idEcole, int idEnseignant, int idNiveau){
		System.out.println("Modification d'une classe ____ "+classe.getIdClasse()+" "+idEcole);
		service.updateClasse(classe, idEcole, idEnseignant, idNiveau);
		
		return "ListeClasses";
	}
	
	public String detailsClasse(int idClasse){
		
		
		classe = service.findClasse(idClasse);
		idEcole = classe.getTEEcoleEco().getIdEcole();
		idEnseignant = classe.getTEEnseignantEn().getIdEnseignant();
		idNiveau = classe.getTRNiveauNiv().getIdNiveau();
		return "DetailsClasse";
	}
	
	public String removeClasse(int idClasse){
		String ret  = "ListeClasse";
		System.out.println("_____ ClasseController _______ Nb Enfants dans liste" + enfantService.getListEnfantClasse(idClasse).size() );
		if (enfantService.getListEnfantClasse(idClasse).size() == 0 ) {
			service.removeClasse(idClasse);
			return "ListeClasse";
		}
		return detailsClasse(idClasse);
		
	}
	
	public List<Enfant> listEnfantsClasse(int idClasse) {
		return enfantService.getListEnfantClasse(idClasse);
	}


	public List<Enfant> getListEnfants() {
		return listEnfants;
	}


	public void setListEnfants(List<Enfant> listEnfants) {
		this.listEnfants = listEnfants;
	}
	
	public int getNombreEleves(int idClasse) {
		int ret = 0;
		
		ret = listEnfantsClasse(idClasse).size();
		return ret;
	}
}
