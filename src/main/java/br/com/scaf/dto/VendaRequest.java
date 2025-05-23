package br.com.scaf.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VendaRequest {

    @NotNull(message = "Data da venda é obrigatória")
    private LocalDate data;

    @NotNull(message = "Peso vendido é obrigatório")
    @Positive(message = "Peso vendido deve ser positivo")
    private Double pesoVendido;

    @NotNull(message = "ID do cliente é obrigatório")
    private Long clienteId;

    // Construtor vazio (para Jackson)
    public VendaRequest() {}

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public Double getPesoVendido() {
        return pesoVendido;
    }
    public void setPesoVendido(Double pesoVendido) {
        this.pesoVendido = pesoVendido;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
