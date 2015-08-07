package simpus;

import cari.*;
import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import fungsi.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DlgPusatData extends JDialog
{
    private DefaultTableModel tabMode;
    koneksiDB koneksi;
    sekuel Sequel;
    validasi Valid;
    private Button BtnAllPnj;
    private Button BtnCariPnj;
    private Button BtnCloseKtg;
    private Label LCount;
    private TextBox TCariPnj;
    private CariAnggota cariAnggota1;
    private CariInventaris cariInventaris1;
    private CariPenerbit cariPenerbit1;
    private CariPengarang cariPengarang1;
    private InternalFrame internalFrame1;
    private InternalFrame internalFrame2;
    private InternalFrame internalFrame3;
    private InternalFrame internalFrame4;
    private InternalFrame internalFrame5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JSeparator jSeparator1;
    private JTabbedPane jTabbedPane1;
    private Label label3;
    private Label label4;
    private Label label5;
    private Panel panel1;
    private PanelGlass panelGlass3;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private Table tbPeminjaman;
    
    public DlgPusatData(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setSize(850, 630);
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
        this.TCariPnj.setDocument((Document)new batasInput(100).getFilter((JTextField)this.TCariPnj));
    }
    
    private void initComponents() {
        this.panel1 = new Panel();
        this.jLabel5 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.BtnCloseKtg = new Button();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTabbedPane1 = new JTabbedPane();
        this.internalFrame1 = new InternalFrame();
        this.cariInventaris1 = new CariInventaris();
        this.internalFrame2 = new InternalFrame();
        this.cariAnggota1 = new CariAnggota();
        this.internalFrame3 = new InternalFrame();
        this.cariPenerbit1 = new CariPenerbit();
        this.internalFrame4 = new InternalFrame();
        this.panelGlass3 = new PanelGlass();
        this.label3 = new Label();
        this.TCariPnj = new TextBox();
        this.BtnCariPnj = new Button();
        this.BtnAllPnj = new Button();
        this.label4 = new Label();
        this.label5 = new Label();
        this.LCount = new Label();
        this.scrollPane1 = new ScrollPane();
        this.tbPeminjaman = new Table();
        this.internalFrame5 = new InternalFrame();
        this.cariPengarang1 = new CariPengarang();
        this.setDefaultCloseOperation(2);
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.panel1.setName("panel1");
        this.panel1.setPreferredSize(new Dimension(440, 27));
        this.panel1.setLayout(new BorderLayout());
        this.jLabel5.setBackground(Color.darkGray);
        this.jLabel5.setFont(new Font("Tahoma", 1, 11));
        this.jLabel5.setForeground(new Color(255, 204, 255));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText(":: Silahkan masukkan keyword pencarian, untuk pencarian tanggal gunakan format yyyy-mm-dd ::");
        this.jLabel5.setName("jLabel5");
        this.panel1.add(this.jLabel5, "Center");
        this.jSeparator1.setBackground(new Color(0, 0, 51));
        this.jSeparator1.setForeground(new Color(0, 0, 51));
        this.jSeparator1.setName("jSeparator1");
        this.jSeparator1.setPreferredSize(new Dimension(1, 1));
        this.panel1.add(this.jSeparator1, "First");
        this.BtnCloseKtg.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/exit.png")));
        this.BtnCloseKtg.setMnemonic('3');
        this.BtnCloseKtg.setToolTipText("Alt+3");
        this.BtnCloseKtg.setCursor(new Cursor(12));
        this.BtnCloseKtg.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCloseKtg.setName("BtnCloseKtg");
        this.BtnCloseKtg.setPreferredSize(new Dimension(40, 23));
        this.BtnCloseKtg.setRoundRect(false);
        this.BtnCloseKtg.addMouseListener((MouseListener)new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgPusatData.this.BtnCloseKtgMouseClicked(evt);
            }
        });
        this.BtnCloseKtg.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPusatData.this.BtnCloseKtgActionPerformed(evt);
            }
        });
        this.BtnCloseKtg.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPusatData.this.BtnCloseKtgKeyPressed(evt);
            }
        });
        this.panel1.add((Component)this.BtnCloseKtg, "West");
        this.getContentPane().add(this.panel1, "Last");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(new BorderLayout());
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: PUSAT PENCARIAN DATA ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1, "Center");
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2, "West");
        this.getContentPane().add(this.panelJudul1, "First");
        this.jTabbedPane1.setBackground(new Color(90, 0, 90));
        this.jTabbedPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.jTabbedPane1.setForeground(new Color(153, 51, 0));
        this.jTabbedPane1.setName("jTabbedPane1");
        this.jTabbedPane1.setOpaque(true);
        this.internalFrame1.setBorder(null);
        this.internalFrame1.setForeground(new Color(255, 153, 204));
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout());
        this.cariInventaris1.setName("cariInventaris1");
        this.internalFrame1.add(this.cariInventaris1, "Center");
        this.jTabbedPane1.addTab("  .: Pencarian Inventaris :.  ", this.internalFrame1);
        this.internalFrame2.setBorder(null);
        this.internalFrame2.setForeground(new Color(255, 153, 204));
        this.internalFrame2.setName("internalFrame2");
        this.internalFrame2.setLayout(new BorderLayout());
        this.cariAnggota1.setName("cariAnggota1");
        this.internalFrame2.add(this.cariAnggota1, "Center");
        this.jTabbedPane1.addTab("  .: Pencarian Peminjam :.  ", this.internalFrame2);
        this.internalFrame3.setBorder(null);
        this.internalFrame3.setForeground(new Color(255, 153, 204));
        this.internalFrame3.setName("internalFrame3");
        this.internalFrame3.setLayout(new BorderLayout());
        this.cariPenerbit1.setName("cariPenerbit1");
        this.internalFrame3.add(this.cariPenerbit1, "Center");
        this.jTabbedPane1.addTab("  .: Pencarian Produsen :.  ", this.internalFrame3);
        this.internalFrame4.setBorder(null);
        this.internalFrame4.setForeground(new Color(255, 153, 204));
        this.internalFrame4.setName("internalFrame4");
        this.internalFrame4.setLayout(new BorderLayout());
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(40, 44));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)new FlowLayout(0, 5, 9));
        this.label3.setHorizontalAlignment(4);
        this.label3.setText("Key Word :");
        this.label3.setName("label3");
        this.label3.setPreferredSize(new Dimension(63, 23));
        this.panelGlass3.add((Component)this.label3);
        this.TCariPnj.setName("TCariPnj");
        this.TCariPnj.setPreferredSize(new Dimension(500, 23));
        this.TCariPnj.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPusatData.this.TCariPnjKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.TCariPnj);
        this.BtnCariPnj.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/accept.png")));
        this.BtnCariPnj.setMnemonic('2');
        this.BtnCariPnj.setToolTipText("Alt+2");
        this.BtnCariPnj.setCursor(new Cursor(12));
        this.BtnCariPnj.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnCariPnj.setName("BtnCariPnj");
        this.BtnCariPnj.setPreferredSize(new Dimension(26, 23));
        this.BtnCariPnj.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPusatData.this.BtnCariPnjActionPerformed(evt);
            }
        });
        this.BtnCariPnj.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPusatData.this.BtnCariPnjKeyPressed(evt);
            }
            
            public void keyReleased(final KeyEvent evt) {
                DlgPusatData.this.BtnCariPnjKeyReleased(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnCariPnj);
        this.BtnAllPnj.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Search-16x16.png")));
        this.BtnAllPnj.setMnemonic('1');
        this.BtnAllPnj.setToolTipText("Alt+1");
        this.BtnAllPnj.setCursor(new Cursor(12));
        this.BtnAllPnj.setFont(new Font("Comic Sans MS", 1, 12));
        this.BtnAllPnj.setName("BtnAllPnj");
        this.BtnAllPnj.setPreferredSize(new Dimension(26, 23));
        this.BtnAllPnj.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgPusatData.this.BtnAllPnjActionPerformed(evt);
            }
        });
        this.BtnAllPnj.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPusatData.this.BtnAllPnjKeyPressed(evt);
            }
        });
        this.panelGlass3.add((Component)this.BtnAllPnj);
        this.label4.setHorizontalAlignment(4);
        this.label4.setName("label4");
        this.label4.setPreferredSize(new Dimension(33, 23));
        this.panelGlass3.add((Component)this.label4);
        this.label5.setHorizontalAlignment(4);
        this.label5.setText("Record :");
        this.label5.setHorizontalTextPosition(0);
        this.label5.setName("label5");
        this.label5.setPreferredSize(new Dimension(50, 23));
        this.panelGlass3.add((Component)this.label5);
        this.LCount.setHorizontalAlignment(2);
        this.LCount.setText("0");
        this.LCount.setHorizontalTextPosition(0);
        this.LCount.setName("LCount");
        this.LCount.setPreferredSize(new Dimension(50, 23));
        this.panelGlass3.add((Component)this.LCount);
        this.internalFrame4.add((Component)this.panelGlass3, "Last");
        this.scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(90, 0, 90)));
        this.scrollPane1.setName("scrollPane1");
        this.tbPeminjaman.setAutoCreateRowSorter(true);
        this.tbPeminjaman.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        this.tbPeminjaman.setName("tbPeminjaman");
        this.tbPeminjaman.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent evt) {
                DlgPusatData.this.tbPeminjamanMouseClicked(evt);
            }
        });
        this.tbPeminjaman.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgPusatData.this.tbPeminjamanKeyPressed(evt);
            }
        });
        this.scrollPane1.setViewportView(this.tbPeminjaman);
        this.internalFrame4.add(this.scrollPane1, "Center");
        this.jTabbedPane1.addTab("  .: Pencarian Peminjaman :.  ", this.internalFrame4);
        this.internalFrame5.setBorder(null);
        this.internalFrame5.setForeground(new Color(255, 153, 204));
        this.internalFrame5.setName("internalFrame5");
        this.internalFrame5.setLayout(new BorderLayout());
        this.cariPengarang1.setName("cariPengarang1");
        this.internalFrame5.add(this.cariPengarang1, "Center");
        this.jTabbedPane1.addTab("  .: Pencarian Type/Merk :.  ", this.internalFrame5);
        this.getContentPane().add(this.jTabbedPane1, "Center");
        this.pack();
    }
    
    private void BtnCloseKtgActionPerformed(final ActionEvent evt) {
        this.dispose();
    }
    
    private void BtnCloseKtgKeyPressed(final KeyEvent evt) {
        this.dispose();
    }
    
    private void TCariPnjKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPnjActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCloseKtg, (JButton)this.BtnCariPnj);
        }
    }
    
    private void BtnCariPnjActionPerformed(final ActionEvent evt) {
        final String sql = " peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip ";
        this.prosesCariPnj("select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where " + sql + "and peminjaman.no_inventaris like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and inventaris.kode_buku like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and buku.judul_buku like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and penerbit.nama_penerbit like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and pengarang.nama_pengarang like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and buku.thn_terbit like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and buku.isbn like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and kategori.nama_kategori like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and jenis_buku.nama_jenis like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and peminjaman.no_anggota like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and anggota.nama_anggota like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and peminjaman.tgl_pinjam like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and peminjaman.tgl_kembali like '%" + this.TCariPnj.getText().trim() + "%' or " + sql + "and petugas.nama_petugas like '%" + this.TCariPnj.getText().trim() + "%' " + " order by peminjaman.tgl_pinjam");
    }
    
    private void BtnCariPnjKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnCariPnjActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TCariPnj, (JButton)this.BtnAllPnj);
        }
    }
    
    private void BtnCariPnjKeyReleased(final KeyEvent evt) {
    }
    
    private void BtnAllPnjActionPerformed(final ActionEvent evt) {
        this.tampilPnj("");
    }
    
    private void BtnAllPnjKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnAllPnjActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JButton)this.BtnCariPnj, (JButton)this.BtnCloseKtg);
        }
    }
    
    private void tbPeminjamanMouseClicked(final MouseEvent evt) {
    }
    
    private void tbPeminjamanKeyPressed(final KeyEvent evt) {
    }
    
    private void BtnCloseKtgMouseClicked(final MouseEvent evt) {
        this.dispose();
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgPusatData dialog = new DlgPusatData(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void tampilPnj(final String key) {
        final String sql = "select peminjaman.no_inventaris,inventaris.kode_buku,buku.judul_buku,penerbit.nama_penerbit,pengarang.nama_pengarang,buku.thn_terbit, buku.isbn,kategori.nama_kategori,jenis_buku.nama_jenis,peminjaman.no_anggota,anggota.nama_anggota,peminjaman.tgl_pinjam,peminjaman.tgl_kembali,petugas.nama_petugas from peminjaman,inventaris,buku,penerbit,pengarang,kategori,jenis_buku,anggota,petugas where peminjaman.no_inventaris=inventaris.no_inventaris and buku.kode_buku=inventaris.kode_buku and buku.kode_penerbit=penerbit.kode_penerbit and buku.kode_pengarang=pengarang.kode_pengarang and buku.id_kategori=kategori.id_kategori and buku.id_jenis=jenis_buku.id_jenis and anggota.no_anggota=peminjaman.no_anggota and petugas.nip=peminjaman.nip " + key + " order by peminjaman.tgl_pinjam";
        this.prosesCariPnj(sql);
    }
    
    private void prosesCariPnj(final String sql) {
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
}
