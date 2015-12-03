package services;

import java.util.List;

import javax.ejb.Local;

import entities.Classe;


@Local
public interface ClasseServices {
	
	public Classe getClasse(Integer id);
	public void addClasse(Classe classe,int idEcole, int idEnseignant, int idNiveau);
	public List<Classe> getListClasses();
	public Classe findClasse(int idClasse);
	public void updateClasse(Classe classe, int idEcole, int idEnseignant, int idNiveau);
	public void removeClasse(int idClasse);
	public List<Integer> getNumListClasses();
	public List<Integer> getIdListClasses();
}
