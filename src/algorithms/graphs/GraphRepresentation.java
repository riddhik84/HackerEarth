package algorithms.graphs;

import java.util.Scanner;

public class GraphRepresentation {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] edges = new int[M][2];
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = 0;
                //System.out.println(graph[i][j]);
            }
        }
        for (int i = 0; i < M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            //System.out.println(node1 + " " + node2);
            graph[node1-1][node2-1] = 1;
        }

        int tests = sc.nextInt();
        for (int i =0; i < tests; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            if(graph[node1-1][node2-1] == 1){
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }

    }
}
