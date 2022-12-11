/**
 *  File Name  :  BreadthFirstSearcher.java
 *  Purpose    :  Provide a class for a breadth first search of a graph
 *  Author     :  B.J. Johnson
 *  Date       :  2020-12-03
 *  Description:  This class performs a recursive breadth-first search on a
 *    graph that is constructed with a user-entered number of nodes.  The
 *    graph is expected to be of the associated "graph" class.
 *
 *    Operation is iterative using nested loops and a queue, which tracks the
 *    adjacent vertices in the adjacency matrix from the Graph class.  The
 *    outer loop hits every element in the queue.  The inner loop looks at
 *    every letter vertex to see if it is connected to whatever the current
 *    vertex is, and if it is, it is appended to the queue at the next open
 *    element.  When the entire adjacency matrix has been scanned, the next
 *    element in the queue becomes the currentVertex, the index in the queue
 *    is moved to the next element, and the current vertex is marked in the
 *    graph as "visited".  The process then repeats with the next element in
 *    the queue.  When all queue elements have been visited, the bfs exits
 *    back to the main() and the output sequence is displayed.
 *    Vertices are implemented as an adjacency matrix, in a pretty standard
 *    method. There is a boolean array to keep track of which nodes have been
 *    visited.  A number of methods for performing the operation are also
 *    available.  All of these items are part of the Graph.java class which
 *    is associated.  This class actually creates and connects the graph to
 *    be searched.
 *
 */

public class BreadthFirstSearcher   {

   private static final boolean DEBUG_ON = false;
   private static final int TEST_GRAPH_SIZE = 9;
   private static char [] output = new char[TEST_GRAPH_SIZE];
   private static int index = 0;
   private static int tracker = 1;

  /*
   * breadth first searcher
   */
   public static void bfs( Graph theGraph, char currentVertex ) {

     // Create a queue for BFS
      int[] queue = new int[TEST_GRAPH_SIZE];

     // Mark the current node as visited and enqueue it
      queue[index] = currentVertex;

      for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
         currentVertex = (char)queue[i];
         if( DEBUG_ON) System.out.println( "  currentVertex: " + currentVertex );

         for( char nextVertex = 'A'; nextVertex <= ('A' + TEST_GRAPH_SIZE - 1); nextVertex++ ) {

            if( DEBUG_ON ) System.out.print( "  Checking " + nextVertex + " >> " );
            if( theGraph.areTwoVertexsConnected( currentVertex, nextVertex ) ) {
               if( !theGraph.wasVisited( nextVertex ) ) {
                  if( DEBUG_ON ) System.out.println( "  Vertexs " + currentVertex + " and " + nextVertex + " ARE connected." );
                  queue[++index] = nextVertex;
               }
            } else {
               if( DEBUG_ON ) System.out.println( "  Vertexs " + currentVertex + " and " + nextVertex + " are NOT connected." );
            }
         }
         if( DEBUG_ON) System.out.println( "     ....completed inner loop......\n" );
         theGraph.markVisited( currentVertex );
      }
     // this loop is just to copy the queue to the output for printing in the main
      for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
         output[i] = (char)queue[i];
      }
   }

  /*
   *  MAIN
   *   The main method declares a graph of 9 Vertexs, initializes them and their
   *   connections, then performs a BFS on the graph just listing out the Vertexs
   *   as they are visited.  It also shows the checks
   */
   public static void main( String [] args )
   {
     // Create a new graph wih 8 Vertexs, which will be named 'A' through 'I'
      Graph theGraph = new Graph( TEST_GRAPH_SIZE );

     // Create links between the Vertexs.
      theGraph.linkTwoVertexs( 'A', 'B' );
      theGraph.linkTwoVertexs( 'A', 'C' );
      theGraph.linkTwoVertexs( 'A', 'D' );
      theGraph.linkTwoVertexs( 'A', 'E' );
      theGraph.linkTwoVertexs( 'B', 'F' );
      theGraph.linkTwoVertexs( 'F', 'H' );
      theGraph.linkTwoVertexs( 'D', 'G' );
      theGraph.linkTwoVertexs( 'G', 'I' );

     // Do a depth first search on theGraph starting from 'E'
      System.out.println( "\n\n   Performing BFS traversal on graph beginning at vertex 'A': " );
      bfs( theGraph, 'A' );
      System.out.println( "                 Expecting: A B C D E F G H I" );
      System.out.print( "   Output list of vertices: " );
      for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
        System.out.print( output[i] + " " );
      }
      System.out.println( );

      System.out.println( "\n\n   Starting over again, same graph, from 'G'... " );
      theGraph = new Graph( TEST_GRAPH_SIZE );

     // Create links between the Vertexs.
      theGraph.linkTwoVertexs( 'A', 'B' );
      theGraph.linkTwoVertexs( 'A', 'C' );
      theGraph.linkTwoVertexs( 'A', 'D' );
      theGraph.linkTwoVertexs( 'A', 'E' );
      theGraph.linkTwoVertexs( 'B', 'F' );
      theGraph.linkTwoVertexs( 'F', 'H' );
      theGraph.linkTwoVertexs( 'D', 'G' );
      theGraph.linkTwoVertexs( 'G', 'I' );
      index = 0;
      System.out.println( "\n\n   Performing BFS traversal on graph beginning at vertex 'A': " );
      bfs( theGraph, 'G' );
      System.out.println( "                 Expecting: G D I A B C E F H" );
      System.out.print( "   Output list of vertices: " );
      for( int i = 0; i < TEST_GRAPH_SIZE; i++ ) {
        System.out.print( output[i] + " " );
      }
      System.out.println( );

   }
}
