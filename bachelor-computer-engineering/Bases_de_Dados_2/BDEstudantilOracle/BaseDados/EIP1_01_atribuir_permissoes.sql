--permissoes do utilizador definido por administrador usando a conta TESTE_01
--consulta
grant select on tbl_caber to teste_01;
grant select on tbl_colocar to teste_01;
grant select on tbl_contactavel to teste_01;
grant select on tbl_conter to teste_01;
grant select on tbl_coordenar to teste_01;
grant select on tbl_dirigir to teste_01;
grant select on tbl_horario_gabinete to teste_01;
grant select on tbl_nao_docente to teste_01;
grant select on tbl_pertencer to teste_01;
grant select on tbl_turno to teste_01;
grant select on tbl_instancia to teste_01;
grant select on tbl_inscrever to teste_01;
grant select on tbl_frequentar to teste_01;
grant select on tbl_docente to teste_01;
grant select on tbl_gabinete to teste_01;
grant select on tbl_telefone_interno to teste_01;
grant select on tbl_aluno to teste_01;
grant select on tbl_disciplina to teste_01;
grant select on tbl_funcionario to teste_01;
grant select on tbl_percentagem to teste_01;
grant select on tbl_interno to teste_01;
grant select on tbl_funcao to teste_01;
grant select on tbl_extensao to teste_01;
grant select on tbl_curso to teste_01;
grant select on tbl_departamento to teste_01;
grant select on tbl_ano_lectivo to teste_01;
grant select on tbl_ano_civil to teste_01;

--actualizacao
grant update on tbl_caber to teste_01;
grant update on tbl_colocar to teste_01;
grant update on tbl_contactavel to teste_01;
grant update on tbl_conter to teste_01;
grant update on tbl_coordenar to teste_01;
grant update on tbl_dirigir to teste_01;
grant update on tbl_horario_gabinete to teste_01;
grant update on tbl_nao_docente to teste_01;
grant update on tbl_pertencer to teste_01;
grant update on tbl_turno to teste_01;
grant update on tbl_instancia to teste_01;
grant update on tbl_inscrever to teste_01;
grant update on tbl_frequentar to teste_01;
grant update on tbl_docente to teste_01;
grant update on tbl_gabinete to teste_01;
grant update on tbl_telefone_interno to teste_01;
grant update on tbl_aluno to teste_01;
grant update on tbl_disciplina to teste_01;
grant update on tbl_funcionario to teste_01;
grant update on tbl_percentagem to teste_01;
grant update on tbl_interno to teste_01;
grant update on tbl_funcao to teste_01;
grant update on tbl_extensao to teste_01;
grant update on tbl_curso to teste_01;
grant update on tbl_departamento to teste_01;
grant update on tbl_ano_lectivo to teste_01;
grant update on tbl_ano_civil to teste_01;

--insercao
grant execute on proc_inserir_contactavel to teste_01;
grant execute on proc_inserir_extensao to teste_01;
grant execute on proc_inserir_funcao to teste_01;
grant execute on proc_inserir_gabinete to teste_01;
grant execute on proc_inserir_nao_docente to teste_01;

--permissoes do utilizador definido por administrativo usando a conta TESTE_02
--consulta
grant select on tbl_caber to teste_02;
grant select on tbl_colocar to teste_02;
grant select on tbl_contactavel to teste_02;
grant select on tbl_conter to teste_02;
grant select on tbl_coordenar to teste_02;
grant select on tbl_dirigir to teste_02;
grant select on tbl_horario_gabinete to teste_02;
grant select on tbl_nao_docente to teste_02;
grant select on tbl_pertencer to teste_02;
grant select on tbl_turno to teste_02;
grant select on tbl_instancia to teste_02;
grant select on tbl_inscrever to teste_02;
grant select on tbl_frequentar to teste_02;
grant select on tbl_docente to teste_02;
grant select on tbl_gabinete to teste_02;
grant select on tbl_telefone_interno to teste_02;
grant select on tbl_aluno to teste_02;
grant select on tbl_disciplina to teste_02;
grant select on tbl_funcionario to teste_02;
grant select on tbl_percentagem to teste_02;
grant select on tbl_interno to teste_02;
grant select on tbl_funcao to teste_02;
grant select on tbl_extensao to teste_02;
grant select on tbl_curso to teste_02;
grant select on tbl_departamento to teste_02;
grant select on tbl_ano_lectivo to teste_02;
grant select on tbl_ano_civil to teste_02;

--actualizacao
grant update on tbl_caber to teste_02;
grant update on tbl_colocar to teste_02;
grant update on tbl_contactavel to teste_02;
grant update on tbl_conter to teste_02;
grant update on tbl_coordenar to teste_02;
grant update on tbl_dirigir to teste_02;
grant update on tbl_nao_docente to teste_02;
grant update on tbl_pertencer to teste_02;
grant update on tbl_instancia to teste_02;
grant update on tbl_inscrever to teste_02;
grant update on tbl_frequentar to teste_02;
grant update on tbl_docente to teste_02;
grant update on tbl_gabinete to teste_02;
grant update on tbl_telefone_interno to teste_02;
grant update on tbl_aluno to teste_02;
grant update on tbl_disciplina to teste_02;
grant update on tbl_funcionario to teste_02;
grant update on tbl_interno to teste_02;
grant update on tbl_funcao to teste_02;
grant update on tbl_extensao to teste_02;
grant update on tbl_curso to teste_02;
grant update on tbl_departamento to teste_02;
grant update on tbl_ano_lectivo to teste_02;
grant update on tbl_ano_civil to teste_02;

--insercao
grant execute on proc_atribuir_gab_contactavel to teste_02;
grant execute on proc_inserir_colocar to teste_02;
grant execute on proc_inserir_contactavel to teste_02;
grant execute on proc_inserir_conter to teste_02;
grant execute on proc_inserir_coordenar to teste_02;
grant execute on proc_inserir_dirigir to teste_02;
grant execute on proc_inserir_nao_docente to teste_02;
grant execute on proc_inserir_pertencer to teste_02;
grant execute on proc_criar_instancia to teste_02;
grant execute on proc_inscrever_aluno to teste_02;
grant execute on proc_inserir_frequentar to teste_02;
grant execute on proc_inserir_docente to teste_02;
grant execute on tbl_telefone_interno to teste_02;
grant execute on proc_inserir_aluno to teste_02;
grant execute on proc_inserir_disciplina to teste_02;
grant execute on proc_inserir_curso to teste_02;
grant execute on proc_inserir_departamento to teste_02;
grant execute on proc_inserir_ano_lectivo to teste_02;
grant execute on proc_inserir_ano_civil to teste_02;

--permissoes do utilizador definido por aluno usando a conta TESTE_03
--consulta
grant select on tbl_aluno to teste_03;
grant select on tbl_ano_lectivo to teste_03;
grant select on tbl_colocar to teste_03;
grant select on tbl_curso to teste_03;
grant select on tbl_departamento to teste_03;
grant select on tbl_disciplina to teste_03;
grant select on tbl_frequentar to teste_03;
grant select on tbl_horario_gabinete to teste_03;
grant select on tbl_inscrever to teste_03;
grant select on tbl_interno to teste_03;
grant select on tbl_instancia to teste_03;
grant select on tbl_telefone_interno to teste_03;
grant select on tbl_turno to teste_03;

--actualizacao
grant update on tbl_turno to teste_03;

--insercao
grant execute on proc_inserir_turno to teste_03;

--permissoes do utilizador definido por docente usando a conta TESTE_04
--consulta
grant select on tbl_caber to teste_04;
grant select on tbl_colocar to teste_04;
grant select on tbl_contactavel to teste_04;
grant select on tbl_conter to teste_04;
grant select on tbl_coordenar to teste_04;
grant select on tbl_dirigir to teste_04;
grant select on tbl_horario_gabinete to teste_04;
grant select on tbl_nao_docente to teste_04;
grant select on tbl_pertencer to teste_04;
grant select on tbl_turno to teste_04;
grant select on tbl_instancia to teste_04;
grant select on tbl_inscrever to teste_04;
grant select on tbl_frequentar to teste_04;
grant select on tbl_docente to teste_04;
grant select on tbl_gabinete to teste_04;
grant select on tbl_telefone_interno to teste_04;
grant select on tbl_aluno to teste_04;
grant select on tbl_disciplina to teste_04;
grant select on tbl_funcionario to teste_04;
grant select on tbl_percentagem to teste_04;
grant select on tbl_interno to teste_04;
grant select on tbl_funcao to teste_04;
grant select on tbl_extensao to teste_04;
grant select on tbl_curso to teste_04;
grant select on tbl_departamento to teste_04;
grant select on tbl_ano_lectivo to teste_04;
grant select on tbl_ano_civil to teste_04;

--actualizacao
grant update on tbl_turno to teste_04;

--insercao
grant execute on proc_inserir_horario_gabinete to teste_04;
grant execute on proc_inserir_percentagem to teste_04;
grant execute on proc_inserir_turno to teste_04;

--permissoes do utilizador definido por externo usando a conta TESTE_05
--consulta
grant select on v_curso to teste_05;
grant select on v_departamento to teste_05;
grant select on tbl_disciplina to teste_05;

--permissoes do utilizador definido por funcionario nao administrativo usando a conta TESTE_06
--consulta
grant select on tbl_extensao to teste_06;
grant select on tbl_funcao to teste_06;
grant select on tbl_funcionario to teste_06;
grant select on tbl_interno to teste_06;
grant select on tbl_nao_docente to teste_06;
grant select on tbl_telefone_interno to teste_06;
