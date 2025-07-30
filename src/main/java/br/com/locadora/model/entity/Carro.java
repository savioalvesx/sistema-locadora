package br.com.locadora.model.entity;

import java.math.BigDecimal;

public class Carro extends Veiculo {
    public Carro(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    @Override
    public BigDecimal getValorDiaria() {
        return new BigDecimal("150.00");
    }

    @Override
    public String toString() {
        return "Carro: " + super.toString() + "\nValor Diária: " + getValorDiaria();
    }
}