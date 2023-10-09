/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Si imposta il titolo tramite tramite il metodo asTitle() dell'enum Task.
     * Si imposta l'indirizzo di destinazione del form tramite il metodo getJsp() dell'enum Task.
     * Si aggiunge un heading al form con il nome del task.
     * @param {fabbricaSemantica.BasePage.Task} task per cui costruire la pagina
     * @class
     * @extends fabbricaSemantica.Navbar
     * @author Joan
     */
    class BasePage extends fabbricaSemantica.Navbar {
        constructor(task) {
            super();
            if (this.form === undefined)
                this.form = null;
            document.title = fabbricaSemantica.BasePage.Task["_$wrappers"][task].asTitle();
            this.form = new fabbricaSemantica.FormBuilder(fabbricaSemantica.BasePage.Task["_$wrappers"][task].getJsp()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group text-primary").addHeading(3, fabbricaSemantica.BasePage.Task["_$wrappers"][task].asTitle()).build());
        }
        /**
         * Caricata la pagina, controlla che l'utente sia loggato, delegando il controllo al metodo privato checkSessionPrivate.
         */
        checkSession() {
            window.onload = (e) => {
                this.checkSessionPrivate();
                return null;
            };
        }
        /**
         * Controlla che l'utente sia loggato. Crea un alert per notificare l'utente, e reindirizza alla pagina di login.
         * @private
         */
        checkSessionPrivate() {
            $.getJSON("isLoggedIn.jsp", (result, a, ctx) => {
                let isLoggedIn = result;
                if (!isLoggedIn) {
                    alert("You\'re not logged in. Please login first.");
                    window.location.replace("login.html");
                }
                return null;
            });
        }
        /**
         * Aggiunge il bottone SKIP e NEXT al form.
         * SKIP: redirect a task casuale.
         * NEXT: submit del form.
         */
        addFormButtons() {
            this.form.addFormGroup$fabbricaSemantica_DivBuilder(this.form.formGroup().addLinkButton("randomTask.jsp", "SKIP", false).addSubmit("NEXT")).build();
        }
    }
    /**
     * Servlet alla quale richiedere i task di annotazione e validazione.
     */
    BasePage.REST_URL = "nextExample.jsp";
    fabbricaSemantica.BasePage = BasePage;
    BasePage["__class"] = "fabbricaSemantica.BasePage";
    (function (BasePage) {
        /**
         * Definisce tutti e soli i task di annotazione e validazione. Ad ogni Task viene associato il proprio indirizzo servlet.
         * @enum
         * @property {fabbricaSemantica.BasePage.Task} TRANSLATION_ANNOTATION
         * @property {fabbricaSemantica.BasePage.Task} WORD_ANNOTATION
         * @property {fabbricaSemantica.BasePage.Task} DEFINITION_ANNOTATION
         * @property {fabbricaSemantica.BasePage.Task} SENSE_ANNOTATION
         * @property {fabbricaSemantica.BasePage.Task} SENSE_VALIDATION
         * @property {fabbricaSemantica.BasePage.Task} TRANSLATION_VALIDATION
         * @class
         */
        var Task;
        (function (Task) {
            Task[Task["TRANSLATION_ANNOTATION"] = 0] = "TRANSLATION_ANNOTATION";
            Task[Task["WORD_ANNOTATION"] = 1] = "WORD_ANNOTATION";
            Task[Task["DEFINITION_ANNOTATION"] = 2] = "DEFINITION_ANNOTATION";
            Task[Task["SENSE_ANNOTATION"] = 3] = "SENSE_ANNOTATION";
            Task[Task["SENSE_VALIDATION"] = 4] = "SENSE_VALIDATION";
            Task[Task["TRANSLATION_VALIDATION"] = 5] = "TRANSLATION_VALIDATION";
        })(Task = BasePage.Task || (BasePage.Task = {}));
        /** @ignore */
        class Task_$WRAPPER {
            constructor(_$ordinal, _$name, jsp) {
                this._$ordinal = _$ordinal;
                this._$name = _$name;
                if (this.jsp === undefined)
                    this.jsp = null;
                this.jsp = jsp;
            }
            /**
             * @return {string} indirizzo servlet del task
             */
            getJsp() {
                return this.jsp;
            }
            /**
             * @return {string} nome del task, lowercase.
             */
            asTitle() {
                return this.name().split("_").join(" ").toLowerCase();
            }
            name() { return this._$name; }
            ordinal() { return this._$ordinal; }
        }
        BasePage.Task_$WRAPPER = Task_$WRAPPER;
        Task["__class"] = "fabbricaSemantica.BasePage.Task";
        Task["__interfaces"] = ["java.lang.Comparable", "java.io.Serializable"];
        Task["_$wrappers"] = [new Task_$WRAPPER(0, "TRANSLATION_ANNOTATION", "translationAnnotation.jsp"), new Task_$WRAPPER(1, "WORD_ANNOTATION", "wordAnnotation.jsp"), new Task_$WRAPPER(2, "DEFINITION_ANNOTATION", "definitionAnnotation.jsp"), new Task_$WRAPPER(3, "SENSE_ANNOTATION", "senseAnnotation.jsp"), new Task_$WRAPPER(4, "SENSE_VALIDATION", "senseValidation.jsp"), new Task_$WRAPPER(5, "TRANSLATION_VALIDATION", "translationValidation.jsp")];
    })(BasePage = fabbricaSemantica.BasePage || (fabbricaSemantica.BasePage = {}));
})(fabbricaSemantica || (fabbricaSemantica = {}));
