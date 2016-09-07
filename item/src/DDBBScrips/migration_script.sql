-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: itemproj
-- Source Schemata: itemproj
-- Created: Tue Jul 12 23:37:25 2016
-- Workbench Version: 6.3.4
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema itemproj
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `itemproj` ;
CREATE SCHEMA IF NOT EXISTS `itemproj` ;

-- ----------------------------------------------------------------------------
-- Table itemproj.Administrador
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`Administrador` (
  `dbId_usuario` INT(11) NOT NULL COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_usuario`)  COMMENT '',
  INDEX `FK8BEB69DAF7F48` (`dbId_usuario` ASC)  COMMENT '',
  CONSTRAINT `FK8BEB69DAF7F48`
    FOREIGN KEY (`dbId_usuario`)
    REFERENCES `itemproj`.`USUARIO` (`dbId_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.USUARIO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`USUARIO` (
  `dbId_usuario` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `NOMBRE` VARCHAR(255) NOT NULL COMMENT '',
  `EMAIL` VARCHAR(255) NOT NULL COMMENT '',
  `PASSWORD` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `TELEFONO` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `VERSION` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_usuario`)  COMMENT '',
  INDEX `FK22E07F0E9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  CONSTRAINT `FK22E07F0E9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.EQUIPO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`EQUIPO` (
  `dbId_equipo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `proyecto` INT(11) NULL DEFAULT NULL COMMENT '',
  `responsable` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_equipo`)  COMMENT '',
  INDEX `FK7A5B923F8C15360A` (`responsable` ASC)  COMMENT '',
  INDEX `FK7A5B923F9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  INDEX `FK7A5B923FE841CDFF` (`proyecto` ASC)  COMMENT '',
  CONSTRAINT `FK7A5B923F8C15360A`
    FOREIGN KEY (`responsable`)
    REFERENCES `itemproj`.`MiembroEquipo` (`dbId_usuario`),
  CONSTRAINT `FK7A5B923F9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`),
  CONSTRAINT `FK7A5B923FE841CDFF`
    FOREIGN KEY (`proyecto`)
    REFERENCES `itemproj`.`PROYECTOSOFTWARE` (`dbId`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.MiembroEquipo
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`MiembroEquipo` (
  `dbId_usuario` INT(11) NOT NULL COMMENT '',
  `puesto` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_usuario`)  COMMENT '',
  INDEX `FK173F2E5A6DC1C30A` (`puesto` ASC)  COMMENT '',
  INDEX `FK173F2E5AAF7F48` (`dbId_usuario` ASC)  COMMENT '',
  CONSTRAINT `FK173F2E5A6DC1C30A`
    FOREIGN KEY (`puesto`)
    REFERENCES `itemproj`.`PUESTO` (`dbId`),
  CONSTRAINT `FK173F2E5AAF7F48`
    FOREIGN KEY (`dbId_usuario`)
    REFERENCES `itemproj`.`USUARIO` (`dbId_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.ITEMSYS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`ITEMSYS` (
  `oid_itemsys` VARCHAR(255) NOT NULL COMMENT '',
  PRIMARY KEY (`oid_itemsys`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.PROYECTOSOFTWARE
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`PROYECTOSOFTWARE` (
  `dbId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `nombre` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `equipo` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId`)  COMMENT '',
  INDEX `FK5618E5AC47D4A92C` (`equipo` ASC)  COMMENT '',
  INDEX `FK5618E5AC9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  CONSTRAINT `FK5618E5AC47D4A92C`
    FOREIGN KEY (`equipo`)
    REFERENCES `itemproj`.`EQUIPO` (`dbId_equipo`),
  CONSTRAINT `FK5618E5AC9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.EQUIPO_MIEMBROS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`EQUIPO_MIEMBROS` (
  `dbId_equipo` INT(11) NULL DEFAULT NULL COMMENT '',
  `elt` INT(11) NOT NULL COMMENT '',
  INDEX `FKD07CCD781DF91AB9` (`elt` ASC)  COMMENT '',
  INDEX `FKD07CCD78FABED612` (`dbId_equipo` ASC)  COMMENT '',
  CONSTRAINT `FKD07CCD781DF91AB9`
    FOREIGN KEY (`elt`)
    REFERENCES `itemproj`.`MiembroEquipo` (`dbId_usuario`),
  CONSTRAINT `FKD07CCD78FABED612`
    FOREIGN KEY (`dbId_equipo`)
    REFERENCES `itemproj`.`EQUIPO` (`dbId_equipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.HISTORIAL
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`HISTORIAL` (
  `dbId_hist` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `fecha` DATETIME NULL DEFAULT NULL COMMENT '',
  `registro` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `histoID` INT(11) NULL DEFAULT NULL COMMENT '',
  `respasig` INT(11) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_hist`)  COMMENT '',
  INDEX `FKCF0EF8F9A85AAC` (`respasig` ASC)  COMMENT '',
  CONSTRAINT `FKCF0EF8F9A85AAC`
    FOREIGN KEY (`respasig`)
    REFERENCES `itemproj`.`MiembroEquipo` (`dbId_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.HISTORIAL_ITEM
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`HISTORIAL_ITEM` (
  `dbId_item` INT(11) NULL DEFAULT NULL COMMENT '',
  `elt` INT(11) NOT NULL COMMENT '',
  INDEX `FK58AE9DC3EB1E94EE` (`elt` ASC)  COMMENT '',
  INDEX `FK58AE9DC32591E4BA` (`dbId_item` ASC)  COMMENT '',
  CONSTRAINT `FK58AE9DC32591E4BA`
    FOREIGN KEY (`dbId_item`)
    REFERENCES `itemproj`.`ITEM` (`dbId_item`),
  CONSTRAINT `FK58AE9DC3EB1E94EE`
    FOREIGN KEY (`elt`)
    REFERENCES `itemproj`.`HISTORIAL` (`dbId_hist`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.ITEM
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`ITEM` (
  `dbId_item` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `titulo` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `descripcion` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `fecha` DATETIME NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `asignado` INT(11) NULL DEFAULT NULL COMMENT '',
  `type` INT(11) NULL DEFAULT NULL COMMENT '',
  `proyecto` INT(11) NULL DEFAULT NULL COMMENT '',
  `estado` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_item`)  COMMENT '',
  INDEX `FK2273139B03A931` (`oid_itemsys` ASC)  COMMENT '',
  INDEX `FK227313A5814555` (`type` ASC)  COMMENT '',
  INDEX `FK227313C70AA7A0` (`estado` ASC)  COMMENT '',
  INDEX `FK227313E841CDFF` (`proyecto` ASC)  COMMENT '',
  INDEX `FK227313F6C1F85A` (`asignado` ASC)  COMMENT '',
  CONSTRAINT `FK2273139B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`),
  CONSTRAINT `FK227313A5814555`
    FOREIGN KEY (`type`)
    REFERENCES `itemproj`.`ITEMTYPE` (`dbId`),
  CONSTRAINT `FK227313C70AA7A0`
    FOREIGN KEY (`estado`)
    REFERENCES `itemproj`.`NODO` (`dbId_nodo`),
  CONSTRAINT `FK227313E841CDFF`
    FOREIGN KEY (`proyecto`)
    REFERENCES `itemproj`.`PROYECTOSOFTWARE` (`dbId`),
  CONSTRAINT `FK227313F6C1F85A`
    FOREIGN KEY (`asignado`)
    REFERENCES `itemproj`.`MiembroEquipo` (`dbId_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.ITEMTYPE
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`ITEMTYPE` (
  `dbId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `descripcion` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `fecha` DATETIME NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `titulo` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `proyecto` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId`)  COMMENT '',
  INDEX `FK74E438CD9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  INDEX `FK74E438CD2674BE12` (`proyecto` ASC)  COMMENT '',
  CONSTRAINT `FK74E438CD2674BE12`
    FOREIGN KEY (`proyecto`)
    REFERENCES `itemproj`.`WORKFLOW` (`dbId_workflow`),
  CONSTRAINT `FK74E438CD9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.NODO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`NODO` (
  `dbId_nodo` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `Name` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_nodo`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.WORKFLOW
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`WORKFLOW` (
  `dbId_workflow` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `Name` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId_workflow`)  COMMENT '',
  INDEX `FK30C1C7BF9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  CONSTRAINT `FK30C1C7BF9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.PUESTO
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`PUESTO` (
  `dbId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `oid` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `Name` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  `version` INT(11) NULL DEFAULT NULL COMMENT '',
  `oid_itemsys` VARCHAR(255) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`dbId`)  COMMENT '',
  INDEX `FK8D521F2E9B03A931` (`oid_itemsys` ASC)  COMMENT '',
  CONSTRAINT `FK8D521F2E9B03A931`
    FOREIGN KEY (`oid_itemsys`)
    REFERENCES `itemproj`.`ITEMSYS` (`oid_itemsys`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.NODO_PROX
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`NODO_PROX` (
  `dbId_equipo` INT(11) NULL DEFAULT NULL COMMENT '',
  `elt` INT(11) NOT NULL COMMENT '',
  INDEX `FKD4AD95BE1427F6E7` (`elt` ASC)  COMMENT '',
  INDEX `FKD4AD95BE79D9395F` (`dbId_equipo` ASC)  COMMENT '',
  CONSTRAINT `FKD4AD95BE1427F6E7`
    FOREIGN KEY (`elt`)
    REFERENCES `itemproj`.`NODO` (`dbId_nodo`),
  CONSTRAINT `FKD4AD95BE79D9395F`
    FOREIGN KEY (`dbId_equipo`)
    REFERENCES `itemproj`.`NODO` (`dbId_nodo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table itemproj.WORKFLOW_NODOS
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `itemproj`.`WORKFLOW_NODOS` (
  `dbId_workflow` INT(11) NULL DEFAULT NULL COMMENT '',
  `elt` INT(11) NOT NULL COMMENT '',
  INDEX `FKF2633B471427F6E7` (`elt` ASC)  COMMENT '',
  INDEX `FKF2633B47456A832` (`dbId_workflow` ASC)  COMMENT '',
  CONSTRAINT `FKF2633B471427F6E7`
    FOREIGN KEY (`elt`)
    REFERENCES `itemproj`.`NODO` (`dbId_nodo`),
  CONSTRAINT `FKF2633B47456A832`
    FOREIGN KEY (`dbId_workflow`)
    REFERENCES `itemproj`.`WORKFLOW` (`dbId_workflow`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
SET FOREIGN_KEY_CHECKS = 1;
