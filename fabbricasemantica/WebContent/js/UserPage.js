/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruisce la pagina impostando il suo titolo.
     * @param {string} title
     * @class
     * @author Joan
     */
    class UserPage {
        constructor(title) {
            document.title = title;
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
         * Controlla che l'utente sia loggato.
         * Crea un box di conferma per notificare l'utente, e reindirizza alla pagina di login o home a seconda dei casi.
         * @private
         */
        /*private*/ checkSessionPrivate() {
            $.getJSON(UserPage.SERVLET_URL, (result, a, ctx) => {
                let isLoggedIn = result;
                if (isLoggedIn) {
                    let logout = confirm("You\'re already logged in. Please logout first.");
                    if (logout)
                        window.location.replace("logout.jsp");
                    else
                        window.location.replace("home.html");
                }
                return null;
            });
        }
    }
    /**
     * indirizzo da cui reperire lo status dell'utente
     */
    UserPage.SERVLET_URL = "isLoggedIn.jsp";
    fabbricaSemantica.UserPage = UserPage;
    UserPage["__class"] = "fabbricaSemantica.UserPage";
})(fabbricaSemantica || (fabbricaSemantica = {}));
