package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Ecole;
import services.impl.EcoleServicesImpl;

@ManagedBean
public class EcoleController {
	
	private Ecole ecole = new Ecole();
	 
	@EJB
	private EcoleServicesImpl service;
 
	public Ecole getEcole() {
		return ecole;
	}

	
	public List<Ecole> getEcoles(){
		System.out.println(service.getEcoles());
		return service.getEcoles();
	}
}
