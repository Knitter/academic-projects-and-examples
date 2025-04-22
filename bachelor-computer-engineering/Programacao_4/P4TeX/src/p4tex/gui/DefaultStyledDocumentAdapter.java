package p4tex.gui;

import javax.swing.text.*;

import p4tex.modelo.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class DefaultStyledDocumentAdapter extends DefaultStyledDocument implements TextoListener {

    public DefaultStyledDocumentAdapter(Texto texto) {
        texto.addTextoListener(this);
    }

    public void writeText(TextoEvent e) {
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attr, e.getEstilo().getTipoDeFonte());
        StyleConstants.setFontSize(attr, e.getEstilo().getTamanhoDaFonte());
        StyleConstants.setBold(attr, e.getEstilo().isNegrito());
        StyleConstants.setItalic(attr, e.getEstilo().isItalico());
        StyleConstants.setUnderline(attr, e.getEstilo().isSublinhado());
        StyleConstants.setForeground(attr, e.getEstilo().getCor());
        StyleConstants.setStrikeThrough(attr, e.isWrongWord());
        try {
            insertString(getLength(), e.getTexto(), attr);
        }
        catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void removeAllText(TextoEvent event) {
        try {
            remove(0, getLength());
        }
        catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
