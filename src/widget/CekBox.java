package widget;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class CekBox extends JCheckBox
{
    private static final long serialVersionUID = 1L;
    
    public CekBox() {
        this.setFont(this.getFont().deriveFont(0, 11.0f));
        this.setBackground(new Color(255, 180, 255));
        this.setForeground(new Color(205, 214, 255));
        this.setFocusPainted(false);
        this.setBorder(new EmptyBorder(1, 1, 1, 1));
        this.setOpaque(false);
        this.setSize(1, 23);
    }
}
