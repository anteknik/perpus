package widget;

import usu.widget.glass.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class ScrollPane extends JScrollPane
{
    private static final long serialVersionUID = 1L;
    
    public ScrollPane() {
        this.setViewport((JViewport)new ViewPortGlass());
        this.setOpaque(false);
        this.setBorder(new LineBorder(new Color(204, 210, 255)));
    }
}
