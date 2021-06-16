package br.com.una.Trabalho.Controllers;


import br.com.una.Trabalho.DTO.ClienteReply;
import br.com.una.Trabalho.DTO.ClienteRequest;
import br.com.una.Trabalho.Models.Cliente;
import br.com.una.Trabalho.Repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<ClienteReply> save(@RequestBody ClienteRequest requestDTO) {
        Cliente cliente = requestDTO.converter();

        return ResponseEntity.ok().body(new ClienteReply(clienteRepository.save(cliente)));
    }

    @Transactional
    @GetMapping
    public ResponseEntity<List<ClienteReply>> listaClientes() {

        List<Cliente> livroList = clienteRepository.findAll();

        return ResponseEntity.ok(
                livroList.stream().map(ClienteReply::new).collect(Collectors.toList()));
    }

    @Transactional
    @GetMapping("/{cpf}")
    public ResponseEntity<?> buscaPorCpf(@PathVariable Long cpf) {

        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);

        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ei esse CPF não está cadastrado!");
        }

        return ResponseEntity.ok(new ClienteReply(cliente.get()) {
        });
    }

    @Transactional
    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteReply> atualizar(@PathVariable Long cpf, @RequestBody @Valid ClienteRequest form) {
        Optional<Cliente> optional = clienteRepository.findByCpf(cpf);
        if (optional.isPresent()) {
            Cliente cliente = form.atualizar(cpf, clienteRepository);
            return ResponseEntity.ok(new ClienteReply(cliente));
        }

        return ResponseEntity.notFound().build();
    }




    @Transactional
    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf) {
        Optional<Cliente> optional = clienteRepository.findByCpf(cpf);
        if (optional.isPresent()) {
            clienteRepository.deleteByCpf(cpf);
            return ResponseEntity.status(HttpStatus.OK).body("CPF deletado com Sucesso!");
        }

        return ResponseEntity.notFound().build();
    }

}