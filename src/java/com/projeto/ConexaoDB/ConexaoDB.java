/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.ConexaoDB;

import com.projeto.util.JSFUtil;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//import com.faculdade.util.JSFUtil;

public class ConexaoDB {
    private static final String USUARIO = "postgres";
	private static final String SENHA = "123456";
	private static final String URL= "jdbc:postgresql://localhost:5432/projetoIntegrador";
	
	public ResultSet rsl;
	public java.sql.Statement stm;
	
	public Connection conexao;
	
	public void conectar() {
		
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		}catch (Exception ex) {
			JSFUtil.mensagemErro("ERRO CRITICAL FALTY: " + ex.getMessage());
			ex.printStackTrace();
                } 		
	}
	
	public void desconectar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			JSFUtil.mensagemErro("ERRO CRITICAL FALTY: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void PesquisarSql(String sql){
        try {
            stm = conexao.createStatement(rsl.TYPE_SCROLL_INSENSITIVE, rsl.CONCUR_READ_ONLY);
            rsl = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JSFUtil.mensagemErro("ERRO CRITICAL FALTY: " + ex.getMessage());
        }
        
    }
    
}
