package br.com.locadora.model.entity;

import java.util.Objects;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    @Override
    public String toString() {
        return "Cliente: " + nome + "\nCPF: " + cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
