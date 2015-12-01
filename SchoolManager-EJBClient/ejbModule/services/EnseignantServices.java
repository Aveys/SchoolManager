package services;

import java.util.List;

import javax.ejb.Local;

import entities.Enseignant;


@Local
public interface EnseignantServices {
	
	public Enseignant getEnseignant(int id);
	public void addEnseignant(Enseignant enseignant);
	public List<Enseignant> getListEnseignants();
}
