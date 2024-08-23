package entities;


import enums.Periodicita;
import jakarta.persistence.*;

@Entity
@Table(name = "rivista")
public class Rivista extends Catalogo {


    @Column(name = "periodicita")
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}

