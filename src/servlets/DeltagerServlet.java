package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DeltagerDAO;
import klasser.Deltager;
/**
 * @author Prosjektgrupe 4
 */
@WebServlet("/Deltagere")
public class DeltagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

		@EJB
		private DeltagerDAO dao;
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			List<Deltager> deltagere = dao.hentUtDeltagere();
			System.out.println(deltagere);
			
			
			HttpSession session = request.getSession();
			session.setAttribute("deltagere", deltagere);
	 		

			request.getRequestDispatcher("WEB-INF/deltager.jsp").forward(request, response);
		}

	}

