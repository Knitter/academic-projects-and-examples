--**********************************************************************************************
--* Trigger que permite validar a introdução de um docente com coordenador de um departamento. *
--**********************************************************************************************
create or replace trigger tbiu_coordenar
  before insert or update on tbl_coordenar  
  for each row
declare
  v_cod_docente number;
  e_dupla_coordenacao exception;
  e_coordenacao_antes_tempo exception;
begin
     v_cod_docente := 0;
     
     select cod_docente
     into v_cod_docente
     from tbl_coordenar
     where cod_docente = :new.cod_docente and data_fim is null;
     
     if v_cod_docente <> 0 then
        raise e_dupla_coordenacao;
     end if;
     
     v_cod_docente := 0;
        
     select cod_docente
     into v_cod_docente
     from tbl_coordenar
     where cod_docente = :new.cod_docente and cod_departamento = :new.cod_departamento and ano_civil = :new.ano_civil;
     
     if v_cod_docente <> 0 then
        raise e_coordenacao_antes_tempo;
     end if;
          
end tbiu_coordenar;
/
