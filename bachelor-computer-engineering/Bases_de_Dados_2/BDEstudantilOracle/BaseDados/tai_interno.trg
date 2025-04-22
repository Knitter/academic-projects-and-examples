--**********************************************************************************************************
--* Trigger que permite garantir a participação obrigatória de um interno nas tabelas Funcionario ou Aluno *
--**********************************************************************************************************
create or replace trigger tai_interno
  after insert on tbl_interno  
  for each row
declare
  v_tipo_funcionario tbl_funcionario.tipo%type;
begin
     if :new.tipo = 'A' then
        insert into tbl_aluno values(:new.cod_interno, 0, 'N', 1, 'asdf', 'asdf', 0);
     else
         if :new.tipo_funcionario = 1 then
            v_tipo_funcionario := 'D';
         else 
            v_tipo_funcionario := 'N';
         end if; 
         insert into tbl_funcionario values(:new.cod_interno, 0, 'asdf', v_tipo_funcionario);
     end if;
end tai_interno;
/
