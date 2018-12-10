
package com.projeto.beans;

import com.projeto.dao.ClienteDao;
import com.projeto.domain.Cliente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean (name = "MBCliente")
public class ClienteBeans {
    
   private Cliente cliente;
   
   public void estanciarCliente(){
       cliente = new Cliente();
   }
   
   public void cadastrarCliente(){
       ClienteDao dao = new ClienteDao();
       dao.salvarCliente(cliente);
   }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
   
   
}
