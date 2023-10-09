/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var fabbricaSemantica;
(function (fabbricaSemantica) {
    /**
     * Costriisce la navbar e la aggiunge al tag body della pagina html.
     * @class
     * @author Joan
     */
    class Navbar {
        constructor() {
            if (this.navbar === undefined)
                this.navbar = null;
            let right = new fabbricaSemantica.DivBuilder("navbar-nav ml-auto").addLinkButton("logout.html", "Logout", true).build();
            this.navbar = new fabbricaSemantica.DivBuilder("navbar navbar-expand navbar-dark bg-dark").addLink("home.html", "Home", "navbar-brand").appendDiv(right).build();
            $("body").append(this.navbar);
        }
    }
    fabbricaSemantica.Navbar = Navbar;
    Navbar["__class"] = "fabbricaSemantica.Navbar";
})(fabbricaSemantica || (fabbricaSemantica = {}));
