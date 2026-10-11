public class Persona {
    private int id;
    private static int count = 0;
    private String cognome;
    private String indirizzo;

    // costruttore
    public Persona(int id, String cognome, String indirizzo) {
        this.id = count++;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    // setter solo per indirizzo
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Persona [id=" + getId() + ", cognome=" + getCognome() + ", indirizzo=" + getIndirizzo() + "]";
    }

}





