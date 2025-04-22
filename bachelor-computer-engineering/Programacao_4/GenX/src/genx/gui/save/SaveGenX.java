package genx.gui.save;

import java.io.*;
import java.util.*;

import genx.gui.representations.*;
import genx.listas.*;
import genx.modelo.*;

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
public class SaveGenX implements Serializable {

    private ArvoreGeneologica arvore;
    private ListaSimplesCircularBaseFim listPessoas = new ListaSimplesCircularBaseFim();
    private ListaSimplesCircularBaseFim listRelacionamentos = new ListaSimplesCircularBaseFim();

    public SaveGenX(ArvoreGeneologica arvore, Iterator it) {
        this.arvore = arvore;
        while(it.hasNext()) {
            Representacao r = (Representacao) it.next();
            if (r.saveRepresentacaoPessoa() != null)
                listPessoas.inserir(r.saveRepresentacaoPessoa());
            if (r.saveRepresentacaoRelacionamento() != null)
                listRelacionamentos.inserir(r.saveRepresentacaoRelacionamento());
        }
    }

    public void save(File saveFile) {
        FileOutputStream f = null;
        try {
            ObjectOutputStream o = new ObjectOutputStream(f = new FileOutputStream(saveFile));
            o.writeObject(this);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (f != null)
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
        }
    }

    public static SaveGenX load(File openFile) {
        SaveGenX save = null;
        FileInputStream f = null;
        try {
            ObjectInputStream i = new ObjectInputStream(f = new FileInputStream(openFile));
            save = (SaveGenX) i.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (f != null)
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            return save;
        }
    }

    public ArvoreGeneologica getArvore() {
        return arvore;
    }

    public Iterador getListaPessoas() {
        return listPessoas.iteradorLista();
    }

    public Iterador getListaRelacionamentos() {
        return listRelacionamentos.iteradorLista();
    }

}
