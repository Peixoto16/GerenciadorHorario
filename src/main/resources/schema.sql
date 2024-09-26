CREATE TABLE IF NOT EXISTS pessoa (
   pessoaid SERIAL PRIMARY KEY,
   nome VARCHAR(30) NOT NULL,
   cpf CHAR(11) UNIQUE NOT NULL,
   cel VARCHAR(15),
   descricao TEXT
);

CREATE TABLE IF NOT EXISTS funcionario (
   funcid SERIAL PRIMARY KEY,
   nome VARCHAR(30) NOT NULL,
   cpf CHAR(11) UNIQUE NOT NULL,
   cel VARCHAR(15),
   especialidade VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS agendamento (
   agendamentoid SERIAL PRIMARY KEY,
   pessoaid INT NOT NULL,
   funcid INT NOT NULL,
   data DATE NOT NULL,
   hora TIME NOT NULL,
   descricao TEXT,
   FOREIGN KEY (pessoaid) REFERENCES pessoa(pessoaid) ON DELETE CASCADE,
   FOREIGN KEY (funcid) REFERENCES funcionario(funcid) ON DELETE CASCADE,
   UNIQUE (data, hora)
);
