package widget;

import javax.swing.*;
import java.awt.*;

public class Table extends JTable
{
    private static final long serialVersionUID = 1L;
    
    public Table() {
        this.setBackground(new Color(90, 0, 90));
        this.setGridColor(new Color(90, 10, 90));
        this.setForeground(new Color(205, 214, 255));
        this.setSelectionBackground(new Color(153, 0, 153));
        this.setSelectionForeground(new Color(160, 160, 160));
        this.setFont(this.getFont().deriveFont(0, 11.0f));
    }
}
