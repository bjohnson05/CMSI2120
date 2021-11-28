/**
 * filename: TruckLoader.java
 * purpose:  demonstrate a Binary Heap in real life
 * @author:  Dr. Johnson
 * @date:    2021-11-10
 * description: A trucking company needs to load several pallets of heavy equipment
 *   onto a semi-trailer rig for shipment.  The heaviest items must be loaded first,
 *   so that the weight is distributed more evenly over all sets of wheels on the
 *   tractor and the trailer.  Your task is to use the heap data structure you have
 *   just developed to determine the loading order so that the heaviest items go in
 *   first, with the lightest items loaded last.  The weights of the pallets are as
 *   follows [in killograms]:
 *   2000, 1000, 500, 3000, 1234, 2129, 1800, 700, 1350, 9800, 1760, 5280, 876, and 4500.
 *
 *   Your task is to print out the appropriate ordering to be used for loading the truck!
 */

public class TruckLoader {

   public static void main( String [] args ) {

      System.out.println( "\n\n   Semi Trailer Loading Program\n\n" );
//      System.out.println( "   Creating a new empty heap..." );
      BinaryHeap bh = new BinaryHeap();
//      System.out.println( "   Inserting nodes in order: 2000, 1000, 500, 3000, 1234, 2129, 1800, 700, 1350, 9800, 1760, 5280, 876, and 4500" );
      bh.insert( 2000 );
      bh.insert( 1000 );
      bh.insert(  500 );
      bh.insert( 3000 );
      bh.insert( 1234 );
      bh.insert( 2129 );
      bh.insert( 1800 );
      bh.insert(  700 );
      bh.insert( 1350 );
      bh.insert( 9800 );
      bh.insert( 1760 );
      bh.insert( 5280 );
      bh.insert(  876 );
      bh.insert( 4500 );
      System.out.println( "   With the following weight pallets:" );
      System.out.print( "   " );
      bh.print();
      System.out.println( "\n   Load the pallets onto the trailer in the following order:" );
      System.out.print( "   " );
      while( bh.getSize() != 0 ) {
         System.out.print( "[" + bh.delete().getKey() + "]" );
      }
      System.out.println( "\n" );
   }
}
