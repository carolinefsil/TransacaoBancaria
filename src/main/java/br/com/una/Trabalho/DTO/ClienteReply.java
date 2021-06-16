package br.com.una.Trabalho.DTO;

import br.com.una.Trabalho.Models.Cliente;

public class ClienteReply {

    private Long id;
    private String nome;

    public ClienteReply() {
    }

    public ClienteReply(Cliente entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
