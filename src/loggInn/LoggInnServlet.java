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


@WebServlet("/login")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DeltagerDAO dao;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	LoggInnSkjema skjema = new LoggInnSkjema(request);
	System.out.println(skjema.getBrukernavn());
	if(skjema.sjekkOmInnlogget(dao)) {
		
	HttpSession sesjon = request.getSession(false);
	
	if(sesjon != null) {
		sesjon.invalidate();
	}

	sesjon = request.getSession(true);
	
	sesjon.setAttribute("loggetInn", skjema.getBrukernavn());
	
		response.sendRedirect("Deltagere");
	} else {
		skjema.feilMelding();
		request.getSession().setAttribute("skjema", skjema);
		response.sendRedirect("loggInnServlet");
	}
	}

}
