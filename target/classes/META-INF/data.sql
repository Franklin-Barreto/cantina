INSERT INTO categoria (`nome`) VALUES ('bebidas');
INSERT INTO categoria (`nome`) VALUES ('lanches');
INSERT INTO categoria (`nome`) VALUES ('sobremesas');

INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('coca-cola', '5.0', '1');
INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('x-tudo', '15.0', '2');
INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('pudim', '8.0', '3');
INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('heineken', '10.0', '1');
INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('bauru', '10.50', '2');
INSERT INTO produto (`nome`, `preco`, `categoria_fk`) VALUES ('chocolate', '4.0', '3');

INSERT INTO cliente (nome, cpf,data_nascimento) VALUES('Luciane', '12345678912', '1983-06-28');
INSERT INTO cliente (nome, cpf,data_nascimento) VALUES('Leticia', '12345678912', '1986-07-10');
INSERT INTO cliente (nome, cpf,data_nascimento) VALUES('Raquel', '12345678912', '1999-01-03');

INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2020-10-25', '1',46);
INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2020-06-10', '1',44);
INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2021-06-15', '2',10);
INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2021-07-12', '2',34);
INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2021-08-14', '2',24);
INSERT INTO pedido (`data_criacao`, `cliente_fk`,valor_total) VALUES ('2021-10-12', '3',14);

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('5', '2', '1', '1');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('10', '2', '4', '1');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('8', '2', '3', '1');

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('5', '2', '1', '2');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('10', '2', '4', '2');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('7', '2', '3', '2');

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('5', '2', '1', '3');

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('10', '2', '4', '4');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('7', '2', '3', '4');

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('5', '2', '1', '5');
INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('7', '2', '3', '5');

INSERT INTO item_pedido (`preco`, `quantidade`, `produto_fk`, `pedido_fk`) VALUES ('7', '2', '3', '6');
