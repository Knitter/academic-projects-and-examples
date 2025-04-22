package bdestudantil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.*;
import java.io.File;
import oracle.sql.BLOB;

public class AreaAluno{
    JPanel jPanelAreaAlunos = new JPanel();
    Connection con;
    public AreaAluno(JPanel jPanelAreaAlunos, Connection con) {
        this.jPanelAreaAlunos=jPanelAreaAlunos;
        this.con = con;
        guiInit();
    }

    JLabel jLabelNum = new JLabel("Número Aluno:");
    JTextField jTextFieldNum = new JTextField(6);
    JLabel jLabelPNome = new JLabel("Primeiro Nome:");
    JTextField jTextFieldPNome = new JTextField(25);
    JLabel jLabelNomesMeio = new JLabel("Nomes Meio:");
    JTextField jTextFieldNomesMeio = new JTextField(25);
    JLabel jLabelApelido = new JLabel("Apelido:");
    JTextField jTextFieldApelido = new JTextField(25);
    JLabel jLabelSexo = new JLabel("Sexo:");
    ButtonGroup sexoGroup = new ButtonGroup();
    JRadioButton jRadioSexoM = new JRadioButton("Masculino");
    JRadioButton jRadioSexoF = new JRadioButton("Feminino");
    JLabel jLabelDataNascimento = new JLabel("Data de Nascimento:");
    JTextField jTextFieldDataNascimento = new JTextField(10);
    JLabel jLabelNaturalidade = new JLabel("Naturalidade:");
    JTextField jTextFieldNaturalidade = new JTextField(35);
    JLabel jLabelNacionalidade = new JLabel("Nacionalidade:");
    JTextField jTextFieldNacionalidade = new JTextField(35);
    JLabel jLabelBI = new JLabel("BI:");
    JTextField jTextFieldBI = new JTextField(9);
    JLabel jLabelNumContribuinte = new JLabel("Número de Contribuinte:");
    JTextField jTextFieldNumContribuinte = new JTextField(9);
    JLabel jLabelNIB = new JLabel("NIB:");
    JTextField jTextFieldNIB = new JTextField(21);
    JLabel jLabelGrauAcademico = new JLabel("Grau Académico:");
    JTextField jTextFieldGrauAcademico = new JTextField(15);
    JLabel jLabelDataEntrada = new JLabel("Data de Entrada:");
    JTextField jTextFieldDataEntrada = new JTextField(10);
    JLabel jLabelEndereco = new JLabel("Endereço:");
    JTextArea jTextAreaEndereco = new JTextArea(3, 50);
    JLabel jLabelCodPostal = new JLabel("Código Postal:");
    JTextField jTextFieldCodPostal = new JTextField(7);
    JLabel jLabelLocalidade = new JLabel("Localidade:");
    JTextField jTextFieldLocalidade = new JTextField(30);
    JLabel jLabelAnoCurso = new JLabel("Ano do Curso:");
    JComboBox jComboAnoCurso = new JComboBox(new Integer[]{new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5)});
    JLabel jLabelPaginaPessoal = new JLabel("Página Pessoal:");
    JTextField jTextFieldPaginaPessoal = new JTextField(50);
    JLabel jLabelTrabalhador = new JLabel("Trabalhador-Estudante:");
    JCheckBox jCheckTrabalhador = new JCheckBox();
    JLabel jLabelTelefone = new JLabel("Telefone:");
    JTextField jTextFieldTelefone = new JTextField(9);
    JLabel jLabelEmail = new JLabel("E-mail:");
    JTextField jTextFieldEmail = new JTextField(50);
    GridBagLayout layout = new GridBagLayout();
    private void guiInit() {
        jPanelAreaAlunos.setVisible(false);
        jPanelAreaAlunos.removeAll();
        jPanelAreaAlunos.setVisible(true);
        jPanelAreaAlunos.setLayout(layout);
        jPanelAreaAlunos.add(jLabelNum,                 new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNum,             new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelPNome,               new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldPNome,           new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelNomesMeio,           new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNomesMeio,       new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelApelido,             new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldApelido,         new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelSexo,                new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        sexoGroup.add(jRadioSexoM);
        sexoGroup.add(jRadioSexoF);
        jPanelAreaAlunos.add(jRadioSexoM,               new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jRadioSexoF,               new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelDataNascimento,      new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldDataNascimento,  new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelNaturalidade,        new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNaturalidade,    new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelNacionalidade,       new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNacionalidade,   new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelBI,                  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldBI,              new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelNumContribuinte,     new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNumContribuinte, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelNIB,                 new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldNIB,             new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelGrauAcademico,       new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldGrauAcademico,   new GridBagConstraints(1, 11, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelDataEntrada,         new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldDataEntrada,     new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelAnoCurso,            new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jComboAnoCurso,            new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelEndereco,            new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jTextAreaEndereco.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        jPanelAreaAlunos.add(jTextAreaEndereco,         new GridBagConstraints(1, 14, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelCodPostal,           new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldCodPostal,       new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelLocalidade,          new GridBagConstraints(0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldLocalidade,      new GridBagConstraints(1, 16, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelPaginaPessoal,       new GridBagConstraints(0, 17, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldPaginaPessoal,    new GridBagConstraints(1, 17, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jCheckTrabalhador.setHorizontalTextPosition(JCheckBox.LEFT);
        jPanelAreaAlunos.add(jLabelTrabalhador,         new GridBagConstraints(0, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jCheckTrabalhador,         new GridBagConstraints(1, 18, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelTelefone,            new GridBagConstraints(0, 19, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldTelefone,        new GridBagConstraints(1, 19, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jLabelEmail,               new GridBagConstraints(0, 20, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        jPanelAreaAlunos.add(jTextFieldEmail,           new GridBagConstraints(1, 20, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
        JButton button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chamarProcedimento();
                System.out.println("OK");
            }
        });
        jPanelAreaAlunos.add(button,                    new GridBagConstraints(1, 21, 2, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2,2,2,2), 0, 0));
       // jPanelAreaAlunos.revalidate();
    }

    private void chamarProcedimento() {
        if(con != null) {
            try { //22
                CallableStatement s = con.prepareCall("{call proc_inserir_aluno(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                String nib = jTextFieldNIB.getText(), bi = jTextFieldBI.getText(), grauAcademico = jTextFieldGrauAcademico.getText();
                String numContribuinte = jTextFieldNumContribuinte.getText(),dataEntrada = jTextFieldDataEntrada.getText(), pagPessoal = jTextFieldPaginaPessoal.getText();
                String dataNascimento = jTextFieldDataNascimento.getText(), localidade = jTextFieldLocalidade.getText(), endereco = jTextAreaEndereco.getText();
                String codPostal = jTextFieldCodPostal.getText(), nome = jTextFieldPNome.getText(), nomesMeio = jTextFieldNomesMeio.getText();
                String apelido = jTextFieldApelido.getText(), sexo = jRadioSexoF.isSelected() ? "F" : "M";
                String mail = jTextFieldEmail.getText(), telefone = jTextFieldTelefone.getText(), /*fotografia*/trabalhador = jCheckTrabalhador.isSelected() ? "S" : "N";
                Integer ano = (Integer) jComboAnoCurso.getSelectedItem();
                String naturalidade = jTextFieldNaturalidade.getText(), nacionalidade = jTextFieldNacionalidade.getText();
                //fotografia

                s.setString(1, nib);
                s.setInt(2, Integer.parseInt(bi));
                s.setString(3, grauAcademico);
                s.setInt(4, Integer.parseInt(numContribuinte));
                s.setString(5, dataEntrada);
                s.setString(6, pagPessoal);
                s.setString(7, dataNascimento);
                s.setString(8, localidade);
                s.setString(9, endereco);
                s.setString(10, codPostal);
                s.setString(11, nome);
                s.setString(12, nomesMeio);
                s.setString(13, apelido);
                s.setString(14, sexo);
                s.setString(15, mail);
                s.setString(16, telefone);
                s.setBlob(17, BLOB.empty_lob());
                s.setString(18, trabalhador);
                s.setInt(19, ano.intValue());
                s.setString(20, naturalidade);
                s.setString(21, nacionalidade);
                s.setString(22, "0");
                s.execute();
                s.close();
                new JOptionPane().showMessageDialog(null, "Aluno inserido com sucesso", "Sucesso!", JOptionPane.PLAIN_MESSAGE);
            } catch (SQLException ex) {
                System.out.println(ex);
                new JOptionPane().showMessageDialog(null, "Aluno nao inserido", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
