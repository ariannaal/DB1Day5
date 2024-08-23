package entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "utente")
public class Utente {

    @Id
    @Column(name = "numero_tessera")
    private int numero_tessera;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @OneToMany(mappedBy = "utente")
    private Set<Prestito> prestiti;

    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate dataNascita, int numero_tessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numero_tessera = numero_tessera;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getNumeroTessera() {
        return numero_tessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numero_tessera = numero_tessera;
    }


}
