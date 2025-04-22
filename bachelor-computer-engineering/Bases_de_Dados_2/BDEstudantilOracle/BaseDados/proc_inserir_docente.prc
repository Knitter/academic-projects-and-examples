--*****************************************************************************
--* Procedimeto que permite introduzir dados do docente.                      *
--* A chave é introduzida através de triggers e provém da tabela Funcionario. *
--*****************************************************************************
create or replace procedure proc_inserir_docente(
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
       p_cacifo           tbl_docente.cacifo%type,
       p_cod_departamento tbl_docente.cod_departamento%type,
       p_cod_gabinete     tbl_docente.cod_gabinete%type,
       p_numero_extensao  tbl_docente.numero%type,
       p_ordenado         tbl_funcionario.ordenado%type,
       p_seg_social       tbl_funcionario.num_seg_social%type       
) is

v_cod_interno tbl_interno.cod_interno%type;

begin
     set transaction read write name 'inserir docente';
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
            1)
     return cod_interno into v_cod_interno;
     dbms_output.put_line('fez insert no interno');
     
     update tbl_funcionario
     set ordenado = p_ordenado,
         num_seg_social = p_seg_social
     where
          cod_funcionario = v_cod_interno;
     dbms_output.put_line('fez update ao funcionario');

     update tbl_docente
     set cacifo=p_cacifo,
         cod_departamento=p_cod_departamento,
         cod_gabinete=p_cod_gabinete,
         numero=p_numero_extensao
     where
          cod_docente=v_cod_interno;
     dbms_output.put_line('fez update ao docente');
       
     commit;

exception
         when others then rollback;
         dbms_output.put_line(SQLERRM);
         raise_application_error(-20002, 'erro na introducao do docente');
end proc_inserir_docente;            
/
