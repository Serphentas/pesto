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
import pesto.internal.properties.Password;
import pesto.internal.properties.Username;

/**
 *
 * @author xerxes
 */
public class DefaultFrame extends javax.swing.JFrame {

    private static final Folder rootFolder = new Folder("Root", null);
    private static final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootFolder.getName());

    private static Iterator<Map.Entry<String, Entry>> entriesIter;
    private static DefaultTableModel dtm;
    private static Folder currentFolder = rootFolder;
    private static boolean isPWShown = false;
    private static Entry currentEntry;

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
     * Refreshes the folder tree to reflect new changes
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
        Entry tmpEntry;
        while (entriesIter.hasNext()) {
            tmpEntry = entriesIter.next().getValue();
            entryTable.setValueAt(tmpEntry.getName(), cnt, 0);
            entryTable.setValueAt(tmpEntry.getUsername(), cnt, 1);
            cnt++;
        }
    }

    /**
     * Sets the folder tree model
     */
    public static void setModel() {
        folderTree.setModel(new DefaultTreeModel(rootNode));
    }

    /**
     * Sets the entry table's row count to the current folder's entry map size
     */
    public static void updateEntryTableSize() {
        dtm = (DefaultTableModel) entryTable.getModel();
        dtm.setRowCount(currentFolder.getEntries().size());
        entryTable.setModel(dtm);
    }

    /**
     * Returns the main panel's card layout
     *
     * @return main panel card layout
     */
    public static CardLayout getPanelLayout() {
        return (CardLayout) mainPanel.getLayout();
    }

    /**
     * Resets the fields in creation and edition panels
     */
    public static void resetFields() {
        createPanelNameField.setText("");
        createPanelUNField.setText("");
        createPanelPWField.setText("");
        editPanelNameField.setText("");
        editPanelUNField.setText("");
        editPanelPWField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entryTablePopupMenu = new javax.swing.JPopupMenu();
        deleteEntryPopupMenuItem = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        createPanel = new javax.swing.JPanel();
        createPanelOKButton = new javax.swing.JButton();
        createPanelNameLabel = new javax.swing.JLabel();
        createPanelNameField = new javax.swing.JTextField();
        createPanelCancelButton = new javax.swing.JButton();
        createPanelUNField = new javax.swing.JTextField();
        createPanelPWField = new javax.swing.JPasswordField();
        createPanelUNLabel = new javax.swing.JLabel();
        createPanelPWLabel = new javax.swing.JLabel();
        newEntryLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        folderTree = new javax.swing.JTree();
        editPanel = new javax.swing.JPanel();
        editPanelNameLabel = new javax.swing.JLabel();
        editPanelNameField = new javax.swing.JTextField();
        editPanelOKButton = new javax.swing.JButton();
        editEntryLabel = new javax.swing.JLabel();
        editPanelSeparator = new javax.swing.JSeparator();
        editPanelCancelButton = new javax.swing.JButton();
        editPanelUNLabel = new javax.swing.JLabel();
        editPanelUNField = new javax.swing.JTextField();
        editPanelPWLabel = new javax.swing.JLabel();
        editPanelPWField = new javax.swing.JPasswordField();
        editPanelPWToggleButton = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newEntryMenuItem = new javax.swing.JMenuItem();
        newFolderMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();

        deleteEntryPopupMenuItem.setText("Delete");
        deleteEntryPopupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryPopupMenuItemActionPerformed(evt);
            }
        });
        entryTablePopupMenu.add(deleteEntryPopupMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Pesto");
        setMinimumSize(new java.awt.Dimension(632, 384));
        setPreferredSize(new java.awt.Dimension(632, 384));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setLayout(new java.awt.CardLayout());

        createPanel.setMaximumSize(new java.awt.Dimension(620, 364));
        createPanel.setName(""); // NOI18N
        createPanel.setPreferredSize(new java.awt.Dimension(0, 0));

        createPanelOKButton.setText("OK");
        createPanelOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPanelOKButtonActionPerformed(evt);
            }
        });

        createPanelNameLabel.setText("Name");

        createPanelCancelButton.setText("Cancel");
        createPanelCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPanelCancelButtonActionPerformed(evt);
            }
        });

        createPanelUNLabel.setText("Username");

        createPanelPWLabel.setText("Password");

        newEntryLabel.setText("New entry");

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(0, 474, Short.MAX_VALUE)
                        .addComponent(createPanelOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createPanelCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createPanelUNLabel)
                            .addComponent(createPanelPWLabel)
                            .addComponent(createPanelNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createPanelNameField)
                            .addComponent(createPanelPWField)
                            .addComponent(createPanelUNField)))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addComponent(newEntryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newEntryLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPanelNameLabel)
                    .addComponent(createPanelNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPanelUNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPanelUNLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPanelPWField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPanelPWLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createPanelCancelButton)
                    .addComponent(createPanelOKButton))
                .addContainerGap())
        );

        mainPanel.add(createPanel, "createPanel");

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
        entryTable.setShowHorizontalLines(false);
        entryTable.setShowVerticalLines(false);
        entryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                entryTableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                entryTableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(entryTable);

        jScrollPane2.setDoubleBuffered(true);

        folderTree.setDoubleBuffered(true);
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

        editPanel.setVerifyInputWhenFocusTarget(false);

        editPanelNameLabel.setText("Name");

        editPanelNameField.setEditable(false);
        editPanelNameField.setToolTipText("");
        editPanelNameField.setEnabled(false);

        editPanelOKButton.setText("OK");
        editPanelOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPanelOKButtonActionPerformed(evt);
            }
        });

        editEntryLabel.setText("Edit entry");

        editPanelCancelButton.setText("Cancel");
        editPanelCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPanelCancelButtonActionPerformed(evt);
            }
        });

        editPanelUNLabel.setText("Username");

        editPanelPWLabel.setText("Password");

        editPanelPWToggleButton.setText("T");
        editPanelPWToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPanelPWToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addComponent(editEntryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editPanelSeparator))
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editPanelUNLabel)
                            .addComponent(editPanelNameLabel)
                            .addComponent(editPanelPWLabel))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editPanelNameField)
                            .addComponent(editPanelUNField)
                            .addGroup(editPanelLayout.createSequentialGroup()
                                .addComponent(editPanelPWField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editPanelPWToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                        .addGap(0, 474, Short.MAX_VALUE)
                        .addComponent(editPanelOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editPanelCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editEntryLabel)
                            .addComponent(editPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editPanelNameLabel)
                            .addComponent(editPanelNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editPanelUNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editPanelUNLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPanelPWField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPanelPWLabel)
                    .addComponent(editPanelPWToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editPanelCancelButton)
                    .addComponent(editPanelOKButton))
                .addContainerGap())
        );

        mainPanel.add(editPanel, "editPanel");

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
        fileMenu.add(jSeparator2);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

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
        getPanelLayout().show(mainPanel, "createPanel");
    }//GEN-LAST:event_newEntryMenuItemActionPerformed

    private void createPanelOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPanelOKButtonActionPerformed
        if (currentFolder.getEntry(createPanelNameField.getText()) == null) {
            if (createPanelNameField.getText().length() < 1) {
                JOptionPane.showMessageDialog(this, "Error: entry must have a name.",
                        "New entry", JOptionPane.ERROR_MESSAGE);
            } else {
                currentFolder.addEntry(new Entry(createPanelNameField.getText(),
                        new Username(createPanelUNField.getText()),
                        new Password(createPanelPWField.getPassword())));
                getPanelLayout().show(mainPanel, "listPanel");
                refreshEntryTable();
                resetFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: an entry with the same name already exists.",
                    "New entry", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_createPanelOKButtonActionPerformed

    private void entryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMousePressed
        if (evt.isPopupTrigger()) {
            entryTablePopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_entryTableMousePressed

    private void entryTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMouseReleased
        entryTableMousePressed(evt);
    }//GEN-LAST:event_entryTableMouseReleased

    private void createPanelCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPanelCancelButtonActionPerformed
        resetFields();
        getPanelLayout().show(mainPanel, "listPanel");
    }//GEN-LAST:event_createPanelCancelButtonActionPerformed

    private void newFolderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFolderMenuItemActionPerformed
        String res = JOptionPane.showInputDialog(this, "Folder name:", "New folder", JOptionPane.QUESTION_MESSAGE);
        if (res != null) {
            currentFolder.addFolder(new Folder(res, currentFolder));
            refreshFolderTree();
        }
    }//GEN-LAST:event_newFolderMenuItemActionPerformed

    private void deleteEntryPopupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryPopupMenuItemActionPerformed
        if (currentFolder.deleteEntry((String) entryTable.getValueAt(entryTable.getSelectedRow(), 0))) {
            refreshEntryTable();
        }
    }//GEN-LAST:event_deleteEntryPopupMenuItemActionPerformed

    private void entryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMouseClicked
        if (evt.getClickCount() == 2) {
            Entry tmpEntry = currentFolder.getEntry((String) entryTable.getValueAt(entryTable.getSelectedRow(), 0));
            if (tmpEntry != null) {
                currentEntry = tmpEntry;
                editPanelNameField.setText(currentEntry.getName());
                editPanelUNField.setText(currentEntry.getUsername());
                editPanelPWField.setText(new String(currentEntry.getPassword()));
                getPanelLayout().show(mainPanel, "editPanel");
            }
        }
    }//GEN-LAST:event_entryTableMouseClicked

    private void editPanelOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPanelOKButtonActionPerformed
        currentEntry.setUsername(editPanelUNField.getText());
        currentEntry.setPassword(editPanelPWField.getPassword());
        isPWShown = false;
        getPanelLayout().show(mainPanel, "listPanel");
        refreshEntryTable();
        resetFields();
    }//GEN-LAST:event_editPanelOKButtonActionPerformed

    private void editPanelCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPanelCancelButtonActionPerformed
        getPanelLayout().show(mainPanel, "listPanel");
        resetFields();
    }//GEN-LAST:event_editPanelCancelButtonActionPerformed

    private void editPanelPWToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPanelPWToggleButtonActionPerformed
        if (isPWShown) {
            editPanelPWField.setEchoChar('*');
            isPWShown = false;
        } else {
            editPanelPWField.setEchoChar((char) 0);
            isPWShown = true;
        }
    }//GEN-LAST:event_editPanelPWToggleButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Exit Pesto ?", "Exit", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitMenuItemActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaultFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(() -> {
            new DefaultFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel createPanel;
    private javax.swing.JButton createPanelCancelButton;
    private static javax.swing.JTextField createPanelNameField;
    private javax.swing.JLabel createPanelNameLabel;
    private static javax.swing.JButton createPanelOKButton;
    private static javax.swing.JPasswordField createPanelPWField;
    private javax.swing.JLabel createPanelPWLabel;
    private static javax.swing.JTextField createPanelUNField;
    private javax.swing.JLabel createPanelUNLabel;
    private javax.swing.JMenuItem deleteEntryPopupMenuItem;
    private javax.swing.JLabel editEntryLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JPanel editPanel;
    private javax.swing.JButton editPanelCancelButton;
    private static javax.swing.JTextField editPanelNameField;
    private javax.swing.JLabel editPanelNameLabel;
    private javax.swing.JButton editPanelOKButton;
    private static javax.swing.JPasswordField editPanelPWField;
    private javax.swing.JLabel editPanelPWLabel;
    private javax.swing.JToggleButton editPanelPWToggleButton;
    private javax.swing.JSeparator editPanelSeparator;
    private static javax.swing.JTextField editPanelUNField;
    private javax.swing.JLabel editPanelUNLabel;
    private static javax.swing.JTable entryTable;
    private javax.swing.JPopupMenu entryTablePopupMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private static javax.swing.JTree folderTree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private static javax.swing.JPanel listPanel;
    private static javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel newEntryLabel;
    private javax.swing.JMenuItem newEntryMenuItem;
    private javax.swing.JMenuItem newFolderMenuItem;
    private javax.swing.JMenu viewMenu;
    // End of variables declaration//GEN-END:variables
}
