package genx.gui.properties;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.borland.jbcl.layout.*;
import com.toedter.calendar.*;
import genx.gui.eventos.*;
import genx.gui.representations.*;
import genx.modelo.*;
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
public class PropertiesRelacionamento extends PropertiesInspector implements RepresentacaoListener {

    private Relacionamento relacionamento;

    private JSplitPane splitPane;
    private JDateChooser dataInicioChooser = new JDateChooser();
    private JDateChooser dataFimChooser = new JDateChooser(true);
    private JCheckBox checkBoxFimRelacionamento = new JCheckBox("Terminado");

    public PropertiesRelacionamento(Object owner) {
        super(owner);
        try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JPanel aPanel;
        JLabel aLabel;
        JButton aButton;
        VerticalFlowLayout verticalFlowLayout = new VerticalFlowLayout();
        JPanel painelEsquerdo = new JPanel(verticalFlowLayout);
        JPanel painelDireito = new JPanel(verticalFlowLayout);

        aLabel = new JLabel("Data Inicio:");
        aLabel.setPreferredSize(new Dimension(84, 18));
        painelEsquerdo.add(aLabel);
        painelDireito.add(dataInicioChooser);

        aLabel = new JLabel("Data Fim:");
        aLabel.setPreferredSize(new Dimension(53, 18));
        painelEsquerdo.add(aLabel);

        aPanel = new JPanel(verticalFlowLayout);
        aPanel.setBorder(BorderFactory.createEtchedBorder());
        checkBoxFimRelacionamento.addActionListener(new PropertiesRelacionamento_checkBoxFimRelacionamento_ActionAdapter(this));
        aPanel.add(checkBoxFimRelacionamento);
        aPanel.add(dataFimChooser);
        painelDireito.add(aPanel);

        aButton = new JButton("Save");
        aButton.addActionListener(new PropertiesRelacionamento_ButtonSave_ActionAdapter(this));
        aPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 20));
        aPanel.add(aButton);
        painelDireito.add(aPanel);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerdo, painelDireito);
        splitPane.setPreferredSize(new Dimension(270,300));
        add(splitPane);

        setMinimumSize(new Dimension(270,300));
    }


    public void dataChanged(RepresentacaoEvent event) {
        relacionamento = (Relacionamento)((RepresentacaoRelacionamento)event.getSource()).getOwner();
        dataInicioChooser.setDate(relacionamento.getDataInicio().getTime());

        if (relacionamento.getDataFim() != null) {
            dataFimChooser.setDateFormatString(dataInicioChooser.getDateFormatString());
            dataFimChooser.setDate(relacionamento.getDataFim().getTime());
            dataFimChooser.getSpinner().setEnabled(true);
            checkBoxFimRelacionamento.setSelected(true);
        }
        else {
            JPanel panel = (JPanel)((JPanel)splitPane.getRightComponent()).getComponent(1);
            dataFimChooser = new JDateChooser(true);
            panel.remove(1);
            panel.add(dataFimChooser, 1);
            dataFimChooser.getSpinner().setEnabled(false);
            checkBoxFimRelacionamento.setSelected(false);
        }

        ((JSplitPane)getOwner()).setLeftComponent(this);
        requestFocus();
    }

    public void pessoaSelected(RepresentacaoEvent event) {
    }

    public void relacionamentoSelected(RepresentacaoEvent event) {
    }

    public void buttonSave_actionPerformed(ActionEvent actionEvent) {
        GregorianCalendar calendar;

        try {
            calendar = new GregorianCalendar();
            calendar.setTime(dataInicioChooser.getDate());
            relacionamento.setDataInicio(calendar);
        }
        catch (GenXDataInvalidaException ex) {
            new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            if(checkBoxFimRelacionamento.isSelected()) {
                calendar = new GregorianCalendar();
                calendar.setTime(dataFimChooser.getDate());
                relacionamento.setDataFim(calendar);
            }
            else
                relacionamento.setDataFim(null);
        }
        catch (GenXDataInvalidaException ex) {
            new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void checkBoxFimRelacionamento_ActionAdapter(ActionEvent e) {
        dataFimChooser.getSpinner().setEnabled(checkBoxFimRelacionamento.isSelected());
        dataFimChooser.setDateFormatString(dataInicioChooser.getDateFormatString());
        if (relacionamento.getDataFim() == null)
            dataFimChooser.setDate(new GregorianCalendar().getTime());
    }

}


class PropertiesRelacionamento_checkBoxFimRelacionamento_ActionAdapter
    implements ActionListener {
    PropertiesRelacionamento adaptee;
    PropertiesRelacionamento_checkBoxFimRelacionamento_ActionAdapter(PropertiesRelacionamento adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.checkBoxFimRelacionamento_ActionAdapter(actionEvent);
    }
}

class PropertiesRelacionamento_ButtonSave_ActionAdapter
    implements ActionListener {
    PropertiesRelacionamento adaptee;
    PropertiesRelacionamento_ButtonSave_ActionAdapter(PropertiesRelacionamento adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.buttonSave_actionPerformed(actionEvent);
    }
}
