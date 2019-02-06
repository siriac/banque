package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Compte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CODE_CPT")
	private int code; 
	@Column(name="SOLDE")
	private double Solde;
	@Column(name="DATE_CREATION")
	private Date dateCreation;
	@ManyToOne
	@JoinColumn(name="CODE_CLI")
	private Client client;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(double solde, Date dateCreation, Client client) {
		super();
		Solde = solde;
		this.dateCreation = dateCreation;
		this.client = client;
	}

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public double getSolde() {
		return Solde;
	}
	public void setSolde(double solde) {
		Solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
