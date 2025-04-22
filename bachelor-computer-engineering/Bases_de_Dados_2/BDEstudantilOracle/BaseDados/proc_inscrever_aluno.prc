--**************************************************************************************
--* Procedimento que permite introduzir dados na tabela Inscrever.                     *
--* Parâmetros de entrada: código do aluno, código da disciplina, código da instância, * 
--* número de faltas, notas teoricas e praticas de frequência e exame.                 *
--************************************************************************************** 
create or replace procedure proc_inscrever_aluno(p_cod_aluno tbl_inscrever.cod_aluno%type, 
       p_cod_disciplina tbl_inscrever.cod_disciplina%type, p_cod_instancia tbl_inscrever.cod_instancia%type,
       p_num_faltas tbl_inscrever.num_faltas%type, p_teo_recurso tbl_inscrever.teo_recurso%type,
       p_teo_especial tbl_inscrever.teo_especial%type, p_teo_exame tbl_inscrever.teo_exame%type,
       p_teo_frequencia tbl_inscrever.teo_frequencia%type, p_pra_frequencia tbl_inscrever.pra_frequencia%type,
       p_trabalho tbl_inscrever.trabalho%type
) is

begin
     set transaction read write name 'inserir inscrever';
     insert into tbl_inscrever values(0, p_num_faltas, p_teo_recurso, p_teo_especial, p_teo_exame, p_teo_frequencia, 
     p_pra_frequencia, p_trabalho, p_cod_aluno, p_cod_disciplina, p_cod_instancia);
     commit;

exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20020, 'falha a introduzir inscrever'); 
end proc_inscrever_aluno;
/
