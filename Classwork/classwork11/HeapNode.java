/*
 * First, a HeapNode class, which is basically just a
 *  wrapper around an "int", but as a node we can use in
 *  a heap structure
 *  (with a possible later Linked List implementation!)
 */

class HeapNode {

   private int data;

  // constructor
   public HeapNode( int key ) {
      data = key;
   }

  // get the data value
   public int getKey() {
      return data;
   }

  // set the data value
   public void setKey( int value ) {
      data = value;
   }
}

