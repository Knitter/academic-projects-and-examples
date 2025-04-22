--dados da tabela ano_civil
execute proc_inserir_ano_civil(2000);
execute proc_inserir_ano_civil(2001);
execute proc_inserir_ano_civil(2002);
execute proc_inserir_ano_civil(2003);
execute proc_inserir_ano_civil(2004);
execute proc_inserir_ano_civil(2005);

--dados da tabela ano_lectivo
execute proc_inserir_ano_lectivo('2000/2001', sysdate, sysdate);
execute proc_inserir_ano_lectivo('2001/2002', sysdate, sysdate);
execute proc_inserir_ano_lectivo('2002/2003', sysdate, sysdate);
execute proc_inserir_ano_lectivo('2003/2004', sysdate, sysdate);
execute proc_inserir_ano_lectivo('2004/2005', sysdate, sysdate);

--dados da tabela departamento
execute proc_inserir_departamento('EI', 'departamento informatica');
execute proc_inserir_departamento('EIC', 'departamento informatica e comunicacoes');
execute proc_inserir_departamento('EM', 'departamento mecanica');
execute proc_inserir_departamento('EA', 'departamento automovel');

--dados da tabela curso
execute proc_inserir_curso('curso de engenharia',5,'EI', 'Engenharia Informatica', 'D');
execute proc_inserir_curso('curso de engenharia',5,'EA', 'Engenharia Ambiente', 'D');
execute proc_inserir_curso('--sem descricao--',4,'SO', 'Solicitadoria', 'D');
execute proc_inserir_curso('--sem descricao--',3,'GAp', 'Gestao e Administracao Publica', 'D');
execute proc_inserir_curso('curso de engenharia',5,'EAU', 'Engenharia Automovel', 'D');
execute proc_inserir_curso('curso de engenharia',5,'EIN', 'Engenharia Informatica', 'N');

--dados da tabela extensao
execute proc_inserir_extensao(1000);
execute proc_inserir_extensao(1001);
execute proc_inserir_extensao(1002);
execute proc_inserir_extensao(1003);
execute proc_inserir_extensao(1004);
execute proc_inserir_extensao(1005);
execute proc_inserir_extensao(1006);
execute proc_inserir_extensao(1007);
execute proc_inserir_extensao(1008);
execute proc_inserir_extensao(1009);
execute proc_inserir_extensao(1010);

--dados da tabela funcao
execute proc_inserir_funcao('administrtivo', 'funcionario administrativo');
execute proc_inserir_funcao('caixa', 'empregado de caixa de bar');
execute proc_inserir_funcao('carpinteiro', 'responsavel por obras de carpintaria');
execute proc_inserir_funcao('electrecista', 'responsavel pela manutencao da rede electrica');
execute proc_inserir_funcao('telefonista', 'telefonista');

--dados da tabela percentagem
execute proc_inserir_percentagem(50, 50, 0);
execute proc_inserir_percentagem(50, 0, 50);
execute proc_inserir_percentagem(35, 65, 0);
execute proc_inserir_percentagem(0, 55, 45);
execute proc_inserir_percentagem(40, 60, 0);

--dados da tabela gabinete
execute proc_inserir_gabinete(2);
execute proc_inserir_gabinete(5);
execute proc_inserir_gabinete(5);
execute proc_inserir_gabinete(7);
execute proc_inserir_gabinete(7);
execute proc_inserir_gabinete(2);
execute proc_inserir_gabinete(1);

--dados da tabela aluno
execute proc_inserir_aluno('100000000000000000001', 123456780, null, 000000001, sysdate, null, to_date('05-10-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Flores', '4210-000', 'Sergio', 'Miguel Neves', 'Lopes', 'M', null, 244801101, null, 'N', 2, 'Leiria', 'Portuguesa', 4);
execute proc_inserir_aluno('100000000000000000012', 123456781, null, 000000012, sysdate, null, to_date('01-01-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Arvores', '4210-001', 'Joaquim', 'Rogrigues', 'Silva', 'M', null, 244801102, null, 'N', 1, 'Leiria', 'Portuguesa', 1);
execute proc_inserir_aluno('100000000000000000123', 123456783, null, 000000123, sysdate, null, to_date('02-02-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Rosas', 2400-002, 'Anacleto', null, 'Antonio', 'M', null, 244801103, null, 'S', 1, 'Leiria', 'Portuguesa', 1);
execute proc_inserir_aluno('100000000000000001234', 123456784, 'Engenheiro', 000001234, sysdate, null, to_date('03-03-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Margaridas', '2410-004', 'Fernando', 'Antunes', 'Araujo', 'M', null, 244801104, null, 'N', 2, 'Leiria', 'Portuguesa', 5);
execute proc_inserir_aluno('100000000000000012345', 123456785, null, 000012345, sysdate, null, to_date('04-04-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Camelias', '2100-000', 'Maria', 'Joao', 'Cruz', 'F', null, 244801105, null, 'S', 2, 'Leiria', 'Portuguesa', 2);

--dados da tabela disciplina
execute proc_inserir_disciplina(3,6,0,15,'Matematica',1,1);
execute proc_inserir_disciplina(9,0,0,15,'Portugues',3,1);
execute proc_inserir_disciplina(3,9,0,15,'Redes',1,1);
execute proc_inserir_disciplina(3,6,0,15,'Bases de Dados',1,1);

--dados da tabela nao docente
execute proc_inserir_nao_docente('100000000000000123456', 123456786, null, 000123456, sysdate, null, to_date('05-05-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua dos Cravos', '2410-060', 'Antonio', null, 'Freitas', 'M', null, 244801106, null, 1, 'S', 500, '12346578910');
execute proc_inserir_nao_docente('100000000000001234567', 123456787, null, 001234567, sysdate, null, to_date('06-06-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua dos Malmequeres', '2420-050', 'Joao', 'Ricardo', 'Maria', 'M', null, 244801107, null, 2, 'N',500, '12345678911');
execute proc_inserir_nao_docente('100000000000012345678', 123456788, null, 012345678, sysdate, null, to_date('07-07-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Cerejeiras', '2430-040', 'Carla', 'Reis de', 'Almeida', 'F', null, 244801108, null, 1, 'S',500, '12345678912');
execute proc_inserir_nao_docente('100000000000123456789', 123456789, null, 123456789, sysdate, null, to_date('08-08-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Macieiras', '2450-030', 'Maria', null, 'Bernadina', 'F', null, 244801109, null, 3, 'N',600, '12345678913');
execute proc_inserir_nao_docente('100000000001234567891', 123456790, null, 123456790, sysdate, null, to_date('09-09-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua das Pereiras', '2460-020', 'Justino', 'Carlos', 'Dias', 'M', null, 244801110, null, 5, 'S',550, '12345678914');
execute proc_inserir_nao_docente('100000000012345678912', 123456791, null, 123456791, sysdate, null, to_date('10-10-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua dos Pessegueiros', '2470-010', 'Ana', null, 'Cruz', 'F', null, 244801111, null, 1, 'N',500, '12345678915');

--dados da tabela docente
execute proc_inserir_docente('100000000123456789123', 123456792, 'Mestre', 123456792, sysdate, 'www.somewhere.moc', to_date('11-11-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua dos Olivais', '2410-032','Joao','Manuel', 'Gomes',  'M', 'noone@someplace.moc', 244801112, null, 1, 1, 1, 1000, 500, '12345678916');
execute proc_inserir_docente('100000001234567891234', 123456793, 'Doutor', 123456793, sysdate, 'www.somewhere2.moc', to_date('12-12-1982', 'DD-MM-YYYY'), 'Leiria', 'Rua do Azeite', '2410-042','Vitoria','Miguel', 'Antunes',  'F', 'noone2@someplace.moc', 244801112, null, 2, 1, 1, 1001, 500, '12345678916');
execute proc_inserir_docente('100000012345678912345', 123456794, 'Engenheiro', 123456794, sysdate, 'www.somewhere3.moc', to_date('01-01-1979', 'DD-MM-YYYY'), 'Leiria', 'Rua do Lagar', '2410-052','Francisco','Gomes', 'da Silva',  'M', 'noone3@someplace.moc', 244801112, null, 3, 1, 1, 1002, 500, '12345678916');
execute proc_inserir_docente('100000123456789123456', 123456795, 'Engenheiro', 123456795, sysdate, 'www.somewhere4.moc', to_date('02-02-1979', 'DD-MM-YYYY'), 'Leiria', 'Rua das Vinhas', '2410-062','Ana',null, 'Lazaro',  'F', 'noone4@someplace.moc', 244801112, null, 4, 1, 1, 1003, 500, '12345678916');
execute proc_inserir_docente('100001234567891234567', 123456796, 'Mestre', 123456796, sysdate, 'www.somewhere5.moc', to_date('03-03-1979', 'DD-MM-YYYY'), 'Leiria', 'Rua das Uvas', '2410-072','Marco',null, 'Paulo',  'M', 'noone5@someplace.moc', 244801112, null, 5, 1, 1, 1004, 500, '12345678916');

--dados da tabela contactavel 
execute proc_inserir_contactavel(6, 1006);
execute proc_inserir_contactavel(7, 1007);
execute proc_inserir_contactavel(8, 1008);

--dados da tabela instancia
execute proc_criar_instancia(1,1,1);
execute proc_criar_instancia(1,1,2);
execute proc_criar_instancia(1,1,3);
execute proc_criar_instancia(1,1,4);
execute proc_criar_instancia(1,1,5);
execute proc_criar_instancia(2,2,1);
execute proc_criar_instancia(2,2,2);
execute proc_criar_instancia(2,2,3);
execute proc_criar_instancia(2,2,4);
execute proc_criar_instancia(2,2,5);
execute proc_criar_instancia(3,3,3);
execute proc_criar_instancia(3,3,4);
execute proc_criar_instancia(3,3,5);

--dados da tabela turno
execute proc_inserir_turno(1,1,1,'Segunda',to_date('16:00', 'HH24:MI'),to_date('17:00','HH24:MI'),12);  
execute proc_inserir_turno(1,1,2,'Terça',to_date('16:00', 'HH24:MI'),to_date('17:30','HH24:MI'),13);  
execute proc_inserir_turno(2,6,1,'Segunda',to_date('14:00', 'HH24:MI'),to_date('15:30','HH24:MI'),14);  
execute proc_inserir_turno(2,6,2,'Quinta',to_date('16:00', 'HH24:MI'),to_date('17:00','HH24:MI'),15);  
