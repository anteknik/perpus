package widget;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TextArea extends JTextArea
{
    private static final long serialVersionUID = 1L;
    
    public TextArea() {
        this.setOpaque(false);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setFont(this.getFont().deriveFont(0, 11.0f));
        this.setForeground(new Color(205, 214, 255));
        this.setSelectionColor(new Color(204, 51, 0));
        this.setCaretColor(Color.white);
        this.setSize(1, 23);
    }
}
