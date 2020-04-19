/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.entidade;

import java.util.List;

/**
 *
 * @author alvaro
 */
public class Relatorio {
    private List<Item> vendas;
    private Double gastos;
    private Double receitas;

    public Double calculaReceita()
    {
        return 3.0;///mexer aqui
    }
    
    public List<Item> getVendas() {
        return vendas;
    }

    public void setVendas(List<Item> vendas) {
        this.vendas = vendas;
    }

    public Double getGastos() {
        return gastos;
    }

    public void setGastos(Double gastos) {
        this.gastos = gastos;
    }

    public Double getReceitas() {
        return receitas;
    }

    public void setReceitas(Double receitas) {
        this.receitas = receitas;
    }
}
