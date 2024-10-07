package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.Model.Pessoa;

import java.util.Optional;

public interface PessoaServiceImp {

    Pessoa findById(Long id);
    Pessoa create(Pessoa pessoa);
    Pessoa update(String cpf, Pessoa pessoa);
    Pessoa delete(String cpf);

}

