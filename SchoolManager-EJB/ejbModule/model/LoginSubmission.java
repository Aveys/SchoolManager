package model;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginSubmission implements Serializable {
	
	/**
	 * Generated UID
	 */
	private static final long serialVersionUID = -5015296017413758502L;
	
	private String mail;
	private String motDePasse;

	public LoginSubmission() {
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
