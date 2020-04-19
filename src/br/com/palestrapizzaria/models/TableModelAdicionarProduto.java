/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.models;

import br.com.palestrapizzaria.entidade.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alvaro
 */
public class TableModelAdicionarProduto extends AbstractTableModel{
    private ArrayList<Produto> dados = new ArrayList<>();
    private final String[] colunas = {"Nome", "Valor"};
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return dados.get(rowIndex).getNome();
            case 1:
                return dados.get(rowIndex).getValor();
        }
        return null;
    }
    
    public void setList(ArrayList<Produto> lista) {
        if (lista != null) {
            this.dados = lista;
        } else {
            this.dados = new ArrayList<>();
        }
        this.fireTableDataChanged();
    }
    
}
