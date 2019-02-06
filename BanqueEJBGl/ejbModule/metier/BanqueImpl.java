package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import metier.entities.Client;
import metier.entities.Compte;
@Stateless(name="BQ")
public class BanqueImpl implements BanqueRemote,BanqueLocal{
	@PersistenceContext(unitName="BanqueEJBGl")
	private EntityManager em;
	@Override
	
	public boolean creerComptes(int idUser, double solde) {
		// TODO Auto-generated method stub
		Client cliente=em.find(Client.class, idUser);
		if(cliente==null){
	  new RuntimeException("impossible de creer compte car client n'ont existant");
		return false;
		}
		else{
		Compte cp=new Compte();
		cp.setClient(cliente);
		cp.setDateCreation(new Date());
		cp.setSolde(solde);
		em.persist(cp);
		
		}
		return true;
	}

	@Override
	public boolean crediterComptes(int idUser, int idCompte, double montant) {
		// TODO Auto-generated method stub
		Compte cp=em.find(Compte.class,idCompte);
		Client cliente=em.find(Client.class, idUser);
		if(cp==null || cliente==null)
		{
			if(cp==null) 
				{new RuntimeException("impossible de crediter compte car compte inexistant");
				}else 
			{new RuntimeException("impossible de crediter compte car compte inexistant");
			
			}
			return false;	
		}
		else {
			cp.setSolde(cp.getSolde()+montant);
			
		}
		return true;
	}

	@Override
	public boolean debiterCompte(int idUser, int idCompte, double montant) {
		// TODO Auto-generated method stub
		Compte cp=em.find(Compte.class, idCompte);
		Client cliente=em.find(Client.class, idUser);
		if(cp==null || cliente==null)
		{
			if(cp==null)
			{
				new RuntimeException("impossible de debiter compte car compte inexistant");
			}
			else new RuntimeException("Impossible de debiter compte car client inexistant");
			return false;
		}
		else {
			if(cp.getSolde()<montant) 
			{
				new RuntimeException("Solde Insuffisant");
				return false;
			}
			cp.setSolde(cp.getSolde()-montant);
			return true;
		}
		
	}

	@Override
	public List<Compte> visualiserComptes(int idUser) throws Exception {
		// TODO Auto-generated method stub
		Client cliente=em.find(Client.class, idUser);
		if(cliente==null)
		{
			System.out.println("Impossible de visualiser ce compte car client non existant");
			return null;
		}
		else
		{
			List<Compte> cpt=new ArrayList<Compte>();
			 
			Query req=em.createQuery("select c.comptes from Client c where c.codeClient=:idUser");
			req.setParameter("idUser", idUser);
			Iterator< Compte> iter=req.getResultList().iterator();
			
			
				while (iter.hasNext()){
					Compte compte1 = iter.next();
					Compte compte2 = new Compte();
					compte2.setCode(compte1.getCode());
					compte2.setDateCreation(compte1.getDateCreation());
					compte2.setSolde(compte1.getSolde());
					cpt.add(compte2);
					}
				return cpt;
			
				
		}
	}

	@Override
	public void createUser(Date dateNaise, String nom, String prenom) {
		// TODO Auto-generated method stub
		Client cliente=new Client(nom,dateNaise,prenom);
		em.persist(cliente);
		
		
	}

	@Override
	public List<Client> consulterClients() throws Exception {
		List<Client> lista=new ArrayList<Client>();
//		Query req= em.createQuery("select c from Client c");
		Iterator<Client> iter= em.createQuery("select c from Client c").getResultList().iterator();
		while (iter.hasNext()){
			Client client1 = iter.next();
			Client client2 = new Client();
			client2.setCodeClient(client1.getCodeClient());
			client2.setNomClient(client1.getNomClient());
			
			lista.add(client2);
			}
		return lista;
}
}
	
