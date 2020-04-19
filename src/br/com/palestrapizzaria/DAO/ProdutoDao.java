/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import br.com.palestrapizzaria.entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class ProdutoDao extends Dao<Produto> {

    Connection con = ConectaBanco.getConexao();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int salvar(Produto obj) {
        try {
            pstmt = con.prepareStatement("INSERT INTO tbProduto(nome,valor) VALUES (?,?);");
            pstmt.setString(1, obj.getNome());
            pstmt.setDouble(2, obj.getValor());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    @Override
    public Produto buscar(String str) {
        Produto p = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbProduto where nome=?");
            pstmt.setString(1, str);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setId(rs.getInt("id"));
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;

    }

    public ArrayList<Produto> buscar(String str, Integer limit) {
        List<Produto> dados = new ArrayList<>();
        try {
            if (str == null) {
                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbProduto;");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbProduto limit ?;");
                    pstmt.setInt(1, limit);
                }
            } else {
                if (limit == 0) {
                    pstmt = con.prepareStatement("SELECT * FROM tbProduto where nome like ?;");
                    pstmt.setString(1,"%"+str+"%");
                } else {
                    pstmt = con.prepareStatement("SELECT * FROM tbProduto where nome like ? limit ?;");
                    pstmt.setString(1,"%"+str+"%");
                    pstmt.setInt(2, limit);
                }
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setId(rs.getInt("id"));
                dados.add(p);
            }
            pstmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dados.isEmpty()) {
            return null;
        }
        return (ArrayList<Produto>) dados;

    }

    @Override
    public int excluir(Produto obj) {
        try {
            pstmt = con.prepareStatement("DELETE FROM tbProduto WHERE id=?");
            pstmt.setInt(1, obj.getId());
            pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

            return 1;
        }
        return 0;
    }

}
