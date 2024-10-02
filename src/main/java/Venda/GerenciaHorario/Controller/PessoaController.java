package Venda.GerenciaHorario.Controller;

import Venda.GerenciaHorario.Model.Pessoa;
import Venda.GerenciaHorario.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable(name = "id") Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);

        // Se a pessoa existir, retorna 200 OK com o objeto; senão, retorna 404 Not Found
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Pessoa> findByCpf(@PathVariable(name = "cpf") String cpf) {
        Optional<Pessoa> pessoa = pessoaService.findByCpf(cpf);

        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /*
    Recebe os dados para criar o cliente, envia para o service e ao receber
    retorna um http com o status referente ao que foi retornado.
    */
    @PostMapping("/criarpessoas")
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        Optional<Pessoa> createdPessoa = pessoaService.create(pessoa);

        return createdPessoa.map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }


    @PutMapping("/editarpessoa/{cpf}")
    public ResponseEntity<Pessoa> update(@PathVariable(name = "cpf") String cpf,
                                         @RequestBody Pessoa pessoa) {
        Optional<Pessoa> updatedPessoa = pessoaService.update(cpf, pessoa);

        return updatedPessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
