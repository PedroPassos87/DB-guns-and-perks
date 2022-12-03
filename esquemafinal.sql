drop database if exists projeto;
create database if not exists projeto;
use projeto;

create table if not exists jogador(
     id int auto_increment,
     nick varchar(45) not null,
     tag int not null unique,
     primary key(id)
);


create table if not exists perk(
     id int not null,
     nome varchar(45) not null,
     raridade varchar(45),
     habilidade varchar(70) not null,
     primary key (id)
);

create table if not exists arma(
     id int not null,
     nome varchar(45) not null,
     tipoArma varchar(45) default null,
     tipoMunicao varchar(45) default null,
     ammocapacity int not null,
     primary key (id)
   
);

create table if not exists arma_has_perk(
     perk_id INT,
	 arma_id INT,
     primary key (perk_id, arma_id),
     
     constraint fk4
        foreign key (perk_id)
        references perk(id)
        on delete cascade
        on update cascade,
        
     constraint fk5
        foreign key (arma_id)
        references arma(id)
        on delete cascade
        on update cascade

);

create table if not exists cofre(
     id int auto_increment,
     capacidade int not null,
     senha varchar(45) not null unique,
     jogador_id int , 
     arma_id int default null,
     
     primary key (id),
     constraint fk1
	     foreign key (jogador_id)
         references jogador(id)
         on delete cascade
         on update cascade,
         
      
     constraint fk2
         foreign key (arma_id)
         references arma(id)
         on delete set null
         on update cascade    
);

