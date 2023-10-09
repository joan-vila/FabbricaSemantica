/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruttore del FormBuilder.
     * @param {string} action indirizzo della servlet.
     * @param {fabbricaSemantica.FormBuilder.Method} method POST.
     * @param {string} className per classi Bootstrap.
     * @class
     * @author Joan
     */
    class FormBuilder {
        constructor(action, method, className) {
            if (((typeof action === 'string') || action === null) && ((typeof method === 'number') || method === null) && ((typeof className === 'string') || className === null)) {
                let __args = arguments;
                if (this.form === undefined)
                    this.form = null;
                if (this.form === undefined)
                    this.form = null;
                (() => {
                    this.form = document.createElement("form");
                    this.form.action = action;
                    this.form.method = fabbricaSemantica.FormBuilder.Method[method];
                    this.form.className = className;
                })();
            }
            else if (((typeof action === 'string') || action === null) && method === undefined && className === undefined) {
                let __args = arguments;
                {
                    let __args = arguments;
                    let method = FormBuilder.Method.POST;
                    let className = "rounded";
                    if (this.form === undefined)
                        this.form = null;
                    if (this.form === undefined)
                        this.form = null;
                    (() => {
                        this.form = document.createElement("form");
                        this.form.action = action;
                        this.form.method = fabbricaSemantica.FormBuilder.Method[method];
                        this.form.className = className;
                    })();
                }
            }
            else
                throw new Error('invalid overload');
        }
        addFormGroup$def_dom_HTMLDivElement(formGroup) {
            $(this.form).append(formGroup);
            return this;
        }
        /**
         * Seguendo il builder pattern, aggiunge un div al form e ritorna se stesso.
         * @param {HTMLDivElement} formGroup il div da aggiungere al form.
         * @return {fabbricaSemantica.FormBuilder} se stesso.
         */
        addFormGroup(formGroup) {
            if (((formGroup != null && formGroup instanceof HTMLDivElement) || formGroup === null)) {
                return this.addFormGroup$def_dom_HTMLDivElement(formGroup);
            }
            else if (((formGroup != null && formGroup instanceof fabbricaSemantica.DivBuilder) || formGroup === null)) {
                return this.addFormGroup$fabbricaSemantica_DivBuilder(formGroup);
            }
            else
                throw new Error('invalid overload');
        }
        addFormGroup$fabbricaSemantica_DivBuilder(formGroup) {
            $(this.form).append(formGroup.build());
            return this;
        }
        /**
         * Restituisce un DivBuilder con classe "form-group".
         * Usato per associare logicamente la costruzione del DivBuilder al form.
         * @return
         * @return {fabbricaSemantica.DivBuilder}
         */
        formGroup() {
            return new fabbricaSemantica.DivBuilder("form-group");
        }
        /**
         * Aggiunge il form al body della pagina.
         */
        build() {
            $("body").append(this.form);
        }
    }
    fabbricaSemantica.FormBuilder = FormBuilder;
    FormBuilder["__class"] = "fabbricaSemantica.FormBuilder";
    (function (FormBuilder) {
        /**
         * Metodi di richiesta del form.
         * Nell'ambito di questo progetto verra utilizzato solamente il metodo POST.
         * @author Joan
         * @enum
         * @property {fabbricaSemantica.FormBuilder.Method} POST
         * @property {fabbricaSemantica.FormBuilder.Method} GET
         * @class
         */
        var Method;
        (function (Method) {
            Method[Method["POST"] = 0] = "POST";
            Method[Method["GET"] = 1] = "GET";
        })(Method = FormBuilder.Method || (FormBuilder.Method = {}));
    })(FormBuilder = fabbricaSemantica.FormBuilder || (fabbricaSemantica.FormBuilder = {}));
})(fabbricaSemantica || (fabbricaSemantica = {}));
