import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class YellowPages {
    private HashMap<String, Noleggio> mappaCittaNoleggio; //Hash map: citta= chiave, relativo noleggio = valore
    private ArrayList<Persona> persone; //collection delle persone iscritte

    public YellowPages() {
        mappaCittaNoleggio = new HashMap<>();
        persone = new ArrayList<>();
        //inizializziamo le collection vuote per ora

    }

    public void aggiungiCittaNoleggio(String citta, Noleggio n) {
        if (mappaCittaNoleggio.containsKey(citta)) {  //controllo se chiave specificata e' gia' presente nella mappa
            System.out.println("Errore: la citta' esiste gia'. ");
        } else {
            mappaCittaNoleggio.put(citta, n); //se non e' gia' presente la aggiunge
        }
    }

    //eliminare citta - noleggio
    public void eliminaCittaNoleggio(String citta) {
        mappaCittaNoleggio.remove(citta);
    }

    //aggiungere una persona a quelle iscritte
    public void aggiungiPersona(Persona p) {
        persone.add(p);
    }

    //elimina p
    public void eliminaPersona(Persona p) {
        persone.remove(p);
    }

// data la citta restituire la collection  id (bici) disponibili di quella citta -- usato hash perche non voglio duplicati
  public HashSet <Integer> bicicletteDisponibiliInCitta(String citta) {
        HashSet<Integer> ids = new HashSet<>(); //nuova collezione per memorizzare id delle bici disponibili
        Noleggio n =  mappaCittaNoleggio.get(citta); //si cerca nella mappa tramite la chiave specifica
        if (n != null) { //se n e' diversa da null, allora la citta e' registrata e il servizio di noleggio esiste
            for (Bici b : n.getBici()) {
                if (b.getAttualeAssegnatario() == null) { //se null la bici non e' noleggiata
                    ids.add(b.getId());  //se bici e' libera il suo id viene aggiunto a ids
                }
            }
        }
        return  ids; //
  }
// dato un id di bici trovare dove e' noleggiabile (in quale citta)
    public String trovaCittaDaIdBici (int idBici){
        for (String citta : mappaCittaNoleggio.keySet()) {
            Noleggio n = mappaCittaNoleggio.get(citta);

            if (n != null) {
                for (Bici b : n.getBici()) {
                    if (b.getId() == idBici) {
                        return citta;
                    }
                }
            }
        }
        return null;
    }

    // ordinare persone iscritte per cognome
    public void ordinaPerCognome(){
        persone.sort((a,b) -> a.getCognome().compareTo(b.getCognome())); //solito comparator x<y = negativo / x=y 0 / x> y positivo
    }

    //conta iscritti
    public int numeroPersoneIscritte(){
        return persone.size();
    }

    //trova elenco citta dove c'e' un noleggio

    public ArrayList<String> elencoCittaConNoleggio() {
        return new ArrayList<>(mappaCittaNoleggio.keySet());
    }
}

