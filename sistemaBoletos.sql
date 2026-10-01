use titicket;

-- cuentas bancarias donde cae el dineroo
CREATE TABLE cuenta_bancaria (
    id_cuenta_bancaria INT AUTO_INCREMENT PRIMARY KEY,
    banco VARCHAR(50) NOT NULL,
    numero_cuenta VARCHAR(20) NOT NULL,
    clabe VARCHAR(18) NOT NULL,
    titular VARCHAR(100) NOT NULL
) ENGINE=InnoDB;


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
id_cuenta_bancaria int not null,
CONSTRAINT fk_evento_cuenta FOREIGN KEY (id_cuenta_bancaria) REFERENCES cuenta_bancaria(id_cuenta_bancaria) ON DELETE RESTRICT
)engine=InnoDB;

-- tabla boleto
CREATE TABLE boleto (
    id_boleto INT AUTO_INCREMENT PRIMARY KEY,
    codigo_boleto VARCHAR(50) NOT NULL UNIQUE,
    precio DECIMAL(10,2) NOT NULL,
    estado ENUM('disponible', 'apartado', 'vendido','cancelao') DEFAULT 'disponible', -- apartado por el tiempo de confimacion de la compra
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
    estado_compra ENUM('completada', 'cancelada', 'reembolsada') DEFAULT 'completada',
    id_Usuario INT NOT NULL,
    CONSTRAINT fk_compra_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE RESTRICT
) ENGINE=InnoDB;

-- detalle compra
CREATE TABLE detalle_compra (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    precio_historico DECIMAL(10,2) NOT NULL, -- PRECIO AL QUE SE VENDIÓ (Sin importar cambios futuros)
    estado_detalle ENUM('activo', 'cancelado') DEFAULT 'activo',
    fecha_cancelacion DATETIME NULL,
    id_compra INT NOT NULL,
    id_boleto INT NOT NULL UNIQUE,
    CONSTRAINT fk_detalle_compra FOREIGN KEY (id_compra) REFERENCES compra(id_compra) ON DELETE CASCADE,
    CONSTRAINT fk_detalle_boleto FOREIGN KEY (id_boleto) REFERENCES boleto(id_boleto) ON DELETE RESTRICT
) ENGINE=InnoDB;