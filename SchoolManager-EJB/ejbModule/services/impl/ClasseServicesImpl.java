package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Classe;
import entities.Droit;
import entities.Ecole;
import entities.Enseignant;
import entities.Niveau;
import entities.User;
import services.ClasseServices;

@Stateful
@LocalBean
public class ClasseServicesImpl implements ClasseServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Classe getClasse(Integer id) {
		Classe classe = (Classe) em.createQuery("SELECT u From Classe u Where u.idClasse LIKE :id")
				.setParameter("id", id);
		
		if(classe == null)System.out.println("!! Aucune classe trouvé !!");
		
		return classe;
	}
	
	
	/***
	 * Retrouve un utilisateur par son id
	 */
	@Override
	public Classe findClasse(int idClasse) {
		
		Classe classe = em.find(Classe.class, idClasse);
		em.flush();
		return classe;
	}

	@Override
	public void addClasse(Classe classe, int idEcole, int idEnseignant, int idNiveau) {
		
		 Ecole ecole = em.getReference(Ecole.class, idEcole);
		 Enseignant enseignant = em.getReference(Enseignant.class, idEnseignant);
		 Niveau niveau = em.getReference(Niveau.class, idNiveau);
		classe.setTEEcoleEco(ecole);
		classe.setTEEnseignantEn(enseignant);
		classe.setTRNiveauNiv(niveau);
		System.out.println("Classe Service - Enregistrement d'une classe");
		em.persist(classe);
		System.out.println("Classe Service - Fin de l'enregistrement");
		
	}

	@Override
	public List<Classe> getListClasses() {
		Query query = em.createQuery("SELECT u FROM Classe u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}
	
	public void updateClasse(Classe classe, int idEcole, int idEnseignant, int idNiveau) {
		 Ecole ecole = em.getReference(Ecole.class, idEcole);
		 Enseignant enseignant = em.getReference(Enseignant.class, idEnseignant);
		 Niveau niveau = em.getReference(Niveau.class, idNiveau);
		classe.setTEEcoleEco(ecole);
		classe.setTEEnseignantEn(enseignant);
		classe.setTRNiveauNiv(niveau);
		em.merge(classe);
		
	}
	
	@Override
	public void removeClasse(int idClasse) {
		Classe classe = findClasse(idClasse);
		em.remove(classe);
	}


	@Override
	public List<Integer> getNumListClasses() {
		List<Classe> lc = getListClasses();
		List<Integer> lnc = new ArrayList<Integer>();
		for (Classe cla: lc) {
			lnc.add(cla.getNumClasse());
		}
		return lnc;
	}
	
	
	
	
	@Override
	public List<Integer> getIdListClasses() {
		List<Classe> lc = getListClasses();
		List<Integer> lnc = new ArrayList<Integer>();
		for (Classe cla: lc) {
			lnc.add(cla.getIdClasse());
		}
		return lnc;
	}
	
	

}
