package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import entities.Classe;
import entities.Ecole;
import entities.Enfant;
import entities.Famille;
import entities.Sexe;
import entities.Tuteur;
import entities.User;
import services.impl.ClasseServicesImpl;
import services.impl.EnfantServicesImpl;
import services.impl.FamilleServicesImpl;
import services.impl.SexeServicesImpl;
import services.impl.TuteurServicesImpl;

@ManagedBean
@SessionScoped
public class EnfantController {
	

	@EJB
	private EnfantServicesImpl enfServ;
	
	@EJB
	private ClasseServicesImpl claServ;
	
	@EJB
	private FamilleServicesImpl famServ;
	
	@EJB
	private TuteurServicesImpl tutServ;
	
	@EJB
	private SexeServicesImpl sexServ;
	
	
	private List<Enfant> filteredEnfants;
	private Enfant enfant = new Enfant();
	
	
	//attribut pour enfant
	private Integer idSexe, idFamille, idClasse;
	
	
	
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
	
	public List<Integer> getIdClasses() {
		return claServ.getIdListClasses();
	}
	
	public String detailsEnfant(Integer idPersonne){
		this.setEnfant(enfServ.findEnfant(idPersonne));
		return "DetailsEnfant";
	}
	
	
	public String ajouterEnfant(Enfant enfant, Integer idFamille, Integer idClasse, Integer idSexe) {
		
		enfServ.addEnfant(enfant, idFamille, idClasse, idSexe);
		return "ListeEnfants";
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
	
	//renvoie les tuteurs
	public List<String> getNomFamilles() {
		List<Famille> listFam = famServ.getListFamilles();
		//return famServ.getNomFamilles();
		List<String> listNom = new ArrayList<String>();
		
		for (Famille fam : listFam) {
			listNom.add(fam.getTETuteurTut1().getNom());
		}
		
		
		return listNom;
	}
	
	public List<Famille> getFamilles() {
		return famServ.getListFamilles();
	}

	public Integer getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(Integer idSexe) {
		this.idSexe = idSexe;
	}

	public Integer getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(Integer idFamille) {
		this.idFamille = idFamille;
	}

	public Integer getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}

	
}
