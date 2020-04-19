/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class ConectaBanco {
    private static Connection conexao;
    private static String url;
    private static String usuario = "pizza";
    private static String senha = "adminpizza";
    private static String banco = "Palestra";
    
    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ConectaBanco.usuario = usuario;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConectaBanco.url = url;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        ConectaBanco.senha = senha;
    }

    public static String getBanco() {
        return banco;
    }

    public static void setBanco(String banco) {
        ConectaBanco.banco = banco;
    }
    
    public static Connection getConexao(){
        try{
            if(conexao == null){
                setUrl("jdbc:mysql://127.0.0.1:3306/"+getBanco()+"?useSSL=true");
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(getUrl(),getUsuario(),getSenha());
            }
        }catch(Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
        }
        return conexao;
    }
}