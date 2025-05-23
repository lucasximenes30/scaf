package br.com.scaf.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Abate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private Double pesoInicial;

    private Double pesoFinal;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public Double getQuebra() {
        if (pesoInicial != null) {
            return pesoInicial * 0.15;
        }
        return null;
    }

    @PrePersist
    @PreUpdate
    public void calcularPesoFinalComQuebra() {
        if (pesoInicial != null) {
            this.pesoFinal = pesoInicial - getQuebra();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
