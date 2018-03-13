CREATE DATABASE db_kungfood;

USE db_kungfood;

CREATE TABLE db_kungfood.tb_admin(

	id_admin INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO ADMIN',
	ds_login_admin VARCHAR(30) NOT NULL COMMENT 'LOGIN DO ADMIN PARA ACESSO AO SISTEMA kungFood',
	ds_senha_admin VARCHAR(30) NOT NULL COMMENT 'SENHA DO ADMIN PARA ACESSO AO SISTEMA kungFood'   	
 
);

CREATE TABLE db_kungfood.tb_cliente(
 
	id_cliente INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO CLIENTE',
    nm_cliente VARCHAR(70) NOT NULL COMMENT 'NOME DO CLIENTE',
    fl_sexo_cliente	CHAR(1)	NOT NULL COMMENT 'INFORMAR M OU F',
    dt_cadastro_cliente DATETIME NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',
    ds_email_cliente VARCHAR(80) NOT NULL COMMENT 'EMAIL DO CLIENTE',
    ds_endereco_cliente VARCHAR(200) NOT NULL COMMENT 'DESCRICAO DO ENDERECO DO CLIENTE',
    fl_origemCadastro_cliente CHAR(1) NOT NULL COMMENT 'ORIGEM DO CADASTRO (I) = INPUT OU (X) = XML',	
    id_admin_cadastro INT NOT NULL COMMENT  'USUARIO LOGADO QUE CADASTROU O CLIENTE'
 
);
CREATE TABLE db_kungfood.tb_cardapio(
	id_prato INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO PRATO',
    nm_prato VARCHAR(70) NOT NULL COMMENT 'NOME DO PRATO',
    ds_prato VARCHAR(200) NOT NULL COMMENT 'DESCRICAO DO PRATO',
    vl_prato DOUBLE NOT NULL COMMENT 'DESCRICAO DO PRATO'
);

CREATE TABLE db_kungfood.tb_pedido(
	id_pedido INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO PEDIDO',
	id_cliente INT NOT NULL COMMENT 'CODIGO DO CLIENTE',
    sts_pedido varchar(50),
    id_prato INT NOT NULL COMMENT 'CODIGO DO PRATO',
    qtd_pedido INT NOT NULL COMMENT 'QUANTIDADE DE PEDIDOS'
);

CREATE TABLE db_kungfood.tb_produto(
	id_produto INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO PRODUTO',
    nm_produto VARCHAR(100) NOT NULL COMMENT 'NOME DO PRODUTO',
    ds_produto	VARCHAR(255) NOT NULL COMMENT 'DESCRICAO DO PRODUTO',
    vl_produto DOUBLE NOT NULL COMMENT 'VALOR DO PRODUTO',
    qt_produto DOUBLE NOT NULL COMMENT 'QUANTIDADE DO PRODUTO',
    validade_produto DATE NOT NULL COMMENT 'VALIDADE DO PRODUTO'
);


ALTER TABLE db_kungfood.tb_cliente ADD FOREIGN KEY (id_admin_cadastro) REFERENCES db_kungfood.tb_admin(id_admin);

ALTER TABLE db_kungfood.tb_pedido ADD FOREIGN KEY (id_cliente) REFERENCES db_kungfood.tb_cliente(id_cliente);

ALTER TABLE db_kungfood.tb_pedido ADD FOREIGN KEY (id_prato) REFERENCES db_kungfood.tb_cardapio(id_prato);

INSERT INTO db_kungfood.tb_admin (ds_login_admin,ds_senha_admin) VALUES('admin','admin');

SHOW FULL COLUMNS FROM tb_admin;

SELECT * FROM db_kungfood.tb_admin;