package Prosjekt1Pakke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		Spiller s1 = new Spiller("Ole");
		Spiller s2 = new Spiller("Kari");
		Spiller s3 = new Spiller("Fredrik");
		
		
		List<Spiller> spillere = new ArrayList<Spiller>();
		spillere.add(s1);
		spillere.add(s2);
		spillere.add(s3);
		HttpSession session = request.getSession(true);
		session.setAttribute("spillere", spillere);
		session.setAttribute("rundeID", 6);
		session.setAttribute("spillerID", s3.getSpillerID() );
		
		System.out.println("spillerID: " + s2.getSpillerID());
		
		
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//La in vilkårlig navn for å teste
//		 dao.lagreNySpiller("Mons");
//		 Spiller spiller = dao.hentBestemtSpiller(1);
//		System.out.println(request.getParameter("dice-value"));
//		spiller.oppdaterScore(request, response);
//		spiller.printScore();
		
	
		System.out.println("Verdiene på terningene er: " + request.getParameter("dice-value"));
		System.out.println("Id er: " + request.getParameter("dice-id"));
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		
		
		}
	

}