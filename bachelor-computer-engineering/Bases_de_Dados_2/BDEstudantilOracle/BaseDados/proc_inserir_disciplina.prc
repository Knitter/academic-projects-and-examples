--************************************************************************************
--* Procedimento que permite inserir dados na tabela disciplina.                     *
--* Parâmetros de entrada: duração semanal teórica, prática e teórico-prática,       *
--* nome da disciplina, número limite de faltasm, código de curso e de departamento. *
--************************************************************************************
create or replace procedure proc_inserir_disciplina(
       p_duracao_sem_teo      tbl_disciplina.duracao_sem_teo%type,
       p_duracao_sem_prat     tbl_disciplina.duracao_sem_prat%type,
       p_duracao_sem_teo_prat tbl_disciplina.duracao_sem_teo_prat%type,
       p_limite_faltas        tbl_disciplina.limite_faltas%type,
       p_nome_disciplina      tbl_disciplina.nome_disciplina%type,
       p_cod_curso            tbl_disciplina.cod_curso%type,
       p_cod_departamento     tbl_disciplina.cod_departamento%type
) is
begin
     set transaction read write name 'inserir disciplina';
     insert into tbl_disciplina values(
            0,
            p_duracao_sem_teo,
            p_duracao_sem_prat,
            p_duracao_sem_teo_prat,
            p_limite_faltas,
            p_nome_disciplina,
            p_cod_curso,
            p_cod_departamento
     );
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20024, 'falha na introducao de disciplina');
end proc_inserir_disciplina;
/
