package widget;

import usu.widget.glass.*;
import java.awt.*;

public class PasswordBox extends usu.widget.glass.PasswordBox
{
    private static final long serialVersionUID = 1L;
    
    public PasswordBox() {
        this.setSelectionColor(Color.BLUE.brighter());
        this.setCaretColor(Color.white);
        this.setFont(this.getFont().deriveFont(1, 11.0f));
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(2);
    }
}
