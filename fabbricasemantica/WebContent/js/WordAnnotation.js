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
    class WordAnnotation extends fabbricaSemantica.BasePage {
        constructor() {
            super(WordAnnotation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[WordAnnotation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (WordAnnotation.task == null)
            WordAnnotation.task = fabbricaSemantica.BasePage.Task.WORD_ANNOTATION; return WordAnnotation.task; }
        ;
        static PARAMS_$LI$() { if (WordAnnotation.PARAMS == null)
            WordAnnotation.PARAMS = ["description", "word"]; return WordAnnotation.PARAMS; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addTaskHeading("Data la seguente definizione in inglese, si provi a fornire la parola definita:").build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addReadOnlyInput(WordAnnotation.PARAMS_$LI$()[0], (json[WordAnnotation.PARAMS_$LI$()[0]])).addInput(WordAnnotation.PARAMS_$LI$()[1], "scrivi qui la parola...", fabbricaSemantica.DivBuilder.InputType.TEXT, true).build());
            this.addFormButtons();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new WordAnnotation();
            page.checkSession();
        }
    }
    fabbricaSemantica.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "fabbricaSemantica.WordAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.WordAnnotation.PARAMS_$LI$();
fabbricaSemantica.WordAnnotation.task_$LI$();
fabbricaSemantica.WordAnnotation.main(null);
