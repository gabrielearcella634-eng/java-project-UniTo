import java.util.ArrayList;
import java.util.HashSet;

public class Noleggio {
    private Persona titolare;
    private String nome;
    private String indirizzo;
    private ArrayList<Bici> bici;

    //costruttore

    public Noleggio(Persona titolare, String nome, String indirizzo) {
        this.titolare = titolare;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.bici = new ArrayList<>(); // prima mettiamo collection vuota

    }

    //getter e setter
    public Persona getTitolare() {
        return titolare;
    }

    public void setTitolare(Persona titolare) {
        this.titolare = titolare;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    //inserire bici nel noleggio
    public void inserisciBici(Bici b) {
        bici.add(b);
    }

    //eliminare bici dal noleggio
    public void eliminaBici(Bici b) {
        bici.remove(b);
    }

    //trovare numero bici elettriche nel noleggio, usa for per controllare se b e' bici
    public int numeroBiciElettriche() {
        int count = 0;
        for (Bici b : bici) {
            if (b instanceof BiciElettrica) {
                count++;
            }
        }
        return count;
    }

    //trovare a chi e' noleggiata la bici dato il suo id
    //id lo prende da classi genitori
    public Persona trovaAssegnatario(int idBici) {
        for (Bici b : bici) {
            if (b.getId() == idBici) {
                return b.getAttualeAssegnatario();
            }
        }
        return null; //se non trova nulla restituisce null
    }

    //cambiare il noleggiatore di una bici dAto il suo id
    public void cambiaAssegnatario(int idBici, Persona nuovaPersona) {
        for (Bici b : bici) {
            if (b.getId() == idBici) { // sempre controllo che id corrente corrisponda a quello cercato
                b.cambioNoleggio(nuovaPersona);
                break;  //quando cambia avviene, fine ciclo
            }
        }
    }

    // trovare id della bici noleggiata piu' volte
    public int biciPiuNoleggiata() {
        int max = 0;  //inizializzo numero massimo di noleggi trovati finora e non deve essere negativo
        int idMax = -1;
        //inizializzo id bici che ha quel numero massimo di noleggi, inizio a -1 per indicare
        //che ancora non e' stata trovata alcuna bici
        for (Bici b : bici) {
            if (b.getNumeroNoleggi() > max) {      //controllo se num noleggi e' > di quello massimo finora registrato
                //se la condizione e' vera allora c'e' bici noleggiata piu volte
                max = b.getNumeroNoleggi();       //aggiorno max con il nuovo numero di noleggi
                idMax = b.getId();                // aggiorno idMax
            }
        }
        return idMax;
    }
    public ArrayList<Bici> getBici() {
        return bici;
    }

    //collection delle bici
    public HashSet<Integer> getIdentificativBici() {
        HashSet<Integer> ids = new HashSet<>();
        for (Bici b : bici) {
            ids.add(b.getId());
        }
        return ids;
    }

    //restituire collection ordinata per prezzo di noleggio
    public ArrayList<Bici> biciOrdinatePerPrezzo() {
        ArrayList<Bici> copia = new ArrayList<>(bici);
        copia.sort((a,b) -> Integer.compare(a.getPrezzoMensile(), b.getPrezzoMensile()));
        return copia;  //il comparator restituira' numero negativo se x<y / zero se x=y / positivo se x > y
    }
// trovare bici con prezzo noleggio piu alto
    public Bici biciConPrezzoMax(){
        Bici max = null;
        for (Bici b : bici) {
            if(max == null || b.getPrezzoMensile() > max.getPrezzoMensile()){  // se prezzo bici corrente (b) e' maggiore
                // del prezzo della bicicletta memorizzata in max allora diventa quella con il prezzo max.
                max = b;
            }
        }
        return max;
    }

    //trovare bici e id che sono state noleggiate almeno x volte
    public ArrayList<Integer> biciNoleggiateAlmenoX(int x) {
        ArrayList<Integer> ids = new ArrayList<>(); //nuova lista vuota che conterra id che soddisfano il mio requisito
        for (Bici b : bici) {
            if (b.getNumeroNoleggi() >= x) {
                ids.add(b.getId());
            }
        }
        return ids;
    }

}
