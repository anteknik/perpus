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

public class CariPengarang extends JPanel
{
    private DefaultTableModel tabModePng;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllPng;
    private Button BtnCariPng;
    private Label LCount;
    private TextBox TCariPng;
    private TextBox TKdPng;
    private TextBox TNmPng;
    private Label label3;
    private Label label4;
    private Label label5;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbPengarang;
    
    public CariPengarang() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(400, 300);
        final Object[] rowPng = { "<html><font color='#006699' face='Comic Sans MS'>ID Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Merk/Type</font></html>" };
        this.tabModePng = new DefaultTableModel((Object[][])null, rowPng) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPengarang.setModel(this.tabModePng);
        this.koneksi.panggilDriver();
        this.tbPengarang.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbPengarang.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbPengarang.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(350);
            }
            else if (i == 1) {
                column.setPreferredWidth(500);
            }
        }
        this.tbPengarang.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariPng.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPng));
    }
    
    private void initComponents() {
        this.TKdPng = new TextBox();
        this.TNmPng = new TextBox();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariPng = new TextBox();
        this.BtnCariPng = new Button();
        this.BtnAllPng = new Button();
        this.label4 = new Label();
        this.label5 = new Label();
        this.LCount = new Label();
        this.scrollPane1 = new ScrollPane();
        this.tbPengarang = new Table();
        this.TKdPng.setName("TKdPng");
        this.TKdPng.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmPng.setName("TNmPng");
        this.TNmPng.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setOpaque(false);
        this.setLayout(new BorderLayout(1, 1));
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
        this.TCariPng.setName("TCariPng");
        this.TCariPng.setPreferredSize(new Dimension(500, 23));
        this.TCariPng.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPengarang.this.TCariPngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariPng);
        this.BtnCariPng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPng.setMnemonic('2');
        this.BtnCariPng.setToolTipText("Alt+2");
        this.BtnCariPng.setCursor(new Cursor(12));
        this.BtnCariPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPng.setName("BtnCariPng");
        this.BtnCariPng.setPreferredSize(new Dimension(26, 23));
        this.BtnCariPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariPengarang.this.BtnCariPngActionPerformed(evt);
            }
        });
        this.BtnCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPengarang.this.BtnCariPngKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariPengarang.this.BtnCariPngKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariPng);
        this.BtnAllPng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPng.setMnemonic('1');
        this.BtnAllPng.setToolTipText("Alt+1");
        this.BtnAllPng.setCursor(new Cursor(12));
        this.BtnAllPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPng.setName("BtnAllPng");
        this.BtnAllPng.setPreferredSize(new Dimension(26, 23));
        this.BtnAllPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariPengarang.this.BtnAllPngActionPerformed(evt);
            }
        });
        this.BtnAllPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPengarang.this.BtnAllPngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPng);
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
        this.tbPengarang.setAutoCreateRowSorter(true);
        this.tbPengarang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPengarang.setName("tbPengarang");
        this.tbPengarang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariPengarang.this.tbPengarangMouseClicked(evt);
            }
        });
        this.tbPengarang.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPengarang.this.tbPengarangKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPengarang);
        this.add(this.scrollPane1, "Center");
    }
    
    private void TCariPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAllPng, (JButton)this.BtnCariPng);
        }
    }
    
    private void BtnCariPngActionPerformed(final ActionEvent evt) {
        this.prosesCariPng("select * from pengarang where kode_pengarang like '%" + this.TCariPng.getText().trim() + "%' " + "or nama_pengarang like '%" + this.TCariPng.getText().trim() + "%' ");
    }
    
    private void BtnCariPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariPng, (JButton)this.BtnAllPng);
        }
    }
    
    private void BtnCariPngKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllPngActionPerformed(final ActionEvent evt) {
        this.tampilPng();
    }
    
    private void BtnAllPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariPng, (JButton)this.BtnAllPng);
        }
    }
    
    private void tbPengarangMouseClicked(final MouseEvent evt) {
        if (this.tabModePng.getRowCount() != 0) {
            try {
                this.getDataPng();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPengarangKeyPressed(final KeyEvent evt) {
        if (this.tabModePng.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataPng();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public void tampilPng() {
        final String sql = "select * from pengarang order by kode_pengarang";
        this.prosesCariPng(sql);
    }
    
    private void prosesCariPng(final String sql) {
        this.Valid.tabelKosong(this.tabModePng);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String kd = rs.getString(1);
                final String nm = rs.getString(2);
                final String[] data = { kd, nm };
                this.tabModePng.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModePng.getRowCount();
        this.LCount.setText("" + b);
    }
    
    private void getDataPng() {
        final int row = this.tbPengarang.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModePng.getValueAt(row, 0).toString();
            final String nama = this.tabModePng.getValueAt(row, 1).toString();
            this.TKdPng.setText(kode);
            this.TNmPng.setText(nama);
        }
    }
}
