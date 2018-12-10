package com.projeto.dao;

import com.projeto.ConexaoDB.ConexaoDB;
import com.projeto.domain.Cliente;
import com.projeto.domain.Patrimonio;
import com.projeto.util.JSFUtil;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//import com.faculdade.util.JSFUtil;
public class PatrimonioDao {

    ConexaoDB conexao = new ConexaoDB();
    Patrimonio p;
    Cliente c;

    public void salvarPatrimonio(Patrimonio p) {
        String sql = "INSERT INTO patrimonio(descricao, vidaUtilB, valorBem, valorResidual, dataAquisicao, dataVenda, valorVenda, situacao, turno, status, id_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Patrimonio patrimonio = new Patrimonio();
        conexao.conectar();
        try {
            Date dt = new Date(p.getDataAquisicao().getTime());
            Date dt1 = new Date(p.getDataVenda().getTime());

            PreparedStatement pst = conexao.conexao.prepareStatement(sql);
            pst.setString(1, p.getDescricao());
            pst.setInt(2, p.getVidaUtilB());
            pst.setDouble(3, p.getValorBem());
            pst.setDouble(4, p.getValorResidual());
            pst.setDate(5, dt);
            pst.setDate(6, dt1);
            pst.setDouble(7, p.getValorVenda());
            pst.setString(8, p.getSituacao());
            pst.setInt(9, p.getTurno());
            pst.setString(10, p.getStatus());
            pst.setInt(11, p.getCliente().getId());

            pst.executeUpdate();

//            JSFUtil.mensagemSucesso("Dados Salvos com Sucesso!");
           

        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao Salvar Dados: "+ ex);
            Logger.getLogger(PatrimonioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconectar();

    }

    public Patrimonio pesquisarPatrimonio(Patrimonio p){
        String sql = "SELECT * FROM patrimonio WHERE codigo = "+ p.getCodigo();
        conexao.conectar();
        conexao.PesquisarSql(sql);
        
        try {
            conexao.rsl.first();
            p.setCodigo(conexao.rsl.getInt("codigo"));
            p.setDescricao(conexao.rsl.getString("descricao"));
            p.setVidaUtilB(conexao.rsl.getInt("vidaUtilB"));
            p.setValorBem(conexao.rsl.getDouble("valorBem"));
            p.setValorResidual(conexao.rsl.getDouble("valorResidual"));
            p.setDataAquisicao(conexao.rsl.getDate("dataAquisicao"));
            p.setDataVenda(conexao.rsl.getDate("dataVenda"));
            p.setValorBem(conexao.rsl.getDouble("valorBem"));
            p.setSituacao(conexao.rsl.getString("situacao"));
            p.setTurno(conexao.rsl.getInt("turno"));
            p.setStatus(conexao.rsl.getString("status"));
            c.setNome(conexao.rsl.getString("nome"));
            p.setCliente(c);
            
        } catch (SQLException ex) {
            Logger.getLogger(PatrimonioDao.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        conexao.desconectar();
        
        return p;
        
    }
    
    
    public void alterarPatrimonio(Patrimonio p) {
        String sql = "UPDATE patrimonio SET descricao= ?, vidaUtilB=?, valorBem = ?,valorResidual =?, dataAquisicao =?,dataVenda=?, valorVenda=?, situacao=?, turno=?, status=?, id_cliente=?";
        conexao.conectar();

        try {
            PreparedStatement pst = conexao.conexao.prepareStatement(sql);
            pst.setString(1, p.getDescricao());
            pst.setInt(2, p.getVidaUtilB());
            pst.setDouble(3, p.getValorBem());
            pst.setDouble(4, p.getValorResidual());
            pst.setDate(5, (Date) p.getDataAquisicao());
            pst.setDate(6, (Date) p.getDataVenda());
            pst.setDouble(7, p.getValorBem());
            pst.setString(8, p.getSituacao());
            pst.setInt(9, p.getTurno());
            pst.setString(10, p.getStatus());
            pst.setInt(11, p.getCliente().getId());

            pst.executeUpdate();

            JSFUtil.mensagemSucesso("Dados Salvos com Sucesso!");
            

        } catch (SQLException ex) {
            JSFUtil.mensagemErro("Erro ao Salvar Dados: "+ ex);
            
            Logger.getLogger(PatrimonioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconectar();

    }

    public ArrayList<Patrimonio> listaPatrimonio() {
        conexao.conectar();
        ArrayList<Patrimonio> listaPatrimonio = new ArrayList<Patrimonio>();
        conexao.PesquisarSql("SELECT p.*, c.nome FROM patrimonio p INNER JOIN cliente c ON p.id_cliente = c.id ORDER BY descricao ASC");

        try {
            while (conexao.rsl.next()) {
                p = new Patrimonio();
                c = new Cliente();
                p.setCodigo(conexao.rsl.getInt("codigo"));

                p.setDescricao(conexao.rsl.getString("descricao"));
                p.setVidaUtilB(conexao.rsl.getInt("vidaUtilB"));
                p.setValorBem(conexao.rsl.getDouble("valorBem"));
                p.setValorResidual(conexao.rsl.getDouble("valorResidual"));
                p.setDataAquisicao(conexao.rsl.getDate("dataAquisicao"));
                p.setDataVenda(conexao.rsl.getDate("dataVenda"));
                p.setValorVenda(conexao.rsl.getDouble("valorVenda"));
                p.setSituacao(conexao.rsl.getString("situacao"));
                p.setTurno(conexao.rsl.getInt("turno"));
                p.setStatus(conexao.rsl.getString("status"));
                c.setNome(conexao.rsl.getString("nome"));
                p.setCliente(c);
                
                listaPatrimonio.add(p);
                
            }
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("ERRO : " + ex.getMessage());
            Logger.getLogger(PatrimonioDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconectar();

        return listaPatrimonio;
    }
}
