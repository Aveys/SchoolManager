package services;

import java.util.List;

import entities.Classe;
import entities.User;

public interface ClasseServices {
	
	public User getClasse(int id);
	public void addClasse(Classe classe);
	public List<Classe> getListClasse();
}
