-- Creación de la tabla de Usuarios con un campo adicional para el tipo de usuario
CREATE TABLE usuarios (
    usuario_id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    identificacion VARCHAR(10) not NULL unique,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(50),
    contrasena VARCHAR(255) NOT NULL,
    tipo_usuario VARCHAR(50) NOT null,
    licencia VARCHAR(50), --conductor
    direccion VARCHAR(255), --cliente
    token_notificacion VARCHAR(255)
);


CREATE TABLE vehiculos (
    vehiculo_id SERIAL PRIMARY KEY,
    conductor_id INT,
    placa VARCHAR(50) NOT NULL,
    modelo VARCHAR(50),
    marca VARCHAR(50),
    lat numeric(10,6) ,
    lng numeric(10,6)  ,
    FOREIGN KEY (conductor_id) REFERENCES usuarios(usuario_id)
);


CREATE TABLE envios (
    envio_id SERIAL PRIMARY KEY,
    vehiculo_id INT NOT NULL,
    fecha_hora_inicio TIMESTAMP NOT NULL,
    fecha_hora_estimada_llegada TIMESTAMP,
    fecha_hora_real_llegada TIMESTAMP,
    fecha_hora_carga TIMESTAMP ,
    direccion_destino VARCHAR(255),
    direccion_inicio VARCHAR(255),
    lat_destino numeric(10,6) NOT NULL,
    lng_destino numeric(10,6)  NOT NULL,
    lat_inicio numeric(10,6)  NOT NULL,
    lng_inicio numeric(10,6)  NOT NULL,
    estado VARCHAR(50),
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(vehiculo_id)
);


CREATE TABLE paquetes (
    paquete_id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL,
    descripcion VARCHAR(255),
    estado VARCHAR(50),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);


create table envio_paquetes(
 	envio_paquetes_id SERIAL PRIMARY KEY,
 	paquete_id INT NOT NULL,
 	envio_id INT NOT NULL,
    FOREIGN KEY (paquete_id) REFERENCES paquetes(paquete_id),
    FOREIGN KEY (envio_id) REFERENCES envios(envio_id)
);


CREATE TABLE mensajes (
    mensaje_id SERIAL PRIMARY KEY,
    envio_id INT NOT NULL,
    usuario_id INT NOT NULL,
    contenido TEXT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL,
    es_del_conductor BOOLEAN NOT NULL,
    FOREIGN KEY (envio_id) REFERENCES envios(envio_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);





