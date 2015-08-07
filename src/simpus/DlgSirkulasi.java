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

public class DlgSirkulasi extends JDialog
{
    private DefaultTableModel tabMode;
    private DefaultTableModel tabModeInventaris;
    private DefaultTableModel tabModePeminjam;
    private DefaultTableModel tabModePetugas;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAll;
    private Button BtnAllAgt;
    private Button BtnAllIn;
    private Button BtnAllPtg;
    private Button BtnBatal;
    private Button BtnCari;
    private Button BtnCariAgt;
    private Button BtnCariIn;
    private Button BtnCariPtg;
    private Button BtnCloseAgt;
    private Button BtnCloseIn;
    private Button BtnCloseInput;
    private Button BtnClosePtg;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnPerpanjang;
    private Button BtnPglAg;
    private Button BtnPglIn;
    private Button BtnPglPnb2;
    private Button BtnPglPnb3;
    private Button BtnPglPt;
    private Button BtnPrint;
    private Button BtnSimpan;
    private Button BtnTambah;
    private JCheckBox ChkCari;
    private CekBox ChkSttsCari;
    private CekBox ChkTglCari;
    private ComboBox CmbSttsCari;
    private JDateTimePicker DTPCari1;
    private JDateTimePicker DTPCari2;
    private JDateTimePicker DTPPinjam;
    private JDialog DlgAnggota;
    private JDialog DlgInput;
    private JDialog DlgInventaris;
    private JDialog DlgPetugas;
    private Label LCount;
    private JLabel LHrIni;
    private JLabel LabelKon;
    private Label LblDenda;
    private Label LblHari;
    private Label LblJmlDenda;
    private Label LblJmlT;
    private JLabel LblPnjm;
    private JLabel LblSetPnjm;
    private Label LblTerlambat;
    private Label LblTgl;
    private InternalFrame PanelCari;
    private JPanel PanelIndukCari;
    private TextBox TCari;
    private TextBox TCariAgt;
    private TextBox TCariIn;
    private TextBox TCariPtg;
    private TextBox TNip;
    private TextBox TNmA;
    private TextBox TNmI;
    private TextBox TNmP;
    private TextBox TNoA;
    private TextBox TNoACari;
    private TextBox TNoI;
    private TextBox TNoICari;
    private TextBox TPnb;
    private TextBox TPng;
    private TextBox TStts;
    private JTextField TTglKmbli;
    private JTextField TTglPnjm;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private InternalFrame internalFrame4;
    private InternalFrame internalFrame5;
    private InternalFrame internalFrame6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label11;
    private Label label12;
    private Label label13;
    private Label label15;
    private Label label16;
    private Label label17;
    private Label label18;
    private Label label19;
    private Label label2;
    private Label label24;
    private Label label25;
    private Label label3;
    private Label label4;
    private Label label6;
    private Label label7;
    private Label label8;
    private Label label9;
    private JLabel lblIjnKdl;
    private JLabel lblTglKdl;
    private Panel panel1;
    private Panel panel2;
    private PanelGlass panelGlass3;
    private PanelGlass panelGlass6;
    private PanelGlass panelGlass7;
    private PanelJudul panelJudul1;
    private PanelJudul panelJudul2;
    private ScrollPane scrollPane1;
    private ScrollPane scrollPane2;
    private ScrollPane scrollPane3;
    private ScrollPane scrollPane4;
    private Table tbInventaris;
    private Table tbPeminjam;
    private Table tbPeminjaman;
    private Table tbPetugas;
    
    public DlgSirkulasi(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Pinjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Kembali</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Petugas</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPeminjaman.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbPeminjaman.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPeminjaman.setAutoResizeMode(0);
        for (int i = 0; i < 14; ++i) {
            final TableColumn column = this.tbPeminjaman.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(150);
            }
            else if (i == 1) {
                column.setPreferredWidth(150);
            }
            else if (i == 2) {
                column.setPreferredWidth(300);
            }
            else if (i == 3) {
                column.setPreferredWidth(150);
            }
            else if (i == 4) {
                column.setPreferredWidth(150);
            }
            else if (i == 5) {
                column.setPreferredWidth(80);
            }
            else if (i == 6) {
                column.setPreferredWidth(150);
            }
            else if (i == 7) {
                column.setPreferredWidth(150);
            }
            else if (i == 8) {
                column.setPreferredWidth(150);
            }
            else if (i == 9) {
                column.setPreferredWidth(150);
            }
            else if (i == 10) {
                column.setPreferredWidth(250);
            }
            else if (i == 11) {
                column.setPreferredWidth(150);
            }
            else if (i == 12) {
                column.setPreferredWidth(150);
            }
            else if (i == 13) {
                column.setPreferredWidth(250);
            }
        }
        this.tbPeminjaman.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowIn = { "<html><font color='#006699' face='Comic Sans MS'>No.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kode Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jml.Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Produsen</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Type/Merk</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Thn.Produksi</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nomer ISBN</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Kategori Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Jenis Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Asal Barang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Pengadaan</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Harga</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Stts.Inventaris</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Ruang</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Rak</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Box</font></html>" };
        this.tabModeInventaris = new DefaultTableModel((Object[][])null, rowIn) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbInventaris.setModel(this.tabModeInventaris);
        this.tbInventaris.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbInventaris.setAutoResizeMode(0);
        for (int j = 0; j < 17; ++j) {
            final TableColumn column2 = this.tbInventaris.getColumnModel().getColumn(j);
            if (j == 0) {
                column2.setPreferredWidth(100);
            }
            else if (j == 1) {
                column2.setPreferredWidth(100);
            }
            else if (j == 2) {
                column2.setPreferredWidth(350);
            }
            else if (j == 3) {
                column2.setPreferredWidth(60);
            }
            else if (j == 4) {
                column2.setPreferredWidth(200);
            }
            else if (j == 5) {
                column2.setPreferredWidth(200);
            }
            else if (j == 6) {
                column2.setPreferredWidth(70);
            }
            else if (j == 7) {
                column2.setPreferredWidth(150);
            }
            else if (j == 8) {
                column2.setPreferredWidth(160);
            }
            else if (j == 9) {
                column2.setPreferredWidth(100);
            }
            else if (j == 10) {
                column2.setPreferredWidth(150);
            }
            else if (j == 11) {
                column2.setPreferredWidth(100);
            }
            else if (j == 12) {
                column2.setPreferredWidth(100);
            }
            else if (j == 13) {
                column2.setPreferredWidth(100);
            }
            else if (j == 14) {
                column2.setPreferredWidth(150);
            }
            else if (j == 15) {
                column2.setPreferredWidth(60);
            }
            else if (j == 16) {
                column2.setPreferredWidth(60);
            }
        }
        this.tbInventaris.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowPeminjam = { "<html><font color='#006699' face='Comic Sans MS'>No.Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Peminjam</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tgl.Bergabung</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Keanggotaan Habis</font></html>" };
        this.tabModePeminjam = new DefaultTableModel((Object[][])null, rowPeminjam) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPeminjam.setModel(this.tabModePeminjam);
        this.tbPeminjam.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPeminjam.setAutoResizeMode(0);
        for (int k = 0; k < 10; ++k) {
            final TableColumn column3 = this.tbPeminjam.getColumnModel().getColumn(k);
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
        this.tbPeminjam.setDefaultRenderer(Object.class, new WarnaTable());
        final Object[] rowPtg = { "<html><font color='#006699' face='Comic Sans MS'>NIP</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Nama Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tempat Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Tanggal Lahir</font></html>", "<html><font color='#006699' face='Comic Sans MS'>J.K.</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Alamat Petugas</font></html>", "<html><font color='#006699' face='Comic Sans MS'>No.Telp</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Email</font></html>" };
        this.tabModePetugas = new DefaultTableModel((Object[][])null, rowPtg) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPetugas.setModel(this.tabModePetugas);
        this.tbPetugas.setPreferredScrollableViewportSize(new Dimension(700, 700));
        this.tbPetugas.setAutoResizeMode(0);
        for (int l = 0; l < 8; ++l) {
            final TableColumn column4 = this.tbPetugas.getColumnModel().getColumn(l);
            if (l == 0) {
                column4.setPreferredWidth(100);
            }
            else if (l == 1) {
                column4.setPreferredWidth(260);
            }
            else if (l == 2) {
                column4.setPreferredWidth(150);
            }
            else if (l == 3) {
                column4.setPreferredWidth(130);
            }
            else if (l == 4) {
                column4.setPreferredWidth(50);
            }
            else if (l == 5) {
                column4.setPreferredWidth(350);
            }
            else if (l == 6) {
                column4.setPreferredWidth(110);
            }
            else if (l == 7) {
                column4.setPreferredWidth(180);
            }
        }
        this.tbPetugas.setDefaultRenderer(Object.class, new WarnaTable());
        this.TNoI.setDocument((Document)new batasInput(20).getFilter((JTextField)this.TNoI));
        this.TNoA.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNoA));
        this.TNip.setDocument((Document)new batasInput(10).getFilter((JTextField)this.TNip));
        this.TCari.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCari));
        this.TCariIn.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariIn));
        this.TCariAgt.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariAgt));
        this.TCariPtg.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPtg));
        this.TCari.requestFocus();
        this.TNoI.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isIn();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isIn();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isIn();
            }
        });
        this.TNoA.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPeminjam();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPeminjam();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPeminjam();
            }
        });
        this.TNip.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPtg();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPtg();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isPtg();
            }
        });
        this.TNoACari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
        });
        this.TNoICari.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
            
            public void removeUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
            
            public void changedUpdate(final DocumentEvent e) {
                DlgSirkulasi.this.isCari();
            }
        });
        this.ChkCariActionPerformed(null);
        this.DlgInput.setSize(734, 293);
        this.DlgInput.setVisible(false);
        this.DlgInventaris.setSize(450, 280);
        this.DlgInventaris.setVisible(false);
        this.DlgAnggota.setSize(450, 280);
        this.DlgAnggota.setVisible(false);
        this.DlgPetugas.setSize(450, 280);
        this.DlgPetugas.setVisible(false);
        this.LabelKon.setVisible(false);
    }
    
    private void initComponents() {
        this.DlgInput = new JDialog();
        this.internalFrame1 = new InternalFrame();
        this.TNoI = new TextBox();
        this.label1 = new Label();
        this.TStts = new TextBox();
        this.TPnb = new TextBox();
        this.label2 = new Label();
        this.TNoA = new TextBox();
        this.DTPPinjam = new JDateTimePicker();
        this.LblTgl = new Label();
        this.label7 = new Label();
        this.TNmI = new TextBox();
        this.BtnSimpan = new Button();
        this.LblHari = new Label();
        this.BtnBatal = new Button();
        this.BtnCloseInput = new Button();
        this.BtnPglIn = new Button();
        this.TPng = new TextBox();
        this.label11 = new Label();
        this.TNmA = new TextBox();
        this.label6 = new Label();
        this.BtnPglAg = new Button();
        this.TNip = new TextBox();
        this.label8 = new Label();
        this.TNmP = new TextBox();
        this.BtnPglPt = new Button();
        this.BtnPerpanjang = new Button();
        this.label12 = new Label();
        this.LblDenda = new Label();
        this.LblJmlDenda = new Label();
        this.LblTerlambat = new Label();
        this.LblJmlT = new Label();
        this.panelJudul2 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.panel1 = new Panel();
        this.LabelKon = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.DlgInventaris = new JDialog();
        this.internalFrame4 = new InternalFrame();
        this.panelGlass7 = new PanelGlass();
        this.label17 = new Label();
        this.TCariIn = new TextBox();
        this.BtnCariIn = new Button();
        this.BtnAllIn = new Button();
        this.label18 = new Label();
        this.BtnCloseIn = new Button();
        this.scrollPane4 = new ScrollPane();
        this.tbInventaris = new Table();
        this.DlgAnggota = new JDialog();
        this.internalFrame5 = new InternalFrame();
        this.panelGlass6 = new PanelGlass();
        this.label9 = new Label();
        this.TCariAgt = new TextBox();
        this.BtnCariAgt = new Button();
        this.BtnAllAgt = new Button();
        this.label16 = new Label();
        this.BtnCloseAgt = new Button();
        this.scrollPane3 = new ScrollPane();
        this.tbPeminjam = new Table();
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
        this.LHrIni = new JLabel();
        this.TTglPnjm = new JTextField();
        this.TTglKmbli = new JTextField();
        this.LblPnjm = new JLabel();
        this.LblSetPnjm = new JLabel();
        this.lblIjnKdl = new JLabel();
        this.lblTglKdl = new JLabel();
        this.jPanel1 = new JPanel();
        this.panelJudul1 = new PanelJudul();
        this.jLabel2 = new JLabel();
        this.jPanel2 = new JPanel();
        this.internalFrame3 = new InternalFrame();
        this.BtnTambah = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnPrint = new Button();
        this.BtnAll = new Button();
        this.BtnKeluar = new Button();
        this.scrollPane1 = new ScrollPane();
        this.tbPeminjaman = new Table();
        this.PanelIndukCari = new JPanel();
        this.internalFrame2 = new InternalFrame();
        this.label3 = new Label();
        this.TCari = new TextBox();
        this.BtnCari = new Button();
        this.label4 = new Label();
        this.LCount = new Label();
        this.PanelCari = new InternalFrame();
        this.ChkSttsCari = new CekBox();
        this.CmbSttsCari = new ComboBox();
        this.ChkTglCari = new CekBox();
        this.DTPCari1 = new JDateTimePicker();
        this.label13 = new Label();
        this.DTPCari2 = new JDateTimePicker();
        this.label24 = new Label();
        this.TNoICari = new TextBox();
        this.BtnPglPnb2 = new Button();
        this.label25 = new Label();
        this.TNoACari = new TextBox();
        this.BtnPglPnb3 = new Button();
        this.panel2 = new Panel();
        this.ChkCari = new JCheckBox();
        this.DlgInput.setDefaultCloseOperation(2);
        this.DlgInput.setBackground(new Color(255, 200, 255));
        this.DlgInput.setModal(true);
        this.DlgInput.setName("DlgInput");
        this.DlgInput.setResizable(false);
        this.DlgInput.setUndecorated(true);
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(null);
        this.TNoI.setName("TNoI");
        this.TNoI.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TNoIKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNoI);
        this.TNoI.setBounds(93, 12, 130, 23);
        this.label1.setHorizontalAlignment(4);
        this.label1.setText("No.Inventaris :");
        this.label1.setName("label1");
        this.internalFrame1.add((Component)this.label1);
        this.label1.setBounds(11, 12, 80, 23);
        this.TStts.setEditable(false);
        this.TStts.setName("TStts");
        this.internalFrame1.add((Component)this.TStts);
        this.TStts.setBounds(93, 72, 240, 23);
        this.TPnb.setEditable(false);
        this.TPnb.setName("TPnb");
        this.internalFrame1.add((Component)this.TPnb);
        this.TPnb.setBounds(447, 42, 240, 23);
        this.label2.setForeground(new Color(153, 153, 255));
        this.label2.setText("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        this.label2.setName("label2");
        this.internalFrame1.add((Component)this.label2);
        this.label2.setBounds(-11, 160, 830, 14);
        this.TNoA.setName("TNoA");
        this.TNoA.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TNoAKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNoA);
        this.TNoA.setBounds(93, 102, 130, 23);
        this.DTPPinjam.setBackground(new Color(90, 0, 90));
        this.DTPPinjam.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPPinjam.setEditable(false);
        this.DTPPinjam.setForeground(new Color(205, 214, 255));
        this.DTPPinjam.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPPinjam.setDisplayFormat("yyyy/MM/dd");
        this.DTPPinjam.setName("DTPPinjam");
        this.DTPPinjam.addItemListener((ItemListener)new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgSirkulasi.this.DTPPinjamItemStateChanged(evt);
            }
        });
        this.DTPPinjam.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.DTPPinjamKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.DTPPinjam);
        this.DTPPinjam.setBounds(447, 72, 110, 23);
        this.LblTgl.setText("Tgl.Pinjam :");
        this.LblTgl.setName("LblTgl");
        this.internalFrame1.add((Component)this.LblTgl);
        this.LblTgl.setBounds(388, 72, 80, 23);
        this.label7.setHorizontalAlignment(4);
        this.label7.setText("Peminjam :");
        this.label7.setName("label7");
        this.internalFrame1.add((Component)this.label7);
        this.label7.setBounds(11, 102, 80, 23);
        this.TNmI.setEditable(false);
        this.TNmI.setName("TNmI");
        this.internalFrame1.add((Component)this.TNmI);
        this.TNmI.setBounds(225, 12, 462, 23);
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
                DlgSirkulasi.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnSimpanKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnSimpan);
        this.BtnSimpan.setBounds(14, 180, 100, 30);
        this.LblHari.setText("Hari");
        this.LblHari.setName("LblHari");
        this.internalFrame1.add((Component)this.LblHari);
        this.LblHari.setBounds(530, 175, 60, 23);
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
                DlgSirkulasi.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnBatalKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCloseInputActionPerformed(evt);
            }
        });
        this.BtnCloseInput.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCloseInputKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnCloseInput);
        this.BtnCloseInput.setBounds(616, 180, 100, 30);
        this.BtnPglIn.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglIn.setMnemonic('1');
        this.BtnPglIn.setToolTipText("Alt+1");
        this.BtnPglIn.setCursor(new Cursor(12));
        this.BtnPglIn.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglIn.setName("BtnPglIn");
        this.BtnPglIn.setPreferredSize(new Dimension(100, 30));
        this.BtnPglIn.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPglInActionPerformed(evt);
            }
        });
        this.BtnPglIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnPglInKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglIn);
        this.BtnPglIn.setBounds(690, 12, 25, 23);
        this.TPng.setEditable(false);
        this.TPng.setName("TPng");
        this.internalFrame1.add((Component)this.TPng);
        this.TPng.setBounds(93, 42, 240, 23);
        this.label11.setHorizontalAlignment(4);
        this.label11.setText("Produsen :");
        this.label11.setName("label11");
        this.internalFrame1.add((Component)this.label11);
        this.label11.setBounds(11, 42, 80, 23);
        this.TNmA.setEditable(false);
        this.TNmA.setName("TNmA");
        this.internalFrame1.add((Component)this.TNmA);
        this.TNmA.setBounds(225, 102, 462, 23);
        this.label6.setHorizontalAlignment(4);
        this.label6.setText("Status Inv :");
        this.label6.setName("label6");
        this.internalFrame1.add((Component)this.label6);
        this.label6.setBounds(11, 72, 80, 23);
        this.BtnPglAg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglAg.setMnemonic('2');
        this.BtnPglAg.setToolTipText("Alt+2");
        this.BtnPglAg.setCursor(new Cursor(12));
        this.BtnPglAg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglAg.setName("BtnPglAg");
        this.BtnPglAg.setPreferredSize(new Dimension(100, 30));
        this.BtnPglAg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPglAgActionPerformed(evt);
            }
        });
        this.BtnPglAg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnPglAgKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglAg);
        this.BtnPglAg.setBounds(690, 102, 25, 23);
        this.TNip.setName("TNip");
        this.TNip.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TNipKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.TNip);
        this.TNip.setBounds(93, 132, 130, 23);
        this.label8.setHorizontalAlignment(4);
        this.label8.setText("Petugas :");
        this.label8.setName("label8");
        this.internalFrame1.add((Component)this.label8);
        this.label8.setBounds(11, 132, 80, 23);
        this.TNmP.setEditable(false);
        this.TNmP.setName("TNmP");
        this.internalFrame1.add((Component)this.TNmP);
        this.TNmP.setBounds(225, 132, 462, 23);
        this.BtnPglPt.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPt.setMnemonic('3');
        this.BtnPglPt.setToolTipText("Alt+3");
        this.BtnPglPt.setCursor(new Cursor(12));
        this.BtnPglPt.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPt.setName("BtnPglPt");
        this.BtnPglPt.setPreferredSize(new Dimension(100, 30));
        this.BtnPglPt.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPglPtActionPerformed(evt);
            }
        });
        this.BtnPglPt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnPglPtKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPglPt);
        this.BtnPglPt.setBounds(690, 132, 25, 23);
        this.BtnPerpanjang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/19.png")));
        this.BtnPerpanjang.setMnemonic('P');
        this.BtnPerpanjang.setText("Perpanjang");
        this.BtnPerpanjang.setToolTipText("Alt+P");
        this.BtnPerpanjang.setCursor(new Cursor(12));
        this.BtnPerpanjang.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPerpanjang.setName("BtnPerpanjang");
        this.BtnPerpanjang.setPreferredSize(new Dimension(100, 30));
        this.BtnPerpanjang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPerpanjangActionPerformed(evt);
            }
        });
        this.BtnPerpanjang.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnPerpanjangKeyPressed(evt);
            }
        });
        this.internalFrame1.add((Component)this.BtnPerpanjang);
        this.BtnPerpanjang.setBounds(220, 180, 115, 30);
        this.label12.setText("Type/Merk :");
        this.label12.setName("label12");
        this.internalFrame1.add((Component)this.label12);
        this.label12.setBounds(388, 42, 80, 23);
        this.LblDenda.setText("Besarnya Denda : Rp.");
        this.LblDenda.setName("LblDenda");
        this.internalFrame1.add((Component)this.LblDenda);
        this.LblDenda.setBounds(360, 192, 120, 23);
        this.LblJmlDenda.setText("0");
        this.LblJmlDenda.setName("LblJmlDenda");
        this.internalFrame1.add((Component)this.LblJmlDenda);
        this.LblJmlDenda.setBounds(470, 192, 140, 23);
        this.LblTerlambat.setText("Keterlambatan :");
        this.LblTerlambat.setName("LblTerlambat");
        this.internalFrame1.add((Component)this.LblTerlambat);
        this.LblTerlambat.setBounds(369, 175, 260, 23);
        this.LblJmlT.setText("0");
        this.LblJmlT.setName("LblJmlT");
        this.internalFrame1.add((Component)this.LblJmlT);
        this.LblJmlT.setBounds(449, 175, 80, 23);
        this.DlgInput.getContentPane().add(this.internalFrame1, "Center");
        this.panelJudul2.setName("panelJudul2");
        this.panelJudul2.setPreferredSize(new Dimension(440, 40));
        this.panelJudul2.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: INPUT PEMINJAMAN ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul2.add(this.jLabel1);
        this.jLabel1.setBounds(238, 10, 250, 20);
        this.jLabel3.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel3.setName("jLabel3");
        this.panelJudul2.add(this.jLabel3);
        this.jLabel3.setBounds(5, 0, 40, 40);
        this.DlgInput.getContentPane().add(this.panelJudul2, "First");
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
        this.DlgInventaris.setModal(true);
        this.DlgInventaris.setName("DlgInventaris");
        this.DlgInventaris.setResizable(false);
        this.DlgInventaris.setUndecorated(true);
        this.internalFrame4.setName("internalFrame4");
        this.internalFrame4.setLayout(new BorderLayout(1, 1));
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
        this.TCariIn.setPreferredSize(new Dimension(230, 23));
        this.TCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TCariInKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCariInActionPerformed(evt);
            }
        });
        this.BtnCariIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariInKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariInKeyReleased(evt);
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
                DlgSirkulasi.this.BtnAllInActionPerformed(evt);
            }
        });
        this.BtnAllIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnAllInKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCloseInActionPerformed(evt);
            }
        });
        this.BtnCloseIn.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCloseInKeyPressed(evt);
            }
        });
        this.panelGlass7.add((Component)this.BtnCloseIn);
        this.internalFrame4.add((Component)this.panelGlass7, "First");
        this.scrollPane4.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane4.setName("scrollPane4");
        this.tbInventaris.setAutoCreateRowSorter(true);
        this.tbInventaris.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbInventaris.setName("tbInventaris");
        this.tbInventaris.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSirkulasi.this.tbInventarisMouseClicked(evt);
            }
        });
        this.tbInventaris.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.tbInventarisKeyPressed(evt);
            }
        });
        this.scrollPane4.setViewportView(this.tbInventaris);
        this.internalFrame4.add(this.scrollPane4, "Center");
        this.DlgInventaris.getContentPane().add(this.internalFrame4, "Center");
        this.DlgAnggota.setModal(true);
        this.DlgAnggota.setName("DlgAnggota");
        this.DlgAnggota.setResizable(false);
        this.DlgAnggota.setUndecorated(true);
        this.internalFrame5.setName("internalFrame5");
        this.internalFrame5.setLayout(new BorderLayout(1, 1));
        this.panelGlass6.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass6.setOpaqueImage(false);
        this.panelGlass6.setPreferredSize(new Dimension(40, 44));
        this.panelGlass6.setRound(false);
        this.panelGlass6.setWarna(new Color(90, 0, 90));
        this.panelGlass6.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label9.setHorizontalAlignment(4);
        this.label9.setText("Key Word :");
        this.label9.setName("label9");
        this.label9.setPreferredSize(new Dimension(63, 23));
        this.panelGlass6.add((Component)this.label9);
        this.TCariAgt.setName("TCariAgt");
        this.TCariAgt.setPreferredSize(new Dimension(230, 23));
        this.TCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TCariAgtKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCariAgtActionPerformed(evt);
            }
        });
        this.BtnCariAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariAgtKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariAgtKeyReleased(evt);
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
                DlgSirkulasi.this.BtnAllAgtActionPerformed(evt);
            }
        });
        this.BtnAllAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnAllAgtKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCloseAgtActionPerformed(evt);
            }
        });
        this.BtnCloseAgt.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCloseAgtKeyPressed(evt);
            }
        });
        this.panelGlass6.add((Component)this.BtnCloseAgt);
        this.internalFrame5.add((Component)this.panelGlass6, "First");
        this.scrollPane3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane3.setName("scrollPane3");
        this.tbPeminjam.setAutoCreateRowSorter(true);
        this.tbPeminjam.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPeminjam.setName("tbPeminjam");
        this.tbPeminjam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSirkulasi.this.tbPeminjamMouseClicked(evt);
            }
        });
        this.tbPeminjam.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.tbPeminjamKeyPressed(evt);
            }
        });
        this.scrollPane3.setViewportView(this.tbPeminjam);
        this.internalFrame5.add(this.scrollPane3, "Center");
        this.DlgAnggota.getContentPane().add(this.internalFrame5, "Center");
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
                DlgSirkulasi.this.TCariPtgKeyPressed(evt);
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
                DlgSirkulasi.this.BtnCariPtgActionPerformed(evt);
            }
        });
        this.BtnCariPtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariPtgKeyPressed(evt);
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
                DlgSirkulasi.this.BtnAllPtgActionPerformed(evt);
            }
        });
        this.BtnAllPtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnAllPtgKeyPressed(evt);
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
                DlgSirkulasi.this.BtnClosePtgActionPerformed(evt);
            }
        });
        this.BtnClosePtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnClosePtgKeyPressed(evt);
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
                DlgSirkulasi.this.tbPetugasMouseClicked(evt);
            }
        });
        this.tbPetugas.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.tbPetugasKeyPressed(evt);
            }
        });
        this.scrollPane2.setViewportView(this.tbPetugas);
        this.internalFrame6.add(this.scrollPane2, "Center");
        this.DlgPetugas.getContentPane().add(this.internalFrame6, "Center");
        this.LHrIni.setText("jLabel4");
        this.LHrIni.setName("LHrIni");
        this.TTglPnjm.setName("TTglPnjm");
        this.TTglKmbli.setName("TTglKmbli");
        this.LblPnjm.setForeground(new Color(255, 255, 255));
        this.LblPnjm.setText("0");
        this.LblPnjm.setName("LblPnjm");
        this.LblSetPnjm.setForeground(new Color(255, 255, 255));
        this.LblSetPnjm.setText("0");
        this.LblSetPnjm.setName("LblSetPnjm");
        this.lblIjnKdl.setForeground(new Color(255, 255, 255));
        this.lblIjnKdl.setText("0");
        this.lblIjnKdl.setName("lblIjnKdl");
        this.lblTglKdl.setForeground(new Color(255, 255, 255));
        this.lblTglKdl.setText("0");
        this.lblTglKdl.setName("lblTglKdl");
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setUndecorated(true);
        this.jPanel1.setBackground(new Color(90, 0, 90));
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setLayout(new BorderLayout(1, 1));
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(163, 28));
        this.panelJudul1.setLayout(new BorderLayout());
        this.jLabel2.setBackground(Color.darkGray);
        this.jLabel2.setFont(new Font("Book Antiqua", 3, 14));
        this.jLabel2.setForeground(new Color(255, 204, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText(":: SIRKULASI INVENTARIS ::");
        this.jLabel2.setIconTextGap(2);
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2, "Center");
        this.jPanel1.add(this.panelJudul1, "First");
        this.jPanel2.setBackground(new Color(90, 0, 90));
        this.jPanel2.setName("jPanel2");
        this.jPanel2.setLayout(new BorderLayout(1, 1));
        this.internalFrame3.setName("internalFrame3");
        this.internalFrame3.setPreferredSize(new Dimension(639, 40));
        this.internalFrame3.setLayout(new FlowLayout(0));
        this.BtnTambah.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/34.png")));
        this.BtnTambah.setMnemonic('T');
        this.BtnTambah.setText("Pinjam");
        this.BtnTambah.setToolTipText("Alt+T");
        this.BtnTambah.setCursor(new Cursor(12));
        this.BtnTambah.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnTambah.setName("BtnTambah");
        this.BtnTambah.setPreferredSize(new Dimension(100, 30));
        this.BtnTambah.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnTambahActionPerformed(evt);
            }
        });
        this.BtnTambah.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnTambahKeyPressed(evt);
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
                DlgSirkulasi.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnHapusKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnHapus);
        this.BtnEdit.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/36.png")));
        this.BtnEdit.setMnemonic('E');
        this.BtnEdit.setText("Kembali");
        this.BtnEdit.setToolTipText("Alt+E");
        this.BtnEdit.setCursor(new Cursor(12));
        this.BtnEdit.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnEdit.setName("BtnEdit");
        this.BtnEdit.setPreferredSize(new Dimension(100, 30));
        this.BtnEdit.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnEditKeyPressed(evt);
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
                DlgSirkulasi.this.BtnPrintActionPerformed(evt);
            }
        });
        this.BtnPrint.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnPrintKeyPressed(evt);
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
                DlgSirkulasi.this.BtnAllActionPerformed(evt);
            }
        });
        this.BtnAll.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnAllKeyPressed(evt);
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
                DlgSirkulasi.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.internalFrame3.add((Component)this.BtnKeluar);
        this.jPanel2.add(this.internalFrame3, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbPeminjaman.setAutoCreateRowSorter(true);
        this.tbPeminjaman.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPeminjaman.setName("tbPeminjaman");
        this.tbPeminjaman.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSirkulasi.this.tbPeminjamanMouseClicked(evt);
            }
        });
        this.tbPeminjaman.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.tbPeminjamanKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPeminjaman);
        this.jPanel2.add(this.scrollPane1, "Center");
        this.jPanel1.add(this.jPanel2, "Center");
        this.PanelIndukCari.setBackground(new Color(90, 0, 90));
        this.PanelIndukCari.setName("PanelIndukCari");
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
        this.TCari.setPreferredSize(new Dimension(430, 23));
        this.TCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.TCariKeyPressed(evt);
            }
            
            public void keyTyped(final KeyEvent evt) {
                DlgSirkulasi.this.TCariKeyTyped(evt);
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
                DlgSirkulasi.this.BtnCariActionPerformed(evt);
            }
        });
        this.BtnCari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSirkulasi.this.BtnCariKeyPressed(evt);
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
        this.PanelCari.setLayout(null);
        this.ChkSttsCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSttsCari.setText("Stts.Pnjm :");
        this.ChkSttsCari.setHorizontalAlignment(4);
        this.ChkSttsCari.setHorizontalTextPosition(4);
        this.ChkSttsCari.setName("ChkSttsCari");
        this.ChkSttsCari.setPreferredSize(new Dimension(80, 23));
        this.ChkSttsCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkSttsCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSttsCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkSttsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgSirkulasi.this.ChkSttsCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkSttsCari);
        this.ChkSttsCari.setBounds(3, 7, 80, 23);
        this.CmbSttsCari.setModel(new DefaultComboBoxModel<Object>(new String[] { "MASIH DIPINJAM", "SUDAH KEMBALI" }));
        this.CmbSttsCari.setName("CmbSttsCari");
        this.CmbSttsCari.setPreferredSize(new Dimension(125, 23));
        this.CmbSttsCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgSirkulasi.this.CmbSttsCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.CmbSttsCari);
        this.CmbSttsCari.setBounds(85, 7, 188, 23);
        this.ChkTglCari.setIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkTglCari.setText("Tgl.Pnjm :");
        this.ChkTglCari.setHorizontalAlignment(4);
        this.ChkTglCari.setHorizontalTextPosition(4);
        this.ChkTglCari.setIconTextGap(8);
        this.ChkTglCari.setName("ChkTglCari");
        this.ChkTglCari.setPreferredSize(new Dimension(77, 23));
        this.ChkTglCari.setRolloverIcon(new ImageIcon(this.getClass().getResource("/picture/011.png")));
        this.ChkTglCari.setRolloverSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkTglCari.setSelectedIcon(new ImageIcon(this.getClass().getResource("/picture/checked.png")));
        this.ChkTglCari.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent evt) {
                DlgSirkulasi.this.ChkTglCariItemStateChanged(evt);
            }
        });
        this.PanelCari.add(this.ChkTglCari);
        this.ChkTglCari.setBounds(6, 37, 77, 23);
        this.DTPCari1.setBackground(new Color(90, 0, 90));
        this.DTPCari1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.DTPCari1.setEditable(false);
        this.DTPCari1.setForeground(new Color(205, 214, 255));
        this.DTPCari1.setModel((ComboBoxModel)new DefaultComboBoxModel(new String[] { "2011/11/17" }));
        this.DTPCari1.setDisplayFormat("yyyy/MM/dd");
        this.DTPCari1.setName("DTPCari1");
        this.DTPCari1.setPreferredSize(new Dimension(82, 23));
        this.PanelCari.add((Component)this.DTPCari1);
        this.DTPCari1.setBounds(85, 37, 85, 23);
        this.label13.setHorizontalAlignment(4);
        this.label13.setText("Sd");
        this.label13.setHorizontalTextPosition(0);
        this.label13.setName("label13");
        this.label13.setPreferredSize(new Dimension(14, 23));
        this.PanelCari.add((Component)this.label13);
        this.label13.setBounds(171, 37, 14, 23);
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
                DlgSirkulasi.this.DTPCari2ItemStateChanged(evt);
            }
        });
        this.PanelCari.add((Component)this.DTPCari2);
        this.DTPCari2.setBounds(188, 37, 85, 23);
        this.label24.setHorizontalAlignment(4);
        this.label24.setText("No.Anggota :");
        this.label24.setName("label24");
        this.PanelCari.add((Component)this.label24);
        this.label24.setBounds(333, 37, 80, 23);
        this.TNoICari.setEditable(false);
        this.TNoICari.setMaximumSize(new Dimension(430, 23));
        this.TNoICari.setMinimumSize(new Dimension(430, 23));
        this.TNoICari.setName("TNoICari");
        this.TNoICari.setPreferredSize(new Dimension(100, 23));
        this.PanelCari.add((Component)this.TNoICari);
        this.TNoICari.setBounds(416, 7, 180, 23);
        this.BtnPglPnb2.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb2.setMnemonic('1');
        this.BtnPglPnb2.setToolTipText("Alt+1");
        this.BtnPglPnb2.setCursor(new Cursor(12));
        this.BtnPglPnb2.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb2.setName("BtnPglPnb2");
        this.BtnPglPnb2.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb2.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPglPnb2ActionPerformed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb2);
        this.BtnPglPnb2.setBounds(598, 7, 25, 23);
        this.label25.setHorizontalAlignment(4);
        this.label25.setText("No.Inventaris :");
        this.label25.setName("label25");
        this.PanelCari.add((Component)this.label25);
        this.label25.setBounds(333, 7, 80, 23);
        this.TNoACari.setEditable(false);
        this.TNoACari.setMaximumSize(new Dimension(430, 23));
        this.TNoACari.setMinimumSize(new Dimension(430, 23));
        this.TNoACari.setName("TNoACari");
        this.TNoACari.setPreferredSize(new Dimension(100, 23));
        this.PanelCari.add((Component)this.TNoACari);
        this.TNoACari.setBounds(416, 37, 180, 23);
        this.BtnPglPnb3.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/190.png")));
        this.BtnPglPnb3.setMnemonic('2');
        this.BtnPglPnb3.setToolTipText("Alt+2");
        this.BtnPglPnb3.setCursor(new Cursor(12));
        this.BtnPglPnb3.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnPglPnb3.setName("BtnPglPnb3");
        this.BtnPglPnb3.setPreferredSize(new Dimension(25, 23));
        this.BtnPglPnb3.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgSirkulasi.this.BtnPglPnb3ActionPerformed(evt);
            }
        });
        this.PanelCari.add((Component)this.BtnPglPnb3);
        this.BtnPglPnb3.setBounds(598, 37, 25, 23);
        this.PanelIndukCari.add(this.PanelCari, "Center");
        this.panel2.setBackground(new Color(40, 0, 40));
        this.panel2.setBorder(BorderFactory.createLineBorder(new Color(74, 54, 105)));
        this.panel2.setName("panel2");
        this.panel2.setOpaque(false);
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
                DlgSirkulasi.this.ChkCariActionPerformed(evt);
            }
        });
        this.panel2.add(this.ChkCari, "Center");
        this.PanelIndukCari.add(this.panel2, "First");
        this.jPanel1.add(this.PanelIndukCari, "Last");
        this.getContentPane().add(this.jPanel1, "Center");
        this.pack();
    }
    
    private void BtnTambahActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.LblTgl.setText("Tgl.Pinjam :");
        this.LblTgl.setLocation(388, 72);
        this.LblJmlT.setVisible(false);
        this.LblHari.setVisible(false);
        this.LblDenda.setVisible(false);
        this.LblJmlDenda.setVisible(false);
        this.BtnPerpanjang.setVisible(false);
        this.BtnPglAg.setEnabled(true);
        this.BtnPglIn.setEnabled(true);
        this.BtnPglPt.setEnabled(true);
        this.isDay();
        this.LabelKon.setVisible(true);
        this.TNoI.setEditable(true);
        this.TNoA.setEditable(true);
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
        if (this.tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            this.TCari.requestFocus();
        }
        else if (this.TNmI.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (this.TTglKmbli.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Data Peminjaman dengan No.Inventaris " + this.TNoI.getText() + ",\nyang dipinjam Peminjam dengan No.Peminjam " + this.TNoA.getText() + "\npada tanggal " + this.TTglPnjm.getText() + " belum dikembalikan.\nData belum bisa anda hapus...!!!!");
        }
        else if (!this.TNmI.getText().trim().equals("") && !this.TTglKmbli.getText().trim().equals("")) {
            try {
                this.Sequel.queryu("delete from peminjaman where no_anggota='" + this.TNoA.getText() + "' and no_inventaris='" + this.TNoI.getText() + "' and tgl_pinjam='" + this.TTglPnjm.getText() + "'");
                this.tampil("");
            }
            catch (Exception e) {
                System.out.println("Pesan Error : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Silahkan anda pilih terlebih dulu data yang mau anda hapus...\n Klik data pada table untuk memilih data...!!!!");
            }
        }
        this.emptTeks();
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
        else if (this.TPnb.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Pilih dulu data peminjaman yang akan dikembalikan dengan menklik data pada tabel...!!!");
            this.tbPeminjaman.requestFocus();
        }
        else if (!this.TTglKmbli.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Inventaris sudah dikembalikan pada tanggal " + this.TTglKmbli.getText() + "...!!!");
            this.tbPeminjaman.requestFocus();
        }
        else if (!this.TPnb.getText().trim().equals("") && this.TTglKmbli.getText().trim().equals("")) {
            this.TNoI.setEditable(false);
            this.TNoA.setEditable(false);
            this.LblTgl.setText("Tgl.Kembali :");
            this.LblTgl.setLocation(383, 72);
            this.LblJmlT.setVisible(true);
            this.LblHari.setVisible(true);
            this.LblDenda.setVisible(true);
            this.LblJmlDenda.setVisible(true);
            this.BtnPerpanjang.setVisible(true);
            this.LabelKon.setVisible(true);
            this.LblTerlambat.setText("Keterlambatan :");
            this.BtnPglAg.setEnabled(false);
            this.BtnPglIn.setEnabled(false);
            this.BtnPglPt.setEnabled(true);
            this.isDaySub();
            this.BtnPerpanjang.setVisible(true);
            this.TPnb.requestFocus();
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
                this.Valid.MyReport("rptSirkulasi.jrxml", "report", "::[ Data Sirkulasi ]::", "select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip  order by peminjaman.tgl_pinjam");
            }
            else if (!this.TCari.getText().trim().equals("")) {
                final String sql = " peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip ";
                this.Valid.MyReport("rptSirkulasi.jrxml", "report", "::[ Data Sirkulasi ]::", "select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where " + sql + "and peminjaman.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and inventaris.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.tgl_pinjam like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.tgl_kembali like '%" + this.TCari.getText().trim() + "%' or " + sql + "and petugas.nama_petugas like '%" + this.TCari.getText().trim() + "%' " + " order by peminjaman.tgl_pinjam");
            }
            else if (this.TCari.getText().trim().equals("") && this.ChkCari.isVisible()) {
                String status = "0";
                String key = "";
                if (this.CmbSttsCari.getSelectedItem().equals("MASIH DIPINJAM")) {
                    status = "0";
                }
                else if (this.CmbSttsCari.getSelectedItem().equals("SUDAH KEMBALI")) {
                    status = "1";
                }
                if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "";
                }
                else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ";
                }
                else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
                    key = "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ";
                }
                this.Valid.MyReport("rptSirkulasi.jrxml", "report", "::[ Data Sirkulasi ]::", "select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip " + key + " order by peminjaman.tgl_pinjam");
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
        this.TNoACari.setText("");
        this.TNoICari.setText("");
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
    
    private void tbPeminjamanMouseClicked(final MouseEvent evt) {
        if (this.tabMode.getRowCount() != 0) {
            try {
                this.getData();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPeminjamanKeyPressed(final KeyEvent evt) {
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
        final String sql = " peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip ";
        this.prosesCari("select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where " + sql + "and peminjaman.no_inventaris like '%" + this.TCari.getText().trim() + "%' or " + sql + "and inventaris.kode_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCari.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCari.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCari.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCari.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.no_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.tgl_pinjam like '%" + this.TCari.getText().trim() + "%' or " + sql + "and peminjaman.tgl_kembali like '%" + this.TCari.getText().trim() + "%' or " + sql + "and petugas.nama_petugas like '%" + this.TCari.getText().trim() + "%' " + " order by peminjaman.tgl_pinjam");
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
            this.CmbSttsCariItemStateChanged(null);
        }
        else if (!this.ChkCari.isSelected()) {
            this.PanelCari.setVisible(false);
            this.PanelIndukCari.setPreferredSize(new Dimension(1, 61));
            this.BtnCariActionPerformed(null);
        }
    }
    
    private void TNoIKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnCloseInput, (JTextField)this.TNoA);
    }
    
    private void TNoAKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNoI, (JTextField)this.TNip);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        this.isSetPinjam();
        if (this.LblSetPnjm.getText().trim().equals("") || this.LblSetPnjm.getText().trim().equals("0")) {
            this.Valid.textKosong((JTextField)this.TNoI, "Setup Peminjaman");
        }
        else if (this.TNoI.getText().trim().equals("") || this.TNmI.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoI, "Inventaris");
        }
        else if (this.TNoA.getText().trim().equals("") || this.TNmA.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoA, "Peminjam");
        }
        else if (this.TNip.getText().trim().equals("") || this.TNmP.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNip, "Petugas");
        }
        else {
            if (this.TNoI.isEditable()) {
                if (this.lblIjnKdl.getText().trim().equals("tidak")) {
                    JOptionPane.showMessageDialog(null, "Maaf, keanggotaan dengan No.Peminjam " + this.TNoA.getText() + " telah habis pada tanggal " + this.lblTglKdl.getText() + ".\nSilahkan anda perpanjang keanggotaan dulu ..!!!");
                    this.TNoI.requestFocus();
                }
                else if (this.LblPnjm.getText().trim().equals("tidak")) {
                    JOptionPane.showMessageDialog(null, "Maaf, maksimal peminjaman " + this.LblSetPnjm.getText() + "...!!!");
                    this.TNoI.requestFocus();
                }
                else if (!this.TStts.getText().trim().equals("ADA")) {
                    JOptionPane.showMessageDialog(null, "Maaf, Barang " + this.TStts.getText() + "...!!!");
                    this.TNoI.requestFocus();
                }
                else if (this.TStts.getText().trim().equals("ADA")) {
                    this.Sequel.menyimpan("peminjaman", "'" + this.TNoA.getText() + "','" + this.TNoI.getText() + "','" + this.DTPPinjam.getSelectedItem() + "','0000-00-00','" + this.TNip.getText() + "','0'", "NIP");
                    this.Sequel.queryu("update inventaris set status_buku='DIPINJAM' where no_inventaris='" + this.TNoI.getText() + "'");
                    this.TNoI.requestFocus();
                    this.TNoI.setText("");
                }
            }
            else if (!this.TNoI.isEditable()) {
                this.DTPPinjam.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.queryu("update peminjaman set tgl_kembali='" + this.DTPPinjam.getSelectedItem() + "',nip='" + this.TNip.getText() + "',status_pinjam='1' where no_anggota='" + this.TNoA.getText() + "' and no_inventaris='" + this.TNoI.getText() + "' and tgl_pinjam='" + this.TTglPnjm.getText() + "'");
                this.Sequel.queryu("update inventaris set status_buku='ADA' where no_inventaris='" + this.TNoI.getText() + "'");
                this.DTPPinjam.setDisplayFormat("dd/MM/yyyy");
                this.emptTeks();
                this.DlgInput.dispose();
            }
            this.tampil("");
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TNip, (JButton)this.BtnBatal);
        }
    }
    
    private void BtnBatalActionPerformed(final ActionEvent evt) {
        if (this.TNoI.isEditable()) {
            this.emptTeks();
        }
        else if (!this.TNoI.isEditable()) {
            this.emptTeks();
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
    
    private void BtnCloseInputActionPerformed(final ActionEvent evt) {
        this.emptTeks();
        this.LabelKon.setVisible(false);
        this.DlgInput.dispose();
    }
    
    private void BtnCloseInputKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.DlgInput.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnBatal, (JTextField)this.TNoI);
        }
    }
    
    private void DTPPinjamKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglInActionPerformed(final ActionEvent evt) {
        this.tampilIn("");
        this.DlgInventaris.setLocationRelativeTo(null);
        this.DlgInventaris.setVisible(true);
    }
    
    private void BtnPglInKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnPglAgActionPerformed(final ActionEvent evt) {
        this.tampilPeminjam("");
        this.DlgAnggota.setLocationRelativeTo(null);
        this.DlgAnggota.setVisible(true);
    }
    
    private void BtnPglAgKeyPressed(final KeyEvent evt) {
    }
    
    private void TNipKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TNoA, (JButton)this.BtnSimpan);
    }
    
    private void BtnPglPtActionPerformed(final ActionEvent evt) {
        this.tampilPtg();
        this.DlgPetugas.setLocationRelativeTo(null);
        this.DlgPetugas.setVisible(true);
    }
    
    private void BtnPglPtKeyPressed(final KeyEvent evt) {
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
        this.DlgInventaris.dispose();
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
    
    private void TCariAgtKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariAgtActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseAgt, (JButton)this.BtnCariAgt);
        }
    }
    
    private void BtnCariAgtActionPerformed(final ActionEvent evt) {
        this.prosesCariPeminjam("select * from anggota where no_anggota like '%" + this.TCariAgt.getText().trim() + "%' " + "or nama_anggota like '%" + this.TCariAgt.getText().trim() + "%' " + "or tmp_lahir like '%" + this.TCariAgt.getText().trim() + "%' " + "or tgl_lahir like '%" + this.TCariAgt.getText().trim() + "%' " + "or j_kel like '%" + this.TCariAgt.getText().trim() + "%' " + "or alamat like '%" + this.TCariAgt.getText().trim() + "%' " + "or no_telp like '%" + this.TCariAgt.getText().trim() + "%' " + "or tgl_gabung like '%" + this.TCariAgt.getText().trim() + "%' " + "or masa_berlaku like '%" + this.TCariAgt.getText().trim() + "%' " + "or email like '%" + this.TCariAgt.getText().trim() + "%' order by no_anggota");
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
        this.tampilPeminjam("");
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
        this.DlgAnggota.dispose();
    }
    
    private void BtnCloseAgtKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnAllAgt, (JTextField)this.TCariAgt);
    }
    
    private void tbPeminjamMouseClicked(final MouseEvent evt) {
        if (this.tabModePeminjam.getRowCount() != 0) {
            try {
                this.getDataPeminjam();
            }
            catch (NullPointerException ex) {}
        }
    }
    
    private void tbPeminjamKeyPressed(final KeyEvent evt) {
        if (this.tabModePeminjam.getRowCount() != 0) {
            if (evt.getKeyCode() != 10 && evt.getKeyCode() != 38) {
                if (evt.getKeyCode() != 40) {
                    return;
                }
            }
            try {
                this.getDataPeminjam();
            }
            catch (NullPointerException ex) {}
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
    
    private void TCariPtgKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPtgActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JButton)this.BtnCariPtg);
        }
    }
    
    private void BtnPerpanjangActionPerformed(final ActionEvent evt) {
        if (this.TNoI.getText().trim().equals("") || this.TNmI.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoI, "Inventaris");
        }
        else if (this.TNoA.getText().trim().equals("") || this.TNmA.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoI, "Peminjam");
        }
        else if (this.TNip.getText().trim().equals("") || this.TNmP.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNoI, "Petugas");
        }
        else {
            if (!this.TNoI.isEditable()) {
                this.DTPPinjam.setDisplayFormat("yyyy-MM-dd");
                this.Sequel.queryu("update peminjaman set tgl_pinjam='" + this.DTPPinjam.getSelectedItem() + "',nip='" + this.TNip.getText() + "' where no_anggota='" + this.TNoA.getText() + "' and no_inventaris='" + this.TNoI.getText() + "' and tgl_pinjam='" + this.TTglPnjm.getText() + "'");
                this.DTPPinjam.setDisplayFormat("dd/MM/yyyy");
                this.DlgInput.dispose();
            }
            this.tampil("");
            this.emptTeks();
        }
    }
    
    private void BtnPerpanjangKeyPressed(final KeyEvent evt) {
    }
    
    private void DTPPinjamItemStateChanged(final ItemEvent evt) {
        if (this.TNoI.isEditable()) {
            this.isDay();
        }
        else if (!this.TNoI.isEditable()) {
            this.isDaySub();
        }
    }
    
    private void BtnPglPnb2ActionPerformed(final ActionEvent evt) {
        this.tampilIn("");
        this.DlgInventaris.setLocationRelativeTo(null);
        this.DlgInventaris.setVisible(true);
    }
    
    private void BtnPglPnb3ActionPerformed(final ActionEvent evt) {
        this.tampilPeminjam("");
        this.DlgAnggota.setLocationRelativeTo(null);
        this.DlgAnggota.setVisible(true);
    }
    
    private void CmbSttsCariItemStateChanged(final ItemEvent evt) {
        this.isCari();
    }
    
    private void ChkSttsCariItemStateChanged(final ItemEvent evt) {
        this.isCari();
    }
    
    private void ChkTglCariItemStateChanged(final ItemEvent evt) {
        this.isCari();
    }
    
    private void DTPCari2ItemStateChanged(final ItemEvent evt) {
        this.isCari();
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
                final DlgSirkulasi dialog = new DlgSirkulasi(new JFrame(), true);
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
        final String sql = "select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip " + key + " order by peminjaman.tgl_pinjam";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6).substring(0, 4), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14) };
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
        this.TNoA.setText("");
        this.TNoI.setText("");
        this.TNip.setText("");
        this.TTglKmbli.setText("");
        this.TTglPnjm.setText("");
        this.DTPPinjam.requestFocus();
        this.DTPPinjam.setDate(new Date());
        this.DTPPinjam.setDisplayFormat("yyyy-MM-dd");
    }
    
    public void focus() {
        this.ChkCariActionPerformed(null);
        this.TCari.requestFocus();
    }
    
    private void getData() {
        this.TTglKmbli.setText("");
        this.TTglPnjm.setText("");
        final int row = this.tbPeminjaman.getSelectedRow();
        if (row != -1) {
            this.TNoI.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TNoA.setText(this.tabMode.getValueAt(row, 9).toString());
            this.TTglPnjm.setText(this.tabMode.getValueAt(row, 11).toString());
            this.TTglKmbli.setText(this.tabMode.getValueAt(row, 12).toString());
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
            if (this.LabelKon.isVisible()) {
                this.TNoI.setText(this.tabModeInventaris.getValueAt(row, 0).toString());
            }
            else if (!this.LabelKon.isVisible()) {
                this.TNoICari.setText(this.tabModeInventaris.getValueAt(row, 0).toString());
            }
            this.TNmI.setText(this.tabModeInventaris.getValueAt(row, 2).toString());
            this.TPnb.setText(this.tabModeInventaris.getValueAt(row, 4).toString());
            this.TPng.setText(this.tabModeInventaris.getValueAt(row, 5).toString());
            this.TStts.setText(this.tabModeInventaris.getValueAt(row, 13).toString());
        }
    }
    
    private void isIn() {
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery("SELECT buku.judul_buku, penerbit.nama_penerbit, pengarang.nama_pengarang, Inventaris.status_buku from inventaris,buku,pengarang,penerbit where inventaris.kode_buku=buku.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and inventaris.no_inventaris='" + this.TNoI.getText().toString() + "'");
            if (rs.next()) {
                this.TNmI.setText(rs.getString(1));
                this.TPnb.setText(rs.getString(2));
                this.TPng.setText(rs.getString(3));
                this.TStts.setText(rs.getString(4));
            }
            else {
                this.TNmI.setText("");
                this.TPnb.setText("");
                this.TPng.setText("");
                this.TStts.setText("");
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    public void tampilPeminjam(final String key) {
        final String sql = "select * from anggota " + key + " order by no_anggota";
        this.prosesCariPeminjam(sql);
    }
    
    private void prosesCariPeminjam(final String sql) {
        this.Valid.tabelKosong(this.tabModePeminjam);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10) };
                this.tabModePeminjam.addRow(data);
            }
            stat.close();
        }
        catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }
    
    private void getDataPeminjam() {
        final int row = this.tbPeminjam.getSelectedRow();
        if (row != -1) {
            if (this.LabelKon.isVisible()) {
                this.TNoA.setText(this.tabModePeminjam.getValueAt(row, 0).toString());
            }
            else if (!this.LabelKon.isVisible()) {
                this.TNoACari.setText(this.tabModePeminjam.getValueAt(row, 0).toString());
            }
            this.TNmA.setText(this.tabModePeminjam.getValueAt(row, 1).toString());
        }
    }
    
    private void isPeminjam() {
        this.Sequel.cariIsi("select nama_anggota from anggota where no_anggota='" + this.TNoA.getText() + "'", (JTextField)this.TNmA);
        this.Sequel.cariIsi("select masa_berlaku from anggota where no_anggota='" + this.TNoA.getText() + "'", this.lblTglKdl);
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
    
    private void isDay() {
        this.Sequel.cariIsi("select date_add('" + this.DTPPinjam.getSelectedItem() + "',interval (select lama_pinjam from set_peminjaman) day) as hari", this.LHrIni);
        this.LblTerlambat.setText("Tgl.Harus Kembali : " + this.LHrIni.getText());
    }
    
    private void isDaySub() {
        this.Sequel.cariIsi("select TO_DAYS('" + this.DTPPinjam.getSelectedItem() + "')-TO_DAYS(date_add('" + this.TTglPnjm.getText() + "',interval (select lama_pinjam from set_peminjaman) day)) as day", this.LHrIni);
        this.Sequel.cariIsi("select if(" + this.LHrIni.getText() + " >0," + this.LHrIni.getText() + ",0)", (JLabel)this.LblJmlT);
        this.Sequel.cariIsi("select ifnull(" + this.LblJmlT.getText() + "*(select denda_perhari from set_peminjaman),0)", (JLabel)this.LblJmlDenda);
    }
    
    public void isSetPinjam() {
        this.Sequel.cariIsi("select max_pinjam from set_peminjaman", this.LblSetPnjm);
        this.Sequel.cariIsi("select if(count(no_anggota)<'" + this.LblSetPnjm.getText() + "','boleh','tidak') as jml " + "from peminjaman where  no_anggota='" + this.TNoA.getText() + "' and status_pinjam ='0'", this.LblPnjm);
        this.Sequel.cariIsi("select if('" + this.lblTglKdl.getText() + "'>'" + this.DTPPinjam.getSelectedItem() + "','boleh','tidak') as jml " + "from anggota where  no_anggota='" + this.TNoA.getText() + "' ", this.lblIjnKdl);
    }
    
    private void isCari() {
        String status = "0";
        if (this.CmbSttsCari.getSelectedItem().equals("MASIH DIPINJAM")) {
            status = "0";
        }
        else if (this.CmbSttsCari.getSelectedItem().equals("SUDAH KEMBALI")) {
            status = "1";
        }
        if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("");
        }
        else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.status_pinjam='" + status + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' " + "and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.tgl_pinjam between '" + this.DTPCari1.getSelectedItem() + "' and '" + this.DTPCari2.getSelectedItem() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' " + "and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && !this.TNoICari.getText().equals("") && this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.no_inventaris='" + this.TNoICari.getText() + "' ");
        }
        else if (!this.ChkSttsCari.isSelected() && !this.ChkTglCari.isSelected() && this.TNoICari.getText().equals("") && !this.TNoACari.getText().equals("")) {
            this.tampil("and peminjaman.no_anggota='" + this.TNoACari.getText() + "' ");
        }
    }
}
