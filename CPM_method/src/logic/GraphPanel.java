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

           /* // Draw nodes
            for (Node node : nodes) {
                g.setColor(Color.WHITE);
                g.fillOval(node.getX() - Node.NODE_SIZE / 2, node.getY() - Node.NODE_SIZE / 2, Node.NODE_SIZE, Node.NODE_SIZE);
                g.setColor(Color.BLACK);
                g.drawOval(node.getX() - Node.NODE_SIZE / 2, node.getY() - Node.NODE_SIZE / 2, Node.NODE_SIZE, Node.NODE_SIZE);
                g.drawString(String.valueOf(node.getId()), node.getX() - 5, node.getY() + 5);
            }
*/
        for (Node node : nodes) {
            g.setColor(Color.WHITE);
            int x = node.getX() - Node.NODE_SIZE / 2 + getInsets().left; // dodaj getInsets().left
            int y = node.getY() - Node.NODE_SIZE / 2 + getInsets().top; // dodaj getInsets().top
            g.fillOval(x, y, Node.NODE_SIZE, Node.NODE_SIZE);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, Node.NODE_SIZE, Node.NODE_SIZE);
            g.drawString(String.valueOf(node.getId()), x - 5, y + 5);
        }
        // Draw edges
       /* for (Edge edge : edges) {
            g.setColor(Color.BLACK);
            g.drawLine(edge.getFromNode().getX(), edge.getFromNode().getY(),
                    edge.getToNode().getX(), edge.getToNode().getY());
        }*/
        for (Edge edge : edges) {
            g.setColor(Color.BLACK);
            int x1 = edge.getFromNode().getX() + getInsets().left; // dodaj getInsets().left
            int y1 = edge.getFromNode().getY() + getInsets().top; // dodaj getInsets().top
            int x2 = edge.getToNode().getX() + getInsets().left; // dodaj getInsets().left
            int y2 = edge.getToNode().getY() + getInsets().top; // dodaj getInsets().top
            g.drawLine(x1, y1, x2, y2);
            g.drawString(String.valueOf(edge.getWeight()), (x1 + x2) / 2, (y1 + y2) / 2);
        }
    }

    public void clear() {
        nodes.clear();
        edges.clear();
        repaint();
    }
}
