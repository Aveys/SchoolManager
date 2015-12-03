package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the t_j_planning_pla database table.
 * 
 */
@Entity
@Table(name="t_j_planning_pla")
@NamedQuery(name="Planning.findAll", query="SELECT p FROM Planning p")
public class Planning implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pla")
	private String idPla;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;

	@Column(name="id_classe")
	private Integer idClasse;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startime;

	private String titre;

	public Planning() {
	}

	public String getIdPla() {
		return this.idPla;
	}

	public void setIdPla(String idPla) {
		this.idPla = idPla;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getIdClasse() {
		return this.idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	public Date getStartime() {
		return this.startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}