public class Bici {
    private CasaBici casaBici;
    private String modello;
    private static int numeroBiciCostruite = 0; //static perche' si riferisce alla classe
    private int id;
    private Persona attualeAssegnatario;
    private int numeroNoleggi;
    private int prezzoMensile;

    // costruttore
    public Bici (CasaBici casaBici, String modello,Persona attualeAssegnatario, int prezzoMensile ) {
        this.casaBici = casaBici;
        this.modello = modello;
        this.id = ++numeroBiciCostruite; //ogni volta che costruiamo bici con id aumentiamo numeroBiciCostruite e assegna al nuovo valore id della bici appena creato
        this.prezzoMensile = prezzoMensile;
        this.numeroNoleggi = 0;
        this.attualeAssegnatario = attualeAssegnatario; // nessun assegnatario all'inizio

    }
    // Getter per tutte le variabili
    public CasaBici getCasaBici() {
        return casaBici;
    }
    public int getId() {
        return id;
    }

    public Persona getAttualeAssegnatario() {
        return attualeAssegnatario;
    }

    public int getNumeroNoleggi() {
        return numeroNoleggi;
    }

    public int getPrezzoMensile() {
        return prezzoMensile;
    }

    public String getModello() { return modello;   }


//setter
    public void setCasaProduttrice(CasaBici casaProduttrice) {
        this.casaBici = casaProduttrice;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setAttualeAssegnatario(Persona attualeAssegnatario) {
        this.attualeAssegnatario = attualeAssegnatario;
    }

    public void setPrezzoMensile(int prezzoMensile) {
        this.prezzoMensile = prezzoMensile;
    }

    //metodo per aumentare o diminuire prezzo
    public void aumentaPrezzo(int importo) {
    this.prezzoMensile += importo;
    }
    public void diminuisciPrezzo(int importo) {
        this.prezzoMensile -= importo;
        if (this.prezzoMensile < 0) {
            this.prezzoMensile = 0; //settiamo prezzo minimo zero
        }
    }
        //metodo pubblico per cambio noleggio
        public void cambioNoleggio (Persona nuovaPersona){
            this.attualeAssegnatario = nuovaPersona;
            incrementaNumeroNoleggi();
        }

        //aumento noleggi
        private void incrementaNumeroNoleggi () {
            this.numeroNoleggi++;
        }

        // metodo per sapere numero totale bici
        public static int getNumeroBiciCostruite () {
            return numeroBiciCostruite;
        }

        public boolean equals (Object o) {
        if (!( o instanceof Bici)) { // primo controllo per vedere se entrambi sono Bici
            return false;
        }
        Bici b = (Bici) o;
        return this.modello.equals(b.modello); //uguali se hanno lo stesso modello
        }

    @Override
    public String toString() {
        return "Bici [id=" + getId() + ", modello=" + modello + ", casaProduttrice=" + getCasaBici().getNome()
                + ", assegnatario=" + (getAttualeAssegnatario() != null ? getAttualeAssegnatario().getCognome() : "nessuno")
                + ", prezzoMensile=" + getPrezzoMensile() + ", numeroNoleggi=" + getNumeroNoleggi() + "]";
    }


}









