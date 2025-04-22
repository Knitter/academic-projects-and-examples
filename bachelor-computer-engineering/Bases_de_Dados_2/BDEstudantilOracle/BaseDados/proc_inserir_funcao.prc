--****************************************************************
--* Procedimeto que permite introduzir dados na tabela funcao.   *
--* Parâmetros de entrada: nome da função e descrição da função. *
--****************************************************************
create or replace procedure proc_inserir_funcao(p_nome tbl_funcao.nome%type,
       p_descricao tbl_funcao.descricao%type
) is

begin
     set transaction read write name 'inserir funcao';
     insert into tbl_funcao values (0, p_nome, p_descricao);
     commit;
     
exception
         when others then
              dbms_output.put_line(SQLERRM);
              rollback;
              raise_application_error(-20006, 'falha a introduzir a funcao');
end proc_inserir_funcao;
/
