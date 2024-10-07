package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.DTO.PessoaDTO;
import Venda.GerenciaHorario.Model.Pessoa;

import java.util.Optional;

public interface PessoaServiceImp {

    PessoaDTO findById(Long id);
    PessoaDTO create(PessoaDTO pessoaDTO);
    PessoaDTO update(String cpf, PessoaDTO pessoaDTO);
    PessoaDTO delete(String cpf);

}

