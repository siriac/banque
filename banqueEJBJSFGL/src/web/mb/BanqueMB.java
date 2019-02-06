package web.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import metier.BanqueLocal;
import metier.entities.Client;
import metier.entities.Compte;

@ManagedBean
@RequestScoped
public class BanqueMB {
	@EJB
	private BanqueLocal metier;
	private int idUser;
	private Double solde;
	private Date date=new Date();
	private String nom;
	private String prenom;
	private int idcpte;
	private Double montant;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public Date getDate() {
		return date;
	}
	public void setDate() {
		this.date = new Date();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getIdcpte() {
		return idcpte;
	}
	public void setIdcpte(int idcpte) {
		this.idcpte = idcpte;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String creercompte()
	{
		metier.creerComptes(idUser, solde);
		return"succes"; 
	}
	public String createUser()
	{
		metier.createUser(date, nom, prenom);
		return "succes";
	}
	public String crediter()
	{
		metier.crediterComptes(idUser, idcpte, montant);
		return "succes";
	}
     public String debiter()
     {
    	 metier.debiterCompte(idUser, idcpte, montant);
    	 return "succes";
     }
     public List<Compte> getListeComptes(int idUser)
     {
    	 List<Compte> ListeComptes=new ArrayList<Compte>();
    	 try {
			ListeComptes=metier.visualiserComptes(idUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListeComptes;
     }
     public List<Client> getListeClients()
     {
    	 List<Client> List=new ArrayList<Client>();
    	 try {
			List=metier.consulterClients();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return List;
     }
	
	 
}
