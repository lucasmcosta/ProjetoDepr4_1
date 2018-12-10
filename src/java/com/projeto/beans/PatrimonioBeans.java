
package com.projeto.beans;

import com.projeto.dao.ClienteDao;
import com.projeto.dao.DepreciacaoDao;
import com.projeto.dao.PatrimonioDao;
import com.projeto.domain.Cliente;
import com.projeto.domain.Depreciacao;
import com.projeto.domain.Patrimonio;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean (name = "MBPatrimonio")
public class PatrimonioBeans {
    private Patrimonio pat;
    private PatrimonioDao dao;   
    private Depreciacao dp;
    
    
    private ArrayList<Patrimonio> listaP;
    private ArrayList<Patrimonio> listaFiltrada;
    private ArrayList<Cliente> listaC;         
    

    public void carregarLista(){
        dao = new PatrimonioDao();
        listaP = dao.listaPatrimonio();
        
    }

    public void estanciarPatrimonio(){
        pat = new Patrimonio();
        ClienteDao daoC = new ClienteDao();
        listaC = daoC.listarCliente();
    }
    
    public void novoPatrimonio(){
        dao = new PatrimonioDao();
        dao.salvarPatrimonio(pat);
        
        listaP=dao.listaPatrimonio();
    }
    
    public void calcular(){
        DepreciacaoDao daoP = new DepreciacaoDao();
        dp = daoP.CalcularDepreciacao(pat);
        
    }
    
    public void salvar(){
        DepreciacaoDao daoP = new DepreciacaoDao();
        daoP.salvar(dp);
    }
    
    public ArrayList<Patrimonio> getListaP() {
        return listaP;
    }

    public void setListaP(ArrayList<Patrimonio> listaP) {
        this.listaP = listaP;
    }

    public ArrayList<Patrimonio> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(ArrayList<Patrimonio> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public Patrimonio getPat() {
        return pat;
    }

    public void setPat(Patrimonio pat) {
        this.pat = pat;
    }

    public PatrimonioDao getDao() {
        return dao;
    }

    public void setDao(PatrimonioDao dao) {
        this.dao = dao;
    }

    public ArrayList<Cliente> getListaC() {
        return listaC;
    }

    public void setListaC(ArrayList<Cliente> listaC) {
        this.listaC = listaC;
    }

    public Depreciacao getDp() {
        return dp;
    }

    public void setDp(Depreciacao dp) {
        this.dp = dp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
