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

public class CariKategori extends JPanel
{
    private DefaultTableModel tabModeKtg;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllKtg;
    private Button BtnCariKtg;
    private Button BtnCloseKtg;
    private TextBox TCariKtg;
    private TextBox TKdKtg;
    private TextBox TNmKtg;
    private Label label3;
    private Label label4;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbKategori;
    
    public CariKategori() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(400, 300);
        final Object[] rowKtg = { "<html><font color='#006699' face='Comic Sans MS'>ID Kategori</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Kategori</font></html>" };
        this.tabModeKtg = new DefaultTableModel((Object[][])null, rowKtg) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbKategori.setModel(this.tabModeKtg);
        this.koneksi.panggilDriver();
        this.tbKategori.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbKategori.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbKategori.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(120);
            }
            else if (i == 1) {
                column.setPreferredWidth(335);
            }
        }
        this.tbKategori.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariKtg.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariKtg));
    }
    
    private void initComponents() {
        this.TKdKtg = new TextBox();
        this.TNmKtg = new TextBox();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariKtg = new TextBox();
        this.BtnCariKtg = new Button();
        this.BtnAllKtg = new Button();
        this.label4 = new Label();
        this.BtnCloseKtg = new Button();
        this.scrollPane1 = new ScrollPane();
        this.tbKategori = new Table();
        this.TKdKtg.setName("TKdKtg");
        this.TKdKtg.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmKtg.setName("TNmKtg");
        this.TNmKtg.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setLayout(new BorderLayout(1, 1));
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(255, 225, 255)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(40, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label3.setHorizontalAlignment(4);
        this.label3.setText("Key Word :");
        this.label3.setName("label3");
        this.label3.setPreferredSize(new Dimension(63, 23));
        this.panelGlass3.add((Component)this.label3);
        this.TCariKtg.setName("TCariKtg");
        this.TCariKtg.setPreferredSize(new Dimension(200, 23));
        this.TCariKtg.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariKategori.this.TCariKtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariKtg);
        this.BtnCariKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariKtg.setMnemonic('2');
        this.BtnCariKtg.setToolTipText("Alt+2");
        this.BtnCariKtg.setCursor(new Cursor(12));
        this.BtnCariKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariKtg.setName("BtnCariKtg");
        this.BtnCariKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnCariKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariKategori.this.BtnCariKtgActionPerformed(evt);
            }
        });
        this.BtnCariKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariKategori.this.BtnCariKtgKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariKategori.this.BtnCariKtgKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariKtg);
        this.BtnAllKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllKtg.setMnemonic('1');
        this.BtnAllKtg.setToolTipText("Alt+1");
        this.BtnAllKtg.setCursor(new Cursor(12));
        this.BtnAllKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllKtg.setName("BtnAllKtg");
        this.BtnAllKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnAllKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariKategori.this.BtnAllKtgActionPerformed(evt);
            }
        });
        this.BtnAllKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariKategori.this.BtnAllKtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllKtg);
        this.label4.setHorizontalAlignment(4);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label4);
        this.BtnCloseKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseKtg.setMnemonic('3');
        this.BtnCloseKtg.setToolTipText("Alt+3");
        this.BtnCloseKtg.setCursor(new Cursor(12));
        this.BtnCloseKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseKtg.setName("BtnCloseKtg");
        this.BtnCloseKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariKategori.this.BtnCloseKtgActionPerformed(evt);
            }
        });
        this.BtnCloseKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariKategori.this.BtnCloseKtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCloseKtg);
        this.add((Component)this.panelGlass3, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 225, 255)));
        this.scrollPane1.setName("scrollPane1");
        this.tbKategori.setAutoCreateRowSorter(true);
        this.tbKategori.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbKategori.setName("tbKategori");
        this.tbKategori.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariKategori.this.tbKategoriMouseClicked(evt);
            }
        });
        this.tbKategori.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariKategori.this.tbKategoriKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbKategori);
        this.add(this.scrollPane1, "Center");
    }
    
    private void TCariKtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariKtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseKtg, (JButton)this.BtnCariKtg);
        }
    }
    
    private void BtnCariKtgActionPerformed(final ActionEvent evt) {
        this.prosesCariKtg("select * from kategori where id_kategori like '%" + this.TCariKtg.getText().trim() + "%' " + "or nama_kategori like '%" + this.TCariKtg.getText().trim() + "%' ");
    }
    
    private void BtnCariKtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariKtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariKtg, (JButton)this.BtnAllKtg);
        }
    }
    
    private void BtnCariKtgKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllKtgActionPerformed(final ActionEvent evt) {
        this.tampilKtg();
    }
    
    private void BtnAllKtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllKtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariKtg, (JButton)this.BtnCloseKtg);
        }
    }
    
    private void BtnCloseKtgActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    private void BtnCloseKtgKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllKtg, (JTextField)this.TCariKtg);
    }
    
    private void tbKategoriMouseClicked(final MouseEvent evt) {
        if (this.tabModeKtg.getRowCount() != 0) {
            try {
                this.getDataKtg();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbKategoriKeyPressed(final KeyEvent evt) {
        if (this.tabModeKtg.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataKtg();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public void tampilKtg() {
        final String sql = "select * from kategori order by id_kategori";
        this.prosesCariKtg(sql);
    }
    
    private void prosesCariKtg(final String sql) {
        this.Valid.tabelKosong(this.tabModeKtg);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String kd = rs.getString(1);
                final String nm = rs.getString(2);
                final String[] data = { kd, nm };
                this.tabModeKtg.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void getDataKtg() {
        final int row = this.tbKategori.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModeKtg.getValueAt(row, 0).toString();
            final String nama = this.tabModeKtg.getValueAt(row, 1).toString();
            this.TKdKtg.setText(kode);
            this.TNmKtg.setText(nama);
        }
    }
}
