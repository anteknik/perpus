package simpus;

import usu.widget.*;
import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.MenuBar;
import widget.Panel;
import widget.PasswordBox;
import widget.ScrollPane;
import fungsi.*;

import javax.swing.text.*;

import java.util.*;

import javax.swing.border.*;

import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.awt.*;

public class frmUtama extends JFrame
{
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    Dimension screen;
    DlgJenisKoleksi dlgjnkol;
    DlgKategoriKoleksi dlgktkol;
    DlgRuang dlgruang;
    DlgDenda dlgdenda;
    DlgPengarang dlgpng;
    DlgAnggota dlgAnggota;
    DlgPenerbit dlgPenerbit;
    DlgPetugas dlgPetugas;
    DlgKoleksi dlgKoleksi;
    DlgInventaris dlgInventaris;
    DlgBayarDenda dlgBayarDenda;
    DlgSirkulasi dlgSirkulasi;
    DlgSetPinjam dlgSetPinjam;
    DlgAdmin dlgAdmin;
    DlgSetting dlgSetting;
    DlgSetUser dlgSetUser;
    DlgVakum dlgVakum;
    DlgAbout dlgAbout;
    DlgPusatData dlgPusatData;
    private ButtonGlass BtnAnggota;
    private ButtonGlass BtnBayar;
    private Button BtnCancel;
    private ButtonGlass BtnDenda;
    private ButtonGlass BtnInventaris;
    private ButtonGlass BtnJnsKoleksi;
    private ButtonBig BtnKeluar;
    private ButtonGlass BtnKoleksi;
    private ButtonGlass BtnKtgKoleksi;
    private ButtonBig BtnLog;
    private Button BtnLogin;
    private ButtonGlass BtnPenerbit;
    private ButtonGlass BtnPengarang;
    private ButtonGlass BtnPetugas;
    private ButtonGlass BtnRuang;
    private ButtonGlass BtnSetAdmin;
    private ButtonGlass BtnSetAplikasi;
    private ButtonGlass BtnSetPinjam;
    private ButtonGlass BtnSetUser;
    private ButtonGlass BtnSirkulasi;
    private ButtonBig BtnToolBay;
    private ButtonBig BtnToolInv;
    private ButtonBig BtnToolKoleksi;
    private ButtonBig BtnToolSir;
    private ButtonGlass BtnVakum;
    private JCheckBox ChkFile;
    private JCheckBox ChkKoleksi;
    private JCheckBox ChkMaster;
    private JCheckBox ChkSetting;
    private JCheckBox ChkTransaksi;
    private JDialog DlgLogin;
    private MenuBar MenuBar;
    private JMenuItem MenuKeluar;
    private JMenuItem MnLogin;
    private JPanel PanelFile;
    private JPanel PanelKoleksi;
    private JPanel PanelMaster;
    private PanelGray PanelMenu;
    private JPanel PanelSetting;
    private InternalFrame PanelStatus;
    private JPanel PanelTransaksi;
    private JPanel PanelUtama;
    private InternalFrame Toolbar;
    private BackCari backCari;
    private BackCari backCari1;
    private PasswordBox edAdmin;
    private PasswordBox edPwd;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame3;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JPopupMenu.Separator jSeparator7;
    private JPopupMenu.Separator jSeparator8;
    private JLabel lblStts;
    private JLabel lblTgl;
    private JLabel lblUser;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    
    public frmUtama() {
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.dlgjnkol = new DlgJenisKoleksi(this, false);
        this.dlgktkol = new DlgKategoriKoleksi(this, false);
        this.dlgruang = new DlgRuang(this, false);
        this.dlgdenda = new DlgDenda(this, false);
        this.dlgpng = new DlgPengarang(this, false);
        this.dlgAnggota = new DlgAnggota(this, false);
        this.dlgPenerbit = new DlgPenerbit(this, false);
        this.dlgPetugas = new DlgPetugas(this, false);
        this.dlgKoleksi = new DlgKoleksi(this, false);
        this.dlgInventaris = new DlgInventaris(this, false);
        this.dlgBayarDenda = new DlgBayarDenda(this, false);
        this.dlgSirkulasi = new DlgSirkulasi(this, false);
        this.dlgSetPinjam = new DlgSetPinjam(this, false);
        this.dlgAdmin = new DlgAdmin(this, false);
        this.dlgSetting = new DlgSetting(this, false);
        this.dlgSetUser = new DlgSetUser(this, false);
        this.dlgVakum = new DlgVakum(this, false);
        this.dlgAbout = new DlgAbout(this, false);
        this.dlgPusatData = new DlgPusatData(this, false);
        this.initComponents();
        this.setSize(this.screen.width, this.screen.height);
        this.setIconImage(new ImageIcon(this.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
        this.edAdmin.setDocument((Document)new batasInput(100).getKata((JTextField)this.edAdmin));
        this.edPwd.setDocument((Document)new batasInput(100).getKata((JTextField)this.edPwd));
        this.dlgjnkol.setLocationRelativeTo(null);
        this.dlgktkol.setLocationRelativeTo(null);
        this.dlgruang.setLocationRelativeTo(null);
        this.dlgdenda.setLocationRelativeTo(null);
        this.dlgpng.setLocationRelativeTo(null);
        this.dlgSetPinjam.setLocationRelativeTo(null);
        this.dlgAdmin.setLocationRelativeTo(null);
        this.dlgBayarDenda.setLocationRelativeTo(null);
        this.dlgSetting.setLocationRelativeTo(null);
        this.dlgSetUser.setLocationRelativeTo(null);
        this.dlgVakum.setLocationRelativeTo(null);
        this.dlgAbout.setLocationRelativeTo(null);
        this.dlgPusatData.setLocationRelativeTo(null);
        this.PanelFile.setVisible(false);
        this.PanelKoleksi.setVisible(false);
        this.PanelMaster.setVisible(false);
        this.PanelSetting.setVisible(false);
        this.PanelTransaksi.setVisible(false);
        this.posisi();
        this.DlgLogin.setSize(344, 187);
        this.DlgLogin.setVisible(false);
        this.DlgLogin.setLocationRelativeTo(null);
        this.PanelMenu.setVisible(false);
        final Calendar instance = Calendar.getInstance();
        this.lblTgl.setText(instance.get(5) + "/" + instance.get(2) + "/" + instance.get(1));
        try {
            final Statement statement = new koneksiDB().condb().createStatement();
            final ResultSet executeQuery = statement.executeQuery("select * from setting");
            while (executeQuery.next()) {
                final String string = executeQuery.getString(1);
                final String string2 = executeQuery.getString(2);
                this.jLabel8.setText("::( " + string + " )::");
                this.jLabel11.setText(string2);
            }
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error : Silahkan Set Aplikasi");
        }
    }
    
    private void initComponents() {
        this.DlgLogin = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.internalFrame3 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.edAdmin = new PasswordBox();
        this.edPwd = new PasswordBox();
        this.jLabel6 = new JLabel();
        this.BtnLogin = new Button();
        this.BtnCancel = new Button();
        this.PanelMenu = new PanelGray();
        this.backCari = new BackCari();
        this.jLabel2 = new JLabel();
        this.backCari1 = new BackCari();
        this.jLabel1 = new JLabel();
        this.scrollPane2 = new ScrollPane();
        this.jPanel1 = new JPanel();
        this.ChkMaster = new JCheckBox();
        this.PanelMaster = new JPanel();
        this.panel1 = new JPanel();
        this.BtnJnsKoleksi = new ButtonGlass();
        this.BtnKtgKoleksi = new ButtonGlass();
        this.BtnRuang = new ButtonGlass();
        this.BtnDenda = new ButtonGlass();
        this.BtnPengarang = new ButtonGlass();
        this.ChkFile = new JCheckBox();
        this.PanelFile = new JPanel();
        this.panel2 = new JPanel();
        this.BtnPetugas = new ButtonGlass();
        this.BtnAnggota = new ButtonGlass();
        this.BtnPenerbit = new ButtonGlass();
        this.ChkKoleksi = new JCheckBox();
        this.PanelKoleksi = new JPanel();
        this.panel3 = new JPanel();
        this.BtnKoleksi = new ButtonGlass();
        this.BtnInventaris = new ButtonGlass();
        this.ChkTransaksi = new JCheckBox();
        this.PanelTransaksi = new JPanel();
        this.panel4 = new JPanel();
        this.BtnBayar = new ButtonGlass();
        this.BtnSirkulasi = new ButtonGlass();
        this.ChkSetting = new JCheckBox();
        this.PanelSetting = new JPanel();
        this.panel5 = new JPanel();
        this.BtnSetPinjam = new ButtonGlass();
        this.BtnSetAdmin = new ButtonGlass();
        this.BtnSetAplikasi = new ButtonGlass();
        this.BtnSetUser = new ButtonGlass();
        this.BtnVakum = new ButtonGlass();
        this.Toolbar = new InternalFrame();
        this.BtnLog = new ButtonBig();
        this.jSeparator1 = new JSeparator();
        this.BtnToolKoleksi = new ButtonBig();
        this.BtnToolInv = new ButtonBig();
        this.jSeparator2 = new JSeparator();
        this.BtnToolBay = new ButtonBig();
        this.BtnToolSir = new ButtonBig();
        this.jSeparator3 = new JSeparator();
        this.BtnKeluar = new ButtonBig();
        this.PanelStatus = new InternalFrame();
        this.lblStts = new JLabel();
        this.jSeparator4 = new JSeparator();
        this.lblUser = new JLabel();
        this.jSeparator5 = new JSeparator();
        this.lblTgl = new JLabel();
        this.jSeparator6 = new JSeparator();
        this.jLabel7 = new JLabel();
        this.scrollPane1 = new ScrollPane();
        this.PanelUtama = new JPanel();
        this.panelGlass2 = new PanelGlass();
        this.jLabel8 = new JLabel();
        this.jLabel11 = new JLabel();
        this.MenuBar = new MenuBar();
        this.jMenu1 = new JMenu();
        this.MnLogin = new JMenuItem();
        this.jSeparator7 = new JPopupMenu.Separator();
        this.jSeparator8 = new JPopupMenu.Separator();
        this.MenuKeluar = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jMenu3 = new JMenu();
        this.DlgLogin.setDefaultCloseOperation(2);
        this.DlgLogin.setModal(true);
        this.DlgLogin.setName("DlgLogin");
        this.DlgLogin.setResizable(false);
        this.DlgLogin.setUndecorated(true);
        this.internalFrame1.setBorder(BorderFactory.createLineBorder(new Color(185, 20, 185)));
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(null);
        this.internalFrame3.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(153, 0, 153), 1, true), ":: Silahkan Anda Login ::", 0, 0, new Font("Book Antiqua", 2, 14), new Color(205, 214, 255)));
        this.internalFrame3.setName("internalFrame3");
        this.internalFrame3.setWarnaAtas(new Color(15, 0, 15));
        this.internalFrame3.setWarnaBawah(new Color(155, 0, 155));
        this.internalFrame3.setLayout(null);
        this.panelGlass1.setBackground(Color.lightGray);
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(153, 0, 153)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(204, 153, 255));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.jLabel4.setForeground(new Color(205, 214, 255));
        this.jLabel4.setText("ID User :");
        this.jLabel4.setName("jLabel4");
        this.panelGlass1.add((Component)this.jLabel4);
        this.jLabel4.setBounds(39, 12, 60, 23);
        this.jLabel5.setForeground(new Color(205, 214, 255));
        this.jLabel5.setText("Password :");
        this.jLabel5.setName("jLabel5");
        this.panelGlass1.add((Component)this.jLabel5);
        this.jLabel5.setBounds(30, 42, 70, 23);
        this.edAdmin.setForeground(new Color(205, 214, 255));
        this.edAdmin.setToolTipText("Silahkan masukkan ID Admin");
        this.edAdmin.setName("edAdmin");
        this.edAdmin.addKeyListener((KeyListener)new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent keyEvent) {
                frmUtama.this.edAdminKeyPressed(keyEvent);
            }
        });
        this.panelGlass1.add((Component)this.edAdmin);
        this.edAdmin.setBounds(85, 12, 220, 23);
        this.edPwd.setForeground(new Color(205, 214, 255));
        this.edPwd.setToolTipText("Silahkan masukkan password");
        this.edPwd.setName("edPwd");
        this.edPwd.addKeyListener((KeyListener)new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent keyEvent) {
                frmUtama.this.edPwdKeyPressed(keyEvent);
            }
        });
        this.panelGlass1.add((Component)this.edPwd);
        this.edPwd.setBounds(85, 40, 220, 23);
        this.internalFrame3.add((Component)this.panelGlass1);
        this.panelGlass1.setBounds(-1, 28, 342, 76);
        this.jLabel6.setIcon(new ImageIcon(this.getClass().getResource("/picture/LaST (Cobalt) Lock n Gear.png")));
        this.jLabel6.setName("jLabel6");
        this.internalFrame3.add(this.jLabel6);
        this.jLabel6.setBounds(120, 0, 135, 145);
        this.BtnLogin.setMnemonic('Z');
        this.BtnLogin.setText("Log-in");
        this.BtnLogin.setToolTipText("Alt+Z");
        this.BtnLogin.setCursor(new Cursor(12));
        this.BtnLogin.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnLogin.setName("BtnLogin");
        this.BtnLogin.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnLoginActionPerformed(actionEvent);
            }
        });
        this.internalFrame3.add((Component)this.BtnLogin);
        this.BtnLogin.setBounds(12, 117, 100, 30);
        this.BtnCancel.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCancel.setMnemonic('Y');
        this.BtnCancel.setText("Batal");
        this.BtnCancel.setToolTipText("Alt+Y");
        this.BtnCancel.setCursor(new Cursor(12));
        this.BtnCancel.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCancel.setName("BtnCancel");
        this.BtnCancel.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnCancelActionPerformed(actionEvent);
            }
        });
        this.internalFrame3.add((Component)this.BtnCancel);
        this.BtnCancel.setBounds(227, 117, 100, 30);
        this.internalFrame1.add(this.internalFrame3);
        this.internalFrame3.setBounds(2, 10, 340, 170);
        this.DlgLogin.getContentPane().add(this.internalFrame1, "Center");
        this.setDefaultCloseOperation(3);
        this.setTitle("::[ Demo Aplikasi Inventaris Perpus v.1 ]::");
        this.setBackground(new Color(0, 51, 153));
        this.setBounds(new Rectangle(0, 0, 0, 0));
        this.PanelMenu.setName("PanelMenu");
        this.PanelMenu.setPreferredSize(new Dimension(198, 198));
        this.PanelMenu.setLayout(new BorderLayout());
        this.backCari.setName("backCari");
        this.backCari.setPreferredSize(new Dimension(197, 22));
        this.backCari.setLayout(new BorderLayout());
        this.jLabel2.setForeground(new Color(255, 153, 204));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("  ~::::::::::< Menu Utama >::::::::::~  ");
        this.jLabel2.setName("jLabel2");
        this.backCari.add(this.jLabel2, "Center");
        this.PanelMenu.add(this.backCari, "First");
        this.backCari1.setName("backCari1");
        this.backCari1.setPreferredSize(new Dimension(197, 22));
        this.backCari1.setLayout(new BorderLayout());
        this.jLabel1.setForeground(new Color(255, 153, 204));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("~::--------------------------------------::~");
        this.jLabel1.setName("jLabel1");
        this.backCari1.add(this.jLabel1, "Center");
        this.PanelMenu.add(this.backCari1, "Last");
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.scrollPane2.setName("scrollPane2");
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setOpaque(false);
        this.ChkMaster.setBackground(new Color(70, 0, 70));
        this.ChkMaster.setForeground(new Color(255, 204, 0));
        this.ChkMaster.setMnemonic('M');
        this.ChkMaster.setText("  .: Master");
        this.ChkMaster.setBorder(new LineBorder(new Color(105, 0, 105), 1, true));
        this.ChkMaster.setBorderPainted(true);
        this.ChkMaster.setBorderPaintedFlat(true);
        this.ChkMaster.setCursor(new Cursor(12));
        this.ChkMaster.setFocusPainted(false);
        this.ChkMaster.setFocusable(false);
        this.ChkMaster.setHorizontalTextPosition(2);
        this.ChkMaster.setIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkMaster.setIconTextGap(122);
        this.ChkMaster.setName("ChkMaster");
        this.ChkMaster.setOpaque(true);
        this.ChkMaster.setPreferredSize(new Dimension(192, 20));
        this.ChkMaster.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkMaster.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkMaster.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkMaster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.ChkMasterActionPerformed(actionEvent);
            }
        });
        this.PanelMaster.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.PanelMaster.setName("PanelMaster");
        this.PanelMaster.setOpaque(false);
        this.PanelMaster.setPreferredSize(new Dimension(192, 25));
        this.PanelMaster.setLayout(new BorderLayout());
        this.panel1.setBackground(new Color(255, 255, 255));
        this.panel1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.panel1.setName("panel1");
        this.panel1.setOpaque(false);
        this.panel1.setLayout(new GridLayout(5, 0, 0, 2));
        this.BtnJnsKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnJnsKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/2.png")));
        this.BtnJnsKoleksi.setMnemonic('7');
        this.BtnJnsKoleksi.setText(" Jenis Barang");
        this.BtnJnsKoleksi.setToolTipText("Alt+7");
        this.BtnJnsKoleksi.setCursor(new Cursor(12));
        this.BtnJnsKoleksi.setEnabled(false);
        this.BtnJnsKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnJnsKoleksi.setHorizontalAlignment(2);
        this.BtnJnsKoleksi.setHorizontalTextPosition(4);
        this.BtnJnsKoleksi.setName("BtnJnsKoleksi");
        this.BtnJnsKoleksi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnJnsKoleksiActionPerformed(actionEvent);
            }
        });
        this.panel1.add((Component)this.BtnJnsKoleksi);
        this.BtnKtgKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnKtgKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/add_to_folder.png")));
        this.BtnKtgKoleksi.setMnemonic('8');
        this.BtnKtgKoleksi.setText("Kategori Barang");
        this.BtnKtgKoleksi.setToolTipText("Alt+8");
        this.BtnKtgKoleksi.setCursor(new Cursor(12));
        this.BtnKtgKoleksi.setEnabled(false);
        this.BtnKtgKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnKtgKoleksi.setHorizontalAlignment(2);
        this.BtnKtgKoleksi.setHorizontalTextPosition(4);
        this.BtnKtgKoleksi.setName("BtnKtgKoleksi");
        this.BtnKtgKoleksi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnKtgKoleksiActionPerformed(actionEvent);
            }
        });
        this.panel1.add((Component)this.BtnKtgKoleksi);
        this.BtnRuang.setForeground(new Color(205, 214, 255));
        this.BtnRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/17.png")));
        this.BtnRuang.setMnemonic('9');
        this.BtnRuang.setText(" Ruang");
        this.BtnRuang.setToolTipText("Alt+9");
        this.BtnRuang.setCursor(new Cursor(12));
        this.BtnRuang.setEnabled(false);
        this.BtnRuang.setGlassColor(new Color(223, 223, 255));
        this.BtnRuang.setHorizontalAlignment(2);
        this.BtnRuang.setHorizontalTextPosition(4);
        this.BtnRuang.setName("BtnRuang");
        this.BtnRuang.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnRuangActionPerformed(actionEvent);
            }
        });
        this.panel1.add((Component)this.BtnRuang);
        this.BtnDenda.setForeground(new Color(205, 214, 255));
        this.BtnDenda.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/budget24.png")));
        this.BtnDenda.setMnemonic('0');
        this.BtnDenda.setText("Denda");
        this.BtnDenda.setToolTipText("Alt+0");
        this.BtnDenda.setCursor(new Cursor(12));
        this.BtnDenda.setEnabled(false);
        this.BtnDenda.setGlassColor(new Color(223, 223, 255));
        this.BtnDenda.setHorizontalAlignment(2);
        this.BtnDenda.setHorizontalTextPosition(4);
        this.BtnDenda.setName("BtnDenda");
        this.BtnDenda.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnDendaActionPerformed(actionEvent);
            }
        });
        this.panel1.add((Component)this.BtnDenda);
        this.BtnPengarang.setForeground(new Color(205, 214, 255));
        this.BtnPengarang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/man1-24.png")));
        this.BtnPengarang.setMnemonic('A');
        this.BtnPengarang.setText("Merk/Type");
        this.BtnPengarang.setToolTipText("Alt+A");
        this.BtnPengarang.setCursor(new Cursor(12));
        this.BtnPengarang.setEnabled(false);
        this.BtnPengarang.setGlassColor(new Color(223, 223, 255));
        this.BtnPengarang.setHorizontalAlignment(2);
        this.BtnPengarang.setHorizontalTextPosition(4);
        this.BtnPengarang.setName("BtnPengarang");
        this.BtnPengarang.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnPengarangActionPerformed(actionEvent);
            }
        });
        this.panel1.add((Component)this.BtnPengarang);
        this.PanelMaster.add(this.panel1, "Center");
        this.ChkFile.setBackground(new Color(70, 0, 70));
        this.ChkFile.setForeground(new Color(255, 204, 0));
        this.ChkFile.setMnemonic('M');
        this.ChkFile.setText("  .: File");
        this.ChkFile.setBorder(new LineBorder(new Color(105, 0, 105), 1, true));
        this.ChkFile.setBorderPainted(true);
        this.ChkFile.setBorderPaintedFlat(true);
        this.ChkFile.setCursor(new Cursor(12));
        this.ChkFile.setFocusPainted(false);
        this.ChkFile.setFocusable(false);
        this.ChkFile.setHorizontalTextPosition(2);
        this.ChkFile.setIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkFile.setIconTextGap(139);
        this.ChkFile.setName("ChkFile");
        this.ChkFile.setOpaque(true);
        this.ChkFile.setPreferredSize(new Dimension(192, 20));
        this.ChkFile.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkFile.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkFile.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.ChkFileActionPerformed(actionEvent);
            }
        });
        this.PanelFile.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.PanelFile.setName("PanelFile");
        this.PanelFile.setOpaque(false);
        this.PanelFile.setPreferredSize(new Dimension(192, 25));
        this.PanelFile.setLayout(new BorderLayout());
        this.panel2.setBackground(new Color(255, 255, 255));
        this.panel2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.panel2.setForeground(new Color(255, 255, 255));
        this.panel2.setName("panel2");
        this.panel2.setOpaque(false);
        this.panel2.setLayout(new GridLayout(3, 0, 0, 2));
        this.BtnPetugas.setForeground(new Color(205, 214, 255));
        this.BtnPetugas.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Add patient.png")));
        this.BtnPetugas.setMnemonic('B');
        this.BtnPetugas.setText("Petugas");
        this.BtnPetugas.setToolTipText("Alt+B");
        this.BtnPetugas.setCursor(new Cursor(12));
        this.BtnPetugas.setEnabled(false);
        this.BtnPetugas.setGlassColor(new Color(223, 223, 255));
        this.BtnPetugas.setHorizontalAlignment(2);
        this.BtnPetugas.setHorizontalTextPosition(4);
        this.BtnPetugas.setName("BtnPetugas");
        this.BtnPetugas.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnPetugasActionPerformed(actionEvent);
            }
        });
        this.panel2.add((Component)this.BtnPetugas);
        this.BtnAnggota.setForeground(new Color(205, 214, 255));
        this.BtnAnggota.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/family24.png")));
        this.BtnAnggota.setMnemonic('C');
        this.BtnAnggota.setText("Peminjam");
        this.BtnAnggota.setToolTipText("Alt+C");
        this.BtnAnggota.setCursor(new Cursor(12));
        this.BtnAnggota.setEnabled(false);
        this.BtnAnggota.setGlassColor(new Color(223, 223, 255));
        this.BtnAnggota.setHorizontalAlignment(2);
        this.BtnAnggota.setHorizontalTextPosition(4);
        this.BtnAnggota.setName("BtnAnggota");
        this.BtnAnggota.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnAnggotaActionPerformed(actionEvent);
            }
        });
        this.panel2.add((Component)this.BtnAnggota);
        this.BtnPenerbit.setForeground(new Color(205, 214, 255));
        this.BtnPenerbit.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/home24.png")));
        this.BtnPenerbit.setMnemonic('D');
        this.BtnPenerbit.setText("Produsen Barang");
        this.BtnPenerbit.setToolTipText("Alt+D");
        this.BtnPenerbit.setCursor(new Cursor(12));
        this.BtnPenerbit.setEnabled(false);
        this.BtnPenerbit.setGlassColor(new Color(223, 223, 255));
        this.BtnPenerbit.setHorizontalAlignment(2);
        this.BtnPenerbit.setHorizontalTextPosition(4);
        this.BtnPenerbit.setName("BtnPenerbit");
        this.BtnPenerbit.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnPenerbitActionPerformed(actionEvent);
            }
        });
        this.panel2.add((Component)this.BtnPenerbit);
        this.PanelFile.add(this.panel2, "Center");
        this.ChkKoleksi.setBackground(new Color(70, 0, 70));
        this.ChkKoleksi.setForeground(new Color(255, 204, 0));
        this.ChkKoleksi.setMnemonic('M');
        this.ChkKoleksi.setText("  .: Koleksi");
        this.ChkKoleksi.setBorder(new LineBorder(new Color(105, 0, 105), 1, true));
        this.ChkKoleksi.setBorderPainted(true);
        this.ChkKoleksi.setBorderPaintedFlat(true);
        this.ChkKoleksi.setCursor(new Cursor(12));
        this.ChkKoleksi.setFocusPainted(false);
        this.ChkKoleksi.setFocusable(false);
        this.ChkKoleksi.setHorizontalTextPosition(2);
        this.ChkKoleksi.setIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkKoleksi.setIconTextGap(123);
        this.ChkKoleksi.setName("ChkKoleksi");
        this.ChkKoleksi.setOpaque(true);
        this.ChkKoleksi.setPreferredSize(new Dimension(192, 20));
        this.ChkKoleksi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkKoleksi.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkKoleksi.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkKoleksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.ChkKoleksiActionPerformed(actionEvent);
            }
        });
        this.PanelKoleksi.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.PanelKoleksi.setName("PanelKoleksi");
        this.PanelKoleksi.setOpaque(false);
        this.PanelKoleksi.setPreferredSize(new Dimension(192, 25));
        this.PanelKoleksi.setLayout(new BorderLayout());
        this.panel3.setBackground(new Color(255, 255, 255));
        this.panel3.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.panel3.setName("panel3");
        this.panel3.setOpaque(false);
        this.panel3.setLayout(new GridLayout(2, 0, 0, 2));
        this.BtnKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/shopping-bag24.png")));
        this.BtnKoleksi.setMnemonic('E');
        this.BtnKoleksi.setText("Barang");
        this.BtnKoleksi.setToolTipText("Alt+E");
        this.BtnKoleksi.setCursor(new Cursor(12));
        this.BtnKoleksi.setEnabled(false);
        this.BtnKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnKoleksi.setHorizontalAlignment(2);
        this.BtnKoleksi.setHorizontalTextPosition(4);
        this.BtnKoleksi.setName("BtnKoleksi");
        this.BtnKoleksi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnKoleksiActionPerformed(actionEvent);
            }
        });
        this.panel3.add((Component)this.BtnKoleksi);
        this.BtnInventaris.setForeground(new Color(205, 214, 255));
        this.BtnInventaris.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/search_page.png")));
        this.BtnInventaris.setMnemonic('F');
        this.BtnInventaris.setText("Inventaris");
        this.BtnInventaris.setToolTipText("Alt+F");
        this.BtnInventaris.setCursor(new Cursor(12));
        this.BtnInventaris.setEnabled(false);
        this.BtnInventaris.setGlassColor(new Color(223, 223, 255));
        this.BtnInventaris.setHorizontalAlignment(2);
        this.BtnInventaris.setHorizontalTextPosition(4);
        this.BtnInventaris.setName("BtnInventaris");
        this.BtnInventaris.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnInventarisActionPerformed(actionEvent);
            }
        });
        this.panel3.add((Component)this.BtnInventaris);
        this.PanelKoleksi.add(this.panel3, "Center");
        this.ChkTransaksi.setBackground(new Color(70, 0, 70));
        this.ChkTransaksi.setForeground(new Color(255, 204, 0));
        this.ChkTransaksi.setMnemonic('M');
        this.ChkTransaksi.setText("  .: Transaksi");
        this.ChkTransaksi.setBorder(new LineBorder(new Color(105, 0, 105), 1, true));
        this.ChkTransaksi.setBorderPainted(true);
        this.ChkTransaksi.setBorderPaintedFlat(true);
        this.ChkTransaksi.setCursor(new Cursor(12));
        this.ChkTransaksi.setFocusPainted(false);
        this.ChkTransaksi.setFocusable(false);
        this.ChkTransaksi.setHorizontalTextPosition(2);
        this.ChkTransaksi.setIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkTransaksi.setIconTextGap(110);
        this.ChkTransaksi.setName("ChkTransaksi");
        this.ChkTransaksi.setOpaque(true);
        this.ChkTransaksi.setPreferredSize(new Dimension(192, 20));
        this.ChkTransaksi.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkTransaksi.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkTransaksi.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.ChkTransaksiActionPerformed(actionEvent);
            }
        });
        this.PanelTransaksi.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.PanelTransaksi.setName("PanelTransaksi");
        this.PanelTransaksi.setOpaque(false);
        this.PanelTransaksi.setPreferredSize(new Dimension(192, 25));
        this.PanelTransaksi.setLayout(new BorderLayout());
        this.panel4.setBackground(new Color(255, 255, 255));
        this.panel4.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.panel4.setName("panel4");
        this.panel4.setOpaque(false);
        this.panel4.setLayout(new GridLayout(2, 0, 0, 2));
        this.BtnBayar.setForeground(new Color(205, 214, 255));
        this.BtnBayar.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Money-32x32.png")));
        this.BtnBayar.setMnemonic('G');
        this.BtnBayar.setText("Bayar Denda");
        this.BtnBayar.setToolTipText("Alt+G");
        this.BtnBayar.setCursor(new Cursor(12));
        this.BtnBayar.setEnabled(false);
        this.BtnBayar.setGlassColor(new Color(223, 223, 255));
        this.BtnBayar.setHorizontalAlignment(2);
        this.BtnBayar.setHorizontalTextPosition(4);
        this.BtnBayar.setName("BtnBayar");
        this.BtnBayar.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnBayarActionPerformed(actionEvent);
            }
        });
        this.panel4.add((Component)this.BtnBayar);
        this.BtnSirkulasi.setForeground(new Color(205, 214, 255));
        this.BtnSirkulasi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/42a.png")));
        this.BtnSirkulasi.setMnemonic('H');
        this.BtnSirkulasi.setText("Sirkulasi");
        this.BtnSirkulasi.setToolTipText("Alt+H");
        this.BtnSirkulasi.setCursor(new Cursor(12));
        this.BtnSirkulasi.setEnabled(false);
        this.BtnSirkulasi.setGlassColor(new Color(223, 223, 255));
        this.BtnSirkulasi.setHorizontalAlignment(2);
        this.BtnSirkulasi.setHorizontalTextPosition(4);
        this.BtnSirkulasi.setIconTextGap(8);
        this.BtnSirkulasi.setName("BtnSirkulasi");
        this.BtnSirkulasi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnSirkulasiActionPerformed(actionEvent);
            }
        });
        this.panel4.add((Component)this.BtnSirkulasi);
        this.PanelTransaksi.add(this.panel4, "Center");
        this.ChkSetting.setBackground(new Color(70, 0, 70));
        this.ChkSetting.setForeground(new Color(255, 204, 0));
        this.ChkSetting.setMnemonic('M');
        this.ChkSetting.setText("  .: Setting");
        this.ChkSetting.setBorder(new LineBorder(new Color(105, 0, 105), 1, true));
        this.ChkSetting.setBorderPainted(true);
        this.ChkSetting.setBorderPaintedFlat(true);
        this.ChkSetting.setCursor(new Cursor(12));
        this.ChkSetting.setFocusPainted(false);
        this.ChkSetting.setFocusable(false);
        this.ChkSetting.setHorizontalTextPosition(2);
        this.ChkSetting.setIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkSetting.setIconTextGap(121);
        this.ChkSetting.setName("ChkSetting");
        this.ChkSetting.setOpaque(true);
        this.ChkSetting.setPreferredSize(new Dimension(192, 20));
        this.ChkSetting.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/129.png")));
        this.ChkSetting.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkSetting.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/130.png")));
        this.ChkSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.ChkSettingActionPerformed(actionEvent);
            }
        });
        this.PanelSetting.setBorder(BorderFactory.createLineBorder(new Color(105, 0, 105)));
        this.PanelSetting.setName("PanelSetting");
        this.PanelSetting.setOpaque(false);
        this.PanelSetting.setPreferredSize(new Dimension(192, 25));
        this.PanelSetting.setLayout(new BorderLayout());
        this.panel5.setBackground(new Color(255, 255, 255));
        this.panel5.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.panel5.setName("panel5");
        this.panel5.setOpaque(false);
        this.panel5.setLayout(new GridLayout(5, 0, 0, 2));
        this.BtnSetPinjam.setForeground(new Color(205, 214, 255));
        this.BtnSetPinjam.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/63.png")));
        this.BtnSetPinjam.setMnemonic('I');
        this.BtnSetPinjam.setText("Setup Pinjam");
        this.BtnSetPinjam.setToolTipText("Alt+I");
        this.BtnSetPinjam.setCursor(new Cursor(12));
        this.BtnSetPinjam.setEnabled(false);
        this.BtnSetPinjam.setGlassColor(new Color(223, 223, 255));
        this.BtnSetPinjam.setHorizontalAlignment(2);
        this.BtnSetPinjam.setHorizontalTextPosition(4);
        this.BtnSetPinjam.setIconTextGap(8);
        this.BtnSetPinjam.setName("BtnSetPinjam");
        this.BtnSetPinjam.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnSetPinjamActionPerformed(actionEvent);
            }
        });
        this.panel5.add((Component)this.BtnSetPinjam);
        this.BtnSetAdmin.setForeground(new Color(205, 214, 255));
        this.BtnSetAdmin.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/85.png")));
        this.BtnSetAdmin.setMnemonic('J');
        this.BtnSetAdmin.setText("Setup Admin");
        this.BtnSetAdmin.setToolTipText("Alt+J");
        this.BtnSetAdmin.setCursor(new Cursor(12));
        this.BtnSetAdmin.setEnabled(false);
        this.BtnSetAdmin.setGlassColor(new Color(223, 223, 255));
        this.BtnSetAdmin.setHorizontalAlignment(2);
        this.BtnSetAdmin.setHorizontalTextPosition(4);
        this.BtnSetAdmin.setIconTextGap(8);
        this.BtnSetAdmin.setName("BtnSetAdmin");
        this.BtnSetAdmin.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnSetAdminActionPerformed(actionEvent);
            }
        });
        this.panel5.add((Component)this.BtnSetAdmin);
        this.BtnSetAplikasi.setForeground(new Color(205, 214, 255));
        this.BtnSetAplikasi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/73.png")));
        this.BtnSetAplikasi.setMnemonic('K');
        this.BtnSetAplikasi.setText("Setup Aplikasi");
        this.BtnSetAplikasi.setToolTipText("Alt+K");
        this.BtnSetAplikasi.setCursor(new Cursor(12));
        this.BtnSetAplikasi.setEnabled(false);
        this.BtnSetAplikasi.setGlassColor(new Color(223, 223, 255));
        this.BtnSetAplikasi.setHorizontalAlignment(2);
        this.BtnSetAplikasi.setHorizontalTextPosition(4);
        this.BtnSetAplikasi.setIconTextGap(8);
        this.BtnSetAplikasi.setName("BtnSetAplikasi");
        this.BtnSetAplikasi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnSetAplikasiActionPerformed(actionEvent);
            }
        });
        this.panel5.add((Component)this.BtnSetAplikasi);
        this.BtnSetUser.setForeground(new Color(205, 214, 255));
        this.BtnSetUser.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/users.png")));
        this.BtnSetUser.setMnemonic('L');
        this.BtnSetUser.setText("Setup User");
        this.BtnSetUser.setToolTipText("Alt+L");
        this.BtnSetUser.setCursor(new Cursor(12));
        this.BtnSetUser.setEnabled(false);
        this.BtnSetUser.setGlassColor(new Color(223, 223, 255));
        this.BtnSetUser.setHorizontalAlignment(2);
        this.BtnSetUser.setHorizontalTextPosition(4);
        this.BtnSetUser.setName("BtnSetUser");
        this.BtnSetUser.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnSetUserActionPerformed(actionEvent);
            }
        });
        this.panel5.add((Component)this.BtnSetUser);
        this.BtnVakum.setForeground(new Color(205, 214, 255));
        this.BtnVakum.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/delete_folder.png")));
        this.BtnVakum.setMnemonic('M');
        this.BtnVakum.setText("Vakum Tabel");
        this.BtnVakum.setToolTipText("Alt+M");
        this.BtnVakum.setCursor(new Cursor(12));
        this.BtnVakum.setEnabled(false);
        this.BtnVakum.setGlassColor(new Color(223, 223, 255));
        this.BtnVakum.setHorizontalAlignment(2);
        this.BtnVakum.setHorizontalTextPosition(4);
        this.BtnVakum.setName("BtnVakum");
        this.BtnVakum.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnVakumActionPerformed(actionEvent);
            }
        });
        this.panel5.add((Component)this.BtnVakum);
        this.PanelSetting.add(this.panel5, "Center");
        final GroupLayout layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.ChkMaster, -2, -1, -2).addComponent(this.PanelMaster, -2, -1, -2).addComponent(this.ChkFile, -2, -1, -2).addComponent(this.PanelFile, -2, -1, -2).addComponent(this.ChkKoleksi, -2, -1, -2).addComponent(this.PanelKoleksi, -2, -1, -2).addComponent(this.ChkTransaksi, -2, -1, -2).addComponent(this.PanelTransaksi, -2, -1, -2).addComponent(this.ChkSetting, -2, -1, -2).addComponent(this.PanelSetting, -2, -1, -2))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.ChkMaster, -2, -1, -2).addComponent(this.PanelMaster, -2, 150, -2).addGap(2, 2, 2).addComponent(this.ChkFile, -2, -1, -2).addComponent(this.PanelFile, -2, 90, -2).addGap(2, 2, 2).addComponent(this.ChkKoleksi, -2, -1, -2).addComponent(this.PanelKoleksi, -2, 60, -2).addGap(2, 2, 2).addComponent(this.ChkTransaksi, -2, -1, -2).addComponent(this.PanelTransaksi, -2, 60, -2).addGap(2, 2, 2).addComponent(this.ChkSetting, -2, -1, -2).addComponent(this.PanelSetting, -2, 150, -2)));
        this.scrollPane2.setViewportView(this.jPanel1);
        this.PanelMenu.add(this.scrollPane2, "Center");
        this.getContentPane().add(this.PanelMenu, "West");
        this.Toolbar.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 51)));
        this.Toolbar.setName("Toolbar");
        this.Toolbar.setPreferredSize(new Dimension(40, 53));
        this.Toolbar.setWarnaAtas(new Color(185, 20, 185));
        this.Toolbar.setWarnaBawah(new Color(15, 0, 15));
        this.Toolbar.setLayout(new FlowLayout(0, 1, 1));
        this.BtnLog.setBackground(new Color(0, 0, 102));
        this.BtnLog.setForeground(new Color(204, 255, 255));
        this.BtnLog.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/login_32.png")));
        this.BtnLog.setMnemonic('1');
        this.BtnLog.setText("Log In");
        this.BtnLog.setToolTipText("Alt+1");
        this.BtnLog.setCursor(new Cursor(12));
        this.BtnLog.setFont(new Font("Tahoma", 0, 11));
        this.BtnLog.setHorizontalTextPosition(4);
        this.BtnLog.setIconTextGap(1);
        this.BtnLog.setName("BtnLog");
        this.BtnLog.setPreferredSize(new Dimension(120, 50));
        this.BtnLog.setVerticalTextPosition(0);
        this.BtnLog.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnLogActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnLog);
        this.jSeparator1.setBackground(new Color(185, 20, 185));
        this.jSeparator1.setForeground(new Color(185, 20, 185));
        this.jSeparator1.setOrientation(1);
        this.jSeparator1.setName("jSeparator1");
        this.jSeparator1.setPreferredSize(new Dimension(1, 42));
        this.Toolbar.add(this.jSeparator1);
        this.BtnToolKoleksi.setBackground(new Color(0, 0, 102));
        this.BtnToolKoleksi.setForeground(new Color(204, 255, 255));
        this.BtnToolKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/shopping-bag24.png")));
        this.BtnToolKoleksi.setMnemonic('2');
        this.BtnToolKoleksi.setText("Barang");
        this.BtnToolKoleksi.setToolTipText("Alt+2");
        this.BtnToolKoleksi.setCursor(new Cursor(12));
        this.BtnToolKoleksi.setEnabled(false);
        this.BtnToolKoleksi.setFont(new Font("Tahoma", 0, 11));
        this.BtnToolKoleksi.setHorizontalTextPosition(4);
        this.BtnToolKoleksi.setIconTextGap(1);
        this.BtnToolKoleksi.setName("BtnToolKoleksi");
        this.BtnToolKoleksi.setPreferredSize(new Dimension(120, 50));
        this.BtnToolKoleksi.setVerticalTextPosition(0);
        this.BtnToolKoleksi.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnToolKoleksiActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnToolKoleksi);
        this.BtnToolInv.setBackground(new Color(0, 0, 102));
        this.BtnToolInv.setForeground(new Color(204, 255, 255));
        this.BtnToolInv.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/search_page.png")));
        this.BtnToolInv.setMnemonic('3');
        this.BtnToolInv.setText("Inventaris");
        this.BtnToolInv.setToolTipText("Alt+3");
        this.BtnToolInv.setCursor(new Cursor(12));
        this.BtnToolInv.setEnabled(false);
        this.BtnToolInv.setFont(new Font("Tahoma", 0, 11));
        this.BtnToolInv.setHorizontalTextPosition(4);
        this.BtnToolInv.setIconTextGap(1);
        this.BtnToolInv.setName("BtnToolInv");
        this.BtnToolInv.setPreferredSize(new Dimension(120, 50));
        this.BtnToolInv.setVerticalTextPosition(0);
        this.BtnToolInv.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnToolInvActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnToolInv);
        this.jSeparator2.setBackground(new Color(185, 20, 185));
        this.jSeparator2.setForeground(new Color(185, 20, 185));
        this.jSeparator2.setOrientation(1);
        this.jSeparator2.setName("jSeparator2");
        this.jSeparator2.setPreferredSize(new Dimension(1, 42));
        this.Toolbar.add(this.jSeparator2);
        this.BtnToolBay.setBackground(new Color(0, 0, 102));
        this.BtnToolBay.setForeground(new Color(204, 255, 255));
        this.BtnToolBay.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Money-32x32.png")));
        this.BtnToolBay.setMnemonic('4');
        this.BtnToolBay.setText("Bayar Denda");
        this.BtnToolBay.setToolTipText("Alt+4");
        this.BtnToolBay.setCursor(new Cursor(12));
        this.BtnToolBay.setEnabled(false);
        this.BtnToolBay.setFont(new Font("Tahoma", 0, 11));
        this.BtnToolBay.setHorizontalTextPosition(4);
        this.BtnToolBay.setIconTextGap(1);
        this.BtnToolBay.setName("BtnToolBay");
        this.BtnToolBay.setPreferredSize(new Dimension(120, 50));
        this.BtnToolBay.setVerticalTextPosition(0);
        this.BtnToolBay.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnToolBayActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnToolBay);
        this.BtnToolSir.setBackground(new Color(0, 0, 102));
        this.BtnToolSir.setForeground(new Color(204, 255, 255));
        this.BtnToolSir.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/42a.png")));
        this.BtnToolSir.setMnemonic('5');
        this.BtnToolSir.setText("Sirkulasi");
        this.BtnToolSir.setToolTipText("Alt+5");
        this.BtnToolSir.setCursor(new Cursor(12));
        this.BtnToolSir.setEnabled(false);
        this.BtnToolSir.setFont(new Font("Tahoma", 0, 11));
        this.BtnToolSir.setHorizontalTextPosition(4);
        this.BtnToolSir.setIconTextGap(1);
        this.BtnToolSir.setName("BtnToolSir");
        this.BtnToolSir.setPreferredSize(new Dimension(120, 50));
        this.BtnToolSir.setVerticalTextPosition(0);
        this.BtnToolSir.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnToolSirActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnToolSir);
        this.jSeparator3.setBackground(new Color(185, 20, 185));
        this.jSeparator3.setForeground(new Color(185, 20, 185));
        this.jSeparator3.setOrientation(1);
        this.jSeparator3.setName("jSeparator3");
        this.jSeparator3.setPreferredSize(new Dimension(1, 42));
        this.Toolbar.add(this.jSeparator3);
        this.BtnKeluar.setBackground(new Color(0, 0, 102));
        this.BtnKeluar.setForeground(new Color(204, 255, 255));
        this.BtnKeluar.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/delete_item_32.png")));
        this.BtnKeluar.setMnemonic('6');
        this.BtnKeluar.setText("Keluar");
        this.BtnKeluar.setToolTipText("Alt+6");
        this.BtnKeluar.setCursor(new Cursor(12));
        this.BtnKeluar.setFont(new Font("Tahoma", 0, 11));
        this.BtnKeluar.setHorizontalTextPosition(4);
        this.BtnKeluar.setIconTextGap(1);
        this.BtnKeluar.setName("BtnKeluar");
        this.BtnKeluar.setPreferredSize(new Dimension(120, 50));
        this.BtnKeluar.setVerticalTextPosition(0);
        this.BtnKeluar.addActionListener((ActionListener)new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.BtnKeluarActionPerformed(actionEvent);
            }
        });
        this.Toolbar.add((Component)this.BtnKeluar);
        this.getContentPane().add(this.Toolbar, "First");
        this.PanelStatus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 51)));
        this.PanelStatus.setName("PanelStatus");
        this.PanelStatus.setPreferredSize(new Dimension(26, 26));
        this.PanelStatus.setWarnaAtas(new Color(15, 0, 15));
        this.PanelStatus.setWarnaBawah(new Color(185, 20, 185));
        this.PanelStatus.setLayout(new FlowLayout(0));
        this.lblStts.setForeground(new Color(255, 204, 255));
        this.lblStts.setHorizontalAlignment(0);
        this.lblStts.setText("Status Admin :");
        this.lblStts.setHorizontalTextPosition(0);
        this.lblStts.setName("lblStts");
        this.lblStts.setPreferredSize(new Dimension(120, 15));
        this.PanelStatus.add(this.lblStts);
        this.jSeparator4.setBackground(new Color(185, 20, 185));
        this.jSeparator4.setForeground(new Color(185, 20, 185));
        this.jSeparator4.setOrientation(1);
        this.jSeparator4.setName("jSeparator4");
        this.jSeparator4.setPreferredSize(new Dimension(5, 15));
        this.PanelStatus.add(this.jSeparator4);
        this.lblUser.setForeground(new Color(255, 204, 255));
        this.lblUser.setHorizontalAlignment(0);
        this.lblUser.setText("Log Out");
        this.lblUser.setHorizontalTextPosition(0);
        this.lblUser.setName("lblUser");
        this.lblUser.setPreferredSize(new Dimension(150, 15));
        this.PanelStatus.add(this.lblUser);
        this.jSeparator5.setBackground(new Color(185, 20, 185));
        this.jSeparator5.setForeground(new Color(185, 20, 185));
        this.jSeparator5.setOrientation(1);
        this.jSeparator5.setName("jSeparator5");
        this.jSeparator5.setPreferredSize(new Dimension(5, 15));
        this.PanelStatus.add(this.jSeparator5);
        this.lblTgl.setForeground(new Color(255, 204, 255));
        this.lblTgl.setHorizontalAlignment(0);
        this.lblTgl.setText("Tanggal");
        this.lblTgl.setHorizontalTextPosition(0);
        this.lblTgl.setName("lblTgl");
        this.lblTgl.setPreferredSize(new Dimension(150, 15));
        this.PanelStatus.add(this.lblTgl);
        this.jSeparator6.setBackground(new Color(185, 20, 185));
        this.jSeparator6.setForeground(new Color(185, 20, 185));
        this.jSeparator6.setOrientation(1);
        this.jSeparator6.setName("jSeparator6");
        this.jSeparator6.setPreferredSize(new Dimension(5, 15));
        this.PanelStatus.add(this.jSeparator6);
        this.jLabel7.setFont(new Font("Book Antiqua", 2, 13));
        this.jLabel7.setForeground(new Color(255, 204, 255));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-16x16.png")));
        this.jLabel7.setText("http://www.Corcobrain.blogspot.com//");
        this.jLabel7.setHorizontalTextPosition(4);
        this.jLabel7.setIconTextGap(3);
        this.jLabel7.setName("jLabel7");
        this.jLabel7.setPreferredSize(new Dimension(547, 16));
        this.PanelStatus.add(this.jLabel7);
        this.getContentPane().add(this.PanelStatus, "Last");
        this.scrollPane1.setBackground(new Color(0, 51, 102));
        this.scrollPane1.setBorder(null);
        this.scrollPane1.setForeground(new Color(0, 51, 102));
        this.scrollPane1.setName("scrollPane1");
        this.scrollPane1.setOpaque(true);
        this.PanelUtama.setBackground(new Color(0, 0, 40));
        this.PanelUtama.setForeground(new Color(205, 214, 255));
        this.PanelUtama.setName("PanelUtama");
        this.PanelUtama.setLayout(new BorderLayout());
        this.panelGlass2.setOpaqueImage(false);
        this.panelGlass2.setPreferredSize(new Dimension(200, 140));
        this.panelGlass2.setRound(false);
        this.panelGlass2.setWarna(new Color(153, 153, 255));
        this.panelGlass2.setLayout((LayoutManager)null);
        this.jLabel8.setFont(new Font("Monotype Corsiva", 2, 30));
        this.jLabel8.setForeground(new Color(255, 153, 204));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setIcon(new ImageIcon(this.getClass().getResource("/picture/LaST (Cobalt) INF-INI File.png")));
        this.jLabel8.setText("::(  http://www.corcobrain.blogspot.com// )::");
        this.jLabel8.setHorizontalTextPosition(4);
        this.jLabel8.setName("jLabel8");
        this.panelGlass2.add((Component)this.jLabel8);
        this.jLabel8.setBounds(0, 0, 710, 120);
        this.jLabel11.setForeground(new Color(255, 153, 204));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("Sekarsuli Rt03/Rw03 Kecamatan Klaten Utara, Klaten, Jawa Tengah. 57432");
        this.jLabel11.setHorizontalTextPosition(0);
        this.jLabel11.setName("jLabel11");
        this.jLabel11.setPreferredSize(new Dimension(430, 15));
        this.panelGlass2.add((Component)this.jLabel11);
        this.jLabel11.setBounds(170, 90, 510, 15);
        this.PanelUtama.add((Component)this.panelGlass2, "Last");
        this.scrollPane1.setViewportView(this.PanelUtama);
        this.getContentPane().add(this.scrollPane1, "Center");
        this.MenuBar.setBackground(new Color(0, 0, 0));
        this.MenuBar.setBorder(null);
        this.MenuBar.setForeground(new Color(255, 204, 255));
        this.MenuBar.setName("MenuBar");
        this.MenuBar.setPreferredSize(new Dimension(227, 27));
        this.jMenu1.setBackground(new Color(20, 0, 20));
        this.jMenu1.setBorder(null);
        this.jMenu1.setForeground(new Color(255, 204, 255));
        this.jMenu1.setText("Program");
        this.jMenu1.setFont(new Font("Calibri", 0, 12));
        this.jMenu1.setName("jMenu1");
        this.MnLogin.setBackground(new Color(20, 0, 20));
        this.MnLogin.setFont(new Font("Calibri", 0, 12));
        this.MnLogin.setForeground(new Color(255, 204, 255));
        this.MnLogin.setIcon(new ImageIcon(this.getClass().getResource("/picture/login_32.png")));
        this.MnLogin.setText("Log-In");
        this.MnLogin.setBorderPainted(true);
        this.MnLogin.setName("MnLogin");
        this.MnLogin.setPreferredSize(new Dimension(200, 35));
        this.MnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.MnLoginActionPerformed(actionEvent);
            }
        });
        this.jMenu1.add(this.MnLogin);
        this.jSeparator7.setBackground(new Color(155, 0, 155));
        this.jSeparator7.setForeground(new Color(155, 0, 155));
        this.jSeparator7.setName("jSeparator7");
        this.jSeparator7.setPreferredSize(new Dimension(0, 1));
        this.jMenu1.add(this.jSeparator7);
        this.jSeparator8.setBackground(new Color(155, 0, 155));
        this.jSeparator8.setForeground(new Color(155, 0, 155));
        this.jSeparator8.setName("jSeparator8");
        this.jSeparator8.setPreferredSize(new Dimension(0, 1));
        this.jMenu1.add(this.jSeparator8);
        this.MenuKeluar.setBackground(new Color(20, 0, 20));
        this.MenuKeluar.setFont(new Font("Calibri", 0, 12));
        this.MenuKeluar.setForeground(new Color(255, 204, 255));
        this.MenuKeluar.setIcon(new ImageIcon(this.getClass().getResource("/picture/delete_item_32.png")));
        this.MenuKeluar.setText("Keluar");
        this.MenuKeluar.setBorderPainted(true);
        this.MenuKeluar.setName("MenuKeluar");
        this.MenuKeluar.setPreferredSize(new Dimension(200, 35));
        this.MenuKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.MenuKeluarActionPerformed(actionEvent);
            }
        });
        this.jMenu1.add(this.MenuKeluar);
        this.MenuBar.add(this.jMenu1);
        this.jMenu2.setBackground(new Color(20, 0, 20));
        this.jMenu2.setBorder(null);
        this.jMenu2.setForeground(new Color(255, 204, 255));
        this.jMenu2.setText("Pencarian");
        this.jMenu2.setFont(new Font("Calibri", 0, 12));
        this.jMenu2.setName("jMenu2");
        this.jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent mouseEvent) {
                frmUtama.this.jMenu2MouseClicked(mouseEvent);
            }
        });
        this.jMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.jMenu2ActionPerformed(actionEvent);
            }
        });
        this.MenuBar.add(this.jMenu2);
        this.jMenu3.setBackground(new Color(20, 0, 20));
        this.jMenu3.setBorder(null);
        this.jMenu3.setForeground(new Color(255, 204, 255));
        this.jMenu3.setText("About Program");
        this.jMenu3.setFont(new Font("Calibri", 0, 12));
        this.jMenu3.setName("jMenu3");
        this.jMenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent mouseEvent) {
                frmUtama.this.jMenu3MouseClicked(mouseEvent);
            }
        });
        this.jMenu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                frmUtama.this.jMenu3ActionPerformed(actionEvent);
            }
        });
        this.MenuBar.add(this.jMenu3);
        this.setJMenuBar(this.MenuBar);
        this.pack();
    }
    
    private void ChkMasterActionPerformed(final ActionEvent actionEvent) {
        this.mnKlik(this.ChkMaster, this.PanelMaster);
    }
    
    private void BtnJnsKoleksiActionPerformed(final ActionEvent actionEvent) {
        this.dlgjnkol.tampil();
        this.dlgjnkol.emptTeks();
        this.dlgjnkol.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnKtgKoleksiActionPerformed(final ActionEvent actionEvent) {
        this.dlgktkol.tampilKtg();
        this.dlgktkol.emptTeks();
        this.dlgktkol.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnRuangActionPerformed(final ActionEvent actionEvent) {
        this.dlgruang.tampilRuang();
        this.dlgruang.emptTeks();
        this.dlgruang.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnDendaActionPerformed(final ActionEvent actionEvent) {
        this.dlgdenda.tampil();
        this.dlgdenda.emptTeks();
        this.dlgdenda.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnPengarangActionPerformed(final ActionEvent actionEvent) {
        this.dlgpng.tampilPng();
        this.dlgpng.emptTeksPng();
        this.dlgpng.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnLogActionPerformed(final ActionEvent actionEvent) {
        if (this.BtnLog.getText().trim().equals("Log Out")) {
            this.BtnJnsKoleksi.setEnabled(false);
            this.BtnKtgKoleksi.setEnabled(false);
            this.BtnRuang.setEnabled(false);
            this.BtnDenda.setEnabled(false);
            this.BtnPengarang.setEnabled(false);
            this.BtnPetugas.setEnabled(false);
            this.BtnAnggota.setEnabled(false);
            this.BtnPenerbit.setEnabled(false);
            this.BtnKoleksi.setEnabled(false);
            this.BtnInventaris.setEnabled(false);
            this.BtnBayar.setEnabled(false);
            this.BtnSirkulasi.setEnabled(false);
            this.BtnSetPinjam.setEnabled(false);
            this.BtnSetAplikasi.setEnabled(false);
            this.BtnSetUser.setEnabled(false);
            this.BtnSetAdmin.setEnabled(false);
            this.BtnVakum.setEnabled(false);
            this.BtnToolBay.setEnabled(false);
            this.BtnToolInv.setEnabled(false);
            this.BtnToolKoleksi.setEnabled(false);
            this.BtnToolSir.setEnabled(false);
            this.dlgAdmin.dispose();
            this.dlgAnggota.dispose();
            this.dlgBayarDenda.dispose();
            this.dlgdenda.dispose();
            this.dlgInventaris.dispose();
            this.dlgjnkol.dispose();
            this.dlgktkol.dispose();
            this.dlgKoleksi.dispose();
            this.dlgPenerbit.dispose();
            this.dlgpng.dispose();
            this.dlgPetugas.dispose();
            this.dlgruang.dispose();
            this.dlgSetPinjam.dispose();
            this.dlgSetUser.dispose();
            this.dlgSetting.dispose();
            this.dlgSirkulasi.dispose();
            this.dlgVakum.dispose();
            this.edAdmin.setText("");
            this.edPwd.setText("");
            this.BtnLog.setText("Log In");
            this.MnLogin.setText("Log In");
            this.lblStts.setText("Status Admin : ");
            this.lblUser.setText("Log Out");
            this.PanelMenu.setVisible(false);
        }
        else if (this.BtnLog.getText().trim().equals("Log In")) {
            this.DlgLogin.setVisible(this.rootPaneCheckingEnabled);
            this.edAdmin.requestFocus();
        }
    }
    
    private void BtnToolKoleksiActionPerformed(final ActionEvent actionEvent) {
        this.BtnKoleksiActionPerformed(actionEvent);
    }
    
    private void BtnToolInvActionPerformed(final ActionEvent actionEvent) {
        this.BtnInventarisActionPerformed(actionEvent);
    }
    
    private void BtnToolBayActionPerformed(final ActionEvent actionEvent) {
        this.BtnBayarActionPerformed(actionEvent);
    }
    
    private void BtnToolSirActionPerformed(final ActionEvent actionEvent) {
        this.BtnSirkulasiActionPerformed(actionEvent);
    }
    
    private void BtnKeluarActionPerformed(final ActionEvent actionEvent) {
        if (JOptionPane.showConfirmDialog(null, "Yakin anda mau keluar dari aplikasi ini ????", "Konfirmasi", 0) == 0) {
            this.dispose();
            System.exit(0);
        }
    }
    
    private void ChkFileActionPerformed(final ActionEvent actionEvent) {
        this.mnKlik(this.ChkFile, this.PanelFile);
    }
    
    private void BtnPetugasActionPerformed(final ActionEvent actionEvent) {
        this.dlgPetugas.tampil();
        this.dlgPetugas.focus();
        this.dlgPetugas.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgPetugas.setLocationRelativeTo(this.PanelUtama);
        this.dlgPetugas.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnAnggotaActionPerformed(final ActionEvent actionEvent) {
        this.dlgAnggota.tampil("");
        this.dlgAnggota.focus();
        this.dlgAnggota.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgAnggota.setLocationRelativeTo(this.PanelUtama);
        this.dlgAnggota.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnPenerbitActionPerformed(final ActionEvent actionEvent) {
        this.dlgPenerbit.tampil();
        this.dlgPenerbit.focus();
        this.dlgPenerbit.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgPenerbit.setLocationRelativeTo(this.PanelUtama);
        this.dlgPenerbit.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void ChkKoleksiActionPerformed(final ActionEvent actionEvent) {
        this.mnKlik(this.ChkKoleksi, this.PanelKoleksi);
    }
    
    private void BtnKoleksiActionPerformed(final ActionEvent actionEvent) {
        this.dlgKoleksi.tampil("");
        this.dlgKoleksi.focus();
        this.dlgKoleksi.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgKoleksi.setLocationRelativeTo(this.PanelUtama);
        this.dlgKoleksi.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnInventarisActionPerformed(final ActionEvent actionEvent) {
        this.dlgInventaris.tampil("");
        this.dlgInventaris.focus();
        this.dlgInventaris.LoadCombo();
        this.dlgInventaris.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgInventaris.setLocationRelativeTo(this.PanelUtama);
        this.dlgInventaris.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void ChkTransaksiActionPerformed(final ActionEvent actionEvent) {
        this.mnKlik(this.ChkTransaksi, this.PanelTransaksi);
    }
    
    private void BtnBayarActionPerformed(final ActionEvent actionEvent) {
        this.dlgBayarDenda.plhTampil();
        this.dlgBayarDenda.LoadCombo();
        this.dlgBayarDenda.isSetDenda();
        this.dlgBayarDenda.emptTeks();
        this.dlgBayarDenda.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnSirkulasiActionPerformed(final ActionEvent actionEvent) {
        this.dlgSirkulasi.tampil("");
        this.dlgSirkulasi.setSize(this.PanelUtama.getWidth(), this.PanelUtama.getHeight());
        this.dlgSirkulasi.setLocationRelativeTo(this.PanelUtama);
        this.dlgSirkulasi.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void ChkSettingActionPerformed(final ActionEvent actionEvent) {
        this.mnKlik(this.ChkSetting, this.PanelSetting);
    }
    
    private void BtnSetPinjamActionPerformed(final ActionEvent actionEvent) {
        this.dlgSetPinjam.tampil();
        this.dlgSetPinjam.emptTeks();
        this.dlgSetPinjam.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnSetAdminActionPerformed(final ActionEvent actionEvent) {
        this.dlgAdmin.tampil();
        this.dlgAdmin.emptTeks();
        this.dlgAdmin.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnSetAplikasiActionPerformed(final ActionEvent actionEvent) {
        this.dlgSetting.tampil();
        this.dlgSetting.emptTeks();
        this.dlgSetting.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnSetUserActionPerformed(final ActionEvent actionEvent) {
        this.dlgSetUser.tampil();
        this.dlgSetUser.emptTeks();
        this.dlgSetUser.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void BtnVakumActionPerformed(final ActionEvent actionEvent) {
        this.dlgVakum.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void MenuKeluarActionPerformed(final ActionEvent actionEvent) {
        this.BtnKeluarActionPerformed(actionEvent);
    }
    
    private void edAdminKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCancel, (JTextField)this.edPwd);
    }
    
    private void edPwdKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.edAdmin, (JButton)this.BtnLogin);
    }
    
    private void BtnLoginActionPerformed(final ActionEvent actionEvent) {
        if (this.edAdmin.getText().toString().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.edAdmin, "ID Admin");
        }
        else if (this.edPwd.getText().toString().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.edPwd, "Password");
        }
        else {
            try {
                final Connection condb = new koneksiDB().condb();
                final Statement statement = condb.createStatement();
                final Statement statement2 = condb.createStatement();
                final ResultSet executeQuery = statement.executeQuery("select * from admin where id_admin=AES_ENCRYPT('" + this.edAdmin.getText() + "','nur') and password=AES_ENCRYPT('" + this.edPwd.getText() + "','windi')");
                executeQuery.last();
                final ResultSet executeQuery2 = statement2.executeQuery("select * from user where nip='" + this.edAdmin.getText() + "' and password=AES_ENCRYPT('" + this.edPwd.getText() + "','windi')");
                executeQuery2.last();
                if (this.edAdmin.getText().equals("admin") && this.edPwd.getText().equals("bismillah")) {
                    this.BtnJnsKoleksi.setEnabled(true);
                    this.BtnKtgKoleksi.setEnabled(true);
                    this.BtnRuang.setEnabled(true);
                    this.BtnDenda.setEnabled(true);
                    this.BtnPengarang.setEnabled(true);
                    this.BtnPetugas.setEnabled(true);
                    this.BtnAnggota.setEnabled(true);
                    this.BtnPenerbit.setEnabled(true);
                    this.BtnKoleksi.setEnabled(true);
                    this.BtnInventaris.setEnabled(true);
                    this.BtnBayar.setEnabled(true);
                    this.BtnSirkulasi.setEnabled(true);
                    this.BtnSetPinjam.setEnabled(true);
                    this.BtnSetAplikasi.setEnabled(true);
                    this.BtnSetUser.setEnabled(true);
                    this.BtnSetAdmin.setEnabled(true);
                    this.BtnVakum.setEnabled(true);
                    this.BtnToolBay.setEnabled(true);
                    this.BtnToolInv.setEnabled(true);
                    this.BtnToolKoleksi.setEnabled(true);
                    this.BtnToolSir.setEnabled(true);
                    this.DlgLogin.dispose();
                    this.BtnLog.setText("Log Out");
                    this.MnLogin.setText("Log Out");
                    this.edAdmin.setText("");
                    this.edPwd.setText("");
                    this.lblStts.setText("Admin : ");
                    this.lblUser.setText("Admin Utama");
                    this.PanelMenu.setVisible(true);
                }
                else if (executeQuery.getRow() >= 1) {
                    this.BtnJnsKoleksi.setEnabled(true);
                    this.BtnKtgKoleksi.setEnabled(true);
                    this.BtnRuang.setEnabled(true);
                    this.BtnDenda.setEnabled(true);
                    this.BtnPengarang.setEnabled(true);
                    this.BtnPetugas.setEnabled(true);
                    this.BtnAnggota.setEnabled(true);
                    this.BtnPenerbit.setEnabled(true);
                    this.BtnKoleksi.setEnabled(true);
                    this.BtnInventaris.setEnabled(true);
                    this.BtnBayar.setEnabled(true);
                    this.BtnSirkulasi.setEnabled(true);
                    this.BtnSetPinjam.setEnabled(true);
                    this.BtnSetAplikasi.setEnabled(true);
                    this.BtnSetUser.setEnabled(true);
                    this.BtnSetAdmin.setEnabled(true);
                    this.BtnVakum.setEnabled(true);
                    this.BtnToolBay.setEnabled(true);
                    this.BtnToolInv.setEnabled(true);
                    this.BtnToolKoleksi.setEnabled(true);
                    this.BtnToolSir.setEnabled(true);
                    this.DlgLogin.dispose();
                    this.BtnLog.setText("Log Out");
                    this.MnLogin.setText("Log Out");
                    this.edAdmin.setText("");
                    this.edPwd.setText("");
                    this.lblStts.setText("Admin : ");
                    this.lblUser.setText("Admin Utama");
                    this.PanelMenu.setVisible(true);
                }
                else if (executeQuery2.getRow() >= 1) {
                    if (executeQuery2.getString(3).equals("YES")) {
                        this.BtnJnsKoleksi.setEnabled(true);
                    }
                    if (executeQuery2.getString(3).equals("NO")) {
                        this.BtnJnsKoleksi.setEnabled(false);
                    }
                    if (executeQuery2.getString(4).equals("YES")) {
                        this.BtnKtgKoleksi.setEnabled(true);
                    }
                    if (executeQuery2.getString(4).equals("NO")) {
                        this.BtnKtgKoleksi.setEnabled(false);
                    }
                    if (executeQuery2.getString(5).equals("YES")) {
                        this.BtnRuang.setEnabled(true);
                    }
                    if (executeQuery2.getString(5).equals("NO")) {
                        this.BtnRuang.setEnabled(false);
                    }
                    if (executeQuery2.getString(6).equals("YES")) {
                        this.BtnDenda.setEnabled(true);
                    }
                    if (executeQuery2.getString(6).equals("NO")) {
                        this.BtnDenda.setEnabled(false);
                    }
                    if (executeQuery2.getString(7).equals("YES")) {
                        this.BtnPengarang.setEnabled(true);
                    }
                    if (executeQuery2.getString(7).equals("NO")) {
                        this.BtnPengarang.setEnabled(false);
                    }
                    if (executeQuery2.getString(8).equals("YES")) {
                        this.BtnPetugas.setEnabled(true);
                    }
                    if (executeQuery2.getString(8).equals("NO")) {
                        this.BtnPetugas.setEnabled(false);
                    }
                    if (executeQuery2.getString(9).equals("YES")) {
                        this.BtnAnggota.setEnabled(true);
                    }
                    if (executeQuery2.getString(9).equals("NO")) {
                        this.BtnAnggota.setEnabled(false);
                    }
                    if (executeQuery2.getString(10).equals("YES")) {
                        this.BtnPenerbit.setEnabled(true);
                    }
                    if (executeQuery2.getString(10).equals("NO")) {
                        this.BtnPenerbit.setEnabled(false);
                    }
                    if (executeQuery2.getString(11).equals("YES")) {
                        this.BtnKoleksi.setEnabled(true);
                        this.BtnToolKoleksi.setEnabled(true);
                    }
                    if (executeQuery2.getString(11).equals("NO")) {
                        this.BtnKoleksi.setEnabled(false);
                        this.BtnToolKoleksi.setEnabled(false);
                    }
                    if (executeQuery2.getString(12).equals("YES")) {
                        this.BtnInventaris.setEnabled(true);
                        this.BtnToolInv.setEnabled(true);
                    }
                    if (executeQuery2.getString(12).equals("NO")) {
                        this.BtnInventaris.setEnabled(false);
                        this.BtnToolInv.setEnabled(false);
                    }
                    if (executeQuery2.getString(13).equals("YES")) {
                        this.BtnBayar.setEnabled(true);
                        this.BtnToolBay.setEnabled(true);
                    }
                    if (executeQuery2.getString(13).equals("NO")) {
                        this.BtnBayar.setEnabled(false);
                        this.BtnToolBay.setEnabled(false);
                    }
                    if (executeQuery2.getString(14).equals("YES")) {
                        this.BtnSirkulasi.setEnabled(true);
                        this.BtnToolSir.setEnabled(true);
                    }
                    if (executeQuery2.getString(14).equals("NO")) {
                        this.BtnSirkulasi.setEnabled(false);
                        this.BtnToolSir.setEnabled(false);
                    }
                    if (executeQuery2.getString(15).equals("YES")) {
                        this.BtnSetPinjam.setEnabled(true);
                    }
                    if (executeQuery2.getString(15).equals("NO")) {
                        this.BtnSetPinjam.setEnabled(false);
                    }
                    if (executeQuery2.getString(16).equals("YES")) {
                        this.BtnSetAplikasi.setEnabled(true);
                    }
                    if (executeQuery2.getString(16).equals("NO")) {
                        this.BtnSetAplikasi.setEnabled(false);
                    }
                    this.BtnSetUser.setEnabled(false);
                    this.BtnSetAdmin.setEnabled(false);
                    this.BtnVakum.setEnabled(false);
                    this.DlgLogin.dispose();
                    this.BtnLog.setText("Log Out");
                    this.MnLogin.setText("Log Out");
                    this.lblStts.setText("Admin : ");
                    this.lblUser.setText(this.edAdmin.getText());
                    this.edAdmin.setText("");
                    this.edPwd.setText("");
                    this.PanelMenu.setVisible(true);
                }
                else if (executeQuery.getRow() == 0 && executeQuery2.getRow() == 0) {
                    JOptionPane.showMessageDialog(null, "Maaf, Gagal login. ID User atau password ada yang salah ...!");
                    this.BtnJnsKoleksi.setEnabled(false);
                    this.BtnKtgKoleksi.setEnabled(false);
                    this.BtnRuang.setEnabled(false);
                    this.BtnDenda.setEnabled(false);
                    this.BtnPengarang.setEnabled(false);
                    this.BtnPetugas.setEnabled(false);
                    this.BtnAnggota.setEnabled(false);
                    this.BtnPenerbit.setEnabled(false);
                    this.BtnKoleksi.setEnabled(false);
                    this.BtnInventaris.setEnabled(false);
                    this.BtnBayar.setEnabled(false);
                    this.BtnSirkulasi.setEnabled(false);
                    this.BtnSetPinjam.setEnabled(false);
                    this.BtnSetAplikasi.setEnabled(false);
                    this.BtnSetUser.setEnabled(false);
                    this.BtnSetAdmin.setEnabled(false);
                    this.BtnVakum.setEnabled(false);
                    this.BtnToolBay.setEnabled(false);
                    this.BtnToolInv.setEnabled(false);
                    this.BtnToolKoleksi.setEnabled(false);
                    this.BtnToolSir.setEnabled(false);
                    this.edAdmin.requestFocus();
                    this.BtnLog.setText("Log In");
                    this.MnLogin.setText("Log In");
                    this.lblStts.setText("Status Admin : ");
                    this.lblUser.setText("Log Out");
                    this.PanelMenu.setVisible(false);
                }
            }
            catch (Exception ex) {
                System.out.println("error : " + ex);
            }
        }
    }
    
    private void BtnCancelActionPerformed(final ActionEvent actionEvent) {
        this.edAdmin.setText("");
        this.edPwd.setText("");
        this.DlgLogin.dispose();
    }
    
    private void MnLoginActionPerformed(final ActionEvent actionEvent) {
        this.BtnLogActionPerformed(actionEvent);
    }
    
    private void jMenu2ActionPerformed(final ActionEvent actionEvent) {
        this.dlgPusatData.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void jMenu2MouseClicked(final MouseEvent mouseEvent) {
        this.dlgPusatData.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void jMenu3ActionPerformed(final ActionEvent actionEvent) {
        this.dlgAbout.setVisible(this.rootPaneCheckingEnabled);
    }
    
    private void jMenu3MouseClicked(final MouseEvent mouseEvent) {
        this.dlgAbout.setVisible(this.rootPaneCheckingEnabled);
    }
    
    public static void main(final String[] array) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmUtama().setVisible(true);
            }
        });
    }
    
    private void posisi() {
        this.ChkFile.setSize(192, 20);
        this.ChkKoleksi.setSize(192, 20);
        this.ChkMaster.setSize(192, 20);
        this.ChkSetting.setSize(192, 20);
        this.ChkTransaksi.setSize(192, 20);
        if (this.PanelMaster.isVisible()) {
            this.PanelMaster.setLocation(2, this.ChkMaster.getHeight() + this.ChkMaster.getY());
            this.PanelMaster.setSize(192, 150);
            this.ChkFile.setLocation(2, this.PanelMaster.getHeight() + this.PanelMaster.getY() + 2);
        }
        else if (!this.PanelMaster.isVisible()) {
            this.ChkFile.setLocation(2, this.ChkMaster.getHeight() + this.ChkMaster.getY() + 2);
        }
        if (this.PanelFile.isVisible()) {
            this.PanelFile.setLocation(2, this.ChkFile.getHeight() + this.ChkFile.getY());
            this.PanelFile.setSize(192, 90);
            this.ChkKoleksi.setLocation(2, this.PanelFile.getHeight() + this.PanelFile.getY() + 2);
        }
        else if (!this.PanelFile.isVisible()) {
            this.ChkKoleksi.setLocation(2, this.ChkFile.getHeight() + this.ChkFile.getY() + 2);
        }
        if (this.PanelKoleksi.isVisible()) {
            this.PanelKoleksi.setLocation(2, this.ChkKoleksi.getHeight() + this.ChkKoleksi.getY());
            this.PanelKoleksi.setSize(192, 60);
            this.ChkTransaksi.setLocation(2, this.PanelKoleksi.getHeight() + this.PanelKoleksi.getY() + 2);
        }
        else if (!this.PanelTransaksi.isVisible()) {
            this.ChkTransaksi.setLocation(2, this.ChkKoleksi.getHeight() + this.ChkKoleksi.getY() + 2);
        }
        if (this.PanelTransaksi.isVisible()) {
            this.PanelTransaksi.setLocation(2, this.ChkTransaksi.getHeight() + this.ChkTransaksi.getY());
            this.PanelTransaksi.setSize(192, 60);
            this.ChkTransaksi.setLocation(2, this.PanelTransaksi.getHeight() + this.PanelTransaksi.getY() + 2);
        }
        else if (!this.PanelTransaksi.isVisible()) {
            this.ChkSetting.setLocation(2, this.ChkTransaksi.getHeight() + this.ChkTransaksi.getY() + 2);
        }
        if (this.PanelSetting.isVisible()) {
            this.PanelSetting.setLocation(2, this.ChkSetting.getHeight() + this.ChkSetting.getY());
            this.PanelSetting.setSize(192, 150);
        }
    }
    
    private void mnKlik(final JCheckBox checkBox, final JPanel panel) {
        if (checkBox.isSelected()) {
            panel.setVisible(true);
            this.posisi();
        }
        else if (!checkBox.isSelected()) {
            panel.setVisible(false);
            this.posisi();
        }
    }
}
