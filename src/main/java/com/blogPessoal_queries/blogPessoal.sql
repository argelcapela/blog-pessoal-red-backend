use blog_pessoal;

select * from tb_postagem;
delete from tb_postagem where id_postagem = 21;

insert into tb_postagem (data, titulo, texto) values (current_date() ,"42 | Libft", "Aprendendo a fazer!");
insert into tb_postagem (data, titulo, texto) values (current_date() ,"42 | GNL ", "Aprendendo a fazer!");
insert into tb_postagem (data, titulo, texto) values (current_date() ,"42 | Printf ", "Aprendendo a fazer!");