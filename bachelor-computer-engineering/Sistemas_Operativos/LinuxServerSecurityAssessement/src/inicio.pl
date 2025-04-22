#! /usr/bin/perl -W
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

my @readed_file;my $line;
open(FILE,"./modelo.html") or die("Erro de abertura do ficheiro \"modelo.html\"\n$!\n");
 {
 @readed_file=<FILE>;
 close(FILE);
 foreach $line (@readed_file)
  {
  $line =~ s/seg_actual_resultados//;
  print $line
  }
 }
