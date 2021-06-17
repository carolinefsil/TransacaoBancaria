package br.com.una.Trabalho.DTO;

import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Repository.ClienteRepository;

public class ClienteRequest {

    private String nome;
    private Long cpf;
    private String endereco;


    public ClienteRequest(String nome, Long cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }


    public Cliente converter(ClienteRequest requestDTO){
        return new Cliente(this.nome, this.cpf, this.endereco);
    }

    public Cliente atualizar(Long cpf, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getOne(cpf);
        cliente.setNome(this.nome);
        cliente.setEndereco(this.endereco);
        return cliente;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }
}
