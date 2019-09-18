create database DBRestaurante;
use DBRestaurante;
-- -------------------------------------
create table ubicaciones(
	idubicacion int not null,
    area varchar(40) not null,
    PRIMARY KEY (idubicacion)
);

create table puestos(
	idpuesto int not null ,
    puesto varchar(40) not null,
    PRIMARY KEY(idpuesto)
);

create table platos(
	idplato int not null,
    plato varchar(40) not null,
    costo decimal(10) not null,
    PRIMARY KEY(idplato)
);

create table clientes(
	idcliente int not null,
    nombres varchar(40) not null,
    apellidos varchar(40) not null,
    dpi varchar(40) not null,
    edad int not null,
    fechanacimiento date not null,
	PRIMARY KEY(idcliente)
);

create table empleados(
	idempleado int not null,
    nombres varchar(40) not null,
    apellidos varchar(40) not null,
    idpuesto int not null,
    PRIMARY KEY(idempleado),
    FOREIGN KEY(idpuesto) REFERENCES puestos(idpuesto)ON DELETE NO ACTION
);

create table mesas(
	idmesa int not null,
    cantidadpersonas int not null,
    idubicacion int not null,
    PRIMARY KEY (idmesa),
    FOREIGN KEY(idubicacion) REFERENCES ubicaciones(idubicacion)ON DELETE NO ACTION
);

create table ordenes(
	idorden int not null,
    idmesa int not null,
    idplato int not null,
    plato_costo decimal not null,
    cantidadplatos int not null,
    descripcion varchar(100) not null,
	totalventa decimal AS (plato_costo * cantidadplatos),
    PRIMARY KEY (idorden),
	FOREIGN KEY(idmesa) REFERENCES mesas(idmesa)ON DELETE NO ACTION,
	FOREIGN KEY(idplato) REFERENCES platos(idplato)ON DELETE NO ACTION
);

create table factura(
	idfactura int not null,
    fechayhora datetime default now(),
    idcliente int not null,
    idmesa int not null,
    totalventa decimal not null,
    PRIMARY KEY (idfactura),
    FOREIGN KEY(idcliente) REFERENCES clientes(idcliente)ON DELETE NO ACTION,
    FOREIGN KEY(idmesa) REFERENCES mesas(idmesa)ON DELETE NO ACTION
);

create table orden_factura(
	PRIMARY KEY (idorden,idfactura),
    idorden int,
    idfactura int,
    FOREIGN KEY(idorden) REFERENCES ordenes(idorden)ON DELETE NO ACTION,
	FOREIGN KEY(idfactura) REFERENCES factura(idfactura)ON DELETE NO ACTION
);

create table empleados_factura(
	PRIMARY KEY (idempleado,idfactura),
    idempleado int,
    idfactura int,
	FOREIGN KEY(idempleado) REFERENCES empleados(idempleado)ON DELETE NO ACTION,
	FOREIGN KEY(idfactura) REFERENCES factura(idfactura)ON DELETE NO ACTION
);