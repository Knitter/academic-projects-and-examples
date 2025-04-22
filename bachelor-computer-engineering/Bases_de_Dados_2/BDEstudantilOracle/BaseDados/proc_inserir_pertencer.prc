--*******************************************************************
-- Procedimento que permite inserir dados na tabela Pertencer.      *
-- Par�metros de entrada: c�digo de curso e c�digo de departamento. *
--*******************************************************************
create or replace procedure proc_inserir_pertencer(p_cod_curso tbl_pertencer.cod_curso%type,
       p_cod_departamento tbl_pertencer.cod_departamento%type
) is

begin
     set transaction read write name 'inserir relacao pertencer'; 
     insert into tbl_pertencer values(p_cod_curso, p_cod_departamento);
     commit;
exception
         when others then
              dbms_output.put_line(SQLERRM);
              raise_application_error(-20004, 'falha na introdu��o de dados na tabela pertencer');
              rollback;  
end proc_inserir_pertencer;
/
