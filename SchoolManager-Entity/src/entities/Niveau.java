package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_niveau_niv database table.
 * 
 */
@Entity
@Table(name="t_r_niveau_niv")
@NamedQuery(name="Niveau.findAll", query="SELECT n FROM Niveau n")
public class Niveau implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_niveau")
	private int idNiveau;

	private int cycle;

	private String niveau;

	//bi-directional many-to-one association to Classe
	@OneToMany(mappedBy="TRNiveauNiv")
	private List<Classe> TEClasseClas;

	//bi-directional many-to-one association to TypeEcole
	@ManyToOne
	@JoinColumn(name="id_type_ecole")
	private TypeEcole TRTypeEcoleTyec;

	public Niveau() {
	}

	public int getIdNiveau() {
		return this.idNiveau;
	}

	public void setIdNiveau(int idNiveau) {
		this.idNiveau = idNiveau;
	}

	public int getCycle() {
		return this.cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<Classe> getTEClasseClas() {
		return this.TEClasseClas;
	}

	public void setTEClasseClas(List<Classe> TEClasseClas) {
		this.TEClasseClas = TEClasseClas;
	}

	public Classe addTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().add(TEClasseCla);
		TEClasseCla.setTRNiveauNiv(this);

		return TEClasseCla;
	}

	public Classe removeTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().remove(TEClasseCla);
		TEClasseCla.setTRNiveauNiv(null);

		return TEClasseCla;
	}

	public TypeEcole getTRTypeEcoleTyec() {
		return this.TRTypeEcoleTyec;
	}

	public void setTRTypeEcoleTyec(TypeEcole TRTypeEcoleTyec) {
		this.TRTypeEcoleTyec = TRTypeEcoleTyec;
	}

}