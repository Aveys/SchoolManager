package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Classe;
import services.ClasseServices;

@Stateful
@LocalBean
public class ClasseServicesImpl implements ClasseServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Classe getClasse(int id) {
		Classe classe = (Classe)em.createQuery("SELECT u From Enfant u Where u.id LIKE :id")
				.setParameter("id", id);
		
		if(classe == null)System.out.println("!! Aucune classe trouvé !!");
		
		return classe;
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
