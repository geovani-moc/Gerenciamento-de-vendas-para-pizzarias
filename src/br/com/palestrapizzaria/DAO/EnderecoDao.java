/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import br.com.palestrapizzaria.entidade.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alvaro
 */
public class EnderecoDao extends Dao<Endereco> {

    Connection con = ConectaBanco.getConexao();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int salvar(Endereco obj) {
        try {
            pstmt = con.prepareStatement("INSERT INTO tbEndereco(rua,bairro,numero,complemento) VALUES (?,?,?,?);");
            pstmt.setString(1, obj.getRua());
            pstmt.setString(2, obj.getBairro());
            pstmt.setInt(3, obj.getNumero());
            pstmt.setString(4, obj.getComplemento());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public Endereco buscar(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Endereco buscarEnd(Endereco obj) {
        Endereco end = null;
        try {
            pstmt = con.prepareStatement("SELECT * FROM tbEndereco where rua = ? AND bairro = ? AND numero = ?;");
            pstmt.setString(1, obj.getRua());
            pstmt.setString(2, obj.getBairro());
            pstmt.setInt(3, obj.getNumero());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                end.setRua(rs.getString("rua"));
                end.setBairro(rs.getString("bairro"));
                end.setNumero(rs.getInt("numero"));
                end.setId(rs.getInt("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return end;

    }

    @Override
    public int excluir(Endereco obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
