package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.Model.Pessoa;

import java.util.Optional;

public interface PessoaServiceImp {

    Optional<Pessoa> findById(Long id);
    Optional<Pessoa> create(Pessoa pessoa);

}

