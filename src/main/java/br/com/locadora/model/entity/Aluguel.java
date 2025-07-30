package br.com.locadora.model.entity;

import java.time.LocalDateTime;

public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime dataAluguel;

    public Aluguel(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataAluguel = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    @Override
    public String toString() {
        return "\nCliente: " + cliente.getNome()
                + "\nVeiculo: " + veiculo.getModelo()
                + "\nData Aluguel: " + dataAluguel;
    }
}