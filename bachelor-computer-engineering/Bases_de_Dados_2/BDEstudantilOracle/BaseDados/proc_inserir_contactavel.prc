--*********************************************************************
--* Procedimento que permite introduzir dados na tabela Contactavel   *
--* Parâmetros de entrada: código do contactável e número da extensão *
--*********************************************************************
create or replace procedure proc_inserir_contactavel(
       p_cod_contactavel tbl_contactavel.cod_contactavel%type,
       p_numero          tbl_contactavel.numero%type
) is
begin
     set transaction read write name 'inserir contactavel';
     insert into tbl_contactavel values(p_cod_contactavel, p_numero);
     commit;
exception 
          when others then
               dbms_output.put_line(SQLERRM);
               rollback;
               raise_application_error(-20009, 'falha a inserir contactavel');
end proc_inserir_contactavel;
/
