# Create degrees
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('assistant');
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('associate professor');
INSERT INTO `botscrew_test`.`Degree` (`name`) VALUES ('professor');

# Create departments and their heads
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Bohdan', 'Stadnyk', '6500', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('IKTA', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('1', '1');

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Artem', 'Syvak', '6500', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('IKHI', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('2', '2');


INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Petro', 'Shulga', '6700', '3');
INSERT INTO `botscrew_test`.`Department` (`name`, `head_id`) VALUES ('IAPX', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('3', '3');

# Create other lectors
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Lesya', 'Molochna', '8200', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('4', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Holmes', 'Sherlock', '3200', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('5', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('James', 'Shevchenko', '4500', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('6', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Iryna', 'Kolobok', '3350', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('7', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('7', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('James', 'Shevchenko', '4500', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('8', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('8', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Walt', 'Disney', '4500', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('9', '1');

INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Tetyana', 'Vesela', '9200', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('10', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Serhiy', 'Olonec', '4500', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('11', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Mykhailo', 'Maydan', '6800', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('12', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('12', '1');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Nikita', 'Khryshch', '3975', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('13', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Andriy', 'Chumachenko', '5100', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('14', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('14', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Herbert', 'Wells', '3200', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('15', '2');


INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Anatolyi', 'Khmuryi', '10200', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('15', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Alice', 'Kukushkina', '9500', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('16', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('16', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('16', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Bohdan', 'Datsyk', '4850', '2');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('17', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Volodymyr', 'Khryshch', '5600', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('18', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('18', '2');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Hennadiy', 'Hentysh', '5100', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('19', '3');
INSERT INTO `botscrew_test`.`Lector` (`name`, `surname`, `salary`, `degree_id`) VALUES ('Pavel', 'Pavlenko', '3200', '1');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('20', '3');
INSERT INTO `botscrew_test`.`lector_department` (`lector_id`, `department_id`) VALUES ('20', '1');
