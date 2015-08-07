package simpus;

import uz.ncipro.calendar.*;
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
import java.util.*;
import java.util.Date;
import java.util.logging.*;
import java.text.*;

public class DlgInventaris extends JDialog
{
    private DefaultTableModel tabMode;
    private DefaultTableModel tabModeKol;
    private DefaultTableModel tabModeRuang;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    DecimalFormat df2;
    private Button BtnAll;
    private Button BtnAllKol;
    private Button BtnAllRuang;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnCariKol;
    private Button BtnCariRuang;
    private Button BtnCloseInput;
    private Button BtnCloseKol;
    private Button BtnCloseRuang;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPglPnb;
    private Button BtnPglPnb1;
    private Button BtnPrint;
    private Button BtnSimpan;
    private Button BtnTambah;
    private JCheckBox ChkCari;
    private CekBox ChkJnsCari;
    private CekBox ChkKtgCari;
    private CekBox ChkSttsCari;
    private CekBox ChkTglCari;
    private ComboBox CmbAsl;
    private ComboBox CmbBox;
    private ComboBox CmbJnsCari;
    private ComboBox CmbKtgCari;
    private ComboBox CmbRak;
    private ComboBox CmbStts;
    private ComboBox CmbSttsCari;
    private JDateTimePicker DTPAda;
    private JDateTimePicker DTPCari1;
    private JDateTimePicker DTPCari2;
    private JDialog DlgInput;
    private JDialog DlgKoleksi;
    private JDialog DlgRuang;
    private Label LCount;
    private Label LCount1;
    private JMenuItem MnBarcode;
    private InternalFrame PanelCari;
    private JPanel PanelIndukCari;
    private TextBox TCari;
    private TextBox TCariKol;
    private TextBox TCariRuang;
    private TextBox THrg;
    private TextBox TJdl;
    private TextBox TJns;
    private TextBox TKdKol;
    private TextBox TKdR;
    private TextBox TKtg;
    private TextBox TNmR;
    private TextBox TNo;
    private TextBox TPnb;
    private TextBox TPng;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private InternalFrame internalFrame5;
    private InternalFrame internalFrame6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPopupMenu jPopupMenu1;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label10;
    private Label label11;
    private Label label13;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label2;
    private Label label20;
    private Label label21;
    private Label label22;
    private Label label23;
    private Label label24;
    private Label label25;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Panel panel1;
    private Panel panel2;
    private PanelGlass panelGlass4;
    private PanelGlass panelGlass5;
    private PanelJudul panelJudul1;
    private PanelJudul panelJudul2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane3;
    private ScrollPane scrollPane4;
    private Table tbInventaris;
    private Table tbKoleksi;
    private Table tbRuang;
    
    public DlgInventaris(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.df2 = new DecimalFormat("###,###,###,###,###,###,###");
        this.initComponents();
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nomer ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Asal Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Pengadaan</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Harga</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Stts.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Ruang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Rak</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Box</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbInventaris.setModel(this.tabMode);
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
        final Object[] rowKol = { "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Produsen Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>" };
        this.tabModeKol = new DefaultTableModel((Object[][])null, rowKol) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbKoleksi.setModel(this.tabModeKol);
        this.tbKoleksi.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbKoleksi.setAutoResizeMode(0);
        for (int j = 0; j < 9; ++j) {
            final TableColumn column2 = this.tbKoleksi.getColumnModel().getColumn(j);
            if (j == 0) {
                column2.setPreferredWidth(100);
            }
            else if (j == 1) {
                column2.setPreferredWidth(350);
            }
            else if (j == 2) {
                column2.setPreferredWidth(60);
            }
            else if (j == 3) {
                column2.setPreferredWidth(150);
            }
            else if (j == 4) {
                column2.setPreferredWidth(150);
            }
            else if (j == 5) {
                column2.setPreferredWidth(70);
            }
            else if (j == 6) {
                column2.setPreferredWidth(110);
            }
            else if (j == 7) {
                column2.setPreferredWidth(150);
            }
            else if (j == 8) {
                column2.setPreferredWidth(150);
            }
        }
        this.tbKoleksi.setDefaultRenderer(Object.class, new WarnaTable());
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
        for (int k = 0; k < 2; ++k) {
            final TableColumn column3 = this.tbRuang.getColumnModel().getColumn(k);
            if (k == 0) {
                column3.setPreferredWidth(120);
            }
            else if (k == 1) {
                column3.setPreferredWidth(335);
            }
        }
        this.tbRuang.setDefaultRenderer(Object.class, new WarnaTable());
        this.TNo.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TNo));
        this.TKdKol.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TKdKol));
        this.THrg.setDocument((Document)new batasInput(12).getOnlyAngka((JTextField)this.THrg));
        this.TKdR.setDocument((Document)new batasInput(5).getFilter((JTextField)this.TKdR));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.TCari.requestFocus();
        this.TKdKol.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgInventaris.this.isKol();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgInventaris.this.isKol();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgInventaris.this.isKol();
            }
        });
        this.TKdR.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgInventaris.this.isRuang();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgInventaris.this.isRuang();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgInventaris.this.isRuang();
            }
        });
        this.ChkCariActionPerformed(null);
        this.DlgInput.setSize(734, 293);
        this.DlgInput.setVisible(false);
        this.DlgKoleksi.setSize(450, 280);
        this.DlgKoleksi.setVisible(false);
        this.DlgRuang.setSize(450, 280);
        this.DlgRuang.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgInput = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.label1 = new Label();
        this.TNo = new TextBox();
        this.TJdl = new TextBox();
        this.label2 = new Label();
        this.label5 = new Label();
        this.TPng = new TextBox();
        this.TPnb = new TextBox();
        this.label7 = new Label();
        this.THrg = new TextBox();
        this.label8 = new Label();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnCloseInput = new Button();
        this.label10 = new Label();
        this.DTPAda = new JDateTimePicker();
        this.label11 = new Label();
        this.TKtg = new TextBox();
        this.label15 = new Label();
        this.TJns = new TextBox();
        this.label16 = new Label();
        this.CmbAsl = new ComboBox();
        this.label18 = new Label();
        this.TKdKol = new TextBox();
        this.CmbStts = new ComboBox();
        this.label19 = new Label();
        this.BtnPglPnb = new Button();
        this.jPanel3 = new JPanel();
        this.label20 = new Label();
        this.TKdR = new TextBox();
        this.TNmR = new TextBox();
        this.BtnPglPnb1 = new Button();
        this.label21 = new Label();
        this.CmbRak = new ComboBox();
        this.CmbBox = new ComboBox();
        this.label17 = new Label();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.DlgKoleksi = new JDialog();
        this.internalFrame5 = new InternalFrame();
        this.panelGlass4 = new PanelGlass();
        this.label22 = new Label();
        this.TCariKol = new TextBox();
        this.BtnCariKol = new Button();
        this.BtnAllKol = new Button();
        this.label23 = new Label();
        this.BtnCloseKol = new Button();
        this.scrollPane3 = new ScrollPane();
        this.tbKoleksi = new Table();
        this.DlgRuang = new JDialog();
        this.internalFrame6 = new InternalFrame();
        this.panelGlass5 = new PanelGlass();
        this.label24 = new Label();
        this.TCariRuang = new TextBox();
        this.BtnCariRuang = new Button();
        this.BtnAllRuang = new Button();
        this.label25 = new Label();
        this.BtnCloseRuang = new Button();
        this.scrollPane4 = new ScrollPane();
        this.tbRuang = new Table();
        this.jPopupMenu1 = new JPopupMenu();
        this.MnBarcode = new JMenuItem();
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
        this.tbInventaris = new Table();
        this.PanelIndukCari = new JPanel();
        this.internalFrame2 = new InternalFrame();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
        this.label6 = new Label();
        this.LCount1 = new Label();
        this.PanelCari = new InternalFrame();
        this.ChkKtgCari = new CekBox();
        this.CmbKtgCari = new ComboBox();
        this.ChkTglCari = new CekBox();
        this.DTPCari1 = new JDateTimePicker();
        this.label13 = new Label();
        this.DTPCari2 = new JDateTimePicker();
        this.ChkJnsCari = new CekBox();
        this.CmbJnsCari = new ComboBox();
        this.ChkSttsCari = new CekBox();
        this.CmbSttsCari = new ComboBox();
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
        this.label1.setText("No.Inventaris :");
        this.label1.setName("label1");
        this.internalFrame1.add((Component)this.label1);
        this.label1.setBounds(9, 12, 80, 23);
        this.TNo.setName("TNo");
        this.TNo.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TNoKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNo);
        this.TNo.setBounds(90, 12, 150, 23);
        this.TJdl.setEditable(false);
        this.TJdl.setName("TJdl");
        this.internalFrame1.add((Component)this.TJdl);
        this.TJdl.setBounds(212, 42, 478, 23);
        this.label2.setForeground(new Color(153, 153, 255));
        this.label2.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.label2.setName("label2");
        this.internalFrame1.add((Component)this.label2);
        this.label2.setBounds(-11, 160, 820, 14);
        this.label5.setHorizontalAlignment(4);
        this.label5.setText("Type/Merk :");
        this.label5.setName("label5");
        this.internalFrame1.add((Component)this.label5);
        this.label5.setBounds(9, 72, 80, 23);
        this.TPng.setEditable(false);
        this.TPng.setName("TPng");
        this.internalFrame1.add((Component)this.TPng);
        this.TPng.setBounds(90, 72, 135, 23);
        this.TPnb.setEditable(false);
        this.TPnb.setName("TPnb");
        this.internalFrame1.add((Component)this.TPnb);
        this.TPnb.setBounds(289, 72, 135, 23);
        this.label7.setHorizontalAlignment(4);
        this.label7.setText("Produsen :");
        this.label7.setName("label7");
        this.internalFrame1.add((Component)this.label7);
        this.label7.setBounds(223, 72, 65, 23);
        this.THrg.setName("THrg");
        this.THrg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.THrgKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.THrg);
        this.THrg.setBounds(110, 132, 115, 23);
        this.label8.setText("Harga : Rp. ");
        this.label8.setName("label8");
        this.internalFrame1.add((Component)this.label8);
        this.label8.setBounds(51, 132, 80, 23);
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
                DlgInventaris.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(14, 180, 100, 30);
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
                DlgInventaris.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnBatalKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnBatal);
        this.BtnBatal.setBounds(117, 180, 100, 30);
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
                DlgInventaris.this.BtnCloseInputActionPerformed(evt);
            }
        });
        this.BtnCloseInput.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCloseInputKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnCloseInput);
        this.BtnCloseInput.setBounds(616, 180, 100, 30);
        this.label10.setHorizontalAlignment(4);
        this.label10.setText("Kode Barang :");
        this.label10.setName("label10");
        this.internalFrame1.add((Component)this.label10);
        this.label10.setBounds(9, 42, 80, 23);
        this.DTPAda.setBackground(new Color(90, 0, 90));
        this.DTPAda.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPAda.setEditable(false);
        this.DTPAda.setForeground(new Color(205, 214, 255));
        this.DTPAda.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "17/11/2011" }));
        this.DTPAda.setDisplayFormat("dd/MM/yyyy");
        this.DTPAda.setName("DTPAda");
        this.DTPAda.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.DTPAdaKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPAda);
        this.DTPAda.setBounds(481, 12, 90, 23);
        this.label11.setHorizontalAlignment(4);
        this.label11.setText("Asal :");
        this.label11.setName("label11");
        this.internalFrame1.add((Component)this.label11);
        this.label11.setBounds(223, 132, 65, 23);
        this.TKtg.setEditable(false);
        this.TKtg.setName("TKtg");
        this.internalFrame1.add((Component)this.TKtg);
        this.TKtg.setBounds(90, 102, 135, 23);
        this.label15.setHorizontalAlignment(4);
        this.label15.setText("Kategori :");
        this.label15.setName("label15");
        this.internalFrame1.add((Component)this.label15);
        this.label15.setBounds(9, 102, 80, 23);
        this.TJns.setEditable(false);
        this.TJns.setName("TJns");
        this.internalFrame1.add((Component)this.TJns);
        this.TJns.setBounds(289, 102, 135, 23);
        this.label16.setHorizontalAlignment(4);
        this.label16.setText("Jenis :");
        this.label16.setName("label16");
        this.internalFrame1.add((Component)this.label16);
        this.label16.setBounds(223, 102, 65, 23);
        this.CmbAsl.setModel(new DefaultComboBoxModel<Object>(new String[] { "BELI", "BANTUAN", "HIBAH", "-" }));
        this.CmbAsl.setName("CmbAsl");
        this.CmbAsl.setPreferredSize(new Dimension(56, 23));
        this.CmbAsl.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.CmbAslKeyPressed(evt);
            }
        });
        this.internalFrame1.add(this.CmbAsl);
        this.CmbAsl.setBounds(289, 132, 135, 23);
        this.label18.setText("Tgl.Pengadaan :");
        this.label18.setName("label18");
        this.internalFrame1.add((Component)this.label18);
        this.label18.setBounds(400, 12, 80, 23);
        this.TKdKol.setName("TKdKol");
        this.TKdKol.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TKdKolKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TKdKol);
        this.TKdKol.setBounds(90, 42, 120, 23);
        this.CmbStts.setModel(new DefaultComboBoxModel<Object>(new String[] { "ADA", "RUSAK", "HILANG", "PERBAIKAN", "DIPINJAM" }));
        this.CmbStts.setName("CmbStts");
        this.CmbStts.setPreferredSize(new Dimension(56, 23));
        this.CmbStts.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.CmbSttsKeyPressed(evt);
            }
        });
        this.internalFrame1.add(this.CmbStts);
        this.CmbStts.setBounds(628, 12, 90, 23);
        this.label19.setText("Status :");
        this.label19.setName("label19");
        this.internalFrame1.add((Component)this.label19);
        this.label19.setBounds(588, 12, 50, 23);
        this.BtnPglPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb.setMnemonic('1');
        this.BtnPglPnb.setToolTipText("Alt+1");
        this.BtnPglPnb.setCursor(new Cursor(12));
        this.BtnPglPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb.setName("BtnPglPnb");
        this.BtnPglPnb.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnPglPnbActionPerformed(evt);
            }
        });
        this.BtnPglPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnPglPnbKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglPnb);
        this.BtnPglPnb.setBounds(692, 42, 25, 23);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(255, 110, 255), 1, true), " Posisi Inventaris Di : ", 0, 0, new Font("Dialog", 0, 12), new Color(205, 214, 255)));
        this.jPanel3.setName("jPanel3");
        this.jPanel3.setOpaque(false);
        this.jPanel3.setLayout(null);
        this.label20.setText("Ruang :");
        this.label20.setName("label20");
        this.jPanel3.add((Component)this.label20);
        this.label20.setBounds(12, 20, 60, 23);
        this.TKdR.setName("TKdR");
        this.TKdR.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TKdRKeyPressed(evt);
            }
        });
        this.jPanel3.add((Component)this.TKdR);
        this.TKdR.setBounds(52, 20, 60, 23);
        this.TNmR.setEditable(false);
        this.TNmR.setName("TNmR");
        this.jPanel3.add((Component)this.TNmR);
        this.TNmR.setBounds(114, 20, 141, 23);
        this.BtnPglPnb1.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb1.setMnemonic('2');
        this.BtnPglPnb1.setToolTipText("Alt+2");
        this.BtnPglPnb1.setCursor(new Cursor(12));
        this.BtnPglPnb1.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb1.setName("BtnPglPnb1");
        this.BtnPglPnb1.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPnb1.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnPglPnb1ActionPerformed(evt);
            }
        });
        this.BtnPglPnb1.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnPglPnb1KeyPressed(evt);
            }
        });
        this.jPanel3.add((Component)this.BtnPglPnb1);
        this.BtnPglPnb1.setBounds(257, 20, 25, 23);
        this.label21.setText("Rak :");
        this.label21.setName("label21");
        this.jPanel3.add((Component)this.label21);
        this.label21.setBounds(25, 50, 50, 23);
        this.CmbRak.setModel(new DefaultComboBoxModel<Object>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        this.CmbRak.setName("CmbRak");
        this.CmbRak.setPreferredSize(new Dimension(56, 23));
        this.CmbRak.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.CmbRakKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.CmbRak);
        this.CmbRak.setBounds(52, 50, 60, 23);
        this.CmbBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        this.CmbBox.setName("CmbBox");
        this.CmbBox.setPreferredSize(new Dimension(56, 23));
        this.CmbBox.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.CmbBoxKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.CmbBox);
        this.CmbBox.setBounds(195, 50, 60, 23);
        this.label17.setText("Box :");
        this.label17.setName("label17");
        this.jPanel3.add((Component)this.label17);
        this.label17.setBounds(168, 50, 40, 23);
        this.internalFrame1.add(this.jPanel3);
        this.jPanel3.setBounds(430, 70, 290, 87);
        this.DlgInput.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: INPUT DATA INVENTARIS ::");
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
        this.DlgInput.getContentPane().add(this.panel1, "Last");
        this.DlgKoleksi.setModal(true);
        this.DlgKoleksi.setName("DlgKoleksi");
        this.DlgKoleksi.setResizable(false);
        this.DlgKoleksi.setUndecorated(true);
        this.internalFrame5.setName("internalFrame5");
        this.internalFrame5.setLayout(new BorderLayout(1, 1));
        this.panelGlass4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass4.setOpaqueImage(false);
        this.panelGlass4.setPreferredSize(new Dimension(40, 44));
        this.panelGlass4.setRound(false);
        this.panelGlass4.setWarna(new Color(90, 0, 90));
        this.panelGlass4.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label22.setHorizontalAlignment(4);
        this.label22.setText("Key Word :");
        this.label22.setName("label22");
        this.label22.setPreferredSize(new Dimension(63, 23));
        this.panelGlass4.add((Component)this.label22);
        this.TCariKol.setName("TCariKol");
        this.TCariKol.setPreferredSize(new Dimension(230, 23));
        this.TCariKol.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TCariKolKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.TCariKol);
        this.BtnCariKol.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariKol.setMnemonic('2');
        this.BtnCariKol.setToolTipText("Alt+2");
        this.BtnCariKol.setCursor(new Cursor(12));
        this.BtnCariKol.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariKol.setName("BtnCariKol");
        this.BtnCariKol.setPreferredSize(new Dimension(26, 23));
        this.BtnCariKol.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnCariKolActionPerformed(evt);
            }
        });
        this.BtnCariKol.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCariKolKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgInventaris.this.BtnCariKolKeyReleased(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnCariKol);
        this.BtnAllKol.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllKol.setMnemonic('1');
        this.BtnAllKol.setToolTipText("Alt+1");
        this.BtnAllKol.setCursor(new Cursor(12));
        this.BtnAllKol.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllKol.setName("BtnAllKol");
        this.BtnAllKol.setPreferredSize(new Dimension(26, 23));
        this.BtnAllKol.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnAllKolActionPerformed(evt);
            }
        });
        this.BtnAllKol.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnAllKolKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnAllKol);
        this.label23.setHorizontalAlignment(4);
        this.label23.setName("label23");
        this.label23.setPreferredSize(new Dimension(33, 23));
        this.panelGlass4.add((Component)this.label23);
        this.BtnCloseKol.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseKol.setMnemonic('3');
        this.BtnCloseKol.setToolTipText("Alt+3");
        this.BtnCloseKol.setCursor(new Cursor(12));
        this.BtnCloseKol.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseKol.setName("BtnCloseKol");
        this.BtnCloseKol.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseKol.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnCloseKolActionPerformed(evt);
            }
        });
        this.BtnCloseKol.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCloseKolKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.BtnCloseKol);
        this.internalFrame5.add((Component)this.panelGlass4, "First");
        this.scrollPane3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane3.setName("scrollPane3");
        this.tbKoleksi.setAutoCreateRowSorter(true);
        this.tbKoleksi.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbKoleksi.setName("tbKoleksi");
        this.tbKoleksi.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgInventaris.this.tbKoleksiMouseClicked(evt);
            }
        });
        this.tbKoleksi.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.tbKoleksiKeyPressed(evt);
            }
        });
        this.scrollPane3.setViewportView(this.tbKoleksi);
        this.internalFrame5.add(this.scrollPane3, "Center");
        this.DlgKoleksi.getContentPane().add(this.internalFrame5, "Center");
        this.DlgRuang.setModal(true);
        this.DlgRuang.setName("DlgRuang");
        this.DlgRuang.setResizable(false);
        this.DlgRuang.setUndecorated(true);
        this.internalFrame6.setName("internalFrame6");
        this.internalFrame6.setLayout(new BorderLayout(1, 1));
        this.panelGlass5.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass5.setOpaqueImage(false);
        this.panelGlass5.setPreferredSize(new Dimension(40, 44));
        this.panelGlass5.setRound(false);
        this.panelGlass5.setWarna(new Color(90, 0, 90));
        this.panelGlass5.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label24.setHorizontalAlignment(4);
        this.label24.setText("Key Word :");
        this.label24.setName("label24");
        this.label24.setPreferredSize(new Dimension(63, 23));
        this.panelGlass5.add((Component)this.label24);
        this.TCariRuang.setName("TCariRuang");
        this.TCariRuang.setPreferredSize(new Dimension(230, 23));
        this.TCariRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TCariRuangKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.TCariRuang);
        this.BtnCariRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariRuang.setMnemonic('2');
        this.BtnCariRuang.setToolTipText("Alt+2");
        this.BtnCariRuang.setCursor(new Cursor(12));
        this.BtnCariRuang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariRuang.setName("BtnCariRuang");
        this.BtnCariRuang.setPreferredSize(new Dimension(26, 23));
        this.BtnCariRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnCariRuangActionPerformed(evt);
            }
        });
        this.BtnCariRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCariRuangKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgInventaris.this.BtnCariRuangKeyReleased(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnCariRuang);
        this.BtnAllRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllRuang.setMnemonic('1');
        this.BtnAllRuang.setToolTipText("Alt+1");
        this.BtnAllRuang.setCursor(new Cursor(12));
        this.BtnAllRuang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllRuang.setName("BtnAllRuang");
        this.BtnAllRuang.setPreferredSize(new Dimension(26, 23));
        this.BtnAllRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnAllRuangActionPerformed(evt);
            }
        });
        this.BtnAllRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnAllRuangKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnAllRuang);
        this.label25.setHorizontalAlignment(4);
        this.label25.setName("label25");
        this.label25.setPreferredSize(new Dimension(33, 23));
        this.panelGlass5.add((Component)this.label25);
        this.BtnCloseRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseRuang.setMnemonic('3');
        this.BtnCloseRuang.setToolTipText("Alt+3");
        this.BtnCloseRuang.setCursor(new Cursor(12));
        this.BtnCloseRuang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseRuang.setName("BtnCloseRuang");
        this.BtnCloseRuang.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnCloseRuangActionPerformed(evt);
            }
        });
        this.BtnCloseRuang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCloseRuangKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.BtnCloseRuang);
        this.internalFrame6.add((Component)this.panelGlass5, "First");
        this.scrollPane4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane4.setName("scrollPane4");
        this.tbRuang.setAutoCreateRowSorter(true);
        this.tbRuang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbRuang.setName("tbRuang");
        this.tbRuang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgInventaris.this.tbRuangMouseClicked(evt);
            }
        });
        this.tbRuang.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.tbRuangKeyPressed(evt);
            }
        });
        this.scrollPane4.setViewportView(this.tbRuang);
        this.internalFrame6.add(this.scrollPane4, "Center");
        this.DlgRuang.getContentPane().add(this.internalFrame6, "Center");
        this.jPopupMenu1.setName("jPopupMenu1");
        this.MnBarcode.setBackground(new Color(153, 0, 153));
        this.MnBarcode.setForeground(new Color(204, 255, 255));
        this.MnBarcode.setText("Barcode Inventaris");
        this.MnBarcode.setName("MnBarcode");
        this.MnBarcode.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.MnBarcodeActionPerformed(evt);
            }
        });
        this.jPopupMenu1.add(this.MnBarcode);
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
                DlgInventaris.this.BtnTambahActionPerformed(evt);
            }
        });
        this.BtnTambah.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnTambahKeyPressed(evt);
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
                DlgInventaris.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnHapusKeyPressed(evt);
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
                DlgInventaris.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnEditKeyPressed(evt);
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
                DlgInventaris.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnPrintKeyPressed(evt);
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
                DlgInventaris.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnAllKeyPressed(evt);
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
                DlgInventaris.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnKeluar);
        this.jPanel2.add(this.internalFrame3, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setComponentPopupMenu(this.jPopupMenu1);
        this.scrollPane1.setName("scrollPane1");
        this.tbInventaris.setAutoCreateRowSorter(true);
        this.tbInventaris.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbInventaris.setComponentPopupMenu(this.jPopupMenu1);
        this.tbInventaris.setName("tbInventaris");
        this.tbInventaris.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgInventaris.this.tbInventarisMouseClicked(evt);
            }
        });
        this.tbInventaris.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.tbInventarisKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbInventaris);
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
        this.TCari.setName("TCari");
        this.TCari.setPreferredSize(new Dimension(230, 23));
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.TCariKeyPressed(evt);
            }
            
            public void keyTyped(final KeyEvent evt) {
                DlgInventaris.this.TCariKeyTyped(evt);
            }
        });
        this.internalFrame2.add((Component)this.TCari);
        this.BtnCari.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCari.setMnemonic('2');
        this.BtnCari.setToolTipText("Alt+2");
        this.BtnCari.setCursor(new Cursor(12));
        this.BtnCari.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCari.setName("BtnCari");
        this.BtnCari.setPreferredSize(new Dimension(28, 23));
        this.BtnCari.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgInventaris.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgInventaris.this.BtnCariKeyPressed(evt);
            }
        });
        this.internalFrame2.add((Component)this.BtnCari);
        this.label4.setHorizontalAlignment(4);
        this.label4.setText("Record :");
        this.label4.setHorizontalTextPosition(0);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(50, 23));
        this.internalFrame2.add((Component)this.label4);
        this.LCount.setHorizontalAlignment(2);
        this.LCount.setText("0");
        this.LCount.setHorizontalTextPosition(0);
        this.LCount.setName("LCount");
        this.LCount.setPreferredSize(new Dimension(50, 23));
        this.internalFrame2.add((Component)this.LCount);
        this.label6.setHorizontalAlignment(4);
        this.label6.setText("Nilai Inv : Rp.");
        this.label6.setHorizontalTextPosition(0);
        this.label6.setName("label6");
        this.label6.setPreferredSize(new Dimension(75, 23));
        this.internalFrame2.add((Component)this.label6);
        this.LCount1.setHorizontalAlignment(2);
        this.LCount1.setText("0");
        this.LCount1.setHorizontalTextPosition(0);
        this.LCount1.setName("LCount1");
        this.LCount1.setPreferredSize(new Dimension(140, 23));
        this.internalFrame2.add((Component)this.LCount1);
        this.PanelIndukCari.add(this.internalFrame2, "Last");
        this.PanelCari.setName("PanelCari");
        this.PanelCari.setPreferredSize(new Dimension(639, 40));
        this.PanelCari.setLayout(null);
        this.ChkKtgCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKtgCari.setText("Ketegori :");
        this.ChkKtgCari.setHorizontalAlignment(4);
        this.ChkKtgCari.setHorizontalTextPosition(4);
        this.ChkKtgCari.setName("ChkKtgCari");
        this.ChkKtgCari.setPreferredSize(new Dimension(62, 23));
        this.ChkKtgCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKtgCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkKtgCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkKtgCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkKtgCari);
        this.ChkKtgCari.setBounds(3, 7, 70, 23);
        this.CmbKtgCari.setName("CmbKtgCari");
        this.CmbKtgCari.setPreferredSize(new Dimension(150, 23));
        this.CmbKtgCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.CmbKtgCari);
        this.CmbKtgCari.setBounds(75, 7, 190, 23);
        this.ChkTglCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkTglCari.setText("Tgl.Pengadaan :");
        this.ChkTglCari.setHorizontalAlignment(4);
        this.ChkTglCari.setHorizontalTextPosition(4);
        this.ChkTglCari.setName("ChkTglCari");
        this.ChkTglCari.setPreferredSize(new Dimension(105, 23));
        this.ChkTglCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkTglCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkTglCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkTglCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkTglCari);
        this.ChkTglCari.setBounds(319, 7, 105, 23);
        this.DTPCari1.setBackground(new Color(90, 0, 90));
        this.DTPCari1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPCari1.setEditable(false);
        this.DTPCari1.setForeground(new Color(205, 214, 255));
        this.DTPCari1.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPCari1.setDisplayFormat("yyyy/MM/dd");
        this.DTPCari1.setName("DTPCari1");
        this.DTPCari1.setPreferredSize(new Dimension(82, 23));
        this.DTPCari1.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPCari1);
        this.DTPCari1.setBounds(426, 7, 85, 23);
        this.label13.setHorizontalAlignment(4);
        this.label13.setText("Sd");
        this.label13.setHorizontalTextPosition(0);
        this.label13.setName("label13");
        this.label13.setPreferredSize(new Dimension(14, 23));
        this.PanelCari.add((Component)this.label13);
        this.label13.setBounds(513, 7, 14, 23);
        this.DTPCari2.setBackground(new Color(90, 0, 90));
        this.DTPCari2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPCari2.setEditable(false);
        this.DTPCari2.setForeground(new Color(205, 214, 255));
        this.DTPCari2.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPCari2.setDisplayFormat("yyyy/MM/dd");
        this.DTPCari2.setName("DTPCari2");
        this.DTPCari2.setPreferredSize(new Dimension(82, 23));
        this.DTPCari2.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPCari2);
        this.DTPCari2.setBounds(531, 7, 85, 23);
        this.ChkJnsCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJnsCari.setText("Jenis :");
        this.ChkJnsCari.setHorizontalAlignment(4);
        this.ChkJnsCari.setHorizontalTextPosition(4);
        this.ChkJnsCari.setIconTextGap(19);
        this.ChkJnsCari.setName("ChkJnsCari");
        this.ChkJnsCari.setPreferredSize(new Dimension(62, 23));
        this.ChkJnsCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJnsCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkJnsCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkJnsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkJnsCari);
        this.ChkJnsCari.setBounds(3, 37, 70, 23);
        this.CmbJnsCari.setName("CmbJnsCari");
        this.CmbJnsCari.setPreferredSize(new Dimension(150, 23));
        this.CmbJnsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.CmbJnsCari);
        this.CmbJnsCari.setBounds(75, 37, 190, 23);
        this.ChkSttsCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSttsCari.setText("Stts.Inventaris :");
        this.ChkSttsCari.setHorizontalAlignment(4);
        this.ChkSttsCari.setHorizontalTextPosition(4);
        this.ChkSttsCari.setName("ChkSttsCari");
        this.ChkSttsCari.setPreferredSize(new Dimension(72, 23));
        this.ChkSttsCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSttsCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSttsCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSttsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkSttsCari);
        this.ChkSttsCari.setBounds(319, 37, 105, 23);
        this.CmbSttsCari.setModel(new DefaultComboBoxModel<Object>(new String[] { "ADA", "RUSAK", "HILANG", "PERBAIKAN", "DIPINJAM" }));
        this.CmbSttsCari.setName("CmbSttsCari");
        this.CmbSttsCari.setPreferredSize(new Dimension(150, 23));
        this.CmbSttsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgInventaris.this.CmbKtgCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.CmbSttsCari);
        this.CmbSttsCari.setBounds(426, 37, 190, 23);
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
                DlgInventaris.this.ChkCariActionPerformed(evt);
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
        this.jLabel2.setText(":: DAFTAR INVENTARIS ::");
        this.jLabel2.setIconTextGap(2);
        this.jLabel2.setName("jLabel2");
        this.panelJudul2.add(this.jLabel2, "Center");
        this.jPanel1.add(this.panelJudul2, "First");
        this.getContentPane().add(this.jPanel1, "Center");
        this.pack();
    }
    
    private void BtnTambahActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.TNo.setEditable(true);
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
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data inventaris yang akan Anda hapus dengan menklik data pada tabel...!!!");
            this.tbInventaris.requestFocus();
        }
        else {
            this.Valid.hapusTable(this.tabMode, (JTextField)this.TNo, "inventaris", "no_inventaris");
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
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data inventaris yang akan Anda edit dengan menklik data pada tabel...!!!");
            this.tbInventaris.requestFocus();
        }
        else if (!this.TJdl.getText().trim().equals("")) {
            this.TNo.setEditable(false);
            this.TJdl.requestFocus();
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
                this.Valid.MyReport("rptInv.jrxml", "report", "::[ Data Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori  and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                final String sql = " inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
                this.Valid.MyReport("rptInv.jrxml", "report", "::[ Data Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where " + sql + "and Inventaris.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.asal_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.tgl_pengadaan like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.harga like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.status_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Ruang.nm_ruang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_rak like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_box like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by Inventaris.no_inventaris");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String key = "";
                if (this.CmbJnsCari.getItemCount() > 0 && this.CmbKtgCari.getItemCount() > 0) {
                    if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                }
                this.Valid.MyReport("rptInv.jrxml", "report", "::[ Data Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori " + key + " and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris");
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
        this.ChkTglCari.setSelected(false);
        this.ChkJnsCari.setSelected(false);
        this.ChkKtgCari.setSelected(false);
        this.ChkSttsCari.setSelected(false);
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
        this.dispose();
    }
    
    private void BtnKeluarKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.setVisible(false);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnAll, (JTextField)this.TCari);
        }
    }
    
    private void tbInventarisMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbInventarisKeyPressed(final KeyEvent evt) {
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
        final String sql = " inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
        this.prosesCari("SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where " + sql + "and Inventaris.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.asal_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.tgl_pengadaan like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.harga like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.status_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Ruang.nm_ruang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_rak like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_box like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by Inventaris.no_inventaris");
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnTambah);
        }
    }
    
    private void ChkCariActionPerformed(final ActionEvent evt) {
        if (this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(true);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 130));
            this.TCari.setText("");
            this.CmbKtgCariItemStateChanged(null);
        }
        else if (!this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(false);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 61));
            this.BtnCariActionPerformed(null);
        }
    }
    
    private void TNoKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCloseInput, (JTextField)this.TKdKol);
    }
    
    private void CmbBoxKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbRak, (JButton)this.BtnSimpan);
    }
    
    private void THrgKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdKol, this.CmbAsl);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TNo.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNo, "NIP");
        }
        else if (this.TKdKol.getText().trim().equals("") || this.TJdl.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdKol, "Koleksi");
        }
        else if (this.THrg.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.THrg, "Harga Inventaris");
        }
        else if (this.TKdR.getText().trim().equals("") || this.TNmR.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdR, "Ruangan");
        }
        else {
            if (this.TNo.isEditable()) {
                this.DTPAda.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.menyimpan("inventaris", "'" + this.TNo.getText() + "','" + this.TKdKol.getText() + "','" + this.CmbAsl.getSelectedItem() + "','" + this.DTPAda.getSelectedItem() + "','" + this.THrg.getText() + "','" + this.CmbStts.getSelectedItem() + "','" + this.TKdR.getText() + "','" + this.CmbRak.getSelectedItem() + "','" + this.CmbBox.getSelectedItem() + "'", "No.Inventaris");
                this.DTPAda.setDisplayFormat("dd/MM/yyyy");
            }
            else if (!this.TNo.isEditable()) {
                this.DTPAda.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.mengedit("inventaris", "no_inventaris='" + this.TNo.getText() + "'", "kode_buku='" + this.TKdKol.getText() + "'," + "asal_buku='" + this.CmbAsl.getSelectedItem() + "'," + "tgl_pengadaan='" + this.DTPAda.getSelectedItem() + "'," + "harga='" + this.THrg.getText() + "'," + "status_buku='" + this.CmbStts.getSelectedItem() + "'," + "kd_ruang='" + this.TKdR.getText() + "'," + "no_rak='" + this.CmbRak.getSelectedItem() + "'," + "no_box='" + this.CmbBox.getSelectedItem() + "'");
                this.DTPAda.setDisplayFormat("dd/MM/yyyy");
            }
            this.tampil("");
            this.BtnBatalActionPerformed(evt);
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnBatalActionPerformed(final ActionEvent evt) {
        if (this.TNo.isEditable()) {
            this.emptTeks();
        }
        else if (!this.TNo.isEditable()) {
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
    
    private void BtnCloseInputActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.DlgInput.dispose();
    }
    
    private void BtnCloseInputKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.DlgInput.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnBatal, (JTextField)this.TNo);
        }
    }
    
    private void DTPAdaKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbAsl, this.CmbStts);
    }
    
    private void CmbAslKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.THrg, (JComboBox)this.DTPAda);
    }
    
    private void TKdKolKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNo, (JTextField)this.THrg);
    }
    
    private void TKdRKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbStts, this.CmbRak);
    }
    
    private void CmbSttsKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.DTPAda, (JTextField)this.TKdR);
    }
    
    private void CmbRakKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdR, this.CmbBox);
    }
    
    private void BtnPglPnbActionPerformed(final ActionEvent evt) {
        this.tampilKol("");
        this.DlgKoleksi.setLocationRelativeTo(null);
        this.DlgKoleksi.setVisible(true);
    }
    
    private void BtnPglPnbKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnb1ActionPerformed(final ActionEvent evt) {
        this.tampilRuang();
        this.DlgRuang.setLocationRelativeTo(null);
        this.DlgRuang.setVisible(true);
    }
    
    private void BtnPglPnb1KeyPressed(final KeyEvent evt) {
    }
    
    private void TCariKolKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariKolActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseKol, (JButton)this.BtnCariKol);
        }
    }
    
    private void BtnCariKolActionPerformed(final ActionEvent evt) {
        final String sql = " buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
        this.prosesCariKol("select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where " + sql + "and buku.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by buku.kode_buku");
    }
    
    private void BtnCariKolKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariKolActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariKol, (JButton)this.BtnAllKol);
        }
    }
    
    private void BtnCariKolKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllKolActionPerformed(final ActionEvent evt) {
        this.tampilKol("");
    }
    
    private void BtnAllKolKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllKolActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariKol, (JButton)this.BtnCloseKol);
        }
    }
    
    private void BtnCloseKolActionPerformed(final ActionEvent evt) {
        this.DlgKoleksi.dispose();
    }
    
    private void BtnCloseKolKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllKol, (JTextField)this.TCariKol);
    }
    
    private void tbKoleksiMouseClicked(final MouseEvent evt) {
        if (this.tabModeKol.getRowCount() != 0) {
            try {
                this.getDataKol();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbKoleksiKeyPressed(final KeyEvent evt) {
        if (this.tabModeKol.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataKol();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void TCariRuangKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariRuangActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseRuang, (JButton)this.BtnCariRuang);
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
    
    private void BtnCariRuangKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllRuangActionPerformed(final ActionEvent evt) {
        this.tampilRuang();
    }
    
    private void BtnAllRuangKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllRuangActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariRuang, (JButton)this.BtnCloseRuang);
        }
    }
    
    private void BtnCloseRuangActionPerformed(final ActionEvent evt) {
        this.DlgRuang.dispose();
    }
    
    private void BtnCloseRuangKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllRuang, (JTextField)this.TCariRuang);
    }
    
    private void tbRuangMouseClicked(final MouseEvent evt) {
        if (this.tabModeRuang.getRowCount() != 0) {
            try {
                this.getDataRuang();
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
                this.getDataRuang();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void CmbKtgCariItemStateChanged(final ItemEvent evt) {
        if (this.CmbJnsCari.getItemCount() > 0 && this.CmbKtgCari.getItemCount() > 0) {
            if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("");
            }
            else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                this.tampil("and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
            }
            else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                this.tampil("and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ");
            }
        }
    }
    
    private void TCariKeyTyped(final KeyEvent evt) {
        if (this.ChkCari.isSelected()) {
            this.ChkCari.setSelected(false);
            this.ChkCariActionPerformed(null);
        }
    }
    
    private void MnBarcodeActionPerformed(final ActionEvent evt) {
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
                this.Valid.MyReport("rptBarcode.jrxml", "report", "::[ Barcode Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori  and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                final String sql = " inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis ";
                this.Valid.MyReport("rptBarcode.jrxml", "report", "::[ Barcode Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where " + sql + "and Inventaris.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.jml_halaman like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.asal_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.tgl_pengadaan like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.harga like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.status_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Ruang.nm_ruang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_rak like '%" + this.TCari.getText().trim() + "%' or " + sql + "and Inventaris.no_box like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' " + " order by Inventaris.no_inventaris");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String key = "";
                if (this.CmbJnsCari.getItemCount() > 0 && this.CmbKtgCari.getItemCount() > 0) {
                    if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and kategori.nama_kategori='" + this.CmbKtgCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and jenis_buku.nama_jenis='" + this.CmbJnsCari.getSelectedItem().toString() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && this.ChkTglCari.isSelected() && !this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.tgl_pengadaan between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                    }
                    else if (!this.ChkKtgCari.isSelected() && !this.ChkJnsCari.isSelected() && !this.ChkTglCari.isSelected() && this.ChkSttsCari.isSelected()) {
                        key = "and Inventaris.status_buku='" + this.CmbSttsCari.getSelectedItem().toString() + "' ";
                    }
                }
                this.Valid.MyReport("rptBarcode.jrxml", "report", "::[ Barcode Inventaris ]::", "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori " + key + " and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris");
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgInventaris dialog = new DlgInventaris(new JFrame(), true);
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
        final String sql = "SELECT Inventaris.no_inventaris, Inventaris.kode_buku, buku.judul_buku, buku.jml_halaman, penerbit.nama_penerbit, pengarang.nama_pengarang, buku.thn_terbit, buku.isbn, kategori.nama_kategori, jenis_buku.nama_jenis, Inventaris.asal_buku, Inventaris.tgl_pengadaan, Inventaris.harga, Inventaris.status_buku, Ruang.nm_ruang, Inventaris.no_rak, Inventaris.no_box from inventaris,buku,ruang,pengarang,penerbit,kategori,jenis_buku where inventaris.kode_buku=buku.kode_buku and inventaris.kd_ruang=ruang.kd_ruang and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori " + key + " and buku.id_jenis=jenis_buku.id_jenis order by Inventaris.no_inventaris";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            double a = 0.0;
            while (rs.next()) {
                a += rs.getDouble(13);
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7).substring(0, 4), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) };
                this.tabMode.addRow(data);
            }
            this.LCount1.setText(this.df2.format(a));
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabMode.getRowCount();
        this.LCount.setText("" + b);
    }
    
    public void emptTeks() {
        this.TKdKol.setText("");
        this.THrg.setText("");
        this.CmbAsl.setSelectedIndex(0);
        this.CmbStts.setSelectedIndex(0);
        this.DTPAda.setDate(new Date());
        this.CmbRak.setSelectedIndex(0);
        this.CmbBox.setSelectedIndex(0);
        this.TKdR.setText("");
        this.TNo.requestFocus();
        this.Valid.autoNomer(this.tabMode, "I", 9, (JTextField)this.TNo);
    }
    
    public void focus() {
        this.TCari.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbInventaris.getSelectedRow();
        if (row != -1) {
            this.TNo.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TKdKol.setText(this.tabMode.getValueAt(row, 1).toString());
            this.CmbAsl.setSelectedItem(this.tabMode.getValueAt(row, 10).toString());
            try {
                this.DTPAda.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabMode.getValueAt(row, 11).toString());
                this.DTPAda.setDate(dtpa);
                this.DTPAda.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgAnggota.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.THrg.setText(this.tabMode.getValueAt(row, 12).toString());
            this.CmbStts.setSelectedItem(this.tabMode.getValueAt(row, 13).toString());
            this.Sequel.cariIsi("select kd_ruang from ruang where nm_ruang='" + this.tabMode.getValueAt(row, 14).toString() + "'", (JTextField)this.TKdR);
            this.CmbRak.setSelectedItem(this.tabMode.getValueAt(row, 15).toString());
            this.CmbBox.setSelectedItem(this.tabMode.getValueAt(row, 16).toString());
        }
    }
    
    private void isKol() {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery("select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and buku.kode_buku='" + this.TKdKol.getText() + "' order by buku.kode_buku");
            if (rs.next()) {
                this.TJdl.setText(rs.getString(2));
                this.TPnb.setText(rs.getString(4));
                this.TPng.setText(rs.getString(5));
                this.TKtg.setText(rs.getString(8));
                this.TJns.setText(rs.getString(9));
            }
            else {
                this.TJdl.setText("");
                this.TPnb.setText("");
                this.TPng.setText("");
                this.TKtg.setText("");
                this.TJns.setText("");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void isRuang() {
        this.Sequel.cariIsi("select nm_ruang from ruang where kd_ruang='" + this.TKdR.getText() + "'", (JTextField)this.TNmR);
    }
    
    public void tampilKol(final String key) {
        final String sql = "select buku.kode_buku,buku.judul_buku,buku.jml_halaman, penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis from buku,penerbit, pengarang,kategori,jenis_buku where buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis " + key + " order by buku.kode_buku";
        this.prosesCariKol(sql);
    }
    
    private void prosesCariKol(final String sql) {
        this.Valid.tabelKosong(this.tabModeKol);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6).substring(0, 4), rs.getString(7), rs.getString(8), rs.getString(9) };
                this.tabModeKol.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void getDataKol() {
        final int row = this.tbKoleksi.getSelectedRow();
        if (row != -1) {
            this.TKdKol.setText(this.tabModeKol.getValueAt(row, 0).toString());
            this.TJdl.setText(this.tabModeKol.getValueAt(row, 1).toString());
            this.TPnb.setText(this.tabModeKol.getValueAt(row, 3).toString());
            this.TPng.setText(this.tabModeKol.getValueAt(row, 4).toString());
            this.TKtg.setText(this.tabModeKol.getValueAt(row, 7).toString());
            this.TJns.setText(this.tabModeKol.getValueAt(row, 8).toString());
        }
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
    
    private void getDataRuang() {
        final int row = this.tbRuang.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModeRuang.getValueAt(row, 0).toString();
            final String nama = this.tabModeRuang.getValueAt(row, 1).toString();
            this.TKdR.setText(kode);
            this.TNmR.setText(nama);
        }
    }
    
    public void LoadCombo() {
        this.Valid.loadCombo(this.CmbKtgCari, "nama_kategori", "kategori");
        this.Valid.loadCombo(this.CmbJnsCari, "nama_jenis", "jenis_buku");
    }
}
