#! /usr/bin/perl -W
#  Autores:
#Fl�vio Tim�teo ei10580
#S�rgio Lopes ei10635

use strict;

my $line;my $resultado=0;
open(FILE,"/etc/profile") or die("Erro: $!\n");
my @readed_file = <FILE>;
close (FILE);
foreach $line (@readed_file)
 {
 if($line =~ s/TMOUT=//)
  {
  $resultado="Tempo limite de inactividade: $line segundos";
  }
 }
if(!$resultado)
 {
 $resultado="Entrada n�o encontrada.\n";
 }
if($ARGV[0])
 {
 print $resultado;
 }
else
 {
 open(FILE,"./modelo.html") or die("Erro: $!\n");
 @readed_file=<FILE>;
 foreach $line (@readed_file)
  {
  $line =~ s/seg_actual_resultados/$resultado/;
  print $line;
  }
 }
