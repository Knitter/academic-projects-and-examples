@@ apagar_indices.sql;

--***************************************************************************
--* �ndice criado para acelerar as consultas � tabela Aluno baseadas no ano *
--***************************************************************************
create index idx_aluno_ano                   on tbl_aluno (ano);

--******************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Caber baseadas no c�digo de gabinete *
--******************************************************************************************
create index idx_caber_cod_gabinete          on tbl_caber (cod_gabinete);

--************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Contactavel baseadas no n�mero da extens�o *
--************************************************************************************************
create index idx_contactavel_numero          on tbl_contactavel (numero);

--*******************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Conter baseadas no c�digo de gabinete *
--*******************************************************************************************
create index idx_conter_cod_gabinete         on tbl_conter (cod_gabinete);

--********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Disciplina baseadas no c�digo de curso *
--********************************************************************************************
create index idx_disciplina_cod_curso        on tbl_disciplina (cod_curso);

--**************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Disciplina baseadas no c�digo de departamento*
--**************************************************************************************************
create index idx_disciplina_cod_dep          on tbl_disciplina (cod_departamento);

--********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Docente baseadas no c�digo de gabinete *
--********************************************************************************************
create index idx_docente_cod_gabinete        on tbl_docente (cod_gabinete);

--********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Docente baseadas no n�mero da extens�o *
--********************************************************************************************
create index idx_docente_numero              on tbl_docente(numero);

--************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Docente baseadas no c�digo do departamento *
--************************************************************************************************
create index idx_docente_cod_departamento    on tbl_docente (cod_departamento);

--***************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Funcao baseadas no nome da fun��o *
--***************************************************************************************
create index idx_funcao_nome                 on tbl_funcao (nome);

--********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas no n�mero de faltas *
--********************************************************************************************
create index idx_inscrever_num_faltas        on tbl_inscrever (num_faltas);

--****************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota te�rica por recurso *
--****************************************************************************************************
create index idx_inscrever_teo_recurso       on tbl_inscrever (teo_recurso);

--**********************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota te�rica em �poca especial *
--**********************************************************************************************************
create index idx_inscrever_teo_especial      on tbl_inscrever (teo_especial);

--**************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota te�rica por exame *
--**************************************************************************************************
create index idx_inscrever_teo_exame         on tbl_inscrever (teo_exame);

--*******************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota te�rica por frequ�ncia *
--*******************************************************************************************************
create index idx_inscrever_teo_frequencia    on tbl_inscrever (teo_frequencia);

--*******************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota pr�tica por frequ�ncia *
--*******************************************************************************************************
create index idx_inscrever_pra_frequencia    on tbl_inscrever (pra_frequencia);

--********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Inscrever baseadas na nota do trabalho *
--********************************************************************************************
create index idx_inscrever_trabalho          on tbl_inscrever (trabalho);

--************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Interno baseadas na localidade *
--************************************************************************************
create index idx_interno_localidade          on tbl_interno (localidade);

--***************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Interno baseadas no c�digo postal *
--***************************************************************************************
create index idx_interno_cod_postal          on tbl_interno (cod_postal);

--**********************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Nao_Docente baseadas no c�digo de fun��o *
--**********************************************************************************************
create index idx_nao_docente_cod_funcao      on tbl_nao_docente (cod_funcao);

--**************************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Pertencer baseadas no c�digo de departamento *
--**************************************************************************************************
create index idx_pertencer_cod_departamento  on tbl_pertencer (cod_departamento);

--*************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Turno baseadas no dia de semana *
--*************************************************************************************
create index idx_turno_dia_semana            on tbl_turno (dia_semana);

--**************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Turno baseadas na hora de �nicio *
--**************************************************************************************
create index idx_turno_hora_inicio           on tbl_turno (hora_inicio);

--***********************************************************************************
--* �ndice criado para acelerar as consultas � tabela Turno baseadas na hora de fim *
--***********************************************************************************
create index idx_turno_hora_fim              on tbl_turno (hora_fim);

--*****************************************************************************************
--* �ndice criado para acelerar as consultas � tabela Turno baseadas no c�digo de docente *
--*****************************************************************************************
create index idx_turno_cod_docente           on tbl_turno (cod_docente);