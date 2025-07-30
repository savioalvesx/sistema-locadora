package br.com.locadora.service;

import br.com.locadora.model.entity.Veiculo;
import java.util.List;

public interface VeiculoService {
    Veiculo cadastrarVeiculo(String placa, String marca, String modelo, String tipo);
    List<Veiculo> listarVeiculosDisponiveis();
}