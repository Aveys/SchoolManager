package services.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.User;
import services.UserServices;

public class UserServicesImpl implements UserServices{

	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	/***
	 * Retourne l'utilisateur correspondant aux mdp et mail donnés
	 */
	@Override
	public User getUser(String mail, String motDePasse) {
		
		//Requête JPA
		User user = (User)em.createQuery("SELECT u From User u Where u.mail LIKE :mail AND u.motDePasse LIKE :mdp ")
				.setParameter("mail", mail)
				.setParameter("mdp", motDePasse)
				.setMaxResults(1)
				.getSingleResult();
		
		if(user == null)System.out.println("!! Aucun utilisateur trouvé !!");
		
		return user;
	}

	@Override
	public void addUser(User user) {
		
		em.persist(user);
		
	}

	@Override
	public List<User> getListUser() {
		
		Query query = em.createQuery("SELECT u FROM User u");
		return query.getResultList();
		
	}

}
