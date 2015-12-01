package services;

import java.util.List;

import javax.ejb.Local;

import entities.Ecole;
import entities.Enseignant;
@Local
public interface EcoleServices {

	public Ecole getEcole(int idEcole);
	public void addEcole(Ecole ecole);
	public List<Ecole> getEcoles();
	public void updateEcole(Ecole ecole, int idEnseignant);
	public List<Enseignant> getListEnseignants();
}