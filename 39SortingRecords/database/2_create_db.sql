-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema employeedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employeedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employeedb` DEFAULT CHARACTER SET utf8 ;
USE `employeedb` ;

-- -----------------------------------------------------
-- Table `employeedb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employeedb`.`employee` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `first_name` VARCHAR(100) NOT NULL,
                                                       `last_name` VARCHAR(100) NOT NULL,
                                                       `position` VARCHAR(100) NOT NULL,
                                                       `separation_date` DATE NULL,
                                                       PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
