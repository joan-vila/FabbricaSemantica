package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;
import fabbricaSemantica.DivBuilder.SelectionType;

/**
 * Pagina senseValidation.html
 * @author Joan
 */
public class SenseValidation extends BasePage 
{
	/**
	 * Task
	 */
	public static final Task task = Task.SENSE_VALIDATION;
	/**
	 * parametri back-end
	 */
	public static final String[] PARAMS = { "word", "example", "sense", "response" };
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public SenseValidation()
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
		form.addFormGroup(form.formGroup()
				.addTaskHeading("Data la seguente parola e frase in cui appare, verificare se il senso fornito dal sistema è appropriato:"))
		.addFormGroup(form.formGroup()
				.addHeading(6, "Word:")
				.addReadOnlyInput(PARAMS[0], json.$get(PARAMS[0]))
				.addHeading(6, "Example:")
				.addReadOnlyInput(PARAMS[1], json.$get(PARAMS[1]))
				.addHeading(6, "Sense:")
				.addReadOnlyInput(PARAMS[2], json.$get(PARAMS[2])))
		.addFormGroup(form.formGroup()
				.addSelection(PARAMS[3], "Sì", SelectionType.RADIO, true)
				.addSelection(PARAMS[3], "No", SelectionType.RADIO, true));
		
		addFormButtons();
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		SenseValidation page = new SenseValidation();
		page.checkSession();
	}
}
