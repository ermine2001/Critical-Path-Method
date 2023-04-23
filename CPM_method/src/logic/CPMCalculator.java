package logic;

import java.util.*;

public class CPMCalculator {
    private List<Node> nodes;
    private Map<Node, Integer> nodeToIndexMap;

    public CPMCalculator(List<Node> nodes) {
        this.nodes = nodes;
        nodeToIndexMap = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            nodeToIndexMap.put(nodes.get(i), i);
        }
    }

    public void calculateEarliestStartTimes() {
        nodes.get(0).setEarliestStartTime(0);
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            for (Edge edge : node.getOutgoingEdges()) {
                Node toNode = edge.getToNode();
                int earliestStartTime = node.getEarliestStartTime() +

                edge.getWeight();
                if (toNode.getEarliestStartTime() < earliestStartTime) {
                    toNode.setEarliestStartTime(earliestStartTime);
                }
            }
        }
    }


    public void calculateLatestStartTimes() {
        nodes.get(nodes.size() - 1).setLatestStartTime(nodes.get(nodes.size() - 1).getEarliestStartTime());
        for (int i = nodes.size() - 2; i >= 0; i--) {
            Node node = nodes.get(i);
            for (Edge edge : node.getOutgoingEdges()) {
                Node toNode = edge.getToNode();
                int latestStartTime = toNode.getLatestStartTime() - edge.getWeight();
                if (node.getLatestStartTime() > latestStartTime) {
                    node.setLatestStartTime(latestStartTime);
                }
            }
        }
    }

    public void calculateTimeReserved()
    {
        for (Node node : nodes) {
            node.setTimeReserve(node.getLatestStartTime() - node.getEarliestStartTime());
        }
    }

    public List<Node> getCriticalPath() {
        List<Node> criticalPath = new ArrayList<>();
        for (Node node : nodes) {
            if (node.getEarliestStartTime() == node.getLatestStartTime()) {
                criticalPath.add(node);
            }
        }
        return criticalPath;
    }
}