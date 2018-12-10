
package com.projeto.dao;

import com.projeto.ConexaoDB.ConexaoDB;
import com.projeto.domain.Cliente;
import com.projeto.util.JSFUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//import com.faculdade.util.JSFUtil;

public class ClienteDao {

    ConexaoDB conexao = new ConexaoDB();
    Cliente cliente;
    
    
public void salvarCliente(Cliente cliente){
    String sql = "INSERT INTO cliente (nome, cpf) VALUES (?,?)";
    conexao.conectar();    
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            
            pst.executeUpdate();
            JSFUtil.mensagemSucesso("Dados Salvos com Sucesso!");
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Erro :" + ex);
           JSFUtil.mensagemErro("ERRO : " + ex.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    conexao.desconectar();
}
    
public void alterarCliente(Cliente cliente){
    String sql = "UPDATE cliente SET cliente = ?, cpf = ? WHERE "+ cliente.getId();
    conexao.conectar();    
        try {
            PreparedStatement pst = conexao.conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            
            pst.executeUpdate();
           // JOptionPane.showMessageDialog(null,"salvos");
            JSFUtil.mensagemSucesso("Dados Salvos com Sucesso!");
        } catch (SQLException ex) {
          //  JOptionPane.showMessageDialog(null,"Erro :" + ex);
           JSFUtil.mensagemErro("Erro ao Salvar Dados: " + ex.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
    conexao.desconectar();
    
}
 
public Cliente pesquisarPorCpf(Cliente cliente){
    
    String sql ="SELECT * FROM cliente WHERE cpf = "+cliente.getCpf();
    conexao.conectar();
        try {
            conexao.rsl.first();
            cliente.setId(conexao.rsl.getInt("id"));
            cliente.setNome(conexao.rsl.getString("nome"));
            cliente.setCpf(conexao.rsl.getString("cpf"));
            
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("ERRO ao Carregar a lista: " + ex.getMessage());
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    conexao.desconectar();
    
    return cliente;
}

public ArrayList<Cliente> listarCliente(){   
    conexao.conectar();
    ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    conexao.PesquisarSql("SELECT * FROM cliente;");
    
        try {
            while(conexao.rsl.next()){
                cliente = new Cliente();
                
                cliente.setId(conexao.rsl.getInt("id"));
                cliente.setNome(conexao.rsl.getString("nome"));
                cliente.setCpf(conexao.rsl.getString("cpf"));
                
                listaCliente.add(cliente);
                
            }   } catch (SQLException ex) {
                JSFUtil.mensagemErro("ERRO : " + ex.getMessage());
                
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    conexao.desconectar();
    
    return listaCliente;
}

}
