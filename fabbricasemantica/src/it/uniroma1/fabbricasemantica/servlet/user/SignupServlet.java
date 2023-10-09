package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Gestisce la registrazione dell'utente.
 * @author Joan
 *
 */
@WebServlet(name="SignupServlet", urlPatterns="/signup.jsp")
public class SignupServlet extends BaseServlet 
{
	private static final long serialVersionUID = 8484501789787L;
	
	/**
	 * Si tenta la registrazione. Se andata a buon fine si inoltra la richiesta alla servlet di login per l'accesso.
	 * Altrimenti si ricarica la pagina.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean registrato = signup(request.getParameter("email"), 
				request.getParameter("password"), 
				request.getParameter("passwordRepeat"), 
				request.getParameter("EN"), 
				request.getParameter("IT"), 
				request.getParameter("altreLingue"));
		
		if (registrato) 
		{
			//response.sendRedirect("login.html");
			String nextJSP = "/login.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
		}
		else response.sendRedirect("signup.html");

	}
	
	/**
	 * Metodo privato che controlla l'iscrizione. Se l'utente non e' gia' iscritto si tenta la registrazione.
	 * @param email
	 * @param pass1	password
	 * @param pass2 password di conferma
	 * @param en madrelingua inglese
	 * @param it madrelingua italiano
	 * @param altro	altre lingue parlate
	 * @return true se la registrazione e' andata a buon fine. 
	 * @return false se l'utente e' gia' registrato, se ci sono problemi di accesso al database, o se le password inserite dall'utente non combaciano;
	 */
	private boolean signup(String email, String pass1, String pass2, String en, String it, String altro)
	{
		final String PATH = getServletContext().getRealPath("WEB-INF/resources/users.csv");
		
		if (!pass1.equals(pass2)) return false;
		
		// controlla se e' gia' iscritto
		try(BufferedReader br = Files.newBufferedReader(Paths.get(PATH)))
		{
			if (br.lines().anyMatch(s -> s.startsWith(email))) 
				return false;
		}
		catch(IOException e )
		{
			e.printStackTrace();
			return false;
		}
		
		String inglese = en == null ? "f" : "t";
		String italiano = it == null ? "f" : "t";
		String csv = email+","+pass1+","+inglese+","+italiano;
		if (altro.isEmpty()) csv+="\n";
		else csv+=","+altro+"\n";
		
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(PATH), StandardCharsets.UTF_8, StandardOpenOption.APPEND))
		{
			bw.append(csv);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
