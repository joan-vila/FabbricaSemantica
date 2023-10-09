/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costruttore della pagina.
     * Si limita a creare un box di conferma per verificare che l'utente sia davvero intenzionato a disconnettersi.
     * @class
     * @author Joan
     */
    class Logout {
        constructor() {
            $.getJSON(Logout.SERVLET_URL, (result, a, ctx) => {
                let isLoggedIn = result;
                if (isLoggedIn) {
                    let wantToLogout = confirm("Are you sure you want to log out?");
                    if (wantToLogout)
                        window.location.replace("logout.jsp");
                    else
                        window.location.replace("home.html");
                }
                else
                    window.location.replace("login.html");
                return null;
            });
        }
        /**
         * Caricata la pagina si carica il box di conferma
         * @param {Array} args
         */
        static main(args) {
            window.onload = (e) => {
                new Logout();
                return null;
            };
        }
    }
    /**
     * indirizzo da cui reperire lo status dell'utente
     */
    Logout.SERVLET_URL = "isLoggedIn.jsp";
    fabbricaSemantica.Logout = Logout;
    Logout["__class"] = "fabbricaSemantica.Logout";
})(fabbricaSemantica || (fabbricaSemantica = {}));
fabbricaSemantica.Logout.main(null);
