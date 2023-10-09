package fabbricaSemantica;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import jsweet.util.StringTypes;

/**
 * Classe adibita alla costruzione di elementi div HTML.
 * Si e' scelto di utilizzare un div in quanto molto versatile, e permette di raggruppare logicamente elementi HTML diversi.
 * Definita tenendo in mente Bootstrap, permette di definire l'attributo class del div, che consente di dare lo stile di bootstrap all'elemento.
 * Dispone di metodi per aggiungere al div diversi elementi HTML. Sono stati raggruppati logicamente per quanto possibile (Input e Selection).
 * Ho limitato gli elementi a quelli necessati nell'ambito di questo progetto, ma e' facile aggiungerne di altri,
 * grazie all'utilizzo del Builder pattern.
 * @author Joan
 *
 */
public class DivBuilder 
{
	/**
	 * Div
	 */
	HTMLDivElement div;
	
	/**
	 * Costruisce il div
	 */
	public DivBuilder()
	{
		div = document.createElement(StringTypes.div);
	}
	/**
	 * Costruisce il div impostando l'attributo class
	 * @param className nome della classe
	 */
	public DivBuilder(String className)
	{
		this();
		div.className = className;
	}
	
	/**
	 * Aggiunge una label al div.
	 * @param text testo della label.
	 * @return se stesso.
	 */
	public DivBuilder addLabel(String text)
	{
		HTMLLabelElement label = document.createElement(StringTypes.label);
		$(label).text(text);
		
		$(div).append(label);
		return this;
	}
	/**
	 * Aggiunge un heading al div.
	 * @param headingDimension dimensione dell'heading.
	 * @param text testo dell'heading.
	 * @return se stesso.
	 */
	public DivBuilder addHeading(int headingDimension, String text)
	{
		HTMLHeadingElement h = document.createElement(StringTypes.h3);
		switch(headingDimension)
		{
			case 1: h = document.createElement(StringTypes.h1); break;
			case 2: h = document.createElement(StringTypes.h2); break;
			case 3: h = document.createElement(StringTypes.h3);	break;
			case 4: h = document.createElement(StringTypes.h4);	break;
			case 5: h = document.createElement(StringTypes.h5); break;
			case 6: h = document.createElement(StringTypes.h6); break;
			default: h = document.createElement(StringTypes.h3);
		}
		$(h).text(text);
		$(div).append(h);
		return this;
	}
	
	/**
	 * Metodo di comodo per l'utilizzo nei task.
	 * @param text testo dell'heading
	 * @return se stesso.
	 */
	public DivBuilder addTaskHeading(String text) 
	{
		addHeading(5, text);
		return this;
	}
	
	/**
	 * Tipi di input.
	 * @author Joan
	 */
	public enum InputType { EMAIL, PASSWORD, TEXT }
	/**
	 * Aggiunge una casella di input al div.
	 * @param name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
	 * @param placeholder testo di informazione visualizzato nell'input.
	 * @param type tipo di input. enum InputType
	 * @param required impedisce il submit del form se non compilato
	 * @return se stesso
	 */
	public DivBuilder addInput(String name, String placeholder, InputType type, boolean required)
	{
		HTMLInputElement input = document.createElement(StringTypes.input);
		input.className = "form-control"; // Bootstrap class
		input.name = name;
		input.placeholder = placeholder;
		input.type = type.name();
		if (required) input.required = required;
		
		$(div).append(input);
		return this;
	}
	
	/**
	 * Tipi di selezione.
	 * @author Joan
	 */
	public enum SelectionType {	CHECKBOX, RADIO	}
	/**
	 * Aggiunge pulsanti di selezione al div.
	 * @param name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
	 * @param text testo associato al pulsante
	 * @param type tipo di pulsante
	 * @param required impedisce il submit del form se non compilato
	 * @return
	 */
	public DivBuilder addSelection(String name, String text, SelectionType type, boolean required)
	{
		HTMLInputElement selection = document.createElement(StringTypes.input);
		selection.className = "form-check-input"; // Bootstrap class
		selection.type = type.name();
		selection.name = name;
		if (required) selection.required = true;
		if (type == SelectionType.RADIO) selection.value = text;
		
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.className = "form-check-label"; // Bootstrap class
		$(label).text(text);
		
		HTMLDivElement row = document.createElement(StringTypes.div);
		row.className = "form-check"; // Bootstrap class
		$(row).append(selection).append(label);
		
		$(div).append(row);
		return this;
	}
	
	/**
	 * Aggiunge al div un input con cui l'utente non puo'interagire.
	 * @param name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
	 * @param value il testo da mandare al server.
	 * @return se stesso.
	 */
	public DivBuilder addReadOnlyInput(String name, String value)
	{
		HTMLInputElement input = document.createElement(StringTypes.input);
		input.name = name;
		input.value = value;
		input.hidden = true;
		
		$(div).append(input);
		addLabel(value);
		return this;
	}
	
	/**
	 * Aggiunge un area di testo al div.
	 * @param name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
	 * @param placeholder testo di informazione visualizzato nell'area di testo.
	 * @param required impedisce il submit del form se non compilato
	 * @return se stesso
	 */
	public DivBuilder addTextArea(String name, String placeholder, boolean required)
	{
		HTMLTextAreaElement textArea = document.createElement(StringTypes.textarea);
		textArea.className = "form-control";
		textArea.name = name;
		textArea.placeholder = placeholder;
		if (required) textArea.required = true;
		
		$(div).append(textArea);
		return this;
	}
	
	/**
	 * Aggiunge un link al div con lo stile di un bottone.
	 * @param href indirizzo destinazione
	 * @param text testo del link
	 * @param outline true = solo il contorno colorato. Aggiunge l'apposita classe Bootstrap all'elemento anchor.
	 * @return se stesso
	 */
	public DivBuilder addLinkButton(String href, String text, boolean outline) 
	{
		HTMLAnchorElement linkButton = document.createElement(StringTypes.a);
		linkButton.className = outline ? "btn btn-outline-primary" : "btn btn-primary"; // Bootstrap class
		linkButton.setAttribute("href", href);
		$(linkButton).text(text);
		
		$(div).append(linkButton);
		return this;
	}
	
	/**
	 * Aggiunge un link al div.
	 * @param href indirizzo di destinazione
	 * @param text testo del link
	 * @param className attributo class del link.
	 * @return se stesso.
	 */
	public DivBuilder addLink(String href, String text, String className) 
	{
		HTMLAnchorElement link = document.createElement(StringTypes.a);
		link.className = className;
		link.setAttribute("href", href);
		$(link).text(text);
		
		$(div).append(link);
		return this;
	}
	
	/**
	 * Aggiunge un pulsante submit al div.
	 * @param value testo del pulsante
	 * @return
	 */
	public DivBuilder addSubmit(String value)
	{
		HTMLInputElement submit = document.createElement(StringTypes.input);
		submit.type = "submit";
		submit.className =  "btn btn-primary";
		submit.value = value;
		
		$(div).append(submit);
		return this;
	}
	
	/**
	 * Aggiunge uno o piu' div all'interno di se stesso.
	 * @param divElements
	 * @return
	 */
	public DivBuilder appendDiv(HTMLDivElement ... divElements)
	{
		for (HTMLDivElement e : divElements)
			$(div).append(e);
		return this;
	}
	
	/**
	 * Restituisce il div.
	 * @return div.
	 */
	public HTMLDivElement build() { return div; }
}
