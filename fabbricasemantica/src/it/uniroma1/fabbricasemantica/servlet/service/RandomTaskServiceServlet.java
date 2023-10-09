package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet che che redirige a un task casuale.
 * @author Joan
 *
 */
@WebServlet(name="RandomTaskServlet", urlPatterns="/randomTask.jsp")
public class RandomTaskServiceServlet extends BaseServlet 
{
	private static final long serialVersionUID = -48464244125920125L;

	/**
	 * Una richiesta alla servlet redirige a un task casuale.
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		final List<String> tasks = List.of(
				"translationAnnotation.html",
				"wordAnnotation.html",
				"definitionAnnotation.html",
				"senseAnnotation.html",
				"translationValidation.html",
				"senseValidation.html");
				//"myAnnotation.html");
		
		String randomTask = tasks.get(new Random().nextInt(tasks.size()));
		response.sendRedirect(randomTask);
	}
}
