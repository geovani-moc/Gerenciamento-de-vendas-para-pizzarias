/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import br.com.palestrapizzaria.entidade.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Geovani Pereira dos Santos
 */
public class PedidoDao extends Dao<Pedido>{
    Connection con = ConectaBanco.getConexao();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public int salvar(Pedido obj) {
        try {
            pstmt = con.prepareStatement("INSERT INTO tbPedido(atendimento,idFuncionario,idCliente,idEndereco) VALUES (?,?,?,?);");
            pstmt.setString(1, obj.getAtendimento());
            pstmt.setInt(2, obj.getFuncionario().getId());
            pstmt.setInt(3, obj.getCliente().getId());
            pstmt.setInt(4, obj.getEntrega().getId());
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public Pedido buscar(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int excluir(Pedido obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
