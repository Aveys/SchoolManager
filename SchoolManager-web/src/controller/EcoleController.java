package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Ecole;
import services.EcoleServices;
import services.impl.EcoleServicesImpl;

@ManagedBean
public class EcoleController {
	
	private Ecole ecole = new Ecole();
	 
	@EJB
	private EcoleServices service;
 
	public Ecole getEcole() {
		return ecole;
	}

	
	public List<Ecole> getEcoles(){
		return service.getEcoles();
	}
}
