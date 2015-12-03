package services;

import java.util.List;

import javax.ejb.Local;

import entities.Planning;

@Local
public interface PlanningServices {
	
	public List<Planning> getListPlanning(int idClasse);
	public void mergePlanning(Planning planning);

}
