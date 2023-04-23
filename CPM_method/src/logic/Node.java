package logic;

import logic.Edge;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private List<Edge> outgoingEdges;
    private int earliestStartTime;
    private int latestStartTime;
    public static final int NODE_SIZE = 50;
    private int x;
    private int y;

    public Node(int id) {
        this.id = id;
        outgoingEdges = new ArrayList<>();
        earliestStartTime = Integer.MIN_VALUE;
        latestStartTime = Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }


    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addOutgoingEdge(Edge edge) {
        outgoingEdges.add(edge);
    }

    public int getEarliestStartTime() {
        return earliestStartTime;
    }

    public void setEarliestStartTime(int earliestStartTime) {
        this.earliestStartTime = earliestStartTime;
    }

    public int getLatestStartTime() {
        return latestStartTime;
    }

    public void setLatestStartTime(int latestStartTime) {
        this.latestStartTime = latestStartTime;
    }
}