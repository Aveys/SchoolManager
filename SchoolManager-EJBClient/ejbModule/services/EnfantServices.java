package services;

import java.util.List;

import javax.ejb.Local;

import entities.Enfant;


@Local
public interface EnfantServices {

	public Enfant getEnfant(String nom, String prenom);
	public List<Enfant> getListEnfant();
	public List<Enfant> getListEnfantClasse(int idClasse);
	public void updateEnfant(Enfant enfant);
	public void removeEnfant(Integer idpersonne);
	public Enfant findEnfant(Integer idpers);
	public void addEnfant(Enfant enfant);
	
}
