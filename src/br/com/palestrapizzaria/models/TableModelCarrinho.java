/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.com.palestrapizzaria.entidade.Item;

/**
 *
 * @author alvaro
 */
public class TableModelCarrinho extends AbstractTableModel {

    private ArrayList<Item> dados = new ArrayList<>();
    private final String[] colunas = {"Nome", "Valor Un", "Quantidade", "SubTotal"};

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dados.get(rowIndex).getItem();
            case 1:
                return dados.get(rowIndex).getValor();
            case 2:
                return dados.get(rowIndex).getQuantidade();
            case 3:
                return dados.get(rowIndex).getValor() * dados.get(rowIndex).getQuantidade();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void setList(ArrayList<Item> lista) {
        if (lista != null) {
            this.dados = lista;
        } else {
            this.dados = new ArrayList<Item>();
        }
        this.fireTableDataChanged();
    }
    
    public ArrayList<Item> getList()
    {
        return this.dados;
    }

    public Item getItem(int index) {
        if (!dados.isEmpty()) {
            return dados.get(index);
        }
        return null;
    }

    public void addRow(Item p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public void removeRow(int linha) {
        dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

}
