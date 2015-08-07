package simpus;

import usu.widget.Label;
import usu.widget.Panel;
import usu.widget.TextArea;
import uz.ncipro.calendar.*;
import widget.*;
import widget.Button;
import widget.ScrollPane;
import fungsi.*;

import javax.swing.text.*;
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

public class DlgAnggota extends JDialog
{
    private DefaultTableModel tabMode;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAll;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnCloseInput;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPrint;
    private Button BtnSimpan;
    private Button BtnTambah;
    private JCheckBox ChkCari;
    private CekBox ChkGabung;
    private CekBox ChkHabis;
    private CekBox ChkJk;
    private ComboBox CmbJk;
    private ComboBox CmbJkCari;
    private JDateTimePicker DTPGabung;
    private JDateTimePicker DTPGabungCari1;
    private JDateTimePicker DTPGabungCari2;
    private JDateTimePicker DTPHabis;
    private JDateTimePicker DTPHabisCari1;
    private JDateTimePicker DTPHabisCari2;
    private JDateTimePicker DTPLahir;
    private JDialog DlgInput;
    private Label LCount;
    private JMenuItem MnBarcode;
    private InternalFrame PanelCari;
    private JPanel PanelIndukCari;
    private TextArea TAlamat;
    private TextBox TCari;
    private TextBox TEmail;
    private TextBox TNm;
    private TextBox TNo;
    private TextBox TTlp;
    private TextBox TTmp;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPopupMenu jPopupMenu1;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label10;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label14;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Panel panel1;
    private Panel panel2;
    private PanelJudul panelJudul1;
    private PanelJudul panelJudul2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private Table tbAnggota;
    
    public DlgAnggota(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Bergabung</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keanggotaan Habis</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbAnggota.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbAnggota.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbAnggota.setAutoResizeMode(0);
        for (int i = 0; i < 10; ++i) {
            final TableColumn column = this.tbAnggota.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            }
            else if (i == 1) {
                column.setPreferredWidth(260);
            }
            else if (i == 2) {
                column.setPreferredWidth(150);
            }
            else if (i == 3) {
                column.setPreferredWidth(120);
            }
            else if (i == 4) {
                column.setPreferredWidth(50);
            }
            else if (i == 5) {
                column.setPreferredWidth(350);
            }
            else if (i == 6) {
                column.setPreferredWidth(110);
            }
            else if (i == 7) {
                column.setPreferredWidth(180);
            }
            else if (i == 8) {
                column.setPreferredWidth(110);
            }
            else if (i == 9) {
                column.setPreferredWidth(130);
            }
        }
        this.tbAnggota.setDefaultRenderer(Object.class, new WarnaTable());
        this.TNo.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNo));
        this.TNm.setDocument((Document)new batasInput(40).getFilter((JTextField)this.TNm));
        this.TTmp.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TTmp));
        this.TAlamat.setDocument(new batasInput(70).getFilter(this.TAlamat));
        this.TTlp.setDocument((Document)new batasInput(13).getOnlyAngka((JTextField)this.TTlp));
        this.TEmail.setDocument((Document)new batasInput(25).getFilter((JTextField)this.TEmail));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.TCari.requestFocus();
        this.ChkCariActionPerformed(null);
        this.DlgInput.setSize(734, 293);
        this.DlgInput.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgInput = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.label1 = new Label();
        this.TNo = new TextBox();
        this.TNm = new TextBox();
        this.label2 = new Label();
        this.label5 = new Label();
        this.TTmp = new TextBox();
        this.DTPGabung = new JDateTimePicker();
        this.label6 = new Label();
        this.CmbJk = new ComboBox();
        this.TTlp = new TextBox();
        this.label7 = new Label();
        this.TEmail = new TextBox();
        this.label8 = new Label();
        this.label9 = new Label();
        this.scrollPane2 = new ScrollPane();
        this.TAlamat = new TextArea();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnCloseInput = new Button();
        this.label10 = new Label();
        this.DTPLahir = new JDateTimePicker();
        this.label11 = new Label();
        this.DTPHabis = new JDateTimePicker();
        this.label12 = new Label();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
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
        this.tbAnggota = new Table();
        this.PanelIndukCari = new JPanel();
        this.internalFrame2 = new InternalFrame();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
        this.PanelCari = new InternalFrame();
        this.ChkJk = new CekBox();
        this.CmbJkCari = new ComboBox();
        this.ChkGabung = new CekBox();
        this.DTPGabungCari1 = new JDateTimePicker();
        this.label13 = new Label();
        this.DTPGabungCari2 = new JDateTimePicker();
        this.ChkHabis = new CekBox();
        this.DTPHabisCari1 = new JDateTimePicker();
        this.label14 = new Label();
        this.DTPHabisCari2 = new JDateTimePicker();
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
        this.label1.setText("No.Pminjam :");
        this.label1.setName("label1");
        this.internalFrame1.add((Component)this.label1);
        this.label1.setBounds(17, 12, 80, 23);
        this.TNo.setName("TNo");
        this.TNo.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TNoKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNo);
        this.TNo.setBounds(85, 12, 130, 23);
        this.TNm.setName("TNm");
        this.TNm.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TNmKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNm);
        this.TNm.setBounds(85, 42, 282, 23);
        this.label2.setForeground(new Color(153, 153, 255));
        this.label2.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.label2.setName("label2");
        this.internalFrame1.add((Component)this.label2);
        this.label2.setBounds(-11, 160, 780, 14);
        this.label5.setText("Tmp.Lahir :");
        this.label5.setName("label5");
        this.internalFrame1.add((Component)this.label5);
        this.label5.setBounds(28, 72, 80, 23);
        this.TTmp.setName("TTmp");
        this.TTmp.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TTmpKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TTmp);
        this.TTmp.setBounds(85, 72, 177, 23);
        this.DTPGabung.setBackground(new Color(90, 0, 90));
        this.DTPGabung.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPGabung.setEditable(false);
        this.DTPGabung.setForeground(new Color(205, 214, 255));
        this.DTPGabung.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "17/11/2011" }));
        this.DTPGabung.setDisplayFormat("dd/MM/yyyy");
        this.DTPGabung.setName("DTPGabung");
        this.DTPGabung.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPGabungKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPGabung);
        this.DTPGabung.setBounds(595, 102, 120, 23);
        this.label6.setText("J.Kel :");
        this.label6.setName("label6");
        this.internalFrame1.add((Component)this.label6);
        this.label6.setBounds(52, 102, 80, 23);
        this.CmbJk.setModel(new DefaultComboBoxModel<Object>(new String[] { "LAKI-LAKI", "PEREMPUAN" }));
        this.CmbJk.setName("CmbJk");
        this.CmbJk.setPreferredSize(new Dimension(56, 23));
        this.CmbJk.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.CmbJkKeyPressed(evt);
            }
        });
        this.internalFrame1.add(this.CmbJk);
        this.CmbJk.setBounds(85, 102, 130, 23);
        this.TTlp.setName("TTlp");
        this.TTlp.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TTlpKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TTlp);
        this.TTlp.setBounds(85, 132, 130, 24);
        this.label7.setText("No.Telp :");
        this.label7.setName("label7");
        this.internalFrame1.add((Component)this.label7);
        this.label7.setBounds(38, 132, 60, 23);
        this.TEmail.setName("TEmail");
        this.TEmail.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TEmailKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TEmail);
        this.TEmail.setBounds(445, 12, 230, 23);
        this.label8.setText("E-Mail :");
        this.label8.setName("label8");
        this.internalFrame1.add((Component)this.label8);
        this.label8.setBounds(407, 12, 80, 23);
        this.label9.setText("Tanggal Bergabung :");
        this.label9.setName("label9");
        this.internalFrame1.add((Component)this.label9);
        this.label9.setBounds(492, 102, 120, 23);
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.scrollPane2.setName("scrollPane2");
        this.TAlamat.setColumns(20);
        this.TAlamat.setRows(5);
        this.TAlamat.setFont(new Font("Tahoma", 0, 11));
        this.TAlamat.setName("TAlamat");
        this.TAlamat.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TAlamatKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.TAlamat);
        this.internalFrame1.add(this.scrollPane2);
        this.scrollPane2.setBounds(445, 42, 270, 53);
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
                DlgAnggota.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnSimpanKeyPressed(evt);
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
                DlgAnggota.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnBatalKeyPressed(evt);
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
                DlgAnggota.this.BtnCloseInputActionPerformed(evt);
            }
        });
        this.BtnCloseInput.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnCloseInputKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnCloseInput);
        this.BtnCloseInput.setBounds(616, 180, 100, 30);
        this.label10.setText("Nama :");
        this.label10.setName("label10");
        this.internalFrame1.add((Component)this.label10);
        this.label10.setBounds(48, 42, 80, 23);
        this.DTPLahir.setBackground(new Color(90, 0, 90));
        this.DTPLahir.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPLahir.setEditable(false);
        this.DTPLahir.setForeground(new Color(205, 214, 255));
        this.DTPLahir.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "17/11/2011" }));
        this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
        this.DTPLahir.setName("DTPLahir");
        this.DTPLahir.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPLahirKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPLahir);
        this.DTPLahir.setBounds(265, 72, 102, 23);
        this.label11.setText("Alamat :");
        this.label11.setName("label11");
        this.internalFrame1.add((Component)this.label11);
        this.label11.setBounds(402, 42, 80, 23);
        this.DTPHabis.setBackground(new Color(90, 0, 90));
        this.DTPHabis.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPHabis.setEditable(false);
        this.DTPHabis.setForeground(new Color(205, 214, 255));
        this.DTPHabis.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "17/11/2011" }));
        this.DTPHabis.setDisplayFormat("dd/MM/yyyy");
        this.DTPHabis.setName("DTPHabis");
        this.DTPHabis.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPHabisKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPHabis);
        this.DTPHabis.setBounds(595, 132, 120, 23);
        this.label12.setText("Keanggotaan Habis Pada :");
        this.label12.setName("label12");
        this.internalFrame1.add((Component)this.label12);
        this.label12.setBounds(465, 132, 160, 23);
        this.DlgInput.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: INPUT DATA PEMINJAM ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(198, 10, 330, 20);
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
        this.jPopupMenu1.setName("jPopupMenu1");
        this.MnBarcode.setBackground(new Color(153, 0, 153));
        this.MnBarcode.setForeground(new Color(204, 255, 255));
        this.MnBarcode.setText("Kartu Anggota");
        this.MnBarcode.setName("MnBarcode");
        this.MnBarcode.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgAnggota.this.MnBarcodeActionPerformed(evt);
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
                DlgAnggota.this.BtnTambahActionPerformed(evt);
            }
        });
        this.BtnTambah.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnTambahKeyPressed(evt);
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
                DlgAnggota.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnHapusKeyPressed(evt);
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
                DlgAnggota.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnEditKeyPressed(evt);
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
                DlgAnggota.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnPrintKeyPressed(evt);
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
                DlgAnggota.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnAllKeyPressed(evt);
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
                DlgAnggota.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnKeluar);
        this.jPanel2.add(this.internalFrame3, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setComponentPopupMenu(this.jPopupMenu1);
        this.scrollPane1.setName("scrollPane1");
        this.tbAnggota.setAutoCreateRowSorter(true);
        this.tbAnggota.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbAnggota.setComponentPopupMenu(this.jPopupMenu1);
        this.tbAnggota.setName("tbAnggota");
        this.tbAnggota.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgAnggota.this.tbAnggotaMouseClicked(evt);
            }
        });
        this.tbAnggota.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.tbAnggotaKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbAnggota);
        this.jPanel2.add(this.scrollPane1, "Center");
        this.jPanel1.add(this.jPanel2, "Center");
        this.PanelIndukCari.setBackground(new Color(90, 0, 90));
        this.PanelIndukCari.setName("PanelIndukCari");
        this.PanelIndukCari.setPreferredSize(new Dimension(757, 100));
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
        this.TCari.setPreferredSize(new Dimension(430, 23));
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.TCariKeyPressed(evt);
            }
            
            public void keyTyped(final KeyEvent evt) {
                DlgAnggota.this.TCariKeyTyped(evt);
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
                DlgAnggota.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.BtnCariKeyPressed(evt);
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
        this.PanelCari.setPreferredSize(new Dimension(639, 40));
        this.PanelCari.setLayout(new FlowLayout(0, 2, 6));
        this.ChkJk.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJk.setText("J.K. :");
        this.ChkJk.setHorizontalAlignment(4);
        this.ChkJk.setHorizontalTextPosition(4);
        this.ChkJk.setName("ChkJk");
        this.ChkJk.setPreferredSize(new Dimension(49, 23));
        this.ChkJk.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkJk.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkJk.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkJk.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkJk);
        this.CmbJkCari.setModel(new DefaultComboBoxModel<Object>(new String[] { "L", "P" }));
        this.CmbJkCari.setName("CmbJkCari");
        this.CmbJkCari.setPreferredSize(new Dimension(45, 23));
        this.CmbJkCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.CmbJkCari.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.CmbJkCariKeyPressed(evt);
            }
        });
        this.PanelCari.add(this.CmbJkCari);
        this.ChkGabung.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkGabung.setText("Tgl.Gbng :");
        this.ChkGabung.setHorizontalAlignment(4);
        this.ChkGabung.setHorizontalTextPosition(4);
        this.ChkGabung.setName("ChkGabung");
        this.ChkGabung.setPreferredSize(new Dimension(77, 23));
        this.ChkGabung.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkGabung.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkGabung.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkGabung.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkGabung);
        this.DTPGabungCari1.setBackground(new Color(90, 0, 90));
        this.DTPGabungCari1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPGabungCari1.setEditable(false);
        this.DTPGabungCari1.setForeground(new Color(205, 214, 255));
        this.DTPGabungCari1.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPGabungCari1.setDisplayFormat("yyyy/MM/dd");
        this.DTPGabungCari1.setName("DTPGabungCari1");
        this.DTPGabungCari1.setPreferredSize(new Dimension(82, 23));
        this.DTPGabungCari1.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.DTPGabungCari1.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPGabungCari1KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPGabungCari1);
        this.label13.setHorizontalAlignment(4);
        this.label13.setText("Sd");
        this.label13.setHorizontalTextPosition(0);
        this.label13.setName("label13");
        this.label13.setPreferredSize(new Dimension(14, 23));
        this.PanelCari.add((Component)this.label13);
        this.DTPGabungCari2.setBackground(new Color(90, 0, 90));
        this.DTPGabungCari2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPGabungCari2.setEditable(false);
        this.DTPGabungCari2.setForeground(new Color(205, 214, 255));
        this.DTPGabungCari2.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPGabungCari2.setDisplayFormat("yyyy/MM/dd");
        this.DTPGabungCari2.setName("DTPGabungCari2");
        this.DTPGabungCari2.setPreferredSize(new Dimension(82, 23));
        this.DTPGabungCari2.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.DTPGabungCari2.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPGabungCari2KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPGabungCari2);
        this.ChkHabis.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkHabis.setText("Agta.Hbs :");
        this.ChkHabis.setHorizontalAlignment(4);
        this.ChkHabis.setHorizontalTextPosition(4);
        this.ChkHabis.setName("ChkHabis");
        this.ChkHabis.setPreferredSize(new Dimension(79, 23));
        this.ChkHabis.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkHabis.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkHabis.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkHabis.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkHabis);
        this.DTPHabisCari1.setBackground(new Color(90, 0, 90));
        this.DTPHabisCari1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPHabisCari1.setEditable(false);
        this.DTPHabisCari1.setForeground(new Color(205, 214, 255));
        this.DTPHabisCari1.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPHabisCari1.setDisplayFormat("yyyy/MM/dd");
        this.DTPHabisCari1.setName("DTPHabisCari1");
        this.DTPHabisCari1.setPreferredSize(new Dimension(82, 23));
        this.DTPHabisCari1.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.DTPHabisCari1.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPHabisCari1KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPHabisCari1);
        this.label14.setHorizontalAlignment(4);
        this.label14.setText("Sd");
        this.label14.setHorizontalTextPosition(0);
        this.label14.setName("label14");
        this.label14.setPreferredSize(new Dimension(14, 23));
        this.PanelCari.add((Component)this.label14);
        this.DTPHabisCari2.setBackground(new Color(90, 0, 90));
        this.DTPHabisCari2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPHabisCari2.setEditable(false);
        this.DTPHabisCari2.setForeground(new Color(205, 214, 255));
        this.DTPHabisCari2.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPHabisCari2.setDisplayFormat("yyyy/MM/dd");
        this.DTPHabisCari2.setName("DTPHabisCari2");
        this.DTPHabisCari2.setPreferredSize(new Dimension(82, 23));
        this.DTPHabisCari2.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgAnggota.this.CmbJkCariItemStateChanged(evt);
            }
        });
        this.DTPHabisCari2.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAnggota.this.DTPHabisCari2KeyPressed(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPHabisCari2);
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
                DlgAnggota.this.ChkCariActionPerformed(evt);
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
        this.jLabel2.setText(":: DAFTAR PEMINJAM ::");
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
        if (this.TNm.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data anggota yang akan Anda hapus dengan menklik data pada tabel...!!!");
            this.tbAnggota.requestFocus();
        }
        else {
            this.Valid.hapusTable(this.tabMode, (JTextField)this.TNo, "anggota", "no_anggota");
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
        else if (this.TNm.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data anggota yang akan Anda edit dengan menklik data pada tabel...!!!");
            this.tbAnggota.requestFocus();
        }
        else if (!this.TNm.getText().trim().equals("")) {
            this.TNo.setEditable(false);
            this.TNm.requestFocus();
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
                this.Valid.MyReport("rptAnggota.jrxml", "report", "::[ Data Anggota ]::", "select * from anggota order by no_anggota");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("rptAnggota.jrxml", "report", "::[ Data Anggota ]::", "select * from anggota where no_anggota like '%" + this.TCari.getText().trim() + "%' " + "or nama_anggota like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or tgl_gabung like '%" + this.TCari.getText().trim() + "%' " + "or masa_berlaku like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by no_anggota");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String key = "";
                if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "";
                }
                else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "'";
                }
                else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ";
                }
                else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ";
                }
                else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                this.Valid.MyReport("rptAnggota.jrxml", "report", "::[ Data Anggota ]::", "select * from anggota " + key + " order by no_anggota");
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
        this.ChkGabung.setSelected(false);
        this.ChkHabis.setSelected(false);
        this.ChkJk.setSelected(false);
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
    
    private void tbAnggotaMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbAnggotaKeyPressed(final KeyEvent evt) {
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
        this.prosesCari("select * from anggota where no_anggota like '%" + this.TCari.getText().trim() + "%' " + "or nama_anggota like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or tgl_gabung like '%" + this.TCari.getText().trim() + "%' " + "or masa_berlaku like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by no_anggota");
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnTambah);
        }
    }
    
    private void CmbJkCariItemStateChanged(final ItemEvent evt) {
        if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
            this.tampil("");
        }
        else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
            this.tampil("where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "'");
        }
        else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
            this.tampil("where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ");
        }
        else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
            this.tampil("where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ");
        }
        else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
            this.tampil("where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ");
        }
        else if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
            this.tampil("where masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ");
        }
        else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
            this.tampil("where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ");
        }
        else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
            this.tampil("where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ");
        }
    }
    
    private void CmbJkCariKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JComboBox)this.DTPHabisCari2, this.DTPGabungCari1);
    }
    
    private void DTPGabungCari1KeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbJkCari, this.DTPGabungCari2);
    }
    
    private void DTPGabungCari2KeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JComboBox)this.DTPGabungCari1, this.DTPHabisCari1);
    }
    
    private void DTPHabisCari1KeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JComboBox)this.DTPGabungCari2, this.DTPHabisCari2);
    }
    
    private void DTPHabisCari2KeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JComboBox)this.DTPHabisCari1, this.CmbJkCari);
    }
    
    private void ChkCariActionPerformed(final ActionEvent evt) {
        if (this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(true);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 100));
            this.TCari.setText("");
            this.CmbJkCariItemStateChanged(null);
        }
        else if (!this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(false);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 61));
            this.BtnCariActionPerformed(null);
        }
    }
    
    private void TNoKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCloseInput, (JTextField)this.TNm);
    }
    
    private void TNmKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNo, (JTextField)this.TTmp);
    }
    
    private void TTmpKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNm, (JComboBox)this.DTPLahir);
    }
    
    private void DTPGabungKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.TAlamat, (JComboBox)this.DTPHabis);
    }
    
    private void CmbJkKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.DTPLahir, (JTextField)this.TTlp);
    }
    
    private void TTlpKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, this.CmbJk, (JTextField)this.TEmail);
    }
    
    private void TEmailKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TTlp, this.TAlamat);
    }
    
    private void TAlamatKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TEmail, (JComboBox)this.DTPGabung);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TNo.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNo, "No.Peminjam");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Nama Peminjam");
        }
        else if (this.TTmp.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TTmp, "Tempat Lahir");
        }
        else if (this.TTlp.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TTlp, "No.Telp Peminjam");
        }
        else if (this.TEmail.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TEmail, "Email Peminjam");
        }
        else if (this.TAlamat.getText().trim().equals("")) {
            this.Valid.textKosong(this.TAlamat, "Alamat Peminjam");
        }
        else {
            if (this.TNo.isEditable()) {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                this.DTPGabung.setDisplayFormat("yyyy-MM-dd");
                this.DTPHabis.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.menyimpan("anggota", "'" + this.TNo.getText() + "','" + this.TNm.getText() + "','" + this.TTmp.getText() + "','" + this.DTPLahir.getSelectedItem() + "','" + this.CmbJk.getSelectedItem().toString().substring(0, 1) + "','" + this.TAlamat.getText() + "','" + this.TTlp.getText() + "','" + this.TEmail.getText() + "','" + this.DTPGabung.getSelectedItem() + "','" + this.DTPHabis.getSelectedItem() + "'", "NIP");
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
                this.DTPGabung.setDisplayFormat("dd/MM/yyyy");
                this.DTPHabis.setDisplayFormat("dd/MM/yyyy");
                this.TNo.requestFocus();
            }
            else if (!this.TNo.isEditable()) {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                this.DTPGabung.setDisplayFormat("yyyy-MM-dd");
                this.DTPHabis.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.mengedit("anggota", "no_anggota='" + this.TNo.getText() + "'", "nama_anggota='" + this.TNm.getText() + "'," + "tmp_lahir='" + this.TTmp.getText() + "'," + "tgl_lahir='" + this.DTPLahir.getSelectedItem() + "'," + "j_kel='" + this.CmbJk.getSelectedItem().toString().substring(0, 1) + "'," + "alamat='" + this.TAlamat.getText() + "'," + "no_telp='" + this.TTlp.getText() + "'," + "email='" + this.TEmail.getText() + "'," + "tgl_gabung='" + this.DTPGabung.getSelectedItem() + "'," + "masa_berlaku='" + this.DTPHabis.getSelectedItem() + "'");
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
                this.DTPGabung.setDisplayFormat("dd/MM/yyyy");
                this.DTPHabis.setDisplayFormat("dd/MM/yyyy");
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
            this.Valid.pindah(evt, (JComboBox)this.DTPHabis, (JButton)this.BtnBatal);
        }
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
    
    private void DTPLahirKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TTmp, this.CmbJk);
    }
    
    private void DTPHabisKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JComboBox)this.DTPGabung, (JButton)this.BtnSimpan);
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
                this.Valid.MyReport("krtuAgt.jrxml", "report", "::[ Kartu Anggota ]::", "select * from anggota order by no_anggota");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("krtuAgt.jrxml", "report", "::[ Kartu Anggota ]::", "select * from anggota where no_anggota like '%" + this.TCari.getText().trim() + "%' " + "or nama_anggota like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or tgl_gabung like '%" + this.TCari.getText().trim() + "%' " + "or masa_berlaku like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by no_anggota");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String key = "";
                if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "";
                }
                else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "'";
                }
                else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ";
                }
                else if (this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkJk.isSelected() && this.ChkGabung.isSelected() && !this.ChkHabis.isSelected()) {
                    key = "where tgl_gabung between '" + this.DTPGabungCari1.getSelectedItem() + "' and '" + this.DTPGabungCari2.getSelectedItem() + "' ";
                }
                else if (this.ChkJk.isSelected() && !this.ChkGabung.isSelected() && this.ChkHabis.isSelected()) {
                    key = "where j_kel='" + this.CmbJkCari.getSelectedItem().toString() + "' " + "and masa_berlaku between '" + this.DTPHabisCari1.getSelectedItem() + "' and '" + this.DTPHabisCari2.getSelectedItem() + "' ";
                }
                this.Valid.MyReport("krtuAgt.jrxml", "report", "::[ Kartu Anggota ]::", "select * from anggota " + key + " order by no_anggota");
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgAnggota dialog = new DlgAnggota(new JFrame(), true);
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
        final String sql = "select * from anggota " + key + " order by no_anggota";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10) };
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
        this.TNo.setText("");
        this.TNm.setText("");
        this.TTmp.setText("");
        this.DTPGabung.setDate(new Date());
        this.DTPHabis.setDate(new Date());
        this.DTPLahir.setDate(new Date());
        this.CmbJk.setSelectedIndex(0);
        this.TTlp.setText("");
        this.TEmail.setText("");
        this.TAlamat.setText("");
        this.TCari.setText("");
        this.TNo.requestFocus();
        this.Valid.autoNomer(this.tabMode, "A", 9, (JTextField)this.TNo);
    }
    
    public void focus() {
        this.ChkCariActionPerformed(null);
        this.TCari.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbAnggota.getSelectedRow();
        if (row != -1) {
            this.TNo.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TNm.setText(this.tabMode.getValueAt(row, 1).toString());
            this.TTmp.setText(this.tabMode.getValueAt(row, 2).toString());
            try {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabMode.getValueAt(row, 3).toString());
                this.DTPLahir.setDate(dtpa);
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgAnggota.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.tabMode.getValueAt(row, 4).toString().equals("L")) {
                this.CmbJk.setSelectedItem("LAKI-LAKI");
            }
            else if (this.tabMode.getValueAt(row, 4).toString().equals("P")) {
                this.CmbJk.setSelectedItem("PEREMPUAN");
            }
            this.TAlamat.setText(this.tabMode.getValueAt(row, 5).toString());
            this.TTlp.setText(this.tabMode.getValueAt(row, 6).toString());
            this.TEmail.setText(this.tabMode.getValueAt(row, 7).toString());
            try {
                this.DTPGabung.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabMode.getValueAt(row, 8).toString());
                this.DTPGabung.setDate(dtpa);
                this.DTPGabung.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgAnggota.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.DTPHabis.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabMode.getValueAt(row, 9).toString());
                this.DTPHabis.setDate(dtpa);
                this.DTPHabis.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgAnggota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
