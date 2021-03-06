package simpus;

import uz.ncipro.calendar.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import widget.TextArea;
import fungsi.*;

import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.*;
import java.text.*;

public class DlgPetugas extends JDialog
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
    private ComboBox CmbJk;
    private JDateTimePicker DTPLahir;
    private JDialog DlgInput;
    private Label LCount;
    private JMenuItem MnBarcode;
    private TextArea TAlamat;
    private TextBox TCari;
    private TextBox TEmail;
    private TextBox TNip;
    private TextBox TNm;
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
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private Panel panel1;
    private PanelJudul panelJudul1;
    private PanelJudul panelJudul2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private Table tbPetugas;
    
    public DlgPetugas(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>NIP</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPetugas.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbPetugas.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPetugas.setAutoResizeMode(0);
        for (int i = 0; i < 8; ++i) {
            final TableColumn column = this.tbPetugas.getColumnModel().getColumn(i);
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
                column.setPreferredWidth(130);
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
        }
        this.tbPetugas.setDefaultRenderer(Object.class, new WarnaTable());
        this.TNip.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNip));
        this.TNm.setDocument((Document)new batasInput(40).getFilter((JTextField)this.TNm));
        this.TTmp.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TTmp));
        this.TAlamat.setDocument(new batasInput(70).getFilter(this.TAlamat));
        this.TTlp.setDocument((Document)new batasInput(13).getOnlyAngka((JTextField)this.TTlp));
        this.TEmail.setDocument((Document)new batasInput(25).getFilter((JTextField)this.TEmail));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.TCari.requestFocus();
        this.DlgInput.setSize(734, 263);
        this.DlgInput.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgInput = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.label1 = new Label();
        this.TNip = new TextBox();
        this.TNm = new TextBox();
        this.label2 = new Label();
        this.label5 = new Label();
        this.TTmp = new TextBox();
        this.DTPLahir = new JDateTimePicker();
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
        this.scrollPane1 = new ScrollPane();
        this.tbPetugas = new Table();
        this.internalFrame3 = new InternalFrame();
        this.BtnTambah = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnPrint = new Button();
        this.BtnAll = new Button();
        this.BtnKeluar = new Button();
        this.internalFrame2 = new InternalFrame();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
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
        this.label1.setText("NIP :");
        this.label1.setName("label1");
        this.internalFrame1.add((Component)this.label1);
        this.label1.setBounds(45, 17, 80, 14);
        this.TNip.setName("TNip");
        this.TNip.setSelectedTextColor(new Color(255, 255, 255));
        this.TNip.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TNipKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNip);
        this.TNip.setBounds(72, 12, 130, 23);
        this.TNm.setName("TNm");
        this.TNm.setSelectedTextColor(new Color(255, 255, 255));
        this.TNm.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TNmKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNm);
        this.TNm.setBounds(72, 42, 295, 23);
        this.label2.setForeground(new Color(153, 153, 255));
        this.label2.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.label2.setName("label2");
        this.internalFrame1.add((Component)this.label2);
        this.label2.setBounds(-11, 130, 820, 14);
        this.label5.setText("Tmp.Lahir :");
        this.label5.setName("label5");
        this.internalFrame1.add((Component)this.label5);
        this.label5.setBounds(15, 77, 80, 14);
        this.TTmp.setName("TTmp");
        this.TTmp.setSelectedTextColor(new Color(255, 255, 255));
        this.TTmp.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TTmpKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TTmp);
        this.TTmp.setBounds(72, 72, 191, 23);
        this.DTPLahir.setBackground(new Color(90, 0, 90));
        this.DTPLahir.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPLahir.setEditable(false);
        this.DTPLahir.setForeground(new Color(205, 214, 255));
        this.DTPLahir.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "24/09/2010" }));
        this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
        this.DTPLahir.setName("DTPLahir");
        this.DTPLahir.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.DTPLahirKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPLahir);
        this.DTPLahir.setBounds(265, 72, 102, 23);
        this.label6.setText("J.Kel :");
        this.label6.setName("label6");
        this.internalFrame1.add((Component)this.label6);
        this.label6.setBounds(39, 107, 80, 14);
        this.CmbJk.setModel(new DefaultComboBoxModel<Object>(new String[] { "LAKI-LAKI", "PEREMPUAN" }));
        this.CmbJk.setName("CmbJk");
        this.CmbJk.setPreferredSize(new Dimension(56, 23));
        this.CmbJk.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.CmbJkKeyPressed(evt);
            }
        });
        this.internalFrame1.add(this.CmbJk);
        this.CmbJk.setBounds(72, 102, 110, 23);
        this.TTlp.setName("TTlp");
        this.TTlp.setSelectedTextColor(new Color(255, 255, 255));
        this.TTlp.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TTlpKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TTlp);
        this.TTlp.setBounds(445, 12, 140, 23);
        this.label7.setText("No.Telp :");
        this.label7.setName("label7");
        this.internalFrame1.add((Component)this.label7);
        this.label7.setBounds(398, 17, 60, 14);
        this.TEmail.setName("TEmail");
        this.TEmail.setSelectedTextColor(new Color(255, 255, 255));
        this.TEmail.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TEmailKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TEmail);
        this.TEmail.setBounds(445, 42, 230, 23);
        this.label8.setText("E-Mail :");
        this.label8.setName("label8");
        this.internalFrame1.add((Component)this.label8);
        this.label8.setBounds(407, 47, 80, 14);
        this.label9.setText("Alamat :");
        this.label9.setName("label9");
        this.internalFrame1.add((Component)this.label9);
        this.label9.setBounds(402, 77, 80, 14);
        this.scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.scrollPane2.setName("scrollPane2");
        this.TAlamat.setColumns(20);
        this.TAlamat.setRows(5);
        this.TAlamat.setFont(new Font("Tahoma", 0, 11));
        this.TAlamat.setName("TAlamat");
        this.TAlamat.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TAlamatKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.TAlamat);
        this.internalFrame1.add(this.scrollPane2);
        this.scrollPane2.setBounds(445, 72, 270, 53);
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
                DlgPetugas.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(14, 150, 100, 30);
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
                DlgPetugas.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnBatalKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnBatal);
        this.BtnBatal.setBounds(117, 150, 100, 30);
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
                DlgPetugas.this.BtnCloseInputActionPerformed(evt);
            }
        });
        this.BtnCloseInput.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnCloseInputKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnCloseInput);
        this.BtnCloseInput.setBounds(616, 150, 100, 30);
        this.label10.setText("Nama :");
        this.label10.setName("label10");
        this.internalFrame1.add((Component)this.label10);
        this.label10.setBounds(35, 47, 80, 14);
        this.DlgInput.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: INPUT DATA PETUGAS ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(238, 10, 250, 21);
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
        this.MnBarcode.setText("Kartu Petugas");
        this.MnBarcode.setName("MnBarcode");
        this.MnBarcode.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPetugas.this.MnBarcodeActionPerformed(evt);
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
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setComponentPopupMenu(this.jPopupMenu1);
        this.scrollPane1.setName("scrollPane1");
        this.tbPetugas.setAutoCreateRowSorter(true);
        this.tbPetugas.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPetugas.setComponentPopupMenu(this.jPopupMenu1);
        this.tbPetugas.setName("tbPetugas");
        this.tbPetugas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgPetugas.this.tbPetugasMouseClicked(evt);
            }
        });
        this.tbPetugas.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.tbPetugasKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPetugas);
        this.jPanel2.add(this.scrollPane1, "Center");
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
                DlgPetugas.this.BtnTambahActionPerformed(evt);
            }
        });
        this.BtnTambah.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnTambahKeyPressed(evt);
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
                DlgPetugas.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnHapusKeyPressed(evt);
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
                DlgPetugas.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnEditKeyPressed(evt);
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
                DlgPetugas.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnPrintKeyPressed(evt);
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
                DlgPetugas.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnAllKeyPressed(evt);
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
                DlgPetugas.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnKeluar);
        this.jPanel2.add(this.internalFrame3, "First");
        this.jPanel1.add(this.jPanel2, "Center");
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
        this.TCari.setSelectedTextColor(new Color(255, 255, 255));
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.TCariKeyPressed(evt);
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
                DlgPetugas.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPetugas.this.BtnCariKeyPressed(evt);
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
        this.jPanel1.add(this.internalFrame2, "Last");
        this.panelJudul2.setName("panelJudul2");
        this.panelJudul2.setPreferredSize(new Dimension(163, 28));
        this.panelJudul2.setLayout(new BorderLayout());
        this.jLabel2.setBackground(Color.darkGray);
        this.jLabel2.setFont(new Font("Book Antiqua", 3, 14));
        this.jLabel2.setForeground(new Color(255, 204, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText(":: DAFTAR PETUGAS ::");
        this.jLabel2.setIconTextGap(2);
        this.jLabel2.setName("jLabel2");
        this.panelJudul2.add(this.jLabel2, "Center");
        this.jPanel1.add(this.panelJudul2, "First");
        this.getContentPane().add(this.jPanel1, "Center");
        this.pack();
    }
    
    private void tbPetugasMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPetugasKeyPressed(final KeyEvent evt) {
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
    
    private void BtnTambahActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.TNip.setEditable(true);
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
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data petugas yang akan Anda hapus dengan menklik data pada tabel...!!!");
            this.tbPetugas.requestFocus();
        }
        else {
            this.Valid.hapusTable(this.tabMode, (JTextField)this.TNip, "petugas", "nip");
            this.tampil();
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
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data petugas yang akan Anda edit dengan menklik data pada tabel...!!!");
            this.tbPetugas.requestFocus();
        }
        else if (!this.TNm.getText().trim().equals("")) {
            this.TNip.setEditable(false);
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
            if (this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("rptPtg.jrxml", "report", "::[ Data Petugas ]::", "select * from petugas order by nip");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("rptPtg.jrxml", "report", "::[ Data Petugas ]::", "select * from petugas where nip like '%" + this.TCari.getText().trim() + "%' " + "or nama_petugas like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by nip");
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
        this.tampil();
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
    
    private void TCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCari);
        }
    }
    
    private void BtnCariActionPerformed(final ActionEvent evt) {
        this.prosesCari("select * from petugas where nip like '%" + this.TCari.getText().trim() + "%' " + "or nama_petugas like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by nip");
    }
    
    private void BtnCariKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCari, (JButton)this.BtnTambah);
        }
    }
    
    private void TNipKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCloseInput, (JTextField)this.TNm);
    }
    
    private void TNmKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNip, (JTextField)this.TTmp);
    }
    
    private void TTmpKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNm, (JComboBox)this.DTPLahir);
    }
    
    private void DTPLahirKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TTmp, this.CmbJk);
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
        this.Valid.pindah(evt, (JTextField)this.TEmail, (JButton)this.BtnSimpan);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TNip.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNip, "NIP");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Nama Petugas");
        }
        else if (this.TTmp.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TTmp, "Tempat Lahir");
        }
        else if (this.TTlp.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TTlp, "No.Telp Petugas");
        }
        else if (this.TEmail.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TEmail, "Email Petugas");
        }
        else if (this.TAlamat.getText().trim().equals("")) {
            this.Valid.textKosong(this.TAlamat, "Alamat Petugas");
        }
        else {
            if (this.TNip.isEditable()) {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.menyimpan("petugas", "'" + this.TNip.getText() + "','" + this.TNm.getText() + "','" + this.TTmp.getText() + "','" + this.DTPLahir.getSelectedItem() + "','" + this.CmbJk.getSelectedItem().toString().substring(0, 1) + "','" + this.TAlamat.getText() + "','" + this.TTlp.getText() + "','" + this.TEmail.getText() + "' ", "NIP");
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
                this.TNip.requestFocus();
            }
            else if (!this.TNip.isEditable()) {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.mengedit("petugas", "nip='" + this.TNip.getText() + "'", "nama_petugas='" + this.TNm.getText() + "'," + "tmp_lahir='" + this.TTmp.getText() + "'," + "tgl_lahir='" + this.DTPLahir.getSelectedItem() + "'," + "j_kel='" + this.CmbJk.getSelectedItem().toString().substring(0, 1) + "'," + "alamat='" + this.TAlamat.getText() + "'," + "no_telp='" + this.TTlp.getText() + "'," + "email='" + this.TEmail.getText() + "'");
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
                this.DlgInput.dispose();
            }
            this.tampil();
            this.emptTeks();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, this.TAlamat, (JButton)this.BtnBatal);
        }
    }
    
    private void BtnBatalActionPerformed(final ActionEvent evt) {
        if (this.TNip.isEditable()) {
            this.emptTeks();
        }
        else if (!this.TNip.isEditable()) {
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
            this.Valid.pindah(evt, (JButton)this.BtnBatal, (JTextField)this.TNip);
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
            if (this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("krtuPtg.jrxml", "report", "::[ Kartu Petugas ]::", "select * from petugas order by nip");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                this.Valid.MyReport("krtuPtg.jrxml", "report", "::[ Kartu Petugas ]::", "select * from petugas where nip like '%" + this.TCari.getText().trim() + "%' " + "or nama_petugas like '%" + this.TCari.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCari.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCari.getText().trim() + "%' " + "or j_kel like '%" + this.TCari.getText().trim() + "%' " + "or alamat like '%" + this.TCari.getText().trim() + "%' " + "or no_telp like '%" + this.TCari.getText().trim() + "%' " + "or email like '%" + this.TCari.getText().trim() + "%' order by nip");
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgPetugas dialog = new DlgPetugas(new JFrame(), true);
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
        final String sql = "select * from petugas order by nip";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) };
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
        this.TNip.setText("");
        this.TNm.setText("");
        this.TTmp.setText("");
        this.DTPLahir.setDate(new Date());
        this.CmbJk.setSelectedIndex(0);
        this.TTlp.setText("");
        this.TEmail.setText("");
        this.TAlamat.setText("");
        this.TCari.setText("");
        this.TNip.requestFocus();
        this.Valid.autoNomer(this.tabMode, "0", 9, (JTextField)this.TNip);
    }
    
    public void focus() {
        this.TCari.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbPetugas.getSelectedRow();
        if (row != -1) {
            this.TNip.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TNm.setText(this.tabMode.getValueAt(row, 1).toString());
            this.TTmp.setText(this.tabMode.getValueAt(row, 2).toString());
            try {
                this.DTPLahir.setDisplayFormat("yyyy-MM-dd");
                final Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(this.tabMode.getValueAt(row, 3).toString());
                this.DTPLahir.setDate(dtpa);
                this.DTPLahir.setDisplayFormat("dd/MM/yyyy");
            }
            catch (ParseException ex) {
                Logger.getLogger(DlgPetugas.class.getName()).log(Level.SEVERE, null, ex);
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
        }
    }
}
