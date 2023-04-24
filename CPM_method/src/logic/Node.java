package logic;

import logic.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    final private int id;
    private List<Edge> outgoingEdges;
    private List<Edge> incomingEdges;
    private int earliestStartTime;
    private int latestStartTime;
    private int earliestFinishTime;
    private int latestFinishTime;
    private int timeReserve;

    public static final int NODE_SIZE = 50;
    private int x = 640;
    private int y = 360;
    private String name;

    public Node(int id) {
        this.id = id;
        this.name = getName();
        outgoingEdges = new ArrayList<>();
        incomingEdges = new ArrayList<>();
        earliestStartTime = Integer.MIN_VALUE;
        latestStartTime = Integer.MAX_VALUE;
        earliestFinishTime = Integer.MIN_VALUE;
        latestFinishTime = Integer.MAX_VALUE;
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
    public void addIncomingEdge(Edge incomingEdge) {
        incomingEdges.add(incomingEdge);
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
    public int getEarliestFinishTime() {
        return earliestFinishTime;
    }

    public void setEarliestFinishTime(int earliestFinishTime) {
        this.earliestFinishTime = earliestFinishTime;
    }

    public int getLatestFinishTime() {
        return latestFinishTime;
    }

    public void setLatestFinishTime(int latestFinishTime) {
        this.latestFinishTime = latestFinishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return id == node.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, earliestStartTime, latestStartTime, x, y, outgoingEdges);
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

    public int getTimeReserve() {
        return timeReserve;
    }

    public void setTimeReserve(int timeReserve) {
        this.timeReserve = timeReserve;
    }
    public boolean isCritical() {
        return getEarliestStartTime() == getLatestStartTime();
    }
    public static Node getNodeById(int id, List<Node> nodes) {
        for (Node node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }


}