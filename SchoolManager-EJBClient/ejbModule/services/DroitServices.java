package services;

import java.util.List;

import javax.ejb.Local;

import entities.Droit;

@Local
public interface DroitServices {
	
	public List<Droit> getListDroit();
	
}
