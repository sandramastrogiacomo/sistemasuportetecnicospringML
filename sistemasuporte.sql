INSERT INTO atendentes (nome, nome_balcao, balcao_id)
VALUES
('Carlos Pereira', 'Norte', 1),
('Ana Ferreira', 'Central', 2),
('João da Silva', 'Sul', 3);

SELECT * FROM atendentes;

INSERT INTO balcao_atendimento(nome_balcao) VALUES ('Central'), ('Norte'),('Sul');

SELECT * FROM balcao_atendimento;