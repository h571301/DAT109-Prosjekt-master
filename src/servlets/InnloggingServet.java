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

import dao.SpillDAO;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/innlogging.html").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> navn = new ArrayList<String>();
		navn.add(request.getParameter("player1"));
		navn.add(request.getParameter("player2"));
		navn.add(request.getParameter("player3"));
		navn.add(request.getParameter("player4"));
		
		int x = 1;
		
		Spill spill = new Spill(1, "Spill1"); 
		dao.lagreNyttSpill(spill);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (String spiller : navn) {
			if (spiller != null && spiller.compareTo("") != 0) {
				System.out.println("Spiller : "+spiller+" Blir lagt til");
				Spiller s1 = new Spiller(x, spiller, spill, new Poeng(x));
				dao.lagreNyPoengListe(s1.getPoeng());
				dao.lagreNySpiller(s1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else
				break;
			x++;
		}
		System.out.println("Generating Yatzy...");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		response.sendRedirect("yatzyServlet");

	}

}
