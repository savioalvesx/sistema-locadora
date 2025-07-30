package br.com.locadora.model.repository;

import br.com.locadora.model.entity.Veiculo;
import java.util.List;
import java.util.Optional;

public interface VeiculoRepository {
    Veiculo salvar(Veiculo veiculo);
    Optional<Veiculo> buscarPorPlaca(String placa);
    List<Veiculo> listarTodos();
    List<Veiculo> listarDisponiveis();
}