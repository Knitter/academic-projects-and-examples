create or replace package pkg_sequences is

  function proximo_cod_interno return number;
  function proximo_cod_curso return number;
  function proximo_num_aluno return number;
  function proximo_cod_departamento return number;
  function proximo_num_docente return number;
  function proximo_cod_disciplina return number;
  function proximo_cod_instancia return number;
  function proximo_cod_funcao return number;
  function proximo_cod_gabinete return number;
  function proximo_cod_percentagem return number;
  function proximo_cod_ano_lectivo return number;
  function proximo_cod_inscrever return number;

end pkg_sequences;
/
create or replace package body pkg_sequences is

  function proximo_cod_interno return number is
  nextv number;
  begin
       select seq_cod_interno.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_interno;

  function proximo_cod_curso return number is
  nextv number;
  begin
       select seq_cod_curso.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_curso;

  function proximo_num_aluno return number is
  nextv number;
  begin
       select seq_num_aluno.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_num_aluno;

  function proximo_cod_departamento return number is
  nextv number;
  begin
       select seq_cod_departamento.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_departamento;

  function proximo_num_docente return number is
  nextv number;
  begin
       select seq_num_docente.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_num_docente;

  function proximo_cod_disciplina return number is
  nextv number;
  begin
       select seq_cod_disciplina.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_disciplina;

  function proximo_cod_instancia return number is
  nextv number;
  begin
       select seq_cod_instancia.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_instancia;

  function proximo_cod_funcao return number is
  nextv number;
  begin
       select seq_cod_funcao.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_funcao;

  function proximo_cod_gabinete return number is
  nextv number;
  begin
       select seq_cod_gabinete.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_gabinete;

  function proximo_cod_percentagem return number is
  nextv number;
  begin
       select seq_cod_percentagem.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_percentagem;

  function proximo_cod_ano_lectivo return number is
  nextv number;
  begin
       select seq_cod_ano_lectivo.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_ano_lectivo;

  function proximo_cod_inscrever return number is
  nextv number;
  begin
       select seq_cod_inscrever.nextval
       into nextv
       from dual;
       return nextv;
  end proximo_cod_inscrever;
end pkg_sequences;
/
