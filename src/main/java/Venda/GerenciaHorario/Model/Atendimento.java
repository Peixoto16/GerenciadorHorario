package Venda.GerenciaHorario.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoaid", nullable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "funcid", nullable = false)
    private Funcionario funcionario;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name ="descricao", nullable = true, length = 255)
    private String descricao;

    // Getters e Setters

}
