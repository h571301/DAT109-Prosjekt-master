package servlets;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.SpillDAO;

import klasser.Poeng;
import klasser.Spill;
import klasser.Spiller;

public class test {
	@EJB
	private static SpillDAO dao;
	
	@PersistenceContext(name ="YatzyPU")
	private EntityManager em;
	
	public static void main(String[] args) {
		
	}
}	
