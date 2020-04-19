/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.DAO;

import java.util.ArrayList;

/**
 *
 * @author alvaro
 * @param <TIPO>
 */
public abstract class Dao<TIPO> {
    public abstract int salvar(TIPO obj);
    public abstract TIPO buscar(String str);
    public abstract int excluir(TIPO obj);
}
