package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_e_reglement_reg database table.
 * 
 */
@Entity
@Table(name="t_e_reglement_reg")
@NamedQuery(name="Reglement.findAll", query="SELECT r FROM Reglement r")
public class Reglement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reglement")
	private int idReglement;

	@Column(name="montant_total")
	private int montantTotal;

	@Column(name="nb_paiements")
	private int nbPaiements;

	//bi-directional many-to-one association to Famille
	@OneToMany(mappedBy="TEReglementReg")
	private List<Famille> TEFamilleFams;

	//bi-directional many-to-one association to Paiement
	@OneToMany(mappedBy="TEReglementReg")
	private List<Paiement> TEPaiementPais;

	//bi-directional many-to-one association to FrequencePaiement
	@ManyToOne
	@JoinColumn(name="id_frequence_paiement")
	private FrequencePaiement TRFrequencePaiementsFrpa;

	public Reglement() {
	}

	public int getIdReglement() {
		return this.idReglement;
	}

	public void setIdReglement(int idReglement) {
		this.idReglement = idReglement;
	}

	public int getMontantTotal() {
		return this.montantTotal;
	}

	public void setMontantTotal(int montantTotal) {
		this.montantTotal = montantTotal;
	}

	public int getNbPaiements() {
		return this.nbPaiements;
	}

	public void setNbPaiements(int nbPaiements) {
		this.nbPaiements = nbPaiements;
	}

	public List<Famille> getTEFamilleFams() {
		return this.TEFamilleFams;
	}

	public void setTEFamilleFams(List<Famille> TEFamilleFams) {
		this.TEFamilleFams = TEFamilleFams;
	}

	public Famille addTEFamilleFam(Famille TEFamilleFam) {
		getTEFamilleFams().add(TEFamilleFam);
		TEFamilleFam.setTEReglementReg(this);

		return TEFamilleFam;
	}

	public Famille removeTEFamilleFam(Famille TEFamilleFam) {
		getTEFamilleFams().remove(TEFamilleFam);
		TEFamilleFam.setTEReglementReg(null);

		return TEFamilleFam;
	}

	public List<Paiement> getTEPaiementPais() {
		return this.TEPaiementPais;
	}

	public void setTEPaiementPais(List<Paiement> TEPaiementPais) {
		this.TEPaiementPais = TEPaiementPais;
	}

	public Paiement addTEPaiementPai(Paiement TEPaiementPai) {
		getTEPaiementPais().add(TEPaiementPai);
		TEPaiementPai.setTEReglementReg(this);

		return TEPaiementPai;
	}

	public Paiement removeTEPaiementPai(Paiement TEPaiementPai) {
		getTEPaiementPais().remove(TEPaiementPai);
		TEPaiementPai.setTEReglementReg(null);

		return TEPaiementPai;
	}

	public FrequencePaiement getTRFrequencePaiementsFrpa() {
		return this.TRFrequencePaiementsFrpa;
	}

	public void setTRFrequencePaiementsFrpa(FrequencePaiement TRFrequencePaiementsFrpa) {
		this.TRFrequencePaiementsFrpa = TRFrequencePaiementsFrpa;
	}

}