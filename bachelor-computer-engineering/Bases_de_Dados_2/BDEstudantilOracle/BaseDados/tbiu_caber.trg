--********************************************************************************************
--* Trigger que valida a colocação de um funcionário não docente e contactável num gabinete. *
--********************************************************************************************
create or replace trigger tbiu_caber
  before insert or update on tbl_caber  
  for each row
declare
       v_lotacao_a number;
       v_lotacao_total number;
       v_lotacao_b number;
       e_lotacao_atingida exception;
begin
     select count(*)
     into v_lotacao_a
     from tbl_caber
     where cod_gabinete = :new.cod_gabinete;
     
     select count(*)
     into v_lotacao_b
     from tbl_docente
     where cod_gabinete = :new.cod_gabinete;
      
     select lotacao
     into v_lotacao_total
     from tbl_gabinete
     where cod_gabinete = :new.cod_gabinete;
        
     if v_lotacao_a + v_lotacao_b >= v_lotacao_total then
        raise e_lotacao_atingida;
     end if;      
end tbiu_caber;
/
