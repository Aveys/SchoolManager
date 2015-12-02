package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Famille;
import services.FamilleServices;


@Stateful
@LocalBean
public class FamilleServicesImpl implements FamilleServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Famille getFamille(int id) {
		Famille famille = (Famille)em.createQuery("SELECT u From Famille u Where u.id LIKE :id")
				.setParameter("id", id);
		
		if(famille == null)System.out.println("!! Aucune famille trouvé !!");
		
		return famille;
	}
	
	
	/***
	 * Retrouve la famille par son id
	 */
	@Override
	public Famille findFamille(int idFamille) {
		
		Famille famille = em.find(Famille.class, idFamille);
		em.flush();
		return famille;
	}

	

	@Override
	public List<Famille> getListFamilles() {
		Query query = em.createQuery("SELECT u FROM Famille u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}


	@Override
	public void removeFamille(int idClasse) {
		// TODO Auto-generated method stub
		
	}
}
