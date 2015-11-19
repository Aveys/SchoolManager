package services;

import java.util.List;

import javax.ejb.Local;

import entities.Ecole;
@Local
public interface EcoleServices {

	public Ecole getEcole(int idEcole);
	public void addEcole(Ecole ecole);
	public List<Ecole> getEcoles();
	
}
