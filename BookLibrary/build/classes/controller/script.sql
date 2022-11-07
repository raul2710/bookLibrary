/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Raul
 * Created: 20 de out. de 2022
 */

CREATE TABLE tb_author (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100)
);

CREATE TABLE tb_genre (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100)
);

CREATE TABLE tb_publisher (
    id SERIAL PRIMARY KEY,
    name VARCHAR (100)
);

CREATE TABLE tb_book (
    id SERIAL PRIMARY KEY, 
    isbn VARCHAR(100),
    title VARCHAR(100),
    id_genre INT,
    id_publisher INT,
    id_author INT, 
    edition INT, 
    rating INT, 
    status VARCHAR(20),
    description VARCHAR(500),
    
    FOREIGN KEY (id_genre)
        REFERENCES tb_genre(id),
    FOREIGN KEY (id_publisher)
        REFERENCES tb_publisher(id),
    FOREIGN KEY (id_author)
        REFERENCES tb_author(id)
);

CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(20),
    name VARCHAR(100),
    telephone VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(32),
    dateBorn DATE,
    status VARCHAR(20)
);

CREATE TABLE tb_loan (
    id SERIAL PRIMARY KEY, 
    id_book INT, 
    id_user INT, 
    dateBorrow DATE, 
    dateReturn DATE, 
    status VARCHAR(20),

    FOREIGN KEY (id_book)
        REFERENCES tb_book(id),
    FOREIGN KEY (id_user)
        REFERENCES tb_user(id)
);

