package services;

import java.util.List;

import javax.ejb.Local;

import entities.Niveau;
import entities.Sexe;


@Local
public interface SexeServices {
	
	public Sexe getSexe(int idSexe);
	public List<Sexe> getListSexe();
	public Sexe findSexe(int idSexe);
}
