/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Master;

import Settings.MainSystemSetting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MS
 */
public class Transaction_Paket extends javax.swing.JFrame {

    /**
     * Creates new form Transaction_Paket
     */
    
    public MainSystemSetting mnSetting = new MainSystemSetting();
    public String kode_kota_emp;
    public String kode_agen_emp;
    public String kode_emp;
    private String jkel;
    private double total_harganya = 0;
    private String kode_estimasi;
    
    public Transaction_Paket() {
        initComponents();
    }
    
    public String getHarga(String kodeasal)
    {
        String harga = "0";
        try {
            
                getConnection();

                ArrayList<DataCost> arraylist_data = new ArrayList<>();

                String[] tujuans = cb_kotatujuan.getSelectedItem().toString().split(" - ");
                String kota_tujuan_paket = tujuans[0];
                System.out.println(kodeasal+" i-i "+kota_tujuan_paket);
                String query = "SELECT *from cost_estimate WHERE from_city_kode = '"+kodeasal+"' AND to_city_kode = '"+kota_tujuan_paket+"'";
                ResultSet rs_data = mnSetting.stm.executeQuery(query);
                DataCost dt;
                while (rs_data.next()) {
                    dt = new DataCost(rs_data.getString("kode"), rs_data.getString("from_city_kode"),rs_data.getString("to_city_kode"),rs_data.getString("cost_perkg"));
                    arraylist_data.add(dt);
                    harga = dt.getCost_kg();
                    kode_estimasi = dt.getKode();
                    System.out.println("harganya "+harga);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error get data harga\n"+ex);
            }
        
        return harga;
    }
    
    public void getKotaTujuan()
    {
        ArrayList<DataKota> arraylist_data = new ArrayList<>();
        cb_kotatujuan.removeAllItems();
        
         try {
            String select_data = "select *from kota";
            ResultSet rs_data = mnSetting.stm.executeQuery(select_data);
            DataKota dt;
            
            while (rs_data.next()) {
                dt = new DataKota(rs_data.getString("kode"), rs_data.getString("nama_kota"));
                arraylist_data.add(dt);
                cb_kotatujuan.addItem(dt.getKode()+" - "+dt.getNama());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void getKotaAsalAgen(String kodeagen)
    {
        ArrayList<DataAgenDropOff> arraylist_data = new ArrayList<>();
        cb_kotatujuan.removeAllItems();
        
         try {
            String select_data = "select *from agent where kode='"+kode_agen_emp+"'";
            ResultSet rs = mnSetting.stm.executeQuery(select_data);
            DataAgenDropOff dt;
            
            while (rs.next()) {
                dt = new DataAgenDropOff(rs.getString("kode"), rs.getString("agent_name"), rs.getString("alamat"), rs.getString("kota_kode"));
                arraylist_data.add(dt);
                kode_kota_emp = dt.getKota_id();
                System.out.println("Kota emp :"+kode_kota_emp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void getDataTransaction()
    {
        ArrayList<DataTransaction> arraylist_data = new ArrayList<>();
            
        try {
            String select_data = "select *from paket_transaction";
            ResultSet rs = mnSetting.stm.executeQuery(select_data);
            DataTransaction dt;
            while (rs.next()) {
                dt = new DataTransaction(rs.getString("id"), rs.getString("transaction_no"), rs.getString("cost_estimate_kode"), rs.getString("cost"), rs.getString("sender_customer_kode"),rs.getString("receiver_customer_kode"),rs.getString("alamat"),rs.getString("nama_paket"),rs.getString("berat"),rs.getString("create_date"),rs.getString("create_by"));
                arraylist_data.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultTableModel model_data = (DefaultTableModel)tabletransaction.getModel();
        model_data.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i<arraylist_data.size(); i++) {
            row[0] = arraylist_data.get(i).getTransaction_no();
            row[1] = arraylist_data.get(i).getCost_estimate_kode();
            row[2] = arraylist_data.get(i).getSender_customer_kode();
            row[3] = arraylist_data.get(i).getAlamat();
            row[4] = arraylist_data.get(i).getNama_paket();
            row[5] = arraylist_data.get(i).getCreate_date();
            model_data.addRow(row);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btn_customer = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btn_transaksi2 = new javax.swing.JButton();
        panel_track = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        et_cari_track = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabletrack = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        et_track_notrans = new javax.swing.JTextField();
        cb_track_status = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        et_track_notes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btTrackSubmit1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel_transaksi = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb_kotatujuan = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_pengirim = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cb_namapenerima = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        et_alamat_trans = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        btn_nextorder_lines1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        et_namapaket = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        et_berat = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        et_caritrans = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabletransaction = new javax.swing.JTable();
        tv_total_harga = new javax.swing.JLabel();
        tv_harga = new javax.swing.JLabel();
        panel_pelanggan = new javax.swing.JPanel();
        et_kodepelanggan = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rbLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        et_notelp = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        et_alamat = new javax.swing.JTextArea();
        et_caripelanggan = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePelanggan = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        et_namapelanggan = new javax.swing.JTextField();
        btSimpanPelanggan = new javax.swing.JButton();
        btUbahPelanggan = new javax.swing.JButton();
        btHapusPelanggan = new javax.swing.JButton();
        btnClearpelanggan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(914, 685));
        setPreferredSize(new java.awt.Dimension(914, 685));
        setResizable(false);
        setSize(new java.awt.Dimension(914, 685));
        getContentPane().setLayout(null);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setText("Transaksi");

        btn_customer.setText("Customer");
        btn_customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_customerMouseClicked(evt);
            }
        });
        btn_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customerActionPerformed(evt);
            }
        });

        btn_transaksi.setText("Transaksi");
        btn_transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transaksiMouseClicked(evt);
            }
        });
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Master");

        btn_transaksi2.setText("Track");
        btn_transaksi2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transaksi2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_transaksi2MouseClicked(evt);
            }
        });
        btn_transaksi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksi2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_menuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_menuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_menuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_menuLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel20))
                            .addComponent(btn_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_transaksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(panel_menu);
        panel_menu.setBounds(10, 10, 120, 640);

        panel_track.setBackground(new java.awt.Color(255, 255, 255));
        panel_track.setLayout(null);

        jLabel37.setText("Cari No Transaksi");
        panel_track.add(jLabel37);
        jLabel37.setBounds(310, 40, 160, 14);

        et_cari_track.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_cari_trackKeyTyped(evt);
            }
        });
        panel_track.add(et_cari_track);
        et_cari_track.setBounds(310, 60, 430, 20);

        tabletrack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Transaksi", "Status", "Desc", "Employee", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabletrack.getTableHeader().setReorderingAllowed(false);
        tabletrack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletrackMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabletrack);

        panel_track.add(jScrollPane8);
        jScrollPane8.setBounds(310, 90, 430, 470);

        jLabel1.setText("Notes (Optional)");
        panel_track.add(jLabel1);
        jLabel1.setBounds(10, 130, 260, 14);

        et_track_notrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_track_notransActionPerformed(evt);
            }
        });
        panel_track.add(et_track_notrans);
        et_track_notrans.setBounds(10, 60, 180, 20);

        cb_track_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perjalanan", "Diterima Agen", "Diambil Customer", "Pengiriman Selesai", "Terkendala" }));
        panel_track.add(cb_track_status);
        cb_track_status.setBounds(10, 90, 290, 20);

        et_track_notes.setColumns(20);
        et_track_notes.setRows(5);
        jScrollPane1.setViewportView(et_track_notes);

        panel_track.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 290, 96);

        jLabel2.setText("No Transaksi");
        panel_track.add(jLabel2);
        jLabel2.setBounds(10, 40, 260, 14);

        btTrackSubmit1.setText("Submit");
        btTrackSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTrackSubmit1ActionPerformed(evt);
            }
        });
        panel_track.add(btTrackSubmit1);
        btTrackSubmit1.setBounds(10, 260, 290, 23);

        jButton2.setText("Stiker");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_track.add(jButton2);
        jButton2.setBounds(200, 60, 100, 23);

        getContentPane().add(panel_track);
        panel_track.setBounds(140, 10, 750, 640);

        panel_transaksi.setBackground(new java.awt.Color(255, 255, 255));
        panel_transaksi.setLayout(null);

        jLabel8.setText("Buat order baru ..");
        panel_transaksi.add(jLabel8);
        jLabel8.setBounds(10, 20, 200, 14);

        jLabel11.setText("Pilih kota tujuan");
        panel_transaksi.add(jLabel11);
        jLabel11.setBounds(10, 70, 220, 14);

        cb_kotatujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_kotatujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kotatujuanActionPerformed(evt);
            }
        });
        panel_transaksi.add(cb_kotatujuan);
        cb_kotatujuan.setBounds(10, 90, 260, 20);

        jLabel12.setText("Nama Pengirim");
        panel_transaksi.add(jLabel12);
        jLabel12.setBounds(10, 160, 180, 14);

        cb_pengirim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_transaksi.add(cb_pengirim);
        cb_pengirim.setBounds(10, 180, 260, 20);

        jLabel14.setText("Nama Penerima");
        panel_transaksi.add(jLabel14);
        jLabel14.setBounds(10, 210, 220, 14);

        cb_namapenerima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panel_transaksi.add(cb_namapenerima);
        cb_namapenerima.setBounds(10, 230, 260, 20);

        et_alamat_trans.setColumns(20);
        et_alamat_trans.setRows(5);
        jScrollPane2.setViewportView(et_alamat_trans);

        panel_transaksi.add(jScrollPane2);
        jScrollPane2.setBounds(10, 280, 260, 90);

        jLabel16.setText("Alamat");
        panel_transaksi.add(jLabel16);
        jLabel16.setBounds(10, 260, 190, 14);

        btn_nextorder_lines1.setText("Submit");
        btn_nextorder_lines1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextorder_lines1ActionPerformed(evt);
            }
        });
        panel_transaksi.add(btn_nextorder_lines1);
        btn_nextorder_lines1.setBounds(10, 520, 260, 23);

        jLabel17.setText("Nama Paket");
        panel_transaksi.add(jLabel17);
        jLabel17.setBounds(10, 380, 193, 14);

        et_namapaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_namapaketActionPerformed(evt);
            }
        });
        panel_transaksi.add(et_namapaket);
        et_namapaket.setBounds(10, 400, 260, 20);

        jLabel19.setText("Berat (Kg)");
        panel_transaksi.add(jLabel19);
        jLabel19.setBounds(10, 430, 210, 14);

        et_berat.setText("0");
        et_berat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                et_beratKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_beratKeyTyped(evt);
            }
        });
        panel_transaksi.add(et_berat);
        et_berat.setBounds(10, 450, 260, 20);

        jLabel24.setText("Cari No Transaksi");
        panel_transaksi.add(jLabel24);
        jLabel24.setBounds(290, 70, 130, 14);

        et_caritrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_caritransActionPerformed(evt);
            }
        });
        et_caritrans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_caritransKeyTyped(evt);
            }
        });
        panel_transaksi.add(et_caritrans);
        et_caritrans.setBounds(290, 90, 450, 20);

        tabletransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Transaksi", "Rute", "Nama Penerima", "Alamat", "Nama Paket", "Tanggal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabletransaction.getTableHeader().setReorderingAllowed(false);
        tabletransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabletransactionMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabletransaction);

        panel_transaksi.add(jScrollPane7);
        jScrollPane7.setBounds(290, 120, 452, 420);

        tv_total_harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tv_total_harga.setText("Total : Rp 0");
        panel_transaksi.add(tv_total_harga);
        tv_total_harga.setBounds(10, 480, 260, 17);

        tv_harga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tv_harga.setText("Harga per KG : Rp 0");
        panel_transaksi.add(tv_harga);
        tv_harga.setBounds(10, 120, 260, 17);

        getContentPane().add(panel_transaksi);
        panel_transaksi.setBounds(140, 10, 750, 640);

        panel_pelanggan.setBackground(new java.awt.Color(255, 255, 255));
        panel_pelanggan.setLayout(null);

        et_kodepelanggan.setToolTipText("Nama");
        et_kodepelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_kodepelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(et_kodepelanggan);
        et_kodepelanggan.setBounds(10, 60, 300, 20);

        jLabel21.setText("Kode Customer");
        panel_pelanggan.add(jLabel21);
        jLabel21.setBounds(10, 40, 120, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Customer");
        panel_pelanggan.add(jLabel22);
        jLabel22.setBounds(0, 0, 750, 30);

        jLabel23.setText("Jenis Kelamin");
        panel_pelanggan.add(jLabel23);
        jLabel23.setBounds(10, 150, 90, 14);

        rbLaki.setBackground(new java.awt.Color(255, 255, 255));
        rbLaki.setText("Laki - laki");
        rbLaki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbLaki.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbLakiStateChanged(evt);
            }
        });
        rbLaki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbLakiMouseClicked(evt);
            }
        });
        rbLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiActionPerformed(evt);
            }
        });
        panel_pelanggan.add(rbLaki);
        rbLaki.setBounds(10, 170, 100, 23);

        rbPerempuan.setBackground(new java.awt.Color(255, 255, 255));
        rbPerempuan.setText("Perempuan");
        rbPerempuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbPerempuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPerempuanMouseClicked(evt);
            }
        });
        rbPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanActionPerformed(evt);
            }
        });
        panel_pelanggan.add(rbPerempuan);
        rbPerempuan.setBounds(110, 170, 110, 23);

        jLabel25.setText("No Handphone");
        panel_pelanggan.add(jLabel25);
        jLabel25.setBounds(10, 200, 100, 14);
        panel_pelanggan.add(et_notelp);
        et_notelp.setBounds(10, 220, 300, 20);

        jLabel26.setText("Alamat");
        panel_pelanggan.add(jLabel26);
        jLabel26.setBounds(10, 250, 90, 14);

        et_alamat.setColumns(20);
        et_alamat.setRows(5);
        jScrollPane3.setViewportView(et_alamat);

        panel_pelanggan.add(jScrollPane3);
        jScrollPane3.setBounds(10, 270, 300, 96);

        et_caripelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                et_caripelangganKeyTyped(evt);
            }
        });
        panel_pelanggan.add(et_caripelanggan);
        et_caripelanggan.setBounds(320, 60, 420, 20);

        jLabel27.setText("Cari Nama Customer");
        panel_pelanggan.add(jLabel27);
        jLabel27.setBounds(320, 40, 190, 14);

        tablePelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Jenis Kelamin", "No Handphone", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePelanggan.getTableHeader().setReorderingAllowed(false);
        tablePelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePelangganMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePelanggan);

        panel_pelanggan.add(jScrollPane4);
        jScrollPane4.setBounds(320, 90, 420, 330);

        jLabel28.setText("Nama Customer");
        panel_pelanggan.add(jLabel28);
        jLabel28.setBounds(10, 90, 120, 20);

        et_namapelanggan.setToolTipText("Nama");
        et_namapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                et_namapelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(et_namapelanggan);
        et_namapelanggan.setBounds(10, 120, 300, 20);

        btSimpanPelanggan.setText("Simpan");
        btSimpanPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSimpanPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSimpanPelangganMouseClicked(evt);
            }
        });
        btSimpanPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSimpanPelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(btSimpanPelanggan);
        btSimpanPelanggan.setBounds(10, 400, 90, 23);

        btUbahPelanggan.setText("Ubah");
        btUbahPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUbahPelanggan.setPreferredSize(new java.awt.Dimension(67, 23));
        btUbahPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUbahPelangganMouseClicked(evt);
            }
        });
        btUbahPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUbahPelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(btUbahPelanggan);
        btUbahPelanggan.setBounds(120, 400, 90, 23);

        btHapusPelanggan.setText("Hapus");
        btHapusPelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btHapusPelanggan.setPreferredSize(new java.awt.Dimension(67, 23));
        btHapusPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btHapusPelangganMouseClicked(evt);
            }
        });
        btHapusPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusPelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(btHapusPelanggan);
        btHapusPelanggan.setBounds(220, 400, 90, 23);

        btnClearpelanggan.setText("Clear");
        btnClearpelanggan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearpelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearpelangganMouseClicked(evt);
            }
        });
        btnClearpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearpelangganActionPerformed(evt);
            }
        });
        panel_pelanggan.add(btnClearpelanggan);
        btnClearpelanggan.setBounds(10, 370, 300, 23);

        getContentPane().add(panel_pelanggan);
        panel_pelanggan.setBounds(140, 10, 750, 640);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_customerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_customerMouseClicked

    private void btn_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customerActionPerformed
        // TODO add your handling code here:
        panel_pelanggan.setVisible(true);
        panel_transaksi.setVisible(false);
        panel_track.setVisible(false);
        getConnection();
        getDataCustomer();
    }//GEN-LAST:event_btn_customerActionPerformed

    private void btn_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transaksiMouseClicked

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        // TODO add your handling code here:
        panel_pelanggan.setVisible(false);
        panel_transaksi.setVisible(true);
        panel_track.setVisible(false);
        getConnection();
        getDataTransaction();
        getKotaAsalAgen(kode_agen_emp);
        getKotaTujuan();
        tv_harga.setText("Harga per KG : Rp "+getHarga(kode_kota_emp));
        
        cb_kotatujuan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                System.out.println("value "+cb_kotatujuan.getSelectedItem().toString());
                tv_harga.setText("Harga per KG : Rp "+getHarga(kode_kota_emp));
            }
        });
        
        getCustomerTransaction();
    }//GEN-LAST:event_btn_transaksiActionPerformed

    public void donotShowany()
    {
        panel_pelanggan.setVisible(false);
        panel_transaksi.setVisible(false);
        panel_track.setVisible(false);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Login lgn = new Login();
        lgn.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_nextorder_lines1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextorder_lines1ActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(null, kode_kota, "System", JOptionPane.DEFAULT_OPTION);

        SimpleDateFormat s = new SimpleDateFormat("ddMMyyyyhhmmss");
        String timestamp_format = s.format(new Date());

        if(total_harganya == 0 || et_namapaket.getText().length() == 0 || et_berat.getText().length() == 0|| et_alamat_trans.getText().length() == 0 )
        {
            JOptionPane.showMessageDialog(null, "Mohon lengkapi data transaksi di atas", "System", JOptionPane.DEFAULT_OPTION);
        }else
        {
            getConnection();

            try {
                
                String[] kodepengirim = cb_pengirim.getSelectedItem().toString().split(" - ");
                String kode_rim = kodepengirim[0];
                
                String[] kodepenerima = cb_namapenerima.getSelectedItem().toString().split(" - ");
                String kode_ma = kodepenerima[0];
                
                String createdata = "insert into paket_transaction (transaction_no, cost_estimate_kode,  cost,  sender_customer_kode,  receiver_customer_kode, alamat, nama_paket,  berat,  create_by) values ('PAKET"+timestamp_format+"','"+kode_estimasi+"','"+total_harganya+"','"+kode_rim+"','"+kode_ma+"','"+et_alamat_trans.getText().toString()+"','"+et_namapaket.getText().toString()+"','"+et_berat.getText().toString()+"','"+kode_emp+"')";
                mnSetting.stm.executeUpdate(createdata);
                getDataTransaction();
                clearTransField();
                
                try {
                    getConnection();

                    JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Reports/invoice.jasper"), null, mnSetting.con);
                    JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    System.out.println("Jaspger "+e.toString());
                    JOptionPane.showMessageDialog(rootPane, e);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error insert data\n"+ex);
            }

        }
    }//GEN-LAST:event_btn_nextorder_lines1ActionPerformed

    public void clearTransField()
    {
        et_namapaket.setText("");
        et_berat.setText("");
        et_alamat_trans.setText("");
    }
    
    private void et_namapaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_namapaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_namapaketActionPerformed

    private void et_caritransKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_caritransKeyTyped
        // TODO add your handling code here:
        System.out.println("typed");
        CariTransaction();
    }//GEN-LAST:event_et_caritransKeyTyped

    private void tabletransactionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletransactionMouseClicked
        // TODO add your handling code here:

//        String kode = (String) tableemployee.getValueAt(tableemployee.getSelectedRow(), 0);
//        String nama = (String) tableemployee.getValueAt(tableemployee.getSelectedRow(), 1);
//
//        try {
//            String select_data = "select *from employee where kode='"+kode+"'";
//            ResultSet rs_data = mnSetting.stm.executeQuery(select_data);
//            while (rs_data.next()) {
//                et_kodeemployee.setText(kode);
//                et_namaemployee.setText(nama);
//                if(rs_data.getString("gender").toLowerCase().equals("laki - laki"))
//                {
//                    rbemp_Laki.setSelected(true);
//                    rbemp_Perempuan.setSelected(false);
//                }else
//                {
//                    rbemp_Laki.setSelected(false);
//                    rbemp_Perempuan.setSelected(true);
//                }
//                et_usernameemp.setText(rs_data.getString("username"));
//                et_passwordemp.setText(rs_data.getString("password"));
//                for(int i=0;i < cb_idagen.getItemCount(); i++)
//                {
//                    if(cb_idagen.getItemAt(i).toString().contains(rs_data.getString("kode_agent")))
//                    {
//                        cb_idagen.setSelectedIndex(i);
//                    }
//                }
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    }//GEN-LAST:event_tabletransactionMouseClicked

    private void et_kodepelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_kodepelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_kodepelangganActionPerformed

    private void rbLakiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbLakiStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakiStateChanged

    private void rbLakiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbLakiMouseClicked
        // TODO add your handling code here:
        rbLaki.setSelected(true);
        if(rbLaki.isSelected())
        {
            rbPerempuan.setSelected(false);
        }else
        {

        }

    }//GEN-LAST:event_rbLakiMouseClicked

    private void rbLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakiActionPerformed

    private void rbPerempuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPerempuanMouseClicked
        // TODO add your handling code here:
        rbPerempuan.setSelected(true);
        if(rbPerempuan.isSelected())
        {
            rbLaki.setSelected(false);
        }else
        {

        }
    }//GEN-LAST:event_rbPerempuanMouseClicked

    private void rbPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPerempuanActionPerformed

    private void et_caripelangganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_caripelangganKeyTyped
        // TODO add your handling code here:
        System.out.println("typed");
        CariCustomer();
    }//GEN-LAST:event_et_caripelangganKeyTyped

    private void tablePelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePelangganMouseClicked
        // TODO add your handling code here:
        String kode = (String) tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 0);
        String nama = (String) tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 1);
        String jeniskelamin = (String) tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 2);
        String notelp = (String) tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 3);
        String alamat = (String) tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 4);

        et_kodepelanggan.setText(kode);
        et_namapelanggan.setText(nama);
        if(jeniskelamin.toLowerCase().equals("laki - laki"))
        {
            rbLaki.setSelected(true);
            rbPerempuan.setSelected(false);
        }else
        {
            rbLaki.setSelected(false);
            rbPerempuan.setSelected(true);
        }
        et_notelp.setText(notelp);
        et_alamat.setText(alamat);
    }//GEN-LAST:event_tablePelangganMouseClicked

    private void et_namapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_namapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_namapelangganActionPerformed

    private void btSimpanPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSimpanPelangganMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btSimpanPelangganMouseClicked

    private void btSimpanPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSimpanPelangganActionPerformed
        // TODO add your handling code here:
        if(rbLaki.isSelected())
        {
            jkel = rbLaki.getText().toString();
        }
        else
        {
            jkel = rbPerempuan.getText().toString();
        }

        if(et_kodepelanggan.getText().length() == 0 || et_namapelanggan.getText().length() == 0 || et_notelp.getText().length() == 0 || (rbLaki.isSelected() == false && rbPerempuan.isSelected() == false) || et_alamat.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Mohon lengkapi data customer di atas", "System", JOptionPane.DEFAULT_OPTION);
        }else
        {
            getConnection();

            try {

                String checkPelanggan = "SELECT count(*) from customer WHERE kode = '"+et_kodepelanggan.getText().toString()+"'";
                mnSetting.ps = mnSetting.con.prepareStatement(checkPelanggan);
                final ResultSet resultSet = mnSetting.ps.executeQuery();
                int count = 0;
                if(resultSet.next()) {
                    count = resultSet.getInt(1);
                }
                if(count > 0)
                {
                    JOptionPane.showMessageDialog(null, "Kode "+et_kodepelanggan.getText().toString()+" sudah terdaftar, mohon gunakan kode yang lain", "System", JOptionPane.DEFAULT_OPTION);
                }else
                {
                    String createPelanggan = "insert into customer (kode,nama,jeniskelamin,notelp,alamat) values ('"+et_kodepelanggan.getText().toString()+"','"+et_namapelanggan.getText().toString()+"','"+jkel+"','"+et_notelp.getText().toString()+"','"+et_alamat.getText().toString()+"')";
                    mnSetting.stm.executeUpdate(createPelanggan);
                    getDataCustomer();
                    clearCustomerField();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error insert data pelanggan\n"+ex);
            }

        }
    }//GEN-LAST:event_btSimpanPelangganActionPerformed

    private void btUbahPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUbahPelangganMouseClicked
        // TODO add your handling code here:
        if(rbLaki.isSelected())
        {
            jkel = rbLaki.getText().toString();
        }
        else
        {
            jkel = rbPerempuan.getText().toString();
        }

        if(et_kodepelanggan.getText().length() == 0 || et_namapelanggan.getText().length() == 0 || et_notelp.getText().length() == 0 || (rbLaki.isSelected() == false && rbPerempuan.isSelected() == false) || et_alamat.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Mohon pilih daftar customer di kanan", "System", JOptionPane.DEFAULT_OPTION);
        }else
        {
            getConnection();

            try {

                String checkPelanggan = "SELECT count(*) from customer WHERE kode = '"+et_kodepelanggan.getText().toString()+"'";
                mnSetting.ps = mnSetting.con.prepareStatement(checkPelanggan);
                final ResultSet resultSet = mnSetting.ps.executeQuery();
                int count = 0;
                if(resultSet.next()) {
                    count = resultSet.getInt(1);
                }
                if(count > 0)
                {
                    String updatePelanggan = "update customer SET nama='"+et_namapelanggan.getText().toString()+"', jeniskelamin='"+jkel+"', notelp='"+et_notelp.getText().toString()+"', alamat='"+et_alamat.getText().toString()+"' where kode='"+et_kodepelanggan.getText().toString()+"'";
                    mnSetting.stm.executeUpdate(updatePelanggan);
                    JOptionPane.showMessageDialog(null, "Kode "+et_kodepelanggan.getText().toString()+" berhasil diperbarui", "System", JOptionPane.DEFAULT_OPTION);
                    getDataCustomer();
                    clearCustomerField();
                }else
                {
                    JOptionPane.showMessageDialog(null, "Kode "+et_kodepelanggan.getText().toString()+" tidak dikenal, Silahkan pilih salah satu daftar customer dikanan untuk mendapatkan kode customer", "System", JOptionPane.DEFAULT_OPTION);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error update data pelanggan\n"+ex);
            }

        }
    }//GEN-LAST:event_btUbahPelangganMouseClicked

    private void btUbahPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUbahPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btUbahPelangganActionPerformed

    private void btHapusPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btHapusPelangganMouseClicked
        // TODO add your handling code here:
        if(et_kodepelanggan.getText().length() == 0 || et_namapelanggan.getText().length() == 0 || et_notelp.getText().length() == 0 || (rbLaki.isSelected() == false && rbPerempuan.isSelected() == false) || et_alamat.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Mohon pilih daftar customer di kanan", "System", JOptionPane.DEFAULT_OPTION);
        }else
        {
            getConnection();
            try {

                String checkCustomer = "SELECT count(*) from customer WHERE kode = '"+et_kodepelanggan.getText().toString()+"'";
                mnSetting.ps = mnSetting.con.prepareStatement(checkCustomer);
                final ResultSet resultSet = mnSetting.ps.executeQuery();
                int count = 0;
                if(resultSet.next()) {
                    count = resultSet.getInt(1);
                }
                if(count > 0)
                {

                    int dialogResult = JOptionPane.showConfirmDialog (null, "Apakah kamu yakin ingin menghapus kode "+et_kodepelanggan.getText().toString()+"?","Warning",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(dialogResult == JOptionPane.YES_OPTION){
                        String deletePelanggan = "delete from customer WHERE kode='"+et_kodepelanggan.getText().toString()+"'";
                        mnSetting.stm.executeUpdate(deletePelanggan);
                        JOptionPane.showMessageDialog(null, "Kode "+et_kodepelanggan.getText().toString()+" berhasil dihapus", "System", JOptionPane.DEFAULT_OPTION);
                        getDataCustomer();
                        clearCustomerField();
                    }

                }else
                {
                    JOptionPane.showMessageDialog(null, "Kode "+et_kodepelanggan.getText().toString()+" tidak dikenal, Silahkan pilih salah satu daftar pelanggan dikanan untuk mendapatkan kode pelanggan", "System", JOptionPane.DEFAULT_OPTION);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error delete data customer\n"+ex);
            }

        }
    }//GEN-LAST:event_btHapusPelangganMouseClicked

    private void btHapusPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btHapusPelangganActionPerformed

    private void btnClearpelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearpelangganMouseClicked
        // TODO add your handling code here:
        clearCustomerField();
    }//GEN-LAST:event_btnClearpelangganMouseClicked

    private void btnClearpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearpelangganActionPerformed

    private void et_cari_trackKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_cari_trackKeyTyped
        // TODO add your handling code here:
        CariTracking();
    }//GEN-LAST:event_et_cari_trackKeyTyped

    private void tabletrackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabletrackMouseClicked
        // TODO add your handling code here:
        
        String notrans = (String) tabletrack.getValueAt(tabletrack.getSelectedRow(), 0);
        
        et_track_notrans.setText(notrans);
        
    }//GEN-LAST:event_tabletrackMouseClicked

    private void et_caritransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_caritransActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_et_caritransActionPerformed

    private void cb_kotatujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kotatujuanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cb_kotatujuanActionPerformed

    private void et_beratKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_beratKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_et_beratKeyTyped

    private void et_beratKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_et_beratKeyReleased
        // TODO add your handling code here:
        
        if(et_berat.getText().length() == 0)
        {
            tv_total_harga.setText("Total : Rp 0");
        }else
        {
            try
            {
                String[] tvsharga = tv_harga.getText().toString().split(" Rp ");
                double hargaaja = Double.valueOf(tvsharga[1]);

                double berat = Double.valueOf(et_berat.getText().toString());

                total_harganya = hargaaja * berat;

                tv_total_harga.setText("Total : Rp "+total_harganya);
            }catch(Exception e)
            {

            }
        }
    }//GEN-LAST:event_et_beratKeyReleased

    private void btn_transaksi2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_transaksi2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_transaksi2MouseClicked

    private void btn_transaksi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksi2ActionPerformed
        // TODO add your handling code here:
        panel_pelanggan.setVisible(false);
        panel_transaksi.setVisible(false);
        panel_track.setVisible(true);
        getConnection();
        getTracking();
        
    }//GEN-LAST:event_btn_transaksi2ActionPerformed

    public void getTracking()
    {
        
        
       
        
        ArrayList<DataTrack> arraylist = new ArrayList<>();
            
        try {
             getConnection();
            String select = "select * from paket_tracker";
            ResultSet rs = mnSetting.stm.executeQuery(select);
            DataTrack dt;
            while (rs.next()) {
                dt = new DataTrack(rs.getString("id"), rs.getString("transaction_no"), rs.getString("description"), rs.getString("status"), rs.getString("created_date"), rs.getString("created_by"));
                arraylist.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "get Transaksi Failed\n"+ex, "System", JOptionPane.DEFAULT_OPTION);
        }
        
        DefaultTableModel model = (DefaultTableModel)tabletrack.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i<arraylist.size(); i++) {
            row[0] = arraylist.get(i).getTransaction_no();
            row[1] = arraylist.get(i).getStatus();
            row[2] = arraylist.get(i).getDesc();
            row[3] = arraylist.get(i).getCreated_by();
            row[4] = arraylist.get(i).getCreated_date();
            model.addRow(row);
        }
        
    }
    
    public void CariTracking()
    {
        
        ArrayList<DataTrack> arraylist = new ArrayList<>();
            
        try {
             getConnection();
            String select = "select * from paket_tracker where transaction_no like '%" + et_cari_track.getText().toString() + "%'";
            ResultSet rs = mnSetting.stm.executeQuery(select);
            DataTrack dt;
            while (rs.next()) {
                dt = new DataTrack(rs.getString("id"), rs.getString("transaction_no"), rs.getString("description"), rs.getString("status"), rs.getString("created_date"), rs.getString("created_by"));
                arraylist.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cari Transaksi Failed\n"+ex, "System", JOptionPane.DEFAULT_OPTION);
        }
        
        DefaultTableModel model = (DefaultTableModel)tabletrack.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i<arraylist.size(); i++) {
            row[0] = arraylist.get(i).getTransaction_no();
            row[1] = arraylist.get(i).getStatus();
            row[2] = arraylist.get(i).getDesc();
            row[3] = arraylist.get(i).getCreated_by();
            row[4] = arraylist.get(i).getCreated_date();
            model.addRow(row);
        }
        
    }
    
    private void et_track_notransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_et_track_notransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_et_track_notransActionPerformed

    private void btTrackSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTrackSubmit1ActionPerformed
        // TODO add your handling code here:
        if(et_track_notrans.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null, "Mohon lengkapi data tracking di atas", "System", JOptionPane.DEFAULT_OPTION);
        }else
        {
            getConnection();

            try {
                
                String createdata = "insert into paket_tracker (transaction_no, description,  status,  created_by) values ('"+et_track_notrans.getText().toString()+"','"+et_track_notes.getText().toString()+"','"+cb_track_status.getSelectedItem().toString()+"','"+kode_emp+"')";
                mnSetting.stm.executeUpdate(createdata);
                getTracking();
                
                
                if(cb_track_status.getSelectedItem().toString().toLowerCase().equals("pengiriman selesai"))
                {
                    try {
                        Map<String, Object> dbparam = new HashMap<>();
                        dbparam.put("notrans", et_track_notrans.getText().toString());
                        
                        getConnection();
                        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Reports/penerimaan.jasper"), dbparam, mnSetting.con);
                        JasperViewer.viewReport(jp, false);
                    } catch(Exception e) {
                        System.out.println("Jaspger "+e.toString());
                        JOptionPane.showMessageDialog(rootPane, e);
                    }
                }
                
                clearTrackField();
                

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error insert data\n"+ex);
            }

        }
    }//GEN-LAST:event_btTrackSubmit1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(et_track_notrans.getText().length() != 0)
        {
            
            try {
                getConnection();
                String select = "select * from paket_transaction where transaction_no = '" + et_track_notrans.getText().toString() + "'";
                ResultSet rs = mnSetting.stm.executeQuery(select);
                if(rs.next())
                {
                    try {
                        Map<String, Object> dbparam = new HashMap<>();
                        dbparam.put("notrans", et_track_notrans.getText().toString());

                        getConnection();
                        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Reports/stiker.jasper"), dbparam, mnSetting.con);
                        JasperViewer.viewReport(jp, false);
                    } catch(Exception e) {
                        System.out.println("Jaspger "+e.toString());
                        JOptionPane.showMessageDialog(rootPane, e);
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Kode tidak ditemukan", "System", JOptionPane.DEFAULT_OPTION);
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Cari Transaksi Failed\n"+ex, "System", JOptionPane.DEFAULT_OPTION);
            }
            
        }else
        {
            JOptionPane.showMessageDialog(null, "Masukkan kode transaksi", "System", JOptionPane.DEFAULT_OPTION);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Transaction_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction_Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction_Paket().setVisible(true);
            }
        });
    }
    
    
    public void CariTransaction()
    {
        
        ArrayList<DataTransaction> arraylist_data = new ArrayList<>();
            
        try {
            String select_data = "select *from paket_transaction where transaction_no like '%" + et_caritrans.getText().toString() + "%'";
            ResultSet rs = mnSetting.stm.executeQuery(select_data);
            DataTransaction dt;
            while (rs.next()) {
                dt = new DataTransaction(rs.getString("id"), rs.getString("transaction_no"), rs.getString("cost_estimate_kode"), rs.getString("cost"), rs.getString("sender_customer_kode"),rs.getString("receiver_customer_kode"),rs.getString("alamat"),rs.getString("nama_paket"),rs.getString("berat"),rs.getString("create_date"),rs.getString("create_by"));
                arraylist_data.add(dt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultTableModel model_data = (DefaultTableModel)tabletransaction.getModel();
        model_data.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i<arraylist_data.size(); i++) {
            row[0] = arraylist_data.get(i).getTransaction_no();
            row[1] = arraylist_data.get(i).getCost_estimate_kode();
            row[2] = arraylist_data.get(i).getSender_customer_kode();
            row[3] = arraylist_data.get(i).getAlamat();
            row[4] = arraylist_data.get(i).getNama_paket();
            row[5] = arraylist_data.get(i).getCreate_date();
            model_data.addRow(row);
        }
    }
    
    public void clearTrackField()
    {
        et_track_notrans.setText("");
        et_track_notes.setText("");
    }
    
    public void clearCustomerField()
    {
        et_kodepelanggan.setText("");
        et_namapelanggan.setText("");
        et_notelp.setText("");
        et_alamat.setText("");
    }
    
    public void getConnection()
    {
        
        if(mnSetting.con == null)
        {
            try {
                mnSetting.stm = mnSetting.con.createStatement();
                System.out.println("DB Connected");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Connection Failed\n"+ex, "System", JOptionPane.DEFAULT_OPTION);

            }
        }else
        {
            
            System.out.println("DB Still Connected");
        }
    }
    
    public void CariCustomer()
    {
        
        ArrayList<DataCustomer> arraylist_customer = new ArrayList<>();
            
        try {
            String select_customer = "select * from customer where nama like '%" + et_caripelanggan.getText().toString() + "%'";
            ResultSet rs_customer = mnSetting.stm.executeQuery(select_customer);
            DataCustomer dtCustomer;
            while (rs_customer.next()) {
                dtCustomer = new DataCustomer(rs_customer.getString("kode"), rs_customer.getString("nama"), rs_customer.getString("jeniskelamin"), rs_customer.getString("notelp"), rs_customer.getString("alamat"));
                arraylist_customer.add(dtCustomer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cari Customer Failed\n"+ex, "System", JOptionPane.DEFAULT_OPTION);
        }
        
        DefaultTableModel model_Pelanggan = (DefaultTableModel)tablePelanggan.getModel();
        model_Pelanggan.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i<arraylist_customer.size(); i++) {
            row[0] = arraylist_customer.get(i).getKode();
            row[1] = arraylist_customer.get(i).getNama();
            row[2] = arraylist_customer.get(i).getJeniskelamin();
            row[3] = arraylist_customer.get(i).getNotelp();
            row[4] = arraylist_customer.get(i).getAlamat();
            model_Pelanggan.addRow(row);
        }
        
    }
    
    public void getDataCustomer()
    {
        ArrayList<DataCustomer> arraylist_customer = new ArrayList<>();
            
        try {
            String select_customer = "select *from customer";
            ResultSet rs_customer = mnSetting.stm.executeQuery(select_customer);
            DataCustomer dtCustomer;
            while (rs_customer.next()) {
                dtCustomer = new DataCustomer(rs_customer.getString("kode"), rs_customer.getString("nama"), rs_customer.getString("jeniskelamin"), rs_customer.getString("notelp"), rs_customer.getString("alamat"));
                arraylist_customer.add(dtCustomer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultTableModel model_Pelanggan = (DefaultTableModel)tablePelanggan.getModel();
        model_Pelanggan.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i<arraylist_customer.size(); i++) {
            row[0] = arraylist_customer.get(i).getKode();
            row[1] = arraylist_customer.get(i).getNama();
            row[2] = arraylist_customer.get(i).getJeniskelamin();
            row[3] = arraylist_customer.get(i).getNotelp();
            row[4] = arraylist_customer.get(i).getAlamat();
            model_Pelanggan.addRow(row);
        }
        
    }
    
    public void getCustomerTransaction()
    {
        ArrayList<DataCustomer> arraylist_customer = new ArrayList<>();
        cb_pengirim.removeAllItems();
        cb_namapenerima.removeAllItems();
            
        try {
            String select_customer = "select *from customer";
            ResultSet rs_customer = mnSetting.stm.executeQuery(select_customer);
            DataCustomer dtCustomer;
            while (rs_customer.next()) {
                dtCustomer = new DataCustomer(rs_customer.getString("kode"), rs_customer.getString("nama"), rs_customer.getString("jeniskelamin"), rs_customer.getString("notelp"), rs_customer.getString("alamat"));
                arraylist_customer.add(dtCustomer);
                cb_pengirim.addItem(dtCustomer.getKode()+" - "+dtCustomer.getNama());
                cb_namapenerima.addItem(dtCustomer.getKode()+" - "+dtCustomer.getNama());
                
            }
            cb_namapenerima.setSelectedIndex(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        DefaultTableModel model_Pelanggan = (DefaultTableModel)tablePelanggan.getModel();
        model_Pelanggan.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i<arraylist_customer.size(); i++) {
            row[0] = arraylist_customer.get(i).getKode();
            row[1] = arraylist_customer.get(i).getNama();
            row[2] = arraylist_customer.get(i).getJeniskelamin();
            row[3] = arraylist_customer.get(i).getNotelp();
            row[4] = arraylist_customer.get(i).getAlamat();
            model_Pelanggan.addRow(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHapusPelanggan;
    private javax.swing.JButton btSimpanPelanggan;
    private javax.swing.JButton btTrackSubmit1;
    private javax.swing.JButton btUbahPelanggan;
    private javax.swing.JButton btnClearpelanggan;
    private javax.swing.JButton btn_customer;
    private javax.swing.JButton btn_nextorder_lines1;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton btn_transaksi2;
    private javax.swing.JComboBox<String> cb_kotatujuan;
    private javax.swing.JComboBox<String> cb_namapenerima;
    private javax.swing.JComboBox<String> cb_pengirim;
    private javax.swing.JComboBox<String> cb_track_status;
    private javax.swing.JTextArea et_alamat;
    private javax.swing.JTextArea et_alamat_trans;
    private javax.swing.JTextField et_berat;
    private javax.swing.JTextField et_cari_track;
    private javax.swing.JTextField et_caripelanggan;
    private javax.swing.JTextField et_caritrans;
    private javax.swing.JTextField et_kodepelanggan;
    private javax.swing.JTextField et_namapaket;
    private javax.swing.JTextField et_namapelanggan;
    private javax.swing.JTextField et_notelp;
    private javax.swing.JTextArea et_track_notes;
    private javax.swing.JTextField et_track_notrans;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_pelanggan;
    private javax.swing.JPanel panel_track;
    private javax.swing.JPanel panel_transaksi;
    private javax.swing.JRadioButton rbLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tablePelanggan;
    private javax.swing.JTable tabletrack;
    private javax.swing.JTable tabletransaction;
    private javax.swing.JLabel tv_harga;
    private javax.swing.JLabel tv_total_harga;
    // End of variables declaration//GEN-END:variables
}
