package controller;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.print.attribute.standard.Severity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import entities.User;
import model.LoginSubmission;
import services.impl.UserServicesImpl;

public class UserController {

	public void CheckUser(LoginSubmission login){
		UserServicesImpl userServices = new UserServicesImpl();
		
		User user = userServices.getUser(login.getMail(), login.getMotDePasse());
		
		if(user != null){
			 //récupère l'espace de mémoire de JSF
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            //place l'utilisateur dans l' espace  de mémoire de JSF
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
}
