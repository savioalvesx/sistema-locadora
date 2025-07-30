package br.com.locadora.model.repository;

import br.com.locadora.model.entity.Aluguel;
import java.util.List;
import java.util.Optional;

public interface AluguelRepository {
    Aluguel salvar(Aluguel aluguel);
    Optional<Aluguel> buscarPorPlacaVeiculo(String placa);
    void remover(Aluguel aluguel);
    List<Aluguel> listarTodos();
}