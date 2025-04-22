#! /usr/bin/perl -w
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;
my @readed_file;
my $line;my @split_line;
my @print_limits; my $cont=0;
if(open(FILE,"/etc/security/limits.conf") || die("Erro\n$!\n")){
	@readed_file=<FILE>;
	close(FILE);
	foreach $line(@readed_file){
		if($line !~ m/#.student/ && $line =~ m/.student/){
			@split_line=split(/ +/,$line);
			$split_line[2] =~ s/maxlogins/maximo de logins: /i;
			$split_line[2] =~ s/nproc/numero maximo de processos: /i;
			$print_limits[$cont++]=$split_line[2];
			$print_limits[$cont++]=$split_line[3];
		}
	}
	if($cont==0){
		@print_limits="Não existem limites na utilização de recursos\n";
	}
	if($ARGV[0]){
		print @print_limits;
	}
	else{
		my @m_readed_file;my $m_line;
		if (open(M_FILE,"./modelo.html") || die("Erro\n$!\n")){
     			@m_readed_file=<M_FILE>;
     			close (M_FILE);
     			foreach $m_line (@m_readed_file){	
      				$m_line =~ s/seg_actual_resultados/@print_limits/;	
				print $m_line;
			}
						
		}
	}		
				
}
