package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the `t_r_mode_paiement_ mopa` database table.
 * 
 */
@Entity
@Table(name="`t_r_mode_paiement_ mopa`")
@NamedQuery(name="ModePaiement.findAll", query="SELECT m FROM ModePaiement m")
public class ModePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mode_paiement")
	private int idModePaiement;

	private String libelle;

	//bi-directional many-to-one association to Paiement
	@OneToMany(mappedBy="TRModePaiementMopa")
	private List<Paiement> TEPaiementPais;

	public ModePaiement() {
	}

	public int getIdModePaiement() {
		return this.idModePaiement;
	}

	public void setIdModePaiement(int idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Paiement> getTEPaiementPais() {
		return this.TEPaiementPais;
	}

	public void setTEPaiementPais(List<Paiement> TEPaiementPais) {
		this.TEPaiementPais = TEPaiementPais;
	}

	public Paiement addTEPaiementPai(Paiement TEPaiementPai) {
		getTEPaiementPais().add(TEPaiementPai);
		TEPaiementPai.setTRModePaiementMopa(this);

		return TEPaiementPai;
	}

	public Paiement removeTEPaiementPai(Paiement TEPaiementPai) {
		getTEPaiementPais().remove(TEPaiementPai);
		TEPaiementPai.setTRModePaiementMopa(null);

		return TEPaiementPai;
	}

}