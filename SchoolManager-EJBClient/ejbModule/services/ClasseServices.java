package services;

import java.util.List;

import javax.ejb.Local;

import entities.Classe;


@Local
public interface ClasseServices {
	
	public Classe getClasse(int id);
	public void addClasse(Classe classe,int idEcole, int idEnseignant, int idNiveau);
	public List<Classe> getListClasses();
}
