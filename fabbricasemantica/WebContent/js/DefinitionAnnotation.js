/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruttore della pagina. Richiama il supercostruttore dando in input il task per le funzionalita di base.
     * Recupera i dati dal back-end e popola il form, passando il JSON in input al metodo buildPage().
     * @class
     * @extends fabbricaSemantica.BasePage
     * @author Joan
     */
    class DefinitionAnnotation extends fabbricaSemantica.BasePage {
        constructor() {
            super(DefinitionAnnotation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[DefinitionAnnotation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (DefinitionAnnotation.task == null)
            DefinitionAnnotation.task = fabbricaSemantica.BasePage.Task.DEFINITION_ANNOTATION; return DefinitionAnnotation.task; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTaskHeading("Data la seguente parola e il suo iperonimo, fornire una definizione nella propria lingua")).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addHeading(6, DefinitionAnnotation.WORD).addReadOnlyInput(DefinitionAnnotation.WORD, (json[DefinitionAnnotation.WORD])).addHeading(6, DefinitionAnnotation.HYPERNYM).addReadOnlyInput(DefinitionAnnotation.HYPERNYM, (json[DefinitionAnnotation.HYPERNYM]))).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTextArea(DefinitionAnnotation.DEFINITION, "scrivi qui la definizione", true));
            this.addFormButtons();
        }
        /**
         * Inizializza la paggina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new DefinitionAnnotation();
            page.checkSession();
        }
    }
    /**
     * parametri back-end
     */
    DefinitionAnnotation.WORD = "word";
    DefinitionAnnotation.HYPERNYM = "hypernym";
    DefinitionAnnotation.DEFINITION = "definition";
    fabbricaSemantica.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "fabbricaSemantica.DefinitionAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.DefinitionAnnotation.task_$LI$();
fabbricaSemantica.DefinitionAnnotation.main(null);
