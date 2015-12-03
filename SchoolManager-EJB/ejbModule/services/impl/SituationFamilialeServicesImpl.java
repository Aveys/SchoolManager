package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Niveau;
import entities.SituationFamiliale;
import services.NiveauServices;
import services.SituationFamilialeServices;

@Stateful
@LocalBean
public class SituationFamilialeServicesImpl implements SituationFamilialeServices{
	
	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;


	@Override
	public SituationFamiliale getSituation(int idSituation) {
		SituationFamiliale situation = (SituationFamiliale)em.createQuery("SELECT u From SituationFamiliale u Where u.id LIKE :id")
				.setParameter("id", idSituation);
		
		if(situation == null)System.out.println("!! Aucune sitation familiale trouvé !!");
		
		return situation;
	}

	@Override
	public List<SituationFamiliale> getListSituationFamiliale() {
		Query query = em.createQuery("SELECT u FROM SituationFamiliale u");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

}
