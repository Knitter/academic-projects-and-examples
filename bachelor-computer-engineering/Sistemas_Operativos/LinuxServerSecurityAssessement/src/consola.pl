#! /usr/bin/perl -w

#  Autores:
#Fl�vio Tim�teo ei10580
#S�rgio Lopes ei10635

use strict;

my $line;my $aux=`ls -A1 /etc/security/console.apps`;
if (open(FILE,"./modelo.html") || die("Erro\n$!\n"))
 {
 	if($ARGV[0]){
		print $aux;	
	}else{
		my @readed_file=<FILE>;
 		close (FILE);
 		foreach $line (@readed_file){
  			$line =~ s/seg_actual_resultados/$aux/;
  			print $line;
 		}
	}
 }
