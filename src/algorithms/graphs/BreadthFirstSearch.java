package algorithms.graphs;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        ArrayList nodeArrList = new ArrayList<Node>();
        for (int i = 0; i < nodes; i++) {
            nodeArrList.add(new Node(i, null));
        }
        for (int i = 0; i < nodes - 1; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            Node N1 = (Node) nodeArrList.get(node1 - 1);
            Node N2 = (Node) nodeArrList.get(node2 - 1);
            N1.addNeighbors(N2);
            //N2.addNeighbors(N1);
        }
        for (int i = 0; i < nodeArrList.size(); i++) {
            System.out.println(((Node) nodeArrList.get(i)).getNeighbors().size());
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add((Node) nodeArrList.get(0));

        HashMap<Integer, Integer> levelsMap = new HashMap<>();
        int nodelevel = 1;
        levelsMap.put(nodeQueue.peek().getNodeCount(), nodelevel);

        while (!nodeQueue.isEmpty()) {
            Node N = nodeQueue.remove();
            System.out.println("Node: " + N.getNodeCount());

            if (N.isVisited() == false) {
                N.setVisited(true);
                if (N.getNeighbors().size() != 0) {
                    nodelevel = nodelevel + 1;

                    for (int i = 0; i < N.getNeighbors().size(); i++) {
                        nodeQueue.add((Node) N.getNeighbors().get(i));
                        if (!levelsMap.containsKey(((Node) N.getNeighbors().get(i)).getNodeCount())) {
                            levelsMap.put(((Node) N.getNeighbors().get(i)).getNodeCount(), nodelevel);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < levelsMap.size(); i++) {
            System.out.println(levelsMap.get(i));
        }

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
