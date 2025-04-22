--******************************************************************************************************************
--* Trigger que permite introduzir actualizar o valor do campo calculado número de docentes da tabela Departamento *
--******************************************************************************************************************
create or replace trigger taiud_pertencer
  after insert or update or delete on tbl_pertencer  
  for each row

begin
     if inserting then
        update tbl_departamento
        set num_docentes = num_docentes + 1
        where cod_departamento = :new.cod_departamento;
     elsif deleting then
        update tbl_departamento
        set num_docentes = num_docentes - 1
        where cod_departamento = :old.cod_departamento;
     else
        update tbl_departamento
        set num_docentes = num_docentes + 1
        where cod_departamento = :new.cod_departamento;
       
        update tbl_departamento
        set num_docentes = num_docentes - 1
        where cod_departamento = :old.cod_departamento;
     end if;
end taiud_pertencer;
/
