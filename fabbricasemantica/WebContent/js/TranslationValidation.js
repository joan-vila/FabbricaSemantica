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
    class TranslationValidation extends fabbricaSemantica.BasePage {
        constructor() {
            super(TranslationValidation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[TranslationValidation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (TranslationValidation.task == null)
            TranslationValidation.task = fabbricaSemantica.BasePage.Task.TRANSLATION_VALIDATION; return TranslationValidation.task; }
        ;
        static PARAMS_$LI$() { if (TranslationValidation.PARAMS == null)
            TranslationValidation.PARAMS = ["word", "description", "translations", "response"]; return TranslationValidation.PARAMS; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTaskHeading("Data la seguente parola e relativa definizione, si scelga la traduzione migliore tra quelle fornite:")).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addHeading(6, "Word:").addReadOnlyInput(TranslationValidation.PARAMS_$LI$()[0], (json[TranslationValidation.PARAMS_$LI$()[0]])).addHeading(6, "Description").addReadOnlyInput(TranslationValidation.PARAMS_$LI$()[1], (json[TranslationValidation.PARAMS_$LI$()[1]])));
            let translations = (json[TranslationValidation.PARAMS_$LI$()[2]]);
            let formGroup = new fabbricaSemantica.DivBuilder("form-group");
            for (let index123 = 0; index123 < translations.length; index123++) {
                let t = translations[index123];
                formGroup.addSelection(TranslationValidation.PARAMS_$LI$()[3], t, fabbricaSemantica.DivBuilder.SelectionType.RADIO, true);
            }
            formGroup.addSelection(TranslationValidation.PARAMS_$LI$()[3], "Nessuna", fabbricaSemantica.DivBuilder.SelectionType.RADIO, true);
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(formGroup);
            this.addFormButtons();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            new TranslationValidation();
        }
    }
    fabbricaSemantica.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "fabbricaSemantica.TranslationValidation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.TranslationValidation.PARAMS_$LI$();
fabbricaSemantica.TranslationValidation.task_$LI$();
fabbricaSemantica.TranslationValidation.main(null);
