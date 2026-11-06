/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {
    public ArrayList<Usuario> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList();
        
        try {
            String query = "SELECT * FROM usuario";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                
                usuarios.add(u);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Usuários. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return usuarios;
    }
    
    public Usuario read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
                
        try {
            String query = "SELECT * FROM usuario WHERE id_usuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            Usuario u = new Usuario();
            if(rs.next()) {
                u.setId(rs.getInt("id_usuario"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
            }
            
            return u;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Usuários. Erro: " + e.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
        
        return null;
    }
}
