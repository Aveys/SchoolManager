package services;

import java.util.List;

import entities.Ecole;

public interface EcoleServices {

	public Ecole getEcole(int idEcole);
	public void addEcole(Ecole ecole);
	public List<Ecole> getEcoles();
	
}
