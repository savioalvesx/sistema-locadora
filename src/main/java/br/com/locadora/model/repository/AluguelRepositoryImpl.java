package br.com.locadora.model.repository;

import br.com.locadora.model.entity.Aluguel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AluguelRepositoryImpl implements AluguelRepository {
    private final List<Aluguel> alugueisAtivos = new ArrayList<>();

    @Override
    public Aluguel salvar(Aluguel aluguel) {
        alugueisAtivos.add(aluguel);
        return aluguel;
    }

    @Override
    public Optional<Aluguel> buscarPorPlacaVeiculo(String placa) {
        return alugueisAtivos.stream()
                .filter(a -> a.getVeiculo().getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    @Override
    public void remover(Aluguel aluguel) {
        alugueisAtivos.remove(aluguel);
    }

    @Override
    public List<Aluguel> listarTodos() {
        return new ArrayList<>(alugueisAtivos);
    }
}
