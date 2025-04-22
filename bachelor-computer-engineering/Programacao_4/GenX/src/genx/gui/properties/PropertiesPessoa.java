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
public class PropertiesPessoa extends PropertiesInspector implements RepresentacaoListener {

    private Pessoa pessoa;

    private JSplitPane splitPane;
    private JTextField inputNome = new JTextField();
    private JDateChooser dataNascChooser = new JDateChooser();
    private JDateChooser dataObitoChooser = new JDateChooser(true);
    private JCheckBox checkBoxObito = new JCheckBox("Falecido");
    private JRadioButton rbMacho = new JRadioButton("Masculino:");
    private JRadioButton rbFemea = new JRadioButton("Feminino:");
    private JButton foto = new JButton();
    private String fotografia;

    public PropertiesPessoa(Object owner) {
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

        rbMacho.addActionListener(new PropertiesPessoa_RadioButtonMacho_ActionAdapter(this));
        rbFemea.addActionListener(new PropertiesPessoa_RadioButtonFemea_ActionAdapter(this));

        ButtonGroup btnGroup = new ButtonGroup();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);
        VerticalFlowLayout verticalFlowLayout = new VerticalFlowLayout();
        JPanel painelEsquerdo = new JPanel(verticalFlowLayout);
        JPanel painelDireito = new JPanel(verticalFlowLayout);

        aLabel = new JLabel("Nome:");
        aLabel.setPreferredSize(new Dimension(30, 18));
        painelEsquerdo.add(aLabel);
        inputNome.setPreferredSize(new Dimension(279, 18));
        painelDireito.add(inputNome);

        aLabel = new JLabel("Data Nascimento:");
        aLabel.setPreferredSize(new Dimension(84, 18));
        painelEsquerdo.add(aLabel);
        painelDireito.add(dataNascChooser);

        aLabel = new JLabel("Data Óbito:");
        aLabel.setPreferredSize(new Dimension(53, 32));
        painelEsquerdo.add(aLabel);

        aPanel = new JPanel(verticalFlowLayout);
        aPanel.setBorder(BorderFactory.createEtchedBorder());
        checkBoxObito.addActionListener(new PropertiesPessoa_CheckBoxObito_ActionAdapter(this));
        aPanel.add(checkBoxObito);
        aPanel.add(dataObitoChooser);
        painelDireito.add(aPanel);

        painelEsquerdo.add(Box.createVerticalStrut(24));

        aLabel = new JLabel("Sexo:");
        aLabel.setPreferredSize(new Dimension(28, 18));
        painelEsquerdo.add(aLabel);

        rbMacho.setPreferredSize(new Dimension(78, 18));
        rbFemea.setPreferredSize(new Dimension(70, 18));
        btnGroup.add(rbMacho);
        btnGroup.add(rbFemea);
        aPanel = new JPanel(flowLayout);
        aPanel.add(rbMacho);
        aPanel.add(rbFemea);
        painelDireito.add(aPanel);

        aLabel = new JLabel("Fotografia:");
        aLabel.setPreferredSize(new Dimension(52, 18));
        painelEsquerdo.add(aLabel);
        foto.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        foto.addActionListener(new PropertiesPessoa_ButtonFoto_ActionAdapter(this));
        aPanel = new JPanel(flowLayout);
        aPanel.add(foto);
        painelDireito.add(aPanel);

        aButton = new JButton("Save");
        aButton.addActionListener(new PropertiesPessoa_ButtonSave_ActionAdapter(this));
        aPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        aPanel.add(aButton);
        painelDireito.add(aPanel);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelEsquerdo, painelDireito);
        splitPane.setPreferredSize(new Dimension(270,300));
        add(splitPane);

        setMinimumSize(new Dimension(270,300));
    }

    public void dataChanged(RepresentacaoEvent event) {

        pessoa = (Pessoa)((RepresentacaoPessoa)event.getSource()).getOwner();
        inputNome.setText(pessoa.getNome());
        dataNascChooser.setDate(pessoa.getDataNasc().getTime());

        if (pessoa.getDataObito() != null) {
            dataObitoChooser.setDateFormatString(dataNascChooser.getDateFormatString());
            dataObitoChooser.setDate(pessoa.getDataObito().getTime());
            dataObitoChooser.getSpinner().setEnabled(true);
            checkBoxObito.setSelected(true);
        }
        else {
            JPanel panel = (JPanel)((JPanel)splitPane.getRightComponent()).getComponent(2);
            dataObitoChooser = new JDateChooser(true);
            panel.remove(1);
            panel.add(dataObitoChooser, 1);
            dataObitoChooser.getSpinner().setEnabled(false);
            checkBoxObito.setSelected(false);
        }

        if (pessoa.getSexo() == Pessoa.SEXO_FEMININO)
            rbFemea.setSelected(true);
        else
            rbMacho.setSelected(true);

        fotografia = pessoa.getFotografia();
        foto.setIcon(ImageLoader.getLoader().getScaledIcon(pessoa.getFotografia(), 32, 32));

        ((JSplitPane)getOwner()).setLeftComponent(this);
        requestFocus();
    }

    public void pessoaSelected(RepresentacaoEvent event) {
    }

    public void relacionamentoSelected(RepresentacaoEvent event) {
    }

    public void seleccionarNome() {
        inputNome.requestFocus();
        inputNome.selectAll();
    }

    public void radioButtonMacho_actionPerformed(ActionEvent actionEvent) {
        fotografia = pessoa.getFotografia(Pessoa.SEXO_MASCULINO);
        foto.setIcon(ImageLoader.getLoader().getScaledIcon(fotografia, 32, 32));
    }

    public void radioButtonFemea_actionPerformed(ActionEvent actionEvent) {
        fotografia = pessoa.getFotografia(Pessoa.SEXO_FEMININO);
        foto.setIcon(ImageLoader.getLoader().getScaledIcon(fotografia, 32, 32));
    }

    public void checkBoxObito_actionPerformed(ActionEvent actionEvent) {
        dataObitoChooser.getSpinner().setEnabled(checkBoxObito.isSelected());
        dataObitoChooser.setDateFormatString(dataNascChooser.getDateFormatString());
        if (pessoa.getDataObito() == null)
            dataObitoChooser.setDate(new GregorianCalendar().getTime());
    }

    public void buttonSave_actionPerformed(ActionEvent actionEvent) {
        GregorianCalendar calendar;
        pessoa.setNome(inputNome.getText());

        calendar = new GregorianCalendar();
        calendar.setTime(dataNascChooser.getDate());
        try {
            pessoa.setDataNasc(calendar);
        }
        catch (GenXDataInvalidaException ex) {
            new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            if (checkBoxObito.isSelected()) {
                calendar = new GregorianCalendar();
                calendar.setTime(dataObitoChooser.getDate());
                pessoa.setDataObito(calendar);
            }
            else {
                pessoa.setDataObito(null);
            }
        }
        catch (GenXDataInvalidaException ex) {
            new JOptionPane().showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        if (rbFemea.isSelected())
            pessoa.setSexo(Pessoa.SEXO_FEMININO);
        else
            pessoa.setSexo(Pessoa.SEXO_MASCULINO);

        pessoa.setFotografia(fotografia);
    }

    public void buttonFoto_actionPerformed(ActionEvent actionEvent) {
        JFileChooser file = new JFileChooser();
        FileExtensionFilter fileFilter = new FileExtensionFilter();
        fileFilter.addExtension("jpg");
        fileFilter.addExtension("gif");
        fileFilter.addExtension("png");
        fileFilter.setDescription("Ficheiros de fotografias");
        file.setFileFilter(fileFilter);
        if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION && file.getSelectedFile() != null) {
            fotografia = file.getSelectedFile().toString();
            foto.setIcon(ImageLoader.getLoader().getScaledIcon(fotografia, 32, 32));
        }
    }

}


class PropertiesPessoa_RadioButtonMacho_ActionAdapter
    implements ActionListener {
    PropertiesPessoa adaptee;
    PropertiesPessoa_RadioButtonMacho_ActionAdapter(PropertiesPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.radioButtonMacho_actionPerformed(actionEvent);
    }
}

class PropertiesPessoa_RadioButtonFemea_ActionAdapter
    implements ActionListener {
    PropertiesPessoa adaptee;
    PropertiesPessoa_RadioButtonFemea_ActionAdapter(PropertiesPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.radioButtonFemea_actionPerformed(actionEvent);
    }
}

class PropertiesPessoa_CheckBoxObito_ActionAdapter
    implements ActionListener {
    PropertiesPessoa adaptee;
    PropertiesPessoa_CheckBoxObito_ActionAdapter(PropertiesPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.checkBoxObito_actionPerformed(actionEvent);
    }
}

class PropertiesPessoa_ButtonSave_ActionAdapter
    implements ActionListener {
    PropertiesPessoa adaptee;
    PropertiesPessoa_ButtonSave_ActionAdapter(PropertiesPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.buttonSave_actionPerformed(actionEvent);
    }
}

class PropertiesPessoa_ButtonFoto_ActionAdapter
    implements ActionListener {
    PropertiesPessoa adaptee;
    PropertiesPessoa_ButtonFoto_ActionAdapter(PropertiesPessoa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.buttonFoto_actionPerformed(actionEvent);
    }
}
