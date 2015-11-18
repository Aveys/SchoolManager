package services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Classe;
import entities.User;
import services.ClasseServices;

public class ClasseServicesImpl implements ClasseServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public User getClasse(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClasse(Classe classe) {

		em.persist(classe);
		
	}

	@Override
	public List<Classe> getListClasse() {
		Query query = em.createQuery("SELECT u FROM Classe u");
		return query.getResultList();
	}

}
