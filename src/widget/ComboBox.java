package widget;

import java.awt.*;
import javax.swing.*;

public final class ComboBox extends JComboBox
{
    private static final long serialVersionUID = 1L;
    
    public ComboBox() {
        this.setFont(this.getFont().deriveFont(0, 11.0f));
        this.setBackground(new Color(90, 0, 90));
        this.setForeground(new Color(205, 214, 255));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setSize(1, 23);
    }
}
