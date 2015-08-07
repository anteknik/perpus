package fungsi;

import javax.swing.table.*;

public class formatColumn
{
    private DefaultTableModel model;
    private TableColumnModel tcm;
    private TableColumn tc;
    public static int curr;
    public static int angka;
    public static int kanan;
    public static int tengah;
    public static int tanggal;
    
    public void setColumnFormat(final DefaultTableModel tabMode, final int column, final int format) {
        this.tc = this.tcm.getColumn(column);
        switch (format) {
            default: {}
        }
    }
    
    static {
        formatColumn.curr = 0;
        formatColumn.angka = 1;
        formatColumn.kanan = 2;
        formatColumn.tengah = 3;
        formatColumn.tanggal = 4;
    }
}
