--**********************************************************************************
--* Trigger que permite introduzir o valor da chave primária na tabela Inscrever e * 
--* verificar se um aluno reprovou por faltas                                      *
--**********************************************************************************
create or replace trigger tbiu_inscrever
  before insert on tbl_inscrever  
  for each row
declare
  limite integer;
begin
     if inserting then
        :new.cod_inscrever := pkg_sequences.proximo_cod_inscrever;
     else
         select limite_faltas
         into limite
         from tbl_disciplina, tbl_instancia
         where :new.cod_instancia = tbl_instancia.cod_instancia and tbl_instancia.cod_disciplina = tbl_disciplina.cod_disciplina;
    
         if :new.num_faltas > limite then
            :new.teo_frequencia := 0;
            :new.pra_frequencia := 0;   
         end if;
      end if;
end tbiu_inscrever;
/
