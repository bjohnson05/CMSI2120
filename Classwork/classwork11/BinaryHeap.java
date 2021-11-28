/*
 * Now the Heap itself, composed of an ArrayList of HeapNodes;
 *  using the ArrayList allows us to expand the heap as we need to,
 *  and still lets us use the HeapNode class as the data items in
 *  the Heap Array...
 */
import java.util.ArrayList;

public class BinaryHeap {

   private ArrayList<HeapNode> uriah;
   private int size;

   BinaryHeap() {
      uriah = new ArrayList<HeapNode>();
      size = 0;
   }

  // First some low-hanging fruit; let's do the traversal helpers
  //  that do the indexing operations we'll need to use to find
  //  stuff in the heap
   public HeapNode getParent( int index ) {
      return uriah.get( (index - 1) / 2 );
   }

   public HeapNode getChild( int index, char child ) {
      int result = (index * 2) + 1;
      if( Character.toUpperCase( child ) == 'R') {   // make sure we're case insensitive!
         result++;
      }
      return uriah.get( result );
   }

  // this just prints the array values; it's left to the observer to figure out
  //  which HeapNode is which, in terms of parent and child
   public void print() {
      for( int i = 0; i < size; i++ ) {
         System.out.print( "[" + uriah.get( i ).getKey() + "]" );
      }
      System.out.println();
   }

  // Now we can handle insertions.  ArrayList has a nice "add" method
  //  that makes things easy.  We *DO* have to deal with the primitive
  //  to Object situation, but that is trivial...
   public void insert( int value ) {
      uriah.add( new HeapNode( value ) );
      bubbleUp( size );                 // WOW that was easy!
      size++;
   }

  // Here is the bubble method that does the swappy thang....
  //  Whaddya mean?!  OF COURSE it is recursive!  Fuggeddaboutit...
   public void bubbleUp( int index ) {
      if( index == 0 ) {   // base case:
         return;           //  we are already at the root, so we are done
      }

      HeapNode parent = getParent( index );
      int parentIndex = (index -1) / 2;
      if( uriah.get( parentIndex ).getKey() < uriah.get( index ).getKey() ) {
         HeapNode temp = uriah.get( index );
         uriah.set( index,  uriah.get( parentIndex ) );
         uriah.set( parentIndex, temp );
         bubbleUp( parentIndex );
      }
   }

  // Adding in the deletions code.  ArrayListmakes it easy to find the last
  //  node because it's at the end of the array.  We just need to swap it
  //  with the root at element [0], then trickle it down.
   public HeapNode delete() {
      HeapNode returnNode = uriah.get( 0 );     // save the root node
      uriah.set( 0, uriah.get( --size ) );      // move the last node to root
      trickleDown( 0 );                         // re-heapify
      return returnNode;
   }

  // Here is the trickle down method that does the swappy thing in the
  //  other direction, from the root downward.
   public void trickleDown( int index ) {
      int nextIndex = (index * 2) + 1;
      if( nextIndex >= size ) {
         return;
      }
      HeapNode root = uriah.get( index );
      HeapNode next = null;
      if( getChild( index, 'L' ).getKey() >= getChild( index, 'R' ).getKey() ) {
         next = getChild( index, 'L' );
      } else {
         next = getChild( index, 'R' );
         nextIndex++;
      }
      uriah.set( index, next );
      uriah.set( nextIndex, root );
      trickleDown( nextIndex );
   }

  // Because "uriah" the heap is private, here's a public method to
  //  see if it is empty or not
   public boolean isEmpty() {
      return uriah.isEmpty();
   }

  // Because "uriah" the heap is private, here's a public method to
  //  get the size
   public int getSize() {
      return size;
   }

   public static void main( String[] args ) {

      System.out.println( "\n\n   Binary Heap Tester\n\n" );
      System.out.println( "   Creating a new empty heap..." );
      BinaryHeap bh = new BinaryHeap();
      System.out.println( "   Inserting nodes in order: 50, 25, 30, 40, 35, 45, 99" );
      bh.insert( 50 );
      bh.insert( 25 );
      bh.insert( 30 );
      bh.insert( 40 );
      bh.insert( 35 );
      bh.insert( 45 );
      bh.insert( 99 );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "\n\n   Inserting more nodes in order: 70, 83, 61" );
      bh.insert( 70 );
      bh.insert( 83 );
      bh.insert( 61 );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "\n\n   Now deleting one item:" );
      HeapNode returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting one more item:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting one more item:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting three more items:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();

      System.out.println( "   \n\n\nCreating a new empty heap..." );
      bh = new BinaryHeap();
      System.out.println( "   Inserting nodes in order: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10" );
      bh.insert(  1 );
      bh.insert(  2 );
      bh.insert(  3 );
      bh.insert(  4 );
      bh.insert(  5 );
      bh.insert(  6 );
      bh.insert(  7 );
      bh.insert(  8 );
      bh.insert(  9 );
      bh.insert( 10 );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "\n\n   Inserting more nodes in order: 20, 21, 22, 23, 24, 25" );
      bh.insert( 20 );
      bh.insert( 21 );
      bh.insert( 22 );
      bh.insert( 23 );
      bh.insert( 24 );
      bh.insert( 25 );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "\n\n   Now deleting one item:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting one more item:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting one more item:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();
      System.out.println( "   Now deleting three more items:" );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      returned = bh.delete();
      System.out.println( "      Deleted item is: " + returned.getKey() );
      System.out.print( "   Current status is: " );
      bh.print();

      System.out.println( "\n" );
   }
}
