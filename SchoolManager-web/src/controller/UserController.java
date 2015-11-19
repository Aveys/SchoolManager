package controller;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import entities.User;
import model.LoginSubmission;
import services.UserServices;
import services.impl.UserServicesImpl;

@ManagedBean
public class UserController {

	@EJB
	private UserServices userService;
		
	public void CheckUser(LoginSubmission login){
		UserServicesImpl userServices = new UserServicesImpl();
		
		User user = userServices.getUser(login.getMail(), login.getMotDePasse());
		
		if(user != null){
			 //r�cup�re l'espace de m�moire de JSF
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            //place l'utilisateur dans l' espace  de m�moire de JSF
            sessionMap.put("loggedUser", user);
            //redirect the current page
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Successful", "Welcome " + user.getPrenom() + " " + user.getPrenom()));
        }
        else
        {
            //redirect the current page
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Cannot connect."));
        }
	}



	public List<User> listUser() {
		return userService.getListUser();
	}
	
	
}
