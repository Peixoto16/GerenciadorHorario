package Venda.GerenciaHorario.Repository;

import Venda.GerenciaHorario.Model.Funcionario;
import Venda.GerenciaHorario.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);
}
