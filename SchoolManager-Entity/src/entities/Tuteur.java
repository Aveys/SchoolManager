package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_tuteur_tut database table.
 * 
 */
@Entity
@Table(name="t_e_tuteur_tut")
@NamedQuery(name="Tuteur.findAll", query="SELECT t FROM Tuteur t")
public class Tuteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tuteur")
	private int idTuteur;

	private String email;

	private String nom;

	@Column(name="num_portable")
	private int numPortable;

	@Column(name="num_secu")
	private String numSecu;

	private String prenom;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="TETuteurTut1")
	private List<Famille> TEFamilleFams1;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="TETuteurTut2")
	private List<Famille> TEFamilleFams2;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="TETuteurTut3")
	private List<Famille> TEFamilleFams3;

	//bi-directional many-to-one association to Sexe
	@ManyToOne
	@JoinColumn(name="id_sexe")
	private Sexe TRSexeSex;

	//bi-directional many-to-one association to SituationFamiliale
	@ManyToOne
	@JoinColumn(name="id_situation_familiale")
	private SituationFamiliale TRSituationFamilialeSifa;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private Adresse TEAdresseAdr;

	public Tuteur() {
	}

	public int getIdTuteur() {
		return this.idTuteur;
	}

	public void setIdTuteur(int idTuteur) {
		this.idTuteur = idTuteur;
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

	public String getNumSecu() {
		return this.numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Famille> getTEFamilleFams1() {
		return this.TEFamilleFams1;
	}

	public void setTEFamilleFams1(List<Famille> TEFamilleFams1) {
		this.TEFamilleFams1 = TEFamilleFams1;
	}

	public Famille addTEFamilleFams1(Famille TEFamilleFams1) {
		getTEFamilleFams1().add(TEFamilleFams1);
		TEFamilleFams1.setTETuteurTut1(this);

		return TEFamilleFams1;
	}

	public Famille removeTEFamilleFams1(Famille TEFamilleFams1) {
		getTEFamilleFams1().remove(TEFamilleFams1);
		TEFamilleFams1.setTETuteurTut1(null);

		return TEFamilleFams1;
	}

	public List<Famille> getTEFamilleFams2() {
		return this.TEFamilleFams2;
	}

	public void setTEFamilleFams2(List<Famille> TEFamilleFams2) {
		this.TEFamilleFams2 = TEFamilleFams2;
	}

	public Famille addTEFamilleFams2(Famille TEFamilleFams2) {
		getTEFamilleFams2().add(TEFamilleFams2);
		TEFamilleFams2.setTETuteurTut2(this);

		return TEFamilleFams2;
	}

	public Famille removeTEFamilleFams2(Famille TEFamilleFams2) {
		getTEFamilleFams2().remove(TEFamilleFams2);
		TEFamilleFams2.setTETuteurTut2(null);

		return TEFamilleFams2;
	}

	public List<Famille> getTEFamilleFams3() {
		return this.TEFamilleFams3;
	}

	public void setTEFamilleFams3(List<Famille> TEFamilleFams3) {
		this.TEFamilleFams3 = TEFamilleFams3;
	}

	public Famille addTEFamilleFams3(Famille TEFamilleFams3) {
		getTEFamilleFams3().add(TEFamilleFams3);
		TEFamilleFams3.setTETuteurTut3(this);

		return TEFamilleFams3;
	}

	public Famille removeTEFamilleFams3(Famille TEFamilleFams3) {
		getTEFamilleFams3().remove(TEFamilleFams3);
		TEFamilleFams3.setTETuteurTut3(null);

		return TEFamilleFams3;
	}

	public Sexe getTRSexeSex() {
		return this.TRSexeSex;
	}

	public void setTRSexeSex(Sexe TRSexeSex) {
		this.TRSexeSex = TRSexeSex;
	}

	public SituationFamiliale getTRSituationFamilialeSifa() {
		return this.TRSituationFamilialeSifa;
	}

	public void setTRSituationFamilialeSifa(SituationFamiliale TRSituationFamilialeSifa) {
		this.TRSituationFamilialeSifa = TRSituationFamilialeSifa;
	}

	public Adresse getTEAdresseAdr() {
		return this.TEAdresseAdr;
	}

	public void setTEAdresseAdr(Adresse TEAdresseAdr) {
		this.TEAdresseAdr = TEAdresseAdr;
	}

}