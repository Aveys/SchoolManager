package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Adresse;
import entities.Classe;
import entities.Droit;
import entities.Ecole;
import entities.Enseignant;
import entities.Niveau;
import entities.User;
import services.AdresseServices;
import services.ClasseServices;

@Stateful
@LocalBean
public class AdresseServicesImpl implements AdresseServices {
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> getListAdresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addAdresse(Adresse adresse) {
		System.out.println("############################## Ajout d'une Adresse");
		em.persist(adresse);
		em.flush();
		return adresse.getIdAdresse();
	}

}
