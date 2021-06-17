package br.com.una.Trabalho;

import br.com.una.Trabalho.Models.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {

    @Test
    @DisplayName("Cadastra novo cliente")
    public void testa_criacao_cliente(){
        Cliente cliente = new Cliente();
            cliente.setNome("Carol");
            cliente.setEndereco("Rua Amarela");
            cliente.setCpf(1234L);
    }



}
