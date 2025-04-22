#Template para uma makefile
#12-10-2006 - Vitor Carreira
CFLAGS=-Wall -W -g -Wmissing-prototypes
IFLAGS=-br -brs -npsl -ce -cli4
DEBUG_HOME=${HOME}/sdp/error_handling
SEM_HOME=${HOME}/sdp/semaforos
ESTRUTURAS_HOME=${HOME}/sdp/estruturas
SYMB_LINKS=debug.h debug.c semaforos.h semaforos.c listas.h listas.c hashtables.h hashtables.c
GENGETOPT_CONFIG=config.ggo
GENGETOPT_FILE=cmdline
LIBS=-pthread

APP=securitas

LISTAGENS=${APP}

.PHONY: clean

build: clean all

all: ${LISTAGENS}

depuracao: CFLAGS += -D SHOW_DEBUG
depuracao: ${LISTAGENS} 

${APP}: ${APP}.o  debug.o  listas.o files.o hashtables.o functions.o structures.o ${GENGETOPT_FILE}.o
	${CC} ${LIBS} -o $@ $@.o debug.o listas.o hashtables.o files.o functions.o structures.o ${GENGETOPT_FILE}.o
	
#dependencias
${APP}.o: ${APP}.c ${APP}.h debug.h listas.h hashtables.h files.h functions.h structures.h defines.h Makefile
#INCLUIR AS RESTANTES DEPENDENCIAS
#Files
files.o: files.c files.h defines.h structures.h hashtables.h debug.h functions.h Makefile
#Functions
functions.o: functions.c functions.h debug.h cmdline.h defines.h Makefile
#Structures
structures.o : structures.c structures.h debug.h defines.h Makefile

debug.o: debug.c debug.h
semaforos.o: semaforos.c semaforos.h
listas.o: listas.c listas.h
hashtables.o: hashtables.c hashtables.h listas.h
${GENGETOPT_FILE}.o: ${GENGETOPT_FILE}.c ${GENGETOPT_FILE}.h

.c.o:
	${CC} ${CFLAGS} -c $<

debug.h:
	ln -fs ${DEBUG_HOME}/debug.h debug.h

debug.c:
	ln -fs ${DEBUG_HOME}/debug.c debug.c

semaforos.h:
	ln -fs ${SEM_HOME}/semaforos.h semaforos.h

semaforos.c:
	ln -fs ${SEM_HOME}/semaforos.c semaforos.c

listas.h:
	ln -fs ${ESTRUTURAS_HOME}/listas.h listas.h

listas.c:
	ln -fs ${ESTRUTURAS_HOME}/listas.c listas.c

hashtables.h:
	ln -fs ${ESTRUTURAS_HOME}/hashtables.h hashtables.h

hashtables.c:
	ln -fs ${ESTRUTURAS_HOME}/hashtables.c hashtables.c

# GENGETOPT
${GENGETOPT_FILE}.h:
	gengetopt < ${GENGETOPT_CONFIG} --file-name=${GENGETOP_FILE}


clean:
	rm -f core.* *.o *~ ${LISTAGENS} ${SYMB_LINKS} #${GENGETOPT_FILE}.*


docs: Doxyfile
	doxygen Doxyfile

Doxyfile:
	doxygen -g Doxyfile

converte:
	dos2unix *.c *.h

indent:
	dos2unix *.c *.h
	indent ${IFLAGS} *.c *.h	
