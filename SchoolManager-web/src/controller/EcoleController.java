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
	
	public Ecole getEcole(int idEcole) {
		return service.getEcole(idEcole);
	}

	
	public List<Ecole> getEcoles(){
		return service.getEcoles();
	}
	
	public String updateEcole(Ecole ecole){
		service.updateEcole(ecole);
		return "DetailsEcole";
	}
	
	public String detailsEcole(int idEcole){
		this.ecole = service.getEcole(idEcole);
		return "DetailsEcole";
	}
}
