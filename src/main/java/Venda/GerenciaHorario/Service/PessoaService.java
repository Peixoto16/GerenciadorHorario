package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.Model.Pessoa;
import Venda.GerenciaHorario.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Venda.GerenciaHorario.DTO.PessoaDTO;

@Service
public class PessoaService implements PessoaServiceImp {

    @Autowired
    private PessoaRepository repository;

    @Override
    public PessoaDTO findById(Long id) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return convertToDTO(pessoa);
    }

    public PessoaDTO findByCpf(String cpf) {
        Pessoa pessoa = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return convertToDTO(pessoa);
    }

    @Override
    public PessoaDTO create(PessoaDTO pessoaDTO) {
        if (repository.findByCpf(pessoaDTO.cpf()).isPresent()) {
            throw new RuntimeException("Pessoa já existe");
        }
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.nome());
        pessoa.setCpf(pessoaDTO.cpf());
        pessoa.setCel(pessoaDTO.cel());
        pessoa.setDescricao(pessoaDTO.descricao());
        return convertToDTO(repository.save(pessoa));
    }

    @Override
    public PessoaDTO update(String cpf, PessoaDTO pessoaDTO) {
        Pessoa existingPessoa = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        existingPessoa.setNome(pessoaDTO.nome());
        existingPessoa.setCel(pessoaDTO.cel());
        existingPessoa.setDescricao(pessoaDTO.descricao());

        return convertToDTO(repository.save(existingPessoa));
    }

    public PessoaDTO delete(String cpf) {
        Pessoa deletePessoa = repository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        repository.delete(deletePessoa);
        return convertToDTO(deletePessoa);
    }

    private PessoaDTO convertToDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getID(), pessoa.getNome(), pessoa.getCpf(), pessoa.getCel(), pessoa.getDescricao());
    }
}