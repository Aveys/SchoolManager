package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Famille;
import entities.Enfant;
import entities.User;
import services.FamilleServices;
import services.DroitServices;
import services.EcoleServices;
import services.EnfantServices;
import services.EnseignantServices;
import services.NiveauServices;
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
}
