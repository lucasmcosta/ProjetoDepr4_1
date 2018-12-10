package com.projeto.domain;

import java.util.Date;

public class Depreciacao {

    private double depreAcumulada = 0.0;
    private double valorContabil = 0.0;
    private double saldo;
    private double vlDepreAnual;
    private double vlDepreMensal;
    private double vlDepreTotal;
    private Date dataDepre;
    private Patrimonio patrimonio = new Patrimonio();

    public Date getDataDepre() {
        return dataDepre;
    }

    public void setDataDepre(Date dataDepre) {
        this.dataDepre = dataDepre;
    }

    

    public double getDepreAcumulada() {
        return depreAcumulada;
    }

    public void setDepreAcumulada(double depreAcumulada) {
        this.depreAcumulada = depreAcumulada;
    }

    public double getValorContabil() {
        return valorContabil;
    }

    public void setValorContabil(double valorContabil) {
        this.valorContabil = valorContabil;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getVlDepreAnual() {
        return vlDepreAnual;
    }

    public void setVlDepreAnual(double vlDepreAnual) {
        this.vlDepreAnual = vlDepreAnual;
    }

    public double getVlDepreMensal() {
        return vlDepreMensal;
    }

    public void setVlDepreMensal(double vlDepreMensal) {
        this.vlDepreMensal = vlDepreMensal;
    }

    public double getVlDepreTotal() {
        return vlDepreTotal;
    }

    public void setVlDepreTotal(double vlDepreTotal) {
        this.vlDepreTotal = vlDepreTotal;
    }

    public Patrimonio getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(Patrimonio patrimonio) {
        this.patrimonio = patrimonio;
    }

}
