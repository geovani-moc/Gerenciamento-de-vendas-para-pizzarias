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
public abstract class Pessoa extends Endereco{
    private String nome;
    private Long telefone;
    private Long cpf;
    private Integer id;

    public Pessoa() {
    }

    public Pessoa(String nome, Long telefone, Long cpf, String rua, String bairro, Integer numero, String complemento) {
        super(rua, bairro, numero, complemento);
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
