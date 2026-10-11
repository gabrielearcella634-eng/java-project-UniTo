public class CasaBici {
    private String nome;
    private Persona titolare;
    private String nazione;

    public CasaBici(String nome, Persona titolare, String nazione) {
        this.nome = nome;
        this.titolare = titolare;
        this.nazione = nazione;
    }
    public String getNome() {
        return nome;
    }
    public Persona getTitolare() {
        return titolare;
    }
    public String getNazione() {
        return nazione;
    }
    public void setTitolare(Persona titolare) {
        this.titolare = titolare;
    }

    @Override
    public String toString() {
        return "CasaBici [nome=" + getNome() + ", titolare=" + getTitolare().getCognome() + ", nazione=" + getNazione() + "]";
    }

}
