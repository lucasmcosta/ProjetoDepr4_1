
package com.projeto.domain;

import java.util.Date;


public class Patrimonio {
    
        private int codigo;
        private String descricao;
	private int vidaUtilB;
	private double valorBem;
	private double valorResidual;
	private Date dataAquisicao;
	private Date dataVenda;
	private double valorVenda;
	private String situacao;
	private int turno;
	private String status;
        private Cliente cliente = new Cliente();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVidaUtilB() {
        return vidaUtilB;
    }

    public void setVidaUtilB(int vidaUtilB) {
        this.vidaUtilB = vidaUtilB;
    }

    public double getValorBem() {
        return valorBem;
    }

    public void setValorBem(double valorBem) {
        this.valorBem = valorBem;
    }

    public double getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(double valorResidual) {
        this.valorResidual = valorResidual;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
        
    

    
}
