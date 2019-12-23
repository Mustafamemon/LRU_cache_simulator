/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cache;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class UICache extends javax.swing.JFrame {

    private CacheClass cache;
    /**
     * Creates new form UICache
     */
    public UICache() {
       initComponents();
       	Dimension temp = this.getSize();
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
          this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
          this.setResizable(false);
          this.setSize(temp);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void initComponents() {

        backGround = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        writeHitPolicy = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        hitRate = new javax.swing.JLabel();
        cacheType = new javax.swing.JComboBox<>();
        setSize = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        query = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        writeMissPolicy = new javax.swing.JComboBox<>();
        replacementPolicy = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cacheTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cacheSize = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        randomB = new javax.swing.JButton();
        JLabel jLabel111 = new javax.swing.JLabel();
        JLabel jLabel112 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 620));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setResizable(false);
        getContentPane().setLayout(null);

        backGround.setBackground(new java.awt.Color(32,178,170));
        backGround.setMinimumSize(new java.awt.Dimension(1147, 800));
        backGround.setPreferredSize(new java.awt.Dimension(1200, 800));
        backGround.setLayout(null);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        backGround.add(jSeparator1);
        jSeparator1.setBounds(270, 0, 10, 800);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Query Sequence: ");
        backGround.add(jLabel1);
        jLabel1.setBounds(0, 310, 140, 40);

        writeHitPolicy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        writeHitPolicy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Write Through", "Write Back" }));
        writeHitPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeHitPolicyActionPerformed(evt);
            }
        });
        backGround.add(writeHitPolicy);
        writeHitPolicy.setBounds(120, 190, 150, 23);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        backGround.add(jSeparator2);
        jSeparator2.setBounds(270, 0, 10, 800);

        hitRate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        hitRate.setForeground(new java.awt.Color(51, 204, 0));
        backGround.add(hitRate);
        hitRate.setBounds(880, 650, 160, 40);

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel111.setText("Set Associative");
        backGround.add(jLabel111);
        jLabel111.setBounds(70, 30, 160, 23);
        cacheType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cacheType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Set Associative"}));
        cacheType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cacheTypeActionPerformed(evt);
            }
        });
        backGround.add(cacheType);
//        cacheType.setBounds(50, 30, 160, 23);

        setSize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "8", "16", "32" }));
        setSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSizeActionPerformed(evt);
            }
        });
        backGround.add(setSize);
        setSize.setBounds(160, 110, 110, 23);

        query.setColumns(20);
        query.setRows(5);
        jScrollPane1.setViewportView(query);

        backGround.add(jScrollPane1);
        jScrollPane1.setBounds(0, 350, 270, 180);

        submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submit.setText("Show Cache");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        backGround.add(submit);
        submit.setBounds(70, 550, 120, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Replacement Policy");
        backGround.add(jLabel5);
        jLabel5.setBounds(0, 140, 140, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Write Hit Policy");
        backGround.add(jLabel6);
        jLabel6.setBounds(0, 180, 140, 40);

        writeMissPolicy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        writeMissPolicy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Write Allocate", "No Write Allocate" }));
        writeMissPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writeMissPolicyActionPerformed(evt);
            }
        });
        backGround.add(writeMissPolicy);
        writeMissPolicy.setBounds(120, 230, 150, 23);
        
        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel112.setText("LRU");
        backGround.add(jLabel112);
        jLabel112.setBounds(180, 150, 110, 23);
        replacementPolicy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        replacementPolicy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"LRU"}));
        replacementPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replacementPolicyActionPerformed(evt);
            }
        });
        backGround.add(replacementPolicy);
//        replacementPolicy.setBounds(160, 150, 110, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cache Size");
        backGround.add(jLabel7);
        jLabel7.setBounds(0, 60, 80, 40);

        cacheTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cacheTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Block Number", "Cache Contents"
            }
        ) {
            
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cacheTable);

        backGround.add(jScrollPane2);
        jScrollPane2.setBounds(272, 72, 920, 510);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("# of Blocks in 1 Set");
        backGround.add(jLabel8);
        jLabel8.setBounds(0, 100, 150, 40);

        cacheSize.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cacheSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "8", "16", "32", "64", "128", "256" }));
        backGround.add(cacheSize);
        cacheSize.setBounds(160, 70, 110, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cache Contents");
        backGround.add(jLabel3);
        jLabel3.setBounds(590, 20, 200, 40);



        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Write Miss Policy");
        backGround.add(jLabel9);
        jLabel9.setBounds(0, 220, 140, 40);

        randomB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        randomB.setText("Random");
        randomB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomBActionPerformed(evt);
            }
        });
        backGround.add(randomB);
        randomB.setBounds(133, 320, 140, 23);

        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 1200, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void writeHitPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeHitPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_writeHitPolicyActionPerformed

    private void setSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setSizeActionPerformed

    private void writeMissPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writeMissPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_writeMissPolicyActionPerformed

    private void replacementPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replacementPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replacementPolicyActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        int cachesize= Integer.parseInt(cacheSize.getSelectedItem().toString());
        int setsize=Integer.parseInt(setSize.getSelectedItem().toString()) ;
        if(setsize> cachesize){
           JOptionPane.showMessageDialog(this,"# of blocks in 1 set should be less than or equals to cache size"
                   + "!" , "# of blocks in 1 set", JOptionPane.ERROR_MESSAGE); 
        }
        else{
            WriteHitPolicy writeHit; WriteMissPolicy writeMiss;
            if (writeHitPolicy.getSelectedIndex()==0)
              writeHit = WriteHitPolicy.WriteThrough;
            else
              writeHit = WriteHitPolicy.WriteBack;

            if (writeMissPolicy.getSelectedIndex()==0)
              writeMiss = WriteMissPolicy.WriteAllocate;
            else
              writeMiss = WriteMissPolicy.NoWriteAllocate;

            cache = new CacheClass(cachesize, writeHit, writeMiss);
            
            
           String query1 = query.getText();
            System.out.println(query1);
            if(cache.setLoadsAndStores(query1)){  
                int result[] =null;
                switch (cacheType.getSelectedIndex()) {
                    case 0: //Set Associative
                        result=cache.setSetAssociativeCache(cacheTable,setsize,replacementPolicy.getSelectedIndex());
                        break;

                }
                double hitRate1 = (double)(result[0])/(double)(result[2])*100;
                double missRate1 = (double)(result[1])/(double)(result[2])*100;
                hitRate1 = BigDecimal.valueOf(hitRate1).setScale(2, RoundingMode.HALF_UP).doubleValue();
                missRate1 = BigDecimal.valueOf(missRate1).setScale(2, RoundingMode.HALF_UP).doubleValue();
                JFrame frame = new JFrame();
                frame.getContentPane().add(new MyComponent(hitRate1,missRate1,result[0],result[1],result[2]));
                frame.setSize(500, 600);
                frame.setVisible(true);
                
            }
    } 
    }//GEN-LAST:event_submitActionPerformed

    private void randomBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomBActionPerformed
         int cachesize= Integer.parseInt(cacheSize.getSelectedItem().toString());
        String query1 = randomQueryMaker(cachesize);
            query.setText(query1);
    }//GEN-LAST:event_randomBActionPerformed

    private void cacheTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cacheTypeActionPerformed
            setSize.setEnabled(true);
            replacementPolicy.setEnabled(true);
        if(cacheType.getSelectedIndex()==1){
            setSize.setEnabled(false);
            replacementPolicy.setEnabled(false);
        }
        else if(cacheType.getSelectedIndex()==2){
            setSize.setEnabled(false);
        } 
    }//GEN-LAST:event_cacheTypeActionPerformed

    private String randomQueryMaker(int cacheSize){
        String query = ""; int size= 1;
        if(cacheSize <=16)
            size = cacheSize*8;
        else
            size = cacheSize*2;
        for (int i=0; i<size; i++){
            if(ThreadLocalRandom.current().nextInt(0, 4 + 1)==0)
                query+= "S ";
            else
                query+= "L ";
            
            query+= ThreadLocalRandom.current().nextInt(0, size+300 + 1);
            query+= "\n";
        
        }
        return query;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backGround;
    private javax.swing.JComboBox<String> cacheSize;
    private javax.swing.JTable cacheTable;
    private javax.swing.JComboBox<String> cacheType;
    private javax.swing.JLabel hitRate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea query;
    private javax.swing.JButton randomB;
    private javax.swing.JComboBox<String> replacementPolicy;
    private javax.swing.JComboBox<String> setSize;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox<String> writeHitPolicy;
    private javax.swing.JComboBox<String> writeMissPolicy;
    // End of variables declaration//GEN-END:variables
}
