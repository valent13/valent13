package p10514904;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Valent
 */
public class MasterBuku extends javax.swing.JFrame {
    public DefaultTableModel tabModel;
    Connection conn;

    public MasterBuku() {
        initComponents();
        AutoNumber();
        setJTable();
        CBStatus.removeAllItems();
        CBStatus.addItem("");
        CBStatus.addItem("Ada");
        CBStatus.addItem("Dipinjam");
    }
    
    public void AutoNumber() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Select * from Buku ORDER BY KodeBuku DESC";
            Statement stt = conn.createStatement();
            ResultSet rs = stt.executeQuery(sql);
            if (rs.next()) {
                String KodeBuku = rs.getString("KodeBuku").substring(1);
                String AN = "" + (Integer.parseInt(KodeBuku) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                txtKodeBuku.setText("B" + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                txtKodeBuku.setText("B0001");//sesuaikan dengan variable namenya
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }

    private void getData(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Select * from Buku";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            String KodeBuku,Judul,Pengarang,Penerbit,TahunTerbit,Status;
            int no=0;
            while(rs.next()){
                no=no+1;
                KodeBuku=rs.getString("KodeBuku");
                Judul=rs.getString("Judul");
                Pengarang=rs.getString("Pengarang");
                Penerbit=rs.getString("Penerbit");
                TahunTerbit=rs.getString("TahunTerbit");
                Status=rs.getString("Status");

                Object Data[]={no,KodeBuku,Judul,Pengarang,Penerbit,TahunTerbit,Status};
                tabModel.addRow(Data);
            }
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
               System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
               System.exit(0);
        }
        catch (SQLException sqle) {
            System.out.println("Proses Query Gagal = " + sqle);
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("Koneksi Access Gagal " +e.getMessage());
            System.exit(0);
        }
    }
    
    private void setJTable(){
        String [] JudulKolom={"No","Kode Buku","Judul","Pengarang","Penerbit","Tahun Terbit","Status"};
        tabModel = new DefaultTableModel(null, JudulKolom){
            boolean[] canEdit = new boolean [] { false, false, false, false, false, false};
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
               
        TBuku.setModel(tabModel);
        TBuku.setAutoResizeMode(TBuku.AUTO_RESIZE_OFF);
        TBuku.getColumnModel().getColumn(0).setPreferredWidth(30);
        TBuku.getColumnModel().getColumn(1).setPreferredWidth(90);
        TBuku.getColumnModel().getColumn(2).setPreferredWidth(300);
        TBuku.getColumnModel().getColumn(3).setPreferredWidth(300);
        TBuku.getColumnModel().getColumn(4).setPreferredWidth(300);
        TBuku.getColumnModel().getColumn(5).setPreferredWidth(100);
        TBuku.getColumnModel().getColumn(6).setPreferredWidth(100);  
        getData();
    }
    
    void ambilData_dari_JTable() {
        int row = TBuku.getSelectedRow();
        String KodeBuku = tabModel.getValueAt(row, 1).toString();
        String Judul = tabModel.getValueAt(row, 2).toString();
        String Pengarang = tabModel.getValueAt(row, 3).toString();
        String Penerbit = tabModel.getValueAt(row, 4).toString();
        String TahunTerbit = tabModel.getValueAt(row, 5).toString();
        CBStatus.addItem(tabModel.getValueAt(row, 6).toString());

        txtKodeBuku.setText(KodeBuku);
        txtJudul.setText(Judul);
        txtPengarang.setText(Pengarang);
        txtPenerbit.setText(Penerbit);
        txtTahunTerbit.setText(TahunTerbit);
    }
    
    public void hapus_Data() {
    // Konfirmasi sebelum melakukan penghapusan data
        ambilData_dari_JTable();
        String Status;
        int ok = JOptionPane.showConfirmDialog(this,
            "Anda Yakin Ingin Menghapus Data\nDengan Kode Buku = '" + txtKodeBuku.getText() +
            "'", "Konfirmasi Menghapus Data",JOptionPane.YES_NO_OPTION);
        if (ok == 0) {     // Apabila tombol OK ditekan
          try {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql = "DELETE FROM Buku WHERE KodeBuku = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, txtKodeBuku.getText());
            int rs=st.executeUpdate();
            if(rs>0){
            tampilDataKeJTable();
            JOptionPane.showMessageDialog(this,"Data Sudah dihapus");
            }
            txtKodeBuku.setText("");
            txtJudul.setText("");
            txtPengarang.setText("");
            txtPenerbit.setText("");
            txtTahunTerbit.setText("");

            }catch (Exception se) {  // Silahkan tambahkan catch Exception yang lain
             JOptionPane.showMessageDialog(this,"Gagal Hapus Data.. ");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RBStatus = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBuku = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtPenerbit = new javax.swing.JTextField();
        txtPengarang = new javax.swing.JTextField();
        txtKodeBuku = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        BTambah = new javax.swing.JButton();
        txtTahunTerbit = new javax.swing.JTextField();
        BSimpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CBStatus = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        CBCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        BCari = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BEdit = new javax.swing.JButton();
        BBatal = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        BClose = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TBuku.setBackground(new java.awt.Color(51, 255, 255));
        TBuku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        TBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Buku", "Judul", "Pengarang", "Penerbit", "Tahun Terbit", "Status"
            }
        ));
        jScrollPane1.setViewportView(TBuku);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel12.setText("Penerbit");

        txtPenerbit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPenerbit.setEnabled(false);

        txtPengarang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPengarang.setEnabled(false);

        txtKodeBuku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtKodeBuku.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtKodeBuku.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setText("Kode Buku");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setText("Judul");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setText("Pengarang");

        txtJudul.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtJudul.setEnabled(false);

        BTambah.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BTambah.setText("Create");
        BTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTambahActionPerformed(evt);
            }
        });

        txtTahunTerbit.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTahunTerbit.setEnabled(false);

        BSimpan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BSimpan.setText("Confirm");
        BSimpan.setEnabled(false);
        BSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSimpanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("Tahun Terbit");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Status");

        CBStatus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        CBStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ada", "Dipinjam" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJudul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPenerbit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtPengarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTambah)
                            .addComponent(BSimpan))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(CBStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CBCari.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        CBCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KodeBuku", "Judul", "Pengarang", "Penerbit" }));

        BCari.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BCari.setText("Find");
        BCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCariActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(32, 32, 32)
                .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(BCari, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CBCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BEdit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BEdit.setText("Edit");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });

        BBatal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BBatal.setText("Cancel");
        BBatal.setEnabled(false);
        BBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBatalActionPerformed(evt);
            }
        });

        BHapus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        BHapus.setText("Delete");
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(BBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BBatal)
                    .addComponent(BHapus)
                    .addComponent(BEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BClose.setBackground(new java.awt.Color(204, 204, 204));
        BClose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCloseMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Close");

        javax.swing.GroupLayout BCloseLayout = new javax.swing.GroupLayout(BClose);
        BClose.setLayout(BCloseLayout);
        BCloseLayout.setHorizontalGroup(
            BCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BCloseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        BCloseLayout.setVerticalGroup(
            BCloseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BCloseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jLabel4.setText("DATA BUKU");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("@COPYRIGHT VALENT_10514904");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void simpanData(){
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Insert into Buku values(?,?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(sql);
            st.setString(1, txtKodeBuku.getText());
            st.setString(2, txtJudul.getText());
            st.setString(3, txtPengarang.getText());
            st.setString(4, txtPenerbit.getText());
            st.setString(5, txtTahunTerbit.getText());
            st.setString(6, CBStatus.getSelectedItem().toString());
            int rs=st.executeUpdate();

            if(rs>0){
                JOptionPane.showMessageDialog(this,"Input Data Buku Berhasil");
                tampilDataKeJTable();
            }
            AutoNumber();
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
        }
        catch (SQLException sqle) {
            System.out.println("Input  Gagal = " + sqle.getMessage());
        }
        catch(Exception e){
            System.out.println("Koneksi Gagal " +e.getMessage());
        }
    }
    
    public void hapusIsiJTable() {
        int row = tabModel.getRowCount();
        for (int i = 0; i < row; i++) {
            tabModel.removeRow(0);
        }
    }
    
    public void tampilDataKeJTable() {
        hapusIsiJTable();
        try {
            conn.close();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="Select * from Buku";
            PreparedStatement st=conn.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            String KodeBuku,Judul,Pengarang,Penerbit,TahunTerbit,Status;
            int no=0;
            while(rs.next()){
                no=no+1;
                KodeBuku=rs.getString("KodeBuku");
                Judul=rs.getString("Judul");
                Pengarang=rs.getString("Pengarang");
                Penerbit=rs.getString("Penerbit");
                TahunTerbit=rs.getString("TahunTerbit");
                Status=rs.getString("Status");
                Object Data[]={no,KodeBuku,Judul,Pengarang,Penerbit,TahunTerbit,Status};
                tabModel.addRow(Data);
            }
        }
        catch (Exception e) {}
    }
    
    private void clrtxt(){
        txtPenerbit.setText("");
        txtPengarang.setText("");
        txtTahunTerbit.setText("");
        txtJudul.setText("");
    }
    
    public void rubahData() {
        //String Status;
        int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Mengubah Data\n Dengan Kode Buku = '" + txtKodeBuku.getText() +
        "'", "Konfirmasi ",JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
            String sql="UPDATE buku SET Judul='"+txtJudul.getText()+"',Pengarang='"+txtPengarang.getText()+"',Penerbit='"+txtPenerbit.getText()+"',TahunTerbit='"+txtTahunTerbit.getText()+"',Status='"+CBStatus.getSelectedItem()+"' where KodeBuku='"+txtKodeBuku.getText()+"'";
            PreparedStatement st=conn.prepareStatement(sql);
            int rs=st.executeUpdate();

            if(rs==1){
                JOptionPane.showMessageDialog(this,"Edit Berhasil");
                setJTable();
                clrtxt();
                txtPenerbit.setEnabled(false); // txtNoAnggota Tidak Aktif
                txtJudul.setEnabled(false);       // txtNama          Aktif
                txtPengarang.setEnabled(false);         // TODO add your handling code here:
                txtTahunTerbit.setEnabled(false);
                txtKodeBuku.setEnabled(false);
            }
            st.close();
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Class Driver tidak ditemukan.. : " + cnfe);
        }
        catch (SQLException sqle) {
            System.out.println("Edit  Gagal = " + sqle.getMessage());
        }
        catch(Exception e){
            System.out.println("Koneksi Gagal " +e.getMessage());
        }
        }
    }
    
    private void BTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTambahActionPerformed
        txtKodeBuku.setEnabled(false);
        txtJudul.setEnabled(true);
        txtPengarang.setEnabled(true);
        txtPenerbit.setEnabled(true);
        txtTahunTerbit.setEnabled(true);
        CBStatus.setEnabled(true);
        
        BSimpan.setText("Confirm");
        
        BTambah.setEnabled(false);
        BSimpan.setEnabled(true);
        BEdit.setEnabled(false);
        BBatal.setEnabled(true);
        BHapus.setEnabled(false);
        BClose.setEnabled(false); 
    }//GEN-LAST:event_BTambahActionPerformed

    private void BSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSimpanActionPerformed
        if(BSimpan.getText().equalsIgnoreCase("Confirm"))
            simpanData();
        else
            rubahData();
        
        String Status;
        txtJudul.setText("");
        txtPengarang.setText("");
        txtPenerbit.setText("");
        txtTahunTerbit.setText("");

        
        
        txtKodeBuku.setEnabled(false);
        txtJudul.setEnabled(false);
        txtPengarang.setEnabled(false);
        txtPenerbit.setEnabled(false);
        txtTahunTerbit.setEnabled(false);
        CBStatus.setEnabled(false);
        
        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true); 
    }//GEN-LAST:event_BSimpanActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        hapus_Data();
    }//GEN-LAST:event_BHapusActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        txtKodeBuku.setEnabled(false);
        txtJudul.setEnabled(true);
        txtPengarang.setEnabled(true);
        txtPenerbit.setEnabled(true);
        txtTahunTerbit.setEnabled(true);
        CBStatus.setEnabled(true);
        
        BSimpan.setText("Update");
        
        BTambah.setEnabled(false);
        BSimpan.setEnabled(true);
        BEdit.setEnabled(false);
        BBatal.setEnabled(true);
        BHapus.setEnabled(false);
        BClose.setEnabled(false);
        
        ambilData_dari_JTable();
    }//GEN-LAST:event_BEditActionPerformed

    private void BBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBatalActionPerformed
        String Status;
        txtJudul.setText("");
        txtPengarang.setText("");
        txtPenerbit.setText("");
        txtTahunTerbit.setText("");

        
        txtKodeBuku.setEnabled(false);
        txtJudul.setEnabled(false);
        txtPengarang.setEnabled(false);
        txtPenerbit.setEnabled(false);
        txtTahunTerbit.setEnabled(false);
        CBStatus.setEnabled(false);
        
        BTambah.setEnabled(true);
        BSimpan.setEnabled(false);
        BEdit.setEnabled(true);
        BBatal.setEnabled(false);
        BHapus.setEnabled(true);
        BClose.setEnabled(true);
    }//GEN-LAST:event_BBatalActionPerformed

    private void BCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCariActionPerformed
        String sql;
        int pilih = CBCari.getSelectedIndex();
        String cari = txtCari.getText();
    try {
        conn.close();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PERPUS");
        if(pilih==0)
        sql ="Select * from Buku WHERE KodeBuku ='" +txtCari.getText() + "'";
        else if(pilih==1)
        sql ="Select * from Buku WHERE Judul Like '%" +txtCari.getText() + "%'";
        else if(pilih==2)
        sql ="Select * from Buku WHERE Pengarang Like '%" +txtCari.getText() + "%'";
        else
        sql ="Select * from Buku WHERE Penerbit Like '%" +txtCari.getText() + "%'";

        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs =st.executeQuery();

        hapusIsiJTable();
        int no=0;
        while (rs.next()) {
            no++;
             String KodeBuku = rs.getString("KodeBuku");
             String JudulBuku = rs.getString("Judul");
             String Pengarang = rs.getString("Pengarang");
             String Penerbit = rs.getString("Penerbit");
             String Tahun = rs.getString("TahunTerbit");
             String Status = rs.getString("Status");
             Object [] data = {no,KodeBuku,JudulBuku, Pengarang,Penerbit,Tahun,Status};
             tabModel.addRow(data);
        }

        if(tabModel.getRowCount()>0)
           JOptionPane.showMessageDialog(this,"Data Ditemukan ");
        else
           JOptionPane.showMessageDialog(this,"Data Tidak Ditemukan.. ");
      }
      catch (ClassNotFoundException se) {}  // Silahkan tambahkan sendiri informasi eksepsi
      catch (SQLException se) {}
    }//GEN-LAST:event_BCariActionPerformed

    private void BCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCloseMouseClicked
        dispose();
    }//GEN-LAST:event_BCloseMouseClicked


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterBuku().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBatal;
    private javax.swing.JButton BCari;
    private javax.swing.JPanel BClose;
    private javax.swing.JButton BEdit;
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BSimpan;
    private javax.swing.JButton BTambah;
    private javax.swing.JComboBox<String> CBCari;
    private javax.swing.JComboBox<String> CBStatus;
    private javax.swing.ButtonGroup RBStatus;
    private javax.swing.JTable TBuku;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtKodeBuku;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtTahunTerbit;
    // End of variables declaration//GEN-END:variables
}
