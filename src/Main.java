public class Main {
    public static void main(String[] args) {

        // Creiamo alcune persone
        Persona p1 = new Persona(1, "Rossi", "Via Roma 10");
        Persona p2 = new Persona(2, "Bianchi", "Corso Italia 5");
        Persona p3 = new Persona(3, "Verdi", "Via Po 7");

        // Creiamo una casa produttrice di biciclette
        CasaBici casa1 = new CasaBici("Velocipede SRL", p1, "Italia");

        // Creiamo bici normali
        Bici b1 = new Bici(casa1, "Modello A", null, 120);
        Bici b2 = new Bici(casa1, "Modello B", null, 150);

        // Aumentiamo i noleggi per testare logica statistiche
        b1.cambioNoleggio(p2);
        b1.cambioNoleggio(p3);
        b1.cambioNoleggio(p1);

        b2.cambioNoleggio(p3);

        // Creiamo una bici elettrica
        BiciElettrica eb1 = new BiciElettrica(casa1, "Modello E", null, 200, 50, 3);
        eb1.cambioNoleggio(p2);
        eb1.cambioNoleggio(p3);
        eb1.aumentaAutonomia(10);

        // Creiamo una bici non prestabile
        BiciNonPrestabile np1 = new BiciNonPrestabile(casa1, "Modello NP", p1, 100);
        np1.cambioNoleggio(p2);

        System.out.println("=== Stato assegnatari ===");
        System.out.println("b1 assegnatario: " + (b1.getAttualeAssegnatario() != null ? b1.getAttualeAssegnatario().getCognome() : "nessuno"));
        System.out.println("b2 assegnatario: " + (b2.getAttualeAssegnatario() != null ? b2.getAttualeAssegnatario().getCognome() : "nessuno"));
        System.out.println("eb1 assegnatario: " + (eb1.getAttualeAssegnatario() != null ? eb1.getAttualeAssegnatario().getCognome() : "nessuno"));
        System.out.println("np1 assegnatario: " + (np1.getAttualeAssegnatario() != null ? np1.getAttualeAssegnatario().getCognome() : "nessuno"));


        System.out.println("\n=== Test informazioni bici elettrica ===");
        System.out.println(eb1);

        System.out.println("\n=== Test equals() ===");
        System.out.println("b1.equals(b2): " + b1.equals(b2));
        Bici b3 = new Bici(casa1, "Modello A", null, 130);
        System.out.println("b1.equals(b3): " + b1.equals(b3));

        System.out.println("\n=== Test Noleggio ===");
        Noleggio n = new Noleggio(p1, "Nolo Center", "Milano");
        n.inserisciBici(b1);
        n.inserisciBici(b2);
        n.inserisciBici(eb1);
        n.inserisciBici(np1);

        System.out.println("Numero bici nel noleggio: " + n.getBici().size());
        System.out.println("Numero bici elettriche: " + n.numeroBiciElettriche());
        System.out.println("Assegnatario bici ID 2: " + n.trovaAssegnatario(2));
        System.out.println("ID bici più noleggiata: " + n.biciPiuNoleggiata());
        System.out.println("Lista ID bici con almeno 1 noleggio: " + n.biciNoleggiateAlmenoX(1));
        System.out.println("ID unici nel noleggio: " + n.getIdentificativBici());
        System.out.println("Bici ordinate per prezzo: " + n.biciOrdinatePerPrezzo());
        System.out.println("Bici con prezzo massimo: " + n.biciConPrezzoMax());

        System.out.println("\n=== Test setter casa bici ===");
        CasaBici casa2 = new CasaBici("Trek SPA", p2, "Germania");
        eb1.setCasaProduttrice(casa2);
        System.out.println("eb1 nuova casa: " + eb1);

        System.out.println("\n=== Test aumenta/diminuisci prezzo ===");
        b1.aumentaPrezzo(30);
        b2.diminuisciPrezzo(500);
        System.out.println("b1 dopo aumenta prezzo: " + b1);
        System.out.println("b2 dopo diminuisci prezzo (non sotto 0): " + b2);

        System.out.println("\n=== Test cambio assegnatario via noleggio ===");
        n.cambiaAssegnatario(1, p3);
        System.out.println("Nuovo assegnatario b1 tramite noleggio: " + n.trovaAssegnatario(1));

        System.out.println("\n=== Test setter modello ===");
        b1.setModello("Modello Z");
        System.out.println("Modello aggiornato b1: " + b1);

        System.out.println("\n=== Test setter prezzo mensile ===");
        b3.setPrezzoMensile(180);
        System.out.println("Prezzo aggiornato b3: " + b3);

        System.out.println("\n=== Test getter casa bici esplicito ===");
        System.out.println("Casa di eb1: " + eb1.getCasaBici());

        System.out.println("\n=== Contatore statico bici costruite ===");
        System.out.println("Totale bici costruite: " + Bici.getNumeroBiciCostruite());

        System.out.println("\n=== Test elimina bici ===");
        n.eliminaBici(b2);
        System.out.println("Dopo rimozione, bici totali: " + n.getBici().size());

        System.out.println("\n=== Test diretto getCasaBici() ===");
        System.out.println(b1.getCasaBici());
    }
}