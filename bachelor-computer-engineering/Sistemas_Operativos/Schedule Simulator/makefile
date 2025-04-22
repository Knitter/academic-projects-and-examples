# se não existir "-D SHOW_DEBUG", o que estiver entre as linhas
# "#ifdef SHOW_DEBUG" e "#endif" não é compilado

CFLAGS = -W -Wall -g -D SHOW_DEBUG

# nome dos ficheiros gerados pelo gengetopt
CMD = opts
CMD_PS= ps_opts

EXECNAME = schedule
EXECNAME2 = ps_schedule

LIBS = 

all: ${EXECNAME} ${EXECNAME2}

${EXECNAME}: ${CMD}.c ${EXECNAME}.o ${CMD}.o debug.o estruturas.o listas.o funcoes.o funcoes_pschedule.o makefile
	gcc ${CFLAGS} ${EXECNAME}.o ${CMD}.o debug.o funcoes.o estruturas.o listas.o funcoes_pschedule.o -o ${EXECNAME} ${LIBS}


${EXECNAME}.o: ${EXECNAME}.c makefile
	gcc ${CFLAGS} -c ${EXECNAME}.c

# bibliotecas dependentes!
debug.o: debug.c debug.h
	gcc ${CFLAGS} -c debug.c

funcoes.o: funcoes.c funcoes.h
	gcc ${CFLAGS} -c funcoes.c

estruturas.o: estruturas.c estruturas.h
	gcc ${CFLAGS} -c estruturas.c

listas.o: listas.c listas.h
	gcc ${CFLAGS} -c listas.c

${CMD}.o: ${CMD}.c
	gcc ${CFLAGS} -c ${CMD}.c

# geracao dos ficheiros pelo gengetopt
${CMD}.c: ${CMD}.ggo
	gengetopt < ${CMD}.ggo -F ${CMD}

#ps_schedule
${EXECNAME2}: ${EXECNAME2}.o ${CMD_PS}.o debug.o funcoes_pschedule.o makefile
	gcc ${CFLAGS} ${EXECNAME2}.o ${CMD_PS}.o  debug.o funcoes_pschedule.o -o ${EXECNAME2} ${LIBS}

${CMD_PS}.o: ${CMD_PS}.c
	gcc ${CFLAGS} -c ${CMD_PS}.c

#geracao dos ficheiros pelo gengetopt
${CMD_PS}.c: ${CMD_PS}.ggo
	gengetopt < ${CMD_PS}.ggo -F ${CMD_PS}

${EXECNAME2}.o: ${EXECNAME2}.c makefile
	gcc ${CFLAGS} -c ${EXECNAME2}.c

funcoes_pschedule.o: funcoes_pschedule.c funcoes_pschedule.h
	gcc ${CFLAGS} -c funcoes_pschedule.c

clean:
	rm -f *.o core.* ${EXECNAME} ${EXECNAME2} *~

