/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.palestrapizzaria.models;

import br.com.palestrapizzaria.entidade.Funcionario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alvaro
 */
public class TableModelFuncionario extends AbstractTableModel{
     private ArrayList<Funcionario> dados = new ArrayList<>();
    private final String[] colunas = {"Nome", "Bairro", "Rua/Av", "Número", "Telefone"};

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
                return dados.get(rowIndex).getNome();
            case 1:
                return dados.get(rowIndex).getBairro();
            case 2:
                return dados.get(rowIndex).getRua();
            case 3:
                return dados.get(rowIndex).getNumero();
            case 4:
                return dados.get(rowIndex).getTelefone();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void setList(ArrayList<Funcionario> lista) {
        if (lista != null) {
            this.dados = lista;
        } else {
            this.dados = new ArrayList<>();
        }
        this.fireTableDataChanged();
    }

    public Funcionario getFuncionario(int index) {
        if (!dados.isEmpty()) {
            return dados.get(index);
        }
        return null;
    }
    
}
