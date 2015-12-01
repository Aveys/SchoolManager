package services.impl;

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
import services.ClasseServices;

@Stateful
@LocalBean
public class ClasseServicesImpl implements ClasseServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	@Override
	public Classe getClasse(int id) {
		Classe classe = (Classe)em.createQuery("SELECT u From Classe u Where u.id LIKE :id")
				.setParameter("id", id);
		
		if(classe == null)System.out.println("!! Aucune classe trouvé !!");
		
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

}
