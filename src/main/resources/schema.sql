
CREATE SCHEMA IF NOT EXISTS `DataBase` ;
USE `DataBase` ;

-- -----------------------------------------------------
-- Table `DataBase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DataBase`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `DataBase`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DataBase`.`team` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lead` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `lead_id_idx` (`lead` ASC),
  CONSTRAINT `lead_id`
  FOREIGN KEY (`lead`)
  REFERENCES `DataBase`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `DataBase`.`team_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DataBase`.`team_user` (
  `team_id` INT NOT NULL,
  `user_id` INT NULL,
  INDEX `team_id_idx` (`team_id` ASC),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `team_id`
  FOREIGN KEY (`team_id`)
  REFERENCES `DataBase`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `DataBase`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `DataBase`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DataBase`.`project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `team` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `team_idx` (`team` ASC),
  CONSTRAINT `team`
  FOREIGN KEY (`team`)
  REFERENCES `DataBase`.`team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
