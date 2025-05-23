package br.com.scaf.dto;

import java.time.LocalDate;

public class VendaDTO {

    private Long id;
    private LocalDate data;
    private Double pesoVendido;
    private String clienteNome;

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

    public Double getPesoVendido() {
        return pesoVendido;
    }

    public void setPesoVendido(Double pesoVendido) {
        this.pesoVendido = pesoVendido;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}
