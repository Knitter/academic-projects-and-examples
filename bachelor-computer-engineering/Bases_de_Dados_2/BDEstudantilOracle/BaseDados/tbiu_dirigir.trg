--*************************************************************************************
--* Trigger que permite validar a introdução de um docente como director de um curso. *
--*************************************************************************************
create or replace trigger tbiu_dirigir
  before insert or update on tbl_dirigir  
  for each row
declare
       v_cod_docente number;
       e_dupla_direccao exception;
       e_direccao_antes_tempo exception;
begin
     v_cod_docente := 0;
     
     select cod_docente
     into v_cod_docente
     from tbl_dirigir
     where cod_docente = :new.cod_docente and data_fim is null;
     
     if v_cod_docente <> 0 then
        raise e_dupla_direccao;
     end if;
     
     v_cod_docente := 0;
        
     select cod_docente
     into v_cod_docente
     from tbl_dirigir
     where cod_docente = :new.cod_docente and cod_curso = :new.cod_curso and ano_civil = :new.ano_civil;
     
     if v_cod_docente <> 0 then
        raise e_direccao_antes_tempo;
     end if;
  
end tbiu_dirigir;
/
