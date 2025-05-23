package br.com.scaf.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AbateRequest {

    @NotNull(message = "Data do abate é obrigatória")
    private LocalDate data;

    @NotNull(message = "Peso inicial é obrigatório")
    @Positive(message = "Peso inicial deve ser positivo")
    private Double pesoInicial;

    @NotNull(message = "ID do fornecedor é obrigatório")
    private Long fornecedorId;

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

    public Long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
}
