package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Sexe;
import entities.Niveau;
import entities.Sexe;
import services.NiveauServices;
import services.SexeServices;

@Stateful
@LocalBean
public class SexeServicesImpl implements SexeServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;

	@Override
	public Sexe getSexe(int idSexe) {
		Sexe sexe = (Sexe)em.createQuery("SELECT u From Sexe u Where u.id LIKE :id")
				.setParameter("id", idSexe);
		
		if(sexe == null)System.out.println("!! Aucune Sexe trouvé !!");
		
		return sexe;
	}

	@Override
	public List<Sexe> getListSexe() {
		Query query = em.createQuery("SELECT u FROM Sexe u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}
	
	@Override
	public Sexe findSexe(int idSexe) {
		
		Sexe sexe = em.find(Sexe.class, idSexe);
		em.flush();
		return sexe;
	}
	
	
}
