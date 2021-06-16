package br.com.una.Trabalho.DTO;

import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Models.ContaCorrente;


public class ContaCorrenteRequest {

    private int numero;
    private Double saldo;
    private Cliente cliente;

    public ContaCorrenteRequest() {
    }

    public ContaCorrenteRequest(int numero, Double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ContaCorrente converter() { return new ContaCorrente(this.numero, this.saldo, this.cliente);
    }



}
