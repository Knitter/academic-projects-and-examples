#!/usr/bin/perl -W
#Autores:
#Fl�vio Tim�teo ei10580
#S�rgio Lopes ei10635

use strict;
my @resultado;my $line;
@resultado=(@resultado,"*****SEGURAN�A DA PASSWORD*****\n",`./passwd.pl total`);
@resultado=(@resultado,"\n*****TEMPO DE INACTIVIDADE DE UMA LIGA��O ACTIVA*****\n",`./activa.pl total`);
@resultado=(@resultado,"\n*****USO DE COMANDOS DA CONSOLA*****\n",`./consola.pl total`);
@resultado=(@resultado,"\n*****CONTAS N�O USADAS*****\n",`./contas.pl total`);
@resultado=(@resultado,"\n*****FICHEIROS IMPORTANTES*****\n",`./ficheiros.pl total`);
@resultado=(@resultado,"\n*****ACESSO A \"SCRIPTS\" IMPORTANTES*****\n",`./scripts.pl total`);
@resultado=(@resultado,"\n*****LIMITES NA UTILIZA��O DE RECURSOS*****\n",`./limites.pl total`);
@resultado=(@resultado,"\n*****N�MERO DE COMANDOS EXECUTADOS E GUARDADOS*****\n",`./comandos.pl total`);
@resultado=(@resultado,"\n*****FICHEIROS ESCONDIDOS******\n",`./escondidos.pl total`);
@resultado=(@resultado,"\n*****SEGURAN�A ADICIONAL*****\n",`./adicional.pl total`);

open(FILE,"./modelo.html") or die("Erro:$!\n");
my @readed_file=<FILE>;
close(FILE);
foreach $line(@readed_file)
 {
 $line =~ s/seg_actual_resultados/@resultado/;
 print $line;
 }
