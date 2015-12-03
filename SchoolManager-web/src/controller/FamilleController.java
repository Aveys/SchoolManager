package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Famille;
import entities.Enfant;
import entities.User;
import services.FamilleServices;
import services.AdresseServices;
import services.DroitServices;
import services.EcoleServices;
import services.EnfantServices;
import services.EnseignantServices;
import services.NiveauServices;
import services.TuteurServices;
import services.UserServices;
import services.impl.FamilleServicesImpl;

@ManagedBean
@SessionScoped
public class FamilleController {

	@EJB
	private FamilleServices service;

	@EJB
	private EcoleServices ecoleService;

	@EJB
	private NiveauServices niveauService;

	@EJB
	private EnseignantServices enseignantService;

	@EJB
	private EnfantServices enfantService;
	
	@EJB
	private TuteurServices tuteurService;
	
	@EJB
	private AdresseServices adresseService;

	private Famille famille = new Famille();
	private int idEnseignant;
	private int idEcole;
	private int idNiveau;
	private List<Enfant> listEnfants;
	private List<Famille> triListFamille;

	public Famille getFamille() {
		return famille;
	}

	public List<Famille> getListFamilles() {
		return service.getListFamilles();
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

	public List<Enfant> getListEnfants() {
		return listEnfants;
	}

	public void setListEnfants(List<Enfant> listEnfants) {
		this.listEnfants = listEnfants;
	}

	public List<Famille> getTriListFamille() {
		return triListFamille;
	}

	public void setTriListFamille(List<Famille> triListFamille) {
		this.triListFamille = triListFamille;
	}
	public String getListeEnfants(int idFamille){
		Famille f = service.findFamille(idFamille);
		
		String ret = "";
		for (Enfant e : f.getTEEnfantsEnfs()){
			ret += e.getNom()+" "+e.getPrenom()+" | ";
		}
		return ret;
	}
	public String saveFamille(Famille famille, int id_situationFam_tuteur1,int id_situationFam_tuteur2, int id_situationFam_tuteur3, int id_sexe_tuteur1, int id_sexe_tuteur2, int id_sexe_tuteur3){
		System.out.println("######################################\nEnregistrement d'une famille");
		//System.out.println(famille);
		
		
		System.out.println("########### Enregistrement du tuteur");
		///Creation du 1er tuteur
		int idAdresse_tut_1 = adresseService.addAdresse(famille.getTETuteurTut1().getTEAdresseAdr());
		int idTuteur_1 = tuteurService.addTuteur(famille.getTETuteurTut1(), idAdresse_tut_1, id_sexe_tuteur1, id_situationFam_tuteur1);
		
		
		//Ajout de l'adresse du Parent 1
		int idAdresse_tut_2 = adresseService.addAdresse(famille.getTETuteurTut2().getTEAdresseAdr());
		int idTuteur_2 = tuteurService.addTuteur(famille.getTETuteurTut2(), idAdresse_tut_2, id_sexe_tuteur2, id_situationFam_tuteur2);
		
		System.out.println("###########  Enregistrement du parent 2");
		/// Ajout de l'adresse du Parent 2
		int idAdresse_tut_3 = adresseService.addAdresse(famille.getTETuteurTut3().getTEAdresseAdr());
		int idTuteur_3 = tuteurService.addTuteur(famille.getTETuteurTut3(), idAdresse_tut_3, id_sexe_tuteur3, id_situationFam_tuteur3);
		
		service.addFamille(famille, idTuteur_1, idTuteur_2, idTuteur_3);
		
		
		return "ListeFamilles";
	}
}
