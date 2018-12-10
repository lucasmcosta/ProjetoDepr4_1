/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.dao;

import com.projeto.domain.Cliente;
import com.projeto.domain.Patrimonio;
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
public class PatrimonioDaoTest {
    
    Cliente cl;
    ClienteDao dao;
    Patrimonio p;
    PatrimonioDao dap;
    
    @Test
    public void salvarPatrimonio(){
        SimpleDateFormat dt = new SimpleDateFormat( "dd/MM/yyyy" );
        cl = new Cliente();
        
        cl.setId(1);
        dap = new PatrimonioDao();
        p = new Patrimonio();
        
        p.setDescricao("veiculo");
        p.setValorBem(32000);
        p.setVidaUtilB(5);
        p.setValorResidual(3200);
        p.setValorVenda(25000);
        p.setSituacao("usado");
        p.setTurno(2);
        p.setStatus("em uso");
        p.setCliente(cl);
        
        try {
            p.setDataAquisicao(dt.parse("22/08/2018"));
             p.setDataVenda(dt.parse("23/08/2018"));
        } catch (ParseException ex) {
            Logger.getLogger(ClienteDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dap.salvarPatrimonio(p);
        
    }
    
    
}
