-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TesteDeMesabd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TesteDeMesabd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TesteDeMesabd` DEFAULT CHARACTER SET utf8 ;
USE `TesteDeMesabd` ;

-- -----------------------------------------------------
-- Table `TesteDeMesabd`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TesteDeMesabd`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(18) NOT NULL,
  `admin` TINYINT NULL DEFAULT 0,
  `pontos` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TesteDeMesabd`.`teste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TesteDeMesabd`.`teste` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TesteDeMesabd`.`pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TesteDeMesabd`.`pergunta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` LONGTEXT NOT NULL,
  `nivel` INT NULL,
  `teste_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pergunta_teste1_idx` (`teste_id` ASC) VISIBLE,
  CONSTRAINT `fk_pergunta_teste1`
    FOREIGN KEY (`teste_id`)
    REFERENCES `TesteDeMesabd`.`teste` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TesteDeMesabd`.`usuario_pergunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TesteDeMesabd`.`usuario_pergunta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `correto` TINYINT NULL DEFAULT 0,
  `dataResposta` DATETIME NULL,
  `usuario_id` INT NOT NULL,
  `pergunta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_pergunta_usuario_idx` (`usuario_id` ASC) VISIBLE,
  INDEX `fk_usuario_pergunta_pergunta1_idx` (`pergunta_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_pergunta_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `TesteDeMesabd`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_pergunta_pergunta1`
    FOREIGN KEY (`pergunta_id`)
    REFERENCES `TesteDeMesabd`.`pergunta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TesteDeMesabd`.`alternativa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TesteDeMesabd`.`alternativa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  `verdadeiro` TINYINT NULL DEFAULT 0,
  `pergunta_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alternativas_pergunta1_idx` (`pergunta_id` ASC) VISIBLE,
  CONSTRAINT `fk_alternativas_pergunta1`
    FOREIGN KEY (`pergunta_id`)
    REFERENCES `TesteDeMesabd`.`pergunta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
