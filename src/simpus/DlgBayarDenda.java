package simpus;

import uz.ncipro.calendar.*;
import usu.widget.Button;
import usu.widget.Label;
import usu.widget.Panel;
import usu.widget.glass.*;
import widget.*;
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

public class DlgBayarDenda extends JDialog
{
    private DefaultTableModel tabModeByrDenda;
    private DefaultTableModel tabModeDendaLain;
    private DefaultTableModel tabModeAnggota;
    private DefaultTableModel tabModeInventaris;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    DecimalFormat df2;
    double jmlHari;
    double setdenda;
    double dendaHari;
    private Button BtnAll;
    private Button BtnAllAgt;
    private Button BtnAllIn;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnCariAgt;
    private Button BtnCariIn;
    private Button BtnCloseAgt;
    private Button BtnCloseIn;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPglPnb4;
    private Button BtnPglPnb5;
    private Button BtnPrint;
    private Button BtnSimpan;
    private ComboBox CmbJnsDnda;
    private JDateTimePicker DTPBayar;
    private JDialog DlgCariAnggota;
    private JDialog DlgCariIn;
    private Label LCount;
    private Label LDenda;
    private TextBox TCari;
    private TextBox TCariAgt;
    private TextBox TCariIn;
    private JTextField TDenda;
    private TextBox TDendaHari;
    private TextBox TDendaLain;
    private TextBox THari;
    private TextBox THrgI;
    private TextBox TKtg;
    private TextBox TNmA;
    private TextBox TNmDnda;
    private TextBox TNmI;
    private TextBox TNoA;
    private TextBox TNoI;
    private TextBox TPrsn;
    private JTabbedPane TabBayar;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private InternalFrame internalFrame4;
    private InternalFrame internalFrame5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSeparator jSeparator1;
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
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelGlass panelGlass3;
    private PanelGlass panelGlass4;
    private PanelGlass panelGlass5;
    private PanelGlass panelGlass6;
    private PanelGlass panelGlass7;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private ScrollPane scrollPane3;
    private ScrollPane scrollPane4;
    private Table tbAnggota;
    private Table tbBayarDenda;
    private Table tbDendaLain;
    private Table tbInventaris;
    
    public DlgBayarDenda(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.df2 = new DecimalFormat("###,###,###,###,###,###,###");
        this.jmlHari = 0.0;
        this.setdenda = 0.0;
        this.dendaHari = 0.0;
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(500, 585);
        final Object[] rowByrDenda = { "<html><font color='#006699' face='Comic Sans MS'>Tgl.Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keterlambatan(Hari)</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Denda(Rp)</font></html>" };
        this.tabModeByrDenda = new DefaultTableModel((Object[][])null, rowByrDenda) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbBayarDenda.setModel(this.tabModeByrDenda);
        this.koneksi.panggilDriver();
        this.tbBayarDenda.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbBayarDenda.setAutoResizeMode(0);
        for (int i = 0; i < 7; ++i) {
            final TableColumn column = this.tbBayarDenda.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(100);
            }
            else if (i == 2) {
                column.setPreferredWidth(250);
            }
            else if (i == 3) {
                column.setPreferredWidth(150);
            }
            else if (i == 4) {
                column.setPreferredWidth(250);
            }
            else if (i == 5) {
                column.setPreferredWidth(150);
            }
            else if (i == 6) {
                column.setPreferredWidth(150);
            }
        }
        this.tbBayarDenda.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowDendaLain = { "<html><font color='#006699' face='Comic Sans MS'>Tgl.Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Besar Denda(Rp)</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keterangan</font></html>" };
        this.tabModeDendaLain = new DefaultTableModel((Object[][])null, rowDendaLain) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbDendaLain.setModel(this.tabModeDendaLain);
        this.tbDendaLain.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbDendaLain.setAutoResizeMode(0);
        for (int j = 0; j < 8; ++j) {
            final TableColumn column2 = this.tbDendaLain.getColumnModel().getColumn(j);
            if (j == 0) {
                column2.setPreferredWidth(100);
            }
            else if (j == 1) {
                column2.setPreferredWidth(100);
            }
            else if (j == 2) {
                column2.setPreferredWidth(250);
            }
            else if (j == 3) {
                column2.setPreferredWidth(150);
            }
            else if (j == 4) {
                column2.setPreferredWidth(250);
            }
            else if (j == 5) {
                column2.setPreferredWidth(150);
            }
            else if (j == 6) {
                column2.setPreferredWidth(150);
            }
            else if (j == 7) {
                column2.setPreferredWidth(250);
            }
        }
        this.tbDendaLain.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowAnggota = { "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Bergabung</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keanggotaan Habis</font></html>" };
        this.tabModeAnggota = new DefaultTableModel((Object[][])null, rowAnggota) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbAnggota.setModel(this.tabModeAnggota);
        this.tbAnggota.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbAnggota.setAutoResizeMode(0);
        for (int k = 0; k < 10; ++k) {
            final TableColumn column3 = this.tbAnggota.getColumnModel().getColumn(k);
            if (k == 0) {
                column3.setPreferredWidth(100);
            }
            else if (k == 1) {
                column3.setPreferredWidth(260);
            }
            else if (k == 2) {
                column3.setPreferredWidth(150);
            }
            else if (k == 3) {
                column3.setPreferredWidth(120);
            }
            else if (k == 4) {
                column3.setPreferredWidth(50);
            }
            else if (k == 5) {
                column3.setPreferredWidth(350);
            }
            else if (k == 6) {
                column3.setPreferredWidth(110);
            }
            else if (k == 7) {
                column3.setPreferredWidth(180);
            }
            else if (k == 8) {
                column3.setPreferredWidth(110);
            }
            else if (k == 9) {
                column3.setPreferredWidth(130);
            }
        }
        this.tbAnggota.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowIn = { "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Terbit</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nomer ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Asal Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Pengadaan</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Harga</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Stts.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Ruang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Rak</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Box</font></html>" };
        this.tabModeInventaris = new DefaultTableModel((Object[][])null, rowIn) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbInventaris.setModel(this.tabModeInventaris);
        this.tbInventaris.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbInventaris.setAutoResizeMode(0);
        for (int l = 0; l < 17; ++l) {
            final TableColumn column4 = this.tbInventaris.getColumnModel().getColumn(l);
            if (l == 0) {
                column4.setPreferredWidth(100);
            }
            else if (l == 1) {
                column4.setPreferredWidth(100);
            }
            else if (l == 2) {
                column4.setPreferredWidth(350);
            }
            else if (l == 3) {
                column4.setPreferredWidth(60);
            }
            else if (l == 4) {
                column4.setPreferredWidth(200);
            }
            else if (l == 5) {
                column4.setPreferredWidth(200);
            }
            else if (l == 6) {
                column4.setPreferredWidth(70);
            }
            else if (l == 7) {
                column4.setPreferredWidth(150);
            }
            else if (l == 8) {
                column4.setPreferredWidth(160);
            }
            else if (l == 9) {
                column4.setPreferredWidth(100);
            }
            else if (l == 10) {
                column4.setPreferredWidth(150);
            }
            else if (l == 11) {
                column4.setPreferredWidth(100);
            }
            else if (l == 12) {
                column4.setPreferredWidth(100);
            }
            else if (l == 13) {
                column4.setPreferredWidth(100);
            }
            else if (l == 14) {
                column4.setPreferredWidth(150);
            }
            else if (l == 15) {
                column4.setPreferredWidth(60);
            }
            else if (l == 16) {
                column4.setPreferredWidth(60);
            }
        }
        this.tbInventaris.setDefaultRenderer(Object.class, new WarnaTable());
        this.TCariIn.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariIn));
        this.TCariAgt.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariAgt));
        this.TNoA.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNoA));
        this.TNoI.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TNoI));
        this.THari.setDocument((Document)new batasInput(10).getOnlyAngka((JTextField)this.THari));
        this.TDendaHari.setDocument((Document)new batasInput(20).getOnlyAngka((JTextField)this.TDendaHari));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.TNoA.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isAnggota();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isAnggota();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isAnggota();
            }
        });
        this.TNoI.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isIn();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isIn();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isIn();
            }
        });
        this.THari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isHarian();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isHarian();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isHarian();
            }
        });
        this.THrgI.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
        });
        this.TPrsn.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgBayarDenda.this.isLain();
            }
        });
        this.DlgCariAnggota.setSize(500, 519);
        this.DlgCariAnggota.setVisible(false);
        this.DlgCariIn.setSize(500, 519);
        this.DlgCariIn.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgCariAnggota = new JDialog();
        this.internalFrame2 = new InternalFrame();
        this.panelGlass6 = new PanelGlass();
        this.label7 = new Label();
        this.TCariAgt = new TextBox();
        this.BtnCariAgt = new Button();
        this.BtnAllAgt = new Button();
        this.label16 = new Label();
        this.BtnCloseAgt = new Button();
        this.scrollPane3 = new ScrollPane();
        this.tbAnggota = new Table();
        this.DlgCariIn = new JDialog();
        this.internalFrame5 = new InternalFrame();
        this.panelGlass7 = new PanelGlass();
        this.label17 = new Label();
        this.TCariIn = new TextBox();
        this.BtnCariIn = new Button();
        this.BtnAllIn = new Button();
        this.label18 = new Label();
        this.BtnCloseIn = new Button();
        this.scrollPane4 = new ScrollPane();
        this.tbInventaris = new Table();
        this.TDenda = new JTextField();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.DTPBayar = new JDateTimePicker();
        this.label2 = new Label();
        this.TNmI = new TextBox();
        this.label3 = new Label();
        this.TNmA = new TextBox();
        this.BtnPglPnb4 = new Button();
        this.label4 = new Label();
        this.TNoA = new TextBox();
        this.THrgI = new TextBox();
        this.TNoI = new TextBox();
        this.BtnPglPnb5 = new Button();
        this.jPanel1 = new JPanel();
        this.panelGlass3 = new PanelGlass();
        this.label5 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.BtnAll = new Button();
        this.label6 = new Label();
        this.LCount = new Label();
        this.LDenda = new Label();
        this.label19 = new Label();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnHapus = new Button();
        this.BtnPrint = new Button();
        this.BtnKeluar = new Button();
        this.jPanel2 = new JPanel();
        this.TabBayar = new JTabbedPane();
        this.internalFrame4 = new InternalFrame();
        this.scrollPane2 = new ScrollPane();
        this.tbBayarDenda = new Table();
        this.panelGlass5 = new PanelGlass();
        this.label12 = new Label();
        this.TDendaHari = new TextBox();
        this.THari = new TextBox();
        this.label13 = new Label();
        this.label14 = new Label();
        this.internalFrame3 = new InternalFrame();
        this.scrollPane1 = new ScrollPane();
        this.tbDendaLain = new Table();
        this.panelGlass4 = new PanelGlass();
        this.TNmDnda = new TextBox();
        this.label8 = new Label();
        this.label9 = new Label();
        this.TKtg = new TextBox();
        this.CmbJnsDnda = new ComboBox();
        this.label10 = new Label();
        this.TPrsn = new TextBox();
        this.TDendaLain = new TextBox();
        this.label11 = new Label();
        this.label15 = new Label();
        this.DlgCariAnggota.setModal(true);
        this.DlgCariAnggota.setName("DlgCariAnggota");
        this.DlgCariAnggota.setResizable(false);
        this.DlgCariAnggota.setUndecorated(true);
        this.internalFrame2.setName("internalFrame2");
        this.internalFrame2.setLayout(new BorderLayout(1, 1));
        this.panelGlass6.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass6.setOpaqueImage(false);
        this.panelGlass6.setPreferredSize(new Dimension(40, 44));
        this.panelGlass6.setRound(false);
        this.panelGlass6.setWarna(new Color(90, 0, 90));
        this.panelGlass6.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label7.setHorizontalAlignment(4);
        this.label7.setText("Key Word :");
        this.label7.setName("label7");
        this.label7.setPreferredSize(new Dimension(63, 23));
        this.panelGlass6.add((Component)this.label7);
        this.TCariAgt.setName("TCariAgt");
        this.TCariAgt.setPreferredSize(new Dimension(278, 23));
        this.TCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TCariAgtKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.TCariAgt);
        this.BtnCariAgt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariAgt.setMnemonic('2');
        this.BtnCariAgt.setToolTipText("Alt+2");
        this.BtnCariAgt.setCursor(new Cursor(12));
        this.BtnCariAgt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariAgt.setName("BtnCariAgt");
        this.BtnCariAgt.setPreferredSize(new Dimension(26, 23));
        this.BtnCariAgt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnCariAgtActionPerformed(evt);
            }
        });
        this.BtnCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCariAgtKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCariAgtKeyReleased(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnCariAgt);
        this.BtnAllAgt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllAgt.setMnemonic('1');
        this.BtnAllAgt.setToolTipText("Alt+1");
        this.BtnAllAgt.setCursor(new Cursor(12));
        this.BtnAllAgt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllAgt.setName("BtnAllAgt");
        this.BtnAllAgt.setPreferredSize(new Dimension(26, 23));
        this.BtnAllAgt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnAllAgtActionPerformed(evt);
            }
        });
        this.BtnAllAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnAllAgtKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnAllAgt);
        this.label16.setHorizontalAlignment(4);
        this.label16.setName("label16");
        this.label16.setPreferredSize(new Dimension(33, 23));
        this.panelGlass6.add((Component)this.label16);
        this.BtnCloseAgt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseAgt.setMnemonic('3');
        this.BtnCloseAgt.setToolTipText("Alt+3");
        this.BtnCloseAgt.setCursor(new Cursor(12));
        this.BtnCloseAgt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseAgt.setName("BtnCloseAgt");
        this.BtnCloseAgt.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseAgt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnCloseAgtActionPerformed(evt);
            }
        });
        this.BtnCloseAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCloseAgtKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnCloseAgt);
        this.internalFrame2.add((Component)this.panelGlass6, "First");
        this.scrollPane3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane3.setName("scrollPane3");
        this.tbAnggota.setAutoCreateRowSorter(true);
        this.tbAnggota.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbAnggota.setName("tbAnggota");
        this.tbAnggota.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgBayarDenda.this.tbAnggotaMouseClicked(evt);
            }
        });
        this.tbAnggota.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.tbAnggotaKeyPressed(evt);
            }
        });
        this.scrollPane3.setViewportView(this.tbAnggota);
        this.internalFrame2.add(this.scrollPane3, "Center");
        this.DlgCariAnggota.getContentPane().add(this.internalFrame2, "Center");
        this.DlgCariIn.setModal(true);
        this.DlgCariIn.setName("DlgCariIn");
        this.DlgCariIn.setResizable(false);
        this.DlgCariIn.setUndecorated(true);
        this.internalFrame5.setName("internalFrame5");
        this.internalFrame5.setLayout(new BorderLayout(1, 1));
        this.panelGlass7.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass7.setOpaqueImage(false);
        this.panelGlass7.setPreferredSize(new Dimension(40, 44));
        this.panelGlass7.setRound(false);
        this.panelGlass7.setWarna(new Color(90, 0, 90));
        this.panelGlass7.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label17.setHorizontalAlignment(4);
        this.label17.setText("Key Word :");
        this.label17.setName("label17");
        this.label17.setPreferredSize(new Dimension(63, 23));
        this.panelGlass7.add((Component)this.label17);
        this.TCariIn.setName("TCariIn");
        this.TCariIn.setPreferredSize(new Dimension(278, 23));
        this.TCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TCariInKeyPressed(evt);
            }
        });
        this.panelGlass7.add((Component)this.TCariIn);
        this.BtnCariIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariIn.setMnemonic('2');
        this.BtnCariIn.setToolTipText("Alt+2");
        this.BtnCariIn.setCursor(new Cursor(12));
        this.BtnCariIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariIn.setName("BtnCariIn");
        this.BtnCariIn.setPreferredSize(new Dimension(26, 23));
        this.BtnCariIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnCariInActionPerformed(evt);
            }
        });
        this.BtnCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCariInKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCariInKeyReleased(evt);
            }
        });
        this.panelGlass7.add((Component)this.BtnCariIn);
        this.BtnAllIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllIn.setMnemonic('1');
        this.BtnAllIn.setToolTipText("Alt+1");
        this.BtnAllIn.setCursor(new Cursor(12));
        this.BtnAllIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllIn.setName("BtnAllIn");
        this.BtnAllIn.setPreferredSize(new Dimension(26, 23));
        this.BtnAllIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnAllInActionPerformed(evt);
            }
        });
        this.BtnAllIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnAllInKeyPressed(evt);
            }
        });
        this.panelGlass7.add((Component)this.BtnAllIn);
        this.label18.setHorizontalAlignment(4);
        this.label18.setName("label18");
        this.label18.setPreferredSize(new Dimension(33, 23));
        this.panelGlass7.add((Component)this.label18);
        this.BtnCloseIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseIn.setMnemonic('3');
        this.BtnCloseIn.setToolTipText("Alt+3");
        this.BtnCloseIn.setCursor(new Cursor(12));
        this.BtnCloseIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseIn.setName("BtnCloseIn");
        this.BtnCloseIn.setPreferredSize(new Dimension(26, 23));
        this.BtnCloseIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnCloseInActionPerformed(evt);
            }
        });
        this.BtnCloseIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCloseInKeyPressed(evt);
            }
        });
        this.panelGlass7.add((Component)this.BtnCloseIn);
        this.internalFrame5.add((Component)this.panelGlass7, "First");
        this.scrollPane4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane4.setName("scrollPane4");
        this.tbInventaris.setAutoCreateRowSorter(true);
        this.tbInventaris.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbInventaris.setName("tbInventaris");
        this.tbInventaris.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgBayarDenda.this.tbInventarisMouseClicked(evt);
            }
        });
        this.tbInventaris.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.tbInventarisKeyPressed(evt);
            }
        });
        this.scrollPane4.setViewportView(this.tbInventaris);
        this.internalFrame5.add(this.scrollPane4, "Center");
        this.DlgCariIn.getContentPane().add(this.internalFrame5, "Center");
        this.TDenda.setEditable(false);
        this.TDenda.setText("0");
        this.TDenda.setName("TDenda");
        this.setDefaultCloseOperation(2);
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
        this.jLabel1.setText(":: BAYAR DENDA ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(125, 10, 250, 20);
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2);
        this.jLabel2.setBounds(5, 0, 40, 40);
        this.getContentPane().add(this.panelJudul1, "First");
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
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(105, 79));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.DTPBayar.setBackground(new Color(90, 0, 90));
        this.DTPBayar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPBayar.setEditable(false);
        this.DTPBayar.setForeground(new Color(205, 214, 255));
        this.DTPBayar.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "26/09/2010" }));
        this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
        this.DTPBayar.setName("DTPBayar");
        this.DTPBayar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.DTPBayarKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.DTPBayar);
        this.DTPBayar.setBounds(66, 10, 85, 23);
        this.label2.setText("Peminjam :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(162, 10, 60, 23);
        this.TNmI.setEditable(false);
        this.TNmI.setName("TNmI");
        this.panelGlass1.add((Component)this.TNmI);
        this.TNmI.setBounds(162, 40, 210, 23);
        this.label3.setText("Tgl.Denda :");
        this.label3.setName("label3");
        this.panelGlass1.add((Component)this.label3);
        this.label3.setBounds(8, 10, 70, 23);
        this.TNmA.setEditable(false);
        this.TNmA.setName("TNmA");
        this.panelGlass1.add((Component)this.TNmA);
        this.TNmA.setBounds(312, 10, 152, 23);
        this.BtnPglPnb4.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb4.setMnemonic('4');
        this.BtnPglPnb4.setToolTipText("Alt+4");
        this.BtnPglPnb4.setCursor(new Cursor(12));
        this.BtnPglPnb4.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb4.setName("BtnPglPnb4");
        this.BtnPglPnb4.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb4.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnPglPnb4ActionPerformed(evt);
            }
        });
        this.BtnPglPnb4.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnPglPnb4KeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.BtnPglPnb4);
        this.BtnPglPnb4.setBounds(465, 40, 25, 23);
        this.label4.setText("No.Invent :");
        this.label4.setName("label4");
        this.panelGlass1.add((Component)this.label4);
        this.label4.setBounds(8, 40, 70, 23);
        this.TNoA.setName("TNoA");
        this.TNoA.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TNoAKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNoA);
        this.TNoA.setBounds(216, 10, 95, 23);
        this.THrgI.setEditable(false);
        this.THrgI.setText("0");
        this.THrgI.setName("THrgI");
        this.panelGlass1.add((Component)this.THrgI);
        this.THrgI.setBounds(373, 40, 91, 23);
        this.TNoI.setName("TNoI");
        this.TNoI.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TNoIKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNoI);
        this.TNoI.setBounds(66, 40, 95, 23);
        this.BtnPglPnb5.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb5.setMnemonic('3');
        this.BtnPglPnb5.setToolTipText("Alt+3");
        this.BtnPglPnb5.setCursor(new Cursor(12));
        this.BtnPglPnb5.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb5.setName("BtnPglPnb5");
        this.BtnPglPnb5.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb5.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnPglPnb5ActionPerformed(evt);
            }
        });
        this.BtnPglPnb5.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnPglPnb5KeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.BtnPglPnb5);
        this.BtnPglPnb5.setBounds(465, 10, 25, 23);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
        this.jPanel1.setBackground(new Color(90, 0, 90));
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
        this.label5.setText("Key Word :");
        this.label5.setName("label5");
        this.panelGlass3.add((Component)this.label5);
        this.label5.setBounds(15, 15, 80, 14);
        this.TCari.setName("TCari");
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TCariKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCari);
        this.TCari.setBounds(72, 10, 207, 23);
        this.BtnCari.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCari.setMnemonic('2');
        this.BtnCari.setToolTipText("Alt+2");
        this.BtnCari.setCursor(new Cursor(12));
        this.BtnCari.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCari.setName("BtnCari");
        this.BtnCari.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnCariKeyPressed(evt);
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
                DlgBayarDenda.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnAllKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAll);
        this.BtnAll.setBounds(310, 10, 28, 23);
        this.label6.setText("Record :");
        this.label6.setName("label6");
        this.panelGlass3.add((Component)this.label6);
        this.label6.setBounds(355, 3, 50, 20);
        this.LCount.setText("0");
        this.LCount.setName("LCount");
        this.panelGlass3.add((Component)this.LCount);
        this.LCount.setBounds(400, 3, 90, 20);
        this.LDenda.setText("0");
        this.LDenda.setName("LDenda");
        this.panelGlass3.add((Component)this.LDenda);
        this.LDenda.setBounds(400, 18, 90, 20);
        this.label19.setText("Ttl.Dnd :");
        this.label19.setName("label19");
        this.panelGlass3.add((Component)this.label19);
        this.label19.setBounds(354, 18, 50, 20);
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
                DlgBayarDenda.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnSimpanKeyPressed(evt);
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
                DlgBayarDenda.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnBatalKeyPressed(evt);
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
                DlgBayarDenda.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnHapusKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnHapus);
        this.BtnHapus.setBounds(182, 10, 86, 30);
        this.BtnPrint.setMnemonic('E');
        this.BtnPrint.setText("Print");
        this.BtnPrint.setToolTipText("Alt+E");
        this.BtnPrint.setCursor(new Cursor(12));
        this.BtnPrint.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPrint.setName("BtnPrint");
        this.BtnPrint.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnPrintKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnPrint);
        this.BtnPrint.setBounds(270, 10, 86, 30);
        this.BtnKeluar.setMnemonic('K');
        this.BtnKeluar.setText("Keluar");
        this.BtnKeluar.setToolTipText("Alt+K");
        this.BtnKeluar.setCursor(new Cursor(12));
        this.BtnKeluar.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnKeluar.setName("BtnKeluar");
        this.BtnKeluar.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgBayarDenda.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluar);
        this.BtnKeluar.setBounds(406, 10, 86, 30);
        this.jPanel1.add((Component)this.panelGlass2, "Center");
        this.internalFrame1.add(this.jPanel1, "Last");
        this.jPanel2.setBackground(new Color(90, 0, 90));
        this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.jPanel2.setName("jPanel2");
        this.jPanel2.setOpaque(false);
        this.jPanel2.setLayout(null);
        this.TabBayar.setBackground(new Color(90, 0, 90));
        this.TabBayar.setForeground(new Color(102, 102, 0));
        this.TabBayar.setTabLayoutPolicy(1);
        this.TabBayar.setName("TabBayar");
        this.TabBayar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgBayarDenda.this.TabBayarMouseClicked(evt);
            }
        });
        this.internalFrame4.setBorder(null);
        this.internalFrame4.setName("internalFrame4");
        this.internalFrame4.setLayout(new BorderLayout(1, 1));
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane2.setName("scrollPane2");
        this.scrollPane2.setPreferredSize(new Dimension(452, 302));
        this.tbBayarDenda.setAutoCreateRowSorter(true);
        this.tbBayarDenda.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbBayarDenda.setName("tbBayarDenda");
        this.tbBayarDenda.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgBayarDenda.this.tbBayarDendaMouseClicked(evt);
            }
        });
        this.tbBayarDenda.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.tbBayarDendaKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.tbBayarDenda);
        this.internalFrame4.add(this.scrollPane2, "Center");
        this.panelGlass5.setOpaqueImage(false);
        this.panelGlass5.setPreferredSize(new Dimension(105, 42));
        this.panelGlass5.setRound(false);
        this.panelGlass5.setWarna(new Color(90, 0, 90));
        this.panelGlass5.setLayout((LayoutManager)null);
        this.label12.setText("Hari");
        this.label12.setName("label12");
        this.panelGlass5.add((Component)this.label12);
        this.label12.setBounds(176, 8, 70, 23);
        this.TDendaHari.setEditable(false);
        this.TDendaHari.setText("0");
        this.TDendaHari.setName("TDendaHari");
        this.panelGlass5.add((Component)this.TDendaHari);
        this.TDendaHari.setBounds(320, 8, 170, 23);
        this.THari.setText("0");
        this.THari.setName("THari");
        this.THari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.THariKeyPressed(evt);
            }
        });
        this.panelGlass5.add((Component)this.THari);
        this.THari.setBounds(87, 8, 85, 23);
        this.label13.setText("Denda : Rp. ");
        this.label13.setName("label13");
        this.panelGlass5.add((Component)this.label13);
        this.label13.setBounds(260, 8, 90, 23);
        this.label14.setText("Keterlambatan :");
        this.label14.setName("label14");
        this.panelGlass5.add((Component)this.label14);
        this.label14.setBounds(8, 8, 90, 23);
        this.internalFrame4.add((Component)this.panelGlass5, "First");
        this.TabBayar.addTab(".: Denda Keterlambatan :.", this.internalFrame4);
        this.internalFrame3.setBorder(null);
        this.internalFrame3.setName("internalFrame3");
        this.internalFrame3.setLayout(new BorderLayout(1, 1));
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane1.setName("scrollPane1");
        this.scrollPane1.setPreferredSize(new Dimension(452, 302));
        this.tbDendaLain.setAutoCreateRowSorter(true);
        this.tbDendaLain.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbDendaLain.setName("tbDendaLain");
        this.tbDendaLain.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgBayarDenda.this.tbDendaLainMouseClicked(evt);
            }
        });
        this.tbDendaLain.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.tbDendaLainKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbDendaLain);
        this.internalFrame3.add(this.scrollPane1, "Center");
        this.panelGlass4.setOpaqueImage(false);
        this.panelGlass4.setPreferredSize(new Dimension(105, 71));
        this.panelGlass4.setRound(false);
        this.panelGlass4.setWarna(new Color(90, 0, 90));
        this.panelGlass4.setLayout((LayoutManager)null);
        this.TNmDnda.setEditable(false);
        this.TNmDnda.setName("TNmDnda");
        this.panelGlass4.add((Component)this.TNmDnda);
        this.TNmDnda.setBounds(143, 8, 150, 23);
        this.label8.setText("% dr hrga brng");
        this.label8.setName("label8");
        this.panelGlass4.add((Component)this.label8);
        this.label8.setBounds(412, 8, 90, 23);
        this.label9.setText("Keterangan :");
        this.label9.setName("label9");
        this.panelGlass4.add((Component)this.label9);
        this.label9.setBounds(10, 38, 70, 23);
        this.TKtg.setName("TKtg");
        this.TKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.TKtgKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.TKtg);
        this.TKtg.setBounds(76, 38, 217, 23);
        this.CmbJnsDnda.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.CmbJnsDnda.setName("CmbJnsDnda");
        this.CmbJnsDnda.setPreferredSize(new Dimension(150, 23));
        this.CmbJnsDnda.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgBayarDenda.this.CmbJnsDndaItemStateChanged(evt);
            }
        });
        this.CmbJnsDnda.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgBayarDenda.this.CmbJnsDndaKeyPressed(evt);
            }
        });
        this.panelGlass4.add((Component)this.CmbJnsDnda);
        this.CmbJnsDnda.setBounds(76, 8, 65, 23);
        this.label10.setText("Jenis Denda :");
        this.label10.setName("label10");
        this.panelGlass4.add((Component)this.label10);
        this.label10.setBounds(8, 8, 70, 23);
        this.TPrsn.setEditable(false);
        this.TPrsn.setText("0");
        this.TPrsn.setName("TPrsn");
        this.panelGlass4.add((Component)this.TPrsn);
        this.TPrsn.setBounds(369, 8, 40, 23);
        this.TDendaLain.setEditable(false);
        this.TDendaLain.setText("0");
        this.TDendaLain.setName("TDendaLain");
        this.panelGlass4.add((Component)this.TDendaLain);
        this.TDendaLain.setBounds(369, 38, 120, 23);
        this.label11.setText("Rp :");
        this.label11.setName("label11");
        this.panelGlass4.add((Component)this.label11);
        this.label11.setBounds(347, 38, 30, 23);
        this.label15.setText("Bsr.Denda :");
        this.label15.setName("label15");
        this.panelGlass4.add((Component)this.label15);
        this.label15.setBounds(310, 8, 70, 23);
        this.internalFrame3.add((Component)this.panelGlass4, "First");
        this.TabBayar.addTab(".: Denda Lain-lain :.", this.internalFrame3);
        this.jPanel2.add(this.TabBayar);
        this.TabBayar.setBounds(-2, 1, 503, 339);
        this.internalFrame1.add(this.jPanel2, "Center");
        this.getContentPane().add(this.internalFrame1, "Center");
        this.pack();
    }
    
    private void DTPBayarKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TCari, (JTextField)this.TNoA);
    }
    
    private void BtnPglPnb4ActionPerformed(final ActionEvent evt) {
        this.tampilIn("");
        this.DlgCariIn.setLocationRelativeTo(this.internalFrame1);
        this.DlgCariIn.setVisible(true);
    }
    
    private void BtnPglPnb4KeyPressed(final KeyEvent evt) {
    }
    
    private void TNoAKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.DTPBayar, (JTextField)this.TNoI);
    }
    
    private void TNoIKeyPressed(final KeyEvent evt) {
        if (this.TabBayar.getSelectedIndex() == 0) {
            this.Valid.pindah(evt, (JTextField)this.TNoA, (JTextField)this.THari);
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            this.Valid.pindah(evt, (JTextField)this.TNoA, this.CmbJnsDnda);
        }
    }
    
    private void BtnPglPnb5ActionPerformed(final ActionEvent evt) {
        this.tampilAnggota("");
        this.DlgCariAnggota.setLocationRelativeTo(this.internalFrame1);
        this.DlgCariAnggota.setVisible(true);
    }
    
    private void BtnPglPnb5KeyPressed(final KeyEvent evt) {
    }
    
    private void TCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCari);
        }
    }
    
    private void TKtgKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbJnsDnda, (JButton)this.BtnSimpan);
    }
    
    private void THariKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNoI, (JButton)this.BtnSimpan);
    }
    
    private void CmbJnsDndaItemStateChanged(final ItemEvent evt) {
        if (this.CmbJnsDnda.getItemCount() > 0) {
            this.Sequel.cariIsi("select jenis_denda from denda where kode_denda='" + this.CmbJnsDnda.getSelectedItem().toString() + "'", (JTextField)this.TNmDnda);
            this.Sequel.cariIsi("select besar_denda from denda where kode_denda='" + this.CmbJnsDnda.getSelectedItem().toString() + "'", (JTextField)this.TPrsn);
        }
    }
    
    private void tbBayarDendaKeyPressed(final KeyEvent evt) {
        if (this.tabModeByrDenda.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataByrDenda();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbBayarDendaMouseClicked(final MouseEvent evt) {
        if (this.tabModeByrDenda.getRowCount() != 0) {
            try {
                this.getDataByrDenda();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void TCariAgtKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariAgtActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseAgt, (JButton)this.BtnCariAgt);
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
            this.Valid.pindah(evt, (JButton)this.BtnCariAgt, (JButton)this.BtnCloseAgt);
        }
    }
    
    private void BtnCloseAgtActionPerformed(final ActionEvent evt) {
        this.DlgCariAnggota.dispose();
    }
    
    private void BtnCloseAgtKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllAgt, (JTextField)this.TCariAgt);
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
    
    private void BtnKeluarActionPerformed(final ActionEvent evt) {
        this.dispose();
    }
    
    private void TCariInKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariInActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseIn, (JButton)this.BtnCariIn);
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
            this.Valid.pindah(evt, (JButton)this.BtnCariIn, (JButton)this.BtnCloseIn);
        }
    }
    
    private void BtnCloseInActionPerformed(final ActionEvent evt) {
        this.DlgCariIn.dispose();
    }
    
    private void BtnCloseInKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllIn, (JTextField)this.TCariIn);
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
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TNoA.getText().trim().equals("") || this.TNmA.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoA, "Peminjam");
        }
        else if (this.TNoI.getText().trim().equals("") || this.TNmI.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmI, "Inventaris yang dipinjam");
        }
        else if (this.TabBayar.getSelectedIndex() == 0) {
            if (this.THari.getText().trim().equals("") || this.THari.getText().trim().equals("0")) {
                this.Valid.textKosong((JTextField)this.THari, "Keterlambatan");
            }
            else if (this.TDenda.getText().trim().equals("")) {
                this.Valid.textKosong((JTextField)this.THari, "Set Peminjaman");
            }
            else if (this.TDendaHari.getText().trim().equals("") || this.TDendaHari.getText().trim().equals("0")) {
                this.Valid.textKosong((JTextField)this.THari, "Denda Harian");
            }
            else {
                this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.menyimpan("bayar_denda_harian", "'" + this.DTPBayar.getSelectedItem() + "','" + this.TNoA.getText() + "','" + this.TNoI.getText() + "','" + this.THari.getText() + "','" + this.TDendaHari.getText() + "'", "Tgl.Bayar, Anggota dan Inventaris");
                this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
                this.TNoA.requestFocus();
                this.tampilByrDenda();
                this.THari.setText("0");
                this.THari.requestFocus();
            }
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            if (this.TNmDnda.getText().trim().equals("")) {
                this.Valid.textKosong(this.CmbJnsDnda, "Jenis Denda");
            }
            else if (this.TDendaLain.getText().trim().equals("") || this.TDendaLain.getText().trim().equals("0")) {
                this.Valid.textKosong(this.CmbJnsDnda, "Denda Lain-lain");
            }
            else if (this.TKtg.getText().trim().equals("")) {
                this.Valid.textKosong((JTextField)this.TKtg, "Katerangan");
            }
            else {
                this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.menyimpan("bayar_denda", "'" + this.DTPBayar.getSelectedItem() + "','" + this.TNoA.getText() + "','" + this.TNoI.getText() + "','" + this.CmbJnsDnda.getSelectedItem() + "','" + this.TDendaLain.getText() + "','" + this.TKtg.getText() + "'", "Tgl.Bayar, Anggota, Inventaris dan Jenis Denda");
                this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
                this.TNoA.requestFocus();
                this.tampilDendaLain();
                this.CmbJnsDnda.setSelectedIndex(0);
                this.TKtg.setText("");
                this.CmbJnsDnda.requestFocus();
            }
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else if (this.TabBayar.getSelectedIndex() == 0) {
            this.Valid.pindah(evt, (JTextField)this.THari, (JButton)this.BtnBatal);
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            this.Valid.pindah(evt, (JTextField)this.TKtg, (JButton)this.BtnBatal);
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
        if (this.TabBayar.getSelectedIndex() == 0) {
            if (this.tabModeByrDenda.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
                this.TNoA.requestFocus();
            }
            else if (this.TNmA.getText().trim().equals("") || this.TNmI.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
            }
            else if (!this.TNmA.getText().trim().equals("") && !this.TNmI.getText().trim().equals("")) {
                try {
                    this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                    this.Sequel.queryu("delete from bayar_denda_harian where no_anggota='" + this.TNoA.getText() + "' and no_inventaris='" + this.TNoI.getText() + "' and tgl_denda='" + this.DTPBayar.getSelectedItem() + "'");
                    this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
                    this.tampilByrDenda();
                }
                catch (Exception e) {
                    System.out.println("Pesan Error : " + e);
                    JOptionPane.showMessageDialog(null, "Maaf, Silahkan anda pilih terlebih dulu data yang mau anda hapus...\n Klik data pada table untuk memilih data...!!!!");
                }
            }
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            if (this.tabModeDendaLain.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
                this.TNoA.requestFocus();
            }
            else if (this.TNmA.getText().trim().equals("") || this.TNmI.getText().trim().equals("") || this.TNmDnda.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
            }
            else if (!this.TNmA.getText().trim().equals("") && !this.TNmI.getText().trim().equals("") && !this.TNmDnda.getText().trim().equals("")) {
                try {
                    this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                    this.Sequel.queryu("delete from bayar_denda where no_anggota='" + this.TNoA.getText() + "' and no_inventaris='" + this.TNoI.getText() + "' and tgl_denda='" + this.DTPBayar.getSelectedItem() + "' and kode_denda='" + this.CmbJnsDnda.getSelectedItem() + "'");
                    this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
                    this.tampilDendaLain();
                }
                catch (Exception e) {
                    System.out.println("Pesan Error : " + e);
                    JOptionPane.showMessageDialog(null, "Maaf, Silahkan anda pilih terlebih dulu data yang mau anda hapus...\n Klik data pada table untuk memilih data...!!!!");
                }
            }
        }
        this.emptTeks();
    }
    
    private void TabBayarMouseClicked(final MouseEvent evt) {
        this.plhTampil();
    }
    
    private void tbDendaLainKeyPressed(final KeyEvent evt) {
        if (this.tabModeDendaLain.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataDendaLain();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbDendaLainMouseClicked(final MouseEvent evt) {
        if (this.tabModeByrDenda.getRowCount() != 0) {
            try {
                this.getDataDendaLain();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void BtnAllActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.plhTampil();
    }
    
    private void BtnAllKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCari, (JTextField)this.TNoI);
        }
    }
    
    private void BtnCariActionPerformed(final ActionEvent evt) {
        if (this.TabBayar.getSelectedIndex() == 0) {
            final String sql = " bayar_denda_harian.no_anggota=anggota.no_anggota and bayar_denda_harian.no_inventaris=inventaris.no_inventaris and inventaris.kode_buku=buku.kode_buku ";
            this.prosesCariByrDenda("select bayar_denda_harian.tgl_denda, bayar_denda_harian.no_anggota, anggota.nama_anggota,bayar_denda_harian.no_inventaris, buku.judul_buku, bayar_denda_harian.keterlambatan, bayar_denda_harian.besar_denda from bayar_denda_harian,anggota,inventaris,buku where " + sql + "and bayar_denda_harian.tgl_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.keterlambatan like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.besar_denda like '%" + this.TCari.getText().trim() + "%' " + " order by bayar_denda_harian.tgl_denda");
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            final String sql = " bayar_denda.no_anggota=anggota.no_anggota and bayar_denda.no_inventaris=inventaris.no_inventaris and bayar_denda.kode_denda=denda.kode_denda and inventaris.kode_buku=buku.kode_buku ";
            this.prosesCariDendaLain("select bayar_denda.tgl_denda, bayar_denda.no_anggota, anggota.nama_anggota,bayar_denda.no_inventaris, buku.judul_buku, denda.jenis_denda, bayar_denda.besar_denda, bayar_denda.keterangan_denda from bayar_denda,anggota,buku,inventaris,denda where " + sql + "and bayar_denda.tgl_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and denda.jenis_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.besar_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.keterangan_denda like '%" + this.TCari.getText().trim() + "%' " + " order by bayar_denda.tgl_denda");
        }
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnAll);
        }
    }
    
    private void BtnHapusKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnHapusActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnBatal, (JButton)this.BtnPrint);
        }
    }
    
    private void BtnKeluarKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnPrint, (JTextField)this.TCari);
        }
    }
    
    private void CmbJnsDndaKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNoI, (JTextField)this.TKtg);
    }
    
    private void BtnPrintKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnPrintActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnHapus, (JButton)this.BtnKeluar);
        }
    }
    
    private void BtnPrintActionPerformed(final ActionEvent evt) {
        if (this.TabBayar.getSelectedIndex() == 0) {
            this.setCursor(Cursor.getPredefinedCursor(3));
            if (!this.TCari.getText().trim().equals("")) {
                this.BtnCariActionPerformed(evt);
            }
            if (this.tabModeByrDenda.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
                this.BtnBatal.requestFocus();
            }
            else if (this.tabModeByrDenda.getRowCount() != 0) {
                if (this.TCari.getText().trim().equals("")) {
                    this.Valid.MyReport("rptTrlmbt.jrxml", "report", "::[ Data Denda Keterlambatan ]::", "select bayar_denda_harian.tgl_denda, bayar_denda_harian.no_anggota, anggota.nama_anggota,bayar_denda_harian.no_inventaris, buku.judul_buku, bayar_denda_harian.keterlambatan, bayar_denda_harian.besar_denda from bayar_denda_harian,anggota,inventaris,buku where bayar_denda_harian.no_anggota=anggota.no_anggota and bayar_denda_harian.no_inventaris=inventaris.no_inventaris and inventaris.kode_buku=buku.kode_buku order by bayar_denda_harian.tgl_denda");
                }
                else if (!this.TCari.getText().trim().equals("")) {
                    final String sql = " bayar_denda_harian.no_anggota=anggota.no_anggota and bayar_denda_harian.no_inventaris=inventaris.no_inventaris and inventaris.kode_buku=buku.kode_buku ";
                    this.Valid.MyReport("rptTrlmbt.jrxml", "report", "::[ Data Denda Keterlambatan ]::", "select bayar_denda_harian.tgl_denda, bayar_denda_harian.no_anggota, anggota.nama_anggota,bayar_denda_harian.no_inventaris, buku.judul_buku, bayar_denda_harian.keterlambatan, bayar_denda_harian.besar_denda from bayar_denda_harian,anggota,inventaris,buku where " + sql + "and bayar_denda_harian.tgl_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.keterlambatan like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda_harian.besar_denda like '%" + this.TCari.getText().trim() + "%' " + " order by bayar_denda_harian.tgl_denda");
                }
            }
            this.setCursor(Cursor.getDefaultCursor());
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            this.setCursor(Cursor.getPredefinedCursor(3));
            if (!this.TCari.getText().trim().equals("")) {
                this.BtnCariActionPerformed(evt);
            }
            if (this.tabModeDendaLain.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
                this.BtnBatal.requestFocus();
            }
            else if (this.tabModeDendaLain.getRowCount() != 0) {
                if (this.TCari.getText().trim().equals("")) {
                    this.Valid.MyReport("rptDendaLain.jrxml", "report", "::[ Data Denda Lain ]::", "select bayar_denda.tgl_denda, bayar_denda.no_anggota, anggota.nama_anggota,bayar_denda.no_inventaris, buku.judul_buku, denda.jenis_denda, bayar_denda.besar_denda, bayar_denda.keterangan_denda from bayar_denda,anggota,buku,inventaris,denda where bayar_denda.no_anggota=anggota.no_anggota and bayar_denda.no_inventaris=inventaris.no_inventaris and bayar_denda.kode_denda=denda.kode_denda and inventaris.kode_buku=buku.kode_buku order by bayar_denda.tgl_denda");
                }
                else if (!this.TCari.getText().trim().equals("")) {
                    final String sql = " bayar_denda.no_anggota=anggota.no_anggota and bayar_denda.no_inventaris=inventaris.no_inventaris and bayar_denda.kode_denda=denda.kode_denda and inventaris.kode_buku=buku.kode_buku ";
                    this.Valid.MyReport("rptDendaLain.jrxml", "report", "::[ Data Denda Lain ]::", "select bayar_denda.tgl_denda, bayar_denda.no_anggota, anggota.nama_anggota,bayar_denda.no_inventaris, buku.judul_buku, denda.jenis_denda, bayar_denda.besar_denda, bayar_denda.keterangan_denda from bayar_denda,anggota,buku,inventaris,denda where " + sql + "and bayar_denda.tgl_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and denda.jenis_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.besar_denda like '%" + this.TCari.getText().trim() + "%' or " + sql + "and bayar_denda.keterangan_denda like '%" + this.TCari.getText().trim() + "%' " + " order by bayar_denda.tgl_denda");
                }
            }
            this.setCursor(Cursor.getDefaultCursor());
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgBayarDenda dialog = new DlgBayarDenda(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void LoadCombo() {
        this.Valid.loadCombo(this.CmbJnsDnda, "kode_denda", "denda");
    }
    
    private void isAnggota() {
        this.Sequel.cariIsi("select nama_anggota from anggota where no_anggota='" + this.TNoA.getText() + "'", (JTextField)this.TNmA);
    }
    
    private void isIn() {
        this.Sequel.cariIsi("select buku.judul_buku from inventaris,buku where inventaris.kode_buku=buku.kode_buku  and Inventaris.no_inventaris='" + this.TNoI.getText() + "'", (JTextField)this.TNmI);
        this.Sequel.cariIsi("select Inventaris.harga from inventaris,buku where inventaris.kode_buku=buku.kode_buku  and Inventaris.no_inventaris='" + this.TNoI.getText() + "'", (JTextField)this.THrgI);
    }
    
    public void isSetDenda() {
        this.Sequel.cariIsi("select denda_perhari from set_peminjaman", this.TDenda);
    }
    
    private void isHarian() {
        if (!this.TDenda.getText().trim().equals("") && !this.THari.getText().trim().equals("")) {
            this.Sequel.cariIsi("select ifnull(" + this.TDenda.getText() + "*" + this.THari.getText() + ",0) as a", (JTextField)this.TDendaHari);
        }
        else if (this.TDenda.getText().trim().equals("") || this.THari.getText().trim().equals("")) {
            this.TDendaHari.setText("0");
        }
    }
    
    private void isLain() {
        if (!this.THrgI.getText().trim().equals("") && !this.TPrsn.getText().trim().equals("")) {
            this.Sequel.cariIsi("select ifnull(round((" + this.TPrsn.getText() + "/100)*" + this.THrgI.getText() + "),0) as a", (JTextField)this.TDendaLain);
        }
        else if (this.THrgI.getText().trim().equals("") || this.TPrsn.getText().trim().equals("")) {
            this.TDendaLain.setText("0");
        }
    }
    
    public void tampilByrDenda() {
        final String sql = "select bayar_denda_harian.tgl_denda, bayar_denda_harian.no_anggota, anggota.nama_anggota,bayar_denda_harian.no_inventaris, buku.judul_buku, bayar_denda_harian.keterlambatan, bayar_denda_harian.besar_denda from bayar_denda_harian,anggota,inventaris,buku where bayar_denda_harian.no_anggota=anggota.no_anggota and bayar_denda_harian.no_inventaris=inventaris.no_inventaris and inventaris.kode_buku=buku.kode_buku order by bayar_denda_harian.tgl_denda";
        this.prosesCariByrDenda(sql);
    }
    
    private void prosesCariByrDenda(final String sql) {
        this.Valid.tabelKosong(this.tabModeByrDenda);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            double a = 0.0;
            while (rs.next()) {
                a += rs.getDouble(7);
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) };
                this.tabModeByrDenda.addRow(data);
            }
            this.LDenda.setText(this.df2.format(a));
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModeByrDenda.getRowCount();
        this.LCount.setText("" + b);
    }
    
    public void emptTeks() {
        this.TDendaHari.setText("0");
        this.TDendaLain.setText("0");
        this.THari.setText("0");
        this.THrgI.setText("0");
        this.TKtg.setText("");
        this.TNmA.setText("");
        this.TNmI.setText("");
        this.TNoA.setText("");
        this.TNoI.setText("");
        this.TCari.setText("");
        if (this.CmbJnsDnda.getItemCount() > 0) {
            this.CmbJnsDnda.setSelectedIndex(0);
        }
        this.DTPBayar.setDate(new Date());
        this.TNoA.requestFocus();
    }
    
    private void getDataByrDenda() {
        final int row = this.tbBayarDenda.getSelectedRow();
        if (row != -1) {
            try {
                this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabModeByrDenda.getValueAt(row, 0).toString());
                this.DTPBayar.setDate(dtpa);
                this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgBayarDenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.TNoA.setText(this.tabModeByrDenda.getValueAt(row, 1).toString());
            this.TNmA.setText(this.tabModeByrDenda.getValueAt(row, 2).toString());
            this.TNoI.setText(this.tabModeByrDenda.getValueAt(row, 3).toString());
            this.TNmI.setText(this.tabModeByrDenda.getValueAt(row, 4).toString());
            this.THari.setText(this.tabModeByrDenda.getValueAt(row, 5).toString());
            this.TDendaHari.setText(this.tabModeByrDenda.getValueAt(row, 6).toString());
        }
    }
    
    public void tampilDendaLain() {
        final String sql = "select bayar_denda.tgl_denda, bayar_denda.no_anggota, anggota.nama_anggota,bayar_denda.no_inventaris, buku.judul_buku, denda.jenis_denda, bayar_denda.besar_denda, bayar_denda.keterangan_denda from bayar_denda,anggota,buku,inventaris,denda where bayar_denda.no_anggota=anggota.no_anggota and bayar_denda.no_inventaris=inventaris.no_inventaris and bayar_denda.kode_denda=denda.kode_denda and inventaris.kode_buku=buku.kode_buku order by bayar_denda.tgl_denda";
        this.prosesCariDendaLain(sql);
    }
    
    private void prosesCariDendaLain(final String sql) {
        this.Valid.tabelKosong(this.tabModeDendaLain);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            double a = 0.0;
            while (rs.next()) {
                a += rs.getDouble(7);
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) };
                this.tabModeDendaLain.addRow(data);
            }
            this.LDenda.setText(this.df2.format(a));
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabModeDendaLain.getRowCount();
        this.LCount.setText("" + b);
    }
    
    private void getDataDendaLain() {
        final int row = this.tbDendaLain.getSelectedRow();
        if (row != -1) {
            try {
                this.DTPBayar.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabModeDendaLain.getValueAt(row, 0).toString());
                this.DTPBayar.setDate(dtpa);
                this.DTPBayar.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgBayarDenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.TNoA.setText(this.tabModeDendaLain.getValueAt(row, 1).toString());
            this.TNmA.setText(this.tabModeDendaLain.getValueAt(row, 2).toString());
            this.TNoI.setText(this.tabModeDendaLain.getValueAt(row, 3).toString());
            this.TNmI.setText(this.tabModeDendaLain.getValueAt(row, 4).toString());
            this.Sequel.cariIsi("select kode_denda from denda where jenis_denda='" + this.tabModeDendaLain.getValueAt(row, 5).toString() + "'", this.CmbJnsDnda);
            this.TNmDnda.setText(this.tabModeDendaLain.getValueAt(row, 5).toString());
            this.TDendaLain.setText(this.tabModeDendaLain.getValueAt(row, 6).toString());
            this.TKtg.setText(this.tabModeDendaLain.getValueAt(row, 7).toString());
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
    }
    
    private void getDataAnggota() {
        final int row = this.tbAnggota.getSelectedRow();
        if (row != -1) {
            this.TNoA.setText(this.tabModeAnggota.getValueAt(row, 0).toString());
            this.TNmA.setText(this.tabModeAnggota.getValueAt(row, 1).toString());
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
    }
    
    private void getDataIn() {
        final int row = this.tbInventaris.getSelectedRow();
        if (row != -1) {
            this.TNoI.setText(this.tabModeInventaris.getValueAt(row, 0).toString());
            this.TNmI.setText(this.tabModeInventaris.getValueAt(row, 2).toString());
            this.THrgI.setText(this.tabModeInventaris.getValueAt(row, 12).toString());
        }
    }
    
    public void plhTampil() {
        if (this.TabBayar.getSelectedIndex() == 0) {
            this.tampilByrDenda();
        }
        else if (this.TabBayar.getSelectedIndex() == 1) {
            this.tampilDendaLain();
        }
    }
}
