package p4tex.p4utils;

public class ListaSimplesCircularBaseLimite implements ListaSimplesADT, java.io.Serializable  {
        private ComparacaoInfimo criterio;
        private NoListaSimplesCircularBaseLimite noInicial;

        public ListaSimplesCircularBaseLimite(ComparacaoInfimo criterio)  {
                this.criterio = criterio;
                noInicial = new NoListaSimplesCircularBaseLimite(criterio.infimo());
        }

        public void inserir(Object elem)  {
                NoListaSimplesCircularBaseLimite ant = pesquisar(elem);
                ant.seguinte = new NoListaSimplesCircularBaseLimite(elem, ant.seguinte);
        }

        /** Remove após consultar */
        public boolean remover(Object elem)  {
                NoListaSimplesCircularBaseLimite ant = pesquisar(elem);
                while (criterio.comparar(elem, ant.seguinte.elemento) == 0
                                && !ant.seguinte.elemento.equals(elem))
                        ant = ant.seguinte;
                if (!ant.seguinte.elemento.equals(elem))
                        return false;
                ant.seguinte = ant.seguinte.seguinte;
                return true;
        }

        public boolean vazia()  {
                return noInicial.seguinte == noInicial;
        }

        public Object consultar(int indice)  {
                NoListaSimplesCircularBaseLimite aux = noInicial.seguinte;
                while (aux != noInicial)  {
                        if (indice-- == 0)
                                return aux.elemento;
                        aux = aux.seguinte;
                }
                return null;
        }

        public Iterador consultar(Object elem)  {
                NoListaSimplesCircularBaseLimite ant = pesquisar(elem);
                ListaSimplesCircularBaseLimite lc = new ListaSimplesCircularBaseLimite(criterio);
                while (criterio.comparar(elem, ant.seguinte.elemento) == 0)   {
                        lc.inserir(ant.seguinte.elemento);
                        ant = ant.seguinte;
                }
                return new IteradorListaSimplesCircularBaseLimite(lc.noInicial);
        }

        public int numElementos()  {
                int i=0;
                NoListaSimplesCircularBaseLimite aux = noInicial.seguinte;
                while (aux != noInicial)  {
                        i++;
                        aux = aux.seguinte;
                }
                return i;
        }

        public void removerTodos() {
                if (noInicial.seguinte != noInicial)
                {
                        NoListaSimplesCircularBaseLimite p = noInicial.seguinte, aux;
                        do {
                                aux = p;
                                p = p.seguinte;
                                aux.elemento = aux.seguinte = null;
                        }
                        while (p != noInicial);
                        noInicial.seguinte = noInicial;
                }
        }

        protected NoListaSimplesCircularBaseLimite pesquisar(Object elem)  {
                NoListaSimplesCircularBaseLimite ant = noInicial;
                while (criterio.comparar(elem, ant.seguinte.elemento) > 0)
                        ant = ant.seguinte;
                return ant;
        }

        public String toString()
        {
                StringBuffer s = new StringBuffer();
                s.append("Lista SCBLim = {\n");
                NoListaSimplesCircularBaseLimite aux = noInicial.seguinte;
                while (aux != noInicial)
                {
                        s.append(aux.elemento).append("\n");
                        aux = aux.seguinte;
                }
                s.append("}\n");
                return s.toString();
        }

        public Iterador iteradorLista()
        {
                return new IteradorListaSimplesCircularBaseLimite(noInicial);
        }
}

/* ************** */
/* Classes Locais */
/* ************** */
class NoListaSimplesCircularBaseLimite implements java.io.Serializable {
        Object elemento;
        NoListaSimplesCircularBaseLimite seguinte;

        // Criação do no base
        NoListaSimplesCircularBaseLimite(Object limite)  {
                elemento = limite;
                seguinte = this;
        }

        NoListaSimplesCircularBaseLimite(Object elem, NoListaSimplesCircularBaseLimite seg)  {
                elemento = elem;
                seguinte = seg;
        }

        protected void finalize()
        {
                elemento = seguinte = null;
        }
}


class IteradorListaSimplesCircularBaseLimite implements Iterador {
        private NoListaSimplesCircularBaseLimite noInicial,
                                                 corrente;

        IteradorListaSimplesCircularBaseLimite(NoListaSimplesCircularBaseLimite noInicial)  {
                this.noInicial = corrente = noInicial;
        }

        public boolean podeAvancar()  {
                return corrente.seguinte != noInicial;
        }

        public Object avancar()  {
                if (podeAvancar())  {
                        corrente = corrente.seguinte;
                        return corrente.elemento;
                }
                throw ELEMENTO_INVALIDO;
        }

        public Object corrente()  {
                if (corrente == noInicial)
                        throw ELEMENTO_INVALIDO;
                return corrente.elemento;
        }

        public void reiniciar()  {
                corrente = noInicial;
        }
}
