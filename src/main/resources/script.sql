CREATE TABLE IF NOT EXISTS `apiux`.`tarea` (
  `identificador` INT NOT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME(6) NULL DEFAULT NULL,
  `vigente` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci