package br.com.locadora.service;

import br.com.locadora.model.entity.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente cadastrarCliente(String cpf, String nome);
    List<Cliente> listarClientes();
}
