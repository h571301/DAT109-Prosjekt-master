package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import loggInn.Deltager;


@Stateless
public class DeltagerDAO {

	
	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;
	

	public List<Deltager> hentUtDeltagere(){
		List<Deltager> liste = em.createQuery("SELECT d FROM Deltager d", Deltager.class).getResultList();
		return liste;
	}
	public boolean eksistererBrukernavn(String brukernavn) {
		try { 
		String funnet = em.find(Deltager.class, brukernavn).getBrukernavn();
		
		} catch(NullPointerException e) {
				return false;
		}
		return true;
	}
	
	public String hentUtPassord(String brukernavn) {
		return em.find(Deltager.class, brukernavn).getPassord();
	}
	public void leggTilDeltager(Deltager d) {
		em.persist(d);
	}
}
