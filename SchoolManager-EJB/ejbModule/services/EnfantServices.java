package services;

import java.util.List;

import entities.Enfant;


public interface EnfantServices {

	public Enfant getEnfant(String nom, String prenom);
	public void addEnfant(Enfant enfant);
	public List<Enfant> getListEnfant();
	public List<Enfant> getListEnfantClasse(int idClasse);
	
}
