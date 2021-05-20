CREATE DATABASE WORKOUT;
USE WORKOUT;

CREATE TABLE EJERCICIOS (
	ID_EJERCICIO INT(5) PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(75) NOT NULL,
    TIPO VARCHAR(15) NOT NULL,
    ZONA VARCHAR(15) NOT NULL,
    PESO INT(3),
    INTENSIDAD VARCHAR(15),
    TIEMPO INT(3)
);

CREATE TABLE USUARIO (
	ID_USUARIO INT(5) PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(15) UNIQUE,
    PASS VARCHAR(50),
    DNI VARCHAR(9) UNIQUE,
    ID_RUTINA INT(5)
);

-- -------------------------------------------------------------------------------------------------------------------------------------------- --

INSERT INTO EJERCICIOS(NOMBRE, TIPO, ZONA, PESO, INTENSIDAD, TIEMPO) VALUES
	('Press_Pectoral', 'Fuerza','Pecho', 30, null, null),
    ('Remo_Máquina', 'Fuerza','Espalda', 25, null, null),
    ('Prensa_Horizontal', 'Fuerza','Piernas', 75, null, null),
    ('Jalón_Máquina', 'Fuerza','Espalda', 60, null, null),
    ('Extensión_Espalda', 'Fuerza','Cadera', 10, null, null),
    ('Press_Hombro_Máquina', 'Fuerza','Hombros', 20, null, null),
    ('Crunch_Máquina', 'Fuerza','Abdomen', 35, null, null),
    ('Press_Banca', 'Fuerza','Pecho', 30, null, null),
    ('Curl_Biceps', 'Fuerza','Brazos', 30, null, null),
    ('Curl_Triceps', 'Fuerza','Brazos', 30, null, null),
    -- ---------------------------------------- --
    ('Torsión_Espalda', 'Flexibilidad','Espalda', null, 'Media', null),
    ('Zancada_con_Rotación', 'Flexibilidad','Piernas', null, 'Media', null),
    ('Step_Back_Squat', 'Flexibilidad','Cadera', null, 'Baja', null),
    ('Warm_Up_Roll', 'Flexibilidad','Cadera', null, 'Alta', null),
    ('Wall_Climb', 'Flexibilidad','Cuerpo', null, 'Media', null),
    ('Puente_con_Pelota', 'Flexibilidad','Espalda', null, 'Media', null),
    ('Cadenas_Musculares', 'Flexibilidad','Cuerpo', null, 'Baja', null),
    ('Patada_de_Glúteos', 'Flexibilidad','Piernas', null, 'Media', null),
    ('Split_lateral', 'Flexibilidad','Piernas', null, 'Baja', null),
    -- ---------------------------------------- --
    ('Carrera', 'Resistencia','General', null, null, 30),
    ('Step', 'Resistencia','General', null, null, 60),
    ('Escaleras', 'Resistencia','General', null, null, 10),
    ('Planchas', 'Resistencia','General', null, null, 2),
    ('Nadar', 'Resistencia','General', null, null, 30);

-- -------------------------------------------------------------------------------------------------------------------------------------------- --

-- SP PARA CAMBIAR LA CONTRASEÑA DEL USUARIO:
DELIMITER |
CREATE PROCEDURE spUpdatePass(
    spPASS VARCHAR(50),
    spID_USUARIO INT(5)
)
BEGIN
    UPDATE workout.usuario 
        SET  PASS = spPASS WHERE ID_USUARIO = spID_USUARIO;
END |
DELIMITER ;