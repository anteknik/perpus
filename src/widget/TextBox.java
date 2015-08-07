package widget;

import usu.widget.glass.*;
import java.awt.*;

public class TextBox extends TextBoxGlass
{
    private static final long serialVersionUID = 1L;
    
    public TextBox() {
        this.setFont(this.getFont().deriveFont(0, 11.0f));
        this.setForeground(new Color(205, 214, 255));
        this.setSelectionColor(new Color(204, 51, 0));
        this.setCaretColor(Color.white);
        this.setHorizontalAlignment(2);
        this.setSize(1, 23);
    }
}
