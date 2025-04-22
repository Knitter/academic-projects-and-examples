@@ apagar_indices.sql;

--***************************************************************************
--* Índice criado para acelerar as consultas á tabela Aluno baseadas no ano *
--***************************************************************************
create index idx_aluno_ano                   on tbl_aluno (ano);

--******************************************************************************************
--* Índice criado para acelerar as consultas á tabela Caber baseadas no código de gabinete *
--******************************************************************************************
create index idx_caber_cod_gabinete          on tbl_caber (cod_gabinete);

--************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Contactavel baseadas no número da extensão *
--************************************************************************************************
create index idx_contactavel_numero          on tbl_contactavel (numero);

--*******************************************************************************************
--* Índice criado para acelerar as consultas á tabela Conter baseadas no código de gabinete *
--*******************************************************************************************
create index idx_conter_cod_gabinete         on tbl_conter (cod_gabinete);

--********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Disciplina baseadas no código de curso *
--********************************************************************************************
create index idx_disciplina_cod_curso        on tbl_disciplina (cod_curso);

--**************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Disciplina baseadas no código de departamento*
--**************************************************************************************************
create index idx_disciplina_cod_dep          on tbl_disciplina (cod_departamento);

--********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Docente baseadas no código de gabinete *
--********************************************************************************************
create index idx_docente_cod_gabinete        on tbl_docente (cod_gabinete);

--********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Docente baseadas no número da extensão *
--********************************************************************************************
create index idx_docente_numero              on tbl_docente(numero);

--************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Docente baseadas no código do departamento *
--************************************************************************************************
create index idx_docente_cod_departamento    on tbl_docente (cod_departamento);

--***************************************************************************************
--* Índice criado para acelerar as consultas á tabela Funcao baseadas no nome da função *
--***************************************************************************************
create index idx_funcao_nome                 on tbl_funcao (nome);

--********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas no número de faltas *
--********************************************************************************************
create index idx_inscrever_num_faltas        on tbl_inscrever (num_faltas);

--****************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota teórica por recurso *
--****************************************************************************************************
create index idx_inscrever_teo_recurso       on tbl_inscrever (teo_recurso);

--**********************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota teórica em época especial *
--**********************************************************************************************************
create index idx_inscrever_teo_especial      on tbl_inscrever (teo_especial);

--**************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota teórica por exame *
--**************************************************************************************************
create index idx_inscrever_teo_exame         on tbl_inscrever (teo_exame);

--*******************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota teórica por frequência *
--*******************************************************************************************************
create index idx_inscrever_teo_frequencia    on tbl_inscrever (teo_frequencia);

--*******************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota prática por frequência *
--*******************************************************************************************************
create index idx_inscrever_pra_frequencia    on tbl_inscrever (pra_frequencia);

--********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Inscrever baseadas na nota do trabalho *
--********************************************************************************************
create index idx_inscrever_trabalho          on tbl_inscrever (trabalho);

--************************************************************************************
--* Índice criado para acelerar as consultas á tabela Interno baseadas na localidade *
--************************************************************************************
create index idx_interno_localidade          on tbl_interno (localidade);

--***************************************************************************************
--* Índice criado para acelerar as consultas á tabela Interno baseadas no código postal *
--***************************************************************************************
create index idx_interno_cod_postal          on tbl_interno (cod_postal);

--**********************************************************************************************
--* Índice criado para acelerar as consultas á tabela Nao_Docente baseadas no código de função *
--**********************************************************************************************
create index idx_nao_docente_cod_funcao      on tbl_nao_docente (cod_funcao);

--**************************************************************************************************
--* Índice criado para acelerar as consultas á tabela Pertencer baseadas no código de departamento *
--**************************************************************************************************
create index idx_pertencer_cod_departamento  on tbl_pertencer (cod_departamento);

--*************************************************************************************
--* Índice criado para acelerar as consultas á tabela Turno baseadas no dia de semana *
--*************************************************************************************
create index idx_turno_dia_semana            on tbl_turno (dia_semana);

--**************************************************************************************
--* Índice criado para acelerar as consultas á tabela Turno baseadas na hora de ínicio *
--**************************************************************************************
create index idx_turno_hora_inicio           on tbl_turno (hora_inicio);

--***********************************************************************************
--* Índice criado para acelerar as consultas á tabela Turno baseadas na hora de fim *
--***********************************************************************************
create index idx_turno_hora_fim              on tbl_turno (hora_fim);

--*****************************************************************************************
--* Índice criado para acelerar as consultas á tabela Turno baseadas no código de docente *
--*****************************************************************************************
create index idx_turno_cod_docente           on tbl_turno (cod_docente);