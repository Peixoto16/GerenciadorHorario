package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.DTO.FuncionarioDTO;
import Venda.GerenciaHorario.DTO.PessoaDTO;

public interface FuncionarioServiceImp {

    FuncionarioDTO create(FuncionarioDTO funcionarioDTO);
    FuncionarioDTO update(String cpf, FuncionarioDTO funcionarioDTO);
    FuncionarioDTO delete(String cpf);
}
