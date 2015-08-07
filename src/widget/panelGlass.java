package widget;

import usu.widget.*;
import java.awt.*;

public class panelGlass extends GlassPane
{
    private static final long serialVersionUID = 1L;
    
    public panelGlass() {
        this.setFont(this.getFont().deriveFont(1));
        this.setForeground(Color.WHITE);
    }
}
