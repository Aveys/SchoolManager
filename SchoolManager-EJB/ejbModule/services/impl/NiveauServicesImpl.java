package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Niveau;
import services.NiveauServices;

@Stateful
@LocalBean
public class NiveauServicesImpl implements NiveauServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	public Niveau getNiveau(int id) {
		Niveau Niveau = (Niveau)em.createQuery("SELECT u From Niveau u Where u.id LIKE :id")
				.setParameter("id", id);
		
		if(Niveau == null)System.out.println("!! Aucune Niveau trouvé !!");
		
		return Niveau;
	}

	public void addNiveau(Niveau niveau) {

		em.persist(niveau);
		
	}

	public List<Niveau> getListNiveaux() {
		Query query = em.createQuery("SELECT u FROM Niveau u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}
