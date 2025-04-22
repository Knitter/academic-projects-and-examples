#! /usr/bin/perl -W
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

my @readed_file;my $line=0;my $character;
open(FILE,"/etc/login.defs") or die("Erro\n$!\n");
@readed_file=<FILE>;
close(FILE);
foreach $line (@readed_file)
 {
 if($line =~ m/^PASS_MIN_LEN/)
  {
  my @letters=split (//,$line);
  foreach $character (@letters)
   {
   if( $character =~ m/\d/)
    {
    my @m_readed_file;my $m_line;
    open(FILE,"./modelo.html") or die("Erro\n$!\n");
    @readed_file=<FILE>;
    close (FILE);
     #impressao
     if($ARGV[0])
      {
      print "Numero minimo de caracteres da password: $character\n";
      }
     else
      {
     foreach $m_line (@readed_file)
      {
      $m_line =~ s/seg_actual_resultados/Numero minimo de caracteres da password: $character/;
      print $m_line;
      }
     }
    }
   }
  }
 }
