package logic;

import logic.CPMCalculator;
import logic.Edge;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);

        Edge ab = new Edge(a, b, 3);
        Edge ac = new Edge(a, c, 2);
        Edge bd = new Edge(b, d, 5);
        Edge ce = new Edge(c, e, 4);
        Edge de = new Edge(d, e, 1);
        Edge df = new Edge(d, f, 2);
        Edge ef = new Edge(e, f, 4);

        a.addOutgoingEdge(ab);
        a.addOutgoingEdge(ac);
        b.addOutgoingEdge(bd);
        c.addOutgoingEdge(ce);
        d.addOutgoingEdge(de);
        d.addOutgoingEdge(df);
        e.addOutgoingEdge(ef);

        List<Node> nodes = Arrays.asList(a, b, c, d, e, f);

        CPMCalculator cpmCalculator = new CPMCalculator(nodes);
        // najwczesniejsze i najpozniejsze czasy ROZPOCZECIA
        cpmCalculator.calculateEarliestStartTimes();
        cpmCalculator.calculateLatestStartTimes();
        // najwczesniejsze i najpozniejsze czasy ZAKONCZENIA
        cpmCalculator.calculateEarliestFinishTimes();
        cpmCalculator.calculateLatestFinishTimes();
        // obliczenie rezerwy czasowej
        cpmCalculator.calculateTimeReserved();
        //sciezka krytyczna
        List<Node> criticalPath = cpmCalculator.getCriticalPath();

        System.out.println("Critical path:");
        for (Node node : criticalPath) {
            System.out.println(node.getId());
        }
        for (Node node : nodes) {
            System.out.println("ID:  #" + (node.getId() + 1) + ":");
            System.out.println("Najwcześniejszy czas rozpoczęcia: " + node.getEarliestStartTime());
            System.out.println("Najpóźniejszy czas rozpoczęcia: " + node.getLatestStartTime());

            System.out.println("Najwcześniejszy czas zakonczenia: " + node.getEarliestFinishTime());
            System.out.println("Najpóźniejszy czas zakonczenia: " + node.getLatestFinishTime());
            System.out.println("Rezerwa czasowa: " + node.getTimeReserve());
            System.out.println("Należy do ścieżki krytycznej: " + node.isCritical());

            System.out.println();
        }

        System.out.println(String.format("%-5s%-25s%-30s%-30s%-30s%-25s%-30s",
                "ID", "Earliest_Start", "Latest_Start",
                "Earliest_Finish", "Latest_Finish",
                "Reserve", "Critical_Path"));

        for (Node node : nodes) {
            System.out.println(String.format("%-5s%-25s%-30s%-30s%-30s%-25s%-30s",
                    node.getId() + 1, node.getEarliestStartTime(), node.getLatestStartTime(),
                    node.getEarliestFinishTime(), node.getLatestFinishTime(),
                    node.getTimeReserve(), node.isCritical()));
        }
    }
}

