package services.impl;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
	 * Retourne l'utilisateur correspondant aux mdp et mail donnés
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
		em.flush();
		return user;
	}

	/***
	 * Ajoute un utilisateur au model
	 */
	@Override
	public void addUser(User user, int idDroit) {
		
		Droit droit = em.getReference(Droit.class, idDroit);
		user.setTRDroitsDro(droit);
		em.persist(user);
		em.flush();
		
	}

	/***
	 * Retourne la liste des utilisateur enregistrés dans la BDD
	 */
	@Override
	public List<User> getListUser() {
		
		Query query = em.createQuery("SELECT u FROM User u");
		em.flush();
		return query.getResultList();
		
	}
	
	/***
	 * Met à jour un utilisateur 
	 */
	@Override
	public void updateUser(User user, int idDroit) {
		//
		int idUser = user.getIdUser();

		Droit droit = em.getReference(Droit.class, idDroit);

		user.setTRDroitsDro(droit);	
		em.merge(user);
		em.flush();
	}

	/***
	 * Retrouve un utilisateur par son id
	 */
	@Override
	public User findUser(int idUser) {
		
		User user = em.find(User.class, idUser);
		em.flush();
		return user;
	}

	@Override
	public void removeUser(int idUser) {
		User user = findUser(idUser);
		
		em.remove(user);
		
	}

}
