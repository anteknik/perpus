package fungsi;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

public class WarnaTable extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 1) {
            component.setBackground(new Color(90, 0, 90));
        }
        else {
            component.setBackground(new Color(100, 15, 105));
        }
        return component;
    }
}
