package services;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServices {
	
	public User getUser(String mail, String motDePasse);
	public void addUser(User user, int idDroit);
	public List<User> getListUser();
	public void updateUser(User user);
}
