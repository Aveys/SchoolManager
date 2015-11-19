package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Enfant;
import entities.User;
import services.EnfantServices;

@Stateful
@LocalBean
public class EnfantServiceImpl implements EnfantServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;

	@Override
	public Enfant getEnfant(String nom, String prenom) {
		Enfant enfant = (Enfant)em.createQuery("SELECT u From Enfant u Where u.nom LIKE :nom AND u.prenom LIKE :prenom ")
				.setParameter("nom", nom)
				.setParameter("prenom", prenom)
				.setMaxResults(1)
				.getSingleResult();
		
		if(enfant == null)System.out.println("!! Aucun enfant " + nom + " " + prenom + " trouvé !!");
		
		return enfant;
	}

	@Override
	public void addEnfant(Enfant enfant) {
		em.persist(enfant);
	}

	@Override
	public List<Enfant> getListEnfant() {
		Query query = em.createQuery("SELECT u FROM Enfant u");
		return query.getResultList();
	}

	@Override
	public List<Enfant> getListEnfantClasse(int idClasse) {
		Query query = em.createQuery("SELECT u FROM Enfant u WHERE u.id_classe LIKE :id").setParameter("id", idClasse);
		return query.getResultList();
	}

}
