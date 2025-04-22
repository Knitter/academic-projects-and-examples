create or replace procedure proc_inserir_foto(p_nome_dir in varchar2, p_nome_foto in varchar2, 
       p_tabela in varchar2, p_nome_blob in varchar2, p_nome_campo in varchar2, p_valor in varchar2)
AS

v_src_bfile BFILE;
v_dst_blob BLOB;
v_sql_string varchar2(200);

begin 
      v_sql_string := 'select ' || p_nome_blob || 'from' || p_tabela || 'where' ||
			                p_nome_campo || '=' || p_valor;
                      
execute immediate v_sql_string into v_dst_blob;

v_src_bfile := bfilename(p_nome_dir, p_nome_foto);
dbms_lob.fileopen(v_src_bfile, dbms_lob.file_readonly);
dbms_lob.loadfromfile(v_dst_blob, v_src_bfile, dbms_lob.getlength(v_src_bfile));
dbms_lob.fileClose(v_src_bfile);

exception 
	when others then
		raise_application_error(-20030, 'falha inserir foto');
		rollback;
end;
/
