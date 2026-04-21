package model;

import java.sql.Date;

public class NotaFiscal {
    private int nfId;
    private int fkCliente;
    private Date dataEmissao;
    private double valorTotal;

    public NotaFiscal() {
    }

    public NotaFiscal(int nfId, int fkCliente, Date dataEmissao, double valorTotal) {
        this.nfId = nfId;
        this.fkCliente = fkCliente;
        this.dataEmissao = dataEmissao;
        this.valorTotal = valorTotal;
    }

    public int getNfId() {
        return nfId;
    }

    public void setNfId(int nfId) {
        this.nfId = nfId;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}