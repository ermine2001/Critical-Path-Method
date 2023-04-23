package logic;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GraphPanel extends JPanel {

    public List<Node> nodes;
    public List<Edge> edges;

    public GraphPanel() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
        repaint();
    }

    public void addEdge(Edge edge) {

        edges.add(edge);
        repaint();
    }
    public void addEdge2(Integer from, Integer to, Integer w) {
        Node nodefrom = new Node(from);
        Node nodeto = new Node(to);
Edge edge = new Edge(nodefrom, nodeto,  w);
        edges.add(edge);
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



            // Draw nodes
            for (Node node : nodes) {
                g.setColor(Color.WHITE);
                g.fillOval(node.getX() - Node.NODE_SIZE / 2, node.getY() - Node.NODE_SIZE / 2, Node.NODE_SIZE, Node.NODE_SIZE);
                g.setColor(Color.BLACK);
                g.drawOval(node.getX() - Node.NODE_SIZE / 2, node.getY() - Node.NODE_SIZE / 2, Node.NODE_SIZE, Node.NODE_SIZE);
                g.drawString(String.valueOf(node.getId()), node.getX() - 5, node.getY() + 5);
            }


        // Draw edges
        for (Edge edge : edges) {
            g.setColor(Color.BLACK);
            g.drawLine(edge.getFromNode().getX(), edge.getFromNode().getY(),
                    edge.getToNode().getX(), edge.getToNode().getY());
        }
    }

    public void clear() {
        nodes.clear();
        edges.clear();
        repaint();
    }
}
