--******************************************************************************
--* Procedimento que permite atribuir um gabinete a um funcionário contactável *
--* Parâmetros de entrada: código do contactável e código do gabinete          *
--******************************************************************************
create or replace procedure proc_atribuir_gab_contactavel(
       p_cod_contactavel tbl_caber.cod_contactavel%type,
       p_cod_gabinete    tbl_caber.cod_gabinete%type
) is

begin
     set transaction read write name 'atribuir gabinete';
     insert into tbl_caber values(p_cod_contactavel, p_cod_gabinete);
     commit;

exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20018, 'falha a atribuir gabinete');
end proc_atribuir_gab_contactavel;
/
