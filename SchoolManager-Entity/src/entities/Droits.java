package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_r_droits_dro database table.
 * 
 */
@Entity
@Table(name="t_r_droits_dro")
@NamedQuery(name="Droits.findAll", query="SELECT d FROM Droits d")
public class Droits implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_droit")
	private int idDroit;

	private String libelle;

	public Droits() {
	}

	public int getIdDroit() {
		return this.idDroit;
	}

	public void setIdDroit(int idDroit) {
		this.idDroit = idDroit;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}