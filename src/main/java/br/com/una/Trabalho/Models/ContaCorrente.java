package br.com.una.Trabalho.Models;


import javax.persistence.*;

@Entity
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private Double saldo;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @Deprecated
    public ContaCorrente( ) {
    }

    public ContaCorrente(Long id, int numero, Double saldo, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public ContaCorrente(int numero, Double saldo, Long cpf) {
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCliente(String cliente) {
    }
}
