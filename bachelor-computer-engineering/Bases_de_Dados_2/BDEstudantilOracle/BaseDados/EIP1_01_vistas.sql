@@ apagar_vistas.sql;

create view v_curso as
       select  abreviatura, nome, regime, duracao, descricao
       from tbl_curso;
       
create view v_departamento as
       select abreviatura, designacao
       from tbl_departamento;

commit;