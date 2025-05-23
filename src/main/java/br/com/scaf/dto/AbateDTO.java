package br.com.scaf.dto;

import java.time.LocalDate;

public class AbateDTO {

    private Long id;
    private LocalDate data;
    private Double pesoInicial;
    private Double pesoFinal;
    private Double quebra;
    private String fornecedorNome;

    public AbateDTO() {}

    public AbateDTO(Long id, LocalDate data, Double pesoInicial, Double pesoFinal, Double quebra, String fornecedorNome) {
        this.id = id;
        this.data = data;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.quebra = quebra;
        this.fornecedorNome = fornecedorNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    public Double getQuebra() {
        return quebra;
    }

    public void setQuebra(Double quebra) {
        this.quebra = quebra;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
