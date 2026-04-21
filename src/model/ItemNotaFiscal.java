package model;

public class ItemNotaFiscal {
    private int id;
    private int fkProd;
    private int fkNf;
    private int quantidade;
    private double valorUnitario;
    private double subtotal;

    public ItemNotaFiscal() {
    }

    public ItemNotaFiscal(int id, int fkProd, int fkNf, int quantidade, double valorUnitario, double subtotal) {
        this.id = id;
        this.fkProd = fkProd;
        this.fkNf = fkNf;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public int getFkProd() {
        return fkProd;
    }

    public int getFkNf() {
        return fkNf;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFkProd(int fkProd) {
        this.fkProd = fkProd;
    }

    public void setFkNf(int fkNf) {
        this.fkNf = fkNf;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}