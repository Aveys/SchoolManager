package model;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

import entities.User;

@ManagedBean
@RequestScoped
// Dur�e de vue uniquement lors d'une requ�te
// m�me propri�t�s que User mais port�e diff�rente
public class UserSubmission extends User {
	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;

	public UserSubmission(){
	}
}
