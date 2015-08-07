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

public class CariPenerbit extends JPanel
{
    private DefaultTableModel tabModePnb;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllPnb;
    private Button BtnCariPnb;
    private Label LCount;
    private TextBox TCariPnb;
    private TextBox TKdPnb;
    private TextBox TNmPnb;
    private Label label3;
    private Label label4;
    private Label label5;
    private PanelGlass panelGlass3;
    private ScrollPane scrollPane1;
    private Table tbPenerbit;
    
    public CariPenerbit() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] rowPnb = { "<html><font color='#006699' face='Comic Sans MS'>Kode Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>E-Mail</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Website Produsen</font></html>" };
        this.tabModePnb = new DefaultTableModel((Object[][])null, rowPnb) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPenerbit.setModel(this.tabModePnb);
        this.koneksi.panggilDriver();
        this.tbPenerbit.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPenerbit.setAutoResizeMode(0);
        for (int i = 0; i < 6; ++i) {
            final TableColumn column = this.tbPenerbit.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(200);
            }
            else if (i == 2) {
                column.setPreferredWidth(300);
            }
            else if (i == 3) {
                column.setPreferredWidth(130);
            }
            else if (i == 4) {
                column.setPreferredWidth(150);
            }
            else if (i == 5) {
                column.setPreferredWidth(150);
            }
        }
        this.tbPenerbit.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariPnb.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPnb));
    }
    
    private void initComponents() {
        this.TKdPnb = new TextBox();
        this.TNmPnb = new TextBox();
        this.scrollPane1 = new ScrollPane();
        this.tbPenerbit = new Table();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariPnb = new TextBox();
        this.BtnCariPnb = new Button();
        this.BtnAllPnb = new Button();
        this.label4 = new Label();
        this.label5 = new Label();
        this.LCount = new Label();
        this.TKdPnb.setName("TKdPnb");
        this.TKdPnb.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmPnb.setName("TNmPnb");
        this.TNmPnb.setSelectedTextColor(new Color(255, 255, 255));
        this.setBackground(new Color(255, 180, 255));
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane1.setName("scrollPane1");
        this.tbPenerbit.setAutoCreateRowSorter(true);
        this.tbPenerbit.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPenerbit.setName("tbPenerbit");
        this.tbPenerbit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                CariPenerbit.this.tbPenerbitMouseClicked(evt);
            }
        });
        this.tbPenerbit.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPenerbit.this.tbPenerbitKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPenerbit);
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
        this.TCariPnb.setName("TCariPnb");
        this.TCariPnb.setPreferredSize(new Dimension(500, 23));
        this.TCariPnb.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPenerbit.this.TCariPnbKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariPnb);
        this.BtnCariPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPnb.setMnemonic('2');
        this.BtnCariPnb.setToolTipText("Alt+2");
        this.BtnCariPnb.setCursor(new Cursor(12));
        this.BtnCariPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPnb.setName("BtnCariPnb");
        this.BtnCariPnb.setPreferredSize(new Dimension(26, 23));
        this.BtnCariPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariPenerbit.this.BtnCariPnbActionPerformed(evt);
            }
        });
        this.BtnCariPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPenerbit.this.BtnCariPnbKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                CariPenerbit.this.BtnCariPnbKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariPnb);
        this.BtnAllPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPnb.setMnemonic('1');
        this.BtnAllPnb.setToolTipText("Alt+1");
        this.BtnAllPnb.setCursor(new Cursor(12));
        this.BtnAllPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPnb.setName("BtnAllPnb");
        this.BtnAllPnb.setPreferredSize(new Dimension(26, 23));
        this.BtnAllPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                CariPenerbit.this.BtnAllPnbActionPerformed(evt);
            }
        });
        this.BtnAllPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                CariPenerbit.this.BtnAllPnbKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPnb);
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
    
    private void tbPenerbitMouseClicked(final MouseEvent evt) {
        if (this.tabModePnb.getRowCount() != 0) {
            try {
                this.getDataPnb();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPenerbitKeyPressed(final KeyEvent evt) {
        if (this.tabModePnb.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataPnb();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void TCariPnbKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPnbActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAllPnb, (JButton)this.BtnCariPnb);
        }
    }
    
    private void BtnCariPnbActionPerformed(final ActionEvent evt) {
        this.prosesCariPnb("select * from penerbit where kode_penerbit like '%" + this.TCariPnb.getText().trim() + "%' " + "or nama_penerbit like '%" + this.TCariPnb.getText().trim() + "%' " + "or website_penerbit like '%" + this.TCariPnb.getText().trim() + "%' " + "or alamat_penerbit like '%" + this.TCariPnb.getText().trim() + "%' " + "or no_telp like '%" + this.TCariPnb.getText().trim() + "%' " + "or email like '%" + this.TCariPnb.getText().trim() + "%' order by kode_penerbit");
    }
    
    private void BtnCariPnbKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPnbActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariPnb, (JButton)this.BtnAllPnb);
        }
    }
    
    private void BtnCariPnbKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllPnbActionPerformed(final ActionEvent evt) {
        this.tampilPnb();
    }
    
    private void BtnAllPnbKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllPnbActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariPnb, (JTextField)this.TCariPnb);
        }
    }
    
    public void tampilPnb() {
        final String sql = "select * from penerbit order by kode_penerbit";
        this.prosesCariPnb(sql);
    }
    
    private void prosesCariPnb(final String sql) {
        this.Valid.tabelKosong(this.tabModePnb);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) };
                this.tabModePnb.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModePnb.getRowCount();
        this.LCount.setText("" + b);
    }
    
    private void getDataPnb() {
        final int row = this.tbPenerbit.getSelectedRow();
        if (row != -1) {
            this.TKdPnb.setText(this.tabModePnb.getValueAt(row, 0).toString());
            this.TNmPnb.setText(this.tabModePnb.getValueAt(row, 1).toString());
        }
    }
}
