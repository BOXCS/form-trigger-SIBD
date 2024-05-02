package Trigger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TriggerForm extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet r;
    private String sql = "";

    private String kb, nb, tm, tk, jm, k;

    public TriggerForm() {
        initComponents();
        KoneksiDB();

        setTitle("Penyimpanan Barang");
    }

    private void KoneksiDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/penyimpanan", "root", "");
            st = con.createStatement(); // Initialize the Statement object
        } catch (Exception e) {
            System.out.println("Koneksi gagal \n" + e);
        }
    }

    private void refreshTableMasuk() {
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("No");
        data.addColumn("Kode Barang");
        data.addColumn("Nama Barang");
        data.addColumn("Tanggal Masuk");
        data.addColumn("Jumlah");
        data.addColumn("Kondisi");

        try {
            int i = 1;
            sql = "SELECT * FROM barang_masuk"; // Query to fetch data from the database
            r = st.executeQuery(sql);
            while (r.next()) {
                data.addRow(new Object[]{
                    ("" + i++),
                    r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)
                });
            }
            tableMasuk.setModel(data); // Set the new table model
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat Ke Database \n Aktifkan Database");
            e.printStackTrace();
        }
    }

    private void refreshTablekeluar() {
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("No");
        data.addColumn("Kode Barang");
        data.addColumn("Nama Barang");
        data.addColumn("Tanggal Masuk");
        data.addColumn("Tanggal keluar");
        data.addColumn("Jumlah");
        data.addColumn("Kondisi");

        try {
            int i = 1;
            sql = "SELECT * FROM barang_keluar"; // Query to fetch data from the database
            r = st.executeQuery(sql);
            while (r.next()) {
                data.addRow(new Object[]{
                    ("" + i++),
                    r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6)
                });
            }
            tableKeluar.setModel(data); // Set the new table model
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat Ke Database \n Aktifkan Database");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMasuk = new javax.swing.JTable();
        cmdMasuk = new javax.swing.JButton();
        cmdRefreshMasuk = new javax.swing.JButton();
        cmdHapusMasuk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtkb = new javax.swing.JTextField();
        txtnb = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableKeluar = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cmdKeluar = new javax.swing.JButton();
        RefreshDataKeluar = new javax.swing.JButton();
        cmdHapusKeluar = new javax.swing.JButton();
        datetm = new com.toedter.calendar.JDateChooser();
        datetk = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtjm = new javax.swing.JTextField();
        cbk = new javax.swing.JComboBox<>();
        cmdEditMasuk = new javax.swing.JButton();
        cmdClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Barang");

        jLabel2.setText("Nama Barang");

        jLabel3.setText("Barang Masuk");

        tableMasuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Tanggal Masuk", "Jumlah", "Kondisi"
            }
        ));
        tableMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMasukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMasuk);

        cmdMasuk.setText("Barang Masuk");
        cmdMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMasukActionPerformed(evt);
            }
        });

        cmdRefreshMasuk.setText("Refresh data masuk");
        cmdRefreshMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshMasukActionPerformed(evt);
            }
        });

        cmdHapusMasuk.setText("Hapus");
        cmdHapusMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusMasukActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal Masuk");

        jLabel5.setText("Tanggal Keluar");

        tableKeluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Tanggal Masuk", "Tanggal Keluar", "Jumlah", "Kondisi"
            }
        ));
        jScrollPane2.setViewportView(tableKeluar);

        jLabel6.setText("Barang Keluar");

        cmdKeluar.setText("Barang Keluar");
        cmdKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKeluarActionPerformed(evt);
            }
        });

        RefreshDataKeluar.setText("Refresh data keluar");
        RefreshDataKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshDataKeluarActionPerformed(evt);
            }
        });

        cmdHapusKeluar.setText("Hapus");
        cmdHapusKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdHapusKeluarActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah");

        jLabel8.setText("Kondisi");

        cbk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Rusak", "Hilang" }));

        cmdEditMasuk.setText("Edit Data Masuk");
        cmdEditMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditMasukActionPerformed(evt);
            }
        });

        cmdClear.setText("Clear");
        cmdClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtkb)
                            .addComponent(txtnb, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(datetm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdEditMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datetk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtjm)
                            .addComponent(cbk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdClear, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cmdKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(RefreshDataKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(cmdHapusKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cmdMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cmdRefreshMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(cmdHapusMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmdMasuk)
                    .addComponent(cmdRefreshMasuk)
                    .addComponent(cmdHapusMasuk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtnb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4))
                            .addComponent(datetm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(datetk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmdKeluar)
                    .addComponent(RefreshDataKeluar)
                    .addComponent(cmdHapusKeluar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtjm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmdEditMasuk)
                        .addGap(18, 18, 18)
                        .addComponent(cmdClear)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMasukActionPerformed
        kb = String.valueOf(txtkb.getText());
        nb = String.valueOf(txtnb.getText());
        java.sql.Date tm = new java.sql.Date(datetm.getDate().getTime()); // Convert java.util.Date to java.sql.Date
        jm = String.valueOf(txtjm.getText());
        k = (String) cbk.getSelectedItem();

        try {
            KoneksiDB();
            String sql = "INSERT INTO barang_masuk (kd_barang, nama_barang, tgl_masuk, jumlah, kondisi) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, kb);
            p.setString(2, nb);
            p.setDate(3, tm); // Set the date using setDate() method
            p.setString(4, jm);
            p.setString(5, k);
            p.executeUpdate();

            Clear();
            ShowData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdMasukActionPerformed

    private void cmdRefreshMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshMasukActionPerformed
        refreshTableMasuk();
    }//GEN-LAST:event_cmdRefreshMasukActionPerformed

    private void tableMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMasukMouseClicked
        int i = tableMasuk.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableMasuk.getModel();
        txtkb.setText(model.getValueAt(i, 1).toString());
        txtnb.setText(model.getValueAt(i, 2).toString());

        // Konversi nilai dari String ke java.util.Date
        try {
            String stringTanggal = model.getValueAt(i, 3).toString();
            java.util.Date tanggalMasuk = new SimpleDateFormat("yyyy-MM-dd").parse(stringTanggal);
            datetm.setDate(tanggalMasuk);
        } catch (ParseException ex) {
            ex.printStackTrace();
            // Handle exception
        }

        cbk.setSelectedItem(model.getValueAt(i, 5));
    }//GEN-LAST:event_tableMasukMouseClicked

    private void cmdKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKeluarActionPerformed
        kb = String.valueOf(txtkb.getText());
        nb = String.valueOf(txtnb.getText());
        java.sql.Date tm = new java.sql.Date(datetm.getDate().getTime()); // Convert java.util.Date to java.sql.Date
        java.sql.Date tk = new java.sql.Date(datetk.getDate().getTime()); // Convert java.util.Date to java.sql.Date
        jm = String.valueOf(txtjm.getText());
        k = (String) cbk.getSelectedItem();

        try {
            KoneksiDB();
            String sql = "INSERT INTO barang_keluar (kd_barang, nama_barang, tgl_masuk, tgl_keluar, jumlah, kondisi) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, kb);
            p.setString(2, nb);
            p.setDate(3, tm); // Set the date using setDate() method
            p.setDate(4, tk); // Set the date using setDate() method
            p.setString(5, jm);
            p.setString(6, k);
            p.executeUpdate();

            Clear();
            ShowDataKeluar();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdKeluarActionPerformed

    private void RefreshDataKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshDataKeluarActionPerformed
        refreshTablekeluar();
    }//GEN-LAST:event_RefreshDataKeluarActionPerformed

    private void cmdHapusMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusMasukActionPerformed
        // Mendapatkan baris yang dipilih
        int row = tableMasuk.getSelectedRow();

        // Memastikan bahwa ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
            return;
        }

        // Mendapatkan kode barang dari baris yang dipilih
        String kd_barang = tableMasuk.getValueAt(row, 1).toString();

        try {
            // Koneksi ke database
            KoneksiDB();

            // Query untuk menghapus data dari tabel barang_masuk
            String sql = "DELETE FROM barang_masuk WHERE kd_barang = ?";

            // Persiapan statement
            PreparedStatement p = con.prepareStatement(sql);

            // Mengatur parameter
            p.setString(1, kd_barang);

            // Eksekusi statement
            p.executeUpdate();

            // Refresh tabel setelah penghapusan
            refreshTableMasuk();

            // Memberi pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");

        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdHapusMasukActionPerformed

    private void cmdHapusKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdHapusKeluarActionPerformed
        // Mendapatkan baris yang dipilih
        int row = tableKeluar.getSelectedRow();

        // Memastikan bahwa ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
            return;
        }

        // Mendapatkan kode barang dari baris yang dipilih
        String kd_barang = tableKeluar.getValueAt(row, 1).toString();

        // Menampilkan dialog konfirmasi
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih "Ya"
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Koneksi ke database
                KoneksiDB();

                // Query untuk menghapus data dari tabel barang_keluar
                String sql = "DELETE FROM barang_keluar WHERE kd_barang = ?";

                // Persiapan statement
                PreparedStatement p = con.prepareStatement(sql);

                // Mengatur parameter
                p.setString(1, kd_barang);

                // Eksekusi statement
                p.executeUpdate();

                // Refresh tabel setelah penghapusan
                refreshTablekeluar();

                // Memberi pesan sukses
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");

            } catch (Exception e) {
                // Menampilkan pesan error jika terjadi kesalahan
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_cmdHapusKeluarActionPerformed

    private void cmdEditMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditMasukActionPerformed
        // Mendapatkan baris yang dipilih
        int row = tableMasuk.getSelectedRow();

        // Memastikan bahwa ada baris yang dipilih
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit.");
            return;
        }

        // Mendapatkan kode barang dari baris yang dipilih
        String kd_barang = tableMasuk.getValueAt(row, 1).toString();

        // Mendapatkan data yang akan diubah dari input pengguna
        String nb = txtnb.getText();
        String jm = txtjm.getText();
        String k = cbk.getSelectedItem().toString();

        // Validasi input
        if (nb.isEmpty() || jm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua kolom yang diperlukan.");
            return;
        }

        try {
            // Koneksi ke database
            KoneksiDB();

            // Query untuk mengupdate data dalam tabel barang_masuk
            String sql = "UPDATE barang_masuk SET nama_barang = ?, jumlah = ?, kondisi = ? WHERE kd_barang = ?";

            // Persiapan statement
            PreparedStatement p = con.prepareStatement(sql);

            // Mengatur parameter
            p.setString(1, nb);
            p.setString(2, jm);
            p.setString(3, k);
            p.setString(4, kd_barang);

            // Eksekusi statement
            p.executeUpdate();

            // Refresh tabel setelah pengeditan
            refreshTableMasuk();

            // Memberi pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil diubah.");

        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi kesalahan
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cmdEditMasukActionPerformed

    private void cmdClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearActionPerformed
        // Menghapus nilai dari textfield
        txtkb.setText("");
        txtnb.setText("");
        txtjm.setText("");

        // Mengatur datechooser menjadi null
        datetm.setDate(null);
        datetk.setDate(null);

        // Mengatur combobox ke item pertama
        cbk.setSelectedIndex(0);
    }//GEN-LAST:event_cmdClearActionPerformed

    private void Clear() {
        txtkb.setText("");
        txtnb.setText("");
        txtjm.setText("");

        datetm.setDate(null);
        datetk.setDate(null);

        // Mengatur combobox ke item pertama
        cbk.setSelectedIndex(0);
    }

    private void ShowData() {
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("Kode Barang");
        data.addColumn("Nama Barang");
        data.addColumn("Tanggal Masuk");
        data.addColumn("Jumlah");
        data.addColumn("Kondisi");

        try {
            KoneksiDB();
            String sql = "SELECT * FROM barang_masuk";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet r = p.executeQuery();

            int i = 0; // Variabel untuk nomor urutan

            while (r.next()) {
                String kodeBarang = r.getString("kd_barang");
                String namaBarang = r.getString("nama_barang");
                Date tanggalMasuk = r.getDate("tgl_masuk");
                String jumlah = r.getString("jumlah");
                String kondisi = r.getString("kondisi");

                // Tambahkan baris ke model tabel
                data.addRow(new Object[]{kodeBarang, namaBarang, tanggalMasuk, jumlah, kondisi});
            }

            // Set the table model to the tableMasuk
            tableMasuk.setModel(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void ShowDataKeluar() {
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn("Kode Barang");
        data.addColumn("Nama Barang");
        data.addColumn("Tanggal Masuk");
        data.addColumn("Tanggal Keluar");
        data.addColumn("Jumlah");
        data.addColumn("Kondisi");

        try {
            KoneksiDB();
            String sql = "SELECT * FROM barang_keluar";
            PreparedStatement p = con.prepareStatement(sql);
            ResultSet r = p.executeQuery();

            int i = 0; // Variabel untuk nomor urutan

            while (r.next()) {
                String kodeBarang = r.getString("kd_barang");
                String namaBarang = r.getString("nama_barang");
                Date tanggalMasuk = r.getDate("tgl_masuk");
                Date tanggalKeluar = r.getDate("tgl_keluar");
                String jumlah = r.getString("jumlah");
                String kondisi = r.getString("kondisi");

                // Tambahkan baris ke model tabel
                data.addRow(new Object[]{kodeBarang, namaBarang, tanggalMasuk, tanggalKeluar, jumlah, kondisi});
            }

            // Set the table model to the tableMasuk
            tableKeluar.setModel(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TriggerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriggerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriggerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriggerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TriggerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RefreshDataKeluar;
    private javax.swing.JComboBox<String> cbk;
    private javax.swing.JButton cmdClear;
    private javax.swing.JButton cmdEditMasuk;
    private javax.swing.JButton cmdHapusKeluar;
    private javax.swing.JButton cmdHapusMasuk;
    private javax.swing.JButton cmdKeluar;
    private javax.swing.JButton cmdMasuk;
    private javax.swing.JButton cmdRefreshMasuk;
    private com.toedter.calendar.JDateChooser datetk;
    private com.toedter.calendar.JDateChooser datetm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableKeluar;
    private javax.swing.JTable tableMasuk;
    private javax.swing.JTextField txtjm;
    private javax.swing.JTextField txtkb;
    private javax.swing.JTextField txtnb;
    // End of variables declaration//GEN-END:variables
}
