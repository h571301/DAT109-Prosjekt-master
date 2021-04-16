package dao;


import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import klasser.Deltager;


/**
 * @author Prosjektgrupe 4
 */
@Stateless
public class DeltagerDAO {

	
	@PersistenceContext(name = "deltagerPU")
	private EntityManager em;
	
	/**
	 * Henter ut deltagere fra servlets.
	 * @return Liste med deltagere
	 */
	public List<Deltager> hentUtDeltagere(){
		List<Deltager> liste = em.createQuery("SELECT d FROM Deltager d", Deltager.class).getResultList();
		return liste;
	}
	
	/**
	 * Sjekker om brukernavn finnes.
	 * @param brukernavn
	 * @return boolean verdi basert på om brukernavnet finnes.
	 */
	public boolean eksistererBrukernavn(String brukernavn) {
		try { 
		String funnet = em.find(Deltager.class, brukernavn).getBrukernavn();
		
		} catch(NullPointerException e) {
				return false;
		}
		return true;
	}
	/**
	 * 
	 * @param brukernavn
	 * @return passord
	 */
	public String hentUtPassord(String brukernavn) {
		return em.find(Deltager.class, brukernavn).getPassord();
	}
	
	/**
	 * Legge til en deltager
	 * @param d
	 */
	public void leggTilDeltager(Deltager d) {
		em.persist(d);
	}
	

	
	
}
