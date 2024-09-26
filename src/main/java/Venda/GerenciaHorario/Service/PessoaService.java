package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.Model.Pessoa;
import Venda.GerenciaHorario.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService implements PessoaServiceImp{

    @Autowired
    private PessoaRepository repository;

    public Optional<Pessoa> findById(Long id) {

        return repository.findById(id);
    }

    public Optional<Pessoa> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Optional<Pessoa> create(Pessoa pessoa) {
        // Lógica para validar a pessoa
        if (repository.findByCpf(pessoa.getCpf()).isPresent()) {
            return Optional.empty(); // Se já existe, retorna vazio
        }
        Pessoa savedPessoa = repository.save(pessoa);
        return Optional.of(savedPessoa); // Retorna a pessoa salva
    }


}
