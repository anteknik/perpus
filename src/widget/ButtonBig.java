package widget;

import usu.widget.glass.*;
import java.awt.*;

public class ButtonBig extends ButtonImageReflection
{
    private static final long serialVersionUID = 1L;
    
    public ButtonBig() {
        this.setForeground(Color.WHITE);
        this.setFont(this.getFont().deriveFont(1));
    }
}
