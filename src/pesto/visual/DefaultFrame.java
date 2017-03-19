/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesto.visual;

import java.awt.CardLayout;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import pesto.internal.Entry;
import pesto.internal.Folder;

/**
 *
 * @author xerxes
 */
public class DefaultFrame extends javax.swing.JFrame {

    private static final Folder rootFolder = new Folder("Root", null);
    private static final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootFolder.getName());

    private static Iterator<Map.Entry<String, Entry>> entriesIter;
    private static Map.Entry<String, Entry> tmpMapEntry;
    private static DefaultTableModel dtm;
    private static Folder currentFolder = rootFolder;
    //private static Entry tmpEntry;

    /**
     * Creates new form DefaultFrame
     */
    public DefaultFrame() {
        initComponents();
        setLocationRelativeTo(null);
        refreshFolderTree();
        getPanelLayout().show(mainPanel, "listPanel");
    }

    /**
     * Refreshes the folder list
     */
    public static void refreshFolderTree() {
        rootNode.removeAllChildren();
        rootFolder.getFolders().stream().forEach((e) -> {
            rootNode.add(new DefaultMutableTreeNode(e.getName()));
        });
        setModel();
    }

    /**
     * Refreshes the entry table to reflect new changes
     */
    public static void refreshEntryTable() {
        updateEntryTableSize();
        entriesIter = currentFolder.getEntries().entrySet().iterator();
        int cnt = 0;
        while (entriesIter.hasNext()) {
            entryTable.setValueAt(entriesIter.next().getValue().getName(), cnt, 0);
            cnt++;
        }
    }

    public static void setModel() {
        folderTree.setModel(new DefaultTreeModel(rootNode));
    }

    /**
     * Sets a new row count for the entry table
     * <p>
     */
    public static void updateEntryTableSize() {
        dtm = (DefaultTableModel) entryTable.getModel();
        dtm.setRowCount(currentFolder.getEntries().size());
        entryTable.setModel(dtm);
    }

    public static CardLayout getPanelLayout() {
        return (CardLayout) mainPanel.getLayout();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entryTablePopupMenu = new javax.swing.JPopupMenu();
        deleteEntryPopupMenuItem = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        detailsPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        folderTree = new javax.swing.JTree();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newEntryMenuItem = new javax.swing.JMenuItem();
        newFolderMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();

        deleteEntryPopupMenuItem.setText("Delete");
        deleteEntryPopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryPopupMenuItemActionPerformed(evt);
            }
        });
        entryTablePopupMenu.add(deleteEntryPopupMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesto");
        setMinimumSize(new java.awt.Dimension(632, 384));
        setPreferredSize(new java.awt.Dimension(632, 384));

        mainPanel.setLayout(new java.awt.CardLayout());

        detailsPanel.setMaximumSize(new java.awt.Dimension(620, 364));
        detailsPanel.setName(""); // NOI18N
        detailsPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Name");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nameField))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsPanelLayout.createSequentialGroup()
                        .addGap(0, 474, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        mainPanel.add(detailsPanel, "detailsPanel");

        listPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        jScrollPane1.setDoubleBuffered(true);

        entryTable.setAutoCreateRowSorter(true);
        entryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Username"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        entryTable.setDoubleBuffered(true);
        entryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                entryTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                entryTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(entryTable);

        jScrollPane2.setDoubleBuffered(true);

        folderTree.setDoubleBuffered(true);
        folderTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                folderTreeValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(folderTree);

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(listPanel, "listPanel");

        menuBar.setInheritsPopupMenu(true);
        menuBar.setMargin(new java.awt.Insets(3, 10, 3, 0));
        menuBar.setMinimumSize(new java.awt.Dimension(95, 17));
        menuBar.setRequestFocusEnabled(false);

        fileMenu.setText("File");

        newEntryMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newEntryMenuItem.setText("New entry");
        newEntryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEntryMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newEntryMenuItem);

        newFolderMenuItem.setText("New folder");
        newFolderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFolderMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newFolderMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        viewMenu.setText("View");
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newEntryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEntryMenuItemActionPerformed
        getPanelLayout().show(mainPanel, "detailsPanel");
    }//GEN-LAST:event_newEntryMenuItemActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        boolean noDuplicate = true;
        if (currentFolder.getEntries().size() > 0) {
            entriesIter = currentFolder.getEntries().entrySet().iterator();
            while (entriesIter.hasNext()) {
                tmpMapEntry = entriesIter.next();
                if (tmpMapEntry.getKey().equals(nameField.getText())) {
                    JOptionPane.showMessageDialog(this, "Error: an entry with the same name already exists.",
                            "New entry", JOptionPane.ERROR_MESSAGE);
                    noDuplicate = false;
                    break;
                }
            }
        }

        if (noDuplicate) {
            currentFolder.addEntry(new Entry(nameField.getText()));
            nameField.setText("");
            getPanelLayout().show(mainPanel, "listPanel");
            refreshEntryTable();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void entryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMousePressed
        if (evt.isPopupTrigger()) {
            entryTablePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_entryTableMousePressed

    private void entryTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMouseReleased
        entryTableMousePressed(evt);
    }//GEN-LAST:event_entryTableMouseReleased

    private void folderTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_folderTreeValueChanged

    }//GEN-LAST:event_folderTreeValueChanged

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        getPanelLayout().show(mainPanel, "listPanel");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void newFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFolderMenuItemActionPerformed
        String res = JOptionPane.showInputDialog(this, "Folder name:", "New folder", JOptionPane.QUESTION_MESSAGE);
        if (res != null) {
            currentFolder.addFolder(new Folder(res, currentFolder));
            refreshFolderTree();
        }
    }//GEN-LAST:event_newFolderMenuItemActionPerformed

    private void deleteEntryPopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryPopupMenuItemActionPerformed
        entriesIter = currentFolder.getEntries().entrySet().iterator();
        while (entriesIter.hasNext()) {
            tmpMapEntry = entriesIter.next();
            if (tmpMapEntry.getKey().equals(entryTable.getValueAt(entryTable.getSelectedRow(), 0))) {
                currentFolder.deleteEntry(tmpMapEntry.getValue());
                refreshEntryTable();
                break;
            }
        }
    }//GEN-LAST:event_deleteEntryPopupMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefaultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaultFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem deleteEntryPopupMenuItem;
    private static javax.swing.JPanel detailsPanel;
    private javax.swing.JMenu editMenu;
    private static javax.swing.JTable entryTable;
    private javax.swing.JPopupMenu entryTablePopupMenu;
    private javax.swing.JMenu fileMenu;
    private static javax.swing.JTree folderTree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JPanel listPanel;
    private static javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private static javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenuItem newEntryMenuItem;
    private javax.swing.JMenuItem newFolderMenuItem;
    private static javax.swing.JButton okButton;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables

}
