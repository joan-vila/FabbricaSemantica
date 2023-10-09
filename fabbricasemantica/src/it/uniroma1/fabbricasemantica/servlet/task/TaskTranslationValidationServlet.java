package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma1.fabbricasemantica.data.DataSaver;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

@WebServlet(name = "TaskTranslationValidationServlet", urlPatterns = "/translationValidation.jsp")
public class TaskTranslationValidationServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * Percorso del database.
	 */
	private static final String PATH = "WEB-INF/resources/task/translationValidation.csv";
	/**
	 * Parametri da salvare nel database.
	 */
	private static final List<String> parameters = List.of("word", "description", "response");
	/**
	 * DataSaver. Vedi @Class DataSaver.
	 */
	private DataSaver dataSaver;
	
	/**
	 * Costruttore della servlet. Inizializza il DataSaver passando in input il @field PATH.
	 */
	@Override
	public void init() throws ServletException
	{
		super.init();
		dataSaver = new DataSaver( getServletContext().getRealPath(PATH) );
	}
	
	/**
	 * Salva i valori dei parametri della request tramite DataSaver. 
	 * Vengono presi in considerazione solo i parametri del tipo contenuto nel @field parameters. 
	 */
	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		boolean isLoggedIn = session.getAttribute("email") != null;

		if (!isLoggedIn) response.sendRedirect("login.html");
		
		dataSaver.save(
				parameters.stream()
				.map(request::getParameter)
				.collect(Collectors.toList()));
		
		//reinderizzare a un task a caso.
		response.sendRedirect("randomTask.jsp");
	}

}
