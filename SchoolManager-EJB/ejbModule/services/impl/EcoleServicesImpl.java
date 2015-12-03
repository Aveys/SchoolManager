package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Classe;
import entities.Droit;
import entities.Ecole;
import entities.Enseignant;
import entities.TypeEcole;
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
		Ecole ecole = (Ecole) em.createQuery("SELECT e From Ecole e Where e.idEcole = :id")
				.setParameter("id", idEcole)
				.setMaxResults(1)
				.getSingleResult();
		if(ecole == null)System.out.println("!! Aucune �cole trouv�e !!");
		return ecole;
	}

	@Override
	public void addEcole(Ecole ecole, int idEnseignant) {
		Enseignant enseignant = em.getReference(Enseignant.class, idEnseignant);
		ecole.setTEEnseignantEn(enseignant);
		em.persist(ecole);
	}

	@Override
	public List<Ecole> getEcoles() {
		Query query = em.createQuery("SELECT e FROM Ecole e");
		return query.getResultList();
	}

	@Override
	public void updateEcole(Ecole ecole, int idEnseignant) {
		int idEcole = ecole.getIdEcole();
		Enseignant enseignant = em.getReference(Enseignant.class, idEnseignant);
		ecole.setTEEnseignantEn(enseignant);	
		em.merge(ecole);
		em.flush();
	}
	
	public List<Enseignant> getListEnseignants(){
		Query query = em.createQuery("SELECT e FROM Enseignant e");
		return query.getResultList();
	}

	@Override
	public List<TypeEcole> getListTypeEcole(int idEcole) {
		Query query = em.createQuery("SELECT te From TypeEcole te JOIN te.TEEcoleEcos e Where e.idEcole = :id")
				.setParameter("id", idEcole);
		//System.out.println(query.getResultList());
		return query.getResultList();
	}
	
	@Override
	public List<Classe> getListClasses(int idEcole){
		Query query = em.createQuery("SELECT c From Classe c JOIN FETCH c.TEEcoleEco e Where e.idEcole = :id")
				.setParameter("id", idEcole);
		//System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public void deleteEcole(int idEcole) {
		Query query = em.createQuery("DELETE FROM Ecole e WHERE e.idEcole = :id")
				.setParameter("id", idEcole);
		try{
			int rowCount = query.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
