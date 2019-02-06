package metier;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import metier.entities.Client;
import metier.entities.Compte;

@Local
public interface BanqueLocal {
	boolean creerComptes(int idUser,double solde);
	boolean crediterComptes(int idUser,int idCompte, double montant);
	boolean debiterCompte(int idUser,int idCompte, double montant);
	List<Compte> visualiserComptes(int idUser) throws Exception;
	void createUser(Date dateNaise, String nom, String prenom);
	List<Client> consulterClients() throws Exception;


}
