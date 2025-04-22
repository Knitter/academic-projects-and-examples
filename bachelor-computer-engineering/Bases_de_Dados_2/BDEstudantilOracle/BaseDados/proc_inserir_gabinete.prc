--*********************************************************************
--* Procedimento que permite introduzir gabinetes na tabela Gabinete. *
--* Par�metros de entrada: lota��o do gabinete.                       *
--* A chave � atribu�da atrav�s de triggers.                          *
--********************************************************************* 
create or replace procedure proc_inserir_gabinete(
       p_lotacao tbl_gabinete.lotacao%type
) is

begin
     set transaction read write name 'inserir gabinete';
     insert into tbl_gabinete values(0, p_lotacao);
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20021, 'falha a introduzir gabinte');
end proc_inserir_gabinete;
/
