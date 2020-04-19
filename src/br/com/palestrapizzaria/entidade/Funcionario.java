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
public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario() {
    }

    public Funcionario(String cargo, String nome, Long telefone, Long cpf, String rua, String bairro, Integer numero, String complemento) {
        super(nome, telefone, cpf, rua, bairro, numero, complemento);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
