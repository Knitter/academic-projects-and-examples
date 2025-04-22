#! /usr/bin/perl -W
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

my $flag=0;my $line;my @readed_file;my @resultado;

if(-e "/etc/tripwire/")
 {
 @resultado=(@resultado,"Pasta de configuracao de \"tripwire\" encontrada\n");
 }
else
 {
 @resultado=(@resultado,"\n\"Tripwire\" não está instalado\n");
 }

open(FILE,"/etc/group") or die("Erro: $!\n");
@readed_file=<FILE>;
close(FILE);
foreach $line(@readed_file)
 {
 if($line =~ m/wheel/)
  {
  $flag++;
  }
 }
if($flag)
 {
  @resultado=(@resultado,"\nGrupo especial \"wheel\" definido\n");
 }
else
 {
  @resultado=(@resultado,"\nDeveria ser definido um grupo de utilizadores chamado \"wheel\"\n");
 }

open(FILE,"/etc/ssh/ssh_config") or die("Erro: $!\n");
@readed_file=<FILE>;
close(FILE);
@resultado=(@resultado,"\nDefinições da ligação ssh (Secure Shell)");
foreach $line(@readed_file)
 {
 if(($line !~ m/^#(.+)/) and ($line !~ m/^\s+/))
  {
   @resultado=(@resultado,"\n$line\n");
  }
 }
if($ARGV[0])
 {
 print @resultado;
 }
else
 {
 open(FILE,"./modelo.html") or die("Erro: $!\n");
 @readed_file=<FILE>;
 close(FILE);
 foreach $line (@readed_file)
  {
  $line =~ s/seg_actual_resultados/@resultado/;
  print $line;
  }
 }
