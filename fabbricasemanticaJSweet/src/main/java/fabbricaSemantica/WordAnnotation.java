package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;
import fabbricaSemantica.DivBuilder.InputType;

/**
 * Pagina wordAnnotation.html
 * @author Joan
 */
public class WordAnnotation extends BasePage 
{
	/**
	 * Task
	 */
	public static final Task task = Task.WORD_ANNOTATION;
	/**
	 * Parametri back-end
	 */
	public static final String[] PARAMS = { "description", "word" };
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public WordAnnotation() {
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
					new DivBuilder("form-group")
						.addTaskHeading("Data la seguente definizione in inglese, si provi a fornire la parola definita:")
						.build())
			.addFormGroup(
					new DivBuilder("form-group")
						.addReadOnlyInput(PARAMS[0], json.$get(PARAMS[0]))
						.addInput(PARAMS[1], "scrivi qui la parola...", InputType.TEXT, true)
						.build());
		addFormButtons(); // adds SKIP and NEXT to form, and form to body
		
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		WordAnnotation page = new WordAnnotation();
		page.checkSession();
	}
}
