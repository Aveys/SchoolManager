package services;

import java.util.List;

import javax.ejb.Local;

import entities.Niveau;


@Local
public interface NiveauServices {
	
	public Niveau getNiveau(int id);
	public void addNiveau(Niveau niveau);
	public List<Niveau> getListNiveaux();
}
