-- Creación de la base de datos
CREATE DATABASE ProgramaS;
USE ProgramaS;

-- Tabla para el registro de usuarios
CREATE TABLE Registro (
    correo VARCHAR(100) PRIMARY KEY,
    nombreR VARCHAR(100) NOT NULL,
    contrasena VARCHAR(100) NOT NULL
);

-- Tabla para el registro de beneficiarios
CREATE TABLE Beneficiarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    correo1 VARCHAR(100),
    nombre VARCHAR(100) NOT NULL,
    apellidoP VARCHAR(100) NOT NULL,
    apellidoM VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    pais VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    municipio VARCHAR(100) NOT NULL,
    fraccionamiento VARCHAR(100) NOT NULL,
    calle VARCHAR(100) NOT NULL,
    numeroInt VARCHAR(100) NOT NULL,
    codigo_postal VARCHAR(10) NOT NULL,
    curp VARCHAR(18) NOT NULL,
    clave_elector VARCHAR(20) NOT NULL,
    ocr VARCHAR(20) NOT NULL,
    ineAnv MEDIUMBLOB NOT NULL,
    ineRev MEDIUMBLOB NOT NULL,
    correoE VARCHAR(100) NOT NULL,
    nick_facebook VARCHAR(50),
    nick_instagram VARCHAR(50),
    FOREIGN KEY (correo1) REFERENCES Registro(correo)
);

