package genx.gui.properties;

import java.awt.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;
import genx.modelo.*;
import genx.modelo.eventos.*;
import genx.utils.*;

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
public class PropertiesArvore extends PropertiesInspector implements ArvoreGeneologicaListener{

    private JLabel lblPessoas;
    private JLabel lblRelacionamentos;
    private int numPessoas;
    private int numRelacionamentos;

    public PropertiesArvore(Object owner) {
        super(owner);
        ((ArvoreGeneologica)owner).addArvoreGeneologicaListener(this);
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setLayout(new VerticalFlowLayout());
        setPreferredSize(new Dimension(280,300));
        setMinimumSize(new Dimension(280,300));

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Numero de Pessoas:", ImageLoader.getLoader().getScaledIcon("/genx/imagens/pessoaMale.png", 16, 16), JLabel.LEADING));
        lblPessoas = new JLabel(Integer.toString(numPessoas));
        panel.add(lblPessoas);
        add(panel);

        panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Numero de Relacionamentos:", ImageLoader.getLoader().getScaledIcon("/genx/imagens/ralationship.png", 16, 16), JLabel.LEADING));
        lblRelacionamentos = new JLabel(Integer.toString(numRelacionamentos));
        panel.add(lblRelacionamentos);
        add(panel);
        lblPessoas.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroPessoas()));
        lblRelacionamentos.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroRelacionamentos()));
    }

    public void pessoaAdded(ArvoreGeneologicaEvent event) {
        lblPessoas.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroPessoas()));
    }

    public void pessoaRemoved(ArvoreGeneologicaEvent event) {
        lblPessoas.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroPessoas()));
    }

    public void relacionamentoParentAdded(ArvoreGeneologicaEvent event) {
        lblRelacionamentos.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroRelacionamentos()));
    }

    public void relacionamentoChildAdded(ArvoreGeneologicaEvent event) {
    }

    public void relacionamentoChanged(ArvoreGeneologicaEvent event) {
    }

    public void relacionamentoRemoved(ArvoreGeneologicaEvent event) {
        lblRelacionamentos.setText(Integer.toString(((ArvoreGeneologica) getOwner()).numeroRelacionamentos()));
    }

}
