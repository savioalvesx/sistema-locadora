package br.com.locadora.service;

import br.com.locadora.model.entity.Carro;
import br.com.locadora.model.entity.Moto;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.model.repository.VeiculoRepository;
import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    public Veiculo cadastrarVeiculo(String placa, String marca, String modelo, String tipo) {
        if (veiculoRepository.buscarPorPlaca(placa).isPresent()) {
            throw new IllegalArgumentException("Já existe um veículo cadastrado com a placa " + placa);
        }

        Veiculo novoVeiculo;
        if ("carro".equalsIgnoreCase(tipo)) {
            novoVeiculo = new Carro(placa, marca, modelo);
        } else if ("moto".equalsIgnoreCase(tipo)) {
            novoVeiculo = new Moto(placa, marca, modelo);
        } else {
            throw new IllegalArgumentException("Tipo de veículo inválido. Use 'carro' ou 'moto'.");
        }
        return veiculoRepository.salvar(novoVeiculo);
    }

    @Override
    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoRepository.listarDisponiveis();
    }
}