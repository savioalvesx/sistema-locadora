package br.com.locadora.service;

import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.repository.ClienteRepository;
import br.com.locadora.util.ValidadorCPF;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository; // Usa a INTERFACE

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadastrarCliente(String cpf, String nome) {
        if (!ValidadorCPF.isCPFValido(cpf)) {
            throw new IllegalArgumentException("Formato de CPF inválido.");
        }
        if (clienteRepository.buscarPorCpf(cpf).isPresent()) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com o CPF." + cpf);
        }
        Cliente novoCliente = new Cliente(cpf, nome);
        return clienteRepository.salvar(novoCliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }
}