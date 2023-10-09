package fabbricaSemantica;

import static def.dom.Globals.alert;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

/**
 * Pagina home.html
 * @author Joan
 *
 */
public class Home extends Navbar 
{
	/**
	 * indirizzo per il redirect a task casuale.
	 */
	public static final String SERVLET_URL = "randomTask.jsp";
	
	/**
	 * Costruise la pagina con un bottone start che reindirizza a un task casuale
	 */
	public Home()
	{	
		//rimuovo il link alla pagina home dal navbar visto che siamo nella home
		$(".navbar-brand").remove();
		
		new FormBuilder(SERVLET_URL)
			.addFormGroup(
					new DivBuilder("form-group")
						.addSubmit("START!")
						.build())
			.build(); // aggiunge al body
	}
			
	/**
	 * Caricata la pagina, controlla che l'utente sia loggato, delegando il controllo al metodo privato checkSessionPrivate.
	 */
	private void checkSession()
	{
		window.onload = (e) -> { checkSessionPrivate(); return null; };
	}
	
	/**
	 * Controlla che l'utente sia loggato. Crea un alert per notificare l'utente, e reindirizza alla pagina di login.
	 */
	private void checkSessionPrivate()
	{
		$.getJSON("isLoggedIn.jsp", (Object result, String a, JQueryXHR ctx) -> {
			boolean isLoggedIn = (boolean) result;
			if (!isLoggedIn) 
			{
				alert("You're not logged in. Please login first.");
				window.location.replace("login.html");
			}
			return null;
		});
	}
	
	public static void main(String[] args) 
	{		
		Home page = new Home();
		page.checkSession();
	}
}
