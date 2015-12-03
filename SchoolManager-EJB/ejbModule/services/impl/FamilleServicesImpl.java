package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Enfant;
import entities.Famille;
import entities.Niveau;
import entities.Tuteur;
import services.FamilleServices;


@Stateful
@LocalBean
public class FamilleServicesImpl implements FamilleServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Famille getFamille(Integer id) {
		Famille famille = (Famille) em.createQuery("SELECT u From Famille u Where u.idFamille = :id")
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
	public void updateFamille(Famille fam) {
		
		em.merge(fam);
		em.flush();
		
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
	
	@Override
	public void addFamille(Famille famille, int id_tuteur_1, int id_parent_1, int id_parent_2) {
	
		 Tuteur tuteur = em.getReference(Tuteur.class, id_tuteur_1);
		famille.setTETuteurTut1(tuteur);
		
		Tuteur parent_1 = em.getReference(Tuteur.class, id_parent_1);
		famille.setTETuteurTut2(parent_1);
		
		Tuteur parent_2 = em.getReference(Tuteur.class, id_parent_2);
		famille.setTETuteurTut3(parent_2);
	
		em.persist(famille);
	}
	

	
}
