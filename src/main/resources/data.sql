INSERT INTO degree (id, name)
VALUES ('a', 'Assistant'),
       ('ap', 'Associate professor'),
       ('p', 'Professor');

INSERT INTO lector (id, full_name, salary, degree_id)
VALUES ('1a', 'Vasylyuk Adam Vitalijovych', 20000.00, 'a'),
       ('2a', 'Myronenko Havrylo Kostyantynovych', 45000.00, 'ap'),
       ('3a', 'Polyakov Feodosij Yakovych', 28500.00, 'a'),
       ('4a', 'Novak Stefan Olehovych', 22340.00, 'a'),
       ('5a', 'Moroz Kostyantyn Leontijovych', 340000.00, 'ap'),
       ('6a', 'Lutsenko Andrij Havrylovych', 120000.00, 'p'),
       ('7a', 'Polishchuk Vsevolod Mykhajlovych', 60000.00, 'ap'),
       ('8a', 'Kosenko Trokhym Rostyslavovych', 90000.00, 'p'),
       ('9a', 'Osadchuk Danylo Kuzmych', 190000.00, 'p'),
       ('10a', 'Kostenko Afanasij Antonovych', 95400.00, 'p');

INSERT INTO department (id, name, head_of_dep)
VALUES ('1b', 'Applied Mathematics', '2a'),
       ('2b', 'Astrophysics', '6a'),
       ('3b', 'Biochemistry', '5a'),
       ('4b', 'Computational Mathematics', '8a'),
       ('5b', 'Discrete Analysis and Intelligent Systems', '9a'),
       ('6b', 'Mathematical and Functional Analysis', '10a');

INSERT INTO lector_department (id, lector_id, department_id)
VALUES ('1c', '2a', '1b'),
       ('2c', '6a', '2b'),
       ('3c', '5a', '3b'),
       ('4c', '8a', '4b'),
       ('5c', '9a', '5b'),
       ('6c', '10a', '6b'),
       ('7c', '6a', '1b'),
       ('8c', '7a', '2b'),
       ('9c', '1a', '3b'),
       ('10c', '3a', '4b'),
       ('11c', '4a', '5b'),
       ('12c', '4a', '6b');