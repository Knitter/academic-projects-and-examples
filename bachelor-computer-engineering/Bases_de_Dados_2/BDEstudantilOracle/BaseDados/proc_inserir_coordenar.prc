--*********************************************************************************************************
--* Procedimeto que permite a introdução de dados na tabela Coordenar.                                    *
--* Parâmetros de entrada: ano civil, código do docente, código de departamento, data de início e de fim. *
--*********************************************************************************************************
create or replace procedure proc_inserir_coordenar(
       p_ano_civil        tbl_coordenar.ano_civil%type,
       p_cod_docente      tbl_coordenar.cod_docente%type,
       p_cod_departamento tbl_coordenar.cod_departamento%type,
       p_data_fim         tbl_coordenar.data_fim%type,
       p_data_inicio      tbl_coordenar.data_inicio%type
)is

begin
     set transaction read write name 'inserir coordenar';
     insert into tbl_coordenar values(p_ano_civil, p_cod_docente, p_cod_departamento, p_data_fim, p_data_inicio);
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20024, 'falha na introducao de coordenar');
end proc_inserir_coordenar;
/
