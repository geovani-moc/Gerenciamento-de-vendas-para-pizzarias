/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import br.com.palestrapizzaria.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * f
 *
 * @author alvaro
 */
public class ClienteDao extends Dao<Cliente> {

    Connection con = ConectaBanco.getConexao();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int salvar(Cliente obj) {
        try {
            pstmt = con.prepareStatement("INSERT INTO tbCliente(nome,cpf,telefone,rua,bairro,numero,complemento,cadastro) VALUES (?,?,?,?,?,?,?,?);");
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getCpf().toString());
            pstmt.setString(3, obj.getTelefone().toString());
            pstmt.setString(4, obj.getRua());
            pstmt.setString(5, obj.getBairro());
            pstmt.setInt(6, obj.getNumero());
            pstmt.setString(7, obj.getComplemento());
            pstmt.setBoolean(8, obj.getAtivo());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    public int salvarSemCad(Cliente obj) { // salvar sem cadastro
        try {
            pstmt = con.prepareStatement("INSERT INTO tbCliente(nome,telefone,rua,bairro,numero,complemento,cadastro) VALUES (?,?,?,?,?,?,?);");
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getTelefone().toString());
            pstmt.setString(3, obj.getRua());
            pstmt.setString(4, obj.getBairro());
            pstmt.setInt(5, obj.getNumero());
            pstmt.setString(6, obj.getComplemento());
            pstmt.setBoolean(7, obj.getAtivo());

            pstmt.executeUpdate();

            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

        return 0;
    }
    
    @Override
    public Cliente buscar(String str) {
        Cliente c = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbCliente WHERE nome=?");
            pstmt.setString(1, str);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setBairro(rs.getString("bairro"));
                c.setCpf(Long.parseLong(rs.getString("cpf")));
                c.setNumero(rs.getInt("numero"));
                c.setTelefone(Long.parseLong(rs.getString("telefone")));
                c.setRua(rs.getString("rua"));
                c.setComplemento(rs.getString("complemento"));
            }
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public Cliente buscarSemCad(String str) {
        Cliente c = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbCliente WHERE nome=?");
            pstmt.setString(1, str);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setBairro(rs.getString("bairro"));
                c.setNumero(rs.getInt("numero"));
                c.setTelefone(Long.parseLong(rs.getString("telefone")));
                c.setRua(rs.getString("rua"));
                c.setComplemento(rs.getString("complemento"));
            }
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public ArrayList<Cliente> buscar(String str, Integer limit) {
        ArrayList<Cliente> dados = new ArrayList<>();
        try {
            if (str == null) {

                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbCliente");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbCliente limit ?");
                    pstmt.setInt(1, limit);
                }
            } 
            else
            {
                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbCliente WHERE nome like ?;");
                    pstmt.setString(1, "%"+str+"%");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbCliente WHERE nome like ? limit ?");
                    pstmt.setString(1, "%"+str+"%");
                    pstmt.setInt(2, limit);
                }
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cliente nc = new Cliente();
                nc.setNome(rs.getString("nome"));
                nc.setBairro(rs.getString("bairro"));
                nc.setCpf(Long.parseLong(rs.getString("cpf")));
                nc.setNumero(rs.getInt("numero"));
                nc.setTelefone(Long.parseLong(rs.getString("telefone")));
                nc.setRua(rs.getString("rua"));
                nc.setComplemento(rs.getString("complemento"));
                nc.setId(rs.getInt("id"));
                dados.add(nc);
            }
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(dados.isEmpty())
            return null;
        return dados;
    }

    @Override
    public int excluir(Cliente obj) {
        try {
            pstmt = con.prepareStatement("DELETE FROM tbCliente WHERE id = ?;");
            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            pstmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
