package loggInn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeltagerDAO;

@WebServlet("/Deltagere")
public class DeltagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@EJB
		private DeltagerDAO dao;

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			List<Deltager> studenter = dao.hentUtDeltagere();

			response.setContentType("text/plain");

			PrintWriter out = response.getWriter();

			studenter.forEach(out::println);

		}

	}
