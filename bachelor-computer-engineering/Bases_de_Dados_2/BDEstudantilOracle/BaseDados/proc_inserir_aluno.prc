--*************************************************************************
--* Procedimeto que permite introduzir dados do aluno.                    *
--* A chave é introduzida através de triggers e provém da tabela Interno. *
--*************************************************************************
create or replace procedure proc_inserir_aluno( p_nib tbl_interno.nib%type, p_bi tbl_interno.bi%type,
       p_grau_academico tbl_interno.grau_academico%type, p_num_contribuinte tbl_interno.num_contribuinte%type,
       p_data_entrada varchar2, p_pag_pessoal tbl_interno.pag_pessoal%type,
       p_data_nascimento varchar2, p_localidade tbl_interno.localidade%type, p_endereco tbl_interno.endereco%type, p_cod_postal tbl_interno.cod_postal%type,
       p_p_nome tbl_interno.p_nome%type, p_nomes_meio tbl_interno.nomes_meio%type, p_apelido tbl_interno.apelido%type,
       p_sexo tbl_interno.sexo%type, p_mail tbl_interno.mail%type, p_telefone tbl_interno.telefone%type,
       p_fotografia tbl_interno.fotografia%type, p_trabalhador tbl_aluno.trabalhador%type, p_ano tbl_aluno.ano%type,
	     p_naturalidade tbl_aluno.naturalidade%type, p_nacionalidade tbl_aluno.nacionalidade%type, p_num_matriculas tbl_aluno.num_matriculas%type
       ) is

v_cod_interno tbl_interno.cod_interno%type;

begin
  set transaction read write name 'inserir aluno';
  
  insert into tbl_interno values (0, p_nib, p_bi, p_grau_academico, p_num_contribuinte, to_date(p_data_entrada, 'DD-MM-YYYY'), p_pag_pessoal, to_date(p_data_nascimento, 'DD-MM-YYYY'), 
  p_localidade, p_endereco, p_cod_postal, p_p_nome, p_nomes_meio, p_apelido, p_sexo, p_mail, p_telefone, 'A', p_fotografia, 0)
  return cod_interno into v_cod_interno;
  
  update tbl_aluno
  set trabalhador = p_trabalhador, ano = p_ano,
    naturalidade = p_naturalidade, nacionalidade = p_nacionalidade,
    num_matriculas = p_num_matriculas
  where cod_aluno = v_cod_interno;
  commit;

exception
         when others then 
         raise_application_error(-20001, 'erro na introducao do aluno');
         dbms_output.put_line(SQLERRM);
         rollback;
end proc_inserir_aluno;
/
