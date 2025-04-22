# Makefile que facilmente se adapta a qualquer tipo de exercicio
# author Vitor Carreira
# date 2004-04-08
#
#LIBS=-pthread 
CFLAGS=-Wall -W -g -ansi -Wmissing-prototypes -D SHOW_DEBUG
#CFLAGS=-Wall -W -g -Wmissing-prototypes
IFLAGS=-br -brs -npsl -ce -cli4

EXEMPLO1=exemplo1
EXEMPLO2=exemplo2
EXEMPLO3=exemplo3

ALL=${EXEMPLO1} ${EXEMPLO2} ${EXEMPLO3}

.PHONY: clean

all: ${ALL}

${EXEMPLO1}: ${EXEMPLO1}.o listas.o
	${CC} ${CFLAGS} -o $@ $@.o listas.o

${EXEMPLO2}: ${EXEMPLO2}.o listas.o
	${CC} ${CFLAGS} -o $@ $@.o listas.o

${EXEMPLO3}: ${EXEMPLO3}.o listas.o hashtables.o
	${CC} ${CFLAGS} -o $@ $@.o listas.o hashtables.o

#dependencias
${EXEMPLO1}.o: ${EXEMPLO1}.c listas.h Makefile
${EXEMPLO2}.o: ${EXEMPLO2}.c listas.h Makefile
${EXEMPLO3}.o: ${EXEMPLO3}.c listas.h hashtables.h Makefile
listas.o: listas.c listas.h
hashtables.o: hashtables.c hashtables.h listas.h
#como compilar .o a partir de .c
.c.o:
	${CC} ${CFLAGS} -c $<

clean:
	rm -f core*
	rm -f *.o
	rm -f *~
	rm -f *.bak
	rm -f ${ALL}

docs: Doxyfile
	doxygen Doxyfile

Doxyfile:
	doxygen -g Doxyfile

indent:
	dos2unix *.c *.h
	indent ${IFLAGS} *.c *.h	
	
