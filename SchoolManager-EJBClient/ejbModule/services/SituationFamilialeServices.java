package services;

import java.util.List;

import javax.ejb.Local;

import entities.Niveau;
import entities.SituationFamiliale;


@Local
public interface SituationFamilialeServices {
	
	public SituationFamiliale getSituation(int idSituation);
	public List<SituationFamiliale> getListSituationFamiliale();
}
