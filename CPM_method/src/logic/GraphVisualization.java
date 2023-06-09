
package logic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphVisualization extends JFrame {

    private GraphPanel graphPanel;
    private JPanel controlPanel;
    private JTextField nodeInputField1;
    private JTextField nodeInputField2;
    private JTextField nodeInputField3;
    private JTextField nodeInputFieldX;
    private JTextField nodeInputFieldY;
    private JButton addEdgeButton;
    private JButton changePosButton;

    private Map<Character, Node> nodeMap;
    private ArrayList<Edge> edges; // bylo list

    public GraphVisualization() {
        super("Graph Visualization");

        nodeMap = new HashMap<>();
        edges = new ArrayList<>();

        graphPanel = new GraphPanel();
        controlPanel = new JPanel();
        nodeInputField1 = new JTextField(2);
        nodeInputField2 = new JTextField(2);
        nodeInputField3 = new JTextField(2);
        nodeInputFieldX = new JTextField(4);
        nodeInputFieldY = new JTextField(4);
        addEdgeButton = new JButton("Add Edge");
        changePosButton = new JButton("Chage node position");

        controlPanel.add(new JLabel("Node 1:"));
        controlPanel.add(nodeInputField1);
        controlPanel.add(new JLabel("Node 2:"));
        controlPanel.add(nodeInputField2);
        controlPanel.add(addEdgeButton);

        controlPanel.add(new JLabel("Node number:"));
        controlPanel.add(nodeInputField3);
        controlPanel.add(new JLabel("X:"));
        controlPanel.add(nodeInputFieldX);
        controlPanel.add(new JLabel("Y:"));
        controlPanel.add(nodeInputFieldY);
        controlPanel.add(changePosButton);

        add(graphPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addEdgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char nodeId1 = nodeInputField1.getText().toUpperCase().charAt(0);
                char nodeId2 = nodeInputField2.getText().toUpperCase().charAt(0);
                Node node1 = nodeMap.get(nodeId1);
                Node node2 = nodeMap.get(nodeId2);
                if (node1 == null) {
                    node1 = new Node(nodeId1);
                    nodeMap.put(nodeId1, node1);
                    graphPanel.addNode(node1);
                }
                if (node2 == null) {
                    node2 = new Node(nodeId2);
                    nodeMap.put(nodeId2, node2);
                    graphPanel.addNode(node2);
                }
                if (edgeExists(node1, node2)) {
                    JOptionPane.showMessageDialog(GraphVisualization.this,
                            "An edge between the two nodes already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Edge edge = new Edge(node1, node2, 5);
                    edges.add(edge);
                    graphPanel.addEdge(edge);
                }
            }
        });

        changePosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                char nodeId = nodeInputField3.getText().toUpperCase().charAt(0);

                int Xposition = nodeInputFieldX.getText().toUpperCase().charAt(0);
                int Yposition = nodeInputFieldY.getText().toUpperCase().charAt(0);

            }
        });
    }

    private boolean edgeExists(Node node1, Node node2) {
        for (Edge edge : edges) {
            if (edge.getFromNode() == node1 && edge.getToNode() == node2 ||
                    edge.getFromNode() == node2 && edge.getToNode() == node1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new GraphVisualization();
    }}