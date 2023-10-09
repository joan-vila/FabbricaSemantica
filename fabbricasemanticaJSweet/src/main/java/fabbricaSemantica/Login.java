package fabbricaSemantica;

import fabbricaSemantica.DivBuilder.InputType;

/**
 * Pagina login.html
 * @author Joan
 *
 */
public class Login extends UserPage
{
	/**
	 * Servlet a cui mandare i dati del form di login
	 */
	public static final String SERVLET_URL = "login.jsp";
	
	/**
	 * Costruisce la pagina richiamando il costruttore della superclasse (che imposta il titolo)
	 * e costruendo il form con gli elementi html necessari
	 */
	public Login()
	{	
		super("login");
		
		new FormBuilder(SERVLET_URL)
			.addFormGroup(
					new DivBuilder("form-group")
					.addHeading(3, "Sign in")
					.build())
			.addFormGroup(
					new DivBuilder("form-group")
					.addInput("email", "insert email...", InputType.EMAIL, true)
					.addInput("password", "insert password...", InputType.PASSWORD, true)
					.build())
			.addFormGroup(
					new DivBuilder("form-group")
					.addLinkButton("signup.html", "signup", true)
					.addSubmit("login")
					.build())
			.build();
	}
	
	/**
	 * inizializza la pagina e controlla la sessione.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Login page = new Login();
		page.checkSession();
	}
}
