use projeto;

insert into 
    arma(id,nome,tipoArma,tipoMunicao,ammocapacity)
values
     (1,"Riskrunner","Submetralhadora","Media",200),
     (2,"Sunshot","Canhao de mão","Grande",200),
     (3,"Coldheart","Rifle","Media",215);
     
insert into 
    perk(id,nome,raridade,habilidade)
values
    (1,"White nail","Exotico","+ controle de mira"),
    (2,"Personal Assistant","Raro","coloca fogo"),
    (3,"Rampage","Comum","da mais dano");
    
 insert into 
	arma_has_perk(perk_id,arma_id)
values
    (1,1),
    (3,1),
    
    (1,2),
    (2,2),
    
    (2,3),
    (3,3);




select * from jogador;
select * from cofre;
select * from arma;
select * from perk;
select a.nome as 'arma', p.nome as 'perk' , p.habilidade from arma as a, perk as p, arma_has_perk as u
where a.id = u.arma_id and p.id= u.perk_id;