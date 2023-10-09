/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruise la pagina con un bottone start che reindirizza a un task casuale
     * @class
     * @extends fabbricaSemantica.Navbar
     * @author Joan
     */
    class Home extends fabbricaSemantica.Navbar {
        constructor() {
            super();
            $(".navbar-brand").remove();
            new fabbricaSemantica.FormBuilder(Home.SERVLET_URL).addFormGroup$def_dom_HTMLDivElement(new fabbricaSemantica.DivBuilder("form-group").addSubmit("START!").build()).build();
        }
        /**
         * Caricata la pagina, controlla che l'utente sia loggato, delegando il controllo al metodo privato checkSessionPrivate.
         * @private
         */
        /*private*/ checkSession() {
            window.onload = (e) => {
                this.checkSessionPrivate();
                return null;
            };
        }
        /**
         * Controlla che l'utente sia loggato. Crea un alert per notificare l'utente, e reindirizza alla pagina di login.
         * @private
         */
        /*private*/ checkSessionPrivate() {
            $.getJSON("isLoggedIn.jsp", (result, a, ctx) => {
                let isLoggedIn = result;
                if (!isLoggedIn) {
                    alert("You\'re not logged in. Please login first.");
                    window.location.replace("login.html");
                }
                return null;
            });
        }
        static main(args) {
            let page = new Home();
            page.checkSession();
        }
    }
    /**
     * indirizzo per il redirect a task casuale.
     */
    Home.SERVLET_URL = "randomTask.jsp";
    fabbricaSemantica.Home = Home;
    Home["__class"] = "fabbricaSemantica.Home";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.Home.main(null);
