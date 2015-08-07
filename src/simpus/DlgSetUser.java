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

public class DlgSetUser extends JDialog
{
    private DefaultTableModel tabMode;
    private DefaultTableModel tabModePetugas;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    String jenis_koleksi;
    String kategori_koleksi;
    String ruang;
    String denda;
    String pengarang;
    String petugas;
    String anggota;
    String penerbit;
    String koleksi;
    String inventaris;
    String bayar_denda;
    String sirkulasi;
    String setup_pinjam;
    String setup_aplikasi;
    private Button BtnAllPtg;
    private Button BtnBatal;
    private Button BtnCariPtg;
    private Button BtnClosePtg;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPglPnb;
    private Button BtnSimpan;
    private JCheckBox ChkAngota;
    private JCheckBox ChkBayar;
    private JCheckBox ChkDenda;
    private JCheckBox ChkInventaris;
    private JCheckBox ChkJenis;
    private JCheckBox ChkKategori;
    private JCheckBox ChkKoleksi;
    private JCheckBox ChkPenerbit;
    private JCheckBox ChkPengarang;
    private JCheckBox ChkPetugas;
    private JCheckBox ChkRuang;
    private JCheckBox ChkSetAp;
    private JCheckBox ChkSetpinjam;
    private JCheckBox ChkSirkulasi;
    private JDialog DlgPetugas;
    private TextBox TCariPtg;
    private TextBox TNip;
    private TextBox TNmP;
    private TextBox TPass;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private Label label15;
    private Label label19;
    private Label label2;
    private Label label4;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelGlass panelGlass3;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private Table tbPetugas;
    private Table tbSetPinjam;
    
    public DlgSetUser(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.jenis_koleksi = "NO";
        this.kategori_koleksi = "NO";
        this.ruang = "NO";
        this.denda = "NO";
        this.pengarang = "NO";
        this.petugas = "NO";
        this.anggota = "NO";
        this.penerbit = "NO";
        this.koleksi = "NO";
        this.inventaris = "NO";
        this.bayar_denda = "NO";
        this.sirkulasi = "NO";
        this.setup_pinjam = "NO";
        this.setup_aplikasi = "NO";
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(604, 635);
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>NIP</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Password</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Ruang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Pengarang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Anggota</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Bayar Denda</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Sirkulasi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Setup Pinjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Setup Aplikasi</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbSetPinjam.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbSetPinjam.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbSetPinjam.setAutoResizeMode(0);
        for (int i = 0; i < 16; ++i) {
            final TableColumn column = this.tbSetPinjam.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(227);
            }
            else if (i == 1) {
                column.setPreferredWidth(227);
            }
            else {
                column.setPreferredWidth(150);
            }
        }
        this.tbSetPinjam.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowPtg = { "<html><font color='#006699' face='Comic Sans MS'>NIP</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>" };
        this.tabModePetugas = new DefaultTableModel((Object[][])null, rowPtg) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPetugas.setModel(this.tabModePetugas);
        this.tbPetugas.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPetugas.setAutoResizeMode(0);
        for (int j = 0; j < 8; ++j) {
            final TableColumn column2 = this.tbPetugas.getColumnModel().getColumn(j);
            if (j == 0) {
                column2.setPreferredWidth(100);
            }
            else if (j == 1) {
                column2.setPreferredWidth(260);
            }
            else if (j == 2) {
                column2.setPreferredWidth(150);
            }
            else if (j == 3) {
                column2.setPreferredWidth(130);
            }
            else if (j == 4) {
                column2.setPreferredWidth(50);
            }
            else if (j == 5) {
                column2.setPreferredWidth(350);
            }
            else if (j == 6) {
                column2.setPreferredWidth(110);
            }
            else if (j == 7) {
                column2.setPreferredWidth(180);
            }
        }
        this.tbPetugas.setDefaultRenderer(Object.class, new WarnaTable());
        this.TNip.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNip));
        this.TPass.setDocument((Document)new batasInput(25).getKata((JTextField)this.TPass));
        this.TCariPtg.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPtg));
        this.TNip.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSetUser.this.isPtg();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSetUser.this.isPtg();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSetUser.this.isPtg();
            }
        });
        this.DlgPetugas.setSize(450, 280);
        this.DlgPetugas.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgPetugas = new JDialog();
        this.internalFrame6 = new InternalFrame();
        this.panelGlass3 = new PanelGlass();
        this.label15 = new Label();
        this.TCariPtg = new TextBox();
        this.BtnCariPtg = new Button();
        this.BtnAllPtg = new Button();
        this.label19 = new Label();
        this.BtnClosePtg = new Button();
        this.scrollPane2 = new ScrollPane();
        this.tbPetugas = new Table();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.TNmP = new TextBox();
        this.TPass = new TextBox();
        this.label2 = new Label();
        this.label4 = new Label();
        this.jPanel1 = new JPanel();
        this.ChkJenis = new JCheckBox();
        this.ChkKategori = new JCheckBox();
        this.ChkRuang = new JCheckBox();
        this.ChkDenda = new JCheckBox();
        this.ChkPengarang = new JCheckBox();
        this.ChkPetugas = new JCheckBox();
        this.ChkAngota = new JCheckBox();
        this.ChkPenerbit = new JCheckBox();
        this.ChkKoleksi = new JCheckBox();
        this.ChkInventaris = new JCheckBox();
        this.ChkBayar = new JCheckBox();
        this.ChkSirkulasi = new JCheckBox();
        this.ChkSetpinjam = new JCheckBox();
        this.ChkSetAp = new JCheckBox();
        this.TNip = new TextBox();
        this.BtnPglPnb = new Button();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnKeluar = new Button();
        this.scrollPane1 = new ScrollPane();
        this.tbSetPinjam = new Table();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.DlgPetugas.setModal(true);
        this.DlgPetugas.setName("DlgPetugas");
        this.DlgPetugas.setResizable(false);
        this.DlgPetugas.setUndecorated(true);
        this.internalFrame6.setName("internalFrame6");
        this.internalFrame6.setLayout(new BorderLayout(1, 1));
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
        this.TCariPtg.setName("TCariPtg");
        this.TCariPtg.setPreferredSize(new Dimension(230, 23));
        this.TCariPtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.TCariPtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariPtg);
        this.BtnCariPtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPtg.setMnemonic('2');
        this.BtnCariPtg.setToolTipText("Alt+2");
        this.BtnCariPtg.setCursor(new Cursor(12));
        this.BtnCariPtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPtg.setName("BtnCariPtg");
        this.BtnCariPtg.setPreferredSize(new Dimension(26, 23));
        this.BtnCariPtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnCariPtgActionPerformed(evt);
            }
        });
        this.BtnCariPtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnCariPtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariPtg);
        this.BtnAllPtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPtg.setMnemonic('1');
        this.BtnAllPtg.setToolTipText("Alt+1");
        this.BtnAllPtg.setCursor(new Cursor(12));
        this.BtnAllPtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPtg.setName("BtnAllPtg");
        this.BtnAllPtg.setPreferredSize(new Dimension(26, 23));
        this.BtnAllPtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnAllPtgActionPerformed(evt);
            }
        });
        this.BtnAllPtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnAllPtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPtg);
        this.label19.setHorizontalAlignment(4);
        this.label19.setName("label19");
        this.label19.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label19);
        this.BtnClosePtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnClosePtg.setMnemonic('3');
        this.BtnClosePtg.setToolTipText("Alt+3");
        this.BtnClosePtg.setCursor(new Cursor(12));
        this.BtnClosePtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnClosePtg.setName("BtnClosePtg");
        this.BtnClosePtg.setPreferredSize(new Dimension(26, 23));
        this.BtnClosePtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnClosePtgActionPerformed(evt);
            }
        });
        this.BtnClosePtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnClosePtgKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnClosePtg);
        this.internalFrame6.add((Component)this.panelGlass3, "First");
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane2.setName("scrollPane2");
        this.tbPetugas.setAutoCreateRowSorter(true);
        this.tbPetugas.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPetugas.setName("tbPetugas");
        this.tbPetugas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSetUser.this.tbPetugasMouseClicked(evt);
            }
        });
        this.tbPetugas.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.tbPetugasKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.tbPetugas);
        this.internalFrame6.add(this.scrollPane2, "Center");
        this.DlgPetugas.getContentPane().add(this.internalFrame6, "Center");
        this.setDefaultCloseOperation(2);
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(100, 210));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.TNmP.setEditable(false);
        this.TNmP.setCursor(new Cursor(2));
        this.TNmP.setName("TNmP");
        this.TNmP.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.TNmPKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNmP);
        this.TNmP.setBounds(202, 12, 360, 23);
        this.TPass.setCursor(new Cursor(2));
        this.TPass.setName("TPass");
        this.TPass.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.TPassKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TPass);
        this.TPass.setBounds(70, 42, 492, 23);
        this.label2.setText("Password :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(13, 42, 60, 23);
        this.label4.setText("NIP :");
        this.label4.setName("label4");
        this.panelGlass1.add((Component)this.label4);
        this.label4.setBounds(42, 12, 70, 23);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(255, 110, 255), 1, true), ".: Hak Akses Yang Diberikan : ", 0, 0, new Font("Dialog", 0, 12), new Color(205, 214, 255)));
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setOpaque(false);
        this.jPanel1.setLayout(new GridLayout(4, 4, 2, 2));
        this.ChkJenis.setBackground(new Color(51, 51, 255));
        this.ChkJenis.setForeground(new Color(205, 214, 255));
        this.ChkJenis.setText("Jenis");
        this.ChkJenis.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJenis.setName("ChkJenis");
        this.ChkJenis.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJenis.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkJenis.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkJenis);
        this.ChkKategori.setBackground(new Color(51, 51, 255));
        this.ChkKategori.setForeground(new Color(205, 214, 255));
        this.ChkKategori.setText("Kategori");
        this.ChkKategori.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKategori.setName("ChkKategori");
        this.ChkKategori.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKategori.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkKategori.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkKategori);
        this.ChkRuang.setBackground(new Color(51, 51, 255));
        this.ChkRuang.setForeground(new Color(205, 214, 255));
        this.ChkRuang.setText("Ruang");
        this.ChkRuang.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkRuang.setName("ChkRuang");
        this.ChkRuang.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkRuang.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkRuang.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkRuang);
        this.ChkDenda.setBackground(new Color(51, 51, 255));
        this.ChkDenda.setForeground(new Color(205, 214, 255));
        this.ChkDenda.setText("Denda");
        this.ChkDenda.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkDenda.setName("ChkDenda");
        this.ChkDenda.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkDenda.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkDenda.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkDenda);
        this.ChkPengarang.setBackground(new Color(51, 51, 255));
        this.ChkPengarang.setForeground(new Color(205, 214, 255));
        this.ChkPengarang.setText("Type");
        this.ChkPengarang.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPengarang.setName("ChkPengarang");
        this.ChkPengarang.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPengarang.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkPengarang.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkPengarang);
        this.ChkPetugas.setBackground(new Color(51, 51, 255));
        this.ChkPetugas.setForeground(new Color(205, 214, 255));
        this.ChkPetugas.setText("Petugas");
        this.ChkPetugas.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPetugas.setName("ChkPetugas");
        this.ChkPetugas.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPetugas.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkPetugas.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkPetugas);
        this.ChkAngota.setBackground(new Color(51, 51, 255));
        this.ChkAngota.setForeground(new Color(205, 214, 255));
        this.ChkAngota.setText("Anggota");
        this.ChkAngota.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkAngota.setName("ChkAngota");
        this.ChkAngota.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkAngota.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkAngota.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkAngota);
        this.ChkPenerbit.setBackground(new Color(51, 51, 255));
        this.ChkPenerbit.setForeground(new Color(205, 214, 255));
        this.ChkPenerbit.setText("Produsen");
        this.ChkPenerbit.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPenerbit.setName("ChkPenerbit");
        this.ChkPenerbit.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkPenerbit.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkPenerbit.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkPenerbit);
        this.ChkKoleksi.setBackground(new Color(51, 51, 255));
        this.ChkKoleksi.setForeground(new Color(205, 214, 255));
        this.ChkKoleksi.setText("Barang");
        this.ChkKoleksi.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKoleksi.setName("ChkKoleksi");
        this.ChkKoleksi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkKoleksi.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkKoleksi.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkKoleksi);
        this.ChkInventaris.setBackground(new Color(51, 51, 255));
        this.ChkInventaris.setForeground(new Color(205, 214, 255));
        this.ChkInventaris.setText("Inventaris");
        this.ChkInventaris.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkInventaris.setName("ChkInventaris");
        this.ChkInventaris.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkInventaris.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkInventaris.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkInventaris);
        this.ChkBayar.setBackground(new Color(51, 51, 255));
        this.ChkBayar.setForeground(new Color(205, 214, 255));
        this.ChkBayar.setText("Bayar Denda");
        this.ChkBayar.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkBayar.setName("ChkBayar");
        this.ChkBayar.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkBayar.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkBayar.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkBayar);
        this.ChkSirkulasi.setBackground(new Color(51, 51, 255));
        this.ChkSirkulasi.setForeground(new Color(205, 214, 255));
        this.ChkSirkulasi.setText("Sirkulasi");
        this.ChkSirkulasi.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSirkulasi.setName("ChkSirkulasi");
        this.ChkSirkulasi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSirkulasi.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSirkulasi.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkSirkulasi);
        this.ChkSetpinjam.setBackground(new Color(51, 51, 255));
        this.ChkSetpinjam.setForeground(new Color(205, 214, 255));
        this.ChkSetpinjam.setText("Setup Pinjam");
        this.ChkSetpinjam.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSetpinjam.setName("ChkSetpinjam");
        this.ChkSetpinjam.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSetpinjam.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSetpinjam.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkSetpinjam);
        this.ChkSetAp.setBackground(new Color(51, 51, 255));
        this.ChkSetAp.setForeground(new Color(205, 214, 255));
        this.ChkSetAp.setText("Setup Aplikasi");
        this.ChkSetAp.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSetAp.setName("ChkSetAp");
        this.ChkSetAp.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSetAp.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSetAp.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.jPanel1.add(this.ChkSetAp);
        this.panelGlass1.add((Component)this.jPanel1);
        this.jPanel1.setBounds(11, 70, 580, 128);
        this.TNip.setCursor(new Cursor(2));
        this.TNip.setName("TNip");
        this.TNip.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.TNipKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNip);
        this.TNip.setBounds(70, 12, 130, 23);
        this.BtnPglPnb.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb.setMnemonic('1');
        this.BtnPglPnb.setToolTipText("Alt+1");
        this.BtnPglPnb.setCursor(new Cursor(12));
        this.BtnPglPnb.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb.setName("BtnPglPnb");
        this.BtnPglPnb.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPnb.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnPglPnbActionPerformed(evt);
            }
        });
        this.BtnPglPnb.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnPglPnbKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.BtnPglPnb);
        this.BtnPglPnb.setBounds(565, 12, 25, 23);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
        this.panelGlass2.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass2.setOpaqueImage(false);
        this.panelGlass2.setPreferredSize(new Dimension(100, 55));
        this.panelGlass2.setRound(false);
        this.panelGlass2.setWarna(new Color(90, 0, 90));
        this.panelGlass2.setLayout((LayoutManager)null);
        this.BtnSimpan.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/save-16x16.png")));
        this.BtnSimpan.setMnemonic('S');
        this.BtnSimpan.setText("Simpan");
        this.BtnSimpan.setToolTipText("Alt+S");
        this.BtnSimpan.setCursor(new Cursor(12));
        this.BtnSimpan.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnSimpan.setName("BtnSimpan");
        this.BtnSimpan.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(6, 10, 100, 30);
        this.BtnBatal.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Cancel-2-16x16.png")));
        this.BtnBatal.setMnemonic('B');
        this.BtnBatal.setText("Batal");
        this.BtnBatal.setToolTipText("Alt+B");
        this.BtnBatal.setCursor(new Cursor(12));
        this.BtnBatal.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnBatal.setName("BtnBatal");
        this.BtnBatal.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnBatalKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnBatal);
        this.BtnBatal.setBounds(108, 10, 100, 30);
        this.BtnHapus.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/stop_f2.png")));
        this.BtnHapus.setMnemonic('H');
        this.BtnHapus.setText("Hapus");
        this.BtnHapus.setToolTipText("Alt+H");
        this.BtnHapus.setCursor(new Cursor(12));
        this.BtnHapus.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnHapus.setName("BtnHapus");
        this.BtnHapus.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnHapusKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnHapus);
        this.BtnHapus.setBounds(210, 10, 100, 30);
        this.BtnEdit.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/inventaris.png")));
        this.BtnEdit.setMnemonic('E');
        this.BtnEdit.setText("Edit");
        this.BtnEdit.setToolTipText("Alt+E");
        this.BtnEdit.setCursor(new Cursor(12));
        this.BtnEdit.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnEdit.setName("BtnEdit");
        this.BtnEdit.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnEditKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnEdit);
        this.BtnEdit.setBounds(312, 10, 100, 30);
        this.BtnKeluar.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnKeluar.setMnemonic('K');
        this.BtnKeluar.setText("Keluar");
        this.BtnKeluar.setToolTipText("Alt+K");
        this.BtnKeluar.setCursor(new Cursor(12));
        this.BtnKeluar.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnKeluar.setName("BtnKeluar");
        this.BtnKeluar.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSetUser.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluar);
        this.BtnKeluar.setBounds(495, 10, 100, 30);
        this.internalFrame1.add((Component)this.panelGlass2, "Last");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbSetPinjam.setAutoCreateRowSorter(true);
        this.tbSetPinjam.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbSetPinjam.setName("tbSetPinjam");
        this.tbSetPinjam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSetUser.this.tbSetPinjamMouseClicked(evt);
            }
        });
        this.tbSetPinjam.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetUser.this.tbSetPinjamKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbSetPinjam);
        this.internalFrame1.add(this.scrollPane1, "Center");
        this.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: SETUP USER ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(177, 10, 250, 20);
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
        this.pack();
    }
    
    private void TNmPKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JTextField)this.TPass);
    }
    
    private void TPassKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNmP, (JButton)this.BtnSimpan);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TNip.getText().trim().equals("") || this.TNmP.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmP, "Pegawai");
        }
        else if (this.TPass.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TPass, "Password");
        }
        else {
            if (this.ChkJenis.isSelected()) {
                this.jenis_koleksi = "YES";
            }
            else if (!this.ChkJenis.isSelected()) {
                this.jenis_koleksi = "NO";
            }
            if (this.ChkKategori.isSelected()) {
                this.kategori_koleksi = "YES";
            }
            else if (!this.ChkKategori.isSelected()) {
                this.kategori_koleksi = "NO";
            }
            if (this.ChkRuang.isSelected()) {
                this.ruang = "YES";
            }
            else if (!this.ChkRuang.isSelected()) {
                this.ruang = "NO";
            }
            if (this.ChkDenda.isSelected()) {
                this.denda = "YES";
            }
            else if (!this.ChkDenda.isSelected()) {
                this.denda = "NO";
            }
            if (this.ChkPengarang.isSelected()) {
                this.pengarang = "YES";
            }
            else if (!this.ChkPengarang.isSelected()) {
                this.pengarang = "NO";
            }
            if (this.ChkPetugas.isSelected()) {
                this.petugas = "YES";
            }
            else if (!this.ChkPetugas.isSelected()) {
                this.petugas = "NO";
            }
            if (this.ChkAngota.isSelected()) {
                this.anggota = "YES";
            }
            else if (!this.ChkAngota.isSelected()) {
                this.anggota = "NO";
            }
            if (this.ChkPenerbit.isSelected()) {
                this.penerbit = "YES";
            }
            else if (!this.ChkPenerbit.isSelected()) {
                this.penerbit = "NO";
            }
            if (this.ChkKoleksi.isSelected()) {
                this.koleksi = "YES";
            }
            else if (!this.ChkKoleksi.isSelected()) {
                this.koleksi = "NO";
            }
            if (this.ChkInventaris.isSelected()) {
                this.inventaris = "YES";
            }
            else if (!this.ChkInventaris.isSelected()) {
                this.inventaris = "NO";
            }
            if (this.ChkBayar.isSelected()) {
                this.bayar_denda = "YES";
            }
            else if (!this.ChkBayar.isSelected()) {
                this.bayar_denda = "NO";
            }
            if (this.ChkSirkulasi.isSelected()) {
                this.sirkulasi = "YES";
            }
            else if (!this.ChkSirkulasi.isSelected()) {
                this.sirkulasi = "NO";
            }
            if (this.ChkSetpinjam.isSelected()) {
                this.setup_pinjam = "YES";
            }
            else if (!this.ChkSetpinjam.isSelected()) {
                this.setup_pinjam = "NO";
            }
            if (this.ChkSetAp.isSelected()) {
                this.setup_aplikasi = "YES";
            }
            else if (!this.ChkSetAp.isSelected()) {
                this.setup_aplikasi = "NO";
            }
            this.Sequel.menyimpan("user", "'" + this.TNip.getText() + "',AES_ENCRYPT('" + this.TPass.getText() + "','windi')," + "'" + this.jenis_koleksi + "'," + "'" + this.kategori_koleksi + "'," + "'" + this.ruang + "'," + "'" + this.denda + "'," + "'" + this.pengarang + "'," + "'" + this.petugas + "'," + "'" + this.anggota + "'," + "'" + this.penerbit + "'," + "'" + this.koleksi + "'," + "'" + this.inventaris + "'," + "'" + this.bayar_denda + "'," + "'" + this.sirkulasi + "'," + "'" + this.setup_pinjam + "'," + "'" + this.setup_aplikasi + "'", "User");
            this.tampil();
            this.emptTeks();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TPass, (JButton)this.BtnBatal);
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
        if (this.tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            this.TNmP.requestFocus();
        }
        else if (this.TNmP.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (!this.TNmP.getText().trim().equals("")) {
            this.Sequel.queryu("delete from user where nip='" + this.TNip.getText() + "'");
            this.tampil();
            this.emptTeks();
        }
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
        if (this.TNip.getText().trim().equals("") || this.TNmP.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmP, "Pegawai");
        }
        else if (this.TPass.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TPass, "Password");
        }
        else {
            if (this.ChkJenis.isSelected()) {
                this.jenis_koleksi = "YES";
            }
            else if (!this.ChkJenis.isSelected()) {
                this.jenis_koleksi = "NO";
            }
            if (this.ChkKategori.isSelected()) {
                this.kategori_koleksi = "YES";
            }
            else if (!this.ChkKategori.isSelected()) {
                this.kategori_koleksi = "NO";
            }
            if (this.ChkRuang.isSelected()) {
                this.ruang = "YES";
            }
            else if (!this.ChkRuang.isSelected()) {
                this.ruang = "NO";
            }
            if (this.ChkDenda.isSelected()) {
                this.denda = "YES";
            }
            else if (!this.ChkDenda.isSelected()) {
                this.denda = "NO";
            }
            if (this.ChkPengarang.isSelected()) {
                this.pengarang = "YES";
            }
            else if (!this.ChkPengarang.isSelected()) {
                this.pengarang = "NO";
            }
            if (this.ChkPetugas.isSelected()) {
                this.petugas = "YES";
            }
            else if (!this.ChkPetugas.isSelected()) {
                this.petugas = "NO";
            }
            if (this.ChkAngota.isSelected()) {
                this.anggota = "YES";
            }
            else if (!this.ChkAngota.isSelected()) {
                this.anggota = "NO";
            }
            if (this.ChkPenerbit.isSelected()) {
                this.penerbit = "YES";
            }
            else if (!this.ChkPenerbit.isSelected()) {
                this.penerbit = "NO";
            }
            if (this.ChkKoleksi.isSelected()) {
                this.koleksi = "YES";
            }
            else if (!this.ChkKoleksi.isSelected()) {
                this.koleksi = "NO";
            }
            if (this.ChkInventaris.isSelected()) {
                this.inventaris = "YES";
            }
            else if (!this.ChkInventaris.isSelected()) {
                this.inventaris = "NO";
            }
            if (this.ChkBayar.isSelected()) {
                this.bayar_denda = "YES";
            }
            else if (!this.ChkBayar.isSelected()) {
                this.bayar_denda = "NO";
            }
            if (this.ChkSirkulasi.isSelected()) {
                this.sirkulasi = "YES";
            }
            else if (!this.ChkSirkulasi.isSelected()) {
                this.sirkulasi = "NO";
            }
            if (this.ChkSetpinjam.isSelected()) {
                this.setup_pinjam = "YES";
            }
            else if (!this.ChkSetpinjam.isSelected()) {
                this.setup_pinjam = "NO";
            }
            if (this.ChkSetAp.isSelected()) {
                this.setup_aplikasi = "YES";
            }
            else if (!this.ChkSetAp.isSelected()) {
                this.setup_aplikasi = "NO";
            }
            this.Sequel.queryu("update user set password=AES_ENCRYPT('" + this.TPass.getText() + "','windi')," + "jenis_koleksi='" + this.jenis_koleksi + "'," + "kategori_koleksi='" + this.kategori_koleksi + "'," + "ruang='" + this.ruang + "'," + "denda='" + this.denda + "'," + "pengarang='" + this.pengarang + "'," + "petugas='" + this.petugas + "'," + "anggota='" + this.anggota + "'," + "penerbit='" + this.penerbit + "'," + "koleksi='" + this.koleksi + "'," + "inventaris='" + this.inventaris + "'," + "bayar_denda='" + this.bayar_denda + "'," + "sirkulasi='" + this.sirkulasi + "'," + "setup_pinjam='" + this.setup_pinjam + "'," + "setup_aplikasi='" + this.setup_aplikasi + "' where nip='" + this.TNip.getText() + "'");
            this.tampil();
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
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JTextField)this.TNmP);
        }
    }
    
    private void tbSetPinjamMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbSetPinjamKeyPressed(final KeyEvent evt) {
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
    
    private void TNipKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglPnbActionPerformed(final ActionEvent evt) {
        this.tampilPtg();
        this.DlgPetugas.setLocationRelativeTo(null);
        this.DlgPetugas.setVisible(true);
    }
    
    private void BtnPglPnbKeyPressed(final KeyEvent evt) {
    }
    
    private void TCariPtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCariPtg);
        }
    }
    
    private void BtnCariPtgActionPerformed(final ActionEvent evt) {
        this.prosesCariPtg("select * from petugas where nip like '%" + this.TCariPtg.getText().trim() + "%' " + "or nama_petugas like '%" + this.TCariPtg.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCariPtg.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCariPtg.getText().trim() + "%' " + "or j_kel like '%" + this.TCariPtg.getText().trim() + "%' " + "or alamat like '%" + this.TCariPtg.getText().trim() + "%' " + "or no_telp like '%" + this.TCariPtg.getText().trim() + "%' " + "or email like '%" + this.TCariPtg.getText().trim() + "%' order by nip");
    }
    
    private void BtnCariPtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariPtg, (JButton)this.BtnAllPtg);
        }
    }
    
    private void BtnAllPtgActionPerformed(final ActionEvent evt) {
        this.tampilPtg();
    }
    
    private void BtnAllPtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllPtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariPtg, (JButton)this.BtnClosePtg);
        }
    }
    
    private void BtnClosePtgActionPerformed(final ActionEvent evt) {
        this.DlgPetugas.dispose();
    }
    
    private void BtnClosePtgKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllPtg, (JTextField)this.TCariPtg);
    }
    
    private void tbPetugasMouseClicked(final MouseEvent evt) {
        if (this.tabModePetugas.getRowCount() != 0) {
            try {
                this.getDataPtg();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPetugasKeyPressed(final KeyEvent evt) {
        if (this.tabModePetugas.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataPtg();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgSetUser dialog = new DlgSetUser(new JFrame(), true);
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
        final String sql = "select nip,AES_DECRYPT(password,'windi'),jenis_koleksi,kategori_koleksi,ruang,denda,pengarang,petugas,anggota,penerbit, koleksi,inventaris,bayar_denda,sirkulasi,setup_pinjam, setup_aplikasi from user";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16) };
                this.tabMode.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
        final int b = this.tabMode.getRowCount();
    }
    
    public void emptTeks() {
        this.TNip.setText("");
        this.TPass.setText("");
        this.ChkAngota.setSelected(false);
        this.ChkBayar.setSelected(false);
        this.ChkDenda.setSelected(false);
        this.ChkInventaris.setSelected(false);
        this.ChkJenis.setSelected(false);
        this.ChkKategori.setSelected(false);
        this.ChkKoleksi.setSelected(false);
        this.ChkPenerbit.setSelected(false);
        this.ChkPengarang.setSelected(false);
        this.ChkPetugas.setSelected(false);
        this.ChkRuang.setSelected(false);
        this.ChkSetAp.setSelected(false);
        this.ChkSetpinjam.setSelected(false);
        this.ChkSirkulasi.setSelected(false);
        this.TNip.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbSetPinjam.getSelectedRow();
        if (row != -1) {
            this.TNip.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TPass.setText(this.tabMode.getValueAt(row, 1).toString());
            if (this.tabMode.getValueAt(row, 2).toString().equals("YES")) {
                this.ChkJenis.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 2).toString().equals("NO")) {
                this.ChkJenis.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 3).toString().equals("YES")) {
                this.ChkKategori.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 3).toString().equals("NO")) {
                this.ChkKategori.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 4).toString().equals("YES")) {
                this.ChkRuang.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 4).toString().equals("NO")) {
                this.ChkRuang.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 5).toString().equals("YES")) {
                this.ChkDenda.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 5).toString().equals("NO")) {
                this.ChkDenda.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 6).toString().equals("YES")) {
                this.ChkPengarang.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 6).toString().equals("NO")) {
                this.ChkPengarang.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 7).toString().equals("YES")) {
                this.ChkPetugas.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 7).toString().equals("NO")) {
                this.ChkPetugas.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 8).toString().equals("YES")) {
                this.ChkAngota.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 8).toString().equals("NO")) {
                this.ChkAngota.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 9).toString().equals("YES")) {
                this.ChkPenerbit.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 9).toString().equals("NO")) {
                this.ChkPenerbit.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 10).toString().equals("YES")) {
                this.ChkKoleksi.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 10).toString().equals("NO")) {
                this.ChkKoleksi.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 11).toString().equals("YES")) {
                this.ChkInventaris.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 11).toString().equals("NO")) {
                this.ChkInventaris.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 12).toString().equals("YES")) {
                this.ChkBayar.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 12).toString().equals("NO")) {
                this.ChkBayar.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 13).toString().equals("YES")) {
                this.ChkSirkulasi.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 13).toString().equals("NO")) {
                this.ChkSirkulasi.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 14).toString().equals("YES")) {
                this.ChkSetpinjam.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 14).toString().equals("NO")) {
                this.ChkSetpinjam.setSelected(false);
            }
            if (this.tabMode.getValueAt(row, 15).toString().equals("YES")) {
                this.ChkSetAp.setSelected(true);
            }
            else if (this.tabMode.getValueAt(row, 15).toString().equals("NO")) {
                this.ChkSetAp.setSelected(false);
            }
        }
    }
    
    public void tampilPtg() {
        final String sql = "select * from petugas order by nip";
        this.prosesCariPtg(sql);
    }
    
    private void prosesCariPtg(final String sql) {
        this.Valid.tabelKosong(this.tabModePetugas);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) };
                this.tabModePetugas.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void getDataPtg() {
        final int row = this.tbPetugas.getSelectedRow();
        if (row != -1) {
            this.TNip.setText(this.tabModePetugas.getValueAt(row, 0).toString());
            this.TNmP.setText(this.tabModePetugas.getValueAt(row, 1).toString());
        }
    }
    
    private void isPtg() {
        this.Sequel.cariIsi("select nama_petugas from petugas where nip='" + this.TNip.getText() + "'", (JTextField)this.TNmP);
    }
}
