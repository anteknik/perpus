package cari;

import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.ScrollPane;
import fungsi.*;
import javax.swing.text.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CariInventaris extends JPanel
{
    private DefaultTableModel tabModeInventaris;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllIn;
    private Button BtnCariIn;
    private Label LCount;
    private TextBox TCariIn;
    private TextBox TNmI;
    private TextBox TNoI;
    private Label label3;
    private Label label4;
    private Label label5;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbInventaris;
    
    public CariInventaris() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] rowIn = { "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Brng</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nomer ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Asal Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Pengadaan</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Harga</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Stts.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Ruang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Rak</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Box</font></html>" };
        this.tabModeInventaris = new DefaultTableModel((Object[][])null, rowIn) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbInventaris.setModel(this.tabModeInventaris);
        this.koneksi.panggilDriver();
        this.tbInventaris.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbInventaris.setAutoResizeMode(0);
        for (int i = 0; i < 17; ++i) {
            final TableColumn column = this.tbInventaris.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(100);
            }
            else if (i == 2) {
                column.setPreferredWidth(350);
            }
            else if (i == 3) {
                column.setPreferredWidth(60);
            }
            else if (i == 4) {
                column.setPreferredWidth(200);
            }
            else if (i == 5) {
                column.setPreferredWidth(200);
            }
            else if (i == 6) {
                column.setPreferredWidth(70);
            }
            else if (i == 7) {
                column.setPreferredWidth(150);
            }
            else if (i == 8) {
                column.setPreferredWidth(160);
            }
            else if (i == 9) {
                column.setPreferredWidth(100);
            }
            else if (i == 10) {
                column.setPreferredWidth(150);
            }
            else if (i == 11) {
                column.setPreferredWidth(100);
            }
            else if (i == 12) {
                column.setPreferredWidth(100);
            }
            else if (i == 13) {
                column.setPreferredWidth(100);
            }
            else if (i == 14) {
                column.setPreferredWidth(150);
            }
            else if (i == 15) {
                column.setPreferredWidth(60);
            }
            else if (i == 16) {
                column.setPreferredWidth(60);
            }
        }
        this.tbInventaris.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariIn.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariIn));
    }
    
    private void initComponents() {
        this.TNoI = new TextBox();
        this.TNmI = new TextBox();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariIn = new TextBox();
        this.BtnCariIn = new Button();
        this.BtnAllIn = new Button();
        this.label4 = new Label();
        this.label5 = new Label();
        this.LCount = new Label();
        this.scrollPane1 = new ScrollPane();
        this.tbInventaris = new Table();
        this.TNoI.setName("TNoI");
        this.TNoI.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmI.setName("TNmI");
        this.TNmI.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(40, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label3.setHorizontalAlignment(4);
        this.label3.setText("Key Word :");
        this.label3.setName("label3");
        this.label3.setPreferredSize(new Dimension(63, 23));
        this.panelGlass3.add((Component)this.label3);
        this.TCariIn.setName("TCariIn");
        this.TCariIn.setPreferredSize(new Dimension(500, 23));
        this.TCariIn.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariInventaris.this.TCariInKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariIn);
        this.BtnCariIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariIn.setMnemonic('2');
        this.BtnCariIn.setToolTipText("Alt+2");
        this.BtnCariIn.setCursor(new Cursor(12));
        this.BtnCariIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariIn.setName("BtnCariIn");
        this.BtnCariIn.setPreferredSize(new Dimension(26, 23));
        this.BtnCariIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariInventaris.this.BtnCariInActionPerformed(evt);
            }
        });
        this.BtnCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariInventaris.this.BtnCariInKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariInventaris.this.BtnCariInKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariIn);
        this.BtnAllIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllIn.setMnemonic('1');
        this.BtnAllIn.setToolTipText("Alt+1");
        this.BtnAllIn.setCursor(new Cursor(12));
        this.BtnAllIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllIn.setName("BtnAllIn");
        this.BtnAllIn.setPreferredSize(new Dimension(26, 23));
        this.BtnAllIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariInventaris.this.BtnAllInActionPerformed(evt);
            }
        });
        this.BtnAllIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariInventaris.this.BtnAllInKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllIn);
        this.label4.setHorizontalAlignment(4);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label4);
        this.label5.setHorizontalAlignment(4);
        this.label5.setText("Record :");
        this.label5.setHorizontalTextPosition(0);
        this.label5.setName("label5");
        this.label5.setPreferredSize(new Dimension(50, 23));
        this.panelGlass3.add((Component)this.label5);
        this.LCount.setHorizontalAlignment(2);
        this.LCount.setText("0");
        this.LCount.setHorizontalTextPosition(0);
        this.LCount.setName("LCount");
        this.LCount.setPreferredSize(new Dimension(50, 23));
        this.panelGlass3.add((Component)this.LCount);
        this.add((Component)this.panelGlass3, "Last");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane1.setName("scrollPane1");
        this.tbInventaris.setAutoCreateRowSorter(true);
        this.tbInventaris.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbInventaris.setName("tbInventaris");
        this.tbInventaris.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariInventaris.this.tbInventarisMouseClicked(evt);
            }
        });
        this.tbInventaris.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariInventaris.this.tbInventarisKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbInventaris);
        this.add(this.scrollPane1, "Center");
    }
    
    private void TCariInKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariInActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAllIn, (JButton)this.BtnCariIn);
        }
    }
    
    private void BtnCariInActionPerformed(final ActionEvent evt) {
        final String sql = " inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
        this.prosesCariIn("SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where " + sql + "and Inventaris.no_inventaris like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.kode_buku like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.asal_buku like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.tgl_pengadaan like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.harga like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.status_buku like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Ruang.nm_ruang like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.no_rak like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and Inventaris.no_box like '%" + this.TCariIn.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCariIn.getText().trim() + "%' " + " order by Inventaris.no_inventaris");
    }
    
    private void BtnCariInKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariInActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariIn, (JButton)this.BtnAllIn);
        }
    }
    
    private void BtnCariInKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllInActionPerformed(final ActionEvent evt) {
        this.tampilIn("");
    }
    
    private void BtnAllInKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllInActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariIn, (JTextField)this.TCariIn);
        }
    }
    
    private void tbInventarisMouseClicked(final MouseEvent evt) {
        if (this.tabModeInventaris.getRowCount() != 0) {
            try {
                this.getDataIn();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbInventarisKeyPressed(final KeyEvent evt) {
        if (this.tabModeInventaris.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataIn();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public void tampilIn(final String key) {
        final String sql = "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori " + key + " and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris";
        this.prosesCariIn(sql);
    }
    
    private void prosesCariIn(final String sql) {
        this.Valid.tabelKosong(this.tabModeInventaris);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            double a = 0.0;
            while (rs.next()) {
                a += rs.getDouble(13);
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7).substring(0, 4), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) };
                this.tabModeInventaris.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModeInventaris.getRowCount();
        this.LCount.setText("" + b);
    }
    
    private void getDataIn() {
        final int row = this.tbInventaris.getSelectedRow();
        if (row != -1) {
            this.TNoI.setText(this.tabModeInventaris.getValueAt(row, 0).toString());
            this.TNmI.setText(this.tabModeInventaris.getValueAt(row, 2).toString());
        }
    }
}
