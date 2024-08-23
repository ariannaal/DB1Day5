package DAO;

import entities.Prestito;
import exceptions.NotFoundEx;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();

        System.out.println("Il prestito " + prestito.getId() + " è stato salvato correttamente!");
    }

    public Prestito findById(int id) {
        Prestito found = em.find(Prestito.class, id);
        if (found == null) throw new NotFoundEx(id);
        return found;
    }

    public void findByIdAndDelete(Integer prestitoID) {
        Prestito found = this.findById(prestitoID);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Il prestito " + found.getId() + " è stato eliminato correttamente.");

    }

}
