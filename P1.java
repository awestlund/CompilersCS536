import java.util.*;
/**
 * TestSym
 *
 * This is a class whose sole purpose is to test the List<E> class, which
 * provides the following operations:
 *       no-arg constructor   -- create an empty list
 *       void add(E item)     -- add item to the end of the list
 *       int indexOf(E item)  -- return the index of the first occurrance of
 *                               item in the list, or -1 if there is no such
 *                               occurrance
 *      void remove(int index) -- remove the item at the given position;
 *                                throw an IndexOutOfBoundsException if
 *                                index < 0 or >= size of list
 *
 * This code tests every List operation, including both correct and
 * bad calls to the operation (remove) that can throw an exception.
 * It produces output ONLY if a test fails.
 */

public class P1 {
    public static void main(String [] args) {
        // Test the Sym Class

        // Test Sym construstor
        try{
            Sym testSym = new Sym("String");
        } catch (Exception e){
            System.out.println("Sym contructor failed with the following exception:" + e);
        }

        Sym testSym = new Sym("String");

        // Test Sym getType() method
        //does method compile
        try{
            String type = testSym.getType();
        } catch (Exception e){
            System.out.println("Sym getType failed with the following exception:" + e);
        }

        // Does getType return correct result
        String type = testSym.getType();
        if (type != "String") {
            System.out.println("Sym getType failed type was supposed to be String but accutally was " + type);
        }

        // Test Sym toSymString() method
        // Does method compile
        try{
            String toString = testSym.toSymString();
        } catch (Exception e){
            System.out.println("Sym getType failed with the following exception:" + e);
        }

        // Does getType return correct result
        String toString = testSym.toSymString();
        if (toString != "String") {
            System.out.println("Sym getType failed type was supposed to be String but accutally was " + toString);
        }
    }
}