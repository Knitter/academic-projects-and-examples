#! /usr/bin/perl -W
#Autores:
#Fl�vio Tim�teo ei10580
#S�rgio Lopes ei10635

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
