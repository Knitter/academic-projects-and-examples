--***********************************************************************************************
--* Procedimento que permite criar uma inst�ncia de disciplina                                  *
--* Par�metros de entrada: c�digo da disciplina, c�digo da percentagem, e c�digo do ano lectivo *
--* O valor da chave � atribuido atrav�s de triggers                                            *
--***********************************************************************************************
create or replace procedure proc_criar_instancia(p_cod_disciplina tbl_instancia.cod_disciplina%type,
       p_cod_percentagem tbl_instancia.cod_percentagem%type, p_codigo tbl_instancia.codigo%type
) is

begin 
      set transaction read write name 'inserir instancia';
      insert into tbl_instancia values(p_cod_disciplina, 0, p_cod_percentagem, p_codigo);  
      commit;
  
exception 
          when others then
               dbms_output.put_line(SQLERRM);
               rollback;
               raise_application_error(-20019, 'falha na introducao de instancia');
end proc_criar_instancia;
/
