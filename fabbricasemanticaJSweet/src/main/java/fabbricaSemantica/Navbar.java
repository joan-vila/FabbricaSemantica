package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;

/**
 * Barra di navigazione con un link alla pagina home.html e un bottone che effettua il logout.
 * Verra' ereditato da dalla classe che costruisce la pagina home.html, e da tutti i task di annotazione.
 * @author Joan
 */
public class Navbar 
{
	/**
	 * Div che rappresenta la navbar.
	 */
	private HTMLDivElement navbar;

	/**
	 * Costriisce la navbar e la aggiunge al tag body della pagina html.
	 */
	public Navbar()
	{
		
		HTMLDivElement right = new DivBuilder("navbar-nav ml-auto") // Bootstrap. Right align.
				.addLinkButton("logout.html", "Logout", true)
				.build();
		
		navbar = new DivBuilder("navbar navbar-expand navbar-dark bg-dark")
				.addLink("home.html", "Home", "navbar-brand")
				.appendDiv(right)
				.build();
		
		$("body").append(navbar);
	}
}
