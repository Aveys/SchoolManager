package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Droit;
import services.DroitServices;

@Stateful
@LocalBean
public class DroitServicesImpl implements DroitServices{

	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public List<Droit> getListDroit() {
		Query query = em.createQuery("SELECT d FROM Droit d");
		return query.getResultList();
	}

}
