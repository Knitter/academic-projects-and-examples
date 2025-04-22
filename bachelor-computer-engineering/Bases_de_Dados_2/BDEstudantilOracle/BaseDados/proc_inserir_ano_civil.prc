--********************************************************************
--* Procedimento para introdução de dados na tabela Ano_Civil.       *
--* A chave da tabela é dada pelo valor do parâmetro de entrada ano. *
--********************************************************************
create or replace procedure proc_inserir_ano_civil(p_ano tbl_ano_civil.ano%type) is
begin
	   set transaction read write name 'inserir ano civil';	
     insert into tbl_ano_civil values(p_ano);
     commit;

exception 
          when others then
               dbms_output.put_line(SQLERRM);
               rollback;
               raise_application_error(-20016, 'falha na introducao de ano civil');
end proc_inserir_ano_civil;
/
