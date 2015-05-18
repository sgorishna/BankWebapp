SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`account_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bank`.`account_type` (
  `idAccount_type` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `account_type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idAccount_type`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`account_currency`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bank`.`account_currency` (
  `idAccount_currency` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `currency` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`idAccount_currency`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bank`.`customer` (
  `idCustomer` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `gender` VARCHAR(10) NOT NULL ,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `updated` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`idCustomer`) )
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`account`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bank`.`account` (
  `idAccount` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `idCustomer` BIGINT(20) NOT NULL ,
  `idAccount_type` BIGINT(20) NOT NULL ,
  `idCurrency` BIGINT(20) NOT NULL ,
  `account_number` BIGINT(20) NOT NULL ,
  `balance` DECIMAL(10,0) NOT NULL ,
  `created` TIMESTAMP NULL DEFAULT NULL ,
  `updated` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`idAccount`) ,
  UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC) ,
  INDEX `idCustomer_FK_idx` (`idCustomer` ASC) ,
  INDEX `idCurrency_FK_idx` (`idCurrency` ASC) ,
  INDEX `idAccount_type_FK_idx` (`idAccount_type` ASC) ,
  CONSTRAINT `idAccount_type_FK`
    FOREIGN KEY (`idAccount_type` )
    REFERENCES `bank`.`account_type` (`idAccount_type` )
    ON UPDATE CASCADE,
  CONSTRAINT `idCurrency_FK`
    FOREIGN KEY (`idCurrency` )
    REFERENCES `bank`.`account_currency` (`idAccount_currency` )
    ON UPDATE CASCADE,
  CONSTRAINT `idCustomer_FK`
    FOREIGN KEY (`idCustomer` )
    REFERENCES `bank`.`customer` (`idCustomer` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bank`.`transaction`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bank`.`transaction` (
  `idTransaction` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `idAccount_sender` BIGINT(20) NOT NULL ,
  `idAccount_receiver` BIGINT(20) NOT NULL ,
  `amount` INT(11) NOT NULL ,
  `comments` VARCHAR(100) NULL DEFAULT NULL ,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`idTransaction`) ,
  INDEX `idAccount_sender_idx` (`idAccount_sender` ASC) ,
  INDEX `idAccount_receiver_idx` (`idAccount_receiver` ASC) ,
  CONSTRAINT `idAccount_receiver`
    FOREIGN KEY (`idAccount_receiver` )
    REFERENCES `bank`.`account` (`idAccount` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `idAccount_sender`
    FOREIGN KEY (`idAccount_sender` )
    REFERENCES `bank`.`account` (`idAccount` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `bank` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
