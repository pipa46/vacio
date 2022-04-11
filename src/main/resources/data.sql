INSERT INTO CATEGORY(id,name) VALUES (1,'Eurogames');
INSERT INTO CATEGORY(id,name) VALUES (2,'Ameritrash');
INSERT INTO CATEGORY(id,name) VALUES(3,'Familiar');

INSERT INTO CLIENTES(id, name) VALUES (1, 'Periko');
INSERT INTO CLIENTES(id, name) VALUES (2, 'Alvaro');
INSERT INTO CLIENTES(id, name) VALUES (3, 'Pipa');
INSERT INTO CLIENTES(id, name) VALUES (4, 'Andres');
INSERT INTO CLIENTES(id, name) VALUES (5, 'Paco');


INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTOR(id, nombre, nacionalidad) VALUES (6, 'Phil Walker-Harding', 'US');


INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);






INSERT INTO PRESTAMOS(id, juego_id, cliente_id, fecha_Inicio , fecha_Fin) VALUES (1, 1, 1, '2020/01/01', '2020/01/06');
INSERT INTO PRESTAMOS(id, juego_id, cliente_id , fecha_Inicio , fecha_Fin) VALUES (2, 2, 2, '2020/01/01', '2020/01/06');
INSERT INTO PRESTAMOS(id, juego_id, cliente_id , fecha_Inicio , fecha_Fin) VALUES (3, 3, 3, '2020/01/02', '2020/01/20');
INSERT INTO PRESTAMOS(id, juego_id, cliente_id , fecha_Inicio , fecha_Fin) VALUES (4, 4, 4, '2020/01/01', '2020/01/06');
INSERT INTO PRESTAMOS(id, juego_id, cliente_id , fecha_Inicio , fecha_Fin) VALUES (5, 5, 5, '2020/01/05', '2020/01/10');





