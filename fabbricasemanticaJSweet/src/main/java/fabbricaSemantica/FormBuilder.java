package fabbricaSemantica;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import jsweet.util.StringTypes;

/**
 * Classe adibita alla costruzione del form. 
 * Definita tenendo in mente Bootstrap, dispone di metodi per aggiungere div al form. I div avranno, nella maggior parte dei casi class="form-group", per 
 * permettere a bootstrap di gestire il form adeguatamente.
 * Per questioni di versatilita' dispone di metodi per aggiungere al form div arbitrari, e DivBuilder (vedi @Class DivBuilder).
 * Si e' scelto di utilizzare il Builder pattern.
 * @author Joan
 */
public class FormBuilder 
{	
	/**
	 * Form
	 */
	private HTMLFormElement form;
	
	/**
	 * Metodi di richiesta del form.
	 * Nell'ambito di questo progetto verra utilizzato solamente il metodo POST.
	 * @author Joan
	 */
	public enum Method { POST, GET } // usare sempre POST come metodo
	
	/**
	 * Costruttore del FormBuilder.
	 * @param action indirizzo della servlet.
	 * @param method POST.
	 * @param className per classi Bootstrap.
	 */
	public FormBuilder(String action, Method method, String className)
	{
		form = document.createElement(StringTypes.form);
		form.action = action;
		form.method = method.name();
		form.className = className;		// Bootstrap
	}
	
	/**
	 * Secondo costruttore della classe. 
	 * @param action indirizzo della servlet.
	 */
	public FormBuilder(String action)
	{
		this(action, Method.POST, "rounded"); // Rounded = Bootstrap class
	}
	
	/**
	 * Seguendo il builder pattern, aggiunge un div al form e ritorna se stesso.
	 * @param formGroup il div da aggiungere al form.
	 * @return se stesso.
	 */
	public FormBuilder addFormGroup(HTMLDivElement formGroup)
	{
		$(form).append(formGroup);
		return this;
	}
	
	/**
	 * Seguendo il builder pattern, aggiunge un DivBuilder al form e ritorna se stesso.
	 * @param formGroup il DivBuilder da aggiungere al form.
	 * @return se stesso.
	 */
	public FormBuilder addFormGroup(DivBuilder formGroup)
	{
		$(form).append(formGroup.build());
		return this;
	}
	
	/**
	 * Restituisce un DivBuilder con classe "form-group".
	 * Usato per associare logicamente la costruzione del DivBuilder al form.
	 * @return
	 */
	public DivBuilder formGroup()
	{
		return new DivBuilder("form-group");
	}
	
	/**
	 * Aggiunge il form al body della pagina.
	 */
	public void build() 
	{
		$("body").append(form);
	}
}


