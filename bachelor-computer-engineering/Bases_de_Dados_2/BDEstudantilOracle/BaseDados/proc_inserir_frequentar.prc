--************************************************************************************
--* Procedimento que permite inserir dados na tabela Frequentar.                     *
--* Par�metros de entrada: c�digo do ano lectivo, c�digo do aluno e c�digo de curso. *
--************************************************************************************
create or replace procedure proc_inserir_frequentar(
       p_codigo    tbl_frequentar.codigo%type,
       p_cod_aluno tbl_frequentar.cod_aluno%type,
       p_cod_curso tbl_frequentar.cod_curso%type
) is

begin
     set transaction read write name 'inserir frequentar';
     insert into tbl_frequentar values(p_codigo, p_cod_aluno, p_cod_curso);
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20022, 'falha a introduzir frequentar');
end proc_inserir_frequentar;
/
