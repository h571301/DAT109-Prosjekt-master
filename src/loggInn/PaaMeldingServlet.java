package loggInn;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeltagerDAO;


@WebServlet("/PaaMeldingServlet")
public class PaaMeldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeltagerDAO dao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/reg.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Skjema skjema = new Skjema(request);		
	HttpSession sesjon = request.getSession(false);
	if(!dao.eksistererBrukernavn(skjema.getBrukernavn()) && skjema.erAllDataGyldig()) {
		
		Deltager d = skjema.lagDeltager();
		
		synchronized (d) {
		dao.leggTilDeltager(d);
		}
		skjema.gjemPassord();
		
		sesjon.setAttribute("skjema", skjema);
	
		response.sendRedirect("login");	
	} else {
		skjema.setFeilmelding();
		sesjon.setAttribute("skjema", skjema);
		response.sendRedirect("PaaMeldingServlet");
	}
	
	}

}
