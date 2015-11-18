package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_e_paiement_pai database table.
 * 
 */
@Entity
@Table(name="t_e_paiement_pai")
@NamedQuery(name="Paiement.findAll", query="SELECT p FROM Paiement p")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_paiement")
	private int idPaiement;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int montant;

	//bi-directional many-to-one association to Reglement
	@ManyToOne
	@JoinColumn(name="id_reglement")
	private Reglement TEReglementReg;

	//bi-directional many-to-one association to ModePaiement
	@ManyToOne
	@JoinColumn(name="id_mode_paiement")
	private ModePaiement TRModePaiementMopa;

	public Paiement() {
	}

	public int getIdPaiement() {
		return this.idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMontant() {
		return this.montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Reglement getTEReglementReg() {
		return this.TEReglementReg;
	}

	public void setTEReglementReg(Reglement TEReglementReg) {
		this.TEReglementReg = TEReglementReg;
	}

	public ModePaiement getTRModePaiementMopa() {
		return this.TRModePaiementMopa;
	}

	public void setTRModePaiementMopa(ModePaiement TRModePaiementMopa) {
		this.TRModePaiementMopa = TRModePaiementMopa;
	}

}