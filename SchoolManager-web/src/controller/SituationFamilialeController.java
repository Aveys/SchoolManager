package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.SituationFamiliale;
import services.SituationFamilialeServices;
import services.impl.SituationFamilialeServicesImpl;

@ManagedBean
@SessionScoped
public class SituationFamilialeController {
	
	private SituationFamiliale situationfamiliale = new SituationFamiliale();
	 
	@EJB
	private SituationFamilialeServices service;
 
	public SituationFamiliale getSituationFamiliale() {
		return situationfamiliale;
	}

	
	public List<SituationFamiliale> getListSituationFamiliale(){
		return service.getListSituationFamiliale();
	}
}
