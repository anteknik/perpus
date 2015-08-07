package simpus;

import usu.widget.glass.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import widget.*;
import fungsi.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DlgRuang extends JDialog
{
    private DefaultTableModel tabModeRuang;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllRuang;
    private Button BtnBatal;
    private Button BtnCariRuang;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnSimpan;
    private Label LCount;
    private TextBox TCariRuang;
    private TextBox TKdR;
    private TextBox TNmR;
    private InternalFrame internalFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelGlass panelGlass3;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private Table tbRuang;
    
    public DlgRuang(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(459, 515);
        final Object[] rowRuang = { "<html><font color='#006699' face='Comic Sans MS'>ID Jenis</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Jenis</font></html>" };
        this.tabModeRuang = new DefaultTableModel((Object[][])null, rowRuang) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbRuang.setModel(this.tabModeRuang);
        this.koneksi.panggilDriver();
        this.tbRuang.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbRuang.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbRuang.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(120);
            }
            else if (i == 1) {
                column.setPreferredWidth(335);
            }
        }
        this.tbRuang.setDefaultRenderer(Object.class, new WarnaTable());
        this.TKdR.setDocument((Document)new batasInput(5).getFilter((JTextField)this.TKdR));
        this.TNmR.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TNmR));
        this.TCariRuang.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariRuang));
    }
    
    private void initComponents() {
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.label1 = new Label();
        this.TKdR = new TextBox();
        this.label2 = new Label();
        this.TNmR = new TextBox();
        this.scrollPane1 = new ScrollPane();
        this.tbRuang = new Table();
        this.jPanel1 = new JPanel();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariRuang = new TextBox();
        this.BtnCariRuang = new Button();
        this.BtnAllRuang = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnKeluar = new Button();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.setDefaultCloseOperation(2);
        this.setBackground(new Color(214, 204, 255));
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: DAFTAR RUANG ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(105, 10, 250, 21);
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2);
        this.jLabel2.setBounds(5, 0, 40, 40);
        this.getContentPane().add(this.panelJudul1, "First");
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(100, 49));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.label1.setText("ID Ruang :");
        this.label1.setName("label1");
        this.panelGlass1.add((Component)this.label1);
        this.label1.setBounds(13, 17, 80, 14);
        this.TKdR.setName("TKdR");
        this.TKdR.setSelectedTextColor(new Color(255, 255, 255));
        this.TKdR.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.TKdRKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TKdR);
        this.TKdR.setBounds(68, 12, 75, 23);
        this.label2.setText("Nama Ruang :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(172, 17, 90, 14);
        this.TNmR.setName("TNmR");
        this.TNmR.setSelectedTextColor(new Color(255, 255, 255));
        this.TNmR.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.TNmRKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNmR);
        this.TNmR.setBounds(243, 12, 202, 23);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.scrollPane1.setPreferredSize(new Dimension(452, 302));
        this.tbRuang.setAutoCreateRowSorter(true);
        this.tbRuang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbRuang.setName("tbRuang");
        this.tbRuang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgRuang.this.tbRuangMouseClicked(evt);
            }
        });
        this.tbRuang.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.tbRuangKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbRuang);
        this.internalFrame1.add(this.scrollPane1, "Center");
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setOpaque(false);
        this.jPanel1.setPreferredSize(new Dimension(100, 101));
        this.jPanel1.setLayout(new BorderLayout(1, 1));
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(100, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)null);
        this.label3.setText("Key Word :");
        this.label3.setName("label3");
        this.panelGlass3.add((Component)this.label3);
        this.label3.setBounds(15, 15, 80, 14);
        this.TCariRuang.setName("TCariRuang");
        this.TCariRuang.setSelectedTextColor(new Color(255, 255, 255));
        this.TCariRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.TCariRuangKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariRuang);
        this.TCariRuang.setBounds(72, 10, 207, 23);
        this.BtnCariRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariRuang.setMnemonic('2');
        this.BtnCariRuang.setToolTipText("Alt+2");
        this.BtnCariRuang.setCursor(new Cursor(12));
        this.BtnCariRuang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariRuang.setName("BtnCariRuang");
        this.BtnCariRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnCariRuangActionPerformed(evt);
            }
        });
        this.BtnCariRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnCariRuangKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariRuang);
        this.BtnCariRuang.setBounds(281, 10, 28, 23);
        this.BtnAllRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllRuang.setMnemonic('1');
        this.BtnAllRuang.setToolTipText("Alt+1");
        this.BtnAllRuang.setCursor(new Cursor(12));
        this.BtnAllRuang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllRuang.setName("BtnAllRuang");
        this.BtnAllRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnAllRuangActionPerformed(evt);
            }
        });
        this.BtnAllRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnAllRuangKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllRuang);
        this.BtnAllRuang.setBounds(310, 10, 28, 23);
        this.label4.setText("Record :");
        this.label4.setName("label4");
        this.panelGlass3.add((Component)this.label4);
        this.label4.setBounds(355, 15, 80, 14);
        this.LCount.setText("0");
        this.LCount.setName("LCount");
        this.panelGlass3.add((Component)this.LCount);
        this.LCount.setBounds(400, 15, 50, 14);
        this.jPanel1.add((Component)this.panelGlass3, "First");
        this.panelGlass2.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass2.setOpaqueImage(false);
        this.panelGlass2.setPreferredSize(new Dimension(100, 55));
        this.panelGlass2.setRound(false);
        this.panelGlass2.setWarna(new Color(90, 0, 90));
        this.panelGlass2.setLayout((LayoutManager)null);
        this.BtnSimpan.setMnemonic('S');
        this.BtnSimpan.setText("Simpan");
        this.BtnSimpan.setToolTipText("Alt+S");
        this.BtnSimpan.setCursor(new Cursor(12));
        this.BtnSimpan.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnSimpan.setName("BtnSimpan");
        this.BtnSimpan.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(6, 10, 86, 30);
        this.BtnBatal.setMnemonic('B');
        this.BtnBatal.setText("Batal");
        this.BtnBatal.setToolTipText("Alt+B");
        this.BtnBatal.setCursor(new Cursor(12));
        this.BtnBatal.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnBatal.setName("BtnBatal");
        this.BtnBatal.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnBatalKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnBatal);
        this.BtnBatal.setBounds(94, 10, 86, 30);
        this.BtnHapus.setMnemonic('H');
        this.BtnHapus.setText("Hapus");
        this.BtnHapus.setToolTipText("Alt+H");
        this.BtnHapus.setCursor(new Cursor(12));
        this.BtnHapus.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnHapus.setName("BtnHapus");
        this.BtnHapus.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnHapusKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnHapus);
        this.BtnHapus.setBounds(182, 10, 86, 30);
        this.BtnEdit.setMnemonic('E');
        this.BtnEdit.setText("Edit");
        this.BtnEdit.setToolTipText("Alt+E");
        this.BtnEdit.setCursor(new Cursor(12));
        this.BtnEdit.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnEdit.setName("BtnEdit");
        this.BtnEdit.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnEditKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnEdit);
        this.BtnEdit.setBounds(270, 10, 86, 30);
        this.BtnKeluar.setMnemonic('K');
        this.BtnKeluar.setText("Keluar");
        this.BtnKeluar.setToolTipText("Alt+K");
        this.BtnKeluar.setCursor(new Cursor(12));
        this.BtnKeluar.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnKeluar.setName("BtnKeluar");
        this.BtnKeluar.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgRuang.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgRuang.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluar);
        this.BtnKeluar.setBounds(364, 10, 86, 30);
        this.jPanel1.add((Component)this.panelGlass2, "Center");
        this.internalFrame1.add(this.jPanel1, "Last");
        this.getContentPane().add(this.internalFrame1, "Center");
        this.panel1.setName("panel1");
        this.panel1.setPreferredSize(new Dimension(440, 25));
        this.panel1.setLayout(new BorderLayout());
        this.jLabel5.setBackground(Color.darkGray);
        this.jLabel5.setFont(new Font("Tahoma", 1, 11));
        this.jLabel5.setForeground(new Color(255, 204, 255));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText(":: Semua field wajib diisi ::");
        this.jLabel5.setName("jLabel5");
        this.panel1.add(this.jLabel5, "Center");
        this.jSeparator1.setBackground(new Color(0, 0, 51));
        this.jSeparator1.setForeground(new Color(0, 0, 51));
        this.jSeparator1.setName("jSeparator1");
        this.jSeparator1.setPreferredSize(new Dimension(1, 1));
        this.panel1.add(this.jSeparator1, "First");
        this.getContentPane().add(this.panel1, "Last");
        this.pack();
    }
    
    private void TKdRKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TCariRuang, (JTextField)this.TNmR);
    }
    
    private void TNmRKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdR, (JButton)this.BtnSimpan);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TKdR.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdR, "ID Ruang");
        }
        else if (this.TNmR.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmR, "Nama Ruang");
        }
        else {
            this.Sequel.menyimpan("ruang", "'" + this.TKdR.getText() + "','" + this.TNmR.getText() + "'", "ID Ruang");
            this.tampilRuang();
            this.emptTeks();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TNmR, (JButton)this.BtnBatal);
        }
    }
    
    private void BtnBatalActionPerformed(final ActionEvent evt) {
        this.emptTeks();
    }
    
    private void BtnBatalKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.emptTeks();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnSimpan, (JButton)this.BtnHapus);
        }
    }
    
    private void BtnHapusActionPerformed(final ActionEvent evt) {
        this.Valid.hapusTable(this.tabModeRuang, (JTextField)this.TKdR, "ruang", "kd_ruang");
        this.tampilRuang();
        this.emptTeks();
    }
    
    private void BtnHapusKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnHapusActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnBatal, (JButton)this.BtnEdit);
        }
    }
    
    private void BtnEditActionPerformed(final ActionEvent evt) {
        if (this.TKdR.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdR, "ID Ruang");
        }
        else if (this.TNmR.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmR, "Nama Ruang");
        }
        else {
            this.Valid.editTable(this.tabModeRuang, "ruang", "kd_ruang", (JTextField)this.TKdR, "nm_ruang='" + this.TNmR.getText() + "'");
            if (this.tabModeRuang.getRowCount() != 0) {
                this.tampilRuang();
            }
            this.emptTeks();
        }
    }
    
    private void BtnEditKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnEditActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnHapus, (JButton)this.BtnKeluar);
        }
    }
    
    private void BtnKeluarActionPerformed(final ActionEvent evt) {
        this.dispose();
    }
    
    private void BtnKeluarKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JTextField)this.TCariRuang);
        }
    }
    
    private void TCariRuangKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariRuangActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCariRuang);
        }
    }
    
    private void BtnCariRuangActionPerformed(final ActionEvent evt) {
        this.prosesCariRuang("select * from ruang where kd_ruang like '%" + this.TCariRuang.getText().trim() + "%' " + "or nm_ruang like '%" + this.TCariRuang.getText().trim() + "%' ");
    }
    
    private void BtnCariRuangKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariRuangActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariRuang, (JButton)this.BtnAllRuang);
        }
    }
    
    private void BtnAllRuangActionPerformed(final ActionEvent evt) {
        this.prosesCariRuang("select * from ruang order by kd_ruang");
        this.emptTeks();
    }
    
    private void BtnAllRuangKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllRuangActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariRuang, (JTextField)this.TKdR);
        }
    }
    
    private void tbRuangMouseClicked(final MouseEvent evt) {
        if (this.tabModeRuang.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbRuangKeyPressed(final KeyEvent evt) {
        if (this.tabModeRuang.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgRuang dialog = new DlgRuang(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void tampilRuang() {
        final String sql = "select * from ruang order by kd_ruang";
        this.prosesCariRuang(sql);
    }
    
    private void prosesCariRuang(final String sql) {
        this.Valid.tabelKosong(this.tabModeRuang);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String kd = rs.getString(1);
                final String nm = rs.getString(2);
                final String[] data = { kd, nm };
                this.tabModeRuang.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModeRuang.getRowCount();
        this.LCount.setText("" + b);
    }
    
    public void emptTeks() {
        this.TKdR.setText("");
        this.TNmR.setText("");
        this.TCariRuang.setText("");
        this.TKdR.requestFocus();
        this.Valid.autoNomer(this.tabModeRuang, "R", 4, (JTextField)this.TKdR);
    }
    
    private void getData() {
        final int row = this.tbRuang.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModeRuang.getValueAt(row, 0).toString();
            final String nama = this.tabModeRuang.getValueAt(row, 1).toString();
            this.TKdR.setText(kode);
            this.TNmR.setText(nama);
        }
    }
}
