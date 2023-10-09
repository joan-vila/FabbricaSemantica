package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Gestisce l'accesso al sito web.
 * @author Joan
 *
 */
@WebServlet(name="LoginServlet", urlPatterns="/login.jsp")
public class LoginServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8484501789787L;

	/**
	 * Se gia' loggato si restituisce un messaggio chiedendo di effettuare il logout.
	 * Altrimenti si tenta il login controllando le credenziali nel database di utenti.
	 * Se l'utente non e' registrato o il controllo fallisce si viene reinirizzati di nuovo alla pagina di login.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		boolean isLoggedIn = session.getAttribute("email") != null;
		
		if (isLoggedIn) response.getWriter().print("Alredy logged in! Please logout first.");
		
		
		boolean loggedIn = login(request.getParameter("email"), request.getParameter("password"));
		if (loggedIn)
		{
			session.setAttribute("email", request.getParameter("email"));
			response.sendRedirect("home.html");
		}
		else response.sendRedirect("login.html");
	}
	
	/**
	 * Metodo privato che controlla l'iscrizione e che le credenziali siano correte.
	 * @param email
	 * @param password
	 * @return true se le credenziali di accesso combaciano. false se non combaciano, se non è presente nel database o se ci sono problemi di accesso al database.
	 */
	private boolean login(String email, String password)
	{
		final String PATH = getServletContext().getRealPath("WEB-INF/resources/users.csv");
		
		Optional<String> user;
		// controlla se e' gia' iscritto
		try(BufferedReader br = Files.newBufferedReader(Paths.get(PATH)))
		{
			user = br.lines().filter( s -> s.startsWith(email)).findFirst();
		}
		catch(IOException e )
		{
			e.printStackTrace();
			return false;
		}
		
		if (!user.isPresent()) return false;
		else
		{
			String[] userData = user.get().split(",");
			return userData[0].equals(email) && userData[1].equals(password);
		}
	}
}
