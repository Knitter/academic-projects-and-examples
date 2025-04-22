--***************************************************************************************************
--* Procedimento que permite introduzir dados na tabela Curso                                       *
--* Parâmetros de entrada: descrição do curso, duração, abreviatura do nome do curso, nome e regime *
--***************************************************************************************************
create or replace procedure proc_inserir_curso(p_descricao tbl_curso.descricao%type,
       p_duracao tbl_curso.duracao%type, p_abreviatura tbl_curso.abreviatura%type, p_nome tbl_curso.nome%type,
	     p_regime tbl_curso.regime%type       
) is  

begin
     set transaction read write name 'inserir curso';
     insert into tbl_curso values (0, p_descricao,	p_duracao, p_abreviatura, p_nome, p_regime,	0, 0);
     commit;
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20017, 'falha na introducao de curso');
end proc_inserir_curso;
/
