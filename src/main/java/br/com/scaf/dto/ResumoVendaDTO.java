package br.com.scaf.dto;

public class ResumoVendaDTO {

    private long quantidadeDeVendas;
    private double pesoTotalVendido;

    public ResumoVendaDTO(long quantidadeDeVendas, double pesoTotalVendido) {
        this.quantidadeDeVendas = quantidadeDeVendas;
        this.pesoTotalVendido = pesoTotalVendido;
    }

    public long getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public void setQuantidadeDeVendas(long quantidadeDeVendas) {
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    public double getPesoTotalVendido() {
        return pesoTotalVendido;
    }

    public void setPesoTotalVendido(double pesoTotalVendido) {
        this.pesoTotalVendido = pesoTotalVendido;
    }
}
