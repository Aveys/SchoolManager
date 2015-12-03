package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_adresse_adr database table.
 * 
 */
@Entity
@Table(name="t_e_adresse_adr")
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int idAdresse;

	private String adresse1;

	private String adresse2;

	private int cp;

	@Column(name="num_fixe")
	private int numFixe;

	private String ville;

	//bi-directional many-to-one association to Enseignant
	@OneToMany(mappedBy="TEAdresseAdr")
	private List<Enseignant> TEEnseignantEns;

	//bi-directional many-to-one association to Tuteur
	@OneToMany(mappedBy="TEAdresseAdr")
	private List<Tuteur> TETuteurTuts;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getAdresse1() {
		return this.adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return this.adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getNumFixe() {
		return this.numFixe;
	}

	public void setNumFixe(int numFixe) {
		this.numFixe = numFixe;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Enseignant> getTEEnseignantEns() {
		return this.TEEnseignantEns;
	}

	public void setTEEnseignantEns(List<Enseignant> TEEnseignantEns) {
		this.TEEnseignantEns = TEEnseignantEns;
	}

	public Enseignant addTEEnseignantEn(Enseignant TEEnseignantEn) {
		getTEEnseignantEns().add(TEEnseignantEn);
		TEEnseignantEn.setTEAdresseAdr(this);

		return TEEnseignantEn;
	}

	public Enseignant removeTEEnseignantEn(Enseignant TEEnseignantEn) {
		getTEEnseignantEns().remove(TEEnseignantEn);
		TEEnseignantEn.setTEAdresseAdr(null);

		return TEEnseignantEn;
	}

	public List<Tuteur> getTETuteurTuts() {
		return this.TETuteurTuts;
	}

	public void setTETuteurTuts(List<Tuteur> TETuteurTuts) {
		this.TETuteurTuts = TETuteurTuts;
	}

	public Tuteur addTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().add(TETuteurTut);
		TETuteurTut.setTEAdresseAdr(this);

		return TETuteurTut;
	}

	public Tuteur removeTETuteurTut(Tuteur TETuteurTut) {
		getTETuteurTuts().remove(TETuteurTut);
		TETuteurTut.setTEAdresseAdr(null);

		return TETuteurTut;
	}

	@Override
	public String toString() {
		return adresse1 + "" + adresse2 + "" + cp + "" + ville ;
	}


}