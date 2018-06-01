# Create degrees
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('assistant');
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('associate professor');
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('professor');

# Create departments and their heads
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Bohdan', 'Stadnyk', '6500', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('IKTA', '1');
UPDATE `botscrew_test`.`Lector` SET `department_id`='1' WHERE `id`='1';

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Artem', 'Syvak', '6500', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('IKHI', '2');
UPDATE `botscrew_test`.`Lector` SET `department_id`='2' WHERE `id`='2';

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Petro', 'Shulga', '6700', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('INPP', '3');
UPDATE `botscrew_test`.`Lector` SET `department_id`='3' WHERE `id`='3';

# Create other lectors
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Lesya', 'Molochna', '8200', '3', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Holmes', 'Sherlock', '3200', '2', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('James', 'Shevchenko', '4500', '2', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Iryna', 'Kolobok', '3350', '1', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('James', 'Shevchenko', '4500', '1', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Walt', 'Disney', '4500', '1', '1');

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Tetyana', 'Vesela', '9200', '3', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Serhiy', 'Olonec', '4500', '2', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Mykhailo', 'Maydan', '6800', '2', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Nikita', 'Khryshch', '3975', '1', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Andriy', 'Chumachenko', '5100', '1', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Herbert', 'Wells', '3200', '1', '2');

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Anatolyi', 'Khmuryi', '10200', '3', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Alice', 'Kukushkina', '9500', '3', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Bohdan', 'Datsyk', '4850', '2', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Volodymyr', 'Khryshch', '5600', '1', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Hennadiy', 'Hentysh', '5100', '1', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`, `department_id`) VALUES ('Pavel', 'Pavlenko', '3200', '1', '3');