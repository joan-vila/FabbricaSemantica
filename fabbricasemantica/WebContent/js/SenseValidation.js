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
    class SenseValidation extends fabbricaSemantica.BasePage {
        constructor() {
            super(SenseValidation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[SenseValidation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (SenseValidation.task == null)
            SenseValidation.task = fabbricaSemantica.BasePage.Task.SENSE_VALIDATION; return SenseValidation.task; }
        ;
        static PARAMS_$LI$() { if (SenseValidation.PARAMS == null)
            SenseValidation.PARAMS = ["word", "example", "sense", "response"]; return SenseValidation.PARAMS; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTaskHeading("Data la seguente parola e frase in cui appare, verificare se il senso fornito dal sistema \u00e8 appropriato:")).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addHeading(6, "Word:").addReadOnlyInput(SenseValidation.PARAMS_$LI$()[0], (json[SenseValidation.PARAMS_$LI$()[0]])).addHeading(6, "Example:").addReadOnlyInput(SenseValidation.PARAMS_$LI$()[1], (json[SenseValidation.PARAMS_$LI$()[1]])).addHeading(6, "Sense:").addReadOnlyInput(SenseValidation.PARAMS_$LI$()[2], (json[SenseValidation.PARAMS_$LI$()[2]]))).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addSelection(SenseValidation.PARAMS_$LI$()[3], "S\u00ec", fabbricaSemantica.DivBuilder.SelectionType.RADIO, true).addSelection(SenseValidation.PARAMS_$LI$()[3], "No", fabbricaSemantica.DivBuilder.SelectionType.RADIO, true));
            this.addFormButtons();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new SenseValidation();
            page.checkSession();
        }
    }
    fabbricaSemantica.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "fabbricaSemantica.SenseValidation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.SenseValidation.PARAMS_$LI$();
fabbricaSemantica.SenseValidation.task_$LI$();
fabbricaSemantica.SenseValidation.main(null);
