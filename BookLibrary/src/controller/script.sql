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
    name VARCHAR (50)
);

CREATE TABLE tb_genre (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50)
);

CREATE TABLE tb_publisher (
    id SERIAL PRIMARY KEY,
    name VARCHAR (50)
);


CREATE TABLE tb_book (

);

CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(20),
    name VARCHAR(100),
    telephone VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(32),
    dateBirth DATE,
    status VARCHAR(10)
);

CREATE TABLE tb_loan (

);

