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

public class CariAnggota extends JPanel
{
    private DefaultTableModel tabModeAnggota;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllAgt;
    private Button BtnCariAgt;
    private Label LCount;
    private TextBox TCariAgt;
    private TextBox TNmA;
    private TextBox TNoA;
    private Label label3;
    private Label label4;
    private Label label5;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbAnggota;
    
    public CariAnggota() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] rowAnggota = { "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Bergabung</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keanggotaan Habis</font></html>" };
        this.tabModeAnggota = new DefaultTableModel((Object[][])null, rowAnggota) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbAnggota.setModel(this.tabModeAnggota);
        this.koneksi.panggilDriver();
        this.tbAnggota.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbAnggota.setAutoResizeMode(0);
        for (int i = 0; i < 10; ++i) {
            final TableColumn column = this.tbAnggota.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(260);
            }
            else if (i == 2) {
                column.setPreferredWidth(150);
            }
            else if (i == 3) {
                column.setPreferredWidth(120);
            }
            else if (i == 4) {
                column.setPreferredWidth(50);
            }
            else if (i == 5) {
                column.setPreferredWidth(350);
            }
            else if (i == 6) {
                column.setPreferredWidth(110);
            }
            else if (i == 7) {
                column.setPreferredWidth(180);
            }
            else if (i == 8) {
                column.setPreferredWidth(110);
            }
            else if (i == 9) {
                column.setPreferredWidth(130);
            }
        }
        this.tbAnggota.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariAgt.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariAgt));
    }
    
    private void initComponents() {
        this.TNoA = new TextBox();
        this.TNmA = new TextBox();
        this.scrollPane1 = new ScrollPane();
        this.tbAnggota = new Table();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariAgt = new TextBox();
        this.BtnCariAgt = new Button();
        this.BtnAllAgt = new Button();
        this.label4 = new Label();
        this.label5 = new Label();
        this.LCount = new Label();
        this.TNoA.setName("TNoA");
        this.TNoA.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmA.setName("TNmA");
        this.TNmA.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setOpaque(false);
        this.setLayout(new BorderLayout(1, 1));
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane1.setName("scrollPane1");
        this.tbAnggota.setAutoCreateRowSorter(true);
        this.tbAnggota.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbAnggota.setName("tbAnggota");
        this.tbAnggota.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariAnggota.this.tbAnggotaMouseClicked(evt);
            }
        });
        this.tbAnggota.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariAnggota.this.tbAnggotaKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbAnggota);
        this.add(this.scrollPane1, "Center");
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
        this.TCariAgt.setName("TCariAgt");
        this.TCariAgt.setPreferredSize(new Dimension(500, 23));
        this.TCariAgt.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariAnggota.this.TCariAgtKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariAgt);
        this.BtnCariAgt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariAgt.setMnemonic('2');
        this.BtnCariAgt.setToolTipText("Alt+2");
        this.BtnCariAgt.setCursor(new Cursor(12));
        this.BtnCariAgt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariAgt.setName("BtnCariAgt");
        this.BtnCariAgt.setPreferredSize(new Dimension(26, 23));
        this.BtnCariAgt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariAnggota.this.BtnCariAgtActionPerformed(evt);
            }
        });
        this.BtnCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariAnggota.this.BtnCariAgtKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariAnggota.this.BtnCariAgtKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariAgt);
        this.BtnAllAgt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllAgt.setMnemonic('1');
        this.BtnAllAgt.setToolTipText("Alt+1");
        this.BtnAllAgt.setCursor(new Cursor(12));
        this.BtnAllAgt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllAgt.setName("BtnAllAgt");
        this.BtnAllAgt.setPreferredSize(new Dimension(26, 23));
        this.BtnAllAgt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariAnggota.this.BtnAllAgtActionPerformed(evt);
            }
        });
        this.BtnAllAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariAnggota.this.BtnAllAgtKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllAgt);
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
    }
    
    private void tbAnggotaMouseClicked(final MouseEvent evt) {
        if (this.tabModeAnggota.getRowCount() != 0) {
            try {
                this.getDataAnggota();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbAnggotaKeyPressed(final KeyEvent evt) {
        if (this.tabModeAnggota.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataAnggota();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void TCariAgtKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariAgtActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAllAgt, (JButton)this.BtnCariAgt);
        }
    }
    
    private void BtnCariAgtActionPerformed(final ActionEvent evt) {
        this.prosesCariAnggota("select * from anggota where no_anggota like '%" + this.TCariAgt.getText().trim() + "%' " + "or nama_anggota like '%" + this.TCariAgt.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCariAgt.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCariAgt.getText().trim() + "%' " + "or j_kel like '%" + this.TCariAgt.getText().trim() + "%' " + "or alamat like '%" + this.TCariAgt.getText().trim() + "%' " + "or no_telp like '%" + this.TCariAgt.getText().trim() + "%' " + "or tgl_gabung like '%" + this.TCariAgt.getText().trim() + "%' " + "or masa_berlaku like '%" + this.TCariAgt.getText().trim() + "%' " + "or email like '%" + this.TCariAgt.getText().trim() + "%' order by no_anggota");
    }
    
    private void BtnCariAgtKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariAgtActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariAgt, (JButton)this.BtnAllAgt);
        }
    }
    
    private void BtnCariAgtKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllAgtActionPerformed(final ActionEvent evt) {
        this.tampilAnggota("");
    }
    
    private void BtnAllAgtKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllAgtActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariAgt, (JButton)this.BtnAllAgt);
        }
    }
    
    public void tampilAnggota(final String key) {
        final String sql = "select * from anggota " + key + " order by no_anggota";
        this.prosesCariAnggota(sql);
    }
    
    private void prosesCariAnggota(final String sql) {
        this.Valid.tabelKosong(this.tabModeAnggota);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10) };
                this.tabModeAnggota.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModeAnggota.getRowCount();
        this.LCount.setText("" + b);
    }
    
    private void getDataAnggota() {
        final int row = this.tbAnggota.getSelectedRow();
        if (row != -1) {
            this.TNoA.setText(this.tabModeAnggota.getValueAt(row, 0).toString());
            this.TNmA.setText(this.tabModeAnggota.getValueAt(row, 1).toString());
        }
    }
}
