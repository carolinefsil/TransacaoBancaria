package br.com.una.Trabalho.DTO;


import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Models.ContaCorrente;
import br.com.una.Trabalho.Repository.ClienteRepository;

public class ContaCorrenteRequest {

    private int numero;
    private Double saldo;
    private Long cpf;

    @Deprecated
    public ContaCorrenteRequest() {
    }

    public ContaCorrenteRequest(int numero, Double saldo, Long cpf) {
        this.numero = numero;
        this.saldo = saldo;
        this.cpf = cpf;
    }



    public ContaCorrente converter(ContaCorrenteRequest requestDTO) {
        return new ContaCorrente(numero,saldo,cpf);
    }

}


