--**********************************************************************************
--* Procedimento para introduzir ano lectivo na tabela Ano_Lectivo.                *
--* Parâmetros de entrada: designação do ano lectivo, data de início, data de fim. *
--* A chave da tabela é atribuida através de triggers                              *
--**********************************************************************************
create or replace procedure proc_inserir_ano_lectivo ( p_designacao tbl_ano_lectivo.designacao%type,
       p_data_inicio tbl_ano_lectivo.data_inicio%type, p_data_fim tbl_ano_lectivo.data_fim%type
) is 

begin
     set transaction read write name 'inserir ano lectivo';
     insert into tbl_ano_lectivo values (0, p_designacao, p_data_inicio, p_data_fim);  
     commit;
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20015, 'falha na introducao de ano lectivo');
end proc_inserir_ano_lectivo;
/
