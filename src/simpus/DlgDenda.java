package simpus;

import usu.widget.Label;
import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Panel;
import widget.ScrollPane;
import fungsi.*;

import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public final class DlgDenda extends JDialog
{
    private DefaultTableModel tabMode;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAll;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnSimpan;
    private Label LCount;
    private TextBox TCari;
    private TextBox TDenda;
    private TextBox TKd;
    private TextBox TNm;
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
    private Label label5;
    private Label label6;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelGlass panelGlass3;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private Table tbDenda;
    
    public DlgDenda(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(459, 515);
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>Kode Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Besarnya Denda(%)</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbDenda.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbDenda.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbDenda.setAutoResizeMode(0);
        for (int i = 0; i < 3; ++i) {
            final TableColumn column = this.tbDenda.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(240);
            }
            else if (i == 2) {
                column.setPreferredWidth(120);
            }
        }
        this.tbDenda.setDefaultRenderer(Object.class, new WarnaTable());
        this.TKd.setDocument((Document)new batasInput(5).getFilter((JTextField)this.TKd));
        this.TNm.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TNm));
        this.TDenda.setDocument((Document)new batasInput(3).getOnlyAngka((JTextField)this.TDenda));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
    }
    
    private void initComponents() {
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.label1 = new Label();
        this.TKd = new TextBox();
        this.label2 = new Label();
        this.TNm = new TextBox();
        this.TDenda = new TextBox();
        this.label5 = new Label();
        this.label6 = new Label();
        this.scrollPane1 = new ScrollPane();
        this.tbDenda = new Table();
        this.jPanel1 = new JPanel();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnKeluar = new Button();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.BtnAll = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
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
        this.jLabel1.setText(":: DAFTAR DENDA ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(106, 10, 250, 20);
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2);
        this.jLabel2.setBounds(5, 0, 40, 40);
        this.getContentPane().add(this.panelJudul1, "First");
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(0, 1));
        this.panelGlass1.setBackground(new Color(195, 100, 195));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(105, 79));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.label1.setText("Kode Denda :");
        this.label1.setName("label1");
        this.panelGlass1.add((Component)this.label1);
        this.label1.setBounds(34, 17, 80, 15);
        this.TKd.setName("TKd");
        this.TKd.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.TKdKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TKd);
        this.TKd.setBounds(102, 12, 73, 23);
        this.label2.setText("Nama Denda :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(195, 17, 90, 15);
        this.TNm.setName("TNm");
        this.TNm.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.TNmKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNm);
        this.TNm.setBounds(266, 12, 180, 23);
        this.TDenda.setName("TDenda");
        this.TDenda.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.TDendaKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TDenda);
        this.TDenda.setBounds(102, 42, 54, 23);
        this.label5.setText("Besarnya Denda :");
        this.label5.setName("label5");
        this.panelGlass1.add((Component)this.label5);
        this.label5.setBounds(13, 47, 120, 15);
        this.label6.setText("% dari harga barang");
        this.label6.setName("label6");
        this.panelGlass1.add((Component)this.label6);
        this.label6.setBounds(160, 47, 120, 15);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
        this.scrollPane1.setBackground(new Color(195, 100, 195));
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbDenda.setAutoCreateRowSorter(true);
        this.tbDenda.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbDenda.setName("tbDenda");
        this.tbDenda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgDenda.this.tbDendaMouseClicked(evt);
            }
        });
        this.tbDenda.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.tbDendaKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbDenda);
        this.internalFrame1.add(this.scrollPane1, "Center");
        this.jPanel1.setBackground(new Color(0, 0, 153));
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setOpaque(false);
        this.jPanel1.setPreferredSize(new Dimension(100, 101));
        this.jPanel1.setLayout(new BorderLayout(0, 1));
        this.panelGlass2.setBackground(new Color(195, 100, 195));
        this.panelGlass2.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass2.setOpaqueImage(false);
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
                DlgDenda.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnSimpanKeyPressed(evt);
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
                DlgDenda.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnBatalKeyPressed(evt);
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
                DlgDenda.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnHapusKeyPressed(evt);
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
                DlgDenda.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnEditKeyPressed(evt);
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
                DlgDenda.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluar);
        this.BtnKeluar.setBounds(364, 10, 86, 30);
        this.jPanel1.add((Component)this.panelGlass2, "Center");
        this.panelGlass3.setBackground(new Color(195, 100, 195));
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(100, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)null);
        this.label3.setText("Key Word :");
        this.label3.setName("label3");
        this.panelGlass3.add((Component)this.label3);
        this.label3.setBounds(15, 15, 80, 15);
        this.TCari.setName("TCari");
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.TCariKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCari);
        this.TCari.setBounds(72, 10, 207, 25);
        this.BtnCari.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCari.setMnemonic('2');
        this.BtnCari.setToolTipText("Alt+2");
        this.BtnCari.setCursor(new Cursor(12));
        this.BtnCari.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCari.setName("BtnCari");
        this.BtnCari.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgDenda.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnCariKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCari);
        this.BtnCari.setBounds(281, 10, 28, 23);
        this.BtnAll.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAll.setMnemonic('1');
        this.BtnAll.setToolTipText("Alt+1");
        this.BtnAll.setCursor(new Cursor(12));
        this.BtnAll.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAll.setName("BtnAll");
        this.BtnAll.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgDenda.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgDenda.this.BtnAllKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAll);
        this.BtnAll.setBounds(310, 10, 28, 23);
        this.label4.setText("Record :");
        this.label4.setName("label4");
        this.panelGlass3.add((Component)this.label4);
        this.label4.setBounds(355, 15, 80, 15);
        this.LCount.setText("0");
        this.LCount.setName("LCount");
        this.panelGlass3.add((Component)this.LCount);
        this.LCount.setBounds(400, 15, 50, 15);
        this.jPanel1.add((Component)this.panelGlass3, "First");
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
        this.jLabel5.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
    
    private void TKdKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TCari, (JTextField)this.TNm);
    }
    
    private void TNmKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKd, (JTextField)this.TDenda);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TKd.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKd, "Kode Denda");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Nama Denda");
        }
        else if (this.TDenda.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TDenda, "Besarnya Denda");
        }
        else {
            this.Sequel.menyimpan("denda", "'" + this.TKd.getText() + "','" + this.TNm.getText() + "','" + this.TDenda.getText() + "'", "Kode Denda");
            this.tampil();
            this.emptTeks();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TNm, (JButton)this.BtnBatal);
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
        this.Valid.hapusTable(this.tabMode, (JTextField)this.TKd, "denda", "kode_denda");
        this.tampil();
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
        if (this.TKd.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKd, "Kode Denda");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Nama Denda");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Besarnya Denda");
        }
        else {
            this.Valid.editTable(this.tabMode, "denda", "kode_denda", (JTextField)this.TKd, "jenis_denda='" + this.TNm.getText() + "',besar_denda='" + this.TDenda.getText() + "'");
            if (this.tabMode.getRowCount() != 0) {
                this.tampil();
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
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JTextField)this.TCari);
        }
    }
    
    private void TCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCari);
        }
    }
    
    private void BtnCariActionPerformed(final ActionEvent evt) {
        this.prosesCari("select * from denda where kode_denda like '%" + this.TCari.getText().trim() + "%' " + "or jenis_denda like '%" + this.TCari.getText().trim() + "%' " + "or besar_denda like '%" + this.TCari.getText().trim() + "%' ");
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnAll);
        }
    }
    
    private void BtnAllActionPerformed(final ActionEvent evt) {
        this.prosesCari("select * from denda order by kode_denda");
        this.emptTeks();
    }
    
    private void BtnAllKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCari, (JTextField)this.TKd);
        }
    }
    
    private void tbDendaMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbDendaKeyPressed(final KeyEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
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
    
    private void TDendaKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNm, (JButton)this.BtnSimpan);
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgDenda dialog = new DlgDenda(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void tampil() {
        final String sql = "select * from denda order by kode_denda";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3) };
                this.tabMode.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabMode.getRowCount();
        this.LCount.setText("" + b);
    }
    
    public void emptTeks() {
        this.TKd.setText("");
        this.TNm.setText("");
        this.TDenda.setText("");
        this.TCari.setText("");
        this.TKd.requestFocus();
        this.Valid.autoNomer(this.tabMode, "D", 4, (JTextField)this.TKd);
    }
    
    private void getData() {
        final int row = this.tbDenda.getSelectedRow();
        if (row != -1) {
            this.TKd.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TNm.setText(this.tabMode.getValueAt(row, 1).toString());
            this.TDenda.setText(this.tabMode.getValueAt(row, 2).toString());
        }
    }
}
