package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_famille_fam database table.
 * 
 */
@Entity
@Table(name="t_e_famille_fam")
@NamedQuery(name="Famille.findAll", query="SELECT f FROM Famille f")
public class Famille implements Serializable {
	@Override
	public String toString() {
		return "Famille [TETuteurTut1=" + TETuteurTut1 + ", TETuteurTut2=" + TETuteurTut2 + ", TETuteurTut3="
				+ TETuteurTut3 + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_famille")
	private int idFamille;

	//bi-directional many-to-one association to Enfant
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "TEFamilleFam", cascade = CascadeType.ALL)
	private List<Enfant> TEEnfantsEnfs;

	//bi-directional many-to-one association to Tuteur
	@ManyToOne
	@JoinColumn(name="id_responsable_legal")
	private Tuteur TETuteurTut1;

	//bi-directional many-to-one association to Reglement
	@ManyToOne
	@JoinColumn(name="id_reglement")
	private Reglement TEReglementReg;

	//bi-directional many-to-one association to Tuteur
	@ManyToOne
	@JoinColumn(name="id_parent1")
	private Tuteur TETuteurTut2;

	//bi-directional many-to-one association to Tuteur
	@ManyToOne
	@JoinColumn(name="id_parent2")
	private Tuteur TETuteurTut3;

	public Famille() {
		TETuteurTut1 = new Tuteur();
		TETuteurTut2 = new Tuteur();
		TETuteurTut3 = new Tuteur();
	
	}

	public int getIdFamille() {
		return this.idFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	public List<Enfant> getTEEnfantsEnfs() {
		return this.TEEnfantsEnfs;
	}

	public void setTEEnfantsEnfs(List<Enfant> TEEnfantsEnfs) {
		this.TEEnfantsEnfs = TEEnfantsEnfs;
	}

	public Enfant addTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().add(TEEnfantsEnf);
		TEEnfantsEnf.setTEFamilleFam(this);

		return TEEnfantsEnf;
	}

	public Enfant removeTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().remove(TEEnfantsEnf);
		TEEnfantsEnf.setTEFamilleFam(null);

		return TEEnfantsEnf;
	}

	public Tuteur getTETuteurTut1() {
		return this.TETuteurTut1;
	}

	public void setTETuteurTut1(Tuteur TETuteurTut1) {
		this.TETuteurTut1 = TETuteurTut1;
	}

	public Reglement getTEReglementReg() {
		return this.TEReglementReg;
	}

	public void setTEReglementReg(Reglement TEReglementReg) {
		this.TEReglementReg = TEReglementReg;
	}

	public Tuteur getTETuteurTut2() {
		return this.TETuteurTut2;
	}

	public void setTETuteurTut2(Tuteur TETuteurTut2) {
		this.TETuteurTut2 = TETuteurTut2;
	}

	public Tuteur getTETuteurTut3() {
		return this.TETuteurTut3;
	}

	public void setTETuteurTut3(Tuteur TETuteurTut3) {
		this.TETuteurTut3 = TETuteurTut3;
	}

}