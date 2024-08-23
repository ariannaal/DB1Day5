package DAO;


import entities.Catalogo;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public Catalogo findByIdAndDelete(String isbn) {
        Catalogo found = this.findById(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        return found;
    }

    public List<Catalogo> findByAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno", Catalogo.class);
        query.setParameter("anno", annoPubblicazione);
        return query.getResultList();
    }

}
