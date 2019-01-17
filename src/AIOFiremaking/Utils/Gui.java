package AIOFiremaking.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import AIOFiremaking.Data.Data;

public class Gui extends JFrame {

    public Gui() {
        initComponents();
    }

    private void startButtonActionPerformed(ActionEvent e) {
        String chosen = locationSelector.getSelectedItem().toString();
        if (chosen.equals("Donator Zone")) {
            Data.selectedArea = "Donator Zone";
        } else {
            Data.selectedArea = "Edgeville";
        }

        String chosen1 = logSelector.getSelectedItem().toString();
        if (chosen1.equals("Oak logs")) {
                Data.logs_ID = 1521;
            } else if (chosen1.equals("Willow logs")){
                Data.logs_ID = 1519;
            } else if (chosen1.equals("Maple logs")){
                Data.logs_ID = 1517;
            } else if (chosen1.equals("Yew logs")){
                Data.logs_ID = 1515;
            } else if (chosen1.equals("Magic logs")) {
                Data.logs_ID = 1513;
            } else {
                Data.logs_ID = 1511;
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Christopher Edwards
        label1 = new JLabel();
        locationSelector = new JComboBox<>();
        logSelector = new JComboBox<>();
        startButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("AIO Firemaking");
        label1.setFont(new Font("Ink Free", Font.BOLD, 28));

        //---- locationSelector ----
        locationSelector.setModel(new DefaultComboBoxModel<>(new String[]{
                "Select a Location..",
                "Donator Zone",
                "Edgeville"
        }));
        locationSelector.setFont(new Font("Ink Free", Font.BOLD, 16));

        //---- logSelector ----
        logSelector.setModel(new DefaultComboBoxModel<>(new String[]{
                "Select a Log..",
                "Logs",
                "Oak logs",
                "Willow logs",
                "Maple logs",
                "Yew logs",
                "Magic logs"
        }));
        logSelector.setFont(new Font("Ink Free", Font.BOLD, 16));
        logSelector.addActionListener(e -> Data.selectedLog = Objects.requireNonNull(logSelector.getSelectedItem()).toString());
        locationSelector.addActionListener(e -> Data.selectedArea = Objects.requireNonNull(locationSelector.getSelectedItem()).toString());
        //---- startButton ----
        startButton.setText("Start");
        startButton.setFont(new Font("Ink Free", Font.BOLD, 22));
        startButton.addActionListener(this::startButtonActionPerformed);


        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(logSelector, GroupLayout.Alignment.LEADING)
                                                .addComponent(locationSelector, GroupLayout.Alignment.LEADING)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton)
                                .addGap(49, 49, 49))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(locationSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(startButton)
                                .addGap(24, 24, 24))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Christopher Edwards
    private JLabel label1;
    private JComboBox<String> locationSelector;
    private JComboBox<String> logSelector;
    private JButton startButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
