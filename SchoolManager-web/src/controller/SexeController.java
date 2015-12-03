package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Sexe;
import services.SexeServices;
import services.impl.SexeServicesImpl;

@ManagedBean
@SessionScoped
public class SexeController {
	
	private Sexe sexe = new Sexe();
	 
	@EJB
	private SexeServices service;
 
	public Sexe getSexe() {
		return sexe;
	}

	
	public List<Sexe> getListSexe(){
		System.out.println("on Y EST !!!!!!");
		return service.getListSexe();
	}
}
