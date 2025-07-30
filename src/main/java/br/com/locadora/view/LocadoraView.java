package br.com.locadora.view;

import br.com.locadora.controller.LocadoraController;
import br.com.locadora.model.entity.Aluguel;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Veiculo;

import java.util.List;
import java.util.Scanner;

public class LocadoraView {
    private final LocadoraController controller;
    private final Scanner scanner;

    public LocadoraView(LocadoraController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- LOCADORA DE VEÍCULOS ---");
            System.out.println("1. Alugar um veículo");
            System.out.println("2. Devolver um veículo");
            System.out.println("3. Cadastrar novo veículo");
            System.out.println("4. Cadastrar novo cliente");
            System.out.println("5. Listar veículos disponíveis");
            System.out.println("6. Listar veículos alugados");
            System.out.println("7. Listar clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                rotearOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Opção inválida. Por favor, insira um número.");
            }
        }
        System.out.println("\nObrigado por usar nosso sistema!");
    }

    private void rotearOpcao(int opcao) {
        switch (opcao) {
            case 1: alugarVeiculo(); break;
            case 2: devolverVeiculo(); break;
            case 3: cadastrarVeiculo(); break;
            case 4: cadastrarCliente(); break;
            case 5: listarVeiculosDisponiveis(); break;
            case 6: listarVeiculosAlugados(); break;
            case 7: listarClientes(); break;
            case 0: break;
            default: System.out.println("ERRO: Opção inválida!");
        }
    }

    private void alugarVeiculo() {
        System.out.println("\n--- Aluguel de Veículo ---");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        String resultado = controller.alugarVeiculo(placa, cpf);
        System.out.println(resultado);
    }

    private void devolverVeiculo() {
        System.out.println("\n--- Devolução de Veículo ---");
        System.out.print("Digite a placa do veículo a ser devolvido: ");
        String placa = scanner.nextLine();
        String resultado = controller.devolverVeiculo(placa);
        System.out.println(resultado);
    }

    private void cadastrarVeiculo() {
        System.out.println("\n--- Cadastro de Veículo ---");
        System.out.print("Digite a placa: ");
        String placa = scanner.nextLine();
        System.out.print("Digite a marca: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o tipo (carro/moto): ");
        String tipo = scanner.nextLine();

        String resultado = controller.cadastrarVeiculo(placa, marca, modelo, tipo);
        System.out.println(resultado);
    }

    private void cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o nome completo do cliente: ");
        String nome = scanner.nextLine();

        String resultado = controller.cadastrarCliente(cpf, nome);
        System.out.println(resultado);
    }

    private void listarVeiculosDisponiveis() {
        System.out.println("\n--- Veículos Disponíveis ---");
        List<Veiculo> veiculos = controller.listarVeiculosDisponiveis();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo disponível no momento.");
        } else {
            veiculos.forEach(System.out::println);
        }
    }

    private void listarVeiculosAlugados() {
        System.out.println("\n--- Veículos Alugados ---");
        List<Aluguel> alugueis = controller.listarAlugueisAtivos();
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum veículo alugado no momento.");
        } else {
            alugueis.forEach(aluguel -> {
                System.out.println("Veículo: " + aluguel.getVeiculo().getModelo() +
                        " | Placa: " + aluguel.getVeiculo().getPlaca() +
                        " | Cliente: " + aluguel.getCliente().getNome() +
                        " | Data: " + aluguel.getDataAluguel().toLocalDate());
            });
        }
    }

    private void listarClientes() {
        System.out.println("\n--- Clientes Cadastrados ---");
        List<Cliente> clientes = controller.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(System.out::println);
        }
    }
}