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

public class DlgSetPinjam extends JDialog
{
    private DefaultTableModel tabMode;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnBatal;
    private Button BtnEdit;
    private Button BtnHapus;
    private Button BtnKeluar;
    private Button BtnSimpan;
    private TextBox TBuku;
    private TextBox TDenda;
    private TextBox THari;
    private InternalFrame internalFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JSeparator jSeparator1;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private Table tbSetPinjam;
    
    public DlgSetPinjam(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(458, 290);
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>Maksimal Buku</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Lama Peminjaman(Hari)</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Denda Terlambat Perhari(Rp)</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbSetPinjam.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbSetPinjam.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbSetPinjam.setAutoResizeMode(0);
        for (int i = 0; i < 3; ++i) {
            final TableColumn column = this.tbSetPinjam.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(120);
            }
            else if (i == 1) {
                column.setPreferredWidth(149);
            }
            else if (i == 2) {
                column.setPreferredWidth(185);
            }
        }
        this.tbSetPinjam.setDefaultRenderer(Object.class, new WarnaTable());
        this.TBuku.setDocument((Document)new batasInput(10).getOnlyAngka((JTextField)this.TBuku));
        this.THari.setDocument((Document)new batasInput(10).getOnlyAngka((JTextField)this.THari));
        this.TDenda.setDocument((Document)new batasInput(15).getOnlyAngka((JTextField)this.TDenda));
    }
    
    private void initComponents() {
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.label1 = new Label();
        this.TBuku = new TextBox();
        this.label2 = new Label();
        this.THari = new TextBox();
        this.TDenda = new TextBox();
        this.label3 = new Label();
        this.label4 = new Label();
        this.label5 = new Label();
        this.panelGlass2 = new PanelGlass();
        this.BtnSimpan = new Button();
        this.BtnBatal = new Button();
        this.BtnHapus = new Button();
        this.BtnEdit = new Button();
        this.BtnKeluar = new Button();
        this.scrollPane1 = new ScrollPane();
        this.tbSetPinjam = new Table();
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setUndecorated(true);
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: SETUP PEMINJAMAN ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(105, 10, 250, 20);
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
        this.panelGlass1.setPreferredSize(new Dimension(100, 105));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.label1.setText("Hari");
        this.label1.setName("label1");
        this.panelGlass1.add((Component)this.label1);
        this.label1.setBounds(350, 40, 70, 23);
        this.TBuku.setName("TBuku");
        this.TBuku.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.TBukuKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TBuku);
        this.TBuku.setBounds(184, 10, 160, 23);
        this.label2.setHorizontalAlignment(4);
        this.label2.setText("Maksimal Lama Peminjaman :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(0, 40, 180, 23);
        this.THari.setName("THari");
        this.THari.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.THariKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.THari);
        this.THari.setBounds(184, 40, 160, 23);
        this.TDenda.setName("TDenda");
        this.TDenda.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.TDendaKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TDenda);
        this.TDenda.setBounds(184, 70, 160, 23);
        this.label3.setHorizontalAlignment(4);
        this.label3.setText("Denda Keterlambatan Perhari Rp.");
        this.label3.setName("label3");
        this.panelGlass1.add((Component)this.label3);
        this.label3.setBounds(0, 70, 180, 23);
        this.label4.setHorizontalAlignment(4);
        this.label4.setText("Maksimal Barang Dipinjam :");
        this.label4.setName("label4");
        this.panelGlass1.add((Component)this.label4);
        this.label4.setBounds(0, 10, 180, 23);
        this.label5.setText("Buku");
        this.label5.setName("label5");
        this.panelGlass1.add((Component)this.label5);
        this.label5.setBounds(350, 10, 70, 23);
        this.internalFrame1.add((Component)this.panelGlass1, "First");
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
                DlgSetPinjam.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.BtnSimpanKeyPressed(evt);
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
                DlgSetPinjam.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.BtnBatalKeyPressed(evt);
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
                DlgSetPinjam.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.BtnHapusKeyPressed(evt);
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
                DlgSetPinjam.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.BtnEditKeyPressed(evt);
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
                DlgSetPinjam.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.BtnKeluarKeyPressed(evt);
            }
        });
        this.panelGlass2.add((Component)this.BtnKeluar);
        this.BtnKeluar.setBounds(364, 10, 86, 30);
        this.internalFrame1.add((Component)this.panelGlass2, "Last");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.scrollPane1.setName("scrollPane1");
        this.tbSetPinjam.setAutoCreateRowSorter(true);
        this.tbSetPinjam.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbSetPinjam.setName("tbSetPinjam");
        this.tbSetPinjam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgSetPinjam.this.tbSetPinjamMouseClicked(evt);
            }
        });
        this.tbSetPinjam.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgSetPinjam.this.tbSetPinjamKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbSetPinjam);
        this.internalFrame1.add(this.scrollPane1, "Center");
        this.getContentPane().add(this.internalFrame1, "Center");
        this.pack();
    }
    
    private void TBukuKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JTextField)this.THari);
    }
    
    private void THariKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TBuku, (JTextField)this.TDenda);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TBuku.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TBuku, "Jumlah buku yang boleh dipinjam");
        }
        else if (this.THari.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.THari, "Lamanya peminjaman");
        }
        else if (this.TDenda.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TDenda, "Denda keterlambatan perhari");
        }
        else if (this.tabMode.getRowCount() == 0) {
            this.Sequel.menyimpan("set_peminjaman", "'" + this.TBuku.getText() + "','" + this.THari.getText() + "','" + this.TDenda.getText() + "'", "Set peminjaman");
            this.tampil();
            this.emptTeks();
        }
        else if (this.tabMode.getRowCount() > 0) {
            JOptionPane.showMessageDialog(null, "Maaf, Hanya diijinkan satu setup peminjaman ...!!!!");
            this.TBuku.requestFocus();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TDenda, (JButton)this.BtnBatal);
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
        this.Valid.hapusTable(this.tabMode, (JTextField)this.TBuku, "set_peminjaman", "max_pinjam");
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
        if (this.TBuku.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TBuku, "Jumlah buku yang boleh dipinjam");
        }
        else if (this.THari.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.THari, "Lamanya peminjaman");
        }
        else if (this.TDenda.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TDenda, "Denda keterlambatan perhari");
        }
        else {
            this.Valid.editTable(this.tabMode, "set_peminjaman", "max_pinjam", (JTextField)this.TBuku, "lama_pinjam='" + this.THari.getText() + "',denda_perhari='" + this.TDenda.getText() + "'");
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
        if (this.tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data setup pinjam tidak boleh kosong ...!!!!");
            this.TBuku.requestFocus();
        }
        else if (this.tabMode.getRowCount() != 0) {
            this.dispose();
        }
    }
    
    private void BtnKeluarKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.dispose();
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JTextField)this.TBuku);
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
    
    private void TDendaKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.THari, (JButton)this.BtnSimpan);
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgSetPinjam dialog = new DlgSetPinjam(new JFrame(), true);
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
        final String sql = "select * from set_peminjaman";
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
    }
    
    public void emptTeks() {
        this.TBuku.setText("");
        this.TDenda.setText("");
        this.THari.setText("");
        this.TBuku.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbSetPinjam.getSelectedRow();
        if (row != -1) {
            this.TBuku.setText(this.tabMode.getValueAt(row, 0).toString());
            this.THari.setText(this.tabMode.getValueAt(row, 1).toString());
            this.TDenda.setText(this.tabMode.getValueAt(row, 2).toString());
        }
    }
}
