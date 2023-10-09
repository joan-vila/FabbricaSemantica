/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruisce la pagina richiamando il costruttore della superclasse (che imposta il titolo)
     * e costruendo il form con gli elementi html necessari
     * @class
     * @extends fabbricaSemantica.UserPage
     * @author Joan
     */
    class Login extends fabbricaSemantica.UserPage {
        constructor() {
            super("login");
            new fabbricaSemantica.FormBuilder(Login.SERVLET_URL).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addHeading(3, "Sign in").build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addInput("email", "insert email...", fabbricaSemantica.DivBuilder.InputType.EMAIL, true).addInput("password", "insert password...", fabbricaSemantica.DivBuilder.InputType.PASSWORD, true).build()).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addLinkButton("signup.html", "signup", true).addSubmit("login").build()).build();
        }
        /**
         * inizializza la pagina e controlla la sessione.
         * @param {Array} args
         */
        static main(args) {
            let page = new Login();
            page.checkSession();
        }
    }
    /**
     * Servlet a cui mandare i dati del form di login
     */
    Login.SERVLET_URL = "login.jsp";
    fabbricaSemantica.Login = Login;
    Login["__class"] = "fabbricaSemantica.Login";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.Login.main(null);
