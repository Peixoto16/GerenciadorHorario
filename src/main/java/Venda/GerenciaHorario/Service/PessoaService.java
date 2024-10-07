package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.Model.Pessoa;
import Venda.GerenciaHorario.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements PessoaServiceImp {

    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public Pessoa findByCpf(String cpf) {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
        if (repository.findByCpf(pessoa.getCpf()).isPresent()) {
            throw new RuntimeException("Pessoa já existe");
        }
        return repository.save(pessoa);
    }

    @Override
    public Pessoa update(String cpf, Pessoa pessoa) {
        Pessoa existingPessoa = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        existingPessoa.setNome(pessoa.getNome());
        existingPessoa.setCel(pessoa.getCel());
        existingPessoa.setDescricao(pessoa.getDescricao());

        return repository.save(existingPessoa);
    }

    public Pessoa delete(String cpf) {
        Pessoa deletePessoa = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        repository.delete(deletePessoa);
        return deletePessoa;
    }
}
