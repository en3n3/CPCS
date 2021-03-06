
package floyd;

public class FloydWarshall {

    final static int INF = 99999;
    static int[][] graph;
    int[][] dist = new int[10][10]; //10 is for matrix size

    public void findShortestPaths(int[][] graph) {
        int i, j, k;

        //initialize distance matrix
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                dist[i][j] = graph[i][j];
            }
        }

//finding shortest paths
        for (k = 0; k < 10; k++) {
// Pick all vertices as source one by one
            for (i = 0; i < 10; i++) {
// Pick all vertices as destination for the above picked source
                for (j = 0; j < 10; j++) {
// If vertex k is on the shortest path from i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }

//print intermediate result
            System.out.println("Shortest distances D(" + (k+1)+ ")");
            this.printDistances();
            System.out.println();
        }
    }

    public void printDistances() {
        System.out.print("\t");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < 10; ++i) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < 10; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(dist[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //initialize graph with adjacency matrix
        graph = new int[][]{{0, 10, INF, INF, INF, 5, INF, INF, INF, INF},
        {INF, 0, 3, INF, 3, INF, INF, INF, INF, INF},
        {INF, INF, 0, 4, INF, INF, INF, 5, INF, INF},
        {INF, INF, INF, 0, INF, INF, INF, INF, 4, INF},
        {INF, INF, 4, INF, 0, INF, 2, INF, INF, INF},
        {INF, 3, INF, INF, INF, 0, INF, INF, INF, 2},
        {INF, INF, INF, 7, INF, INF, 0, INF, INF, INF},
        {INF, INF, INF, 4, INF, INF, INF, 0, 3, INF},
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, INF},
        {INF, 6, INF, INF, INF, INF, 8, INF, INF, 0}
        };
        
        //print the graph as matrix
        System.out.println("The matrix is :");
        System.out.print("\t");
        for (int i = 0; i < 10; i++) {
            System.out.print((char) ('A' + i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < 10; ++i) {
            System.out.print((char) ('A' + i) + "\t");
            for (int j = 0; j < 10; ++j) {
               if (graph[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(graph[i][j] + "\t");
                }
            }
            System.out.println("");
        }
         System.out.println("");
        FloydWarshall fw = new FloydWarshall();

// Print the solution
        fw.findShortestPaths(graph);

//print final result
        System.out.println("\n\nFinal shortest distances matrix:");
        fw.printDistances();
    }
}
