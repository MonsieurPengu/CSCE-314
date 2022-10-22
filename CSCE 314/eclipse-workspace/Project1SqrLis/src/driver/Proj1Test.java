// Name: Ian Wang
// Section: CSCE 314 700 - Group 28
// UIN: 227004716
package driver ;
import squarelist.* ;

/**
  Main program to test SquareList data structure.
  This is just a basic test. You should write your own
  test programs to thoroughly exercise all the methods.
  Grading will include other test programs using larger
  data sets.

  @author Richard Chang
  @version 09/13/2013
*/
public class Proj1Test {

   public static void main (String [] args) {
      System.out.println("Basic Test for Project 1:") ;

      SquareList sqrList = new SquareList() ;
      Integer t ;

      // Step 1: add a bunch of Integers
      System.out.println("\nStep 1: Add initial items.") ;

      sqrList.addFirst( 12) ; sqrList.addFirst( 10) ; sqrList.addFirst(999) ; sqrList.addFirst(999) ;
      sqrList.addFirst(  9) ; sqrList.addFirst(  8) ; sqrList.addFirst(999) ; sqrList.addFirst(  7) ;

      sqrList.addLast( 14) ; sqrList.addLast(996) ; sqrList.addLast( 15) ; sqrList.addLast(995) ;
      sqrList.addLast( 16) ; sqrList.addLast( 17) ; sqrList.addLast( 18) ; sqrList.addLast(994) ;

      sqrList.addFirst(997) ; sqrList.addFirst(  5) ; sqrList.addFirst(992) ; sqrList.addFirst(991) ;
      sqrList.addFirst(  2) ; sqrList.addFirst(989) ; sqrList.addFirst(988) ; sqrList.addFirst(987) ;

      sqrList.addLast( 20) ; sqrList.addLast(993) ; sqrList.addLast(990) ;
      // sqrList.dump() ;

      System.out.println("After Step 1:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;


      // Step 2: trim some items
      System.out.println("\nStep 2: remove some items.") ;

      t = sqrList.removeFirst() ; 
      t = sqrList.removeFirst() ;
      t = sqrList.remove(sqrList.size()-1) ;
      t = sqrList.remove(sqrList.size()-1) ;

      System.out.println("After Step 2:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;


      //Step 3: set a few values
      System.out.println("\nStep 3: change some items.") ;

      sqrList.set(0, 1) ; sqrList.set(2, 3) ; sqrList.set(3, 4) ; sqrList.set(5, 6) ;

      System.out.println("After Step 3:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;


      //Step 4: remove some items
      System.out.println("\nStep 4: remove some more items.") ;

      t = sqrList.remove(7) ; t = sqrList.remove(9) ; t = sqrList.remove(9) ;
      t = sqrList.remove(12) ; t = sqrList.remove(13) ;

      System.out.println("After Step 4:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;


      //Step 5: insert some times
      System.out.println("\nStep 5: insert some items.") ;

      sqrList.add(10,799) ; sqrList.add(12,13) ;

      System.out.println("After Step 5:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;


      //Step 6: change some items
      System.out.println("\nStep 6: change some more items.") ;

      sqrList.set(10,11) ; sqrList.set(18,19) ;


      System.out.println("After Step 6:") ;
      for(int i=0 ; i < sqrList.size() ; i++) {  // very slow!
         System.out.print(sqrList.get(i) + " ") ;
      }
      System.out.println() ;

      System.out.println("\n\nDATA DUMP") ;
      sqrList.dump() ;


      //Step 7: Add even more items, to cause merges
      System.out.println("\n\nStep 7: add items to cause merges.") ;

      for(int i=21 ; i<=101 ;i++) {
         sqrList.addLast(i) ;
      }

      System.out.println("After Step 7:") ;
      System.out.println("DATA DUMP") ;
      sqrList.dump() ;


      //Step 8: Remove lots of items, to cause splits
      System.out.println("\n\nStep 8: remove items to cause splits.") ;

      for(int i=1 ; i<=47 ;i++) {
         t = sqrList.removeFirst() ;
      }

      System.out.println("After Step 8:") ;
      System.out.println("DATA DUMP") ;
      sqrList.dump() ;


      //Step 9: Remove even more items, to cause splits
      System.out.println("\n\nStep 9: remove more items to cause more splits.") ;

      for(int i=1 ; i<=34 ;i++) {
         t = sqrList.removeFirst() ;
      }

      System.out.println("After Step 9:") ;
      System.out.println("DATA DUMP") ;
      sqrList.dump() ;
   }

}