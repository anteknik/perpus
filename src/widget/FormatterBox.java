package widget;

import usu.widget.glass.*;
import java.awt.*;
import usu.widget.text.*;
import usu.util.*;
import javax.swing.text.*;

public class FormatterBox extends FormatedTextBox
{
    private static final long serialVersionUID = 1L;
    
    public FormatterBox() {
        this.setFont(this.getFont().deriveFont(1));
        this.setForeground(Color.WHITE);
        this.setSelectionColor(Color.BLUE.brighter());
        this.setCaretColor(Color.white);
        this.setHorizontalAlignment(2);
        this.setDocument((Document)new DefaultDocument() {
            private static final long serialVersionUID = 1L;
            
            public void insertString(final int offs, final String str, final AttributeSet a) throws BadLocationException {
                if (StringUtil.containQuote(str)) {
                    return;
                }
                super.insertString(offs, str, a);
            }
        });
    }
}
