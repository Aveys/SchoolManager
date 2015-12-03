package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Planning;
import services.PlanningServices;

@Stateful
@LocalBean
public class PlanningServicesImpl implements PlanningServices{

	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public List<Planning> getListPlanning(int idClasse) {
		
		Query query = em.createQuery("SELECT p FROM Planning P WHERE id_classe = :idClasse")
		.setParameter("idClasse", idClasse);
		
		em.flush();
		
		return query.getResultList();
	}

	@Override
	public void mergePlanning(Planning planning) {

		em.persist(planning);
		em.flush();
	}

}
