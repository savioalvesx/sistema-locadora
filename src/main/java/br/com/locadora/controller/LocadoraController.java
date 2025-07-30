package br.com.locadora.controller;

import br.com.locadora.model.entity.Aluguel;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.service.AluguelService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.ClienteServiceImpl;
import br.com.locadora.service.VeiculoService;

import java.util.List;

public class LocadoraController {
    private final AluguelService aluguelService;
    private final VeiculoService veiculoService;
    private final ClienteService clienteService;

    public LocadoraController(AluguelService aluguelService, VeiculoService veiculoService, ClienteService clienteService) {
        this.aluguelService = aluguelService;
        this.veiculoService = veiculoService;
        this.clienteService = clienteService;
    }

    public String alugarVeiculo(String placa, String cpf) {
        try {
            Aluguel aluguel = aluguelService.alugarVeiculo(placa, cpf);
            return "SUCESSO: Veículo " + aluguel.getVeiculo().getModelo() + " alugado para " + aluguel.getCliente().getNome() + "!";
        } catch (Exception e) {
            return "ERRO: " + e.getMessage();
        }
    }
    public String cadastrarVeiculo(String placa, String marca, String modelo, String tipo) {
        try {
            Veiculo veiculo = veiculoService.cadastrarVeiculo(placa, marca, modelo, tipo);
            return "SUCESSO: Veículo '" + veiculo.getModelo() + "' cadastrado com a placa " + veiculo.getPlaca();
        } catch (Exception e) {
            return "ERRO: " + e.getMessage();
        }
    }
    public String cadastrarCliente(String cpf, String nome) {
        try {
            Cliente cliente = clienteService.cadastrarCliente(cpf, nome);
            return "SUCESSO: Cliente '" + cliente.getNome() + "' cadastrado com o CPF " + cliente.getCpf();
        } catch (Exception e) {
            return "ERRO: " + e.getMessage();
        }
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoService.listarVeiculosDisponiveis();
    }

    public String devolverVeiculo(String placa) {
        try {
            var valorAPagar = aluguelService.devolverVeiculo(placa);
            return String.format("SUCESSO: Veículo de placa %s devolvido. Valor a pagar: R$ %.2f", placa, valorAPagar);
        } catch (Exception e) {
            return "ERRO: " + e.getMessage();
        }
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    public List<Aluguel> listarAlugueisAtivos() {
        return aluguelService.listarAlugueisAtivos();
    }
}