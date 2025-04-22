#! /usr/bin/perl
#  Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

my $line;my $aux;
open(FILE,"./config.txt") or die("Erro: $!");
my @readed_file=<FILE>;
close(FILE);
foreach $line (@readed_file)
 {
 if($line =~ s/^TEMPO=//)
  {
  $line =~ s/(\s+)(.+)$// ;
  $aux=$line;
  last;
  }
 }

my @total=`lastlog`;my @parcial=`lastlog -t $aux`;my @resultado;my $z;my $x=0;

for($z=0;$z<=$#total;$z++)
 {
 if($total[$z] eq $parcial[$x])
  {
  $x++;
  if($x>$#parcial+1)
   {
   last;
   }
  }
 else
  {
  @resultado=(@resultado,$total[$z]);
  }  
 }
if($ARGV[0])
 {
 print @resultado;
 }
else
 {
 open (FILE,"./modelo.html") or die ("Erro de abertura do ficheiro \"modelo.html\"\n$!\n");
 if($ARGV[0])
  {
  print @resultado;
  }
 else
  {
  my @m_readed_file=<FILE>;
  close(FILE);
  foreach $line (@m_readed_file)
   {
   $line =~ s/seg_actual_resultados/@resultado/;
   print $line;
   }
  }
 }
