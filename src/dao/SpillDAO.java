package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Prosjekt1Pakke.Spill;
import Prosjekt1Pakke.Spiller;

@Stateless
public class SpillDAO {
		
		@PersistenceContext(name ="YatzyPU")
		private EntityManager em;
		
		
		public List<Spiller> hentAlleSpillere(int spillID) {
			return em.find(Spill.class, spillID).getSpillere();
		}
		
		public Spiller hentBestemtSpiller(int spillerID) {
			return em.find(Spiller.class, spillerID);
		}
		
		public void lagreNySpiller(String navn) {
			em.persist(new Spiller(navn));
		}
}