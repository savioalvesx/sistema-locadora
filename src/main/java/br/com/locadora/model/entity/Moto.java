package br.com.locadora.model.entity;

import java.math.BigDecimal;

public class Moto extends Veiculo {
    public Moto(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    @Override
    public BigDecimal getValorDiaria() {
        return new BigDecimal("75.00");
    }

    @Override
    public String toString() {
        return "Moto: " + super.toString() + "\nValor Diária: " + getValorDiaria();
    }
}
