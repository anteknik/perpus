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

public class CariJenis extends JPanel
{
    private DefaultTableModel tabModeJns;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllJns;
    private Button BtnCariJns;
    private Button BtnCloseJns;
    private TextBox TCariJns;
    private TextBox TKdJns;
    private TextBox TNmJns;
    private Label label3;
    private Label label4;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbJenis;
    
    public CariJenis() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(400, 300);
        final Object[] rowJns = { "<html><font color='#006699' face='Comic Sans MS'>ID Jenis</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Jenis</font></html>" };
        this.tabModeJns = new DefaultTableModel((Object[][])null, rowJns) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbJenis.setModel(this.tabModeJns);
        this.koneksi.panggilDriver();
        this.tbJenis.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbJenis.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbJenis.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(120);
            }
            else if (i == 1) {
                column.setPreferredWidth(335);
            }
        }
        this.tbJenis.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariJns.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariJns));
    }
    
    private void initComponents() {
        this.TKdJns = new TextBox();
        this.TNmJns = new TextBox();
        this.scrollPane1 = new ScrollPane();
        this.tbJenis = new Table();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariJns = new TextBox();
        this.BtnCariJns = new Button();
        this.BtnAllJns = new Button();
        this.label4 = new Label();
        this.BtnCloseJns = new Button();
        this.TKdJns.setName("TKdJns");
        this.TKdJns.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmJns.setName("TNmJns");
        this.TNmJns.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setLayout(new BorderLayout(1, 1));
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 225, 255)));
        this.scrollPane1.setName("scrollPane1");
        this.tbJenis.setAutoCreateRowSorter(true);
        this.tbJenis.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbJenis.setName("tbJenis");
        this.tbJenis.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariJenis.this.tbJenisMouseClicked(evt);
            }
        });
        this.tbJenis.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariJenis.this.tbJenisKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbJenis);
        this.add(this.scrollPane1, "Center");
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
        this.TCariJns.setName("TCariJns");
        this.TCariJns.setPreferredSize(new Dimension(200, 23));
        this.TCariJns.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariJenis.this.TCariJnsKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariJns);
        this.BtnCariJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariJns.setMnemonic('2');
        this.BtnCariJns.setToolTipText("Alt+2");
        this.BtnCariJns.setCursor(new Cursor(12));
        this.BtnCariJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariJns.setName("BtnCariJns");
        this.BtnCariJns.setPreferredSize(new Dimension(26, 23));
        this.BtnCariJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariJenis.this.BtnCariJnsActionPerformed(evt);
            }
        });
        this.BtnCariJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariJenis.this.BtnCariJnsKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariJenis.this.BtnCariJnsKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariJns);
        this.BtnAllJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllJns.setMnemonic('1');
        this.BtnAllJns.setToolTipText("Alt+1");
        this.BtnAllJns.setCursor(new Cursor(12));
        this.BtnAllJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllJns.setName("BtnAllJns");
        this.BtnAllJns.setPreferredSize(new Dimension(26, 23));
        this.BtnAllJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariJenis.this.BtnAllJnsActionPerformed(evt);
            }
        });
        this.BtnAllJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariJenis.this.BtnAllJnsKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllJns);
        this.label4.setHorizontalAlignment(4);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label4);
        this.BtnCloseJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseJns.setMnemonic('3');
        this.BtnCloseJns.setToolTipText("Alt+3");
        this.BtnCloseJns.setCursor(new Cursor(12));
        this.BtnCloseJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseJns.setName("BtnCloseJns");
        this.BtnCloseJns.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariJenis.this.BtnCloseJnsActionPerformed(evt);
            }
        });
        this.BtnCloseJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariJenis.this.BtnCloseJnsKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCloseJns);
        this.add((Component)this.panelGlass3, "First");
    }
    
    private void tbJenisMouseClicked(final MouseEvent evt) {
        if (this.tabModeJns.getRowCount() != 0) {
            try {
                this.getDataJns();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbJenisKeyPressed(final KeyEvent evt) {
        if (this.tabModeJns.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataJns();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void TCariJnsKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariJnsActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseJns, (JButton)this.BtnCariJns);
        }
    }
    
    private void BtnCariJnsActionPerformed(final ActionEvent evt) {
        this.prosesCariJns("select * from jenis_buku where id_jenis like '%" + this.TCariJns.getText().trim() + "%' " + "or nama_jenis like '%" + this.TCariJns.getText().trim() + "%' ");
    }
    
    private void BtnCariJnsKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariJnsActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariJns, (JButton)this.BtnAllJns);
        }
    }
    
    private void BtnCariJnsKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllJnsActionPerformed(final ActionEvent evt) {
        this.tampilJns();
    }
    
    private void BtnAllJnsKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllJnsActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariJns, (JButton)this.BtnCloseJns);
        }
    }
    
    private void BtnCloseJnsActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    private void BtnCloseJnsKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllJns, (JTextField)this.TCariJns);
    }
    
    public void tampilJns() {
        final String sql = "select * from jenis_buku order by id_jenis";
        this.prosesCariJns(sql);
    }
    
    private void prosesCariJns(final String sql) {
        this.Valid.tabelKosong(this.tabModeJns);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String kd = rs.getString(1);
                final String nm = rs.getString(2);
                final String[] data = { kd, nm };
                this.tabModeJns.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void getDataJns() {
        final int row = this.tbJenis.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModeJns.getValueAt(row, 0).toString();
            final String nama = this.tabModeJns.getValueAt(row, 1).toString();
            this.TKdJns.setText(kode);
            this.TNmJns.setText(nama);
        }
    }
}
