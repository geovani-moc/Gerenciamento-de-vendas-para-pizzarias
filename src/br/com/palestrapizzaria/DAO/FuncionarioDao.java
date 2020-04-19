/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import br.com.palestrapizzaria.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alvaro
 */
public class FuncionarioDao extends Dao<Funcionario> {

    Connection con = ConectaBanco.getConexao();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int salvar(Funcionario obj) {
        if (obj.getId() == null) {
            try {
                pstmt = con.prepareStatement("INSERT INTO tbFuncionario(nome,cpf,telefone,rua,bairro,numero,complemento,cargo) VALUES (?,?,?,?,?,?,?,?);");
                pstmt.setString(1, obj.getNome());
                pstmt.setString(2, obj.getCpf().toString());
                pstmt.setString(3, obj.getTelefone().toString());
                pstmt.setString(4, obj.getRua());
                pstmt.setString(5, obj.getBairro());
                pstmt.setInt(6, obj.getNumero());
                pstmt.setString(7, obj.getComplemento());
                pstmt.setString(8, obj.getCargo());
                pstmt.executeUpdate();

                pstmt.close();

            } catch (Exception e) {
                e.printStackTrace();
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Funcionario buscar(String str) {
        Funcionario f = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbFuncionario WHERE nome = ?;");
            pstmt.setString(1, str);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                f = new Funcionario();
                f.setCargo(rs.getString("cargo"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(Long.parseLong(rs.getString("telefone")));
                f.setCpf(Long.parseLong(rs.getString("cpf")));
                f.setRua(rs.getString("rua"));
                f.setBairro(rs.getString("bairro"));
                f.setNumero(rs.getInt("numero"));
                f.setComplemento(rs.getString("complemento"));
            }
            pstmt.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Funcionario> buscar(String str, Integer limit) {
        ArrayList<Funcionario> dados = new ArrayList<>();
        try {
            if (str == null) {

                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbFuncionario");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbFuncionario limit ?");
                    pstmt.setInt(1, limit);
                }
            } else {
                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbFuncionario WHERE nome like ?;");
                    pstmt.setString(1, "%" + str + "%");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbFuncionario WHERE nome like ? limit ?");
                    pstmt.setString(1, "%" + str + "%");
                    pstmt.setInt(2, limit);
                }
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Funcionario nc = new Funcionario();
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
        if (dados.isEmpty()) {
            return null;
        }
        return dados;
    }

    @Override
    public int excluir(Funcionario obj) {
        try {
            pstmt = con.prepareStatement("DELETE FROM tbFuncionario WHERE id=?;");
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
