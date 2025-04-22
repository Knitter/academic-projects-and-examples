package genx.modelo;

import java.util.*;

import genx.listas.*;
import genx.modelo.exceptions.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Test {
    public Test() {
        ArvoreGeneologica arv = new ArvoreGeneologica();
        Pessoa p1 = new Pessoa("Pai 1", new GregorianCalendar(1990, 10, 15), 0);
        Pessoa p2 = new Pessoa("Mae 1", new GregorianCalendar(1990, 10, 15), 1);
        Pessoa p3 = new Pessoa("Mae 2", new GregorianCalendar(1990, 10, 15), 1);
        Pessoa p4 = new Pessoa("Filho 1", new GregorianCalendar(1990, 10, 15), 0);
        Pessoa p5 = new Pessoa("Filho 2", new GregorianCalendar(), 0);
        Pessoa p6 = new Pessoa("Filho 3", new GregorianCalendar(), 0);
        Pessoa p7 = new Pessoa("Meio Irmao 1", new GregorianCalendar(), 0);
        Pessoa p8 = new Pessoa("Meio Irmao 2", new GregorianCalendar(), 0);
        Pessoa p9 = new Pessoa("Meio Irmao 3", new GregorianCalendar(), 0);
        Pessoa p10 = new Pessoa("Irmao do Pai", new GregorianCalendar(), 0);
        Pessoa p11 = new Pessoa("Tia", new GregorianCalendar(), 1);
        Pessoa p12 = new Pessoa("Avo", new GregorianCalendar(), 0);
        Pessoa p13 = new Pessoa("Avó ", new GregorianCalendar(), 1);
        Pessoa p14 = new Pessoa("Primo 1", new GregorianCalendar(), 0);
        Pessoa p15 = new Pessoa("Primo 2", new GregorianCalendar(), 0);
        Pessoa p16 = new Pessoa("BISAVÓ", new GregorianCalendar(), 1);
        Pessoa p17 = new Pessoa("NOT", new GregorianCalendar(), 0);

        /*CONDICIONANTES DE TESTE - ARVORE DE TESTE*/
        arv.addPessoa(p1);
        arv.addPessoa(p2);
        arv.addPessoa(p3);
        arv.addPessoa(p4);
        arv.addPessoa(p5);
        arv.addPessoa(p6);
        arv.addPessoa(p7);
        arv.addPessoa(p8);
        arv.addPessoa(p9);
        arv.addPessoa(p10);
        arv.addPessoa(p11);
        arv.addPessoa(p12);
        arv.addPessoa(p13);
        arv.addPessoa(p14);
        arv.addPessoa(p15);
        arv.addPessoa(p16);
        arv.addPessoa(p17);


            try {
                /*Bisavos*/
                arv.criarRelacionamento(p17, p16);
                /*tios*/
                arv.criarRelacionamento(p11, p10);
                /*Avós*/
                arv.criarRelacionamento(p12, p13);
                /*Pai 1 + Mae 1*/
                arv.criarRelacionamento(p1, p2);
                /*Pai 1 + Mae 2*/
                arv.criarRelacionamento(p1, p3);
            }
            catch (GenXRelacionamentoNecrofilosException ex) {
                System.out.println(ex);
            }
            catch (GenXSexosIguaisException ex) {
                System.out.println(ex);
            }

        /*remover pessoa NOT*/
        arv.removerPessoa(p17);


        Iterador it = arv.iteradorListaRelacionamentos();
        Relacionamento um = (Relacionamento)it.avancar();/*pai 1 Mae 2*/
        Relacionamento dois = (Relacionamento)it.avancar();/*pai 1 mae 1*/
        Relacionamento tres = (Relacionamento)it.avancar();/*avos*/
        Relacionamento quatro = (Relacionamento)it.avancar();/*tios*/
        Relacionamento cinco = (Relacionamento)it.avancar();/*bisavos*/

        try {
            /*bisavos*/
            arv.adicionarFilho(p12, cinco);

            /*Pai e tio*/
            arv.adicionarFilho(p10, tres);
            arv.adicionarFilho(p1, tres);

            /*irmaos*/
            arv.adicionarFilho(p4, um);
            arv.adicionarFilho(p5, um);
            arv.adicionarFilho(p6, um);

            /*1/2 irmaos*/
            arv.adicionarFilho(p7, dois);
            arv.adicionarFilho(p8, dois);
            arv.adicionarFilho(p9, dois);

            /*primos*/
            arv.adicionarFilho(p14, quatro);
            arv.adicionarFilho(p15, quatro);
            /*FIM DAS CONDICIONATES DE TESTE*/
        }
        catch (GenXDataInvalidaException ex1) {
            System.out.println(ex1.getMessage());
        }


        /*TESTES*/
        /*Teste para verificar as datas*/
        /*p1.setDataObito(new GregorianCalendar());
        it = arv.consultarPessoasVivasEm(new GregorianCalendar());
        while(it.podeAvancar())
            System.out.println(it.avancar());*/


        /*Teste para consultar ascendentes de grau n*//*
        it = arv.consultarAscendentesGrauN(p4, 3);
        while(it.podeAvancar())
            System.out.println(it.avancar());*/


       /*Teste para consultar primos*//*
       it = arv.consultarPrimos(p4);
       while(it.podeAvancar())
           System.out.println(it.avancar());*/


        /*Teste para consultar filhos*//*
        it = arv.consultarFilhos(p1);
        while(it.podeAvancar())
            System.out.println(it.avancar());*/

        /*Teste de consulta de meios irmaos*/
        it = arv.consultarMeiosIrmaos(p8);
        while(it.podeAvancar())
            System.out.println(it.avancar());


        /*Teste de consulta a irmaos*//*
        it = arv.consultarIrmaos(p8);
        while(it.podeAvancar())
            System.out.println(it.avancar());

        /*Teste de consulta por nome*//*
        it = arv.consultarPorNome("b");
        while(it.podeAvancar())
          System.out.println(it.avancar());*/
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
