package fungsi;

import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import uz.ncipro.calendar.*;
import datechooser.beans.*;
import java.sql.*;
import java.io.*;
import net.sf.jasperreports.engine.xml.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.*;
import java.awt.*;
import java.util.*;

public class validasi
{
    private int a;
    koneksiDB koneksi;
    
    public validasi() {
        this.koneksi = new koneksiDB();
    }
    
    public void textKosong(final JTextField teks, final String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }
    
    public void textKosong(final JTextArea teks, final String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }
    
    public void tabelKosong(final DefaultTableModel tabMode) {
        for (int row = tabMode.getRowCount(), i = 0; i < row; ++i) {
            tabMode.removeRow(0);
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextField kiri, final JTextField kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextField kiri, final JTextArea kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextField kiri, final JButton kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JButton kiri, final JTextField kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JButton kiri, final JButton kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextField kiri, final JComboBox kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextArea kiri, final JComboBox kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JComboBox kiri, final JTextField kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JComboBox kiri, final JDateTimePicker kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JDateTimePicker kiri, final JTextField kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JComboBox kiri, final JComboBox kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JComboBox kiri, final JButton kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JButton kiri, final JComboBox kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JComboBox kiri, final DateChooserCombo kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextArea kiri, final JButton kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void pindah(final KeyEvent evt, final JTextArea kiri, final JTextField kanan) {
        if (evt.getKeyCode() == 34) {
            kanan.requestFocus();
        }
        else if (evt.getKeyCode() == 33) {
            kiri.requestFocus();
        }
    }
    
    public void loadCombo(final JComboBox cmb, final String field, final String table) {
        cmb.removeAllItems();
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery("select " + field + " from " + table + " order by " + field);
            while (rs.next()) {
                final String item = rs.getString(1);
                cmb.addItem(item);
                ++this.a;
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void hapusTable(final DefaultTableModel tabMode, final JTextField nilai_field, final String table, final String field) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        }
        else if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (!nilai_field.getText().trim().equals("")) {
            final sekuel HapusData = new sekuel();
            HapusData.meghapus(table, field, nilai_field.getText());
        }
    }
    
    public void hapusTable(final DefaultTableModel tabMode, final JComboBox nilai_field, final String table, final String field) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        }
        else if (nilai_field.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (nilai_field.getSelectedItem() != "") {
            final sekuel HapusData = new sekuel();
            final String data = (String)nilai_field.getSelectedItem();
            HapusData.meghapus(table, field, data);
        }
    }
    
    public void editTable(final DefaultTableModel tabMode, final String table, final String field_acuan, final JTextField nilai_field, final String update) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        }
        else if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (!nilai_field.getText().trim().equals("")) {
            final sekuel EditData = new sekuel();
            EditData.mengedit(table, field_acuan + "='" + nilai_field.getText() + "'", update);
        }
    }
    
    public void editTable(final DefaultTableModel tabMode, final String table, final String field_acuan, final JComboBox nilai_field, final String update) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        }
        else if (nilai_field.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (nilai_field.getSelectedItem() != "") {
            final sekuel EditData = new sekuel();
            EditData.mengedit(table, field_acuan + "='" + nilai_field.getSelectedItem() + "'", update);
        }
    }
    
    public void textKosong(final JComboBox teks, final String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }
    
    public void MyReport(final String reportName, final String reportDirName, final String judul, final String qry) {
        final Properties systemProp = System.getProperties();
        final String currentDir = systemProp.getProperty("user.dir");
        final File dir = new File(currentDir);
        String fullPath = "";
        if (dir.isDirectory()) {
            final String[] isiDir = dir.list();
            for (int i = 0; i < isiDir.length; ++i) {
                final File fileRpt = new File(currentDir + File.separatorChar + isiDir[i] + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) {
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                }
            }
        }
        final String[] subRptDir = fullPath.split(reportName);
        final String reportDir = subRptDir[0];
        com.mysql.jdbc.Connection con = null;
        try {
            con = (com.mysql.jdbc.Connection)new koneksiDB().condb();
            final com.mysql.jdbc.Statement stm = (com.mysql.jdbc.Statement)con.createStatement();
            final Map<String, Object> parameters = new HashMap<String, Object>();
            try {
                final String namafile = "./" + reportDirName + "/" + reportName;
                final File reportfile = new File(namafile);
                final JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(qry);
                final JasperDesign jasperDesign = JRXmlLoader.load(reportfile);
                jasperDesign.setQuery(newQuery);
                final JasperReport JRpt = JasperCompileManager.compileReport(jasperDesign);
                final JasperPrint jasperPrint = JasperFillManager.fillReport(JRpt, (Map)parameters, (Connection)con);
                final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle(judul);
                jasperViewer.setAlwaysOnTop(false);
                final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                jasperViewer.setSize(screen.width - 50, screen.height - 50);
                jasperViewer.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
                jasperViewer.setLocationRelativeTo((Component)null);
                jasperViewer.setVisible(true);
            }
            catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
                JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void autoNomer(final DefaultTableModel tabMode, final String strAwal, final Integer pnj, final JTextField teks) {
        final String s = Integer.toString(tabMode.getRowCount() + 1);
        final Integer j = s.length();
        String s2 = "";
        for (int i = 1; i <= pnj - j; ++i) {
            s2 += "0";
        }
        teks.setText(strAwal + s2 + s);
    }
    
    public void LoadTahun(final JComboBox cmb) {
        final Calendar now = Calendar.getInstance();
        final int year = now.get(1);
        cmb.removeAllItems();
        for (int i = 1950; i <= year; ++i) {
            cmb.addItem(i);
        }
        cmb.setSelectedItem(year);
    }
}
