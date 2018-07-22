package algorithms.graphs;

import java.util.*;

public class DepthFirstSearch {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList nodeArrList = new ArrayList();
        for (int i = 0; i < nodes; i++) {
            nodeArrList.add(new Node(i, null));
        }
        for (int i = 0; i < edges; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            Node N1 = (Node) nodeArrList.get(node1 - 1);
            Node N2 = (Node) nodeArrList.get(node2 - 1);
            N1.addNeighbors(N2);
            N2.addNeighbors(N1);
        }
        for (int i = 0; i < nodeArrList.size(); i++) {
            //System.out.println(((Node) nodeArrList.get(i)).getNeighbors().size());
        }

        //HeadNodes
        int searchNode = sc.nextInt();

        Stack nodestack = new Stack();
        Node start = (Node) nodeArrList.get(searchNode - 1);
        nodestack.add(start);
        //start.setVisited(true);

        while (!nodestack.isEmpty()) {
            Node N = (Node) nodestack.pop();
            //System.out.println("Node: " + N.getNodeCount());

            if (N.isVisited() == false) {
                if (N.getNeighbors().size() != 0) {

                    for (int i = 0; i < N.getNeighbors().size(); i++) {
                        N.setVisited(true);
                        nodestack.add((Node) N.getNeighbors().get(i));
                    }
                }
            }
        }

        int unreachable = 0;
        for (int i = 0; i < nodeArrList.size(); i++) {
            Node N = (Node) nodeArrList.get(i);
            if (N.isVisited() == false) {
                unreachable++;
            }
        }
        System.out.println(unreachable);
    }

}

class Node {

    int node_num;
    Node neighborNode;
    ArrayList neighbors = new ArrayList<Node>();
    boolean visited = false;

    Node(int node_num, Node neighborNode) {
        this.node_num = node_num;
        this.neighborNode = neighborNode;
    }

    public int getNodeCount() {
        return node_num;
    }

    public void addNeighbors(Node node) {
        neighbors.add(node);
    }

    public ArrayList getNeighbors() {
        return neighbors;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

}
