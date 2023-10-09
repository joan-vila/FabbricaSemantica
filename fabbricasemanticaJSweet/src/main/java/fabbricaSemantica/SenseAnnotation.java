package fabbricaSemantica;

import static def.jquery.Globals.$;


import def.jquery.JQueryXHR;
import def.js.JSON;
import fabbricaSemantica.DivBuilder.SelectionType;

/**
 * Pagina senseAnnotation.html
 * @author Joan
 */
public class SenseAnnotation extends BasePage 
{
	/**
	 * Task
	 */
	public static final Task task = Task.SENSE_ANNOTATION;
	
	/**
	 * parametri back-end
	 */
	public static final String WORD = "word";
	public static final String DESCRIPTION = "description";
	public static final String SENSES = "senses";
	
	/**
	 * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
	 * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
	 */
	public SenseAnnotation()
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
				.addTaskHeading("Seleziona il significato corretto della seguente parola nell'ambito della frase data:"))
		.addFormGroup(
				form.formGroup()
				.addHeading(6, "Word:")
				.addReadOnlyInput(WORD, json.$get(WORD))
				.addHeading(6, "Description:")
				.addReadOnlyInput(DESCRIPTION, json.$get(DESCRIPTION)));
		
		String[] senses = json.$get("senses");
	
		DivBuilder formGroup = new DivBuilder("form-group");
		
		for (String sense : senses) formGroup.addSelection("response", sense, SelectionType.RADIO, true);
		
		form.addFormGroup(formGroup);
		
		addFormButtons();
	}
	
	/**
	 * Inizializza la pagina e controlla la sessione.
	 */
	public static void main(String[] args) 
	{
		SenseAnnotation page = new SenseAnnotation();
		page.checkSession();
	}
}
