/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.entidade;

/**
 *
 * @author Geovani Pereira dos Santos
 */
public class Atendimento {

    private final String[] atendimento = {"Balcão", "Mesa", "entrega"};
    private Integer idAtendimento;
    
    public void setAtendimento(Integer index) {
        this.idAtendimento = index; 
    }
    
    public String getAtendimento()
    {
        return atendimento[idAtendimento];
    }
    
    public Integer getIdAtendimento()
    {
        return idAtendimento;
    }
}
