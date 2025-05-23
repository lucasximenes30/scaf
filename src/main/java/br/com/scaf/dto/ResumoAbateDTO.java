package br.com.scaf.dto;

public class ResumoAbateDTO {

    private long quantidadeDeAbates;
    private double pesoTotalAbatido;
    private double quebraTotal;

    public ResumoAbateDTO(long quantidadeDeAbates, double pesoTotalAbatido, double quebraTotal) {
        this.quantidadeDeAbates = quantidadeDeAbates;
        this.pesoTotalAbatido = pesoTotalAbatido;
        this.quebraTotal = quebraTotal;
    }

    public long getQuantidadeDeAbates() {
        return quantidadeDeAbates;
    }

    public void setQuantidadeDeAbates(long quantidadeDeAbates) {
        this.quantidadeDeAbates = quantidadeDeAbates;
    }

    public double getPesoTotalAbatido() {
        return pesoTotalAbatido;
    }

    public void setPesoTotalAbatido(double pesoTotalAbatido) {
        this.pesoTotalAbatido = pesoTotalAbatido;
    }

    public double getQuebraTotal() {
        return quebraTotal;
    }

    public void setQuebraTotal(double quebraTotal) {
        this.quebraTotal = quebraTotal;
    }
}
