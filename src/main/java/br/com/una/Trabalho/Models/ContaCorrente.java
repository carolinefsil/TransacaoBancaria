package br.com.una.Trabalho.Models;


import javax.persistence.*;

@Entity
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private Double saldo;
    @ManyToOne (fetch = FetchType.EAGER)
    private Long cliente;

    @Deprecated
    public ContaCorrente() {
    }


    public ContaCorrente(int numero, Double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente.getCpf();
    }

    public Long getCliente() {
        return getCliente();
    }
}
