package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Ecole;
import services.EcoleServices;


@Stateful
@LocalBean
public class EcoleServicesImpl implements EcoleServices {

	@PersistenceContext(name = "SchoolManager-Web")
	private EntityManager em;
	
	/**
	 * Retourne une ecole en fonction d'un ID
	 */
	@Override
	public Ecole getEcole(int idEcole) {
		/**
		 * Requete JPA
		 */
		Ecole ecole = (Ecole) em.createQuery("SELECT e From Ecole e Where e.id_ecole = :id")
				.setParameter("id", idEcole)
				.setMaxResults(1)
				.getSingleResult();
		if(ecole == null)System.out.println("!! Aucune �cole trouv�e !!");
		return ecole;
	}

	@Override
	public void addEcole(Ecole ecole) {
		em.persist(ecole);
	}

	@Override
	public List<Ecole> getEcoles() {
		Query query = em.createQuery("SELECT e FROM Ecole e");
		return query.getResultList();
	}

	@Override
	public void updateEcole(Ecole ecole) {
		
		int idEcole = ecole.getIdEcole();
		Ecole oldEcole = getEcole(idEcole);
		
		oldEcole.setNomEtablissement(ecole.getNomEtablissement());
		oldEcole.setAdresse(ecole.getAdresse());
		oldEcole.setEmail(ecole.getEmail());
		oldEcole.setFax(ecole.getFax());
	}

	
}
