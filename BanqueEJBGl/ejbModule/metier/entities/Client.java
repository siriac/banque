package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")
private int codeClient;
	public Client(String nomClient, Date dateNaissance, String prenom) {
		super();
		this.nomClient = nomClient;
		this.dateNaissance = dateNaissance;
		this.prenom = prenom;
	}

	@Column(name="NOM_CLI")
private String nomClient;
	@Column(name="DATE_NAISS")
	private Date dateNaissance;
	@Column(name="PRENOM")
	private String prenom;
@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private List<Compte> comptes;

public List<Compte> getComptes() {
	return comptes;
}
public void setComptes(List<Compte> comptes) {
	this.comptes = comptes;
}
public int getCodeClient() {
	return codeClient;
}
public void setCodeClient(int codeClient) {
	this.codeClient = codeClient;
}
public String getNomClient() {
	return nomClient;
}
public Client() {
	super();
	// TODO Auto-generated constructor stub
}

public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}

}
