package simpus;

import usu.widget.Button;
import usu.widget.Label;
import usu.widget.Panel;
import usu.widget.glass.*;
import widget.*;
import widget.ScrollPane;
import fungsi.*;

import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class DlgAdmin extends JDialog
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
    private TextBox TKd;
    private TextBox TNm;
    private InternalFrame internalFrame1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel5;
    private JSeparator jSeparator1;
    private Label label2;
    private Label label4;
    private Panel panel1;
    private PanelGlass panelGlass1;
    private PanelGlass panelGlass2;
    private PanelJudul panelJudul1;
    private ScrollPane scrollPane1;
    private Table tbSetPinjam;
    
    public DlgAdmin(final Frame parent, final boolean modal) {
        super(parent, modal);
        this.koneksi = new koneksiDB();
        this.Sequel = new sekuel();
        this.Valid = new validasi();
        this.initComponents();
        this.setLocation(10, 10);
        this.setSize(458, 233);
        final Object[] row = { "<html><font color='#006699' face='Comic Sans MS'>ID Admin</font></html>", "<html><font color='#006699' face='Comic Sans MS'>Password Admin</font></html>" };
        this.tabMode = new DefaultTableModel((Object[][])null, row) {
            public boolean isCellEditable(final int rowIndex, final int colIndex) {
                return false;
            }
        };
        this.tbSetPinjam.setModel(this.tabMode);
        this.koneksi.panggilDriver();
        this.tbSetPinjam.setPreferredScrollableViewportSize(new Dimension(500, 500));
        this.tbSetPinjam.setAutoResizeMode(0);
        for (int i = 0; i < 2; ++i) {
            final TableColumn column = this.tbSetPinjam.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(227);
            }
            else if (i == 1) {
                column.setPreferredWidth(227);
            }
        }
        this.tbSetPinjam.setDefaultRenderer(Object.class, new WarnaTable());
        this.TKd.setDocument((Document)new batasInput(30).getKata((JTextField)this.TKd));
        this.TNm.setDocument((Document)new batasInput(30).getKata((JTextField)this.TNm));
    }
    
    private void initComponents() {
        this.internalFrame1 = new InternalFrame();
        this.panelGlass1 = new PanelGlass();
        this.TKd = new TextBox();
        this.TNm = new TextBox();
        this.label2 = new Label();
        this.label4 = new Label();
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
        this.setDefaultCloseOperation(2);
        this.setModal(true);
        this.setResizable(false);
        this.setUndecorated(true);
        this.internalFrame1.setName("internalFrame1");
        this.internalFrame1.setLayout(new BorderLayout(1, 1));
        this.panelGlass1.setBorder(BorderFactory.createLineBorder(new Color(110, 5, 110)));
        this.panelGlass1.setOpaqueImage(false);
        this.panelGlass1.setPreferredSize(new Dimension(100, 49));
        this.panelGlass1.setRound(false);
        this.panelGlass1.setWarna(new Color(90, 0, 90));
        this.panelGlass1.setLayout((LayoutManager)null);
        this.TKd.setCursor(new Cursor(2));
        this.TKd.setName("TKd");
        this.TKd.setSelectedTextColor(new Color(255, 255, 255));
        this.TKd.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.TKdKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TKd);
        this.TKd.setBounds(66, 12, 150, 23);
        this.TNm.setCursor(new Cursor(2));
        this.TNm.setName("TNm");
        this.TNm.setSelectedTextColor(new Color(255, 255, 255));
        this.TNm.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.TNmKeyPressed(evt);
            }
        });
        this.panelGlass1.add((Component)this.TNm);
        this.TNm.setBounds(293, 12, 150, 23);
        this.label2.setText("Password :");
        this.label2.setName("label2");
        this.panelGlass1.add((Component)this.label2);
        this.label2.setBounds(237, 12, 60, 23);
        this.label4.setText("ID Admin :");
        this.label4.setName("label4");
        this.panelGlass1.add((Component)this.label4);
        this.label4.setBounds(13, 12, 70, 23);
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
                DlgAdmin.this.BtnSimpanActionPerformed(evt);
            }
        });
        this.BtnSimpan.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.BtnSimpanKeyPressed(evt);
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
                DlgAdmin.this.BtnBatalActionPerformed(evt);
            }
        });
        this.BtnBatal.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.BtnBatalKeyPressed(evt);
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
                DlgAdmin.this.BtnHapusActionPerformed(evt);
            }
        });
        this.BtnHapus.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.BtnHapusKeyPressed(evt);
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
                DlgAdmin.this.BtnEditActionPerformed(evt);
            }
        });
        this.BtnEdit.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.BtnEditKeyPressed(evt);
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
                DlgAdmin.this.BtnKeluarActionPerformed(evt);
            }
        });
        this.BtnKeluar.addKeyListener((KeyListener)new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.BtnKeluarKeyPressed(evt);
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
                DlgAdmin.this.tbSetPinjamMouseClicked(evt);
            }
        });
        this.tbSetPinjam.addKeyListener(new KeyAdapter() {
            public void keyPressed(final KeyEvent evt) {
                DlgAdmin.this.tbSetPinjamKeyPressed(evt);
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
        this.jLabel1.setText(":: SETUP ADMIN ::");
        this.jLabel1.setIconTextGap(2);
        this.jLabel1.setName("jLabel1");
        this.panelJudul1.add(this.jLabel1);
        this.jLabel1.setBounds(105, 10, 250, 21);
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
    
    private void TKdKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JButton)this.BtnKeluar, (JTextField)this.TNm);
    }
    
    private void TNmKeyPressed(final KeyEvent evt) {
        this.Valid.pindah(evt, (JTextField)this.TKd, (JButton)this.BtnSimpan);
    }
    
    private void BtnSimpanActionPerformed(final ActionEvent evt) {
        if (this.TKd.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKd, "ID Admin");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Password");
        }
        else if (this.tabMode.getRowCount() == 0) {
            this.Sequel.menyimpan("admin", "AES_ENCRYPT('" + this.TKd.getText() + "','nur'),AES_ENCRYPT('" + this.TNm.getText() + "','windi')", "Kode Admin");
            this.tampil();
            this.emptTeks();
        }
        else if (this.tabMode.getRowCount() > 0) {
            JOptionPane.showMessageDialog(null, "Maaf, Hanya diijinkan satu Admin Utama ...!!!!");
            this.TKd.requestFocus();
        }
    }
    
    private void BtnSimpanKeyPressed(final KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.BtnSimpanActionPerformed(null);
        }
        else {
            this.Valid.pindah(evt, (JTextField)this.TNm, (JButton)this.BtnBatal);
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
            this.TKd.requestFocus();
        }
        else if (this.TNm.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        }
        else if (!this.TNm.getText().trim().equals("")) {
            this.Sequel.queryu("delete from admin where id_admin=AES_ENCRYPT('" + this.TKd.getText() + "','nur')");
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
        if (this.TKd.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TKd, "ID Admin");
        }
        else if (this.TNm.getText().trim().equals("")) {
            this.Valid.textKosong((JTextField)this.TNm, "Password");
        }
        else {
            this.Sequel.queryu("update admin set password=AES_ENCRYPT('" + this.TNm.getText() + "','windi') " + "where id_admin=AES_ENCRYPT('" + this.TKd.getText() + "','nur')");
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
            JOptionPane.showMessageDialog(null, "Maaf, data admin tidak boleh kosong ...!!!!");
            this.TKd.requestFocus();
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
            this.Valid.pindah(evt, (JButton)this.BtnEdit, (JTextField)this.TKd);
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
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final DlgAdmin dialog = new DlgAdmin(new JFrame(), true);
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
        final String sql = "select AES_DECRYPT(id_admin,'nur'),AES_DECRYPT(password,'windi') from admin";
        this.prosesCari(sql);
    }
    
    private void prosesCari(final String sql) {
        this.Valid.tabelKosong(this.tabMode);
        try {
            final Connection connect = new koneksiDB().condb();
            final Statement stat = connect.createStatement();
            final ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                final String[] data = { rs.getString(1), rs.getString(2) };
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
        this.TKd.setText("");
        this.TNm.setText("");
        this.TKd.requestFocus();
    }
    
    private void getData() {
        final int row = this.tbSetPinjam.getSelectedRow();
        if (row != -1) {
            this.TKd.setText(this.tabMode.getValueAt(row, 0).toString());
            this.TNm.setText(this.tabMode.getValueAt(row, 1).toString());
        }
    }
}
