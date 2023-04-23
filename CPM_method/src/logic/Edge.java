package logic;

import java.util.Objects;

public class Edge {

    private int weight;
    public Node fromNode;
    public Node toNode;

    public Edge(Node fromNode, Node toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight && Objects.equals(fromNode, edge.fromNode) && Objects.equals(toNode, edge.toNode);
    }
}
   // @Override
   // public int hashCode() {
      //  return Objects.hash(weight, fromNode, toNode);
  //  }
//}
