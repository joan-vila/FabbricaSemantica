package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Pagina stranslationAnnotation.html
 * @author Joan
 */
public class TranslationAnnotation extends BasePage 
{
	/**
	 * Task
	 */
	public static final Task task = Task.TRANSLATION_ANNOTATION;
	/**
	 * parametri back-end
	 */
	public static final String[] PARAMS = { "word", "description", "translation" };
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public TranslationAnnotation() 
	{
		super(task);
		
		$.getJSON(REST_URL, "task="+task.name(), (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			buildPage(json);
			return null;
		});
	}
	
	/**
	 * Costruisce il form
	 * @param json
	 */
	private void buildPage(JSON json)
	{
		form.addFormGroup(
				form.formGroup()
					.addHeading(5, "Data la seguente parola e definizione, fornisci una traduzione nella tua lingua madre:"))
		
			.addFormGroup(
					form.formGroup()
						.addHeading(6, "Word:")
						.addReadOnlyInput(PARAMS[0], json.$get(PARAMS[0]))
						.addHeading(6, "Description:")
						.addReadOnlyInput(PARAMS[1], json.$get(PARAMS[1]))
						.build())
			.addFormGroup(
					form.formGroup()
						.addTextArea(PARAMS[2], "scrivi qui la traduzione...", true));
		addFormButtons();// does $("body").append(form)
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		TranslationAnnotation page = new TranslationAnnotation();
		page.checkSession();
	}


}
