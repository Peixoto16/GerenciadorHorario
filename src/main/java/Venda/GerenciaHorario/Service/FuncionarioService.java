package Venda.GerenciaHorario.Service;

import Venda.GerenciaHorario.DTO.FuncionarioDTO;
import Venda.GerenciaHorario.Model.Funcionario;
import Venda.GerenciaHorario.Repository.FuncionarioRepository;
import Venda.GerenciaHorario.Service.Exception.JaExistenteException;
import Venda.GerenciaHorario.Service.Exception.NaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService implements FuncionarioServiceImp {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDTO findByCpf(String cpf) {
        Funcionario funcionario = repository.findByCpf(cpf)
                .orElseThrow(() -> new NaoEncontradaException("Funcionário não encontrado"));
        return convertToDTO(funcionario);
    }

    @Override
    public FuncionarioDTO create(FuncionarioDTO funcionarioDTO) {
        if (repository.findByCpf(funcionarioDTO.cpf()).isPresent()) {
            throw new JaExistenteException("Funcionário já existe");
        }
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.nome());
        funcionario.setCpf(funcionarioDTO.cpf());
        funcionario.setCel(funcionarioDTO.cel());
        funcionario.setEspecialidade(funcionarioDTO.especialidade());
        return convertToDTO(repository.save(funcionario));
    }

    @Override
    public FuncionarioDTO update(String cpf, FuncionarioDTO funcionarioDTO) {
        Funcionario existingFuncionario = repository.findByCpf(cpf)
                .orElseThrow(() -> new NaoEncontradaException("Funcionário não encontrado"));

        existingFuncionario.setNome(funcionarioDTO.nome());
        existingFuncionario.setCel(funcionarioDTO.cel());
        existingFuncionario.setEspecialidade(funcionarioDTO.especialidade());

        return convertToDTO(repository.save(existingFuncionario));
    }

    public FuncionarioDTO delete(String cpf) {
        Funcionario deleteFuncionario = repository.findByCpf(cpf)
                .orElseThrow(() -> new NaoEncontradaException("Funcionário não encontrado"));
        repository.delete(deleteFuncionario);
        return convertToDTO(deleteFuncionario);
    }

    private FuncionarioDTO convertToDTO(Funcionario funcionario) {
        return new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getCel(), funcionario.getEspecialidade());
    }
}
