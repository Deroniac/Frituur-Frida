package be.vdab.frituur;

import be.vdab.entities.Gemeente;
import be.vdab.entities.Adres;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class frituurserv
 */
@WebServlet(urlPatterns = "/index.htm",name = "indexservlet")
public class frituurserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDate day = LocalDate.now();
		DayOfWeek weekdag = day.getDayOfWeek();
		request.setAttribute("openGesloten", weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ? "gesloten" : "open");
		request.setAttribute("locatie", new Adres("Mortelstraat", "21", new Gemeente("Diepenbeek", 3590)));
		request.getRequestDispatcher(VIEW).forward(request, response);
		request.setAttribute("telefoonNummerHelpDesk", request.getServletContext().getInitParameter("telefoonNummerHelpDesk"));
	}

}
