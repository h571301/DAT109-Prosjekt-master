package loggInn;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeltagerDAO;

@WebServlet("/DeltagerServlet")
public class DeltagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO dao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<Deltager> studenter = dao.hentUtDeltagere();
		
		String[] names = new String[studenter.size()];

		for (int i = 0; i < studenter.size(); i++) {
			names[i] = studenter.get(i).getBrukernavn();
		} 

		request.setAttribute("names", names);
		request.getRequestDispatcher("WEB-INF/Deltager.jsp").forward(request, response);

	}
}