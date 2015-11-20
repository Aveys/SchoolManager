package services.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Droit;
import entities.User;
import services.UserServices;

@Stateful
@LocalBean
public class UserServicesImpl implements UserServices{

	@PersistenceContext(name = "SchoolManager-Entity")
	private EntityManager em;
	
	/***
	 * Retourne l'utilisateur correspondant aux mdp et mail donn�s
	 */
	@Override
	public User getUser(String mail, String motDePasse) {
		
		//Requète JPA
		User user = (User)em.createQuery("SELECT u From User u Where u.mail LIKE :mail AND u.motDePasse LIKE :mdp ")
				.setParameter("mail", mail)
				.setParameter("mdp", motDePasse)
				.setMaxResults(1)
				.getSingleResult();
		
		if(user == null)System.out.println("!! Aucun utilisateur trouv� !!");
		
		return user;
	}

	@Override
	public void addUser(User user, int idDroit) {
		
		Droit droit = em.getReference(Droit.class, idDroit);
		user.setTRDroitsDro(droit);
		em.persist(user);
		
	}

	@Override
	public List<User> getListUser() {
		
		Query query = em.createQuery("SELECT u FROM User u");
		return query.getResultList();
		
	}

	@Override
	public void updateUser(User user) {
		//
		User oldUser = em.find(User.class,user.getIdUser());
		
		//Met à jour les champs de l'entit�
		oldUser.setMail(user.getMail());
		oldUser.setMotDePasse(user.getMotDePasse());
		oldUser.setNom(user.getNom());
		oldUser.setPrenom(user.getPrenom());
		oldUser.setTRDroitsDro(user.getTRDroitsDro());
		
		em.getTransaction().commit();
		
	}

}
