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
