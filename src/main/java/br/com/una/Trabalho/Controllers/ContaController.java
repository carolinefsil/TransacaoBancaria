package br.com.una.Trabalho.Controllers;


import br.com.una.Trabalho.DTO.ContaCorrenteReply;
import br.com.una.Trabalho.DTO.ContaCorrenteRequest;
import br.com.una.Trabalho.Models.ContaCorrente;
import br.com.una.Trabalho.Repository.ClienteRepository;
import br.com.una.Trabalho.Repository.ContaCorrenteRepository;
import br.com.una.Trabalho.Service.ContaService;
import br.com.una.Trabalho.Util.ExceptionCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/conta")
public class ContaController {


    @Autowired
    private ContaService contaService;
    private ContaCorrenteRepository contaCorrenteRepository;
    private ClienteRepository clienteRepository;


    public ContaController(ContaService contaService, ContaCorrenteRepository contaCorrenteRepository, ClienteRepository clienteRepository) {
        this.contaService = contaService;
        this.contaCorrenteRepository = contaCorrenteRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ContaCorrenteReply> save(@RequestBody ContaCorrenteRequest requestDTO) {
        ContaCorrente contaCorrente = requestDTO.converter(requestDTO);

        return ResponseEntity.ok().body(new ContaCorrenteReply(contaCorrenteRepository.save(contaCorrente)));
    }

    @Transactional
    @GetMapping
    public ResponseEntity<List<ContaCorrenteReply>> listaContas() {

        List<ContaCorrente> contaCorrenteList = contaCorrenteRepository.findAll();

        return ResponseEntity.ok(
                contaCorrenteList.stream().map(ContaCorrenteReply::new).collect(Collectors.toList()));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<ContaCorrente> optional = contaCorrenteRepository.findById(id);
        if (optional.isPresent()) {
            contaCorrenteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Conta deletado com Sucesso!");
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/depositar/{quantidade}/{id}")
    public ResponseEntity<?> depositar(@PathVariable double quantidade, @PathVariable Long id) {

        this.contaService.deposita(quantidade, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/sacar/{quantidade}/{id}\"")
    public ResponseEntity<?> sacar(@PathVariable double quantidade, @PathVariable Long id) {
        if (quantidade <= 0) {
            throw new ExceptionCustom("valor incorreto");
        }
        this.contaService.sacar(quantidade, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



