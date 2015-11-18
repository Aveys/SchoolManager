package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_droits_dro database table.
 * 
 */
@Entity
@Table(name="t_r_droits_dro")
@NamedQuery(name="Droit.findAll", query="SELECT d FROM Droit d")
public class Droit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_droit")
	private int idDroit;

	private String libelle;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="TRDroitsDro")
	private List<User> TEUsersUses;

	public Droit() {
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

	public List<User> getTEUsersUses() {
		return this.TEUsersUses;
	}

	public void setTEUsersUses(List<User> TEUsersUses) {
		this.TEUsersUses = TEUsersUses;
	}

	public User addTEUsersUs(User TEUsersUs) {
		getTEUsersUses().add(TEUsersUs);
		TEUsersUs.setTRDroitsDro(this);

		return TEUsersUs;
	}

	public User removeTEUsersUs(User TEUsersUs) {
		getTEUsersUses().remove(TEUsersUs);
		TEUsersUs.setTRDroitsDro(null);

		return TEUsersUs;
	}

}