package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_situation_familiale_sifa database table.
 * 
 */
@Entity
@Table(name="t_r_situation_familiale_sifa")
@NamedQuery(name="SituationFamiliale.findAll", query="SELECT s FROM SituationFamiliale s")
public class SituationFamiliale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_situation_familiale")
	private int idSituationFamiliale;

	private String libelle;

	//bi-directional many-to-one association to Tuteur
	@OneToMany(mappedBy="TRSituationFamilialeSifa")
	private List<Tuteur> TETuteurTuts;

	public SituationFamiliale() {
	}

	public int getIdSituationFamiliale() {
		return this.idSituationFamiliale;
	}

	public void setIdSituationFamiliale(int idSituationFamiliale) {
		this.idSituationFamiliale = idSituationFamiliale;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Tuteur> getTETuteurTuts() {
		return this.TETuteurTuts;
	}

	public void setTETuteurTuts(List<Tuteur> TETuteurTuts) {
		this.TETuteurTuts = TETuteurTuts;
	}

	public Tuteur addTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().add(TETuteurTut);
		TETuteurTut.setTRSituationFamilialeSifa(this);

		return TETuteurTut;
	}

	public Tuteur removeTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().remove(TETuteurTut);
		TETuteurTut.setTRSituationFamilialeSifa(null);

		return TETuteurTut;
	}

}