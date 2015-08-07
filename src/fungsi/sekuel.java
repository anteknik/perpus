package fungsi;

import java.awt.*;
import java.sql.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;

public class sekuel
{
    public void menyimpan(final String table, final String value, final String sama) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement statement = connect.createStatement();
            final String sql = "insert into " + table + " values(" + value + ")";
            statement.executeUpdate(sql);
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Pesan Error : " + e);
            JOptionPane.showMessageDialog(null, "Maaf, gagal menyimpan data. Kemungkinan ada " + sama + " yang sama dimasukkan sebelumnya...!");
        }
    }
    
    public void meghapus(final String table, final String field, final String nilai_field) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement statement = connect.createStatement();
            final String sql = "delete from " + table + " where " + field + "='" + nilai_field + "'";
            statement.executeUpdate(sql);
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Pesan Error : " + e);
            JOptionPane.showMessageDialog(null, "Maaf, data gagal dihapus. Kemungkinan data tersebut masih dipakai di table lain...!!!!");
        }
    }
    
    public void mengedit(final String table, final String acuan_field, final String update) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement statement = connect.createStatement();
            final String sql = "update " + table + " set " + update + " where " + acuan_field;
            statement.executeUpdate(sql);
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Pesan Error : " + e);
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data yang mau anda edit...\n Klik data pada table untuk memilih...!!!!");
        }
    }
    
    public void query(final String qry) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement statement = connect.createStatement();
            statement.executeQuery(qry);
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Pesan Error : " + e);
            JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
        }
    }
    
    public void queryu(final String qry) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement statement = connect.createStatement();
            statement.executeUpdate(qry);
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            System.out.println("Pesan Error : " + e);
            JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
        }
    }
    
    public void cariIsi(final String sql, final JComboBox cmb) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                final String dicari = rs.getString(1);
                cmb.setSelectedItem(dicari);
            }
            else {
                cmb.setSelectedItem("");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void cariIsi(final String sql, final JTextField txt) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                final String dicari = rs.getString(1);
                txt.setText(dicari);
            }
            else {
                txt.setText("");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void cariIsi(final String sql, final JLabel txt) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                final String dicari = rs.getString(1);
                txt.setText(dicari);
            }
            else {
                txt.setText("");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void cariIsi(final String sql, String txt) {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                final String dicari = rs.getString(1);
                txt = rs.getString(1);
            }
            else {
                txt = "";
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void cariIsiAngka(final String sql, final JTextField txt) {
        final DecimalFormat df2 = new DecimalFormat("####");
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                txt.setText(df2.format(rs.getDouble(1)));
            }
            else {
                txt.setText("0");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void Tabel(final JTable tb, final int[] lebar) {
        tb.setAutoResizeMode(0);
        for (int kolom = tb.getColumnCount(), i = 0; i < kolom; ++i) {
            final TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
        }
    }
}
