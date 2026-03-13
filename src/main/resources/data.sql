-- 1. CATEGORIAS (5)
INSERT INTO tb_categoria (nome)
VALUES ('Eletrônicos'),
       ('Livros'),
       ('Roupas'),
       ('Casa'),
       ('Jogos');

-- 2. USUÁRIOS (5)
INSERT INTO tb_usuario (nome, email, telefone, d_nascimento, senha)
VALUES ('João Silva', 'joao@gmail.com', '11999999999', '1990-05-15', 'senha123'),
       ('Maria Oliveira', 'maria@gmail.com', '11888888888', '1985-10-20', 'senha456'),
       ('Carlos Souza', 'carlos@gmail.com', '11777777777', '1995-02-10', 'senha789'),
       ('Ana Costa', 'ana@gmail.com', '11666666666', '1992-12-01', 'senha000'),
       ('Pedro Lima', 'pedro@gmail.com', '11555555555', '1988-07-30', 'senha111');

-- 3. PRODUTOS (10)
INSERT INTO tb_produto (nome, descricao, preco, img_url)
VALUES ('Smartphone', 'Celular potente', 2500.0, 'img1.png'),
       ('Notebook', 'Core i7 16GB', 4500.0, 'img2.png'),
       ('Livro Java', 'Aprenda Java', 80.0, 'img3.png'),
       ('Livro SQL', 'Domine Bancos de Dados', 70.0, 'img4.png'),
       ('Camiseta', 'Algodão Premium', 50.0, 'img5.png'),
       ('Tênis', 'Esportivo', 300.0, 'img6.png'),
       ('Cafeteira', 'Expresso', 600.0, 'img7.png'),
       ('Sofá', '3 lugares', 1500.0, 'img8.png'),
       ('God of War', 'Jogo PS5', 250.0, 'img9.png'),
       ('Zelda', 'Jogo Switch', 350.0, 'img10.png');

-- 4. PRODUTO_CATEGORIA (10) - Tabela de associação N:N
INSERT INTO tb_produto_categoria (produto_id, categoria_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 2),
       (5, 3),
       (6, 3),
       (7, 4),
       (8, 4),
       (9, 5),
       (10, 5);

-- 5. PEDIDOS (10) - Usando IDs de Usuários de 1 a 5
INSERT INTO tb_pedido (horario, status, cliente_id)
VALUES (TIMESTAMP '2026-03-01 10:00:00', 1, 1),
       (TIMESTAMP '2026-03-01 11:30:00', 1, 2),
       (TIMESTAMP '2026-03-02 14:00:00', 2, 3),
       (TIMESTAMP '2026-03-02 15:45:00', 0, 4),
       (TIMESTAMP '2026-03-03 09:00:00', 1, 5),
       (TIMESTAMP '2026-03-03 10:20:00', 3, 1),
       (TIMESTAMP '2026-03-04 13:10:00', 4, 2),
       (TIMESTAMP '2026-03-04 16:00:00', 1, 3),
       (TIMESTAMP '2026-03-05 08:30:00', 2, 4),
       (TIMESTAMP '2026-03-05 17:00:00', 1, 5);

-- 6. ITEM_PEDIDO (10) - Relacionando Pedidos e Produtos
INSERT INTO tb_item_pedido (pedido_id, produto_id, quantidade, preco)
VALUES (1, 1, 1, 2500.0),
       (1, 3, 2, 80.0),
       (2, 2, 1, 4500.0),
       (3, 9, 1, 250.0),
       (4, 5, 3, 50.0),
       (5, 7, 1, 600.0),
       (6, 10, 1, 350.0),
       (7, 6, 1, 300.0),
       (8, 2, 1, 4500.0),
       (9, 8, 1, 1500.0);

-- 7. PAGAMENTOS (Pelo menos alguns para os pedidos pagos)
INSERT INTO tb_pagamento (pedido_id, horario)
VALUES (1, TIMESTAMP '2026-03-01 10:05:00'),
       (3, TIMESTAMP '2026-03-02 14:10:00');

