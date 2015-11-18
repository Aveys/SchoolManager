package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_r_frequence_paiements_frpa database table.
 * 
 */
@Entity
@Table(name="t_r_frequence_paiements_frpa")
@NamedQuery(name="FrequencePaiement.findAll", query="SELECT f FROM FrequencePaiement f")
public class FrequencePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_frequence_paiement")
	private int idFrequencePaiement;

	private String libelle;

	//bi-directional many-to-one association to Reglement
	@OneToMany(mappedBy="TRFrequencePaiementsFrpa")
	private List<Reglement> TEReglementRegs;

	public FrequencePaiement() {
	}

	public int getIdFrequencePaiement() {
		return this.idFrequencePaiement;
	}

	public void setIdFrequencePaiement(int idFrequencePaiement) {
		this.idFrequencePaiement = idFrequencePaiement;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Reglement> getTEReglementRegs() {
		return this.TEReglementRegs;
	}

	public void setTEReglementRegs(List<Reglement> TEReglementRegs) {
		this.TEReglementRegs = TEReglementRegs;
	}

	public Reglement addTEReglementReg(Reglement TEReglementReg) {
		getTEReglementRegs().add(TEReglementReg);
		TEReglementReg.setTRFrequencePaiementsFrpa(this);

		return TEReglementReg;
	}

	public Reglement removeTEReglementReg(Reglement TEReglementReg) {
		getTEReglementRegs().remove(TEReglementReg);
		TEReglementReg.setTRFrequencePaiementsFrpa(null);

		return TEReglementReg;
	}

}