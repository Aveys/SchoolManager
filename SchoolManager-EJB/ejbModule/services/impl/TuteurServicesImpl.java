package services.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Adresse;
import entities.Droit;
import entities.Ecole;
import entities.Enseignant;
import entities.Niveau;
import entities.Sexe;
import entities.SituationFamiliale;
import entities.Tuteur;
import entities.User;
import services.AdresseServices;
import services.TuteurServices;
import services.UserServices;

@Stateful
@LocalBean
public class TuteurServicesImpl implements TuteurServices {

	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Tuteur getTuteur(int idTuteur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tuteur> getListTuteurs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int addTuteur(Tuteur tuteur, int idAdresse, int idSexe, int idSituationFamiliale) {
		System.out.println("############################ Debut enregistrement d'un tuteur");
		System.out.println("___________ Enregistrement d'un tuteur : recup des classes des necessaires");
		Sexe sexe = em.getReference(Sexe.class, idSexe);
		SituationFamiliale sitFam = em.getReference(SituationFamiliale.class, idSituationFamiliale);
		Adresse adresse = em.getReference(Adresse.class, idAdresse);
		
		System.out.println("___________ Enregistrement d'un tuteur : set des classes");
		tuteur.setTRSexeSex(sexe);
		tuteur.setTRSituationFamilialeSifa(sitFam);
		tuteur.setTEAdresseAdr(adresse);
		
		em.persist(tuteur);
		em.flush();
		System.out.println("___________ Enregistrement d'un tuteur : Fin");
		return tuteur.getIdTuteur();
	}

}
