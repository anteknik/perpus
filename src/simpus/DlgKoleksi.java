package simpus;

import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import fungsi.*;

import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DlgKoleksi extends JDialog
{
    private DefaultTableModel tabMode;
    private DefaultTableModel tabModePng;
    private DefaultTableModel tabModeKtg;
    private DefaultTableModel tabModeJns;
    private DefaultTableModel tabModePnb;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAll;
    private Button BtnAllJns;
    private Button BtnAllKtg;
    private Button BtnAllPnb;
    private Button BtnAllPng;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnCariJns;
    private Button BtnCariKtg;
    private Button BtnCariPnb;
    private Button BtnCariPng;
    private Button BtnCloseInput;
    private Button BtnCloseJns;
    private Button BtnCloseKtg;
    private Button BtnClosePnb;
    private Button BtnClosePng;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPglJns;
    private Button BtnPglKtg;
    private Button BtnPglPnb;
    private Button BtnPglPnb1;
    private Button BtnPglPnb2;
    private Button BtnPglPnb3;
    private Button BtnPglPnb4;
    private Button BtnPglPng;
    private Button BtnPrint;
    private Button BtnSimpan;
    private Button BtnTambah;
    private JCheckBox ChkCari;
    private CekBox ChkCrThn;
    private ComboBox CmbThn;
    private ComboBox CmbThnCari;
    private JDialog DlgCariJns;
    private JDialog DlgCariKtg;
    private JDialog DlgCariPnb;
    private JDialog DlgCariPng;
    private JDialog DlgInput;
    private Label LCount;
    private JLabel LabelKon;
    private InternalFrame PanelCari;
    private JPanel PanelIndukCari;
    private TextBox TCari;
    private TextBox TCariJns;
    private TextBox TCariKtg;
    private TextBox TCariPnb;
    private TextBox TCariPng;
    private TextBox THlm;
    private TextBox TIsbn;
    private TextBox TJdl;
    private TextBox TJnsCari;
    private TextBox TKd;
    private TextBox TKdJns;
    private TextBox TKdKtg;
    private TextBox TKdPnb;
    private TextBox TKdPng;
    private TextBox TKtgCari;
    private TextBox TNmJns;
    private TextBox TNmKtg;
    private TextBox TNmPnb;
    private TextBox TNmPng;
    private TextBox TPnbCari;
    private TextBox TPngCari;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private InternalFrame internalFrame4;
    private InternalFrame internalFrame5;
    private InternalFrame internalFrame6;
    private InternalFrame internalFrame7;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label2;
    private Label label20;
    private Label label21;
    private Label label22;
    private Label label24;
    private Label label25;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Panel panel1;
    private Panel panel2;
    private PanelGlass panelGlass3;
    private PanelGlass panelGlass4;
    private PanelGlass panelGlass5;
    private PanelGlass panelGlass6;
    private PanelJudul panelJudul1;
    private PanelJudul panelJudul2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private ScrollPane scrollPane3;
    private ScrollPane scrollPane4;
    private ScrollPane scrollPane5;
    private Table tbJenis;
    private Table tbKategori;
    private Table tbKoleksi;
    private Table tbPenerbit;
    private Table tbPengarang;
    
    public DlgKoleksi(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Produsen Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbKoleksi.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbKoleksi.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbKoleksi.setAutoResizeMode(0);
        for (int i = 0; i < 9; ++i) {
            final TableColumn column = this.tbKoleksi.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(350);
            }
            else if (i == 2) {
                column.setPreferredWidth(60);
            }
            else if (i == 3) {
                column.setPreferredWidth(150);
            }
            else if (i == 4) {
                column.setPreferredWidth(150);
            }
            else if (i == 5) {
                column.setPreferredWidth(70);
            }
            else if (i == 6) {
                column.setPreferredWidth(110);
            }
            else if (i == 7) {
                column.setPreferredWidth(150);
            }
            else if (i == 8) {
                column.setPreferredWidth(150);
            }
        }
        this.tbKoleksi.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowPng = { "<html><font color='#006699' face='Comic Sans MS'>ID Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Merk/Type</font></html>" };
        this.tabModePng = new DefaultTableModel((Object[][])null, rowPng) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPengarang.setModel(this.tabModePng);
        this.tbPengarang.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbPengarang.setAutoResizeMode(0);
        for (int j = 0; j < 2; ++j) {
            final TableColumn column2 = this.tbPengarang.getColumnModel().getColumn(j);
            if (j == 0) {
                column2.setPreferredWidth(120);
            }
            else if (j == 1) {
                column2.setPreferredWidth(327);
            }
        }
        this.tbPengarang.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowKtg = { "<html><font color='#006699' face='Comic Sans MS'>ID Kategori</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Kategori</font></html>" };
        this.tabModeKtg = new DefaultTableModel((Object[][])null, rowKtg) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbKategori.setModel(this.tabModeKtg);
        this.tbKategori.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbKategori.setAutoResizeMode(0);
        for (int k = 0; k < 2; ++k) {
            final TableColumn column3 = this.tbKategori.getColumnModel().getColumn(k);
            if (k == 0) {
                column3.setPreferredWidth(120);
            }
            else if (k == 1) {
                column3.setPreferredWidth(327);
            }
        }
        this.tbKategori.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowJns = { "<html><font color='#006699' face='Comic Sans MS'>ID Jenis</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Jenis</font></html>" };
        this.tabModeJns = new DefaultTableModel((Object[][])null, rowJns) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbJenis.setModel(this.tabModeJns);
        this.tbJenis.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbJenis.setAutoResizeMode(0);
        for (int l = 0; l < 2; ++l) {
            final TableColumn column4 = this.tbJenis.getColumnModel().getColumn(l);
            if (l == 0) {
                column4.setPreferredWidth(120);
            }
            else if (l == 1) {
                column4.setPreferredWidth(327);
            }
        }
        this.tbJenis.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowPnb = { "<html><font color='#006699' face='Comic Sans MS'>Kode Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>E-Mail</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Website Produsen</font></html>" };
        this.tabModePnb = new DefaultTableModel((Object[][])null, rowPnb) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPenerbit.setModel(this.tabModePnb);
        this.tbPenerbit.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPenerbit.setAutoResizeMode(0);
        for (int m = 0; m < 6; ++m) {
            final TableColumn column5 = this.tbPenerbit.getColumnModel().getColumn(m);
            if (m == 0) {
                column5.setPreferredWidth(100);
            }
            else if (m == 1) {
                column5.setPreferredWidth(200);
            }
            else if (m == 2) {
                column5.setPreferredWidth(300);
            }
            else if (m == 3) {
                column5.setPreferredWidth(130);
            }
            else if (m == 4) {
                column5.setPreferredWidth(150);
            }
            else if (m == 5) {
                column5.setPreferredWidth(150);
            }
        }
        this.tbPenerbit.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariPnb.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPnb));
        this.TCariJns.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariJns));
        this.TCariKtg.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariKtg));
        this.TCariPng.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPng));
        this.TKd.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TKd));
        this.TJdl.setDocument((Document)new batasInput(60).getFilter((JTextField)this.TJdl));
        this.THlm.setDocument((Document)new batasInput(5).getOnlyAngka((JTextField)this.THlm));
        this.TKdPnb.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TKdPnb));
        this.TKdPng.setDocument((Document)new batasInput(7).getFilter((JTextField)this.TKdPng));
        this.TIsbn.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TIsbn));
        this.TKdKtg.setDocument((Document)new batasInput(5).getFilter((JTextField)this.TKdKtg));
        this.TKdJns.setDocument((Document)new batasInput(5).getFilter((JTextField)this.TKdJns));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.Valid.LoadTahun(this.CmbThn);
        this.Valid.LoadTahun(this.CmbThnCari);
        this.TCari.requestFocus();
        this.LabelKon.setVisible(false);
        this.TKdPnb.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPnb();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPnb();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPnb();
            }
        });
        this.TKdPng.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPng();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPng();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isPng();
            }
        });
        this.TKdKtg.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isKtg();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isKtg();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isKtg();
            }
        });
        this.TKdJns.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isJns();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isJns();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isJns();
            }
        });
        this.TPnbCari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
        });
        this.TPngCari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
        });
        this.TKtgCari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
        });
        this.TJnsCari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgKoleksi.this.isCari();
            }
        });
        this.ChkCariActionPerformed(null);
        this.DlgInput.setSize(734, 263);
        this.DlgInput.setVisible(false);
        this.DlgCariPng.setSize(450, 252);
        this.DlgCariPng.setVisible(false);
        this.DlgCariKtg.setSize(450, 252);
        this.DlgCariKtg.setVisible(false);
        this.DlgCariJns.setSize(450, 252);
        this.DlgCariJns.setVisible(false);
        this.DlgCariPnb.setSize(450, 252);
        this.DlgCariPnb.setVisible(false);
        this.LabelKon.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgInput = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.label1 = new Label();
        this.TJdl = new TextBox();
        this.label2 = new Label();
        this.label5 = new Label();
        this.THlm = new TextBox();
        this.label6 = new Label();
        this.TKdPnb = new TextBox();
        this.label7 = new Label();
        this.TKdPng = new TextBox();
        this.label8 = new Label();
        this.label9 = new Label();
        this.BtnSimpan = new Button();
        this.BtnCloseInput = new Button();
        this.label10 = new Label();
        this.label11 = new Label();
        this.label12 = new Label();
        this.TNmKtg = new TextBox();
        this.TKdKtg = new TextBox();
        this.TKdJns = new TextBox();
        this.BtnBatal = new Button();
        this.BtnPglPnb = new Button();
        this.TKd = new TextBox();
        this.BtnPglPng = new Button();
        this.BtnPglKtg = new Button();
        this.BtnPglJns = new Button();
        this.TIsbn = new TextBox();
        this.TNmPng = new TextBox();
        this.TNmJns = new TextBox();
        this.CmbThn = new ComboBox();
        this.TNmPnb = new TextBox();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.panel1 = new Panel();
        this.LabelKon = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.DlgCariPng = new JDialog();
        this.internalFrame4 = new InternalFrame();
        this.panelGlass3 = new PanelGlass();
        this.label15 = new Label();
        this.TCariPng = new TextBox();
        this.BtnCariPng = new Button();
        this.BtnAllPng = new Button();
        this.label16 = new Label();
        this.BtnClosePng = new Button();
        this.scrollPane2 = new ScrollPane();
        this.tbPengarang = new Table();
        this.DlgCariKtg = new JDialog();
        this.internalFrame5 = new InternalFrame();
        this.panelGlass4 = new PanelGlass();
        this.label17 = new Label();
        this.TCariKtg = new TextBox();
        this.BtnCariKtg = new Button();
        this.BtnAllKtg = new Button();
        this.label18 = new Label();
        this.BtnCloseKtg = new Button();
        this.scrollPane3 = new ScrollPane();
        this.tbKategori = new Table();
        this.DlgCariJns = new JDialog();
        this.internalFrame6 = new InternalFrame();
        this.panelGlass5 = new PanelGlass();
        this.label19 = new Label();
        this.TCariJns = new TextBox();
        this.BtnCariJns = new Button();
        this.BtnAllJns = new Button();
        this.label20 = new Label();
        this.BtnCloseJns = new Button();
        this.scrollPane4 = new ScrollPane();
        this.tbJenis = new Table();
        this.DlgCariPnb = new JDialog();
        this.internalFrame7 = new InternalFrame();
        this.panelGlass6 = new PanelGlass();
        this.label21 = new Label();
        this.TCariPnb = new TextBox();
        this.BtnCariPnb = new Button();
        this.BtnAllPnb = new Button();
        this.label22 = new Label();
        this.BtnClosePnb = new Button();
        this.scrollPane5 = new ScrollPane();
        this.tbPenerbit = new Table();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.internalFrame3 = new InternalFrame();
        this.BtnTambah = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnPrint = new Button();
        this.BtnAll = new Button();
        this.BtnKeluar = new Button();
        this.scrollPane1 = new ScrollPane();
        this.tbKoleksi = new Table();
        this.PanelIndukCari = new JPanel();
        this.internalFrame2 = new InternalFrame();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
        this.PanelCari = new InternalFrame();
        this.TPnbCari = new TextBox();
        this.BtnPglPnb1 = new Button();
        this.TPngCari = new TextBox();
        this.BtnPglPnb2 = new Button();
        this.TKtgCari = new TextBox();
        this.BtnPglPnb3 = new Button();
        this.TJnsCari = new TextBox();
        this.BtnPglPnb4 = new Button();
        this.label13 = new Label();
        this.label14 = new Label();
        this.label24 = new Label();
        this.label25 = new Label();
        this.ChkCrThn = new CekBox();
        this.CmbThnCari = new ComboBox();
        this.panel2 = new Panel();
        this.ChkCari = new JCheckBox();
        this.panelJudul2 = new PanelJudul();
        this.jLabel2 = new JLabel();
        this.DlgInput.setDefaultCloseOperation(2);
        this.DlgInput.setBackground(new Color(255, 200, 255));
        this.DlgInput.setModal(true);
        this.DlgInput.setName("DlgInput");
        this.DlgInput.setResizable(false);
        this.DlgInput.setUndecorated(true);
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(null);
        this.label1.setHorizontalAlignment(4);
        this.label1.setText("Kode Barang :");
        this.label1.setName("label1");
        this.internalFrame1.add((Component)this.label1);
        this.label1.setBounds(10, 17, 74, 14);
        this.TJdl.setName("TJdl");
        this.TJdl.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TJdlKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TJdl);
        this.TJdl.setBounds(85, 42, 282, 23);
        this.label2.setForeground(new Color(153, 153, 255));
        this.label2.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.label2.setName("label2");
        this.internalFrame1.add((Component)this.label2);
        this.label2.setBounds(-11, 130, 810, 14);
        this.label5.setHorizontalAlignment(4);
        this.label5.setText("Jml.Barang :");
        this.label5.setName("label5");
        this.internalFrame1.add((Component)this.label5);
        this.label5.setBounds(10, 77, 74, 14);
        this.THlm.setName("THlm");
        this.THlm.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.THlmKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.THlm);
        this.THlm.setBounds(85, 72, 60, 23);
        this.label6.setText("Tahun Produksi :");
        this.label6.setName("label6");
        this.internalFrame1.add((Component)this.label6);
        this.label6.setBounds(162, 77, 90, 14);
        this.TKdPnb.setName("TKdPnb");
        this.TKdPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKdPnbKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKdPnb);
        this.TKdPnb.setBounds(85, 102, 90, 23);
        this.label7.setHorizontalAlignment(4);
        this.label7.setText("Produsen :");
        this.label7.setName("label7");
        this.internalFrame1.add((Component)this.label7);
        this.label7.setBounds(10, 107, 74, 14);
        this.TKdPng.setName("TKdPng");
        this.TKdPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKdPngKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKdPng);
        this.TKdPng.setBounds(445, 12, 70, 23);
        this.label8.setHorizontalAlignment(4);
        this.label8.setText("Merk/Type :");
        this.label8.setName("label8");
        this.internalFrame1.add((Component)this.label8);
        this.label8.setBounds(364, 17, 80, 14);
        this.label9.setHorizontalAlignment(4);
        this.label9.setText("Kategori :");
        this.label9.setName("label9");
        this.internalFrame1.add((Component)this.label9);
        this.label9.setBounds(364, 77, 80, 14);
        this.BtnSimpan.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/save-16x16.png")));
        this.BtnSimpan.setMnemonic('S');
        this.BtnSimpan.setText("Simpan");
        this.BtnSimpan.setToolTipText("Alt+S");
        this.BtnSimpan.setCursor(new Cursor(12));
        this.BtnSimpan.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnSimpan.setName("BtnSimpan");
        this.BtnSimpan.setPreferredSize(new Dimension(100, 30));
        this.BtnSimpan.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(14, 150, 100, 30);
        this.BtnCloseInput.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseInput.setMnemonic('C');
        this.BtnCloseInput.setText("Close");
        this.BtnCloseInput.setToolTipText("Alt+C");
        this.BtnCloseInput.setCursor(new Cursor(12));
        this.BtnCloseInput.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseInput.setName("BtnCloseInput");
        this.BtnCloseInput.setPreferredSize(new Dimension(100, 30));
        this.BtnCloseInput.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCloseInputActionPerformed(evt);
            }
        });
        this.BtnCloseInput.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCloseInputKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnCloseInput);
        this.BtnCloseInput.setBounds(616, 150, 100, 30);
        this.label10.setHorizontalAlignment(4);
        this.label10.setText("Nama Barang :");
        this.label10.setName("label10");
        this.internalFrame1.add((Component)this.label10);
        this.label10.setBounds(10, 47, 74, 14);
        this.label11.setHorizontalAlignment(4);
        this.label11.setText("ISBN :");
        this.label11.setName("label11");
        this.internalFrame1.add((Component)this.label11);
        this.label11.setBounds(364, 47, 80, 14);
        this.label12.setHorizontalAlignment(4);
        this.label12.setText("Jenis :");
        this.label12.setName("label12");
        this.internalFrame1.add((Component)this.label12);
        this.label12.setBounds(364, 107, 80, 14);
        this.TNmKtg.setEditable(false);
        this.TNmKtg.setName("TNmKtg");
        this.internalFrame1.add((Component)this.TNmKtg);
        this.TNmKtg.setBounds(534, 72, 185, 23);
        this.TKdKtg.setName("TKdKtg");
        this.TKdKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKdKtgKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKdKtg);
        this.TKdKtg.setBounds(445, 72, 60, 23);
        this.TKdJns.setName("TKdJns");
        this.TKdJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKdJnsKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKdJns);
        this.TKdJns.setBounds(445, 102, 60, 23);
        this.BtnBatal.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Cancel-2-16x16.png")));
        this.BtnBatal.setMnemonic('B');
        this.BtnBatal.setText("Batal");
        this.BtnBatal.setToolTipText("Alt+B");
        this.BtnBatal.setCursor(new Cursor(12));
        this.BtnBatal.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnBatal.setName("BtnBatal");
        this.BtnBatal.setPreferredSize(new Dimension(100, 30));
        this.BtnBatal.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnBatalKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnBatal);
        this.BtnBatal.setBounds(117, 150, 100, 30);
        this.BtnPglPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb.setMnemonic('1');
        this.BtnPglPnb.setToolTipText("Alt+1");
        this.BtnPglPnb.setCursor(new Cursor(12));
        this.BtnPglPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb.setName("BtnPglPnb");
        this.BtnPglPnb.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPnbActionPerformed(evt);
            }
        });
        this.BtnPglPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPnbKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglPnb);
        this.BtnPglPnb.setBounds(177, 102, 25, 23);
        this.TKd.setName("TKd");
        this.TKd.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKdKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKd);
        this.TKd.setBounds(85, 12, 160, 23);
        this.BtnPglPng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPng.setMnemonic('2');
        this.BtnPglPng.setToolTipText("Alt+2");
        this.BtnPglPng.setCursor(new Cursor(12));
        this.BtnPglPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPng.setName("BtnPglPng");
        this.BtnPglPng.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPngActionPerformed(evt);
            }
        });
        this.BtnPglPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPngKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglPng);
        this.BtnPglPng.setBounds(517, 12, 25, 23);
        this.BtnPglKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglKtg.setMnemonic('3');
        this.BtnPglKtg.setToolTipText("Alt+3");
        this.BtnPglKtg.setCursor(new Cursor(12));
        this.BtnPglKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglKtg.setName("BtnPglKtg");
        this.BtnPglKtg.setPreferredSize(new Dimension(100, 30));
        this.BtnPglKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglKtgActionPerformed(evt);
            }
        });
        this.BtnPglKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglKtgKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglKtg);
        this.BtnPglKtg.setBounds(507, 72, 25, 23);
        this.BtnPglJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglJns.setMnemonic('4');
        this.BtnPglJns.setToolTipText("Alt+4");
        this.BtnPglJns.setCursor(new Cursor(12));
        this.BtnPglJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglJns.setName("BtnPglJns");
        this.BtnPglJns.setPreferredSize(new Dimension(100, 30));
        this.BtnPglJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglJnsActionPerformed(evt);
            }
        });
        this.BtnPglJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglJnsKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglJns);
        this.BtnPglJns.setBounds(507, 102, 25, 23);
        this.TIsbn.setName("TIsbn");
        this.TIsbn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TIsbnKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TIsbn);
        this.TIsbn.setBounds(445, 42, 150, 23);
        this.TNmPng.setEditable(false);
        this.TNmPng.setName("TNmPng");
        this.internalFrame1.add((Component)this.TNmPng);
        this.TNmPng.setBounds(544, 12, 175, 23);
        this.TNmJns.setEditable(false);
        this.TNmJns.setName("TNmJns");
        this.internalFrame1.add((Component)this.TNmJns);
        this.TNmJns.setBounds(534, 102, 185, 23);
        this.CmbThn.setName("CmbThn");
        this.CmbThn.setPreferredSize(new Dimension(45, 23));
        this.CmbThn.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.CmbThnKeyPressed(evt);
            }
        });
        this.internalFrame1.add(this.CmbThn);
        this.CmbThn.setBounds(244, 72, 90, 23);
        this.TNmPnb.setEditable(false);
        this.TNmPnb.setName("TNmPnb");
        this.internalFrame1.add((Component)this.TNmPnb);
        this.TNmPnb.setBounds(205, 102, 162, 23);
        this.DlgInput.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: INPUT DATA BARANG ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(238, 10, 250, 20);
        this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel3.setName("jLabel3");
        this.panelJudul1.add(this.jLabel3);
        this.jLabel3.setBounds(5, 0, 40, 40);
        this.DlgInput.getContentPane().add(this.panelJudul1, "First");
        this.panel1.setName("panel1");
        this.panel1.setPreferredSize(new Dimension(440, 25));
        this.panel1.setLayout(new BorderLayout());
        this.LabelKon.setBackground(Color.darkGray);
        this.LabelKon.setFont(new Font("Tahoma", 1, 11));
        this.LabelKon.setForeground(new Color(255, 204, 255));
        this.LabelKon.setHorizontalAlignment(0);
        this.LabelKon.setText(":: Semua field wajib diisi ::");
        this.LabelKon.setName("LabelKon");
        this.panel1.add(this.LabelKon, "Center");
        this.jSeparator1.setBackground(new Color(0, 0, 51));
        this.jSeparator1.setForeground(new Color(0, 0, 51));
        this.jSeparator1.setName("jSeparator1");
        this.jSeparator1.setPreferredSize(new Dimension(1, 1));
        this.panel1.add(this.jSeparator1, "First");
        this.DlgInput.getContentPane().add(this.panel1, "Last");
        this.DlgCariPng.setBackground(new Color(255, 180, 255));
        this.DlgCariPng.setModal(true);
        this.DlgCariPng.setName("DlgCariPng");
        this.DlgCariPng.setResizable(false);
        this.DlgCariPng.setUndecorated(true);
        this.internalFrame4.setName("internalFrame4");
        this.internalFrame4.setLayout(new BorderLayout(1, 1));
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(40, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label15.setHorizontalAlignment(4);
        this.label15.setText("Key Word :");
        this.label15.setName("label15");
        this.label15.setPreferredSize(new Dimension(63, 23));
        this.panelGlass3.add((Component)this.label15);
        this.TCariPng.setName("TCariPng");
        this.TCariPng.setPreferredSize(new Dimension(230, 23));
        this.TCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TCariPngKeyPressed(evt);
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
                DlgKoleksi.this.BtnCariPngActionPerformed(evt);
            }
        });
        this.BtnCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariPngKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariPngKeyReleased(evt);
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
                DlgKoleksi.this.BtnAllPngActionPerformed(evt);
            }
        });
        this.BtnAllPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnAllPngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPng);
        this.label16.setHorizontalAlignment(4);
        this.label16.setName("label16");
        this.label16.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label16);
        this.BtnClosePng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnClosePng.setMnemonic('3');
        this.BtnClosePng.setToolTipText("Alt+3");
        this.BtnClosePng.setCursor(new Cursor(12));
        this.BtnClosePng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnClosePng.setName("BtnClosePng");
        this.BtnClosePng.setPreferredSize(new Dimension(26, 23));
        this.BtnClosePng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnClosePngActionPerformed(evt);
            }
        });
        this.BtnClosePng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnClosePngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnClosePng);
        this.internalFrame4.add((Component)this.panelGlass3, "First");
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane2.setName("scrollPane2");
        this.tbPengarang.setAutoCreateRowSorter(true);
        this.tbPengarang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPengarang.setName("tbPengarang");
        this.tbPengarang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgKoleksi.this.tbPengarangMouseClicked(evt);
            }
        });
        this.tbPengarang.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.tbPengarangKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.tbPengarang);
        this.internalFrame4.add(this.scrollPane2, "Center");
        this.DlgCariPng.getContentPane().add(this.internalFrame4, "Center");
        this.DlgCariKtg.setModal(true);
        this.DlgCariKtg.setName("DlgCariKtg");
        this.DlgCariKtg.setResizable(false);
        this.DlgCariKtg.setUndecorated(true);
        this.internalFrame5.setName("internalFrame5");
        this.internalFrame5.setLayout(new BorderLayout(1, 1));
        this.panelGlass4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass4.setOpaqueImage(false);
        this.panelGlass4.setPreferredSize(new Dimension(40, 44));
        this.panelGlass4.setRound(false);
        this.panelGlass4.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label17.setHorizontalAlignment(4);
        this.label17.setText("Key Word :");
        this.label17.setName("label17");
        this.label17.setPreferredSize(new Dimension(63, 23));
        this.panelGlass4.add((Component)this.label17);
        this.TCariKtg.setName("TCariKtg");
        this.TCariKtg.setPreferredSize(new Dimension(230, 23));
        this.TCariKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TCariKtgKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.TCariKtg);
        this.BtnCariKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariKtg.setMnemonic('2');
        this.BtnCariKtg.setToolTipText("Alt+2");
        this.BtnCariKtg.setCursor(new Cursor(12));
        this.BtnCariKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariKtg.setName("BtnCariKtg");
        this.BtnCariKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnCariKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCariKtgActionPerformed(evt);
            }
        });
        this.BtnCariKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariKtgKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariKtgKeyReleased(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnCariKtg);
        this.BtnAllKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllKtg.setMnemonic('1');
        this.BtnAllKtg.setToolTipText("Alt+1");
        this.BtnAllKtg.setCursor(new Cursor(12));
        this.BtnAllKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllKtg.setName("BtnAllKtg");
        this.BtnAllKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnAllKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnAllKtgActionPerformed(evt);
            }
        });
        this.BtnAllKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnAllKtgKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnAllKtg);
        this.label18.setHorizontalAlignment(4);
        this.label18.setName("label18");
        this.label18.setPreferredSize(new Dimension(33, 23));
        this.panelGlass4.add((Component)this.label18);
        this.BtnCloseKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseKtg.setMnemonic('3');
        this.BtnCloseKtg.setToolTipText("Alt+3");
        this.BtnCloseKtg.setCursor(new Cursor(12));
        this.BtnCloseKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseKtg.setName("BtnCloseKtg");
        this.BtnCloseKtg.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCloseKtgActionPerformed(evt);
            }
        });
        this.BtnCloseKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCloseKtgKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnCloseKtg);
        this.internalFrame5.add((Component)this.panelGlass4, "First");
        this.scrollPane3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane3.setName("scrollPane3");
        this.tbKategori.setAutoCreateRowSorter(true);
        this.tbKategori.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbKategori.setName("tbKategori");
        this.tbKategori.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgKoleksi.this.tbKategoriMouseClicked(evt);
            }
        });
        this.tbKategori.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.tbKategoriKeyPressed(evt);
            }
        });
        this.scrollPane3.setViewportView(this.tbKategori);
        this.internalFrame5.add(this.scrollPane3, "Center");
        this.DlgCariKtg.getContentPane().add(this.internalFrame5, "Center");
        this.DlgCariJns.setModal(true);
        this.DlgCariJns.setName("DlgCariJns");
        this.DlgCariJns.setResizable(false);
        this.DlgCariJns.setUndecorated(true);
        this.internalFrame6.setName("internalFrame6");
        this.internalFrame6.setLayout(new BorderLayout(1, 1));
        this.panelGlass5.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass5.setOpaqueImage(false);
        this.panelGlass5.setPreferredSize(new Dimension(40, 44));
        this.panelGlass5.setRound(false);
        this.panelGlass5.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label19.setHorizontalAlignment(4);
        this.label19.setText("Key Word :");
        this.label19.setName("label19");
        this.label19.setPreferredSize(new Dimension(63, 23));
        this.panelGlass5.add((Component)this.label19);
        this.TCariJns.setName("TCariJns");
        this.TCariJns.setPreferredSize(new Dimension(230, 23));
        this.TCariJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TCariJnsKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.TCariJns);
        this.BtnCariJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariJns.setMnemonic('2');
        this.BtnCariJns.setToolTipText("Alt+2");
        this.BtnCariJns.setCursor(new Cursor(12));
        this.BtnCariJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariJns.setName("BtnCariJns");
        this.BtnCariJns.setPreferredSize(new Dimension(26, 23));
        this.BtnCariJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCariJnsActionPerformed(evt);
            }
        });
        this.BtnCariJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariJnsKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariJnsKeyReleased(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnCariJns);
        this.BtnAllJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllJns.setMnemonic('1');
        this.BtnAllJns.setToolTipText("Alt+1");
        this.BtnAllJns.setCursor(new Cursor(12));
        this.BtnAllJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllJns.setName("BtnAllJns");
        this.BtnAllJns.setPreferredSize(new Dimension(26, 23));
        this.BtnAllJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnAllJnsActionPerformed(evt);
            }
        });
        this.BtnAllJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnAllJnsKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnAllJns);
        this.label20.setHorizontalAlignment(4);
        this.label20.setName("label20");
        this.label20.setPreferredSize(new Dimension(33, 23));
        this.panelGlass5.add((Component)this.label20);
        this.BtnCloseJns.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseJns.setMnemonic('3');
        this.BtnCloseJns.setToolTipText("Alt+3");
        this.BtnCloseJns.setCursor(new Cursor(12));
        this.BtnCloseJns.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseJns.setName("BtnCloseJns");
        this.BtnCloseJns.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseJns.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCloseJnsActionPerformed(evt);
            }
        });
        this.BtnCloseJns.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCloseJnsKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnCloseJns);
        this.internalFrame6.add((Component)this.panelGlass5, "First");
        this.scrollPane4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane4.setName("scrollPane4");
        this.tbJenis.setAutoCreateRowSorter(true);
        this.tbJenis.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbJenis.setName("tbJenis");
        this.tbJenis.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgKoleksi.this.tbJenisMouseClicked(evt);
            }
        });
        this.tbJenis.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.tbJenisKeyPressed(evt);
            }
        });
        this.scrollPane4.setViewportView(this.tbJenis);
        this.internalFrame6.add(this.scrollPane4, "Center");
        this.DlgCariJns.getContentPane().add(this.internalFrame6, "Center");
        this.DlgCariPnb.setModal(true);
        this.DlgCariPnb.setName("DlgCariPnb");
        this.DlgCariPnb.setResizable(false);
        this.DlgCariPnb.setUndecorated(true);
        this.internalFrame7.setName("internalFrame7");
        this.internalFrame7.setLayout(new BorderLayout(1, 1));
        this.panelGlass6.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass6.setOpaqueImage(false);
        this.panelGlass6.setPreferredSize(new Dimension(40, 44));
        this.panelGlass6.setRound(false);
        this.panelGlass6.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label21.setHorizontalAlignment(4);
        this.label21.setText("Key Word :");
        this.label21.setName("label21");
        this.label21.setPreferredSize(new Dimension(63, 23));
        this.panelGlass6.add((Component)this.label21);
        this.TCariPnb.setName("TCariPnb");
        this.TCariPnb.setPreferredSize(new Dimension(230, 23));
        this.TCariPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TCariPnbKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.TCariPnb);
        this.BtnCariPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPnb.setMnemonic('2');
        this.BtnCariPnb.setToolTipText("Alt+2");
        this.BtnCariPnb.setCursor(new Cursor(12));
        this.BtnCariPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPnb.setName("BtnCariPnb");
        this.BtnCariPnb.setPreferredSize(new Dimension(26, 23));
        this.BtnCariPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCariPnbActionPerformed(evt);
            }
        });
        this.BtnCariPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariPnbKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariPnbKeyReleased(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnCariPnb);
        this.BtnAllPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPnb.setMnemonic('1');
        this.BtnAllPnb.setToolTipText("Alt+1");
        this.BtnAllPnb.setCursor(new Cursor(12));
        this.BtnAllPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPnb.setName("BtnAllPnb");
        this.BtnAllPnb.setPreferredSize(new Dimension(26, 23));
        this.BtnAllPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnAllPnbActionPerformed(evt);
            }
        });
        this.BtnAllPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnAllPnbKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnAllPnb);
        this.label22.setHorizontalAlignment(4);
        this.label22.setName("label22");
        this.label22.setPreferredSize(new Dimension(33, 23));
        this.panelGlass6.add((Component)this.label22);
        this.BtnClosePnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnClosePnb.setMnemonic('3');
        this.BtnClosePnb.setToolTipText("Alt+3");
        this.BtnClosePnb.setCursor(new Cursor(12));
        this.BtnClosePnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnClosePnb.setName("BtnClosePnb");
        this.BtnClosePnb.setPreferredSize(new Dimension(26, 23));
        this.BtnClosePnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnClosePnbActionPerformed(evt);
            }
        });
        this.BtnClosePnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnClosePnbKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnClosePnb);
        this.internalFrame7.add((Component)this.panelGlass6, "First");
        this.scrollPane5.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane5.setName("scrollPane5");
        this.tbPenerbit.setAutoCreateRowSorter(true);
        this.tbPenerbit.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPenerbit.setName("tbPenerbit");
        this.tbPenerbit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgKoleksi.this.tbPenerbitMouseClicked(evt);
            }
        });
        this.tbPenerbit.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.tbPenerbitKeyPressed(evt);
            }
        });
        this.scrollPane5.setViewportView(this.tbPenerbit);
        this.internalFrame7.add(this.scrollPane5, "Center");
        this.DlgCariPnb.getContentPane().add(this.internalFrame7, "Center");
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setUndecorated(true);
        this.jPanel1.setBackground(new Color(90, 0, 90));
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setLayout(new BorderLayout(1, 1));
        this.jPanel2.setBackground(new Color(90, 0, 90));
        this.jPanel2.setName("jPanel2");
        this.jPanel2.setLayout(new BorderLayout(1, 1));
        this.internalFrame3.setName("internalFrame3");
        this.internalFrame3.setPreferredSize(new Dimension(639, 40));
        this.internalFrame3.setLayout(new FlowLayout(0));
        this.BtnTambah.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/add-file-16x16.png")));
        this.BtnTambah.setMnemonic('T');
        this.BtnTambah.setText("Tambah");
        this.BtnTambah.setToolTipText("Alt+T");
        this.BtnTambah.setCursor(new Cursor(12));
        this.BtnTambah.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnTambah.setName("BtnTambah");
        this.BtnTambah.setPreferredSize(new Dimension(100, 30));
        this.BtnTambah.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnTambahActionPerformed(evt);
            }
        });
        this.BtnTambah.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnTambahKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnTambah);
        this.BtnHapus.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/stop_f2.png")));
        this.BtnHapus.setMnemonic('H');
        this.BtnHapus.setText("Hapus");
        this.BtnHapus.setToolTipText("Alt+H");
        this.BtnHapus.setCursor(new Cursor(12));
        this.BtnHapus.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnHapus.setName("BtnHapus");
        this.BtnHapus.setPreferredSize(new Dimension(100, 30));
        this.BtnHapus.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnHapusKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnHapus);
        this.BtnEdit.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/inventaris.png")));
        this.BtnEdit.setMnemonic('E');
        this.BtnEdit.setText("Edit");
        this.BtnEdit.setToolTipText("Alt+E");
        this.BtnEdit.setCursor(new Cursor(12));
        this.BtnEdit.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnEdit.setName("BtnEdit");
        this.BtnEdit.setPreferredSize(new Dimension(100, 30));
        this.BtnEdit.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnEditKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnEdit);
        this.BtnPrint.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/b_print.png")));
        this.BtnPrint.setMnemonic('P');
        this.BtnPrint.setText("Print");
        this.BtnPrint.setToolTipText("Alt+P");
        this.BtnPrint.setCursor(new Cursor(12));
        this.BtnPrint.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPrint.setName("BtnPrint");
        this.BtnPrint.setPreferredSize(new Dimension(100, 30));
        this.BtnPrint.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPrintKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnPrint);
        this.BtnAll.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAll.setMnemonic('V');
        this.BtnAll.setText("View All");
        this.BtnAll.setToolTipText("Alt+V");
        this.BtnAll.setCursor(new Cursor(12));
        this.BtnAll.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAll.setName("BtnAll");
        this.BtnAll.setPreferredSize(new Dimension(100, 30));
        this.BtnAll.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnAllKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnAll);
        this.BtnKeluar.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnKeluar.setMnemonic('C');
        this.BtnKeluar.setText("Close");
        this.BtnKeluar.setToolTipText("Alt+C");
        this.BtnKeluar.setCursor(new Cursor(12));
        this.BtnKeluar.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnKeluar.setName("BtnKeluar");
        this.BtnKeluar.setPreferredSize(new Dimension(100, 30));
        this.BtnKeluar.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnKeluar);
        this.jPanel2.add(this.internalFrame3, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbKoleksi.setAutoCreateRowSorter(true);
        this.tbKoleksi.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbKoleksi.setName("tbKoleksi");
        this.tbKoleksi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgKoleksi.this.tbKoleksiMouseClicked(evt);
            }
        });
        this.tbKoleksi.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.tbKoleksiKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbKoleksi);
        this.jPanel2.add(this.scrollPane1, "Center");
        this.jPanel1.add(this.jPanel2, "Center");
        this.PanelIndukCari.setBackground(new Color(90, 0, 90));
        this.PanelIndukCari.setName("PanelIndukCari");
        this.PanelIndukCari.setOpaque(false);
        this.PanelIndukCari.setPreferredSize(new Dimension(757, 130));
        this.PanelIndukCari.setLayout(new BorderLayout(1, 1));
        this.internalFrame2.setName("internalFrame2");
        this.internalFrame2.setPreferredSize(new Dimension(639, 40));
        this.internalFrame2.setLayout(new FlowLayout(0, 5, 7));
        this.label3.setHorizontalAlignment(4);
        this.label3.setText("Key Word :");
        this.label3.setHorizontalTextPosition(0);
        this.label3.setName("label3");
        this.label3.setPreferredSize(new Dimension(65, 23));
        this.internalFrame2.add((Component)this.label3);
        this.TCari.setMaximumSize(new Dimension(430, 23));
        this.TCari.setMinimumSize(new Dimension(430, 23));
        this.TCari.setName("TCari");
        this.TCari.setPreferredSize(new Dimension(430, 23));
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TCariKeyPressed(evt);
            }
            
            public void keyTyped(final KeyEvent evt) {
                DlgKoleksi.this.TCariKeyTyped(evt);
            }
        });
        this.internalFrame2.add((Component)this.TCari);
        this.BtnCari.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCari.setMnemonic('5');
        this.BtnCari.setToolTipText("Alt+5");
        this.BtnCari.setCursor(new Cursor(12));
        this.BtnCari.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCari.setName("BtnCari");
        this.BtnCari.setPreferredSize(new Dimension(28, 23));
        this.BtnCari.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnCariKeyPressed(evt);
            }
        });
        this.internalFrame2.add((Component)this.BtnCari);
        this.label4.setHorizontalAlignment(4);
        this.label4.setText("Record :");
        this.label4.setHorizontalTextPosition(0);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(70, 23));
        this.internalFrame2.add((Component)this.label4);
        this.LCount.setHorizontalAlignment(2);
        this.LCount.setText("0");
        this.LCount.setHorizontalTextPosition(0);
        this.LCount.setName("LCount");
        this.LCount.setPreferredSize(new Dimension(100, 23));
        this.internalFrame2.add((Component)this.LCount);
        this.PanelIndukCari.add(this.internalFrame2, "Last");
        this.PanelCari.setName("PanelCari");
        this.PanelCari.setPreferredSize(new Dimension(639, 80));
        this.PanelCari.setLayout(null);
        this.TPnbCari.setEditable(false);
        this.TPnbCari.setMaximumSize(new Dimension(430, 23));
        this.TPnbCari.setMinimumSize(new Dimension(430, 23));
        this.TPnbCari.setName("TPnbCari");
        this.TPnbCari.setPreferredSize(new Dimension(100, 23));
        this.TPnbCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TPnbCariKeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.TPnbCari);
        this.TPnbCari.setBounds(60, 7, 160, 23);
        this.BtnPglPnb1.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb1.setMnemonic('4');
        this.BtnPglPnb1.setToolTipText("Alt+4");
        this.BtnPglPnb1.setCursor(new Cursor(12));
        this.BtnPglPnb1.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb1.setName("BtnPglPnb1");
        this.BtnPglPnb1.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb1.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPnb1ActionPerformed(evt);
            }
        });
        this.BtnPglPnb1.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPnb1KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb1);
        this.BtnPglPnb1.setBounds(492, 37, 25, 23);
        this.TPngCari.setEditable(false);
        this.TPngCari.setMaximumSize(new Dimension(430, 23));
        this.TPngCari.setMinimumSize(new Dimension(430, 23));
        this.TPngCari.setName("TPngCari");
        this.TPngCari.setPreferredSize(new Dimension(100, 23));
        this.TPngCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TPngCariKeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.TPngCari);
        this.TPngCari.setBounds(330, 7, 160, 23);
        this.BtnPglPnb2.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb2.setMnemonic('2');
        this.BtnPglPnb2.setToolTipText("Alt+2");
        this.BtnPglPnb2.setCursor(new Cursor(12));
        this.BtnPglPnb2.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb2.setName("BtnPglPnb2");
        this.BtnPglPnb2.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb2.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPnb2ActionPerformed(evt);
            }
        });
        this.BtnPglPnb2.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPnb2KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb2);
        this.BtnPglPnb2.setBounds(222, 37, 25, 23);
        this.TKtgCari.setEditable(false);
        this.TKtgCari.setMaximumSize(new Dimension(430, 23));
        this.TKtgCari.setMinimumSize(new Dimension(430, 23));
        this.TKtgCari.setName("TKtgCari");
        this.TKtgCari.setPreferredSize(new Dimension(100, 23));
        this.TKtgCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TKtgCariKeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.TKtgCari);
        this.TKtgCari.setBounds(60, 37, 160, 23);
        this.BtnPglPnb3.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb3.setMnemonic('3');
        this.BtnPglPnb3.setToolTipText("Alt+3");
        this.BtnPglPnb3.setCursor(new Cursor(12));
        this.BtnPglPnb3.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb3.setName("BtnPglPnb3");
        this.BtnPglPnb3.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb3.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPnb3ActionPerformed(evt);
            }
        });
        this.BtnPglPnb3.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPnb3KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb3);
        this.BtnPglPnb3.setBounds(492, 7, 25, 23);
        this.TJnsCari.setEditable(false);
        this.TJnsCari.setMaximumSize(new Dimension(430, 23));
        this.TJnsCari.setMinimumSize(new Dimension(430, 23));
        this.TJnsCari.setName("TJnsCari");
        this.TJnsCari.setPreferredSize(new Dimension(100, 23));
        this.TJnsCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.TJnsCariKeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.TJnsCari);
        this.TJnsCari.setBounds(330, 37, 160, 23);
        this.BtnPglPnb4.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb4.setMnemonic('1');
        this.BtnPglPnb4.setToolTipText("Alt+1");
        this.BtnPglPnb4.setCursor(new Cursor(12));
        this.BtnPglPnb4.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb4.setName("BtnPglPnb4");
        this.BtnPglPnb4.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb4.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.BtnPglPnb4ActionPerformed(evt);
            }
        });
        this.BtnPglPnb4.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgKoleksi.this.BtnPglPnb4KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb4);
        this.BtnPglPnb4.setBounds(222, 7, 25, 23);
        this.label13.setHorizontalAlignment(4);
        this.label13.setText("Jenis :");
        this.label13.setName("label13");
        this.PanelCari.add((Component)this.label13);
        this.label13.setBounds(250, 37, 80, 23);
        this.label14.setHorizontalAlignment(4);
        this.label14.setText("Prdsen :");
        this.label14.setName("label14");
        this.PanelCari.add((Component)this.label14);
        this.label14.setBounds(0, 7, 60, 23);
        this.label24.setHorizontalAlignment(4);
        this.label24.setText("Kategori :");
        this.label24.setName("label24");
        this.PanelCari.add((Component)this.label24);
        this.label24.setBounds(0, 37, 60, 23);
        this.label25.setHorizontalAlignment(4);
        this.label25.setText("Type/Merk :");
        this.label25.setName("label25");
        this.PanelCari.add((Component)this.label25);
        this.label25.setBounds(250, 7, 80, 23);
        this.ChkCrThn.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkCrThn.setText("Thn.Prdksi :");
        this.ChkCrThn.setName("ChkCrThn");
        this.ChkCrThn.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkCrThn.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkCrThn.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkCrThn.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgKoleksi.this.ChkCrThnItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkCrThn);
        this.ChkCrThn.setBounds(545, 7, 90, 23);
        this.CmbThnCari.setName("CmbThnCari");
        this.CmbThnCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgKoleksi.this.CmbThnCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.CmbThnCari);
        this.CmbThnCari.setBounds(545, 37, 80, 23);
        this.PanelIndukCari.add(this.PanelCari, "Center");
        this.panel2.setBorder(BorderFactory.createLineBorder(new Color(74, 54, 105)));
        this.panel2.setName("panel2");
        this.panel2.setPreferredSize(new Dimension(100, 20));
        this.panel2.setLayout(new BorderLayout());
        this.ChkCari.setBackground(new Color(40, 0, 40));
        this.ChkCari.setFont(new Font("Comic Sans MS", 0, 12));
        this.ChkCari.setForeground(new Color(255, 204, 255));
        this.ChkCari.setMnemonic('D');
        this.ChkCari.setText("  .: Pencarian Data  :: ================================================================================ ::");
        this.ChkCari.setToolTipText("Alt+D");
        this.ChkCari.setBorder(null);
        this.ChkCari.setBorderPainted(true);
        this.ChkCari.setBorderPaintedFlat(true);
        this.ChkCari.setCursor(new Cursor(12));
        this.ChkCari.setFocusPainted(false);
        this.ChkCari.setHorizontalAlignment(2);
        this.ChkCari.setHorizontalTextPosition(4);
        this.ChkCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/145.png")));
        this.ChkCari.setName("ChkCari");
        this.ChkCari.setOpaque(true);
        this.ChkCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/145.png")));
        this.ChkCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/143.png")));
        this.ChkCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/143.png")));
        this.ChkCari.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgKoleksi.this.ChkCariActionPerformed(evt);
            }
        });
        this.panel2.add(this.ChkCari, "Center");
        this.PanelIndukCari.add(this.panel2, "First");
        this.jPanel1.add(this.PanelIndukCari, "Last");
        this.panelJudul2.setName("panelJudul2");
        this.panelJudul2.setPreferredSize(new Dimension(163, 28));
        this.panelJudul2.setLayout(new BorderLayout());
        this.jLabel2.setBackground(Color.darkGray);
        this.jLabel2.setFont(new Font("Book Antiqua", 3, 14));
        this.jLabel2.setForeground(new Color(255, 204, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText(":: DAFTAR BARANG ::");
        this.jLabel2.setIconTextGap(2);
        this.jLabel2.setName("jLabel2");
        this.panelJudul2.add(this.jLabel2, "Center");
        this.jPanel1.add(this.panelJudul2, "First");
        this.getContentPane().add(this.jPanel1, "Center");
        this.pack();
    }
    
    private void BtnTambahActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.LabelKon.setVisible(true);
        this.TKd.setEditable(true);
        this.DlgInput.setLocationRelativeTo(null);
        this.DlgInput.setVisible(true);
    }
    
    private void BtnTambahKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnTambahActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnHapus);
        }
    }
    
    private void BtnHapusActionPerformed(final ActionEvent evt) {
        if (this.TJdl.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data koleksi yang akan Anda hapus dengan menklik data pada tabel...!!!");
            this.tbKoleksi.requestFocus();
        }
        else {
            this.Valid.hapusTable(this.tabMode, (JTextField)this.TKd, "buku", "kode_buku");
            this.tampil("");
            this.emptTeks();
        }
    }
    
    private void BtnHapusKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnHapusActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnTambah, (JButton)this.BtnEdit);
        }
    }
    
    private void BtnEditActionPerformed(final ActionEvent evt) {
        if (this.tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, Tabel kosong. Tidak ada data yang bisa Anda edit..!!!!");
            this.BtnTambah.requestFocus();
        }
        else if (this.TJdl.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data koleksi yang akan Anda edit dengan menklik data pada tabel...!!!");
            this.tbKoleksi.requestFocus();
        }
        else if (!this.TJdl.getText().trim().equals("")) {
            this.TKd.setEditable(false);
            this.TJdl.requestFocus();
            this.LabelKon.setVisible(true);
            this.DlgInput.setLocationRelativeTo(null);
            this.DlgInput.setVisible(true);
        }
    }
    
    private void BtnEditKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnEditActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnHapus, (JButton)this.BtnPrint);
        }
    }
    
    private void BtnPrintActionPerformed(final ActionEvent evt) {
        this.setCursor(Cursor.getPredefinedCursor(3));
        if (!this.TCari.getText().trim().equals("")) {
            this.BtnCariActionPerformed(evt);
        }
        if (this.tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            this.BtnBatal.requestFocus();
        }
        else if (this.tabMode.getRowCount() != 0) {
            if (this.TCari.getText().trim().equals("") && !this.ChkCari.isVisible()) {
                this.Valid.MyReport("rptKoleksi.jrxml", "report", "::[ Data Koleksi ]::", "select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis  order by buku.kode_buku");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                final String sql = " buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
                this.Valid.MyReport("rptKoleksi.jrxml", "report", "::[ Data Koleksi ]::", "select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where " + sql + "and buku.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by buku.kode_buku");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String key = "";
                if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "'";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "'";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
                    key = "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ";
                }
                else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
                    key = "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ";
                }
                this.Valid.MyReport("rptKoleksi.jrxml", "report", "::[ Data Koleksi ]::", "select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis " + key + " order by buku.kode_buku");
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    private void BtnPrintKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnPrintActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JButton)this.BtnAll);
        }
    }
    
    private void BtnAllActionPerformed(final ActionEvent evt) {
        this.TCari.setText("");
        this.TPnbCari.setText("");
        this.TPngCari.setText("");
        this.TKtgCari.setText("");
        this.TJnsCari.setText("");
        this.tampil("");
    }
    
    private void BtnAllKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnPrint, (JButton)this.BtnKeluar);
        }
    }
    
    private void BtnKeluarActionPerformed(final ActionEvent evt) {
        this.setVisible(false);
    }
    
    private void BtnKeluarKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.setVisible(false);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAll, (JTextField)this.TCari);
        }
    }
    
    private void tbKoleksiMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbKoleksiKeyPressed(final KeyEvent evt) {
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
    
    private void TCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCari);
        }
    }
    
    private void BtnCariActionPerformed(final ActionEvent evt) {
        final String sql = " buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
        this.prosesCari("select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where " + sql + "and buku.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by buku.kode_buku");
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnTambah);
        }
    }
    
    private void TPnbCariKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnb1ActionPerformed(final ActionEvent evt) {
        this.tampilJns();
        this.DlgCariJns.setLocationRelativeTo(null);
        this.DlgCariJns.setVisible(true);
    }
    
    private void BtnPglPnb1KeyPressed(final KeyEvent evt) {
    }
    
    private void TPngCariKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnb2ActionPerformed(final ActionEvent evt) {
        this.tampilKtg();
        this.DlgCariKtg.setLocationRelativeTo(null);
        this.DlgCariKtg.setVisible(true);
    }
    
    private void BtnPglPnb2KeyPressed(final KeyEvent evt) {
    }
    
    private void TKtgCariKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnb3ActionPerformed(final ActionEvent evt) {
        this.tampilPng();
        this.DlgCariPng.setLocationRelativeTo(null);
        this.DlgCariPng.setVisible(true);
    }
    
    private void BtnPglPnb3KeyPressed(final KeyEvent evt) {
    }
    
    private void TJnsCariKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnb4ActionPerformed(final ActionEvent evt) {
        this.tampilPnb();
        this.DlgCariPnb.setLocationRelativeTo(null);
        this.DlgCariPnb.setVisible(true);
    }
    
    private void BtnPglPnb4KeyPressed(final KeyEvent evt) {
    }
    
    private void ChkCrThnItemStateChanged(final ItemEvent evt) {
        this.isCari();
    }
    
    private void CmbThnCariItemStateChanged(final ItemEvent evt) {
        this.isCari();
    }
    
    private void ChkCariActionPerformed(final ActionEvent evt) {
        if (this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(true);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 130));
            this.TCari.setText("");
            this.isCari();
        }
        else if (!this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(false);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 61));
            this.BtnCariActionPerformed(null);
        }
    }
    
    private void TJdlKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKd, (JTextField)this.THlm);
    }
    
    private void THlmKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TJdl, this.CmbThn);
    }
    
    private void TKdPnbKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbThn, (JTextField)this.TKdPng);
    }
    
    private void TKdPngKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdPnb, (JTextField)this.TIsbn);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TKd.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKd, "Kode Koleksi");
        }
        else if (this.TJdl.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TJdl, "Judul Koleksi");
        }
        else if (this.THlm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.THlm, "Jml.Halaman");
        }
        else if (this.TKdPnb.getText().trim().equals("") || this.TNmPnb.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdPnb, "Penerbit");
        }
        else if (this.TKdPng.getText().trim().equals("") || this.TNmPng.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdPng, "Pengarang");
        }
        else if (this.TIsbn.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TIsbn, "ISBN");
        }
        else if (this.TKdKtg.getText().trim().equals("") || this.TNmKtg.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdKtg, "Kategori Koleksi");
        }
        else if (this.TKdJns.getText().trim().equals("") || this.TNmJns.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdJns, "Jenis Koleksi");
        }
        else {
            if (this.TKd.isEditable()) {
                this.Sequel.menyimpan("buku", "'" + this.TKd.getText() + "','" + this.TJdl.getText() + "','" + this.THlm.getText() + "','" + this.TKdPnb.getText() + "','" + this.TKdPng.getText() + "','" + this.CmbThn.getSelectedItem() + "','" + this.TIsbn.getText() + "','" + this.TKdKtg.getText() + "','" + this.TKdJns.getText() + "'", "Kode Koleksi");
                this.TKd.requestFocus();
            }
            else if (!this.TKd.isEditable()) {
                this.Sequel.mengedit("buku", "kode_buku='" + this.TKd.getText() + "'", "judul_buku='" + this.TJdl.getText() + "'," + "jml_halaman='" + this.THlm.getText() + "'," + "kode_penerbit='" + this.TKdPnb.getText() + "'," + "kode_pengarang='" + this.TKdPng.getText() + "'," + "thn_terbit='" + this.CmbThn.getSelectedItem() + "'," + "isbn='" + this.TIsbn.getText() + "'," + "id_kategori='" + this.TKdKtg.getText() + "'," + "id_jenis='" + this.TKdJns.getText() + "'");
                this.DlgInput.dispose();
            }
            this.tampil("");
            this.emptTeks();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TKdJns, (JButton)this.BtnBatal);
        }
    }
    
    private void BtnCloseInputActionPerformed(final ActionEvent evt) {
        this.LabelKon.setVisible(false);
        this.DlgInput.dispose();
    }
    
    private void BtnCloseInputKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.DlgInput.dispose();
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TKdPnb, (JTextField)this.TNmPnb);
        }
    }
    
    private void TKdKtgKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TIsbn, (JTextField)this.TKdJns);
    }
    
    private void TKdJnsKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdKtg, (JButton)this.BtnSimpan);
    }
    
    private void BtnBatalActionPerformed(final ActionEvent evt) {
        if (this.TKd.isEditable()) {
            this.emptTeks();
        }
        else if (!this.TKd.isEditable()) {
            this.LabelKon.setVisible(false);
            this.DlgInput.dispose();
        }
    }
    
    private void BtnBatalKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnBatalActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnSimpan, (JButton)this.BtnCloseInput);
        }
    }
    
    private void BtnPglPnbActionPerformed(final ActionEvent evt) {
        this.tampilPnb();
        this.DlgCariPnb.setLocationRelativeTo(null);
        this.DlgCariPnb.setVisible(true);
    }
    
    private void BtnPglPnbKeyPressed(final KeyEvent evt) {
    }
    
    private void TKdKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCloseInput, (JTextField)this.TJdl);
    }
    
    private void BtnPglPngActionPerformed(final ActionEvent evt) {
        this.tampilPng();
        this.DlgCariPng.setLocationRelativeTo(null);
        this.DlgCariPng.setVisible(true);
    }
    
    private void BtnPglPngKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglKtgActionPerformed(final ActionEvent evt) {
        this.tampilKtg();
        this.DlgCariKtg.setLocationRelativeTo(null);
        this.DlgCariKtg.setVisible(true);
    }
    
    private void BtnPglKtgKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglJnsActionPerformed(final ActionEvent evt) {
        this.tampilJns();
        this.DlgCariJns.setLocationRelativeTo(null);
        this.DlgCariJns.setVisible(true);
    }
    
    private void BtnPglJnsKeyPressed(final KeyEvent evt) {
    }
    
    private void TIsbnKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdPng, (JTextField)this.TKdKtg);
    }
    
    private void CmbThnKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.THlm, (JTextField)this.TKdPnb);
    }
    
    private void TCariPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnClosePng, (JButton)this.BtnCariPng);
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
            this.Valid.pindah(evt, (JButton)this.BtnCariPng, (JButton)this.BtnClosePng);
        }
    }
    
    private void BtnClosePngActionPerformed(final ActionEvent evt) {
        this.DlgCariPng.dispose();
    }
    
    private void BtnClosePngKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllPng, (JTextField)this.TCariPng);
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
        this.DlgCariKtg.dispose();
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
        this.DlgCariJns.dispose();
    }
    
    private void BtnCloseJnsKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllJns, (JTextField)this.TCariJns);
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
    
    private void TCariPnbKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPnbActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseKtg, (JButton)this.BtnCariPnb);
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
            this.Valid.pindah(evt, (JButton)this.BtnCariPnb, (JButton)this.BtnCloseKtg);
        }
    }
    
    private void BtnClosePnbActionPerformed(final ActionEvent evt) {
        this.DlgCariPnb.dispose();
    }
    
    private void BtnClosePnbKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllPnb, (JTextField)this.TCariPnb);
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
    
    private void TCariKeyTyped(final KeyEvent evt) {
        if (this.ChkCari.isSelected()) {
            this.ChkCari.setSelected(false);
            this.ChkCariActionPerformed(null);
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgKoleksi dialog = new DlgKoleksi(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void tampil(final String key) {
        final String sql = "select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis " + key + " order by buku.kode_buku";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6).substring(0, 4), rs.getString(7), rs.getString(8), rs.getString(9) };
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
        this.TJdl.setText("");
        this.THlm.setText("");
        this.TKdJns.setText("");
        this.TKdKtg.setText("");
        this.TKdPnb.setText("");
        this.TKdPng.setText("");
        this.TIsbn.setText("");
        this.TKd.requestFocus();
        this.Valid.autoNomer(this.tabMode, "B", 9, (JTextField)this.TKd);
    }
    
    public void focus() {
        this.TCari.requestFocus();
    }
    
    private void isPnb() {
        this.Sequel.cariIsi("select nama_penerbit from penerbit where kode_penerbit='" + this.TKdPnb.getText() + "'", (JTextField)this.TNmPnb);
    }
    
    private void isPng() {
        this.Sequel.cariIsi("select nama_pengarang from pengarang where kode_pengarang='" + this.TKdPng.getText() + "'", (JTextField)this.TNmPng);
    }
    
    private void isKtg() {
        this.Sequel.cariIsi("select nama_kategori from kategori where id_kategori='" + this.TKdKtg.getText() + "'", (JTextField)this.TNmKtg);
    }
    
    private void isJns() {
        this.Sequel.cariIsi("select nama_jenis from jenis_buku where id_jenis='" + this.TKdJns.getText() + "'", (JTextField)this.TNmJns);
    }
    
    private void isCari() {
        if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "'");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "'");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (!this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and penerbit.nama_penerbit='" + this.TPnbCari.getText() + "' " + "and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' " + "and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && !this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and pengarang.nama_pengarang='" + this.TPngCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and kategori.nama_kategori='" + this.TKtgCari.getText() + "' " + "and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' " + "and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && !this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and jenis_buku.nama_jenis='" + this.TJnsCari.getText() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && this.ChkCrThn.isSelected()) {
            this.tampil("and buku.thn_terbit='" + this.CmbThnCari.getSelectedItem() + "' ");
        }
        else if (this.TPnbCari.getText().equals("") && this.TPngCari.getText().equals("") && !this.TKtgCari.getText().equals("") && this.TJnsCari.getText().equals("") && !this.ChkCrThn.isSelected()) {
            this.tampil("and kategori.nama_kategori='" + this.TKtgCari.getText() + "' ");
        }
    }
    
    private void getData() {
        final int row = this.tbKoleksi.getSelectedRow();
        if (row != -1) {
            this.TKd.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TJdl.setText(this.tabMode.getValueAt(row, 1).toString());
            this.THlm.setText(this.tabMode.getValueAt(row, 2).toString());
            this.Sequel.cariIsi("select kode_penerbit from penerbit where nama_penerbit='" + this.tabMode.getValueAt(row, 3).toString() + "'", (JTextField)this.TKdPnb);
            this.Sequel.cariIsi("select kode_pengarang from pengarang where nama_pengarang='" + this.tabMode.getValueAt(row, 4).toString() + "'", (JTextField)this.TKdPng);
            this.CmbThn.setSelectedItem(this.tabMode.getValueAt(row, 5).toString());
            this.TIsbn.setText(this.tabMode.getValueAt(row, 6).toString());
            this.Sequel.cariIsi("select id_kategori from kategori where nama_kategori='" + this.tabMode.getValueAt(row, 7).toString() + "'", (JTextField)this.TKdKtg);
            this.Sequel.cariIsi("select id_jenis from jenis_buku where nama_jenis='" + this.tabMode.getValueAt(row, 8).toString() + "'", (JTextField)this.TKdJns);
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
    }
    
    private void getDataPng() {
        final int row = this.tbPengarang.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModePng.getValueAt(row, 0).toString();
            final String nama = this.tabModePng.getValueAt(row, 1).toString();
            this.TKdPng.setText(kode);
            if (this.LabelKon.isVisible()) {
                this.TNmPng.setText(nama);
            }
            else if (!this.LabelKon.isVisible()) {
                this.TPngCari.setText(nama);
            }
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
            if (this.LabelKon.isVisible()) {
                this.TNmKtg.setText(nama);
            }
            else if (!this.LabelKon.isVisible()) {
                this.TKtgCari.setText(nama);
            }
        }
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
            if (this.LabelKon.isVisible()) {
                this.TNmJns.setText(nama);
            }
            else if (!this.LabelKon.isVisible()) {
                this.TJnsCari.setText(nama);
            }
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
    }
    
    private void getDataPnb() {
        final int row = this.tbPenerbit.getSelectedRow();
        if (row != -1) {
            this.TKdPnb.setText(this.tabModePnb.getValueAt(row, 0).toString());
            if (this.LabelKon.isVisible()) {
                this.TNmPnb.setText(this.tabModePnb.getValueAt(row, 1).toString());
            }
            else if (!this.LabelKon.isVisible()) {
                this.TPnbCari.setText(this.tabModePnb.getValueAt(row, 1).toString());
            }
        }
    }
}
