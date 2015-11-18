package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_enseignant_ens database table.
 * 
 */
@Entity
@Table(name="t_e_enseignant_ens")
@NamedQuery(name="Enseignant.findAll", query="SELECT e FROM Enseignant e")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_enseignant")
	private int idEnseignant;

	private String email;

	private String nom;

	@Column(name="num_portable")
	private int numPortable;

	private String prenom;

	//bi-directional many-to-one association to Classe
	@OneToMany(mappedBy="TEEnseignantEn")
	private List<Classe> TEClasseClas;

	//bi-directional many-to-one association to Ecole
	@OneToMany(mappedBy="TEEnseignantEn")
	private List<Ecole> TEEcoleEcos;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private Adresse TEAdresseAdr;

	//bi-directional many-to-one association to Sexe
	@ManyToOne
	@JoinColumn(name="id_sexe")
	private Sexe TRSexeSex;

	public Enseignant() {
	}

	public int getIdEnseignant() {
		return this.idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumPortable() {
		return this.numPortable;
	}

	public void setNumPortable(int numPortable) {
		this.numPortable = numPortable;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Classe> getTEClasseClas() {
		return this.TEClasseClas;
	}

	public void setTEClasseClas(List<Classe> TEClasseClas) {
		this.TEClasseClas = TEClasseClas;
	}

	public Classe addTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().add(TEClasseCla);
		TEClasseCla.setTEEnseignantEn(this);

		return TEClasseCla;
	}

	public Classe removeTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().remove(TEClasseCla);
		TEClasseCla.setTEEnseignantEn(null);

		return TEClasseCla;
	}

	public List<Ecole> getTEEcoleEcos() {
		return this.TEEcoleEcos;
	}

	public void setTEEcoleEcos(List<Ecole> TEEcoleEcos) {
		this.TEEcoleEcos = TEEcoleEcos;
	}

	public Ecole addTEEcoleEco(Ecole TEEcoleEco) {
		getTEEcoleEcos().add(TEEcoleEco);
		TEEcoleEco.setTEEnseignantEn(this);

		return TEEcoleEco;
	}

	public Ecole removeTEEcoleEco(Ecole TEEcoleEco) {
		getTEEcoleEcos().remove(TEEcoleEco);
		TEEcoleEco.setTEEnseignantEn(null);

		return TEEcoleEco;
	}

	public Adresse getTEAdresseAdr() {
		return this.TEAdresseAdr;
	}

	public void setTEAdresseAdr(Adresse TEAdresseAdr) {
		this.TEAdresseAdr = TEAdresseAdr;
	}

	public Sexe getTRSexeSex() {
		return this.TRSexeSex;
	}

	public void setTRSexeSex(Sexe TRSexeSex) {
		this.TRSexeSex = TRSexeSex;
	}

}