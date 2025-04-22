@@ apagar_tabelas.sql;

-- tabelas sem dependencias
create table tbl_ano_civil(
	ano varchar2(4),
	constraint pk_ano_civil_ano primary key (ano)
);

create table tbl_ano_lectivo(
	codigo number(6),
	designacao varchar(9) not null,
	data_inicio date default (sysdate) not null,
	data_fim date not null,
	constraint pk_ano_lectivo_codigo primary key (codigo)
);


create table tbl_departamento(
	cod_departamento number(6),
	abreviatura      varchar2(6) not null,
	designacao       varchar2(50),
    	num_docentes     number(2) default(0) not null,
	constraint pk_departamento_cod_dep primary key (cod_departamento)
);

create table tbl_curso(
	cod_curso            number(6),
	descricao            varchar(250),
	duracao              number(1) not null,
	abreviatura          varchar2(3) not null,
	nome                 varchar2(35) not null,
	regime               varchar2(1) default 'D' not null,
	num_docentes         number(4) default(0) not null,
	num_alunos_inscritos number(6) default(0) not null,
	constraint pk_curso_cod_curso primary key (cod_curso),
	constraint ck_curso_regime    check (regime in ('D','N')),
	constraint ck_curso_duracao   check (duracao > 0 and duracao <= 9)
);

create table tbl_extensao(
	numero number(4),
	constraint pk_extensao_numero primary key (numero)
);

create table tbl_funcao(
	cod_funcao number(6),
	nome varchar2(25) not null,
	descricao varchar2(150),
	constraint pk_funcao_cod_funcao primary key (cod_funcao)
);

create table tbl_interno(
       cod_interno       number(6),
       nib               varchar2(21)  not null,
       bi                number(9)     unique not null,     
       grau_academico    varchar(15),
       num_contribuinte  number(9)     unique not null,
       data_entrada      date          not null,
       pag_pessoal       varchar2(200),
       data_nascimento   date          not null,
       localidade        varchar2(30)  not null,
       endereco          varchar2(150) not null,
       cod_postal        varchar2(8)   not null,
       p_nome            varchar2(25)  not null,
       nomes_meio        varchar2(100),
       apelido           varchar2(25)  not null,
       sexo              varchar2(1)   not null,
       mail              varchar2(200),
       telefone          number(9)     not null,
       tipo              varchar2(1)   not null,
       fotografia	 blob,
       tipo_funcionario  integer not null,
       constraint pk_interno_cod_interno primary key (cod_interno),
       constraint ck_interno_sexo        check       (sexo in ('M', 'F')),
       constraint ck_interno_tipo        check       (tipo in ('A', 'F')),
       constraint ck_interno_tipo_funcionario check (tipo_funcionario in (0, 1, 2))              
)
LOB (fotografia) STORE AS (TABLESPACE TBS_LOBS);

create table tbl_percentagem(
       cod_percentagem number(6),
       peso_teorica    number(3) default(0) not null,
       peso_pratica    number(3) default(0) not null,
       peso_trabalho   number(3) default(0) not null,
       constraint pk_percentagem_cod_percentagem primary key (cod_percentagem),
       constraint ck_percentagem_peso_teorica  check (peso_teorica  between 0 and 100),
       constraint ck_percentagem_peso_pratica  check (peso_pratica  between 0 and 100),
       constraint ck_percentagem_peso_trabalho check (peso_trabalho between 0 and 100)
);
--inicio das tabelas com dependencias

create table tbl_funcionario(
	cod_funcionario number(6),
	ordenado number(6),
	num_seg_social varchar2(11),
	tipo              varchar2(1)   not null,
	constraint pk_funcionario_cod_funcionario primary key (cod_funcionario),
	constraint fk_funcionario_cod_funcionario foreign key (cod_funcionario) references tbl_interno(cod_interno),
	constraint ck_funcionario_tipo        check       (tipo in ('D', 'N')) 
);

create table tbl_disciplina(
	cod_disciplina number(6),
	duracao_sem_teo number(1),
	duracao_sem_prat number(1),
	duracao_sem_teo_prat number(1),
	limite_faltas number(2),
	nome_disciplina varchar(50),
	cod_curso number(6) not null,
	cod_departamento number(6) not null,
	constraint pk_disciplina_cod_disciplina primary key (cod_disciplina),
	constraint fk_disciplina_cod_curso foreign key (cod_curso) references tbl_curso(cod_curso),
	constraint fk_disciplina_cod_departamento foreign key (cod_departamento) references tbl_departamento(cod_departamento),
	constraint ck_disciplina_limite_faltas check (limite_faltas >=0),
	constraint ck_disciplina_dur_teorica check (duracao_sem_teo >=0),
	constraint ck_disciplina_dur_pratica check (duracao_sem_prat >=0),
	constraint ck_disciplina_dur_teo_pratica check (duracao_sem_teo_prat >=0)	
);

create table tbl_aluno(
	cod_aluno number(6),
	num_aluno number(6) unique not null,
	trabalhador varchar2(1) default 'N' not null,
	ano number(1) default 1 not null,
	naturalidade varchar2(35) not null,
	nacionalidade varchar2(35) not null,
    	num_matriculas number(2) default(1) not null,
	constraint pk_aluno_cod_aluno primary key (cod_aluno),
	constraint ck_aluno_ano check (ano between 1 and 5),
	constraint ck_aluno_trabalhador check (trabalhador in ('N', 'S')),
	constraint fk_aluno_cod_aluno foreign key (cod_aluno) references tbl_interno(cod_interno)
);

create table tbl_telefone_interno(
       cod_interno  number(6),
       telefone     number(9),
       constraint pk_telefone_interno_all         primary key (cod_interno, telefone),
       constraint fk_telefone_interno_cod foreign key (cod_interno) references tbl_interno(cod_interno)
);

create table tbl_gabinete(
	cod_gabinete number(6), 
	lotacao number(2) not null,
	constraint pk_gabinete_cod_gabinete         primary key (cod_gabinete)
);

create table tbl_docente(
	cod_docente number(6), 
	num_docente number(6) unique not null,
	cacifo number(4) not null,
	cod_departamento number(6) not null,
	cod_gabinete number(6) not null,
	numero number(4) not null,
	constraint pk_docente_cod_docente primary key (cod_docente),
	constraint fk_docente_cod_docente foreign key (cod_docente) references tbl_funcionario(cod_funcionario), 
	constraint fk_docente_cod_departamento foreign key (cod_departamento) references tbl_departamento(cod_departamento),
	constraint fk_docente_cod_gabinete foreign key (cod_gabinete) references tbl_gabinete(cod_gabinete),
	constraint fk_docente_numero foreign key (numero) references tbl_extensao(numero)
);

create table tbl_frequentar(
	codigo number(6),
	cod_aluno number(6),
	cod_curso number(6),
	constraint pk_frequentar_all primary key (codigo, cod_aluno, cod_curso),
	constraint fk_frequentar_codigo foreign key (codigo) references tbl_ano_lectivo(codigo),
	constraint fk_frequentar_cod_aluno foreign key (cod_aluno) references tbl_aluno(cod_aluno),
	constraint fk_frequentar_cod_curso foreign key (cod_curso) references tbl_curso(cod_curso)
);

create table tbl_instancia (
	cod_disciplina number(6),
	cod_instancia number(6),
	cod_percentagem number(6) not null,
	codigo number(6) not null,
	constraint pk_instancia_cod_disci_instan primary key (cod_disciplina, cod_instancia),
	constraint fk_instancia_cod_disciplina foreign key (cod_disciplina) references tbl_disciplina(cod_disciplina),
	constraint fk_instancia_cod_percentagem foreign key (cod_percentagem) references tbl_percentagem(cod_percentagem),
	constraint fk_instancia_codigo foreign key (codigo) references tbl_ano_lectivo(codigo)
);

create table tbl_inscrever(
	cod_inscrever   number(6),
    	num_faltas      number(2) default(0),
    	teo_recurso     number(2),
    	teo_especial    number(2),
    	teo_exame       number(2),
    	teo_frequencia  number(2),
    	pra_frequencia  number(2),
    	trabalho        number(2),
    	cod_aluno       number(6) not null,
    	cod_disciplina number(6) not null,
	cod_instancia number(6) not null,
    	constraint pk_inscrever_cod_inscrever  primary key (cod_inscrever),
    	constraint fk_inscrever_cod_aluno      foreign  key (cod_aluno) references tbl_aluno(cod_aluno),
    	constraint fk_inscrever_cods_instancia foreign  key (cod_disciplina, cod_instancia) references tbl_instancia(cod_disciplina, cod_instancia),
    	constraint ck_inscrever_num_faltas     check (num_faltas >=0),
    	constraint ck_inscrever_teo_recurso    check (teo_recurso    between 0 and 20),
    	constraint ck_inscrever_teo_especial   check (teo_especial   between 0 and 20),
    	constraint ck_inscrever_teo_exame      check (teo_exame      between 0 and 20),
    	constraint ck_inscrever_teo_frequencia check (teo_frequencia between 0 and 20),
    	constraint ck_inscrever_pra_frequencia check (pra_frequencia between 0 and 20),
	constraint ck_inscrever_trabalho       check (trabalho       between 0 and 20)
);

create table tbl_turno(
       cod_disciplina number(6),
       cod_instancia  number(6),
       num_turno      number(1),
       dia_semana     varchar2(7) not null,
       hora_inicio    date not null,
       hora_fim       date not null,
       cod_docente    number(6),
       constraint pk_turno_cod_disciplina_turno primary key (cod_disciplina, cod_instancia, num_turno),
       constraint fk_turno_cod_disciplina       foreign key (cod_disciplina, cod_instancia) references tbl_instancia (cod_disciplina, cod_instancia),
       constraint fk_turno_cod_docente          foreign key (cod_docente)    references tbl_docente    (cod_docente),
       constraint ck_turno_dia_semana check (dia_semana  in ('Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'))
);

create table tbl_pertencer(
       cod_curso          number(6),
       cod_departamento   number(6) not null,
       constraint pk_pertencer_cod_curso        primary key (cod_curso),
       constraint fk_pertencer_cod_curso        foreign key (cod_curso)        references tbl_curso(cod_curso),
       constraint fk_pertencer_cod_departamento foreign key (cod_departamento) references tbl_departamento(cod_departamento)
);

create table tbl_nao_docente(
       cod_nao_docente   number(6),
       cod_funcao        number(6) not null,
       contactavel       varchar2(1) default('N') not null,
       constraint pk_nao_docente_cod_nao_docente primary key (cod_nao_docente),
       constraint fk_nao_docente_cod_funcao      foreign key (cod_funcao) references tbl_funcao,
       constraint ck_nao_docente_contactavel check (contactavel in ('S', 'N'))
);

create table tbl_horario_gabinete(
       cod_docente number(6),
       hora_inicio date,
       hora_fim    date,
       dia_semana  varchar2(7) not null,
       constraint pk_horarioGabinete_all primary key (cod_docente, hora_inicio, hora_fim, dia_semana),
       constraint fk_horarioGabinete_cod_docente foreign key (cod_docente) references tbl_docente(cod_docente),
       constraint ck_horarioGabinete_dia_semana  check (dia_semana  in ('Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado', 'Domingo'))
);

create table tbl_dirigir(
	cod_curso number(6),
	cod_docente number(6),
	ano_civil varchar2(4),
	data_inicio date not null,
	data_fim date,
	constraint pk_dirigir_cods_ano primary key (	cod_curso, cod_docente,ano_civil),
	constraint fk_dirigir_cod_curso foreign key (cod_curso) references tbl_curso(cod_curso),
	constraint fk_dirigir_cod_docente foreign key (cod_docente) references tbl_docente(cod_docente),
	constraint fk_dirigir_cod_ano_civil foreign key (ano_civil) references tbl_ano_civil(ano)
);	

create table tbl_coordenar(
	ano_civil varchar2(4),
	cod_docente number(6),
	cod_departamento number(6),
	data_fim date,
	data_inicio date not null,
	constraint pk_coordenar_cod primary key (ano_civil, cod_docente, cod_departamento),
	constraint fk_coordenar_ano_civil foreign key (ano_civil) references tbl_ano_civil(ano),
	constraint fk_coordenar_cod_docente foreign key (cod_docente) references tbl_docente(cod_docente),
	constraint fk_coordenar_cod_departamento foreign key (cod_departamento) references tbl_departamento(cod_departamento)
);

create table tbl_conter(
	numero number(6),
	cod_gabinete number(6),
	constraint pk_conter_all primary key (numero),
	constraint fk_conter_numero foreign key (numero) references tbl_extensao(numero),
	constraint fk_conter_cod_gabinete foreign key (cod_gabinete) references tbl_gabinete(cod_gabinete)
);

create table tbl_contactavel (
	cod_contactavel number(8),
	numero number(4) not null,
	constraint pk_contactavel_all primary key (cod_contactavel),
	constraint fk_contactavel_cod_contactavel foreign key (cod_contactavel) references tbl_nao_docente(cod_nao_docente),
	constraint fk_contactavel_cod_numero foreign key (numero) references tbl_extensao(numero)
);

create table tbl_colocar (
	cod_disciplina number(6),
	cod_instancia number(6),
	num_turno number(1),
	cod_aluno number(6),
	constraint pk_colocar_all primary key (cod_disciplina, cod_instancia, num_turno, cod_aluno),
	constraint fk_colocar_num_turno foreign key (cod_disciplina, cod_instancia, num_turno) references tbl_turno (cod_disciplina, cod_instancia, num_turno),
	constraint fk_colocar_cod_aluno foreign key (cod_aluno) references tbl_aluno(cod_aluno)
);

create table tbl_caber(
	cod_contactavel number(6),
	cod_gabinete number(6) not null,
	constraint pk_caber_all primary key (cod_contactavel),
	constraint fk_caber_cod_contactavel foreign key (cod_contactavel) references tbl_contactavel(cod_contactavel),
	constraint fk_caber_cod_gabinete  foreign key (cod_gabinete) references tbl_gabinete (cod_gabinete)
);