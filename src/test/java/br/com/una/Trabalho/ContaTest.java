package br.com.una.Trabalho;

import br.com.una.Trabalho.Models.ContaCorrente;
import org.junit.jupiter.api.Test;


public class ContaTest {

    @Test
    public void testa_criacao_conta(){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setNumero(123434);
        contaCorrente.setCliente("Carol");
        contaCorrente.setSaldo(100.00);
    }


    @Test
    public void deposito(){
        ContaCorrente contaCorrente = new ContaCorrente();
        int saldo = (int) 100.00;
        int deposito = 20;
        int result = (saldo + deposito);
        assertEquals( result);
    }

    private void assertEquals(int result) {
    }

    @Test
    public void testSubtracao(){
        ContaCorrente contaCorrente = new ContaCorrente();
        int saldo = (int) 100.00;
        int saque = 20;
        if (saldo > saque){
            int result = (saldo - saque);
            assertEquals( result);
        }else
            System.out.println("Você não possui saldo");

    }
    }

