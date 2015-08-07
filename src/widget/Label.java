package widget;

import usu.widget.*;
import java.awt.*;

public class Label extends usu.widget.Label
{
    private static final long serialVersionUID = 1L;
    
    public Label() {
        this.setForeground(new Color(205, 214, 255));
        this.setFont(this.getFont().deriveFont(0, 11.0f));
    }
}
