package br.com.locadora.model.repository;

import br.com.locadora.model.entity.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeiculoRepositoryImpl implements VeiculoRepository {
    private final List<Veiculo> veiculos = new ArrayList<>();

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        veiculos.add(veiculo);
        return veiculo;
    }

    @Override
    public Optional<Veiculo> buscarPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(veiculos);
    }

    @Override
    public List<Veiculo> listarDisponiveis() {
        return veiculos.stream()
                .filter(Veiculo::isDisponivel)
                .collect(Collectors.toList());
    }
}