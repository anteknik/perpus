package widget;

import usu.widget.*;
import java.awt.*;

public class Button extends ButtonGlass
{
    private static final long serialVersionUID = 1L;
    
    public Button() {
        this.setFont(this.getFont().deriveFont(1));
        this.setForeground(new Color(205, 214, 255));
        this.setRoundRect(true);
    }
}
