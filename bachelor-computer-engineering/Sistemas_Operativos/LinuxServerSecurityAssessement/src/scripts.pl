#! /usr/bin/perl -W
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635


use strict;

my $aux;my @list;my $line;my @resultado;my $flag;
open(FILE,"./config.txt") or die("Erro: $!\n");
my @readed_file=<FILE>;
close(FILE);
foreach $line (@readed_file)
 {
 if(($line =~ s/^DIRS=//i))
  {
  $line =~s/#(.+)//;
  $aux=$line;
  }
 }
my @dirs=split(/:/,$aux);
foreach $line (@dirs)
 {
 @list=`ls -Al $line`;
 @resultado=(@resultado,"\nDirectoria: $line\n");
 $flag=0;
 foreach $aux (@list)
  {
  if($aux !~ m/^.-{3}/)
   {
   if($aux =~ m/^-.{3}-{6}(.+)root/)
    {
    @resultado=(@resultado,$aux);
    $flag++;
    }
   }
  }
 if(!$flag)
  {
  @resultado=(@resultado,"Nesta directoria não existem resultados a apresentar\n")
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
foreach $line (@readed_file)
 {
 $line =~ s/seg_actual_resultados/@resultado/;
 print $line;
 }
}
