package p10514904;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Valent
 */
public class FPeminjaman extends javax.swing.JFrame {
    Connection conn;
    public DefaultTableModel tabModel;

    public FPeminjaman() {
        initComponents();
        AutoNumber();
        setJTable();        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNoPinjam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNoAnggota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        txtTglKembali = new javax.swing.JTextField();
        BTambah1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtJudul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodeBuku = new javax.swing.JTextField();
        BHapus = new javax.swing.JButton();
        BTambah = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        BClose = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BSimpan = new javax.swing.JButton();
        BBatal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPinjam = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel1.setText("No Pinjam");

        txtNoPinjam.setBackground(new java.awt.Color(255, 255, 0));
        txtNoPinjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNoPinjam.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNoPinjam.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("No Anggota");

        txtNoAnggota.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNoAnggota.setEnabled(false);
        txtNoAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoAnggotaKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setText("Nama");

        txtNama.setBackground(new java.awt.Color(153, 153, 153));
        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNama.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNama.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Tgl Pinjam");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setText("Tgl Kembali");

        txtTglPinjam.setBackground(new java.awt.Color(255, 255, 0));
        txtTglPinjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTglPinjam.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTglPinjam.setEnabled(false);

        txtTglKembali.setBackground(new java.awt.Color(255, 255, 0));
        txtTglKembali.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTglKembali.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTglKembali.setEnabled(false);

        BTambah1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BTambah1.setText("Create");
        BTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambah1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("@COPYRIGHT VALENT_10514904");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNoPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtNoAnggota))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(35, 35, 35)
                        .addComponent(BTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtTglKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTambah1)
                    .addComponent(jLabel11))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("Status");

        txtStatus.setBackground(new java.awt.Color(153, 153, 153));
        txtStatus.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStatus.setEnabled(false);

        txtJudul.setBackground(new java.awt.Color(153, 153, 153));
        txtJudul.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtJudul.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtJudul.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Judul");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("Kode Buku");

        txtKodeBuku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtKodeBuku.setEnabled(false);
        txtKodeBuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeBukuKeyPressed(evt);
            }
        });

        BHapus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BHapus.setText("Delete");
        BHapus.setEnabled(false);
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        BTambah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BTambah.setText("Insert");
        BTambah.setEnabled(false);
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(BTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTambah)
                    .addComponent(BHapus))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel10.setText("PEMINJAMAN BUKU");

        BClose.setBackground(new java.awt.Color(204, 204, 204));
        BClose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCloseMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Close");

        javax.swing.GroupLayout BCloseLayout = new javax.swing.GroupLayout(BClose);
        BClose.setLayout(BCloseLayout);
        BCloseLayout.setHorizontalGroup(
            BCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BCloseLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BCloseLayout.setVerticalGroup(
            BCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BCloseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(26, 26, 26))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BSimpan.setText("Confirm");
        BSimpan.setEnabled(false);
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        BBatal.setText("Cancel");
        BBatal.setEnabled(false);
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(BBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TPinjam.setBackground(new java.awt.Color(51, 255, 255));
        TPinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku"
            }
        ));
        jScrollPane2.setViewportView(TPinjam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel10)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BClose, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    public void AutoNumber() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Select * from Pinjam ORDER BY NoPinjam DESC";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String NoPeminjaman = rs.getString("NoPinjam").substring(1);
                String AN = "" + (Integer.parseInt(NoPeminjaman) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                txtNoPinjam.setText("P" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtNoPinjam.setText("P0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
  
    private void getData(){
        Connection conn;
        
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Select * from Pinjam";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
        
            String NoPinjam, TglPinjam, NoAnggota, TglKembali;
            int no=0;
            while(rs.next()){
                no=no+1;
                NoPinjam=rs.getString("NoPinjam");
                TglPinjam=rs.getString("TglPinjam");
                NoAnggota=rs.getString("NoAnggota");
                TglKembali=rs.getString("TglKembali");

                Object Data[]={no,NoPinjam, TglPinjam, NoAnggota, TglKembali};
                tabModel.addRow(Data);
            }
    
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {         // Ketika Gagal Memanggil Driver
            System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
            System.exit(0);
        }
        catch (SQLException sqle) {                   // Ketika Gagal Sql   // import java.sql.SQLException
            System.out.println("Proses Query Gagal = " + sqle);
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("Koneksi Access Gagal " +e.getMessage());
            System.exit(0);
        }
    }
    
    private void setJTable(){
        String [] JudulKolom={"Kode Buku","Judul"};
        tabModel = new DefaultTableModel(null, JudulKolom){
                      boolean[] canEdit = new boolean [] { false, false, false };
                      @Override
                      public boolean isCellEditable(int rowIndex, int columnIndex) {
                       return canEdit [columnIndex];
                      }
                  };
        TPinjam.setModel(tabModel);
        TPinjam.getColumnModel().getColumn(0).setPreferredWidth(100);
        TPinjam.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    private void txtNoAnggotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoAnggotaKeyPressed
        if (evt.getKeyCode()==10){
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
                String sql="select * from Anggota Where NoAnggota=?";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1,txtNoAnggota.getText());
                ResultSet rs= st.executeQuery();
                if( rs.next()){
                    String Nama = rs.getString("Nama");
                    txtNama.setText(Nama);
                } else{
                    JOptionPane.showMessageDialog(this, "No Anggota Tidak  Ada","Informasi",JOptionPane.INFORMATION_MESSAGE);
                    txtNama.setText("");
                }
            }
            catch(Exception e){
                System.out.println("Koneksi Gagal " +e.getMessage());
            }
        }
    }//GEN-LAST:event_txtNoAnggotaKeyPressed

    private void Kosongkan(){
        txtNoAnggota.setText("");
        txtTglPinjam.setText("");
        txtTglKembali.setText("");
        txtNama.setText("");
        txtKodeBuku.setText("");
        txtJudul.setText("");
        txtStatus.setText("");

        int row=tabModel.getRowCount();
        for(int i=0;i<row;i++){
            tabModel.removeRow(0);
        }

        txtNoPinjam.setEnabled(false);
        txtNoAnggota.setEnabled(false);
        txtKodeBuku.setEnabled(false);
    }

    private void txtKodeBukuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeBukuKeyPressed
        if (evt.getKeyCode()==10){           
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="select * from Buku Where KodeBuku=?";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1,txtKodeBuku.getText());
            ResultSet rs= st.executeQuery();

            if( rs.next()){
                String Judul = rs.getString("Judul");
                String Status = rs.getString("Status");
                txtJudul.setText(Judul);
                txtStatus.setText(Status);
            }else
                {
                    JOptionPane.showMessageDialog(this, "Kode Buku Tidak Ada","Informasi",JOptionPane.INFORMATION_MESSAGE);
                    txtJudul.setText("");
                    txtStatus.setText("");
                }
            }
            catch(Exception e){
                System.out.println("Exception :  " +e);
            }           
        }
    }//GEN-LAST:event_txtKodeBukuKeyPressed

    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
        String KodeBuku;
        boolean ketemu=false;

        int jum=tabModel.getRowCount();
        if(txtStatus.getText().equalsIgnoreCase("Ada")){

            for(int i=0;i<jum;i++){
                KodeBuku = tabModel.getValueAt(i, 0).toString();
                if(KodeBuku.equalsIgnoreCase(txtKodeBuku.getText())){
                    JOptionPane.showMessageDialog(this,"Buku Sudah Ada Pada List Pinjaman");
                    ketemu=true;
                    TPinjam.setRowSelectionInterval(i, i);
                    break;}
            }
            if (ketemu==false) {
                String Data[]={txtKodeBuku.getText(),txtJudul.getText()};
                tabModel.addRow(Data);

                txtKodeBuku.setText("");
                txtJudul.setText("");
                txtStatus.setText("");
            }
        }else
        JOptionPane.showMessageDialog(this, "Buku ini sedang dipinjam","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BTambahActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        int row=TPinjam.getSelectedRow();
        System.out.println(row);
        if(row>=0)
            tabModel.removeRow(row);
        else
            JOptionPane.showMessageDialog(this, "Gagal Dihapus");
    }//GEN-LAST:event_BHapusActionPerformed

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            if(txtNama.getText().isEmpty() || tabModel.getRowCount()==0 ){
                JOptionPane.showMessageDialog(this,"Silahkan Input Anggota dan Buku");
            } else {
                // Menyimpan ke Tabel Pinjam
                String sql="insert into Pinjam values(?,?,?,?)";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1,txtNoPinjam.getText());
                st.setString(2,txtTglPinjam.getText());
                st.setString(3,txtNoAnggota.getText());
                st.setString(4,txtTglKembali.getText());
                int rs= st.executeUpdate();

                String KodeBuku; int rs2=0;
                int jum=tabModel.getRowCount();
                for(int i=0;i<jum;i++){
                    // Menyimpan Ke detail Pinjam
                    String sql2="insert into DetailPinjam values(?,?,?)";
                    PreparedStatement st2=conn.prepareStatement(sql2);
                    KodeBuku = tabModel.getValueAt(i, 0).toString();
                    st2.setString(1,txtNoPinjam.getText());
                    st2.setString(2,KodeBuku);
                    st2.setString(3,"0");
                    rs2= st2.executeUpdate();
                    // Merubah status Buku
                    String sql3="update Buku set Status=? where KodeBuku=?";
                    PreparedStatement st3=conn.prepareStatement(sql3);
                    st3.setString(1,"Dipinjam");
                    st3.setString(2,KodeBuku);
                    st3.executeUpdate();
                }
                if((rs>0) && (rs2>0)){
                    JOptionPane.showMessageDialog(this,"Input Berhasil");
                    Kosongkan();
                    AutoNumber();
                } else
                    JOptionPane.showMessageDialog(this,"Input Gagal");
                conn.close();
            }
        } // akhir try
        catch(Exception e){
            System.out.println("Exception " +e );
        }
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        Kosongkan();
    }//GEN-LAST:event_BBatalActionPerformed

    private void BTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambah1ActionPerformed
        Date tgl_sekarang=new Date();
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        String tgl=format.format(tgl_sekarang);
        txtTglPinjam.setText(tgl);
        
        String dt = tgl;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException ex) {
            Logger.getLogger(FPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.add(Calendar.DATE, 3);  // number of days to add
        String tglKembali = sdf.format(c.getTime());  // dt is now the new date
        txtTglKembali.setText(tglKembali);

        txtNoPinjam.setEnabled(false);
        txtNoAnggota.setEnabled(true);
        txtKodeBuku.setEnabled(true);
        
        BTambah.setEnabled(true);
        BSimpan.setEnabled(true);
        BBatal.setEnabled(true);
        BHapus.setEnabled(true);
        BClose.setEnabled(true); 
        
    }//GEN-LAST:event_BTambah1ActionPerformed

    private void BCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCloseMouseClicked
        dispose();
    }//GEN-LAST:event_BCloseMouseClicked

    
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
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBatal;
    private javax.swing.JPanel BClose;
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BSimpan;
    private javax.swing.JButton BTambah;
    private javax.swing.JButton BTambah1;
    private javax.swing.JTable TPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoAnggota;
    private javax.swing.JTextField txtNoPinjam;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTglKembali;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}
