package logic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.lang.String;
public  class AddEdgeWindow extends JFrame {
    private final JLabel fromLabel = new JLabel("From:");
    private final JLabel toLabel = new JLabel("To:");
    private final JLabel weightLabel = new JLabel("Weight:");
    private final JTextField fromField = new JTextField(5);
    private final JTextField toField = new JTextField(5);
    private final JTextField weightField = new JTextField(5);
    private final JButton addButton = new JButton("Add");
    private List<Edge> edges = new ArrayList<Edge>(); // dodane
    private List<Node> nodes = new ArrayList<Node>(); //dodane


    public AddEdgeWindow() {
        super("Add Edge");
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 500)); // ustawienie preferowanej wielkości okna
        add(fromLabel);
        add(fromField);
        add(toLabel);
        add(toField);
        add(weightLabel);
        add(weightField);
        add(addButton);

        addButton.addActionListener(e -> {
            String from = fromField.getText();
            String to = toField.getText();
            String weightStr = weightField.getText();
           int from2 = Integer.parseInt(from);
           int to2 = Integer.parseInt(to);

            if (!from.isEmpty() && !to.isEmpty() && !weightStr.isEmpty()) {
                try {
                    int weight = Integer.parseInt(weightStr);
                    Node fromNode = getNodeById(from2);
                    Node toNode = getNodeById(to2);

                    if (fromNode != null && toNode != null) {
                        if (!isEdgeAlreadyExists(fromNode, toNode)) {
                            edges.add(new Edge(fromNode, toNode, weight));
                            repaint();
                        } else {
                            JOptionPane.showMessageDialog(this, "Edge already exists!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid node ids!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid weight!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty!");
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Node getNodeById(int id) {
        for (Node node : nodes) {
            if ((node.getId())==(id)) {
                return node;
            }
        }
        return null;
    }


    private boolean isEdgeAlreadyExists(Node from, Node to) {
        for (Edge edge : edges) {
            if ((edge.getFromNode().equals(from) && edge.getToNode().equals(to))
                    || (edge.getFromNode().equals(to) && edge.getToNode().equals(from))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        new GraphVisualization();
    }
}






