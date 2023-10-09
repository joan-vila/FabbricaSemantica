package fabbricaSemantica;

import static def.dom.Globals.confirm;
import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

/**
 * Classe astratta che definisce un metodo di controllo sessione.
 * Sara' utilizzata dalle pagine signup e login.
 * @author Joan
 */
public abstract class UserPage 
{
	/**
	 * indirizzo da cui reperire lo status dell'utente
	 */
	public static final String SERVLET_URL = "isLoggedIn.jsp";
	
	/**
	 * Costruisce la pagina impostando il suo titolo.
	 * @param title
	 */
	public UserPage(String title)
	{
		document.title = title;
	}
	
	/**
	 * Caricata la pagina, controlla che l'utente sia loggato, delegando il controllo al metodo privato checkSessionPrivate.
	 */
	protected void checkSession()
	{
		window.onload = (e) -> { checkSessionPrivate(); return null; };
	}
	
	/**
	 * Controlla che l'utente sia loggato. 
	 * Crea un box di conferma per notificare l'utente, e reindirizza alla pagina di login o home a seconda dei casi.
	 */
	private void checkSessionPrivate()
	{
		$.getJSON(SERVLET_URL, (Object result, String a, JQueryXHR ctx) -> {
			boolean isLoggedIn = (boolean) result;
			if (isLoggedIn) 
			{
				boolean logout = confirm("You're already logged in. Please logout first.").booleanValue();
				if (logout) window.location.replace("logout.jsp");
				else window.location.replace("home.html");
			}
			return null;
		});
	}
}
