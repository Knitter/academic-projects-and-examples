--******************************************************************
--* Procedimento que permite introduzir valores na tabela Conter   *
--* Parâmetros de entrada: número da extensão e código do gabinete *
--******************************************************************
create or replace procedure proc_inserir_conter(
       p_numero        tbl_conter.numero%type,
       p_cod_gabinete  tbl_conter.cod_gabinete%type
) is

begin
     set transaction read write name 'inserir conter';
     insert into tbl_conter values(p_numero, p_cod_gabinete);
     commit;

exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20008, 'falha a introduzir dados na tabela conter');
end proc_inserir_conter;
/
