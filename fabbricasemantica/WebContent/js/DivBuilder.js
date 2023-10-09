/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruisce il div impostando l'attributo class
     * @param {string} className nome della classe
     * @class
     * @author Joan
     */
    class DivBuilder {
        constructor(className) {
            if (((typeof className === 'string') || className === null)) {
                let __args = arguments;
                {
                    let __args = arguments;
                    if (this.div === undefined)
                        this.div = null;
                    if (this.div === undefined)
                        this.div = null;
                    (() => {
                        this.div = document.createElement("div");
                    })();
                }
                (() => {
                    this.div.className = className;
                })();
            }
            else if (className === undefined) {
                let __args = arguments;
                if (this.div === undefined)
                    this.div = null;
                if (this.div === undefined)
                    this.div = null;
                (() => {
                    this.div = document.createElement("div");
                })();
            }
            else
                throw new Error('invalid overload');
        }
        /**
         * Aggiunge una label al div.
         * @param {string} text testo della label.
         * @return {fabbricaSemantica.DivBuilder} se stesso.
         */
        addLabel(text) {
            let label = document.createElement("label");
            $(label).text(text);
            $(this.div).append(label);
            return this;
        }
        /**
         * Aggiunge un heading al div.
         * @param {number} headingDimension dimensione dell'heading.
         * @param {string} text testo dell'heading.
         * @return {fabbricaSemantica.DivBuilder} se stesso.
         */
        addHeading(headingDimension, text) {
            let h = document.createElement("h3");
            switch ((headingDimension)) {
                case 1:
                    h = document.createElement("h1");
                    break;
                case 2:
                    h = document.createElement("h2");
                    break;
                case 3:
                    h = document.createElement("h3");
                    break;
                case 4:
                    h = document.createElement("h4");
                    break;
                case 5:
                    h = document.createElement("h5");
                    break;
                case 6:
                    h = document.createElement("h6");
                    break;
                default:
                    h = document.createElement("h3");
            }
            $(h).text(text);
            $(this.div).append(h);
            return this;
        }
        /**
         * Metodo di comodo per l'utilizzo nei task.
         * @param {string} text testo dell'heading
         * @return {fabbricaSemantica.DivBuilder} se stesso.
         */
        addTaskHeading(text) {
            this.addHeading(5, text);
            return this;
        }
        /**
         * Aggiunge una casella di input al div.
         * @param {string} name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
         * @param {string} placeholder testo di informazione visualizzato nell'input.
         * @param {fabbricaSemantica.DivBuilder.InputType} type tipo di input. enum InputType
         * @param {boolean} required impedisce il submit del form se non compilato
         * @return {fabbricaSemantica.DivBuilder} se stesso
         */
        addInput(name, placeholder, type, required) {
            let input = document.createElement("input");
            input.className = "form-control";
            input.name = name;
            input.placeholder = placeholder;
            input.type = fabbricaSemantica.DivBuilder.InputType[type];
            if (required)
                input.required = required;
            $(this.div).append(input);
            return this;
        }
        /**
         * Aggiunge pulsanti di selezione al div.
         * @param {string} name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
         * @param {string} text testo associato al pulsante
         * @param {fabbricaSemantica.DivBuilder.SelectionType} type tipo di pulsante
         * @param {boolean} required impedisce il submit del form se non compilato
         * @return
         * @return {fabbricaSemantica.DivBuilder}
         */
        addSelection(name, text, type, required) {
            let selection = document.createElement("input");
            selection.className = "form-check-input";
            selection.type = fabbricaSemantica.DivBuilder.SelectionType[type];
            selection.name = name;
            if (required)
                selection.required = true;
            if (type === DivBuilder.SelectionType.RADIO)
                selection.value = text;
            let label = document.createElement("label");
            label.className = "form-check-label";
            $(label).text(text);
            let row = document.createElement("div");
            row.className = "form-check";
            $(row).append(selection).append(label);
            $(this.div).append(row);
            return this;
        }
        /**
         * Aggiunge al div un input con cui l'utente non puo'interagire.
         * @param {string} name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
         * @param {string} value il testo da mandare al server.
         * @return {fabbricaSemantica.DivBuilder} se stesso.
         */
        addReadOnlyInput(name, value) {
            let input = document.createElement("input");
            input.name = name;
            input.value = value;
            input.hidden = true;
            $(this.div).append(input);
            this.addLabel(value);
            return this;
        }
        /**
         * Aggiunge un area di testo al div.
         * @param {string} name nome dell'input. Utilizzato lato back-end per ottenere l'input inserito dall'utente.
         * @param {string} placeholder testo di informazione visualizzato nell'area di testo.
         * @param {boolean} required impedisce il submit del form se non compilato
         * @return {fabbricaSemantica.DivBuilder} se stesso
         */
        addTextArea(name, placeholder, required) {
            let textArea = document.createElement("textarea");
            textArea.className = "form-control";
            textArea.name = name;
            textArea.placeholder = placeholder;
            if (required)
                textArea.required = true;
            $(this.div).append(textArea);
            return this;
        }
        /**
         * Aggiunge un link al div con lo stile di un bottone.
         * @param {string} href indirizzo destinazione
         * @param {string} text testo del link
         * @param {boolean} outline true = solo il contorno colorato. Aggiunge l'apposita classe Bootstrap all'elemento anchor.
         * @return {fabbricaSemantica.DivBuilder} se stesso
         */
        addLinkButton(href, text, outline) {
            let linkButton = document.createElement("a");
            linkButton.className = outline ? "btn btn-outline-primary" : "btn btn-primary";
            linkButton.setAttribute("href", href);
            $(linkButton).text(text);
            $(this.div).append(linkButton);
            return this;
        }
        /**
         * Aggiunge un link al div.
         * @param {string} href indirizzo di destinazione
         * @param {string} text testo del link
         * @param {string} className attributo class del link.
         * @return {fabbricaSemantica.DivBuilder} se stesso.
         */
        addLink(href, text, className) {
            let link = document.createElement("a");
            link.className = className;
            link.setAttribute("href", href);
            $(link).text(text);
            $(this.div).append(link);
            return this;
        }
        /**
         * Aggiunge un pulsante submit al div.
         * @param {string} value testo del pulsante
         * @return
         * @return {fabbricaSemantica.DivBuilder}
         */
        addSubmit(value) {
            let submit = document.createElement("input");
            submit.type = "submit";
            submit.className = "btn btn-primary";
            submit.value = value;
            $(this.div).append(submit);
            return this;
        }
        /**
         * Aggiunge uno o piu' div all'interno di se stesso.
         * @param {Array} divElements
         * @return
         * @return {fabbricaSemantica.DivBuilder}
         */
        appendDiv(...divElements) {
            for (let index121 = 0; index121 < divElements.length; index121++) {
                let e = divElements[index121];
                $(this.div).append(e);
            }
            return this;
        }
        /**
         * Restituisce il div.
         * @return {HTMLDivElement} div.
         */
        build() {
            return this.div;
        }
    }
    fabbricaSemantica.DivBuilder = DivBuilder;
    DivBuilder["__class"] = "fabbricaSemantica.DivBuilder";
    (function (DivBuilder) {
        /**
         * Tipi di input.
         * @author Joan
         * @enum
         * @property {fabbricaSemantica.DivBuilder.InputType} EMAIL
         * @property {fabbricaSemantica.DivBuilder.InputType} PASSWORD
         * @property {fabbricaSemantica.DivBuilder.InputType} TEXT
         * @class
         */
        var InputType;
        (function (InputType) {
            InputType[InputType["EMAIL"] = 0] = "EMAIL";
            InputType[InputType["PASSWORD"] = 1] = "PASSWORD";
            InputType[InputType["TEXT"] = 2] = "TEXT";
        })(InputType = DivBuilder.InputType || (DivBuilder.InputType = {}));
        /**
         * Tipi di selezione.
         * @author Joan
         * @enum
         * @property {fabbricaSemantica.DivBuilder.SelectionType} CHECKBOX
         * @property {fabbricaSemantica.DivBuilder.SelectionType} RADIO
         * @class
         */
        var SelectionType;
        (function (SelectionType) {
            SelectionType[SelectionType["CHECKBOX"] = 0] = "CHECKBOX";
            SelectionType[SelectionType["RADIO"] = 1] = "RADIO";
        })(SelectionType = DivBuilder.SelectionType || (DivBuilder.SelectionType = {}));
    })(DivBuilder = fabbricaSemantica.DivBuilder || (fabbricaSemantica.DivBuilder = {}));
})(fabbricaSemantica || (fabbricaSemantica = {}));
