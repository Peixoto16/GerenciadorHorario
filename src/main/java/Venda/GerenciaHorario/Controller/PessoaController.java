package Venda.GerenciaHorario.Controller;

import Venda.GerenciaHorario.DTO.PessoaDTO;
import Venda.GerenciaHorario.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<PessoaDTO> findByCpf(@PathVariable String cpf) {
        PessoaDTO pessoa = pessoaService.findByCpf(cpf);
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping("/criar")
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO createdPessoa = pessoaService.create(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPessoa);
    }

    @PutMapping("/editar/{cpf}")
    public ResponseEntity<PessoaDTO> update(@PathVariable String cpf, @RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO updatedPessoa = pessoaService.update(cpf, pessoaDTO);
        return ResponseEntity.ok(updatedPessoa);
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        pessoaService.delete(cpf);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
