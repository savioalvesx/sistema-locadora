package br.com.locadora.service;

import br.com.locadora.exception.EntidadeNaoEncontradaException;
import br.com.locadora.exception.VeiculoIndisponivelException;
import br.com.locadora.model.entity.Aluguel;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.model.repository.AluguelRepository;
import br.com.locadora.model.repository.ClienteRepository;
import br.com.locadora.model.repository.VeiculoRepository;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class AluguelServiceImpl implements AluguelService {
    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;
    private final AluguelRepository aluguelRepository;

    public AluguelServiceImpl(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository, AluguelRepository aluguelRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
        this.aluguelRepository = aluguelRepository;
    }

    @Override
    public Aluguel alugarVeiculo(String placa, String cpf) {
        Veiculo veiculo = veiculoRepository.buscarPorPlaca(placa)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veículo com placa " + placa + " não encontrado."));
        Cliente cliente = clienteRepository.buscarPorCpf(cpf)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente com CPF " + cpf + " não encontrado."));

        if (!veiculo.isDisponivel()) {
            throw new VeiculoIndisponivelException("O veículo " + veiculo.getModelo() + " não está disponível para aluguel.");
        }

        veiculo.setDisponivel(false);
        Aluguel novoAluguel = new Aluguel(cliente, veiculo);
        return aluguelRepository.salvar(novoAluguel);
    }

    @Override
    public BigDecimal devolverVeiculo(String placa) {
        Aluguel aluguel = aluguelRepository.buscarPorPlacaVeiculo(placa)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Não há aluguel ativo para a placa " + placa));

        Veiculo veiculo = aluguel.getVeiculo();
        veiculo.setDisponivel(true);
        aluguelRepository.remover(aluguel);

        long horas = Duration.between(aluguel.getDataAluguel(), LocalDateTime.now()).toHours();
        if (horas == 0) horas = 1;

        long dias = (horas / 24) + (horas % 24 > 0 ? 1 : 0);

        return veiculo.getValorDiaria().multiply(new BigDecimal(dias));
    }

    @Override
    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelRepository.listarTodos();
    }
}
