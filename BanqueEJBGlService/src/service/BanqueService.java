package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.BanqueLocal;
import metier.entities.Client;
import metier.entities.Compte;

@WebService
public class BanqueService {
	@EJB
private BanqueLocal metier;//metier est un ejb qui implemente cette interface qui est deploye 
	

@WebMethod
	public boolean creerComptes(@WebParam(name="iduser")int idUser, @WebParam(name="solde")double solde) {
		return metier.creerComptes(idUser, solde);
	}
@WebMethod
	public boolean crediterComptes(@WebParam(name="iduser")int idUser, 
			@WebParam (name="idCpt")int idCompte, @WebParam(name="montant")double montant) {
		return metier.crediterComptes(idUser, idCompte, montant);
	}
@WebMethod
	public boolean debiterCompte(@WebParam(name="iduser")int idUser, @WebParam(name="idcompte")int idCompte,@WebParam(name="montant")double montant) {
		return metier.debiterCompte(idUser, idCompte, montant);
	}
@WebMethod
	public List<Compte> visualiserComptes(@WebParam(name="iduser")int idUser) throws Exception {
		return metier.visualiserComptes(idUser);
	}

@WebMethod
	public void createUser(
			@WebParam(name="date") Date dateNaise, 
			@WebParam(name="nom")String nom,
			@WebParam (name="prenom")String prenom) {
		metier.createUser(dateNaise, nom, prenom);
	}

@WebMethod
public List<Client> consulterClients() throws Exception {
	return metier.consulterClients();
}
	
}
