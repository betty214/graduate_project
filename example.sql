CREATE TABLE `graduate`.`majors` (
  `major_name` VARCHAR(200) NOT NULL,
  `major_number` INT NOT NULL,
  `category` VARCHAR(100) NULL,
  `recommend_time` INT NULL,
  `this_time` INT NULL,
  `professor_name` VARCHAR(200) NULL,
  `division_number` INT NULL,
  PRIMARY KEY (`major_name`, `major_number`));