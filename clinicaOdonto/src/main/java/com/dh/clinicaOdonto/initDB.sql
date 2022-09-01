Create table if not exists Usuario(
	id int auto_increment primary key not null,
	usuario varchar(30) not null,
	senha varchar(30) not null,
	nome varchar(20) not null,
	sobrenome varchar(70) not null,
	idTipoUsuario int
);

Create table if not exists TipoUsuario(
	id int auto_increment primary key not null,
	tipo varchar(20) not null
);

Create table if not exists Dentista(
	id int auto_increment primary key not null,
	idUsuario int not null,
	matricula int not null
);

Create table if not exists Paciente(
	id int auto_increment primary key not null,
	rg varchar(15) not null,
	dataAlta datetime
);

Create table if not exists Agenda(
	id int auto_increment primary key not null,
	idDentista int not null,
	idPaciente int not null,
	dataConsulta datetime not null,
);

Create table if not exists Endereco(
	id int auto_increment primary key not null,
	idUsuario int not null,
	rua varchar(50) not null,
	numero int,
	bairro varchar(30) not null,
	cidade varchar(30) not null,
	cep int,
	estado varchar(2) not null
);

Insert into TipoUsuario (tipo) values ("Administrador"), ("Paciente"), ("Dentista");
