CREATE SCHEMA `db_cpms_subscription_manager` ;

CREATE TABLE `db_cpms_subscription_manager`.`tbl_cpms_users` (
  `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `user_name` VARCHAR(100) NOT NULL COMMENT '',
  `user_password` VARCHAR(45) NOT NULL COMMENT '',
  `first_name` VARCHAR(45) NOT NULL COMMENT '',
  `last_name` VARCHAR(45) NOT NULL COMMENT '',
  `country` VARCHAR(45) NOT NULL COMMENT '',
  `isAdmin` TINYINT ZEROFILL NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`user_id`)  COMMENT '',
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC)  COMMENT '');

INSERT INTO `db_cpms_subscription_manager`.`tbl_cpms_users` (`user_name`, `user_password`, `first_name`, `last_name`, `country`) VALUES ('rakib@uark.edu', '1234', 'Rakib', 'Shahriar', 'Bangladesh');
ALTER TABLE `db_cpms_subscription_manager`.`tbl_cpms_users`
CHANGE COLUMN `user_name` `user_email` VARCHAR(100) NOT NULL COMMENT '' ;

ALTER TABLE `db_cpms_subscription_manager`.`tbl_cpms_users`
CHANGE COLUMN `isAdmin` `admin_role` TINYINT(1) UNSIGNED ZEROFILL NULL DEFAULT '000' COMMENT '' ;


CREATE TABLE `db_cpms_subscription_manager`.`tbl_cpms_subscribed_machines` (
  `user_id` INT NOT NULL COMMENT '',
  `machine_id` INT NOT NULL COMMENT '',
  `remarks` VARCHAR(500) NULL COMMENT '',
  INDEX `user_id_idx` (`user_id` ASC)  COMMENT '',
  CONSTRAINT `user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `db_cpms_subscription_manager`.`tbl_cpms_users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `db_cpms_subscription_manager`.`tbl_cpms_subscribed_machines`
ADD COLUMN `record_id` INT NOT NULL AUTO_INCREMENT COMMENT '' AFTER `remarks`,
ADD PRIMARY KEY (`record_id`)  COMMENT '';

