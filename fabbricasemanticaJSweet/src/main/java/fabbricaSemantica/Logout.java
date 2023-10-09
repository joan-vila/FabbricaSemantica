package fabbricaSemantica;

import static def.dom.Globals.confirm;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

/**
 * Pagina di logout.
 * @author Joan
 *
 */
public class Logout 
{
	/**
	 * indirizzo da cui reperire lo status dell'utente
	 */
	public static final String SERVLET_URL = "isLoggedIn.jsp";
	
	/**
	 * Costruttore della pagina.
	 * Si limita a creare un box di conferma per verificare che l'utente sia davvero intenzionato a disconnettersi.
	 */
	public Logout()
	{
		$.getJSON(SERVLET_URL, (Object result, String a, JQueryXHR ctx) -> {
			boolean isLoggedIn = (boolean) result;
			if (isLoggedIn) 
			{
				boolean wantToLogout = confirm("Are you sure you want to log out?").booleanValue();
				if (wantToLogout) window.location.replace("logout.jsp");
				else window.location.replace("home.html");
			}
			else window.location.replace("login.html");
			return null;
		});
	}
	
	/**
	 * Caricata la pagina si carica il box di conferma
	 */
	public static void main(String[] args) 
	{
		window.onload = (e) -> { new Logout(); return null; };
	}
}
