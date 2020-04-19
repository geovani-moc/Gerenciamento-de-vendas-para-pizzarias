/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class Pedido {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String atendimento;
    private List<Item> itens = new ArrayList<>();
    private Cliente cliente;
    private Funcionario funcionario;
    private Date data;
    private Endereco entrega;
    
    public void finalizarPedido()
    {
        //
    }
    
    public void adicionarItem()
    {
        
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Endereco getEntrega() {
        return entrega;
    }

    public void setEntrega(Endereco entrega) {
        this.entrega = entrega;
    }
    
    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(Item item) {
        this.itens.add(item);
    }
    
    public void setListItem(ArrayList<Item> list)
    {
        this.itens= list;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
