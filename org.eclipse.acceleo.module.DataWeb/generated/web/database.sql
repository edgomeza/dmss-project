-- Script de creación de base de datos para Sistema Bancario Digital
CREATE DATABASE IF NOT EXISTS sistema_bancario digital;
USE sistema_bancario digital;

-- Creación de tablas
CREATE TABLE IF NOT EXISTS CLIENTES (
    id_cliente INT PRIMARY KEY
,
        dni VARCHAR(255)
,
        nombre VARCHAR(255)
,
        apellidos VARCHAR(255)
,
        email VARCHAR(255)
,
        telefono VARCHAR(255)
,
        fecha_registro VARCHAR(255)
,
        activo BOOLEAN
);

CREATE TABLE IF NOT EXISTS CUENTAS (
    numero_cuenta VARCHAR(255) PRIMARY KEY
,
        tipo_cuenta VARCHAR(255)
,
        saldo DECIMAL(10,2)
,
        fecha_apertura VARCHAR(255)
,
        activa BOOLEAN
,
    cliente_titular_ID INT,
    FOREIGN KEY (cliente_titular_ID) REFERENCES CLIENTES(id_cliente)
);

CREATE TABLE IF NOT EXISTS TRANSACCIONES (
    id_transaccion INT PRIMARY KEY
,
        fecha_transaccion VARCHAR(255)
,
        tipo_transaccion VARCHAR(255)
,
        monto DECIMAL(10,2)
,
        descripcion VARCHAR(255)
,
        estado VARCHAR(255)
,
    cuenta_origen_ID VARCHAR(255),
    FOREIGN KEY (cuenta_origen_ID) REFERENCES CUENTAS(numero_cuenta)
,
        cuenta_destino_ID VARCHAR(255),
    FOREIGN KEY (cuenta_destino_ID) REFERENCES CUENTAS(numero_cuenta)
);

CREATE TABLE IF NOT EXISTS EMPLEADOS (
    id_empleado INT PRIMARY KEY
,
        codigo_empleado VARCHAR(255)
,
        nombre VARCHAR(255)
,
        puesto VARCHAR(255)
,
        departamento VARCHAR(255)
,
        email VARCHAR(255)
,
        activo BOOLEAN
);

CREATE TABLE IF NOT EXISTS PRESTAMOS (
    id_prestamo INT PRIMARY KEY
,
        monto_solicitado DECIMAL(10,2)
,
        tasa_interes DECIMAL(10,2)
,
        plazo_meses INT
,
        estado_prestamo VARCHAR(255)
,
        fecha_solicitud VARCHAR(255)
,
        fecha_aprobacion VARCHAR(255)
,
    cliente_solicitante_ID INT,
    FOREIGN KEY (cliente_solicitante_ID) REFERENCES CLIENTES(id_cliente)
,
        empleado_aprobador_ID INT,
    FOREIGN KEY (empleado_aprobador_ID) REFERENCES EMPLEADOS(id_empleado)
);

CREATE TABLE IF NOT EXISTS TARJETAS_CREDITO (
    numero_tarjeta VARCHAR(255) PRIMARY KEY
,
        limite_credito DECIMAL(10,2)
,
        saldo_actual DECIMAL(10,2)
,
        fecha_vencimiento VARCHAR(255)
,
        activa BOOLEAN
,
    cliente_propietario_ID INT,
    FOREIGN KEY (cliente_propietario_ID) REFERENCES CLIENTES(id_cliente)
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
('AdministradorBanco', 'Acceso completo al sistema bancario')
,
('GerenteOperaciones', 'Gestión de operaciones y transacciones')
,
('EmpleadoBanco', 'Operaciones básicas bancarias')
,
('Cliente', 'Acceso a servicios de cliente')
;

-- Insertar datos de ejemplo para encuestas
INSERT INTO ENCUESTAS (nombre, titulo, descripcion, tipo_representacion) VALUES
('preferenciasBancarias', 'Encuesta de Servicios Preferidos', 'Ayúdanos a conocer tus preferencias bancarias', 'CIRCULAR');

-- Insertar datos de ejemplo para cuestionarios
INSERT INTO CUESTIONARIOS (nombre, titulo, descripcion) VALUES
('satisfaccionCliente', 'Encuesta de Satisfacción Bancaria', 'Evalúa tu experiencia con nuestros servicios');
