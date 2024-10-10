package Venda.GerenciaHorario.Controller;

import Venda.GerenciaHorario.DTO.FuncionarioDTO;
import Venda.GerenciaHorario.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<FuncionarioDTO> findByCpf(@PathVariable String cpf) {
        FuncionarioDTO funcionario = funcionarioService.findByCpf(cpf);
        return ResponseEntity.ok(funcionario);
    }

    @PostMapping("/criar")
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO createdFuncionario = funcionarioService.create(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFuncionario);
    }

    @PutMapping("/editar/{cpf}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable String cpf, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO updatedFuncionario = funcionarioService.update(cpf, funcionarioDTO);
        return ResponseEntity.ok(updatedFuncionario);
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        funcionarioService.delete(cpf);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

