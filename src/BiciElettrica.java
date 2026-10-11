public class BiciElettrica extends Bici {
    private int autonomia;
    private int tempoRicarica;

    public BiciElettrica(CasaBici casaBici, String modello, Persona attualeAssegnatario,
                         int prezzoMensile, int autonomia, int tempoRicarica) {
        super(casaBici, modello, attualeAssegnatario, prezzoMensile);
        this.autonomia = autonomia;
        this.tempoRicarica = tempoRicarica;
    }

    public int getAutonomia() { return autonomia; }
    public int getTempoRicarica() { return tempoRicarica; }

    public void aumentaAutonomia(int km) { if (km > 0) this.autonomia += km; }

    @Override
    public String toString() {
        return super.toString() + " [autonomia=" + autonomia + " km, tempoRicarica=" + tempoRicarica + " h]";
    }
}

