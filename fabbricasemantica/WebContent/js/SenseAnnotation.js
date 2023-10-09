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
    class SenseAnnotation extends fabbricaSemantica.BasePage {
        constructor() {
            super(SenseAnnotation.task_$LI$());
            $.getJSON(fabbricaSemantica.BasePage.REST_URL, "task=" + fabbricaSemantica.BasePage.Task[SenseAnnotation.task_$LI$()], (result, a, ctx) => {
                let json = result;
                this.buildPage(json);
                return null;
            });
        }
        static task_$LI$() { if (SenseAnnotation.task == null)
            SenseAnnotation.task = fabbricaSemantica.BasePage.Task.SENSE_ANNOTATION; return SenseAnnotation.task; }
        ;
        /**
         * Costruisce il form
         * @param {*} json
         * @private
         */
        /*private*/ buildPage(json) {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addTaskHeading("Seleziona il significato corretto della seguente parola nell\'ambito della frase data:")).addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addHeading(6, "Word:").addReadOnlyInput(SenseAnnotation.WORD, (json[SenseAnnotation.WORD])).addHeading(6, "Description:").addReadOnlyInput(SenseAnnotation.DESCRIPTION, (json[SenseAnnotation.DESCRIPTION])));
            let senses = (json["senses"]);
            let formGroup = new fabbricaSemantica.DivBuilder("form-group");
            for (let index122 = 0; index122 < senses.length; index122++) {
                let sense = senses[index122];
                formGroup.addSelection("response", sense, fabbricaSemantica.DivBuilder.SelectionType.RADIO, true);
            }
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(formGroup);
            this.addFormButtons();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new SenseAnnotation();
            page.checkSession();
        }
    }
    /**
     * parametri back-end
     */
    SenseAnnotation.WORD = "word";
    SenseAnnotation.DESCRIPTION = "description";
    SenseAnnotation.SENSES = "senses";
    fabbricaSemantica.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "fabbricaSemantica.SenseAnnotation";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.SenseAnnotation.task_$LI$();
fabbricaSemantica.SenseAnnotation.main(null);
