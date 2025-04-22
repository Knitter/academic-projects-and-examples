package bdestudantil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import bdestudantil.jdbc.ConfiguracaoLigacao;
import com.borland.jbcl.layout.VerticalFlowLayout;

public class AreaResultados{
    JPanel jPanelAreaResultados;
    Connection con;

    public AreaResultados(JPanel jPanelAreaDepartamento, Connection con) {
        this.jPanelAreaResultados=jPanelAreaDepartamento;
        this.con = con;
        guiInit();

    }

    JLabel jLabelCodDepartamento = new JLabel("Código do Departamento:");
    JTextField jTextFieldCodDepartamento = new JTextField(6);
    JLabel jLabelAbreviatura = new JLabel("Abreviatura:");
    JTextField jTextFieldAbreviatura = new JTextField(12);
    JLabel jLabelDesignacao = new JLabel("Designação:");
    JTextField jTextFieldDesignacao = new JTextField(50);
    JButton jButtonInsert = new JButton("insert");
    JButton jButtonConsult = new JButton("Consultar");
    JButton jButtonClear = new JButton("clear");
    JTextArea area = new JTextArea();
    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    private void guiInit() {
        jPanelAreaResultados.setVisible(false);
        jPanelAreaResultados.removeAll();
        jPanelAreaResultados.setVisible(true);
        jPanelAreaResultados.setLayout(verticalFlowLayout1);

        area.setPreferredSize(new Dimension(100, 400));
        JScrollPane jsp = new JScrollPane(area);

        jsp.setVerticalScrollBarPolicy(jsp.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(jsp.HORIZONTAL_SCROLLBAR_NEVER);
        jPanelAreaResultados.add(jsp);

        JPanel t = new JPanel();
        t.setLayout(verticalFlowLayout1);
        t.add(jButtonConsult);
        jPanelAreaResultados.add(t);

        jButtonConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                callSelect();
            }
        });

    }

    private void callSelect() {
        if(con != null) {
            try {
                area.setText("");
                Statement s = con.createStatement();
                s.execute("select * from tbl_aluno");
                ResultSet rs = s.getResultSet();
                area.append("cod_aluno");
                area.append("\n");
                while(rs.next()) {
                    area.append(rs.getString(1) + "\t");
                    area.append(rs.getString(2) + "\t");
                    area.append(rs.getString(3) + "\t");
                    area.append(rs.getString(4) + "\t");
                    area.append(rs.getString(5) + "\t");
                    area.append(rs.getString(6) + "\t");
                    area.append(rs.getString(7) + "\t");
                    area.append("\n");
                }
            } catch (SQLException ex) {
                area.setText(ex.getMessage());
                System.out.println(ex);
            }
        }
    }
}
