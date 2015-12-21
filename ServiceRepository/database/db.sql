CREATE DATABASE `db_cpms_service_repository` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `db_cpms_service_repository`.`tbl_machine_services` (
  `machine_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `machine_model` VARCHAR(100) NULL COMMENT '',
  `machine_description` VARCHAR(1000) NULL COMMENT '',
  `control_service_url` VARCHAR(1000) NULL COMMENT '',
  `control_service_description` VARCHAR(1000) NULL COMMENT '',
  `monitor_service_url` VARCHAR(1000) NULL COMMENT '',
  `monitor_service_description` VARCHAR(1000) NULL COMMENT '',
  PRIMARY KEY (`machine_id`)  COMMENT '');


# NEW DB - Redesigned tables

CREATE TABLE `db_cpms_service_repository`.`tbl_machines` (
  `machine_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `machine_model` VARCHAR(100) NOT NULL COMMENT '',
  `machine_description` VARCHAR(1000) NOT NULL COMMENT '',
  `tags` VARCHAR(1000) NULL COMMENT '',
  PRIMARY KEY (`machine_id`)  COMMENT '',
  UNIQUE INDEX `machine_id_UNIQUE` (`machine_id` ASC)  COMMENT '');


CREATE TABLE `db_cpms_service_repository`.`tbl_services` (
  `service_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `service_name` VARCHAR(200) NOT NULL COMMENT '',
  `service_url` VARCHAR(1000) NOT NULL COMMENT '',
  `machine_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`service_id`)  COMMENT '',
  INDEX `machine_id_idx` (`machine_id` ASC)  COMMENT '',
  CONSTRAINT `machine_id`
  FOREIGN KEY (`machine_id`)
  REFERENCES `db_cpms_service_repository`.`tbl_machines` (`machine_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
