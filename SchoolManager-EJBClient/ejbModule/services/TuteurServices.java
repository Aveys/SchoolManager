package services;

import java.util.List;

import javax.ejb.Local;

import entities.Tuteur;


@Local
public interface TuteurServices {
	
	public Tuteur getTuteur(int idTuteur);
	public List<Tuteur> getListTuteurs();
	public int addTuteur(Tuteur tuteur, int idAdresse, int idSexe, int idSituationFamiliale);
}
