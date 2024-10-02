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

    @Override // Busca o cliente pelo id
    public Optional<Pessoa> findById(Long id) {

        return repository.findById(id);
    }

    // Busca o cliente no banco pelo cpf
    public Optional<Pessoa> findByCpf(String cpf) {

        return repository.findByCpf(cpf);
    }

    @Override // Cria e verifica sem ja existe o usuario pelo cpf
    public Optional<Pessoa> create(Pessoa pessoa) {

        if (repository.findByCpf(pessoa.getCpf()).isPresent()) {
            return Optional.empty();
        }
        Pessoa savedPessoa = repository.save(pessoa);
        return Optional.of(savedPessoa);
    }

    @Override
    public Optional<Pessoa> update(String cpf, Pessoa pessoa) {
        Optional<Pessoa> existingPessoa = repository.findByCpf(cpf);

        if (existingPessoa.isPresent()) {
            Pessoa updatedPessoa = existingPessoa.get();
            updatedPessoa.setNome(pessoa.getNome()); // Supondo que "nome" seja um dos atributos
            updatedPessoa.setCel(pessoa.getCel());
            updatedPessoa.setDescricao(pessoa.getDescricao()); // Supondo que "idade" seja outro atributo

            repository.save(updatedPessoa);
            return Optional.of(updatedPessoa);
        }

        return Optional.empty(); // Retorna vazio se não encontrar a pessoa
    }


}
