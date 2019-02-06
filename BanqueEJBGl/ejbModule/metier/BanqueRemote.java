package metier;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import metier.entities.Client;
import metier.entities.Compte;

@Remote
public interface BanqueRemote  {
	boolean creerComptes(int idUser,double solde);
	boolean crediterComptes(int idUser,int idCompte, double montant);
	boolean debiterCompte(int idUser,int idCompte, double montant);
	List<Compte> visualiserComptes(int idUser) throws Exception;
	void createUser(Date dateNaise, String nom, String prenom);
	List<Client> consulterClients() throws Exception;


}
