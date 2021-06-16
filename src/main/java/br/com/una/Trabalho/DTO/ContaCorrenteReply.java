package br.com.una.Trabalho.DTO;

import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Models.ContaCorrente;

public class ContaCorrenteReply {

    private Long id;
    private int numero;
    private Double saldo;
    private Long cliente;

    public ContaCorrenteReply(ContaCorrente save) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Long getCliente() {
        return cliente;
    }
}
