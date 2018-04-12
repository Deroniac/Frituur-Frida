package be.vdab.frituur;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import be.vdab.entities.Saus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sauzenserv
 */
@WebServlet("/sauzen.htm")
public class sauzenserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Saus> sauzen = Arrays.asList(
				new Saus(3L, "Cocktail", Arrays.asList("room", "ketchup", "paprikapoeder")),
				new Saus(6L, "mayonaise", Arrays.asList("ei", "room")),
				new Saus(7L, "mosterd", Arrays.asList("mosterdzaad", "azijn", "zout")),
				new Saus(12L, "tartare", Arrays.asList("peterselie", "bieslook", "mayonaise")),
				new Saus(44L, "vinaigrette", Arrays.asList("azijn")));
		request.setAttribute("sauzen", sauzen);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
