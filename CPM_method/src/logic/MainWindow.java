package logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {

    private JTextField fromNodeField, toNodeField, weightField;
    private JButton addButton, clearButton;
    private GraphPanel graphPanel;

    public MainWindow() {

        setTitle("Critical Path Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1, 600);

        // Create form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // Create form fields
        fromNodeField = new JTextField(5);
        toNodeField = new JTextField(5);
        weightField = new JTextField(5);

        // Create form labels
        JLabel fromNodeLabel = new JLabel("From node:");
        JLabel toNodeLabel = new JLabel("To node:");
        JLabel weightLabel = new JLabel("Weight:");

        // Create buttons
        addButton = new JButton("Add edge");
        clearButton = new JButton("Clear");

        // Add form elements to form panel
        JPanel fromNodePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fromNodePanel.add(fromNodeLabel);
        fromNodePanel.add(fromNodeField);
        formPanel.add(fromNodePanel);

        JPanel toNodePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toNodePanel.add(toNodeLabel);
        toNodePanel.add(toNodeField);
        formPanel.add(toNodePanel);

        JPanel weightPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        formPanel.add(weightPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        formPanel.add(buttonPanel);

        // Add form panel to frame
        add(formPanel, BorderLayout.CENTER);

        // Create graph panel
        graphPanel = new GraphPanel();
        graphPanel.setPreferredSize(new Dimension(800, 600));
        // Add graph panel to frame
        add(graphPanel, BorderLayout.CENTER);

        // Add button listeners
        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Get values from form fields
            String fromNodeString = fromNodeField.getText();
            String toNodeString = toNodeField.getText();
            String weightString = weightField.getText();

            // Clear form fields
            fromNodeField.setText("");
            toNodeField.setText("");
            weightField.setText("");

            try {
                // Parse input values


                int fromNodeId = Integer.parseInt(fromNodeString);
                int toNodeId = Integer.parseInt(toNodeString);
                int weight = Integer.parseInt(weightString);

                // Add edge to graph

                graphPanel.addEdge2(fromNodeId, toNodeId, weight);

                // Repaint graph panel
                //.repaint(); //!!!
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            } //catch (DuplicateEdgeException ex) {
               // JOptionPane.showMessageDialog(this, "Edge already exists", "Error", JOptionPane.ERROR_MESSAGE);
           // }
        } else if (e.getSource() == clearButton) {
            // Clear graph
            graphPanel.clear();

            // Repaint graph panel
            graphPanel.repaint();
        }
    }

    public static void main(String[] args) {

        new MainWindow();
    }
}
