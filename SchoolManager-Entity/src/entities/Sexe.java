package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_sexe__sex database table.
 * 
 */
@Entity
@Table(name="t_r_sexe__sex")
@NamedQuery(name="Sexe.findAll", query="SELECT s FROM Sexe s")
public class Sexe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sexe")
	private int idSexe;

	private String libelle;

	//bi-directional many-to-one association to Enfant
	@OneToMany(mappedBy="TRSexeSex")
	private List<Enfant> TEEnfantsEnfs;

	//bi-directional many-to-one association to Enseignant
	@OneToMany(mappedBy="TRSexeSex")
	private List<Enseignant> TEEnseignantEns;

	//bi-directional many-to-one association to Tuteur
	@OneToMany(mappedBy="TRSexeSex")
	private List<Tuteur> TETuteurTuts;

	public Sexe() {
	}

	public int getIdSexe() {
		return this.idSexe;
	}

	public void setIdSexe(int idSexe) {
		this.idSexe = idSexe;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Enfant> getTEEnfantsEnfs() {
		return this.TEEnfantsEnfs;
	}

	public void setTEEnfantsEnfs(List<Enfant> TEEnfantsEnfs) {
		this.TEEnfantsEnfs = TEEnfantsEnfs;
	}

	public Enfant addTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().add(TEEnfantsEnf);
		TEEnfantsEnf.setTRSexeSex(this);

		return TEEnfantsEnf;
	}

	public Enfant removeTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().remove(TEEnfantsEnf);
		TEEnfantsEnf.setTRSexeSex(null);

		return TEEnfantsEnf;
	}

	public List<Enseignant> getTEEnseignantEns() {
		return this.TEEnseignantEns;
	}

	public void setTEEnseignantEns(List<Enseignant> TEEnseignantEns) {
		this.TEEnseignantEns = TEEnseignantEns;
	}

	public Enseignant addTEEnseignantEn(Enseignant TEEnseignantEn) {
		getTEEnseignantEns().add(TEEnseignantEn);
		TEEnseignantEn.setTRSexeSex(this);

		return TEEnseignantEn;
	}

	public Enseignant removeTEEnseignantEn(Enseignant TEEnseignantEn) {
		getTEEnseignantEns().remove(TEEnseignantEn);
		TEEnseignantEn.setTRSexeSex(null);

		return TEEnseignantEn;
	}

	public List<Tuteur> getTETuteurTuts() {
		return this.TETuteurTuts;
	}

	public void setTETuteurTuts(List<Tuteur> TETuteurTuts) {
		this.TETuteurTuts = TETuteurTuts;
	}

	public Tuteur addTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().add(TETuteurTut);
		TETuteurTut.setTRSexeSex(this);

		return TETuteurTut;
	}

	public Tuteur removeTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().remove(TETuteurTut);
		TETuteurTut.setTRSexeSex(null);

		return TETuteurTut;
	}

}