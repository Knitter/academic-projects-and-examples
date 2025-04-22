--****************************************************************************************
--* Procedimento para criar hórarios de gabinete de docentes na tabela Horario_Gabinete. *
--****************************************************************************************
create or replace procedure proc_inserir_horario_gabinete(p_cod_docente tbl_horario_gabinete.cod_docente%type,
       p_hora_inicio varchar2, p_hora_fim varchar2, p_dia_semana varchar2
)is

begin
     set transaction read write name 'inserir horario gabinete';
     insert into tbl_horario_gabinete values(p_cod_docente, to_date(p_hora_inicio, 'HH24:MI'), to_date(p_hora_fim, 'HH24:MI'), p_dia_semana);
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20014, 'falha na insercao de horario de gabinete');
end proc_inserir_horario_gabinete;
/
