package net.au70.algorithmbench.gui;


import net.au70.algorithmbench.AlgorithmBench;
import net.au70.algorithmbench.algorithms.Algorithm;

import java.util.ArrayList;

public class Frame extends javax.swing.JFrame {

    public javax.swing.JComboBox<String> algorithmComboBox;
    public javax.swing.JLabel arrayLabel;
    public javax.swing.JPanel bottomPanel;
    public javax.swing.JLabel comparisonsLabel;
    public javax.swing.JLabel progressLabel;
    public javax.swing.JButton startResetButton;
    public javax.swing.JLabel timeLabel;
    public FrameCanvas canvas;

    private Algorithm alg;

    public Frame() {
        initComponents();
    }


    private void initComponents() {

        bottomPanel = new javax.swing.JPanel();
        startResetButton = new javax.swing.JButton();
        algorithmComboBox = new javax.swing.JComboBox<>();
        progressLabel = new javax.swing.JLabel();
        comparisonsLabel = new javax.swing.JLabel();
        arrayLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        canvas = new FrameCanvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algorithm Benchmark");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        startResetButton.setText("Start");

        /*
        startResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startResetButtonActionPerformed(evt);
            }
        });
         */
        startResetButton.addActionListener(evt -> startResetButtonActionPerformed(evt));

        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        progressLabel.setText("Progress: ");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(progressLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
                bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bottomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(progressLabel))
                                .addContainerGap())
        );

        comparisonsLabel.setText("Comparisons:");

        arrayLabel.setText("Array Accesses: ");

        timeLabel.setText("Time Elapsed:");

        startResetButton.updateUI();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(comparisonsLabel)
                                                .addGap(71, 71, 71)
                                                .addComponent(arrayLabel)
                                                .addGap(70, 70, 70)
                                                .addComponent(timeLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(arrayLabel)
                                        .addComponent(timeLabel)
                                        .addComponent(comparisonsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void startResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        switch(startResetButton.getText()) {
            case "Start":
                for(Algorithm a : AlgorithmBench.algorithms) {
                    if(a.toString().equals(algorithmComboBox.getSelectedItem())){
                        System.out.println("Starting the algorithm thread");
                        alg = a;
                        alg.unhalt();
                        alg.start();
                    }
                }
                startResetButton.setText("Reset");
                startResetButton.updateUI();
                break;
            // Todo: remove alg object form AlgorithmBench.algorithms in order to fully terminate the thread.
            // This will fix the bug of not being able to reset the process or choose a different algorithm to use.
            case "Reset":
                alg.halt();
                AlgorithmBench.updateList();
                startResetButton.setText("Start");
                startResetButton.updateUI();
                break;
        }
    }

    public void populateComboBox(ArrayList<Algorithm> algorithms) {
        algorithmComboBox.removeAllItems();
        for(Algorithm a : algorithms) {
            algorithmComboBox.addItem(a.toString());
        }
    }

    public void updateLabels(int arrayAccesses, int comparisons, int timeElapsed) {
        arrayLabel.setText("Array Accesses: " + arrayAccesses);
        comparisonsLabel.setText("Comparisons: " + comparisons);
        timeLabel.setText("Time elapsed: " + timeElapsed + " ms");
    }

    public void updateProgress(int progress) {
        progressLabel.setText("Progress: " + progress + " %");
    }

    public void start() {
        // Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        setVisible(true);
        // Create and display the form
        //java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }

}
