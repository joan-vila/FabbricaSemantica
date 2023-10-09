/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruisce la pagina richiamando il costruttore della superclasse (che imposta il titolo).
     * Aggiunge al form tutti gli input necessari.
     * @class
     * @extends fabbricaSemantica.UserPage
     * @author Joan
     */
    class Signup extends fabbricaSemantica.UserPage {
        constructor() {
            super("signup");
            new fabbricaSemantica.FormBuilder(Signup.SERVLET_URL).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addHeading(3, "Sign up").addInput("email", "email...", fabbricaSemantica.DivBuilder.InputType.EMAIL, true).addInput("password", "password...", fabbricaSemantica.DivBuilder.InputType.PASSWORD, true).addInput("passwordRepeat", "ripeti password...", fabbricaSemantica.DivBuilder.InputType.PASSWORD, true).build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addHeading(6, "Seleziona le lingue di cui sei madrelingua:").addSelection("EN", "Inglese", fabbricaSemantica.DivBuilder.SelectionType.CHECKBOX, false).addSelection("IT", "Italiano", fabbricaSemantica.DivBuilder.SelectionType.CHECKBOX, false).build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addHeading(6, "Altre lingue parlate e livello:").addInput("altreLingue", "lingua1 livello1, lingua2 livello2...", fabbricaSemantica.DivBuilder.InputType.TEXT, false).build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addLinkButton("login.html", "login", true).addSubmit("signup").build()).build();
        }
        /**
         * Inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new Signup();
            page.checkSession();
        }
    }
    /**
     * indirizzo a cui mandare i dati di registrazione.
     */
    Signup.SERVLET_URL = "signup.jsp";
    fabbricaSemantica.Signup = Signup;
    Signup["__class"] = "fabbricaSemantica.Signup";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.Signup.main(null);
