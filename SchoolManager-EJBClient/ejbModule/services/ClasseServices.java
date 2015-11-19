package services;

import java.util.List;

import javax.ejb.Local;

import entities.Classe;
import entities.User;

@Local
public interface ClasseServices {
	
	public User getClasse(int id);
	public void addClasse(Classe classe);
	public List<Classe> getListClasse();
}
