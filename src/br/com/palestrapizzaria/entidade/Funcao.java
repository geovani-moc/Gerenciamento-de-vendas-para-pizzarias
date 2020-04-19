package br.com.palestrapizzaria.entidade;
/**
 *
 * @author alvaro
 */
public class Funcao {
    private final String[] cargos = {"Pizzaiolo", "Entregador", "Garçom", "Atendente", "Gerente", "Serviços Gerais", "Outros"};
    private Integer idCargo;
    
    public String getCargo() {
        return cargos[idCargo];
    }

    public void setCargo(Integer id) {
        idCargo = id;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    
}
