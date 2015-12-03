package services;

import java.util.List;

import javax.ejb.Local;

import entities.Adresse;


@Local
public interface AdresseServices {
	
	public Adresse getAdresse(int idAdresse);
	public List<Adresse> getListAdresses();
	public int addAdresse(Adresse adresse);
}
