package j2gether.testes;

import j2gether.model.J2Gether;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class MainTest {

    private J2Gether jogo = new J2Gether(60,60,1,0);
    private double init;

    public MainTest() {

        init = System.currentTimeMillis();
        for (int k = 0; k < 50; k++) {
            jogo = new J2Gether(400,400,3,0);
            jogo.jogar(399, 0);
            jogo.jogar(399, 0);
        }
        System.out.println((System.currentTimeMillis() - init ));

        init = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            jogo  = new J2Gether(400,400,3,0);
            jogo.wizard();
        }
        System.out.println((System.currentTimeMillis() - init ));

    }

    public static void main(String[] args) {
        new MainTest();
    }
}
