/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Fornecedor;

/**
 *
 * @author Aluno
 */
public class FornecedorDAO {
    public void create(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO fornecedor(cnpj, razao_social, email, telefone) VALUES (?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, f.getCnpj());
            stmt.setString(2, f.getRazaoSocial());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getTelefone());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Fornecedor. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<Fornecedor> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Fornecedor> fornecedores = new ArrayList();
        
        try {
            String query = "SELECT * FROM fornecedor";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id_fornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setRazaoSocial(rs.getString("razao_social"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                
                fornecedores.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Fornecedores. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return fornecedores;
    }
    
    public Fornecedor read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM fornecedor WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            Fornecedor f = new Fornecedor();
            if(rs.next()) {
                f.setId(rs.getInt("id_fornecedor"));
                f.setCnpj(rs.getString("cnpj"));
                f.setRazaoSocial(rs.getString("razao_social"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
            }
            
            return f;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Fornecedores. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return null;
    }
    
    public void update(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE fornecedor "
                    + "SET cnpj = ?, razao_social = ?, email = ?, telefone = ? "
                    + "WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, f.getCnpj());
            stmt.setString(2, f.getRazaoSocial());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getTelefone());
            stmt.setInt(5, f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Fornecedor. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(Fornecedor f) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor Excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Fornecedor. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
