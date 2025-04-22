--************************************************************************************************
--* Procedimento que permite inserir dados na tabela Percentagem.                                *
--* Parâmetros de entrada: peso da nota teórica, peso da nota prática, peso da nota do trabalho. *
--************************************************************************************************
create or replace procedure proc_inserir_percentagem (p_peso_teorica tbl_percentagem.peso_teorica%type,
       p_peso_pratica tbl_percentagem.peso_pratica%type, p_peso_trabalho tbl_percentagem.peso_trabalho%type
) is

begin 
      set transaction read write name 'inserir percentagem';
      insert into tbl_percentagem values (0, p_peso_teorica, p_peso_pratica, p_peso_trabalho); 
      commit;
  
exception
         when others then
              dbms_output.put_line(SQLERRM);
              raise_application_error(-20005, 'falha na introducao de dados na tabela percentagem');
              rollback;
end proc_inserir_percentagem;
/
