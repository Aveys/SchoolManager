package services;

import java.util.List;

import javax.ejb.Local;

import entities.Enfant;


@Local
public interface EnfantServices {

	public Enfant getEnfant(String nom, String prenom);
	public void addEnfant(Enfant enfant);
	public List<Enfant> getListEnfant();
	public List<Enfant> getListEnfantClasse(int idClasse);
	
}
