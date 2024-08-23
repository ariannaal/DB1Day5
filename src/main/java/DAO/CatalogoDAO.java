package DAO;


import entities.Catalogo;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CatalogoDAO {

    private final EntityManager em;

    // costruttore
    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("L'elemento del catalogo \"" + catalogo.getTitolo() + "\" è stato salvato con successo!");
    }

    // ricerca di un elemento del catalogo per ID
    public Catalogo findById(String isbn) {
        Catalogo found = em.find(Catalogo.class, isbn);
        if (found == null) throw new NotFoundEx(isbn);
        return found;
    }

    public void findByIdAndDelete(String isbn) {
        Catalogo found = this.findById(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'elemento " + found.getTitolo() + " è stato eliminato con successo.");
    }

    // 22/8/24
//        public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
//            TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class); // specifico il tipo di oggetto che mi viene restituito
//            query.setParameter("inStreaming", inStreaming);
//            return query.getResultList();
//        }
//
//        public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
//            TypedQuery<Concerto> query = em.createQuery("SELECT c.genere, COUNT(c) FROM Concerto c WHERE c.genere = :genere GROUP BY c.genere", Concerto.class);
//            query.setParameter("genere", genere);
//            return query.getResultList();
//        }
//
//        public List<PartitaDiCalcio> getPartiteVinteInCasa() {
//            TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class);
//            return query.getResultList();
//        }
//
//        public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
//            TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
//            return query.getResultList();
//        }
}
