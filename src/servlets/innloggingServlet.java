package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import klasser.Poeng;
import klasser.Spill;
import klasser.Spiller;


@WebServlet("/innloggingServlet")
public class innloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/innlogging.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String s1 = request.getParameter("player1");
		String s2 = request.getParameter("player2");
		String s3 = request.getParameter("player3");
		String s4 = request.getParameter("player4");
	
		
		
		
		if(s2 != null) {
			
		}
		
		
	}

}
