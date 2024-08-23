package org.example;

import DAO.CatalogoDAO;
import DAO.PrestitoDAO;
import DAO.UtenteDAO;
import entities.*;
import enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D5");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

        Libro libro = new Libro("978-1234567860", "Le otto montagne", 2018, 300, "Paolo Cognetti", "Romanzo");
//        cd.save(libro);

        Libro libro1 = new Libro("978-1244567860", "1984", 1949, 400, "George Orwell", "Fantasy");
//        cd.save(libro1);

        Libro libro2 = new Libro("978-1234547860", "Cime tempestose", 1847, 300, "Emily Bronte", "Romanzo");
//        cd.save(libro2);

        Libro libro3 = new Libro("968-1234567860", "Orgoglio e pregiudizio", 1813, 500, "Jane Austen", "Romanzo");
//        cd.save(libro3);

        Libro libro4 = new Libro("978-1232567860", "Frankestein", 1818, 500, "Mary Shelley", "Fantasy");
//        cd.save(libro4);

        Libro libro5 = new Libro("978-1234557860", "Robinson Crusoe", 1719, 600, "Daniel Defoe", "Avventura");
//        cd.save(libro5);

        Rivista rivista = new Rivista("978-3-16-148410-0", "Rivista di moda", 2024, 120, Periodicita.MENSILE);
//        cd.save(rivista);

        Rivista rivista1 = new Rivista("978-4-16-148410-0", "Rivista di viaggi", 2024, 120, Periodicita.SEMESTRALE);
//        cd.save(rivista1);

        Rivista rivista2 = new Rivista("978-5-16-148410-0", "Rivista di storia", 2024, 120, Periodicita.SETTIMANALE);
//        cd.save(rivista2);

        Rivista rivista3 = new Rivista("978-6-16-148410-0", "Rivista di auto", 2024, 120, Periodicita.MENSILE);
//        cd.save(rivista3);

        Rivista rivista4 = new Rivista("978-7-16-148410-0", "Rivista di animali", 2024, 120, Periodicita.SETTIMANALE);
//        cd.save(rivista4);

        Utente utente = new Utente("Marco", "Poretti", LocalDate.of(1995, 5, 19), 1000);
//        ud.save(utente);

        Utente utente1 = new Utente("Andrea", "Franchi", LocalDate.of(1997, 2, 26), 1001);
//        ud.save(utente1);

        Utente utente2 = new Utente("Luca", "Bianchi", LocalDate.of(1985, 8, 21), 1002);
//        ud.save(utente2);

        Utente utente3 = new Utente("Giulia", "Verdi", LocalDate.of(1992, 11, 30), 1003);
//        ud.save(utente3);

        Utente utente4 = new Utente("Mario", "Rossi", LocalDate.of(1990, 3, 16), 1004);
//        ud.save(utente4);


        Prestito prestito = new Prestito(123455, utente, libro, LocalDate.of(2024, 8, 20), LocalDate.of(2024, 8, 23));
//        pd.save(prestito);

        Prestito prestito1 = new Prestito(127356, utente1, libro1, LocalDate.of(2024, 5, 15), LocalDate.of(2024, 5, 20));
//        pd.save(prestito1);

        Prestito prestito2 = new Prestito(122357, utente2, libro2, LocalDate.of(2024, 7, 18), LocalDate.of(2024, 8, 29));
//        pd.save(prestito2);

        Prestito prestito3 = new Prestito(123458, utente3, libro3, LocalDate.of(2024, 9, 25), LocalDate.of(2024, 9, 28));
//        pd.save(prestito3);

        Prestito prestito4 = new Prestito(123459, utente1, libro1, LocalDate.of(2024, 10, 4), LocalDate.of(2024, 10, 27));
//        pd.save(prestito4);

        // rimozione tramite isbn

//        Catalogo elementoRimosso = cd.findByIdAndDelete("978-7-16-148410-0");
//        if (elementoRimosso != null) {
//            System.out.println("L'elemento " + elementoRimosso.getTitolo() + " è stato eliminato con successo.");
//        } else {
//            System.out.println("Elemento del catalogo non trovato.");
//        }

        // ricerca di un elemento del catalogo per isbn
        Catalogo elementoTrovato = cd.findById("978-3-16-148410-0");
        if (elementoTrovato != null) {
            System.out.println("Elemento del catalogo trovato: " + elementoTrovato.getTitolo());
        } else {
            System.out.println("Elemento del catalogo non trovato.");
        }

        //ricerca tramite anno di pubblicazione
        List<Catalogo> elementiAnnoPubblicazione = cd.findByAnnoPubblicazione(1949);
        if (!elementiAnnoPubblicazione.isEmpty()) {
            System.out.println("Elementi del catalogo con anno di pubblicazione: " + elementiAnnoPubblicazione.stream().count() + ".");
            for (Catalogo c : elementiAnnoPubblicazione) {
                System.out.println("Titolo dell'elemento trovato con anno di pubblicazione " + c.getAnnoPubblicazione() + ": " + c.getTitolo());
            }
        } else {
            System.out.println("Nessun elemento trovato per l'anno di pubblicazione " + elementiAnnoPubblicazione + ".");
        }

        // ricerca per autore
        List<Catalogo> elementiAutore = cd.findAutore("Paolo Cognetti");
        if (!elementiAutore.isEmpty()) {
            System.out.println("Numero di elementi trovati: " + elementiAutore.stream().count());
            for (Catalogo c : elementiAutore) {
                System.out.println("Titolo dell'elemento trovato con l'autore cercato: " + c.getTitolo());
            }
        } else {
            System.out.println("Nessun elemento trovato per l'autore cercato.");
        }

        // ricerca per titolo o parte di esso
        List<Catalogo> elementiTitolo = cd.ricercaTitolo("montagne");
        if (!elementiTitolo.isEmpty()) {
            System.out.println("Elementi del catalogo con titolo che contiene la parola cercata \"" + elementiTitolo.stream().count() + "\":");
            for (Catalogo c : elementiTitolo) {
                System.out.println("Titolo: " + c.getTitolo());
            }
        } else {
            System.out.println("Nessun elemento trovato per il titolo che contiene la parola cercata");
        }

        // ricerca elementi in prestito con numero tessera
        List<Prestito> elementiInPrestito = pd.findElementiInPrestito(1001);
        if (!elementiInPrestito.isEmpty()) {
            System.out.println("Elementi attualmente in prestito per l'utente con numero di tessera cercato.");
            for (Prestito p : elementiInPrestito) {
                System.out.println("Id dell'elemento in prestito: " + p.getId());
            }
        } else {
            System.out.println("Nessun elemento in prestito trovato per l'utente con numero di tessera cercato.");
        }


        // ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Prestito> prestitiScaduti = pd.findPrestitiScaduti(1001);
        if (!prestitiScaduti.isEmpty()) {
            System.out.println("Prestiti scaduti e non ancora restituiti:" + prestitiScaduti.stream().count());
            for (Prestito p : prestitiScaduti) {
                System.out.println("Prestiti scaduti e non ancora restituiti: " + p.getElemento().getTitolo() +
                        ", data inizio prestito: " + p.getDataInizioPrestito() +
                        ", data restituzione prevista: " + p.getDataRestituzionePrevista());
            }
        } else {
            System.out.println("Nessun prestito scaduto e non ancora restituito trovato.");
        }


    }
}



