// A Java program for Dijkstra's single source shortest path
// algorithm. The program is for adjacency matrix
// representation of the graph
import java.io.*;
import java.lang.*;
import java.util.*;

class ShortestPath {
   // A utility function to find the vertex with minimum
   // distance value, from the set of vertices not yet
   // included in shortest path tree
   static final int V = 9;
   public int minDistance( int dist[], Boolean sptSet[] ) {
      // Initialize min value
      int min = Integer.MAX_VALUE, min_index = -1;

      for( int v = 0; v < V; v++ ) {
         if( sptSet[v] == false && dist[v] <= min ) {
            min = dist[v];
            min_index = v;
         }
      }
      return min_index;
   }

   public void displayGraph() {
      System.out.println( "\n\n   This program finds the shortest path from vertex (0)\n" +
                          "     to every other vertex in the graph.\n   Thanks to Edsgar Dijkstra" +
                          " for inventing this!" );
      System.out.println( "\n\n             8         7\n" +
                          "         (1)----(2)---------(3)\n" +
                          "         /|      |\\          |\\\n" +
                          "       4/ |     2| \\         | \\\n" +
                          "       /  |      |  \\      14|  \\9\n" +
                          "      /   |11    |   \\       |   \\\n" +
                          "     /    |     (8)   \\      |    \\\n" +
                          "   (0)    |     /|     \\     |    (4)\n" +
                          "     \\    |    / |      \\    |    /\n" +
                          "      \\   |  7/  |       \\   |   /\n" +
                          "      8\\  |  /   |6     4 \\  |  /10\n" +
                          "        \\ | /    |         \\ | /\n" +
                          "         \\|/     |          \\|/\n" +
                          "         (7)-----(6)--------(5)\n" +
                          "              1         2\n\n\n" );
   }

   // A utility function to print the constructed distance
   // array
   public void printSolution( int dist[] ) {
      System.out.println(
         "   Vertex \t Distance from (0)");
      for( int i = 0; i < V; i++ ) {
         System.out.println( "     " + i + " \t\t\t " + dist[i] );
      }
   }

   // Function that implements Dijkstra's single source
   // shortest path algorithm for a graph represented using
   // adjacency matrix representation
   public void dijkstra( int graph[][], int src ) {
      int dist[] = new int[V];   // The output array.
                                 // dist[i] will hold
                                 // the shortest distance from src to i
      // sptSet[i] will be true if vertex i is included in
      //    the shortest path tree or the shortest distance from src
      //    to i is finalized
      Boolean sptSet[] = new Boolean[V];

      // Initialize all distances as INFINITE and stpSet[]
      //    as false
      for( int i = 0; i < V; i++ ) {
         dist[i] = Integer.MAX_VALUE;
         sptSet[i] = false;
      }

      // Distance of source vertex from itself is always 0
      dist[src] = 0;

      // Find shortest path for all vertices
      for( int count = 0; count < V - 1; count++ ) {
         // Pick the minimum distance vertex from the set
         //    of vertices not yet processed. u is always
         //    equal to src in first iteration.
         int u = minDistance( dist, sptSet );

         // Mark the picked vertex as processed
         sptSet[u] = true;

         // Update dist value of the adjacent vertices of
         // the picked vertex.
         for( int v = 0; v < V; v++ ) {

            // Update dist[v] only if is not in sptSet,
            //    there is an edge from u to v, and total
            //    weight of path from src to v through u is
            //    smaller than current value of dist[v]
            if( (!sptSet[v]) && (graph[u][v] != 0) &&
                (dist[u] != Integer.MAX_VALUE)     &&
                (dist[u] + graph[u][v] < dist[v])  ) {
                  dist[v] = dist[u] + graph[u][v];
            }
         }
      }

      // print the constructed distance array
      printSolution( dist );
   }

   // Driver's code
   public static void main( String[] args ) {
      // create the example graph with 8 vertices as shown in the
      //    above diagram
      // this is actually an adjacency matrix with the rows and columns
      //    numbered from 0 through 8 and the values in the 'cells' set
      //    to the weights on the edges that join adjacent vertices
      //                              0   1   2   3   4   5   6   7   8
      //                             --- --- --- --- --- --- --- --- ---
      int graph[][] = new int[][] { { 0,  4,  0,  0,  0,  0,  0,  8,  0 },    // 0
                                    { 4,  0,  8,  0,  0,  0,  0, 11,  0 },    // 1
                                    { 0,  8,  0,  7,  0,  4,  0,  0,  2 },    // 2
                                    { 0,  0,  7,  0,  9, 14,  0,  0,  0 },    // 3
                                    { 0,  0,  0,  9,  0, 10,  0,  0,  0 },    // 4
                                    { 0,  0,  4, 14, 10,  0,  2,  0,  0 },    // 5
                                    { 0,  0,  0,  0,  0,  2,  0,  1,  6 },    // 6
                                    { 8, 11,  0,  0,  0,  0,  1,  0,  7 },    // 7
                                    { 0,  0,  2,  0,  0,  0,  6,  7,  0 } };  // 8
      ShortestPath t = new ShortestPath();
      t.displayGraph();
      // Function call
      t.dijkstra( graph, 0 );
   }
}
// This code is contributed by Aakash Hasija
// from https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
