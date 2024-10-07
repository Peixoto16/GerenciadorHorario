package Venda.GerenciaHorario.Controller;

import Venda.GerenciaHorario.DTO.PessoaDTO;
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
    public ResponseEntity<PessoaDTO> findById(@PathVariable(name = "id") Long id) {
        Optional<PessoaDTO> pessoa = Optional.ofNullable(pessoaService.findById(id));
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<PessoaDTO> findByCpf(@PathVariable(name = "cpf") String cpf) {
        Optional<PessoaDTO> pessoa = Optional.ofNullable(pessoaService.findByCpf(cpf));
        return pessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/criar")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        Optional<PessoaDTO> createdPessoa = Optional.ofNullable(pessoaService.create(pessoaDTO));
        return createdPessoa.map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @PutMapping("/editar/{cpf}")
    public ResponseEntity<PessoaDTO> update(@PathVariable(name = "cpf") String cpf,
                                            @RequestBody PessoaDTO pessoaDTO) {
        Optional<PessoaDTO> updatedPessoa = Optional.ofNullable(pessoaService.update(cpf, pessoaDTO));
        return updatedPessoa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Object> delete(@PathVariable(name = "cpf") String cpf) {
        Optional<PessoaDTO> deletePessoa = Optional.ofNullable(pessoaService.delete(cpf));
        return deletePessoa.map(p -> ResponseEntity.status(HttpStatus.NO_CONTENT).build()) // 204 No Content
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Pessoa não encontrada")); // 404 Not Found
    }
}
