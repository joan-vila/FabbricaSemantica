package fabbricaSemantica;

import static def.jquery.Globals.$;

import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Pagina definitionAnnotation.html
 * @author Joan
 *
 */
public class DefinitionAnnotation extends BasePage 
{
	/**
	 * Taks
	 */
	public static final Task task = Task.DEFINITION_ANNOTATION;
	
	/**
	 * parametri back-end
	 */
	public static final String WORD = "word";
	public static final String HYPERNYM = "hypernym";
	public static final String DEFINITION = "definition";
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public DefinitionAnnotation() 
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
				.addTaskHeading("Data la seguente parola e il suo iperonimo, fornire una definizione nella propria lingua")
				)
		.addFormGroup(
				form.formGroup()
				.addHeading(6, WORD)
				.addReadOnlyInput(WORD, json.$get(WORD))	
				.addHeading(6, HYPERNYM)
				.addReadOnlyInput(HYPERNYM, json.$get(HYPERNYM))
				)
		.addFormGroup(
				form.formGroup()
				.addTextArea(DEFINITION, "scrivi qui la definizione", true)
				);
		addFormButtons();
	}
	
	/**
	 * Inizializza la paggina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		DefinitionAnnotation page = new DefinitionAnnotation();
		page.checkSession();
	}
}
