#!/usr/bin/perl -W
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;
my @resultado;my $line;
@resultado=(@resultado,"*****SEGURANÇA DA PASSWORD*****\n",`./passwd.pl total`);
@resultado=(@resultado,"\n*****TEMPO DE INACTIVIDADE DE UMA LIGAÇÃO ACTIVA*****\n",`./activa.pl total`);
@resultado=(@resultado,"\n*****USO DE COMANDOS DA CONSOLA*****\n",`./consola.pl total`);
@resultado=(@resultado,"\n*****CONTAS NÃO USADAS*****\n",`./contas.pl total`);
@resultado=(@resultado,"\n*****FICHEIROS IMPORTANTES*****\n",`./ficheiros.pl total`);
@resultado=(@resultado,"\n*****ACESSO A \"SCRIPTS\" IMPORTANTES*****\n",`./scripts.pl total`);
@resultado=(@resultado,"\n*****LIMITES NA UTILIZAÇÃO DE RECURSOS*****\n",`./limites.pl total`);
@resultado=(@resultado,"\n*****NÚMERO DE COMANDOS EXECUTADOS E GUARDADOS*****\n",`./comandos.pl total`);
@resultado=(@resultado,"\n*****FICHEIROS ESCONDIDOS******\n",`./escondidos.pl total`);
@resultado=(@resultado,"\n*****SEGURANÇA ADICIONAL*****\n",`./adicional.pl total`);

open(FILE,"./modelo.html") or die("Erro:$!\n");
my @readed_file=<FILE>;
close(FILE);
foreach $line(@readed_file)
 {
 $line =~ s/seg_actual_resultados/@resultado/;
 print $line;
 }
