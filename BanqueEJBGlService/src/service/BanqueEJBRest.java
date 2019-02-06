package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.BanqueLocal;
import metier.entities.Client;
import metier.entities.Compte;

@Stateless
@Path("/")
public class BanqueEJBRest {
@EJB
private BanqueLocal metier;
@POST
@Path("/comptes")
@Produces(MediaType.APPLICATION_JSON)
public boolean creerComptes(@FormParam(value="iduser")int idUser, @FormParam(value="solde")double solde) {
	return metier.creerComptes(idUser, solde);
}
@PUT
@Path("/comptes/crediter")
@Produces(MediaType.APPLICATION_JSON)
public boolean crediterComptes(@FormParam(value="iduser")int idUser, @FormParam(value="idcpt")int idCompte,@FormParam(value="montant") double montant) {
	return metier.crediterComptes(idUser, idCompte, montant);
}
@PUT
@Path("/comptes/debiter")
@Produces(MediaType.APPLICATION_JSON)
public boolean debiterCompte(@FormParam(value="iduser")int idUser,@FormParam(value="idcompte") int idCompte, @FormParam(value="montant")double montant) {
	return metier.debiterCompte(idUser, idCompte, montant);
}
@GET
@Path("/comptes/{code}")
@Produces(MediaType.APPLICATION_JSON)
public List<Compte> visualiserComptes(@PathParam(value="code")int idUser) throws Exception {
	return metier.visualiserComptes(idUser);
}
@POST
@Path("/user")
public void createUser(@FormParam(value="date")Date dateNaise, @FormParam(value="nom")String nom, @FormParam(value="prenom")String prenom) {
	metier.createUser(dateNaise, nom, prenom);
}
@GET
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public List<Client> consulterClients() throws Exception {
	return metier.consulterClients();
}

}
