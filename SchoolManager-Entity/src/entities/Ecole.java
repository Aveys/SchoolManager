package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_ecole_eco database table.
 * 
 */
@Entity
@Table(name="t_e_ecole_eco")
@NamedQuery(name="Ecole.findAll", query="SELECT e FROM Ecole e")
public class Ecole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ecole")
	private int idEcole;

	private String adresse;

	private String email;

	private int fax;

	@Column(name="nom_etablissement")
	private String nomEtablissement;

	@Column(name="nombre_salles")
	private int nombreSalles;

	private int num_Telephone;

	private int surface;

	//bi-directional many-to-one association to Classe
	@OneToMany(mappedBy="TEEcoleEco")
	private List<Classe> TEClasseClas;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="id_responsable")
	private Enseignant TEEnseignantEn;

	//bi-directional many-to-many association to TypeEcole
	@ManyToMany(mappedBy="TEEcoleEcos")
	private List<TypeEcole> TRTypeEcoleTyecs;

	public Ecole() {
	}

	public int getIdEcole() {
		return this.idEcole;
	}

	public void setIdEcole(int idEcole) {
		this.idEcole = idEcole;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getNomEtablissement() {
		return this.nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public int getNombreSalles() {
		return this.nombreSalles;
	}

	public void setNombreSalles(int nombreSalles) {
		this.nombreSalles = nombreSalles;
	}

	public int getNum_Telephone() {
		return this.num_Telephone;
	}

	public void setNum_Telephone(int num_Telephone) {
		this.num_Telephone = num_Telephone;
	}

	public int getSurface() {
		return this.surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public List<Classe> getTEClasseClas() {
		return this.TEClasseClas;
	}

	public void setTEClasseClas(List<Classe> TEClasseClas) {
		this.TEClasseClas = TEClasseClas;
	}

	public Classe addTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().add(TEClasseCla);
		TEClasseCla.setTEEcoleEco(this);

		return TEClasseCla;
	}

	public Classe removeTEClasseCla(Classe TEClasseCla) {
		getTEClasseClas().remove(TEClasseCla);
		TEClasseCla.setTEEcoleEco(null);

		return TEClasseCla;
	}

	public Enseignant getTEEnseignantEn() {
		return this.TEEnseignantEn;
	}

	public void setTEEnseignantEn(Enseignant TEEnseignantEn) {
		this.TEEnseignantEn = TEEnseignantEn;
	}

	public List<TypeEcole> getTRTypeEcoleTyecs() {
		return this.TRTypeEcoleTyecs;
	}

	public void setTRTypeEcoleTyecs(List<TypeEcole> TRTypeEcoleTyecs) {
		this.TRTypeEcoleTyecs = TRTypeEcoleTyecs;
	}

}