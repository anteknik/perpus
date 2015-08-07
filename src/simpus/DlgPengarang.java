package simpus;

import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import fungsi.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DlgPengarang extends JDialog
{
    private DefaultTableModel tabModePng;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllPng;
    private Button BtnBatalPng;
    private Button BtnCariPng;
    private Button BtnEditPng;
    private Button BtnHapusPng;
    private Button BtnKeluarPng;
    private Button BtnSimpanPng;
    private Label LCountPng;
    private TextBox TCariPng;
    private TextBox TKdPng;
    private TextBox TNmPng;
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
    private Table tbPengarang;
    
    public DlgPengarang(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(459, 515);
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>ID Merk/Type</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Merk/Type</font></html>" };
        this.tabModePng = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbPengarang.setModel(this.tabModePng);
        this.koneksi.panggilDriver();
        this.tbPengarang.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbPengarang.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbPengarang.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(120);
            }
            else if (i == 1) {
                column.setPreferredWidth(335);
            }
        }
        this.tbPengarang.setDefaultRenderer(Object.class, new WarnaTable());
        this.TKdPng.setDocument((Document)new batasInput(7).getFilter((JTextField)this.TKdPng));
        this.TNmPng.setDocument((Document)new batasInput(40).getFilter((JTextField)this.TNmPng));
        this.TCariPng.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPng));
    }
    
    private void initComponents() {
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.label1 = new Label();
        this.TKdPng = new TextBox();
        this.label2 = new Label();
        this.TNmPng = new TextBox();
        this.scrollPane1 = new ScrollPane();
        this.tbPengarang = new Table();
        this.jPanel1 = new JPanel();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariPng = new TextBox();
        this.BtnCariPng = new Button();
        this.BtnAllPng = new Button();
        this.label4 = new Label();
        this.LCountPng = new Label();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpanPng = new Button();
        this.BtnBatalPng = new Button();
        this.BtnHapusPng = new Button();
        this.BtnEditPng = new Button();
        this.BtnKeluarPng = new Button();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.setDefaultCloseOperation(2);
        this.setBackground(new Color(214, 204, 255));
        this.setResizable(false);
        this.setUndecorated(true);
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: DAFTAR MERK/TYPE ::");
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
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(100, 49));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.label1.setHorizontalAlignment(4);
        this.label1.setText("ID Merk/Type  :");
        this.label1.setName("label1");
        this.panelGlass1.add((Component)this.label1);
        this.label1.setBounds(8, 17, 80, 14);
        this.TKdPng.setName("TKdPng");
        this.TKdPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.TKdPngKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TKdPng);
        this.TKdPng.setBounds(89, 12, 75, 23);
        this.label2.setHorizontalAlignment(4);
        this.label2.setText("Merk/Type :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(174, 17, 100, 14);
        this.TNmPng.setName("TNmPng");
        this.TNmPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.TNmPngKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNmPng);
        this.TNmPng.setBounds(275, 12, 172, 23);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbPengarang.setAutoCreateRowSorter(true);
        this.tbPengarang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPengarang.setName("tbPengarang");
        this.tbPengarang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgPengarang.this.tbPengarangMouseClicked(evt);
            }
        });
        this.tbPengarang.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.tbPengarangKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPengarang);
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
        this.TCariPng.setName("TCariPng");
        this.TCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.TCariPngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariPng);
        this.TCariPng.setBounds(72, 10, 207, 23);
        this.BtnCariPng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPng.setMnemonic('2');
        this.BtnCariPng.setToolTipText("Alt+2");
        this.BtnCariPng.setCursor(new Cursor(12));
        this.BtnCariPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPng.setName("BtnCariPng");
        this.BtnCariPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnCariPngActionPerformed(evt);
            }
        });
        this.BtnCariPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnCariPngKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgPengarang.this.BtnCariPngKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariPng);
        this.BtnCariPng.setBounds(281, 10, 28, 23);
        this.BtnAllPng.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPng.setMnemonic('1');
        this.BtnAllPng.setToolTipText("Alt+1");
        this.BtnAllPng.setCursor(new Cursor(12));
        this.BtnAllPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPng.setName("BtnAllPng");
        this.BtnAllPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnAllPngActionPerformed(evt);
            }
        });
        this.BtnAllPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnAllPngKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPng);
        this.BtnAllPng.setBounds(310, 10, 28, 23);
        this.label4.setText("Record :");
        this.label4.setName("label4");
        this.panelGlass3.add((Component)this.label4);
        this.label4.setBounds(355, 15, 80, 14);
        this.LCountPng.setText("0");
        this.LCountPng.setName("LCountPng");
        this.panelGlass3.add((Component)this.LCountPng);
        this.LCountPng.setBounds(400, 15, 50, 14);
        this.jPanel1.add((Component)this.panelGlass3, "First");
        this.panelGlass2.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass2.setOpaqueImage(false);
        this.panelGlass2.setRound(false);
        this.panelGlass2.setWarna(new Color(90, 0, 90));
        this.panelGlass2.setLayout((LayoutManager)null);
        this.BtnSimpanPng.setMnemonic('S');
        this.BtnSimpanPng.setText("Simpan");
        this.BtnSimpanPng.setToolTipText("Alt+S");
        this.BtnSimpanPng.setCursor(new Cursor(12));
        this.BtnSimpanPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnSimpanPng.setName("BtnSimpanPng");
        this.BtnSimpanPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnSimpanPngActionPerformed(evt);
            }
        });
        this.BtnSimpanPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnSimpanPngKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnSimpanPng);
        this.BtnSimpanPng.setBounds(6, 10, 86, 30);
        this.BtnBatalPng.setMnemonic('B');
        this.BtnBatalPng.setText("Batal");
        this.BtnBatalPng.setToolTipText("Alt+B");
        this.BtnBatalPng.setCursor(new Cursor(12));
        this.BtnBatalPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnBatalPng.setName("BtnBatalPng");
        this.BtnBatalPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnBatalPngActionPerformed(evt);
            }
        });
        this.BtnBatalPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnBatalPngKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnBatalPng);
        this.BtnBatalPng.setBounds(94, 10, 86, 30);
        this.BtnHapusPng.setMnemonic('H');
        this.BtnHapusPng.setText("Hapus");
        this.BtnHapusPng.setToolTipText("Alt+H");
        this.BtnHapusPng.setCursor(new Cursor(12));
        this.BtnHapusPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnHapusPng.setName("BtnHapusPng");
        this.BtnHapusPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnHapusPngActionPerformed(evt);
            }
        });
        this.BtnHapusPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnHapusPngKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnHapusPng);
        this.BtnHapusPng.setBounds(182, 10, 86, 30);
        this.BtnEditPng.setMnemonic('E');
        this.BtnEditPng.setText("Edit");
        this.BtnEditPng.setToolTipText("Alt+E");
        this.BtnEditPng.setCursor(new Cursor(12));
        this.BtnEditPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnEditPng.setName("BtnEditPng");
        this.BtnEditPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnEditPngActionPerformed(evt);
            }
        });
        this.BtnEditPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnEditPngKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnEditPng);
        this.BtnEditPng.setBounds(270, 10, 86, 30);
        this.BtnKeluarPng.setMnemonic('K');
        this.BtnKeluarPng.setText("Keluar");
        this.BtnKeluarPng.setToolTipText("Alt+K");
        this.BtnKeluarPng.setCursor(new Cursor(12));
        this.BtnKeluarPng.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnKeluarPng.setName("BtnKeluarPng");
        this.BtnKeluarPng.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPengarang.this.BtnKeluarPngActionPerformed(evt);
            }
        });
        this.BtnKeluarPng.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPengarang.this.BtnKeluarPngKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluarPng);
        this.BtnKeluarPng.setBounds(364, 10, 86, 30);
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
    
    private void TKdPngKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TCariPng, (JTextField)this.TNmPng);
    }
    
    private void TNmPngKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKdPng, (JButton)this.BtnSimpanPng);
    }
    
    private void BtnSimpanPngActionPerformed(final ActionEvent evt) {
        if (this.TKdPng.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdPng, "ID Merk/Type");
        }
        else if (this.TNmPng.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmPng, "Type/Merk");
        }
        else {
            this.Sequel.menyimpan("pengarang", "'" + this.TKdPng.getText() + "','" + this.TNmPng.getText() + "'", "ID Pengarang");
            this.tampilPng();
            this.emptTeksPng();
        }
    }
    
    private void BtnSimpanPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TNmPng, (JButton)this.BtnBatalPng);
        }
    }
    
    private void BtnBatalPngActionPerformed(final ActionEvent evt) {
        this.emptTeksPng();
    }
    
    private void BtnBatalPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.emptTeksPng();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnSimpanPng, (JButton)this.BtnHapusPng);
        }
    }
    
    private void BtnHapusPngActionPerformed(final ActionEvent evt) {
        this.Valid.hapusTable(this.tabModePng, (JTextField)this.TKdPng, "pengarang", "kode_pengarang");
        this.tampilPng();
        this.emptTeksPng();
    }
    
    private void BtnHapusPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnHapusPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnBatalPng, (JButton)this.BtnEditPng);
        }
    }
    
    private void BtnEditPngActionPerformed(final ActionEvent evt) {
        if (this.TKdPng.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKdPng, "ID Pengarang");
        }
        else if (this.TNmPng.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNmPng, "Nama Pengarang");
        }
        else {
            this.Valid.editTable(this.tabModePng, "pengarang", "kode_pengarang", (JTextField)this.TKdPng, "nama_pengarang='" + this.TNmPng.getText() + "'");
            if (this.tabModePng.getRowCount() != 0) {
                this.tampilPng();
            }
            this.emptTeksPng();
        }
    }
    
    private void BtnEditPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnEditPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnHapusPng, (JButton)this.BtnKeluarPng);
        }
    }
    
    private void BtnKeluarPngActionPerformed(final ActionEvent evt) {
        this.dispose();
    }
    
    private void BtnKeluarPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnEditPng, (JTextField)this.TCariPng);
        }
    }
    
    private void TCariPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnKeluarPng, (JButton)this.BtnCariPng);
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
        this.prosesCariPng("select * from pengarang order by kode_pengarang");
        this.emptTeksPng();
    }
    
    private void BtnAllPngKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllPngActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariPng, (JTextField)this.TKdPng);
        }
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
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgPengarang dialog = new DlgPengarang(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
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
        final int b = this.tabModePng.getRowCount();
        this.LCountPng.setText("" + b);
    }
    
    public void emptTeksPng() {
        this.TKdPng.setText("");
        this.TNmPng.setText("");
        this.TCariPng.setText("");
        this.TKdPng.requestFocus();
        this.Valid.autoNomer(this.tabModePng, "P", 6, (JTextField)this.TKdPng);
    }
    
    private void getDataPng() {
        final int row = this.tbPengarang.getSelectedRow();
        if (row != -1) {
            final String kode = this.tabModePng.getValueAt(row, 0).toString();
            final String nama = this.tabModePng.getValueAt(row, 1).toString();
            this.TKdPng.setText(kode);
            this.TNmPng.setText(nama);
        }
    }
}
