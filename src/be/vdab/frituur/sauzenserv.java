package be.vdab.frituur;

import java.io.IOException;
import be.vdab.repository.SausRepository;

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
    private final SausRepository sausRepository = new SausRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setAttribute("sauzen", sausRepository.findAll());
    	request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
