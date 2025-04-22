#! /usr/bin/perl -w
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;

if (open(FILE,"./modelo.html") || die("Erro\n$!\n")){
	my @readed_file=<FILE>;
	my $line;
	my $aux;
 	close (FILE);
 	if(open(FILE,"./config.txt") || die("ERRO\n$!\n")){
		my @config=<FILE>;
		close(FILE);
		foreach $line (@config){
			if($line =~ m/DIRS/){
				$line =~ s/DIRS=//i;
				$line =~ s/#(.+)$//;
				$aux=$line;
			}
		}
		my @dirs=split(/:/,$aux);
		my $i;my $j;my $OFFSET=0;
		my @lista_files;
		my @aux_list;
		for($i=0;$i<=$#dirs;$i++){
			@aux_list=`lsattr $dirs[$i]`;
			chomp($dirs[$i]);
			$lista_files[$OFFSET++]="\nDirectorio:$dirs[$i]\nFicheiros:\n";
			for($j=0;$j<=$#aux_list;$j++){
				if($aux_list[$j]=~ m/^(-*)i(-*)\s(.+)$/){
					$lista_files[$OFFSET++]="$3\n";
                	        }
			}
			if($lista_files[$OFFSET-1]=~ m/Directorio/){
				$lista_files[$OFFSET++]="Nao existem ficheiros importantes nesta directoria\n";
			}	
		}
		if($ARGV[0]){
			print @lista_files;
		}
		else{
			foreach $line (@readed_file){
                		$line =~ s/seg_actual_resultados/Ficheiros Importantes(imutaveis):\n@lista_files/;
                	print $line;
			}
        	}
}
}
