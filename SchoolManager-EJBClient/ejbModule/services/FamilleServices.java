package services;

import java.util.List;

import javax.ejb.Local;


import entities.Famille;


@Local
public interface FamilleServices {
	
	public Famille getFamille(int id);
	//public void addFamille(Classe classe,int idEcole, int idEnseignant, int idNiveau);
	public List<Famille> getListFamilles();
	public Famille findFamille(int idFamille);
	//public void updateFamille(Classe classe, int idEcole, int idEnseignant, int idNiveau);
	public void removeFamille(int idClasse);
	public void addFamille(Famille famille, int id_tuteur_1, int id_parent_1, int id_parent_2);
}
