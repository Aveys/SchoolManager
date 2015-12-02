package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_classe_cla database table.
 * 
 */
@Entity
@Table(name="t_e_classe_cla")
@NamedQuery(name="Classe.findAll", query="SELECT c FROM Classe c")
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_classe")
	private Integer idClasse;

	@Column(name="num_classe")
	private Integer numClasse;

	@Column(name="num_salle")
	private Integer numSalle;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="id_instituteur")
	private Enseignant TEEnseignantEn;

	//bi-directional many-to-one association to Niveau
	@ManyToOne
	@JoinColumn(name="id_niveau")
	private Niveau TRNiveauNiv;

	//bi-directional many-to-one association to Ecole
	@ManyToOne
	@JoinColumn(name="id_ecole")
	private Ecole TEEcoleEco;

	//bi-directional many-to-one association to Enfant
	@OneToMany(mappedBy="TEClasseCla")
	private List<Enfant> TEEnfantsEnfs;

	public Classe() {
	}

	public Integer getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(Integer idClasse) {
		this.idClasse = idClasse;
	}

	public Integer getNumClasse() {
		return this.numClasse;
	}

	public void setNumClasse(Integer numClasse) {
		this.numClasse = numClasse;
	}

	public Integer getNumSalle() {
		return this.numSalle;
	}

	public void setNumSalle(Integer numSalle) {
		this.numSalle = numSalle;
	}

	public Enseignant getTEEnseignantEn() {
		return this.TEEnseignantEn;
	}

	public void setTEEnseignantEn(Enseignant TEEnseignantEn) {
		this.TEEnseignantEn = TEEnseignantEn;
	}

	public Niveau getTRNiveauNiv() {
		return this.TRNiveauNiv;
	}

	public void setTRNiveauNiv(Niveau TRNiveauNiv) {
		this.TRNiveauNiv = TRNiveauNiv;
	}

	public Ecole getTEEcoleEco() {
		return this.TEEcoleEco;
	}

	public void setTEEcoleEco(Ecole TEEcoleEco) {
		this.TEEcoleEco = TEEcoleEco;
	}

	public List<Enfant> getTEEnfantsEnfs() {
		return this.TEEnfantsEnfs;
	}

	public void setTEEnfantsEnfs(List<Enfant> TEEnfantsEnfs) {
		this.TEEnfantsEnfs = TEEnfantsEnfs;
	}

	public Enfant addTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().add(TEEnfantsEnf);
		TEEnfantsEnf.setTEClasseCla(this);

		return TEEnfantsEnf;
	}

	public Enfant removeTEEnfantsEnf(Enfant TEEnfantsEnf) {
		getTEEnfantsEnfs().remove(TEEnfantsEnf);
		TEEnfantsEnf.setTEClasseCla(null);

		return TEEnfantsEnf;
	}

}