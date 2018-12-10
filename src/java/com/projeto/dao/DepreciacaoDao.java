/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.dao;

import com.projeto.ConexaoDB.ConexaoDB;
import com.projeto.domain.Depreciacao;
import com.projeto.domain.Patrimonio;
import com.projeto.util.JSFUtil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DepreciacaoDao {
    
    ConexaoDB conexao = new ConexaoDB();

    private double vlDepr;
    private double dplAcumulada;
    private double vlContabil;
    private double vlLucro;
    int periodo = 0;

    public int calcularData(Patrimonio p) {

        Calendar dtInicial = Calendar.getInstance();
        Calendar dtFinal = Calendar.getInstance();

        dtInicial.setTime(p.getDataAquisicao());
        dtFinal.setTime(p.getDataVenda());

        periodo = (dtFinal.get(Calendar.YEAR) - dtInicial.get(Calendar.YEAR)) * 12;

        //Calcular Ano Inicial
        if (dtInicial.get(Calendar.DAY_OF_MONTH) <= 15) {
            periodo = periodo - (dtInicial.get(Calendar.MONTH) - 1);
        } else {
            periodo = periodo - dtInicial.get(Calendar.MONTH);
        }

        //Calcular Ano Final
        if (dtFinal.get(Calendar.DAY_OF_MONTH) <= 15) {
            periodo = periodo + (dtFinal.get(Calendar.MONTH) - 1);
        } else {
            periodo = periodo + dtFinal.get(Calendar.MONTH);
        }

        return periodo;
    }

    public Depreciacao CalcularDepreciacao(Patrimonio p) {
        Depreciacao dp = new Depreciacao();

        calcularData(p);

        double vlDeprAnual = 0; // valor da Depreciacao anual
        double vlDeprMensal = 0; // valor da depreciaçao mensal.
        double vlDeprTotal = 0; // valor total da depreciacao.
        double DeprAcm = 0; // depreceaçao acumulada.
        double vlBem = p.getValorBem(); // valor do bem na aquisiçao
        double taxaDepre = 0;
        int somaData = periodo; // tras a diferença entre as datas inicial e final
        double vlContabil = 0; //valor contabil 
        double saldoDepr = 0; // saldo do calculo da depreceaçao
        double vlResidual = p.getValorResidual();  // valor residual
        double vidaUtil = p.getVidaUtilB();

        //Validação se o produto eh usado
        //Calculo da Taxa de Depreciacao
        int turno = p.getTurno();
        taxaDepre = (100 / vidaUtil) / 100;

        //validando o turno trabalhado 
        if (turno == 2) {
            taxaDepre = (taxaDepre * (1.5));
        } else if (turno == 3) {
            taxaDepre = taxaDepre * 2;
        }

        //Calculo dos  valores da Depreciacao
        vlDeprTotal = vlBem - vlResidual;
        vlDeprAnual = vlDeprTotal / vidaUtil;
        vlDeprMensal = vlDeprAnual / 12;

        //Calculo da Depreciação Acumulada	
        DeprAcm = vlDeprMensal * somaData;

        //Calculo Valor Contabil
        vlContabil = vlBem - DeprAcm;

        //calculo do saldo da depreceação
        saldoDepr = p.getValorVenda() - vlContabil;

        dp.setDepreAcumulada(DeprAcm);
        dp.setSaldo(saldoDepr);
        dp.setValorContabil(vlContabil);

        return dp;
    }

    public void salvar(Depreciacao depreciacao) {
        String sql = "INSERT INTO depreciacao (depreAcumulada, valorcontabil, saldo, vlDepreAnual, vlDepreMensal, vlDepreTotal, id_patrimonio, data_depreciacao) VALUES (?,?,?,?,?,?,?,?)";
        conexao.conectar();

        try {
            Date dt = new Date(depreciacao.getDataDepre().getTime());

            PreparedStatement pst = conexao.conexao.prepareStatement(sql);
            pst.setDouble(1, depreciacao.getDepreAcumulada());
            pst.setDouble(2, depreciacao.getValorContabil());
            pst.setDouble(3, depreciacao.getSaldo());
            pst.setDouble(4, depreciacao.getVlDepreAnual());
            pst.setDouble(5, depreciacao.getVlDepreMensal());
            pst.setDouble(6, depreciacao.getVlDepreTotal());
            pst.setInt(7, depreciacao.getPatrimonio().getCodigo());
            pst.setDate(8, dt);
//JSFUtil.mensagemSucesso("Dados Salvos com Sucesso!");
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao Salvar Dados: " + ex);

            ex.printStackTrace();
        }

        conexao.desconectar();

    }

    public double getVlLucro() {
        return vlLucro;
    }

    public void setVlLucro(double vlLucro) {
        this.vlLucro = vlLucro;
    }

    public double getVlContabil() {
        return vlContabil;
    }

    public void setVlContabil(double vlContabil) {
        this.vlContabil = vlContabil;
    }

    public double getDplAcumulada() {
        return dplAcumulada;
    }

    public void setDplAcumulada(double dplAcumulada) {
        this.dplAcumulada = dplAcumulada;
    }

    public double getVlDepr() {
        return vlDepr;
    }

    public void setVlDepr(double vlDepr) {
        this.vlDepr = vlDepr;
    }

}
