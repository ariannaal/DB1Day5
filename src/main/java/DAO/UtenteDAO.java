package DAO;

import entities.Utente;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente \"" + utente.getNome() + " " + utente.getCognome() + "\" è stato salvato con successo!");
    }

    public Utente findById(int utenteId) {
        Utente found = em.find(Utente.class, utenteId); // Primo parametro è la classe dell'entità, secondo è l'id da cercare
        if (found == null) throw new NotFoundEx(utenteId);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Utente found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'utente \"" + found.getNome() + " " + found.getCognome() + "\" è stato eliminato con successo.");
    }
}
