package br.com.una.Trabalho.DTO;

import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Models.ContaCorrente;

public class ContaCorrenteReply {

    private int numero;
    private Double saldo;
    private Cliente cliente;

    public ContaCorrenteReply(ContaCorrente contaCorrente) {
        this.numero = contaCorrente.getNumero();
        this.saldo = contaCorrente.getSaldo();
        this.cliente = contaCorrente.getCliente();
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
}
