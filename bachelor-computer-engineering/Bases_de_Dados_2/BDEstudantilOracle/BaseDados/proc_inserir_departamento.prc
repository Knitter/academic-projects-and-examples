--*******************************************************************************************
--* Procedimento que permite introduzir dados do departamento na tabela Departamento        *
--* Par�metros de entrada: abreviatura do nome do departamento, designa��o do departamento. *
--* A chave prim�ria � atribuida atrav�s de triggers                                        *
--*******************************************************************************************
create or replace procedure proc_inserir_departamento(	p_abreviatura tbl_departamento.abreviatura%type,
       p_designacao tbl_departamento.designacao%type
) is

begin
     set transaction read write name 'inserir dapartamento';
     insert into tbl_departamento values(0, p_abreviatura, p_designacao, 0);
     commit;
     
exception 
          when others then
               dbms_output.put_line(SQLERRM);
               rollback;
               raise_application_error(-20007, 'falha a introduzir departamento');
end proc_inserir_departamento;
/
