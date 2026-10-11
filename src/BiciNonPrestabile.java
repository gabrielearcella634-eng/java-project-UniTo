public class BiciNonPrestabile extends Bici {
    public BiciNonPrestabile(CasaBici casaBici, String modello, Persona attualeAssegnatario, int prezzoMensile) {
       super (casaBici, modello, attualeAssegnatario, prezzoMensile);
    }

    @Override
    public void cambioNoleggio(Persona nuovaPersona) {
        System.out.println("Errore: questa bici non può essere prestata.");
        //non chiamo super.cambioNoleggio() cosi che assegnatario non cambia
        // funziona perche metodo e' vuoto
    }
    @Override
    public String toString() {
        return super.toString() + " [NON PRESTABILE]";
    }

}
