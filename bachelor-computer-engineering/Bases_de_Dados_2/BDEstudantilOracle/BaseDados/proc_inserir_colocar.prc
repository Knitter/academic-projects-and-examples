--************************************************************
--* Procedimento que permite inserir dados na tabela Colocar *
--************************************************************
create or replace procedure proc_inserir_colocar(
     p_cod_disciplina tbl_colocar.cod_disciplina%type,
     p_cod_instancia  tbl_colocar.cod_instancia%type,
     p_num_turno      tbl_colocar.num_turno%type,
     p_cod_aluno      tbl_colocar.cod_aluno%type
) is

begin
     set transaction read write name 'inserir dados em colocar';
     insert into tbl_colocar values(p_cod_disciplina, p_cod_instancia, p_num_turno, p_cod_aluno);
     commit;
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20011, 'falha a introduzir dados na tabela colocar');
end proc_inserir_colocar;
/
