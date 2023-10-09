package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;
import fabbricaSemantica.DivBuilder.SelectionType;

/**
 * Pagina translationValidation.html
 * @author Joan
 *
 */
public class TranslationValidation extends BasePage 
{
	/**
	 * Taks
	 */
	public static final Task task = Task.TRANSLATION_VALIDATION;
	/**
	 * Parametri back-end
	 */
	public static final String[] PARAMS = { "word", "description", "translations", "response" };
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public TranslationValidation()
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
				.addTaskHeading("Data la seguente parola e relativa definizione, si scelga la traduzione migliore tra quelle fornite:"))
		.addFormGroup(
				form.formGroup()
				.addHeading(6, "Word:")
				.addReadOnlyInput(PARAMS[0], json.$get(PARAMS[0]))
				.addHeading(6, "Description")
				.addReadOnlyInput(PARAMS[1], json.$get(PARAMS[1])));
		
		String[] translations = json.$get(PARAMS[2]);
		
		DivBuilder formGroup = new DivBuilder("form-group");
		
		for (String t : translations) formGroup.addSelection(PARAMS[3], t, SelectionType.RADIO, true);
		formGroup.addSelection(PARAMS[3], "Nessuna", SelectionType.RADIO, true);
		
		form.addFormGroup(formGroup);
		addFormButtons();
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		new TranslationValidation();
	}
}
