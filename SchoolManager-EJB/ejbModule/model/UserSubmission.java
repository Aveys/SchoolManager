package model;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

import entities.User;

@ManagedBean
@RequestScoped
// Durée de vue uniquement lors d'une requète
// même propriétés que User mais portée différente
public class UserSubmission extends User {
	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;

	public UserSubmission(){
	}
}
