#!/usr/bin/perl -w
#  Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

my @readed_file;my $line=0;my $histsize;my $flag=0;
if(open(FILE,"/etc/profile") || die("Erro\n$!\n")){
	@readed_file=<FILE>;
	close(FILE);
	foreach $line (@readed_file){
		if($line =~ m/HISTSIZE(\D+)(\d+)/){
			$histsize=$2;
			$flag=1;
		}
	}
	if(!$flag){
		$histsize="Não foram encontrados resultados\n";
	}
       	if($ARGV[0]){
		print "$histsize\n";		
	}
	else{
		my @m_readed_file;my $m_line;
		if (open(M_FILE,"./modelo.html") || die("Erro\n$!\n")){
			my @m_readed_file=<M_FILE>;
			close (M_FILE);
			foreach $m_line (@m_readed_file){
	        		$m_line =~ s/seg_actual_resultados/Numero maximo de comandos que podem ser guardados: $histsize/;
				print $m_line;
			}
		}
	}
}
