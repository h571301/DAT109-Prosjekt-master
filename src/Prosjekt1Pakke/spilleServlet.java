package Prosjekt1Pakke;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SpillDAO;

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
		
		Spiller spiller = new Spiller();
		
		spiller.oppdaterScore(request, response);
		
		spiller.printScore();
		session.setAttribute("poeng", spiller.getPoeng());
		//response.sendRedirect("spillYahtzee");
		
		request.getRequestDispatcher("WEB-INF/index.html").forward(request, response);

		
	
		
		}
	

}
