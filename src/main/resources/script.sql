CREATE TABLE controlepassagens.estado (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sigla VARCHAR(2) NOT NULL
);

INSERT INTO controlepassagens.estado (nome, sigla) VALUES ("Paraná", "PR");
INSERT INTO controlepassagens.estado (nome, sigla) VALUES ("São paulo", "SP");
INSERT INTO controlepassagens.estado (nome, sigla) VALUES ("Minas Gerais", "MG");

CREATE TABLE controlepassagens.cidade (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    id_estado INT,
    FOREIGN KEY (id_estado) REFERENCES estado(id)
);

INSERT INTO controlepassagens.cidade (nome, id_estado) VALUES("Dois Vizinhos", 1);
INSERT INTO controlepassagens.cidade (nome, id_estado) VALUES("Presidente Prudente", 2);
INSERT INTO controlepassagens.cidade (nome, id_estado) VALUES("Parati", 3);

CREATE TABLE controlepassagens.cliente (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    documento VARCHAR(14) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

INSERT INTO controlepassagens.cliente (nome, documento, telefone) VALUES("Airton Cruz", "2515248525", "999243095");
INSERT INTO controlepassagens.cliente (nome, documento, telefone) VALUES("Joao da Silva", "525525262", "525152548254");
INSERT INTO controlepassagens.cliente (nome, documento, telefone) VALUES("Paulo da Cunha", "152414525636", "302560525");

CREATE TABLE controlepassagens.passagem (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
	id_origem INT,
	FOREIGN KEY (id_origem) REFERENCES cidade(id),
	id_destino INT,
	FOREIGN KEY (id_destino) REFERENCES cidade(id),
	id_cliente INT,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	num_assento VARCHAR(20) NOT NULL
);

INSERT INTO controlepassagens.passagem (id_origem, id_destino, id_cliente, num_assento) VALUES(1, 2, 1, "01AB");
INSERT INTO controlepassagens.passagem (id_origem, id_destino, id_cliente, num_assento) VALUES(2, 1, 3, "02AX");
INSERT INTO controlepassagens.passagem (id_origem, id_destino, id_cliente, num_assento) VALUES(3, 2, 2, "03AC");

CREATE TABLE controlepassagens.aeronave (
	id INT(6) AUTO_INCREMENT PRIMARY KEY,
    fabricante VARCHAR(255) NOT NULL,
    num_max_passageiros INT,
    is_operando boolean
);

INSERT INTO controlepassagens.aeronave (fabricante, num_max_passageiros, is_operando) VALUES('Boeing', 200, true);
INSERT INTO controlepassagens.aeronave (fabricante, num_max_passageiros, is_operando) VALUES('Boeing', 250, true);
INSERT INTO controlepassagens.aeronave (fabricante, num_max_passageiros, is_operando) VALUES('Embraer', 100, true);
INSERT INTO controlepassagens.aeronave (fabricante, num_max_passageiros, is_operando) VALUES('Embraer', 75, false);




