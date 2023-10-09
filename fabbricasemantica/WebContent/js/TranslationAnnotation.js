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
    class TranslationAnnotation extends fabbricaSemantica.BasePage {
        constructor() {
            super(TranslationAnnotation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[TranslationAnnotation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (TranslationAnnotation.task == null)
            TranslationAnnotation.task = fabbricaSemantica.BasePage.Task.TRANSLATION_ANNOTATION; return TranslationAnnotation.task; }
        ;
        static PARAMS_$LI$() { if (TranslationAnnotation.PARAMS == null)
            TranslationAnnotation.PARAMS = ["word", "description", "translation"]; return TranslationAnnotation.PARAMS; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addHeading(5, "Data la seguente parola e definizione, fornisci una traduzione nella tua lingua madre:")).addFormGroup$def_dom_HTMLDivElement(this.form.formGroup().addHeading(6, "Word:").addReadOnlyInput(TranslationAnnotation.PARAMS_$LI$()[0], (json[TranslationAnnotation.PARAMS_$LI$()[0]])).addHeading(6, "Description:").addReadOnlyInput(TranslationAnnotation.PARAMS_$LI$()[1], (json[TranslationAnnotation.PARAMS_$LI$()[1]])).build()).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTextArea(TranslationAnnotation.PARAMS_$LI$()[2], "scrivi qui la traduzione...", true));
            this.addFormButtons();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new TranslationAnnotation();
            page.checkSession();
        }
    }
    fabbricaSemantica.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "fabbricaSemantica.TranslationAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.TranslationAnnotation.PARAMS_$LI$();
fabbricaSemantica.TranslationAnnotation.task_$LI$();
fabbricaSemantica.TranslationAnnotation.main(null);
