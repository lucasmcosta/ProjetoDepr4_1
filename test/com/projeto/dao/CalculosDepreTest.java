/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.dao;

import com.projeto.domain.Depreciacao;
import com.projeto.domain.Patrimonio;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CalculosDepreTest {
    
   @Test
   public void somarDeprNovo(){
       SimpleDateFormat dt = new SimpleDateFormat( "dd/MM/yyyy" );
       
       Patrimonio pt = new Patrimonio();
       Depreciacao dp;
       DepreciacaoDao c = new DepreciacaoDao();
       
       pt.setDescricao("veiculo");
       pt.setValorBem(32000);
       pt.setValorResidual(3200);
       pt.setVidaUtilB(5);
      pt.setTurno(1);
      pt.setSituacao("novo");
      pt.setValorVenda(25000);
   
      try {
           pt.setDataAquisicao(dt.parse("18/12/2015"));
           pt.setDataVenda(dt.parse("18/12/2018"));
       } catch (ParseException ex) {
           Logger.getLogger(CalculosDepreTest.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       dp = c.CalcularDepreciacao(pt);
       
        System.out.println("valor da  depreciaçao acumilada :" + dp.getDepreAcumulada());
       System.out.println("valor contabil :" + dp.getValorContabil());
       System.out.println("Saldo" + dp.getSaldo());
        
   }
    
}
