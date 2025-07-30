package br.com.locadora;

import br.com.locadora.controller.LocadoraController;
import br.com.locadora.model.repository.AluguelRepository;
import br.com.locadora.model.repository.ClienteRepository;
import br.com.locadora.model.repository.VeiculoRepository;
import br.com.locadora.model.repository.AluguelRepositoryImpl;
import br.com.locadora.model.repository.ClienteRepositoryImpl;
import br.com.locadora.model.repository.VeiculoRepositoryImpl;
import br.com.locadora.service.AluguelService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.VeiculoService;
import br.com.locadora.service.AluguelServiceImpl;
import br.com.locadora.service.ClienteServiceImpl;
import br.com.locadora.service.VeiculoServiceImpl;
import br.com.locadora.view.LocadoraView;

public class Main {
    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepositoryImpl();
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        AluguelRepository aluguelRepository = new AluguelRepositoryImpl();

        VeiculoService veiculoService = new VeiculoServiceImpl(veiculoRepository);
        ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
        AluguelService aluguelService = new AluguelServiceImpl(veiculoRepository, clienteRepository, aluguelRepository);

        LocadoraController controller = new LocadoraController(aluguelService, veiculoService, clienteService);

        LocadoraView view = new LocadoraView(controller);
        view.exibirMenu();
    }
}