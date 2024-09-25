CREATE TABLE IF NOT EXISTS pessoa(
    PessoaId serial PRIMARY KEY,
    nome varchar(30) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    cel varchar(15),
    descricao TEXT
);

CREATE TABLE IF NOT EXISTS func(
    FuncId serial PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    cel VARCHAR(15),
    especialidade VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS Agendamento (
    AgendamentoID SERIAL PRIMARY KEY,
    PessoaID INT NOT NULL,
    FuncionarioID INT NOT NULL,
    Data DATE NOT NULL,
    Hora TIME NOT NULL,
    Descricao TEXT,
    FOREIGN KEY (PessoaID) REFERENCES Pessoa(PessoaID) ON DELETE CASCADE,
    FOREIGN KEY (FuncionarioID) REFERENCES Funcionario(FuncId) ON DELETE CASCADE,
    UNIQUE (Data, Hora)
);

INSERT INTO pessoa (nome, cpf, cel, descricao)
VALUES ('Israel Peixoto', '08199810602', '(11) 99900-9090', 'Cliente regular');

ALTER TABLE Funcionario RENAME COLUMN id TO FuncId;
ALTER TABLE func RENAME TO Funcionario;

