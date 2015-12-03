package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Enseignant;
import services.EnseignantServices;

@Stateful
@LocalBean
public class EnseignantServicesImpl implements EnseignantServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Enseignant getEnseignant(int id) {
		Enseignant enseignant = (Enseignant)em.createQuery("SELECT u From Enseignant u Where u.id LIKE :id")
				.setParameter("id", id);
		
		if(enseignant == null)System.out.println("!! Aucune enseignant trouvé !!");
		
		return enseignant;
	}

	@Override
	public void addEnseignant(Enseignant enseignant) {

		em.persist(enseignant);
		
	}

	@Override
	public List<Enseignant> getListEnseignants() {
		Query query = em.createQuery("SELECT u FROM Enseignant u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public void removeEnseignant(int idEnseignant) {
		em.remove(getEnseignant(idEnseignant));
	}

}
