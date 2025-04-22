--*******************************************************************
--* Procedimento que permite introduzir n�meros na tabela extens�o. *
--* A chave da tabela � o pr�prio n�mero da extens�o.               *
--*******************************************************************
create or replace procedure proc_inserir_extensao(p_numero tbl_extensao.numero%type) is

begin
     set transaction read write name 'inserir extens�o';
     insert into tbl_extensao values (p_numero);
     commit;
     
exception 
          when others then
               dbms_output.put_line(SQLERRM);
               rollback;
               raise_application_error(-20010, 'falha a introduzir numeros de extensoes');
end proc_inserir_extensao;
/
