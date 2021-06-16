package br.com.una.Trabalho.Controllers;


import br.com.una.Trabalho.DTO.ContaCorrenteReply;
import br.com.una.Trabalho.DTO.ContaCorrenteRequest;
import br.com.una.Trabalho.Models.ContaCorrente;
import br.com.una.Trabalho.Repository.ContaCorrenteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    private ContaCorrenteRepository contaCorrenteRepository;

    public ContaController(ContaCorrenteRepository contaCorrenteRepository) {
        this.contaCorrenteRepository = contaCorrenteRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ContaCorrenteReply> save(@RequestBody ContaCorrenteRequest requestDTO) {
        ContaCorrente contaCorrente = requestDTO.converter();

        return ResponseEntity.ok().body(new ContaCorrenteReply(contaCorrenteRepository.save(contaCorrente)));
    }
}
