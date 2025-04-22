--*************************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Departamento e *
-- colocar o campo calculado número de docentes a zero                                *
--*************************************************************************************
create or replace trigger tbi_departamento
  before insert on tbl_departamento  
  for each row

begin
     :new.cod_departamento:=pkg_sequences.proximo_cod_departamento;
     :new.num_docentes := 0;
end tbi_departamento;
/
