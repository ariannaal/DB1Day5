package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {

    @Id
    @Column(name = "isbn")
    protected String isbn;

    @Column(name = "titolo")
    protected String titolo;

    @Column(name = "anno_pubblicazione")
    protected int annoPubblicazione;

    @Column(name = "n_pagine")
    protected int numeroPagine;

    @OneToMany(mappedBy = "elemento")
    protected List<Prestito> prestiti;

    public Catalogo() {
    }

    public Catalogo(String isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
