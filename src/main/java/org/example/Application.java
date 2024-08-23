package org.example;

import DAO.CatalogoDAO;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D5");
//    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB1D2");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        CatalogoDAO cd = new CatalogoDAO(em);
//
//
////        EventoDAO ed = new EventoDAO(em);
////        PersonaDAO personaDAO = new PersonaDAO(em);
////        LocationDAO locationDAO = new LocationDAO(em);
////
////        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
//
//
        Libro libro = new Libro("978-1234567860", "Le otto montagne", 2018, 300, "Paolo Cognetti", "Romanzo");
        cd.save(libro);
//
//
////            Evento evento1 = new Evento("Proiezione film", LocalDate.of(2023, 1, 1), "film sci-fi", TipoEvento.PUBBLICO, 60, location);
////            ed.save(evento1);


    }
}



