package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_e_users_use database table.
 * 
 */
@Entity
@Table(name="t_e_users_use")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String mail;

	@Column(name="mot_de_passe")
	private String motDePasse;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Droit
	@ManyToOne
	@JoinColumn(name="id_droit")
	private Droit TRDroitsDro;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Droit getTRDroitsDro() {
		return this.TRDroitsDro;
	}

	public void setTRDroitsDro(Droit TRDroitsDro) {
		this.TRDroitsDro = TRDroitsDro;
	}

}