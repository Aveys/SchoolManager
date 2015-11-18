package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_e_enfants_enf database table.
 * 
 */
@Entity
@Table(name="t_e_enfants_enf")
@NamedQuery(name="Enfant.findAll", query="SELECT e FROM Enfant e")
public class Enfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personne")
	private int idPersonne;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Sexe
	@ManyToOne
	@JoinColumn(name="id_sexe")
	private Sexe TRSexeSex;

	//bi-directional many-to-one association to Famille
	@ManyToOne
	@JoinColumn(name="id_famille")
	private Famille TEFamilleFam;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe TEClasseCla;

	public Enfant() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public Sexe getTRSexeSex() {
		return this.TRSexeSex;
	}

	public void setTRSexeSex(Sexe TRSexeSex) {
		this.TRSexeSex = TRSexeSex;
	}

	public Famille getTEFamilleFam() {
		return this.TEFamilleFam;
	}

	public void setTEFamilleFam(Famille TEFamilleFam) {
		this.TEFamilleFam = TEFamilleFam;
	}

	public Classe getTEClasseCla() {
		return this.TEClasseCla;
	}

	public void setTEClasseCla(Classe TEClasseCla) {
		this.TEClasseCla = TEClasseCla;
	}

}