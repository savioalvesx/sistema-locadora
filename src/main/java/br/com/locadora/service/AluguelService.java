package br.com.locadora.service;

import br.com.locadora.model.entity.Aluguel;
import java.math.BigDecimal;
import java.util.List;

public interface AluguelService {
    Aluguel alugarVeiculo(String placa, String cpf);
    BigDecimal devolverVeiculo(String placa);
    List<Aluguel> listarAlugueisAtivos();
}