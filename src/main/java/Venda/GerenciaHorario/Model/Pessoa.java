package Venda.GerenciaHorario.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="pessoaid")
    private Long ID;
    @Column(name ="nome", nullable = false)
    private String nome;
    @Column(name ="cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name ="cel", nullable = false)
    private String cel;
    @Column(name ="descricao", nullable = false, length = 255)
    private String descricao;

    public Pessoa() {

    }

    public Long getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCel() {
        return cel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
