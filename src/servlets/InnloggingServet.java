package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeltagerDAO;
import dao.SpillDAO;
import klasser.Deltager;
import klasser.Poeng;
import klasser.Spill;
import klasser.Spiller;

/**
 * Servlet implementation class InnloggingServet
 */
@WebServlet("/innloggingServlet")
public class InnloggingServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private SpillDAO dao;

	@EJB
	private DeltagerDAO daoDeltagere;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getRequestDispatcher("WEB-INF/innlogging.html").forward(request,
		// response);

//		dao.slettSpill(1);

		List<Deltager> deltagere = daoDeltagere.hentUtDeltagere();
		System.out.println("Deltagere " + deltagere);

		List<String> navn = new ArrayList<String>();
//		navn.add(request.getParameter("player1"));
//		navn.add(request.getParameter("player2"));
//		navn.add(request.getParameter("player3"));
//		navn.add(request.getParameter("player4"));

		for (Deltager deltager : deltagere) {
			navn.add(deltager.getBrukernavn());
		}
		if (dao.finnesSpill(1)) { // reset spill
			Spill spill = dao.hentBestemtSpill(1);
			List<Spiller> spillere = spill.getSpillere();
			
			for (Spiller spiller : spillere) {
				int poengID = spiller.getPoeng().getPoengID();
				spiller.resetPoeng(poengID);
				dao.oppdaterNyPoengListe(spiller.getPoeng());
			}
		} else {
			int x = 1;

			Spill spill = new Spill(1, "Spill1");
			dao.lagreNyttSpill(spill);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			List<Spiller> spillere = new ArrayList<Spiller>();
			for (String spiller : navn) {
				if (spiller != null && spiller.compareTo("") != 0) {
					System.out.println("Spiller : " + spiller + " Is being added...");
					Spiller s1 = new Spiller(x, spiller, spill, new Poeng(x));
					dao.lagreNyPoengListe(s1.getPoeng());
					dao.lagreNySpiller(s1);
					spillere.add(s1);
				} else
					break;
				x++;
			}
		}
		response.sendRedirect("yatzyServlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
