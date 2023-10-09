package fabbricaSemantica;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;
import static def.dom.Globals.window;
import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;

/**
 * Classe astratta adibita alla costruzione delle pagine web dei task di annotazione.
 * Delinea alcune funzionalita di base:
 * - imposta il titolo della pagina;
 * - aggiunge il form al body della pagina, e lo inizializza con l'indirizzo della servlet di destinazione;
 * - definisce un metodo per l'aggiunta dei tasti SKIP e NEXT al form.
 * - definisce un metodo per controllare che l'utente sia loggato.
 * - definisce la servlet alla quale richiedere i dati per i task di annotazione e validazione;
 * Per ragioni di vicinanza logica e spaziale, si definisce un enum dei task di annotazione con relativi indirizzi servlet.
 * @author Joan
 */
public abstract class BasePage extends Navbar
{
	/**
	 * Servlet alla quale richiedere i task di annotazione e validazione.
	 */
	public static final String REST_URL = "nextExample.jsp";
	/**
	 * Form della pagina
	 */
	public FormBuilder form;
	
	/**
	 * Si imposta il titolo tramite tramite il metodo asTitle() dell'enum Task.
	 * Si imposta l'indirizzo di destinazione del form tramite il metodo getJsp() dell'enum Task.
	 * Si aggiunge un heading al form con il nome del task.
	 * @param task per cui costruire la pagina
	 */
	public BasePage(Task task)
	{
		document.title = task.asTitle();
		
		form = new FormBuilder(task.getJsp())
				.addFormGroup(
						new DivBuilder("form-group text-primary")
							.addHeading(3, task.asTitle())
							.build());	
	}
	
	/**
	 * Caricata la pagina, controlla che l'utente sia loggato, delegando il controllo al metodo privato checkSessionPrivate.
	 */
	protected void checkSession()
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
	
	/**
	 * Aggiunge il bottone SKIP e NEXT al form.
	 * SKIP: redirect a task casuale.
	 * NEXT: submit del form.
	 */
	protected void addFormButtons()
	{
		form.addFormGroup(
				form.formGroup()
					.addLinkButton("randomTask.jsp", "SKIP", false)
					.addSubmit("NEXT"))
			.build(); // does $("body").append(form);
	}
	
	/**
	 * Definisce tutti e soli i task di annotazione e validazione. Ad ogni Task viene associato il proprio indirizzo servlet.
	 */
	protected enum Task
	{
		TRANSLATION_ANNOTATION("translationAnnotation.jsp"),
		WORD_ANNOTATION("wordAnnotation.jsp"),
		DEFINITION_ANNOTATION("definitionAnnotation.jsp"),
		SENSE_ANNOTATION("senseAnnotation.jsp"),
		SENSE_VALIDATION("senseValidation.jsp"),
		TRANSLATION_VALIDATION("translationValidation.jsp")
		;
		
		private String jsp;
		
		Task(String jsp)
		{
			this.jsp = jsp;
		}
		/**
		 * @return indirizzo servlet del task
		 */
		public String getJsp() { return jsp; }
		/**
		 * @return nome del task, lowercase.
		 */
		public String asTitle() { return name().replace("_", " ").toLowerCase(); }
	}
}
