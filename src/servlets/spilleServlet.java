package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.mail.Session;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget blir kjørt");
		HttpSession session = request.getSession();
//		if (session.getAttribute("rundeID") == null) // Setter start verdi for rundeID, rundeID blir økt lengre nede.
//		{
//			
//			session.setAttribute("rundeID", 1);
//			
//		}
		
		
		/* *** KJØR EN GANG FOR Å SETTE OPP SPILLERE!!! *** 
		
		Spill spill = new Spill(1, "Spill1");
		Spiller s1 = new Spiller(1, "Per", spill, new Poeng(1));
		Spiller s2 = new Spiller(2, "Petter", spill, new Poeng(2));
		Spiller s3 = new Spiller(3, "Pelle", spill, new Poeng(3));



		
		dao.lagreNyttSpill(spill);
		dao.lagreNyPoengListe(s1.getPoeng());
		dao.lagreNyPoengListe(s2.getPoeng());
		dao.lagreNyPoengListe(s3.getPoeng());

		dao.lagreNySpiller(s1);
		dao.lagreNySpiller(s2);
		dao.lagreNySpiller(s3);
		
	*/

		int spillID = 1; // Må hentes i framtiden når det blir laget flere spill.
		List<Spiller> spillere;
		spillere = dao.hentAlleSpillere(spillID);
		session.setAttribute("spillere", spillere);
		
		int x = 0;
		int poengpos = 0;
		int rundeID = 0;
		boolean funnet = false;
		while (!funnet) {
			if (spillere.size() <= x) {
				x = 0;
				poengpos++;
			}
			
			Spiller spiller = spillere.get(x);
			List<Integer> poengliste = spiller.getPoeng().lagrePoengSomListe();

			if(poengliste.size() <= poengpos){
				System.err.println("Fant ingen spiller med -1 poeng verdi, spillet er ferdig.");
				break;
			}
			
			if (spillere.get(0).getSpillerID() == spiller.getSpillerID())
				rundeID++;

			if (poengliste.get(poengpos) == -1) {
				session.setAttribute("spillerID", spiller.getSpillerID());
				session.setAttribute("rundeID", rundeID);
				funnet = true;
			}
			
			else
				x++;
		}

//		int spillerID;
//		if (session.getAttribute("spillerID") == null) // *** Begynner på starten av listen.
//			session.setAttribute("spillerID", spillere.get(0).getSpillerID());

//		else if (spillere.size() > (int) session.getAttribute("spillerID"))
//			session.setAttribute("spillerID", spillere.get((int) session.getAttribute("spillerID")).getSpillerID());
//		else {
//			// *** Starter på nytt i spillere, og øker RundeID ***
//			session.setAttribute("spillerID", spillere.get(0).getSpillerID());
//			session.setAttribute("rundeID", (int) session.getAttribute("rundeID") + 1);
//		}

		System.out.println("runde ID: " + session.getAttribute("rundeID"));
		System.out.println("spiller ID: " + session.getAttribute("spillerID"));

		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost blir kjørt");

		HttpSession session = request.getSession();

		// ************* TEST - START *************

		// ************* SETUP *************
		// Kan bare kjøres en gang også må det kommenteres ut

		// Metodene nedenfor som oppretter Spill, Spiller og Poeng
		// burde plasseres i en egen servlet som en setUpServlet.

		// ************* SETUP *************

		List<Spiller> spillere = dao.hentAlleSpillere(1);
		System.out.println(session.getAttribute("spillerID"));
		Spiller spiller = dao.hentBestemtSpiller((int) session.getAttribute("spillerID"));
		spiller.oppdaterScore(request, response);
		System.out.println("Etter oppdatering: " + spiller.getPoeng().lagrePoengSomListe());
		dao.oppdaterNyPoengListe(spiller.getPoeng());



		// ************* SLUTT ************************
		response.sendRedirect("yatzyServlet");

		// request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

	}

}
