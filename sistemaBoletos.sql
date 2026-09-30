use titicket;

-- tabla de usuarios (TODOS los uduarios, TODAS CUENTAS)
create table Usuario(
id_Usuario int auto_increment primary key,
tipo_Usuario ENUM('fan','empresa') not null, -- un usuario puede ser fan o empresa
correo varchar(100) not null unique,
telefono varchar (120) not null unique,
fechaRegistrado datetime default current_timestamp -- mas pa la empresa
)engine=InnoDB;

-- tabla usuario fan
create table usuario_fan(
id_Usuario INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50),
    fecha_nacimiento DATE NOT NULL,
    CONSTRAINT fk_persona_cliente 
        FOREIGN KEY (id_Usuario ) REFERENCES usuario(id_Usuario ) 
        ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- tabla usuario empresa
create table usuario_empresa(
id_Usuario INT PRIMARY KEY,
nombre_empresa VARCHAR(150) NOT NULL,
rfc VARCHAR(15) UNIQUE,
contacto_nombre VARCHAR(100), -- Nombre del representante o encargado
CONSTRAINT fk_empresa_cliente 
  FOREIGN KEY (id_Usuario ) REFERENCES usuario(id_Usuario ) 
  ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- tabla eventos
create table evento(
id_evento int auto_increment primary key,
nombre varchar (100) not null,
descripcion varchar(300) ,
fecha_Evento datetime not null,
lugar varchar (140) not null
)engine=InnoDB;

-- tabla boleto
CREATE TABLE boleto (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    codigo_boleto VARCHAR(50) NOT NULL UNIQUE,
    precio DECIMAL(10,2) NOT NULL,
    estado ENUM('disponible', 'apartado', 'vendido') DEFAULT 'disponible', -- apartado por el tiempo de confimacion de la compra
    id_evento INT NOT NULL,
    CONSTRAINT fk_boleto_evento 
        FOREIGN KEY (id_evento) REFERENCES evento(id_evento) 
        ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;

-- tabla compra
CREATE TABLE compra (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    fecha_compra DATETIME DEFAULT CURRENT_TIMESTAMP,
    monto_total DECIMAL(10,2) NOT NULL,
    id_Usuario INT NOT NULL,
    CONSTRAINT fk_compra_cliente 
  FOREIGN KEY (id_Usuario ) REFERENCES usuario(id_Usuario ) 
  ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;

-- detalle compra
CREATE TABLE detalle_compra (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    precio_unitario DECIMAL(10,2) NOT NULL,
    id_compra INT NOT NULL,
    id_boleto INT NOT NULL UNIQUE,
    CONSTRAINT fk_detalle_compra 
        FOREIGN KEY (id_compra) REFERENCES compra(id_compra) 
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_detalle_boleto 
        FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto) 
        ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;

