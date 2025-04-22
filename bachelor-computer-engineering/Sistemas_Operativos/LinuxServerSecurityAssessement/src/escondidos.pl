#! /usr/bin/perl -w
#Autores:
#Flávio Timóteo ei10580
#Sérgio Lopes ei10635

use strict;
my @readed_file;
if (open(FILE,"./modelo.html") || die("Erro\n$!\n")){
        @readed_file=<FILE>;
	my $line;
	my $aux;
	my @file_list;
	close(FILE);
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
		my @aux_list;my $aux_line;
		my $count=0;
		foreach $line(@dirs){
			chomp($line);
			@aux_list=`ls -a $line`;
			$file_list[$count++]="\nDirectorio: $line\nFicheiros Escondidos:\n";
			foreach $aux_line(@aux_list){
				if($aux_line=~ m/^\.(\w+)(.*)/){
					$file_list[$count++]="$1$2\n";
				}
			}
			if($file_list[$count-1]=~ m/Directorio/ ){
				$file_list[$count++]="Nao existem ficheiros escondidos nesta directoria\n";
			}
		}
	}
	if($ARGV[0]){
		print @file_list;
	}
	else{
		foreach $line (@readed_file){
                	$line =~ s/seg_actual_resultados/@file_list/;
        		print $line;
		}
	}
	
}
