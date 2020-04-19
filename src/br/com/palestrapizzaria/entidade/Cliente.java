/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.entidade;

/**
 *
 * @author alvaro
 */
public class Cliente extends Pessoa{
    
    private Boolean ativo;

    public Cliente(Boolean cadastro, String nome, Long telefone, Long cpf, String rua, String bairro, Integer numero, String complemento) {
        super(nome, telefone, cpf, rua, bairro, numero, complemento);
        this.ativo = cadastro;
    }

    public Cliente() {
    }
        
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean cadastro) {
        this.ativo = cadastro;
    }
    
}

