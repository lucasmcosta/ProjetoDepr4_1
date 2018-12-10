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
import org.junit.Ignore;
import org.junit.Test;

public class ClienteDaoTest {
    
    Cliente cl;
    ClienteDao dao;
    Patrimonio p;
    PatrimonioDao dap;
    
    @Test
    @Ignore
    public void salvar(){
    dao = new ClienteDao();
    cl = new Cliente();
    
    cl.setNome("Lucas Marques");
    cl.setCpf("0113344");
    
    dao.salvarCliente(cl);   
    }
    
}
