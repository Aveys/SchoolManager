package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Niveau;
import services.NiveauServices;
import services.impl.NiveauServicesImpl;

@ManagedBean
@SessionScoped
public class NiveauController {
	
	private Niveau niveau = new Niveau();
	 
	@EJB
	private NiveauServices service;
 
	public Niveau getClasse() {
		return niveau;
	}

	
	public List<Niveau> getListNiveaux(){
		return service.getListNiveaux();
	}
}
