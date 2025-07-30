package br.com.locadora.model.repository;

import br.com.locadora.model.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente salvar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }
}
