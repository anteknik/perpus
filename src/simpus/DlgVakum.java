package simpus;

import usu.widget.*;
import usu.widget.glass.*;
import widget.*;
import widget.Button;
import widget.Label;
import widget.Panel;
import widget.ScrollPane;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import fungsi.*;
import java.sql.*;

public class DlgVakum extends JDialog
{
    sekuel Sequel;
    private ButtonGlass BtnAnggota;
    private ButtonGlass BtnBayar;
    private ButtonGlass BtnDenda;
    private ButtonGlass BtnInventaris;
    private ButtonGlass BtnJnsKoleksi;
    private ButtonGlass BtnKoleksi;
    private ButtonGlass BtnKtgKoleksi;
    private ButtonGlass BtnPenerbit;
    private ButtonGlass BtnPengarang;
    private ButtonGlass BtnPetugas;
    private ButtonGlass BtnRuang;
    private ButtonGlass BtnSetAplikasi;
    private ButtonGlass BtnSetPinjam;
    private ButtonGlass BtnSetUser;
    private ButtonGlass BtnSirkulasi;
    private Button button1;
    private InternalFrame internalFrame1;
    private JLabel jLabel1;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private Panel panel1;
    private PanelGlass panelGlass3;
    private PanelJudul panelJudul1;
    
    public DlgVakum(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.Sequel = new sekuel();
        this.initComponents();
        this.setLocation(10, 2);
        this.setSize(791, 281);
    }
    
    private void initComponents() {
        this.panel1 = new Panel();
        this.jSeparator1 = new JSeparator();
        this.jLabel5 = new JLabel();
        this.panelJudul1 = new PanelJudul();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.internalFrame1 = new InternalFrame();
        this.jPanel1 = new JPanel();
        this.BtnJnsKoleksi = new ButtonGlass();
        this.BtnKtgKoleksi = new ButtonGlass();
        this.BtnRuang = new ButtonGlass();
        this.BtnDenda = new ButtonGlass();
        this.BtnPengarang = new ButtonGlass();
        this.BtnPetugas = new ButtonGlass();
        this.BtnAnggota = new ButtonGlass();
        this.BtnPenerbit = new ButtonGlass();
        this.BtnKoleksi = new ButtonGlass();
        this.BtnInventaris = new ButtonGlass();
        this.BtnBayar = new ButtonGlass();
        this.BtnSirkulasi = new ButtonGlass();
        this.BtnSetPinjam = new ButtonGlass();
        this.BtnSetAplikasi = new ButtonGlass();
        this.BtnSetUser = new ButtonGlass();
        this.panelGlass3 = new PanelGlass();
        this.button1 = new Button();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.setDefaultCloseOperation(2);
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.panel1.setName("panel1");
        this.panel1.setPreferredSize(new Dimension(440, 25));
        this.panel1.setLayout(new BorderLayout());
        this.jSeparator1.setBackground(new Color(0, 0, 51));
        this.jSeparator1.setForeground(new Color(0, 0, 51));
        this.jSeparator1.setName("jSeparator1");
        this.jSeparator1.setPreferredSize(new Dimension(1, 1));
        this.panel1.add(this.jSeparator1, "First");
        this.jLabel5.setFont(new Font("Tahoma", 1, 11));
        this.jLabel5.setForeground(new Color(255, 204, 255));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText(":: Terima kasih telah menggunakan produk kami ::");
        this.jLabel5.setName("jLabel5");
        this.panel1.add(this.jLabel5, "Center");
        this.getContentPane().add(this.panel1, "Last");
        this.panelJudul1.setName("panelJudul1");
        this.panelJudul1.setPreferredSize(new Dimension(440, 40));
        this.panelJudul1.setLayout(null);
        this.jLabel1.setBackground(Color.darkGray);
        this.jLabel1.setFont(new Font("Book Antiqua", 3, 17));
        this.jLabel1.setForeground(new Color(255, 204, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText(":: KOSONGKAN TABLE ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(270, 10, 250, 20);
        this.jLabel2.setIcon(new ImageIcon(this.getClass().getResource("/picture/file-edit-32x32.png")));
        this.jLabel2.setName("jLabel2");
        this.panelJudul1.add(this.jLabel2);
        this.jLabel2.setBounds(5, 0, 40, 40);
        this.getContentPane().add(this.panelJudul1, "First");
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(110, 5, 110), 1, true), ".: Silahkan klik tombol untuk menghapus isi table  ", 0, 0, new Font("Book Antiqua", 2, 12), new Color(255, 255, 153)));
        this.jPanel1.setName("jPanel1");
        this.jPanel1.setOpaque(false);
        this.jPanel1.setLayout(new GridLayout(4, 4, 4, 3));
        this.BtnJnsKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnJnsKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/2.png")));
        this.BtnJnsKoleksi.setMnemonic('7');
        this.BtnJnsKoleksi.setText(" Jenis");
        this.BtnJnsKoleksi.setToolTipText("Alt+7");
        this.BtnJnsKoleksi.setCursor(new Cursor(12));
        this.BtnJnsKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnJnsKoleksi.setHorizontalAlignment(2);
        this.BtnJnsKoleksi.setHorizontalTextPosition(4);
        this.BtnJnsKoleksi.setName("BtnJnsKoleksi");
        this.BtnJnsKoleksi.setRoundRect(true);
        this.BtnJnsKoleksi.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnJnsKoleksiActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnJnsKoleksi);
        this.BtnKtgKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnKtgKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/add_to_folder.png")));
        this.BtnKtgKoleksi.setMnemonic('8');
        this.BtnKtgKoleksi.setText("Kategori");
        this.BtnKtgKoleksi.setToolTipText("Alt+8");
        this.BtnKtgKoleksi.setCursor(new Cursor(12));
        this.BtnKtgKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnKtgKoleksi.setHorizontalAlignment(2);
        this.BtnKtgKoleksi.setHorizontalTextPosition(4);
        this.BtnKtgKoleksi.setName("BtnKtgKoleksi");
        this.BtnKtgKoleksi.setRoundRect(true);
        this.BtnKtgKoleksi.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnKtgKoleksiActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnKtgKoleksi);
        this.BtnRuang.setForeground(new Color(205, 214, 255));
        this.BtnRuang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/17.png")));
        this.BtnRuang.setMnemonic('9');
        this.BtnRuang.setText(" Ruang");
        this.BtnRuang.setToolTipText("Alt+9");
        this.BtnRuang.setCursor(new Cursor(12));
        this.BtnRuang.setGlassColor(new Color(223, 223, 255));
        this.BtnRuang.setHorizontalAlignment(2);
        this.BtnRuang.setHorizontalTextPosition(4);
        this.BtnRuang.setName("BtnRuang");
        this.BtnRuang.setRoundRect(true);
        this.BtnRuang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnRuangActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnRuang);
        this.BtnDenda.setForeground(new Color(205, 214, 255));
        this.BtnDenda.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/budget24.png")));
        this.BtnDenda.setMnemonic('0');
        this.BtnDenda.setText("Denda");
        this.BtnDenda.setToolTipText("Alt+0");
        this.BtnDenda.setCursor(new Cursor(12));
        this.BtnDenda.setGlassColor(new Color(223, 223, 255));
        this.BtnDenda.setHorizontalAlignment(2);
        this.BtnDenda.setHorizontalTextPosition(4);
        this.BtnDenda.setName("BtnDenda");
        this.BtnDenda.setRoundRect(true);
        this.BtnDenda.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnDendaActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnDenda);
        this.BtnPengarang.setForeground(new Color(205, 214, 255));
        this.BtnPengarang.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/man1-24.png")));
        this.BtnPengarang.setMnemonic('A');
        this.BtnPengarang.setText("Produsen");
        this.BtnPengarang.setToolTipText("Alt+A");
        this.BtnPengarang.setCursor(new Cursor(12));
        this.BtnPengarang.setGlassColor(new Color(223, 223, 255));
        this.BtnPengarang.setHorizontalAlignment(2);
        this.BtnPengarang.setHorizontalTextPosition(4);
        this.BtnPengarang.setName("BtnPengarang");
        this.BtnPengarang.setRoundRect(true);
        this.BtnPengarang.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnPengarangActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnPengarang);
        this.BtnPetugas.setForeground(new Color(205, 214, 255));
        this.BtnPetugas.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Add patient.png")));
        this.BtnPetugas.setMnemonic('B');
        this.BtnPetugas.setText("Petugas");
        this.BtnPetugas.setToolTipText("Alt+B");
        this.BtnPetugas.setCursor(new Cursor(12));
        this.BtnPetugas.setGlassColor(new Color(223, 223, 255));
        this.BtnPetugas.setHorizontalAlignment(2);
        this.BtnPetugas.setHorizontalTextPosition(4);
        this.BtnPetugas.setName("BtnPetugas");
        this.BtnPetugas.setRoundRect(true);
        this.BtnPetugas.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnPetugasActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnPetugas);
        this.BtnAnggota.setForeground(new Color(205, 214, 255));
        this.BtnAnggota.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/family24.png")));
        this.BtnAnggota.setMnemonic('C');
        this.BtnAnggota.setText("Anggota");
        this.BtnAnggota.setToolTipText("Alt+C");
        this.BtnAnggota.setCursor(new Cursor(12));
        this.BtnAnggota.setGlassColor(new Color(223, 223, 255));
        this.BtnAnggota.setHorizontalAlignment(2);
        this.BtnAnggota.setHorizontalTextPosition(4);
        this.BtnAnggota.setName("BtnAnggota");
        this.BtnAnggota.setRoundRect(true);
        this.BtnAnggota.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnAnggotaActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnAnggota);
        this.BtnPenerbit.setForeground(new Color(205, 214, 255));
        this.BtnPenerbit.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/home24.png")));
        this.BtnPenerbit.setMnemonic('D');
        this.BtnPenerbit.setText("Produsen");
        this.BtnPenerbit.setToolTipText("Alt+D");
        this.BtnPenerbit.setCursor(new Cursor(12));
        this.BtnPenerbit.setGlassColor(new Color(223, 223, 255));
        this.BtnPenerbit.setHorizontalAlignment(2);
        this.BtnPenerbit.setHorizontalTextPosition(4);
        this.BtnPenerbit.setName("BtnPenerbit");
        this.BtnPenerbit.setRoundRect(true);
        this.BtnPenerbit.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnPenerbitActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnPenerbit);
        this.BtnKoleksi.setForeground(new Color(205, 214, 255));
        this.BtnKoleksi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/shopping-bag24.png")));
        this.BtnKoleksi.setMnemonic('E');
        this.BtnKoleksi.setText("Koleksi");
        this.BtnKoleksi.setToolTipText("Alt+E");
        this.BtnKoleksi.setCursor(new Cursor(12));
        this.BtnKoleksi.setGlassColor(new Color(223, 223, 255));
        this.BtnKoleksi.setHorizontalAlignment(2);
        this.BtnKoleksi.setHorizontalTextPosition(4);
        this.BtnKoleksi.setName("BtnKoleksi");
        this.BtnKoleksi.setRoundRect(true);
        this.BtnKoleksi.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnKoleksiActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnKoleksi);
        this.BtnInventaris.setForeground(new Color(205, 214, 255));
        this.BtnInventaris.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/search_page.png")));
        this.BtnInventaris.setMnemonic('F');
        this.BtnInventaris.setText("Inventaris");
        this.BtnInventaris.setToolTipText("Alt+F");
        this.BtnInventaris.setCursor(new Cursor(12));
        this.BtnInventaris.setGlassColor(new Color(223, 223, 255));
        this.BtnInventaris.setHorizontalAlignment(2);
        this.BtnInventaris.setHorizontalTextPosition(4);
        this.BtnInventaris.setName("BtnInventaris");
        this.BtnInventaris.setRoundRect(true);
        this.BtnInventaris.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnInventarisActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnInventaris);
        this.BtnBayar.setForeground(new Color(205, 214, 255));
        this.BtnBayar.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/Money-32x32.png")));
        this.BtnBayar.setMnemonic('G');
        this.BtnBayar.setText("Bayar Denda");
        this.BtnBayar.setToolTipText("Alt+G");
        this.BtnBayar.setCursor(new Cursor(12));
        this.BtnBayar.setGlassColor(new Color(223, 223, 255));
        this.BtnBayar.setHorizontalAlignment(2);
        this.BtnBayar.setHorizontalTextPosition(4);
        this.BtnBayar.setName("BtnBayar");
        this.BtnBayar.setRoundRect(true);
        this.BtnBayar.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnBayarActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnBayar);
        this.BtnSirkulasi.setForeground(new Color(205, 214, 255));
        this.BtnSirkulasi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/42a.png")));
        this.BtnSirkulasi.setMnemonic('H');
        this.BtnSirkulasi.setText("Sirkulasi");
        this.BtnSirkulasi.setToolTipText("Alt+H");
        this.BtnSirkulasi.setCursor(new Cursor(12));
        this.BtnSirkulasi.setGlassColor(new Color(223, 223, 255));
        this.BtnSirkulasi.setHorizontalAlignment(2);
        this.BtnSirkulasi.setHorizontalTextPosition(4);
        this.BtnSirkulasi.setIconTextGap(8);
        this.BtnSirkulasi.setName("BtnSirkulasi");
        this.BtnSirkulasi.setRoundRect(true);
        this.BtnSirkulasi.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnSirkulasiActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnSirkulasi);
        this.BtnSetPinjam.setForeground(new Color(205, 214, 255));
        this.BtnSetPinjam.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/63.png")));
        this.BtnSetPinjam.setMnemonic('I');
        this.BtnSetPinjam.setText("Setup Pinjam");
        this.BtnSetPinjam.setToolTipText("Alt+I");
        this.BtnSetPinjam.setCursor(new Cursor(12));
        this.BtnSetPinjam.setGlassColor(new Color(223, 223, 255));
        this.BtnSetPinjam.setHorizontalAlignment(2);
        this.BtnSetPinjam.setHorizontalTextPosition(4);
        this.BtnSetPinjam.setIconTextGap(8);
        this.BtnSetPinjam.setName("BtnSetPinjam");
        this.BtnSetPinjam.setRoundRect(true);
        this.BtnSetPinjam.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnSetPinjamActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnSetPinjam);
        this.BtnSetAplikasi.setForeground(new Color(205, 214, 255));
        this.BtnSetAplikasi.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/73.png")));
        this.BtnSetAplikasi.setMnemonic('K');
        this.BtnSetAplikasi.setText("Setup Aplikasi");
        this.BtnSetAplikasi.setToolTipText("Alt+K");
        this.BtnSetAplikasi.setCursor(new Cursor(12));
        this.BtnSetAplikasi.setGlassColor(new Color(223, 223, 255));
        this.BtnSetAplikasi.setHorizontalAlignment(2);
        this.BtnSetAplikasi.setHorizontalTextPosition(4);
        this.BtnSetAplikasi.setIconTextGap(8);
        this.BtnSetAplikasi.setName("BtnSetAplikasi");
        this.BtnSetAplikasi.setRoundRect(true);
        this.BtnSetAplikasi.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnSetAplikasiActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnSetAplikasi);
        this.BtnSetUser.setForeground(new Color(205, 214, 255));
        this.BtnSetUser.setIcon((Icon)new ImageIcon(this.getClass().getResource("/picture/users.png")));
        this.BtnSetUser.setMnemonic('L');
        this.BtnSetUser.setText("Setup User");
        this.BtnSetUser.setToolTipText("Alt+L");
        this.BtnSetUser.setCursor(new Cursor(12));
        this.BtnSetUser.setGlassColor(new Color(223, 223, 255));
        this.BtnSetUser.setHorizontalAlignment(2);
        this.BtnSetUser.setHorizontalTextPosition(4);
        this.BtnSetUser.setName("BtnSetUser");
        this.BtnSetUser.setRoundRect(true);
        this.BtnSetUser.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.BtnSetUserActionPerformed(evt);
            }
        });
        this.jPanel1.add((Component)this.BtnSetUser);
        this.internalFrame1.add(this.jPanel1, "Center");
        this.panelGlass3.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass3.setOpaqueImage(false);
        this.panelGlass3.setPreferredSize(new Dimension(30, 52));
        this.panelGlass3.setRound(false);
        this.panelGlass3.setWarna(new Color(90, 0, 90));
        this.panelGlass3.setLayout((LayoutManager)null);
        this.button1.setMnemonic('C');
        this.button1.setText("Close");
        this.button1.setToolTipText("Alt+C");
        this.button1.setCursor(new Cursor(12));
        this.button1.setFont(new Font("Comic Sans MS", 1, 12));
        this.button1.setName("button1");
        this.button1.addActionListener((ActionListener)new ActionListener() {
            public void actionPerformed(final ActionEvent evt) {
                DlgVakum.this.button1ActionPerformed(evt);
            }
        });
        this.panelGlass3.add((Component)this.button1);
        this.button1.setBounds(680, 10, 100, 30);
        this.jLabel11.setForeground(new Color(205, 214, 255));
        this.jLabel11.setText("Berhati-hatilah dalam menghapus isi table. Terdapat relasi antar table, ketika Anda menghapus suatu table maka di table yang berelasi");
        this.jLabel11.setName("jLabel11");
        this.panelGlass3.add((Component)this.jLabel11);
        this.jLabel11.setBounds(10, 10, 660, 15);
        this.jLabel12.setForeground(new Color(205, 214, 255));
        this.jLabel12.setText("juga ikut terhapus. Lakukan backup data terlebih dulu sebelum menghapus isi table");
        this.jLabel12.setName("jLabel12");
        this.panelGlass3.add((Component)this.jLabel12);
        this.jLabel12.setBounds(10, 25, 660, 15);
        this.internalFrame1.add((Component)this.panelGlass3, "Last");
        this.getContentPane().add(this.internalFrame1, "Center");
        this.pack();
    }
    
    private void button1ActionPerformed(final ActionEvent evt) {
        this.dispose();
    }
    
    private void BtnJnsKoleksiActionPerformed(final ActionEvent evt) {
        this.hapus("Jenis Koleksi", "jenis_buku");
    }
    
    private void BtnKtgKoleksiActionPerformed(final ActionEvent evt) {
        this.hapus("Kategori Koleksi", "kategori");
    }
    
    private void BtnRuangActionPerformed(final ActionEvent evt) {
        this.hapus("Ruang", "ruang");
    }
    
    private void BtnDendaActionPerformed(final ActionEvent evt) {
        this.hapus("Denda", "denda");
    }
    
    private void BtnPengarangActionPerformed(final ActionEvent evt) {
        this.hapus("Pengarang", "pengarang");
    }
    
    private void BtnPetugasActionPerformed(final ActionEvent evt) {
        this.hapus("Petugas", "petugas");
    }
    
    private void BtnAnggotaActionPerformed(final ActionEvent evt) {
        this.hapus("Anggota", "anggota");
    }
    
    private void BtnPenerbitActionPerformed(final ActionEvent evt) {
        this.hapus("Penerbit", "penerbit");
    }
    
    private void BtnKoleksiActionPerformed(final ActionEvent evt) {
        this.hapus("Koleksi", "buku");
    }
    
    private void BtnInventarisActionPerformed(final ActionEvent evt) {
        this.hapus("Inventaris", "inventaris");
    }
    
    private void BtnBayarActionPerformed(final ActionEvent evt) {
        this.hapus("Denda Harian", "bayar_denda_harian");
        this.hapus("Denda Lain", "bayar_denda");
    }
    
    private void BtnSirkulasiActionPerformed(final ActionEvent evt) {
        this.hapus("Peminjaman", "peminjaman");
    }
    
    private void BtnSetPinjamActionPerformed(final ActionEvent evt) {
        this.hapus("Set Peminjaman", "set_peminjaman");
    }
    
    private void BtnSetAplikasiActionPerformed(final ActionEvent evt) {
        this.hapus("Set Aplikasi", "setting");
    }
    
    private void BtnSetUserActionPerformed(final ActionEvent evt) {
        this.hapus("Setup User", "user");
    }
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgVakum dialog = new DlgVakum(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(final WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public void hapus(final String pesan, final String nm_table) {
        final int jawab = JOptionPane.showConfirmDialog(null, "Yakin anda mau menghapuas data " + pesan + " ????", "Konfirmasi", 0);
        if (jawab == 0) {
            try {
                final Connection connect = new koneksiDB().condb();
                final Statement statement = connect.createStatement();
                statement.executeUpdate("delete from " + nm_table);
                statement.close();
                connect.close();
            }
            catch (Exception e) {
                System.out.println("Pesan Error : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Gagal dihapus. Ada sebagian data " + pesan + " yang masih dipakai di table lain...!!!!");
            }
        }
    }
}
