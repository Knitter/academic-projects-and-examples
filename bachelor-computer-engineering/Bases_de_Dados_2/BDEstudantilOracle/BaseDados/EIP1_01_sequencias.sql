@@ apagar_sequencias.sql;

--*******************************************************
--*Sequência usada para obter a chave da tabela Interno *
--*******************************************************
create sequence seq_cod_interno
maxvalue 999999
nocycle
cache 5;

--*****************************************************
--*Sequência usada para obter a chave da tabela Curso *
--*****************************************************
create sequence seq_cod_curso
maxvalue 999999
nocycle
nocache;

--***************************************************************
--*Sequência usada para obter o número de aluno da tabela Aluno *
--***************************************************************
create sequence seq_num_aluno
maxvalue 999999
nocycle
nocache;

--************************************************************
--*Sequência usada para obter a chave da tabela Departamento *
--************************************************************
create sequence seq_cod_departamento
maxvalue 999999
nocycle
nocache;

--*******************************************************************
--*Sequência usada para obter o número do docente da tabela Docente *
--*******************************************************************
create sequence seq_num_docente
maxvalue 999999
nocycle
nocache;

--**********************************************************
--*Sequência usada para obter a chave da tabela Disciplina *
--**********************************************************
create sequence seq_cod_disciplina
maxvalue 999999
nocycle
nocache;

--*********************************************************
--*Sequência usada para obter a chave da tabela Instancia *
--*********************************************************
create sequence seq_cod_instancia
maxvalue 999999
nocycle
nocache;

--******************************************************
--*Sequência usada para obter a chave da tabela Funcao *
--******************************************************
create sequence seq_cod_funcao
maxvalue 999999
nocycle
nocache;

--********************************************************
--*Sequência usada para obter a chave da tabela Gabinete *
--********************************************************
create sequence seq_cod_gabinete
maxvalue 999999
nocycle
nocache;

--***********************************************************
--*Sequência usada para obter a chave da tabela Percentagem *
--***********************************************************
create sequence seq_cod_percentagem
maxvalue 999999
nocycle
nocache;

--***********************************************************
--*Sequência usada para obter a chave da tabela Ano_Lectivo *
--***********************************************************
create sequence seq_cod_ano_lectivo
maxvalue 999999
nocycle
nocache;

--*********************************************************
--*Sequência usada para obter a chave da tabela Inscrever *
--*********************************************************
create sequence seq_cod_inscrever
maxvalue 999999
nocycle
nocache;