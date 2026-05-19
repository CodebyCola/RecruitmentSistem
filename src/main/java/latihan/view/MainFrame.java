/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package latihan.view;

import latihan.controller.Controller;
import latihan.dao.KandidatDAO;

/**
 *
 * @author Pongo
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private final Controller controller;
    private int selectedId = -1;

    public MainFrame() {
        initComponents();
        controller = new Controller(this);
        loadTable();
        listenTableClick();
    }

    private void listenTableClick() {
        mainTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = mainTable.getSelectedRow();
                if (row != -1) {
                    selectedId = (int) mainTable.getValueAt(row, 0);
                    inputName.setText((String) mainTable.getValueAt(row, 1));
                    inputPath.setSelectedItem((String) mainTable.getValueAt(row, 2));
                    inputWriting.setText(String.valueOf(mainTable.getValueAt(row, 3)));
                    inputCoding.setText(String.valueOf(mainTable.getValueAt(row, 4)));
                    inputInterview.setText(String.valueOf(mainTable.getValueAt(row, 5)));
                }
            }
        });
    }

    public void loadTable() {

        String[] columns = {"ID", "nama", "path", "writing", "coding", "interview", "final score", "status"};
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columns, 0);

        // Get all data from DB via controller
        java.util.List<latihan.model.Kandidat> list = controller.getAllKandidat();

        for (latihan.model.Kandidat k : list) {
            Object[] row = {
                k.getId(),
                k.getNama(),
                k.getPath(),
                k.getWriting(),
                k.getCoding(),
                k.getInterview(),
                k.calculateFinalScore(),
                k.getStatus()
            };
            model.addRow(row);
        }

        mainTable.setModel(model);
    }

    public void clearFields() {
        inputName.setText("");
        inputWriting.setText("");
        inputCoding.setText("");
        inputInterview.setText("");
        inputPath.setSelectedIndex(0);
        selectedId = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        form = new javax.swing.JPanel();
        inputName = new javax.swing.JTextField();
        inputWriting = new javax.swing.JTextField();
        inputPath = new javax.swing.JComboBox<>();
        inputCoding = new javax.swing.JTextField();
        inputInterview = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "nama", "path", "writing", "coding", "interview", "final score", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainTable.setColumnSelectionAllowed(true);
        mainTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(mainTable);
        mainTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (mainTable.getColumnModel().getColumnCount() > 0) {
            mainTable.getColumnModel().getColumn(0).setResizable(false);
            mainTable.getColumnModel().getColumn(1).setResizable(false);
            mainTable.getColumnModel().getColumn(2).setResizable(false);
            mainTable.getColumnModel().getColumn(3).setResizable(false);
            mainTable.getColumnModel().getColumn(4).setResizable(false);
            mainTable.getColumnModel().getColumn(5).setResizable(false);
            mainTable.getColumnModel().getColumn(6).setResizable(false);
            mainTable.getColumnModel().getColumn(7).setResizable(false);
        }

        inputName.setText("Input Name");
        inputName.setToolTipText("Name");
        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        inputWriting.setText("input Writing Score");
        inputWriting.setToolTipText("Name");
        inputWriting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputWritingActionPerformed(evt);
            }
        });

        inputPath.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Android Developer", "Website Developer" }));

        inputCoding.setText("input Coding Score");
        inputCoding.setToolTipText("Name");
        inputCoding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCodingActionPerformed(evt);
            }
        });

        inputInterview.setText("input Interview Score");
        inputInterview.setToolTipText("Name");
        inputInterview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputInterviewActionPerformed(evt);
            }
        });

        addBtn.setText("ADD");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });

        deleteBtn.setText("DELETE");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        clearBtn.setText("CLEAR ALL");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputName)
                    .addComponent(inputWriting, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(inputPath, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputCoding, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(inputInterview, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(inputPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(inputWriting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(inputCoding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(inputInterview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearBtn)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void inputWritingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputWritingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputWritingActionPerformed

    private void inputCodingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCodingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCodingActionPerformed

    private void inputInterviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputInterviewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputInterviewActionPerformed

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        // TODO add your handling code here:

        String nama = inputName.getText().trim();
        String path = (String) inputPath.getSelectedItem();
        int writing = Integer.parseInt(inputWriting.getText().trim());
        int coding = Integer.parseInt(inputCoding.getText().trim());
        int interview = Integer.parseInt(inputInterview.getText().trim());

        controller.addKandidat(nama, path, writing, coding, interview);
        loadTable();

        clearFields();

    }//GEN-LAST:event_addBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        // TODO add your handling code here:
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a row first!");
            return;
        }
        String nama = inputName.getText().trim();
        String path = (String) inputPath.getSelectedItem();
        int writing = Integer.parseInt(inputWriting.getText().trim());
        int coding = Integer.parseInt(inputCoding.getText().trim());
        int interview = Integer.parseInt(inputInterview.getText().trim());

        controller.updateKandidat(selectedId, nama, path, writing, coding, interview);
        loadTable();
        clearFields();
    }//GEN-LAST:event_updateBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        // TODO add your handling code here:
        if (selectedId == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Select a row first!");
            return;
        }
        controller.deleteKandidat(selectedId);
        loadTable();
        clearFields();

    }//GEN-LAST:event_deleteBtnMouseClicked

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_clearBtnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JPanel form;
    private javax.swing.JTextField inputCoding;
    private javax.swing.JTextField inputInterview;
    private javax.swing.JTextField inputName;
    private javax.swing.JComboBox<String> inputPath;
    private javax.swing.JTextField inputWriting;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mainTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
