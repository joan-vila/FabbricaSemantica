package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet per la radice del sito web. Se gia' loggato redirige alla home, altrimenti alla pagina di login.
 * @author Joan
 */
@WebServlet(name="RootServlet", urlPatterns="")
public class RootServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8247320116050759369L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		boolean isLoggedIn = session.getAttribute("email") != null;
		
		if (isLoggedIn) response.sendRedirect("home.html");
		else response.sendRedirect("login.html");
	}
}
