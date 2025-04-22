--***************************************************************************************************
--* Procedimeto que permite introduzir dados na tabela dirigir.                                     *
--* Parâmetros de entrada: código de curso , código de docente, ano civil, data de início e de fim. *
--***************************************************************************************************
create or replace procedure proc_inserir_dirigir(p_cod_curso tbl_dirigir.cod_curso%type,
       p_cod_docente tbl_dirigir.cod_docente%type, p_ano_civil tbl_dirigir.ano_civil%type,
       p_data_inicio tbl_dirigir.data_inicio%type, p_data_fim tbl_dirigir.data_fim%type
) is

begin
     set transaction read write name 'inserir dirigente de curso';
     insert into tbl_dirigir values (p_cod_curso, p_cod_docente, p_ano_civil,	p_data_inicio, p_data_fim);
     commit;

exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20024, 'falha na introducao de dirigir');
end proc_inserir_dirigir;
/
