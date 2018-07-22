CREATE TABLE rental_management_system.item (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)