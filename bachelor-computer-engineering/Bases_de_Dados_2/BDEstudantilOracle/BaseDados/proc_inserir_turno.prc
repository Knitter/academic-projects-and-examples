--*******************************************************************************
--* Procedimento para introdus«zir turnos na tabela Turno.                      *
--* Parâmnetros de entrada: código da disciplina, código da                     *
--* instância, número do turno, dia da semana, hora de ínicio e de fim do turno *
--*******************************************************************************
create or replace procedure proc_inserir_turno(
       p_cod_disciplina tbl_turno.cod_disciplina%type,
       p_cod_instancia  tbl_turno.cod_instancia%type,
       p_num_turno      tbl_turno.num_turno%type,
       p_dia_semana     tbl_turno.dia_semana%type,
       p_hora_inicio    tbl_turno.hora_inicio%type,
       p_hora_fim       tbl_turno.hora_fim%type,
       p_cod_docente    tbl_turno.cod_docente%type
) is
begin
     set transaction read write name 'inserir turno';
     insert into tbl_turno values(p_cod_disciplina, p_cod_instancia, p_num_turno, p_dia_semana, 
     p_hora_inicio, p_hora_fim, p_cod_docente);
     commit;
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20012, 'falha ao introduzor turno');
end proc_inserir_turno;
/
