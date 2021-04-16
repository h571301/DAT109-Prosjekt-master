package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
 * @author Prosjektgrupe 4
 */
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

		List<Spiller> spillere;

		spillere = dao.hentAlleSpillere2();
		session.setAttribute("spillere", spillere);
		int x = 0;
		int poengpos = 0;
		int rundeID = 0;
		boolean funnet = false;

		// *** Finner rundeID og spillerID ****
		while (!funnet) {
			if (spillere.size() <= x) {
				x = 0;
				poengpos++;
			}

			Spiller spiller = spillere.get(x);
			List<Integer> poengliste = spiller.getPoeng().lagrePoengSomListe();

			if (poengliste.size() <= poengpos) {
				System.err.println("Fant ingen spiller med -1 poeng verdi, spillet er ferdig.");
				List<Spiller> top = spillere;
				top.sort((Spiller s1, Spiller s2) -> s1.compareTo(s2));

				// System.out.println("Vinner: " +top.get(0).getNavn());

				session.setAttribute("firstPlace", top.get(0).getNavn());
				if (spillere.size() > 1)
					session.setAttribute("secondPlace", top.get(1).getNavn());
				if (spillere.size() > 2)
					session.setAttribute("thirdPlace", top.get(2).getNavn());

				dao.slettDB();

				request.getRequestDispatcher("WEB-INF/resultat.jsp").forward(request, response);
				return;
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

		System.out.println("runde ID: " + session.getAttribute("rundeID"));
		System.out.println("spiller ID: " + session.getAttribute("spillerID"));

		request.getRequestDispatcher("WEB-INF/spill.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost blir kjørt");

		HttpSession session = request.getSession();

		// *** Oppdaterer Score ***

		Spiller spiller = dao.hentBestemtSpiller((int) session.getAttribute("spillerID"));
		spiller.oppdaterScore(request, response);
		System.out.println("Etter oppdatering: " + spiller.getPoeng().lagrePoengSomListe());
		dao.oppdaterNyPoengListe(spiller.getPoeng());

		// *** Ferdig ***
		response.sendRedirect("yatzyServlet");

	}

}
