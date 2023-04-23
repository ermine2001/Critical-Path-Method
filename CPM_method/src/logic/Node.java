package logic;

import logic.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    final private int id;
    private List<Edge> outgoingEdges;
    private int earliestStartTime;
    private int latestStartTime;
    private int earliestEndTime;
    private int latestEndTime;
    private int timeReserve;

    public static final int NODE_SIZE = 50;
    private int x;
    private int y;

    public Node(int id) {
        this.id = id;
        outgoingEdges = new ArrayList<>();
        earliestStartTime = Integer.MIN_VALUE;
        latestStartTime = Integer.MAX_VALUE;
        earliestEndTime = Integer.MIN_VALUE;
        latestEndTime = Integer.MAX_VALUE;
        timeReserve = Integer.MAX_VALUE;
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

    public void changePosition(int xPos, int yPos)
    {
        this.x = xPos;
        this.y = yPos;
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



    public void showNodeInfo()
    {
        System.out.println("Node with id number: " + this.id + "\nEarliest start time:" + this.earliestStartTime +
                "\nLatest start time:" + this.latestStartTime + "\nAll outgoing Edges From that Node:");
        listAllOutgoingEdges(outgoingEdges);
    }

    public void listAllOutgoingEdges(List<Edge> edges) {
        for (var edge : edges) {
            System.out.println(edge.toNode + " -> " + edge.toNode);
        }
    }

    public boolean isCritical() {
        return getEarliestStartTime() == getLatestStartTime();
    }

    public int getTimeReserve() {
        return timeReserve;
    }

    public void setTimeReserve(int timeReserve) {
        this.timeReserve = timeReserve;
    }

    public int getEarliestEndTime() {
        return earliestEndTime;
    }

    public void setEarliestEndTime(int earliestEndTime) {
        this.earliestEndTime = earliestEndTime;
    }

    public void setLatestEndTime(int latestEndTime) {
        this.latestEndTime = latestEndTime;
    }

    public int getLatestEndTime() {
        return latestEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return id == node.id;
    }
}