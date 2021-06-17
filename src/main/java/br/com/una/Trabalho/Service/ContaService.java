package br.com.una.Trabalho.Service;

import br.com.una.Trabalho.Repository.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    public void deposita( double quantidade, Long id) {
        contaCorrenteRepository.setFixedSaldoFor(quantidade, id);
    }

    public void sacar( double quantidade, Long id) {
        contaCorrenteRepository.setFixedSaldo(quantidade, id);
    }

}
