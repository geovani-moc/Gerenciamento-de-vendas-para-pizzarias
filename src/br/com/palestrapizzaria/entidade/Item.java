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
public class Item {
    private String item;
    private Integer quantidade;
    private Double valor;
    private Integer id;

    public Item() {
    }

    public Item(String item, Integer quantidade, Double valor) {
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Double subTotal()
    {
        return valor*quantidade;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Double getTotal()
    {
        return this.valor*this.quantidade;
    }
}
