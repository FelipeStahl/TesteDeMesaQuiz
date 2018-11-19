-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema testedemesabd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema testedemesabd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testedemesabd` DEFAULT CHARACTER SET utf8 ;
USE `testedemesabd` ;

-- -----------------------------------------------------
-- Table `testedemesabd`.`teste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testedemesabd`.`teste` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testedemesabd`.`pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testedemesabd`.`pergunta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` LONGTEXT NOT NULL,
  `nivel` INT(11) NULL DEFAULT NULL,
  `teste_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pergunta_teste1_idx` (`teste_id` ASC) VISIBLE,
  CONSTRAINT `fk_pergunta_teste1`
    FOREIGN KEY (`teste_id`)
    REFERENCES `testedemesabd`.`teste` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testedemesabd`.`alternativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testedemesabd`.`alternativa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `verdadeiro` TINYINT(4) NULL DEFAULT '0',
  `pergunta_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alternativas_pergunta1_idx` (`pergunta_id` ASC) VISIBLE,
  CONSTRAINT `fk_alternativas_pergunta1`
    FOREIGN KEY (`pergunta_id`)
    REFERENCES `testedemesabd`.`pergunta` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 32
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testedemesabd`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testedemesabd`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(18) NOT NULL,
  `admin` TINYINT(4) NULL DEFAULT '0',
  `pontos` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `testedemesabd`.`usuario_pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `testedemesabd`.`usuario_pergunta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `correto` TINYINT(4) NULL DEFAULT '0',
  `dataResposta` DATETIME NULL DEFAULT NULL,
  `usuario_id` INT(11) NOT NULL,
  `pergunta_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_pergunta_usuario_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_usuario_pergunta_pergunta1_idx` (`pergunta_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_pergunta_pergunta1`
    FOREIGN KEY (`pergunta_id`)
    REFERENCES `testedemesabd`.`pergunta` (`id`),
  CONSTRAINT `fk_usuario_pergunta_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `testedemesabd`.`usuario` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
