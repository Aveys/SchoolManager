package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_type_ecole_tyec database table.
 * 
 */
@Entity
@Table(name="t_r_type_ecole_tyec")
@NamedQuery(name="TypeEcole.findAll", query="SELECT t FROM TypeEcole t")
public class TypeEcole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_type_ecole")
	private int idTypeEcole;

	private String libelle;

	//bi-directional many-to-many association to Ecole
	@ManyToMany
	@JoinTable(
		name="t_j_type_ecole_jte"
		, joinColumns={
			@JoinColumn(name="id_type_ecole")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_ecole")
			}
		)
	private List<Ecole> TEEcoleEcos;

	//bi-directional many-to-one association to Niveau
	@OneToMany(mappedBy="TRTypeEcoleTyec")
	private List<Niveau> TRNiveauNivs;

	public TypeEcole() {
	}

	public int getIdTypeEcole() {
		return this.idTypeEcole;
	}

	public void setIdTypeEcole(int idTypeEcole) {
		this.idTypeEcole = idTypeEcole;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Ecole> getTEEcoleEcos() {
		return this.TEEcoleEcos;
	}

	public void setTEEcoleEcos(List<Ecole> TEEcoleEcos) {
		this.TEEcoleEcos = TEEcoleEcos;
	}

	public List<Niveau> getTRNiveauNivs() {
		return this.TRNiveauNivs;
	}

	public void setTRNiveauNivs(List<Niveau> TRNiveauNivs) {
		this.TRNiveauNivs = TRNiveauNivs;
	}

	public Niveau addTRNiveauNiv(Niveau TRNiveauNiv) {
		getTRNiveauNivs().add(TRNiveauNiv);
		TRNiveauNiv.setTRTypeEcoleTyec(this);

		return TRNiveauNiv;
	}

	public Niveau removeTRNiveauNiv(Niveau TRNiveauNiv) {
		getTRNiveauNivs().remove(TRNiveauNiv);
		TRNiveauNiv.setTRTypeEcoleTyec(null);

		return TRNiveauNiv;
	}

}