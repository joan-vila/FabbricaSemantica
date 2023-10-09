package fabbricaSemantica;

import fabbricaSemantica.DivBuilder.InputType;
import fabbricaSemantica.DivBuilder.SelectionType;

/**
 * Pagina signup.html
 * @author Joan
 *
 */
public class Signup extends UserPage
{
	/**
	 * indirizzo a cui mandare i dati di registrazione.
	 */
	public static final String SERVLET_URL = "signup.jsp";
	
	/**
	 * Costruisce la pagina richiamando il costruttore della superclasse (che imposta il titolo).
	 * Aggiunge al form tutti gli input necessari.
	 */
	public Signup()
	{	
		super("signup");
		
		new FormBuilder(SERVLET_URL)
			.addFormGroup(
					new DivBuilder("form-group")
						.addHeading(3, "Sign up")
						.addInput("email", "email...", InputType.EMAIL, true)
						.addInput("password", "password...", InputType.PASSWORD, true)
						.addInput("passwordRepeat", "ripeti password...", InputType.PASSWORD, true)
						.build())
			.addFormGroup(
					new DivBuilder("form-group")
						.addHeading(6, "Seleziona le lingue di cui sei madrelingua:")
						.addSelection("EN", "Inglese", SelectionType.CHECKBOX, false)
						.addSelection("IT", "Italiano", SelectionType.CHECKBOX, false)
						.build())
			.addFormGroup(
					new DivBuilder("form-group")
						.addHeading(6, "Altre lingue parlate e livello:")
						.addInput("altreLingue", "lingua1 livello1, lingua2 livello2...", InputType.TEXT, false)
						.build())
			.addFormGroup(
					new DivBuilder("form-group")
						.addLinkButton("login.html", "login", true)
						.addSubmit("signup")
						.build())
			.build();
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		Signup page = new Signup();
		page.checkSession();
	}
}
