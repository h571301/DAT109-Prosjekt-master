package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SpillDAO;
import klasser.Poeng;
import klasser.Spill;
import klasser.Spiller;

/**
 * Servlet implementation class spilleServlet
 */


@WebServlet("/yatzyServlet") 
public class spilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	@EJB
	private SpillDAO dao; 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/index.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// ************* TEST - START ************* 
		
		// ************* SETUP  ************* 
		// Kan bare kjøres en gang også må det kommenteres ut
		
		// Metodene nedenfor som oppretter Spill, Spiller og Poeng 
		// burde plasseres i en egen servlet  som en setUpServlet. 
		
		Spill Rom_1 = new Spill(1, "Rom_1");
		Spill Rom_2 = new Spill(2, "Rom_2");
		Poeng poengMons = new Poeng(35);
		Poeng poengSiv = new Poeng(42);
		Spiller Mons = new Spiller(1, "Mons", Rom_1, poengMons);
		Spiller Siv = new Spiller(3, "Siv", Rom_1, poengSiv);
		
		
		dao.lagreNyttSpill(Rom_1);
		dao.lagreNyttSpill(Rom_2);
		
		dao.lagreNyPoengListe(poengMons);
		dao.lagreNyPoengListe(poengSiv);
		
		dao.lagreNySpiller(Mons);
		dao.lagreNySpiller(Siv);
		
		// ************* SETUP  ************* 
		
		
		// ************* OPPDATERER POENG  ************* 
		
		List<Spill> alleSpill = dao.hentAlleSpill();
		
		Spill spill1 = alleSpill.get(0);
		
		List<Spiller> alleSpillereISpill1 = spill1.getSpillere();
		
		Spiller spiller1 = alleSpillereISpill1.get(0);
		
		// Bruker her en annen måte å oppdatere poeng på men skal gå fint 
		// å bruke metoden oppdaterScore() i spiller i stedet for. 
		spiller1.getPoeng().setEnere(3);
		spiller1.getPoeng().oppdaterSummer();
		
		spill1.oppdaterSpiller(0, spiller1);
		
		dao.oppdaterSpill(spill1);
		
		// ************* OPPDATERER POENG  ************* 
		
		// ************* TEST - SLUTT ************************
		
		request.getRequestDispatcher("WEB-INF/index.html").forward(request, response);
		

		
		}
	

}
