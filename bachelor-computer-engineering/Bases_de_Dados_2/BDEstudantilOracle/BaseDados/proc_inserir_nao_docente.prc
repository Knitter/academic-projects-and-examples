--******************************************************************************************************************
--* Procedimento que permite introduzir dados na tabela Nao_Docente.                                               *
--* Parâmetros de entrada: número de identificação bancária, número de BI, grau académico, número de contribuinte, *
--* data de entrada na instituição, página pessoal, data de nascimento, localidade, endereço, código postal,       *
--* nome completo (primeiro nome, nomes do meio e apelido), sexo, endereço de correio electrónico, telefone,       *
--* fotografia, código da função desempenhada, indicação de contactável, ordenado, número de segurança social.     *
--******************************************************************************************************************
create or replace procedure proc_inserir_nao_docente(
       p_nib              tbl_interno.nib%type,
       p_bi               tbl_interno.bi%type,
       p_grau_academico   tbl_interno.grau_academico%type,
       p_num_contribuinte tbl_interno.num_contribuinte%type,
       p_data_entrada     tbl_interno.data_entrada%type,
       p_pag_pessoal      tbl_interno.pag_pessoal%type,
       p_data_nascimento  tbl_interno.data_nascimento%type,
       p_localidade       tbl_interno.localidade%type,
       p_endereco         tbl_interno.endereco%type,
       p_cod_postal       tbl_interno.cod_postal%type,
       p_nome             tbl_interno.p_nome%type,
       p_nomes_meio       tbl_interno.nomes_meio%type,
       p_apelido          tbl_interno.apelido%type,
       p_sexo             tbl_interno.sexo%type,
       p_mail             tbl_interno.mail%type,
       p_telefone         tbl_interno.telefone%type,
       p_fotografia       tbl_interno.fotografia%type,
       p_cod_funcao       tbl_nao_docente.cod_funcao%type,
       p_contactavel      tbl_nao_docente.contactavel%type,
       p_ordenado         tbl_funcionario.ordenado%type,
       p_seg_social       tbl_funcionario.num_seg_social%type
) is

v_cod_interno tbl_interno.cod_interno%type;

begin
     set transaction read write name 'inserir nao docente';
     insert into tbl_interno values(
            0,
            p_nib,
            p_bi,
            p_grau_academico,
            p_num_contribuinte,
            p_data_entrada,
            p_pag_pessoal,
            p_data_nascimento,
            p_localidade,
            p_endereco,
            p_cod_postal,
            p_nome,
            p_nomes_meio,
            p_apelido,
            p_sexo,
            p_mail,
            p_telefone,
            'F',
            p_fotografia,
            2
            )
     return cod_interno into v_cod_interno;
     
     update tbl_funcionario
     set ordenado = p_ordenado,
         num_seg_social = p_seg_social
     where
          cod_funcionario = v_cod_interno;
     
     update tbl_nao_docente
     set cod_funcao=p_cod_funcao,
         contactavel=p_contactavel
     where
         cod_nao_docente=v_cod_interno;
     commit;
     
exception
         when others then rollback;
         dbms_output.put_line(SQLERRM);
         raise_application_error(-20003, 'falha na introducao do nao docente');
end proc_inserir_nao_docente;
/
