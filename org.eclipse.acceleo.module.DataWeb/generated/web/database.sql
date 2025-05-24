-- Script de creación de base de datos para Biblioteca Universitaria
CREATE DATABASE IF NOT EXISTS biblioteca_universitaria;
USE biblioteca_universitaria;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS LIBROS (
    id_libro INT PRIMARY KEY
,
        titulo VARCHAR(255)
,
        autor VARCHAR(255)
,
        añoPublicacion INT
,
        disponible BOOLEAN
,
    pertenece_categoria_ID INT,
    FOREIGN KEY (pertenece_categoria_ID) REFERENCES CATEGORIAS(id_categoria)
);

CREATE TABLE IF NOT EXISTS CATEGORIAS (
    id_categoria INT PRIMARY KEY
,
        nombre_categoria VARCHAR(255)
,
        descripcion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS USUARIOS (
    id_usuario INT PRIMARY KEY
,
        nombre_usuario VARCHAR(255)
,
        email VARCHAR(255)
,
        activo BOOLEAN
);

CREATE TABLE IF NOT EXISTS PRESTAMOS (
    id_prestamo INT PRIMARY KEY
,
        fechaPrestamo VARCHAR(255)
,
        fechaDevolucion VARCHAR(255)
,
    prestamo_usuario_ID INT,
    FOREIGN KEY (prestamo_usuario_ID) REFERENCES USUARIOS(id_usuario)
,
        prestamo_libro_ID INT,
    FOREIGN KEY (prestamo_libro_ID) REFERENCES LIBROS(id_libro)
);


-- Creación de tablas para encuestas y cuestionarios
CREATE TABLE IF NOT EXISTS ENCUESTAS (
    id_encuesta INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    tipo_representacion VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS PREGUNTAS_ENCUESTA (
    id_pregunta INT PRIMARY KEY AUTO_INCREMENT,
    id_encuesta INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    texto TEXT NOT NULL,
    FOREIGN KEY (id_encuesta) REFERENCES ENCUESTAS(id_encuesta) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OPCIONES_PREGUNTA (
    id_opcion INT PRIMARY KEY AUTO_INCREMENT,
    id_pregunta INT NOT NULL,
    texto VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_pregunta) REFERENCES PREGUNTAS_ENCUESTA(id_pregunta) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS RESPUESTAS_ENCUESTA (
    id_respuesta INT PRIMARY KEY AUTO_INCREMENT,
    id_pregunta INT NOT NULL,
    respuesta TEXT,
    fecha_respuesta DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pregunta) REFERENCES PREGUNTAS_ENCUESTA(id_pregunta) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS CUESTIONARIOS (
    id_cuestionario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS PREGUNTAS_CUESTIONARIO (
    id_pregunta INT PRIMARY KEY AUTO_INCREMENT,
    id_cuestionario INT NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    texto TEXT NOT NULL,
    respuesta_correcta TEXT NOT NULL,
    FOREIGN KEY (id_cuestionario) REFERENCES CUESTIONARIOS(id_cuestionario) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OPCIONES_CUESTIONARIO (
    id_opcion INT PRIMARY KEY AUTO_INCREMENT,
    id_pregunta INT NOT NULL,
    texto VARCHAR(255) NOT NULL,
    valor VARCHAR(255) NOT NULL,
    es_correcta BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_pregunta) REFERENCES PREGUNTAS_CUESTIONARIO(id_pregunta) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS RESPUESTAS_CUESTIONARIO (
    id_respuesta INT PRIMARY KEY AUTO_INCREMENT,
    id_pregunta INT NOT NULL,
    respuesta TEXT,
    es_correcta BOOLEAN DEFAULT FALSE,
    fecha_respuesta DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pregunta) REFERENCES PREGUNTAS_CUESTIONARIO(id_pregunta) ON DELETE CASCADE
);

-- Creación de tablas para usuarios y roles
CREATE TABLE IF NOT EXISTS ROLES (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS USUARIOS (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    id_rol INT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_rol) REFERENCES ROLES(id_rol)
);

-- Datos iniciales
INSERT INTO ROLES (nombre, descripcion) VALUES
('Administrador', 'Acceso total al sistema')
,
('Bibliotecario', 'Gestión de libros y préstamos')
,
('Estudiante', 'Consulta de libros disponibles')
;

-- Insertar datos de ejemplo para encuestas
INSERT INTO ENCUESTAS (nombre, titulo, descripcion, tipo_representacion) VALUES
('preferenciasBiblioteca', 'Encuesta de Preferencias', 'Ayúdanos a conocer tus preferencias de lectura', 'BARRAS');

-- Insertar datos de ejemplo para cuestionarios
INSERT INTO CUESTIONARIOS (nombre, titulo, descripcion) VALUES
('satisfaccionBiblioteca', 'Cuestionario de Satisfacción', 'Evalúa tu experiencia con la biblioteca');
