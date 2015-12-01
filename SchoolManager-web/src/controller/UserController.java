package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entities.Droit;
import entities.User;
import model.LoginSubmission;
import services.DroitServices;
import services.UserServices;
import services.impl.UserServicesImpl;

@ManagedBean(name="userController")
@SessionScoped
public class UserController {

	@EJB
	private UserServices userService;

	@EJB
	private DroitServices droitService;
	private LoginSubmission loginSubmission = new LoginSubmission();
	private User user = new User();
	private int idDroit = 2;
	private List<User> filteredUsers;
	
	public String checkUser(LoginSubmission login){

		User user = userService.getUser(login.getMail(), login.getMotDePasse());
		//System.out.println(user);
		if(user != null){
			 //récupère l'espace de mémoire de JSF
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            //place l'utilisateur dans l' espace  de mémoire de JSF

            sessionMap.put("loggedUser", user);
            //redirect the current page
        }
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
	
	public String saveUser(User user,int droit){
		userService.addUser(user,droit);
		
		return "ListeUtilisateurs";
	}
	
	public String detailsUtilisateur(int idUtilisateur){
		
		user = userService.findUser(idUtilisateur);
		
		return "DetailsUtilisateur";
	}
	
	public String updateUtilisateur(User updatedUser,int droit){
		
		userService.updateUser(updatedUser,droit);
		
		return "ListeUtilisateurs";
	}
	
	public String removeUtilisateur(int idUser){
		userService.removeUser(idUser);
		
		return "ListeUtilisateurs";
	}

	public List<Droit> listDroit(){
		return droitService.getListDroit();
	}
	
	public int getIdDroit(){
		return idDroit;
	}
	
	public void setIdDroit(int droit){
		idDroit = droit;
	}
	
	public User getUser(){
		return user;
	}
	
	public List<User> listUser() {
		return userService.getListUser();
	}

	public LoginSubmission getLoginSubmission() {
		return loginSubmission;
	}

	public void setLoginSubmission(LoginSubmission loginSubmission) {
		this.loginSubmission = loginSubmission;
	}
	public String logout(){
		
        //récupère l'espace de mémoire de JSF
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        //place l'utilisateur dans l' espace  de mémoire de JSF
        sessionMap.remove("loggedUser");
        //redirect the current page
        try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("loginPage.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "loginPage";
	}
	
	
	public List<User> getFilteredUsers() {
        return filteredUsers;
    }
 
    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
	
}
