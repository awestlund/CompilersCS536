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
            String toString = testSym.toString();
        } catch (Exception e){
            System.out.println("Sym getType failed with the following exception:" + e);
        }

        // Does getType return correct result
        String toString = testSym.toString();
        if (toString != "String") {
            System.out.println("Sym getType failed type was supposed to be String but accutally was " + toString);
        }

        //This is the constructor; it should initialize the SymTable's List field to contain a single, empty HashMap.
        try{
            SymTable testSymTable = new SymTable();
        } catch (Exception e){
            System.out.println("SymTable contructor failed with the following exception:" + e);
        }

        // test to see if the hashmap is empty
        try{
            SymTable testSymTable1 = new SymTable();
            testSymTable1.print();
            System.out.println("SymTable contructor failed to make an empty hashmap");
        } catch (NullPointerException e){}

        //If this SymTable's list is empty, throw an EmptySymTableException.
        try{
            SymTable testSymTable2 = new SymTable();
            testSymTable2.removeScope();
            testSymTable2.addDecl("name", testSym);
            System.out.println("SymTable's addDecl does not throw an EmptySymTableException");
        } catch (DuplicateSymException | EmptySymTableException e){}
        //If either name or sym (or both) is null, throw a NullPointerException.
        try{
            SymTable testSymTable3 = new SymTable();
            testSymTable3.addDecl("", testSym);
            System.out.println("SymTable's addDecl does not throw a NullPointerException1");
        } catch (DuplicateSymException | EmptySymTableException | NullPointerException e){}
        try{
            SymTable testSymTable4 = new SymTable();
            testSymTable4.addDecl("name", null);
            System.out.println("SymTable's addDecl does not throw a NullPointerException2");
        } catch (DuplicateSymException | EmptySymTableException | NullPointerException e){}
        try{
            SymTable testSymTable5 = new SymTable();
            testSymTable5.addDecl("", null);
            System.out.println("SymTable's addDecl does not throw a NullPointerException3");
        } catch (DuplicateSymException | EmptySymTableException | NullPointerException e){}
        //If the first HashMap in the list already contains the given name as a key, throw a DuplicateSymException. 
        try{
            SymTable testSymTable6 = new SymTable();
            testSymTable6.addDecl("name", testSym);
            testSymTable6.addDecl("name", testSym);
            System.out.println("SymTable's addDecl does not throw a DuplicateSymException");
        } catch (EmptySymTableException | DuplicateSymException e){}
        //Otherwise, add the given name and sym to the first HashMap in the list.
        try{
            SymTable testSymTable7 = new SymTable();
            testSymTable7.addDecl("name1", testSym);
        } catch (Exception e){
            System.out.println("SymTable addDecl failed with the following exception:" + e);
        }

        //Add a new, empty HashMap to the front of the list.
        try{
            SymTable testSymTable8 = new SymTable();
            testSymTable8.addScope();
        } catch (Exception e){
            System.out.println("SymTable addScope() failed with the following exception:" + e);
        }

        //If this SymTable's list is empty, throw an EmptySymTableException. 
        //Otherwise, if the first HashMap in the list contains name as a key, return the associated Sym; otherwise, return null.
        try{
            SymTable testSymTable9 = new SymTable();
            testSymTable9.removeScope();
            Sym returnSym = testSymTable9.lookupLocal("name2");
            System.out.println("SymTable's lookupLocal does not throw an EmptySymTableException");
        } catch (EmptySymTableException e){}

        try{
            SymTable testSymTable10 = new SymTable();
            testSymTable10.addDecl("name2", testSym);
            Sym returnSym = testSymTable10.lookupLocal("name2");
            if (returnSym == null){
                System.out.println("SymTable lookupLocal failed");
            }
            if (returnSym != testSym){
                System.out.println("SymTable lookupLocal failed, it returned the wrong Sym");
            }
        } catch (Exception e){
            System.out.println("SymTable lookupLocal failed with the following exception:" + e);
        }

        //If this SymTable's list is empty, throw an EmptySymTableException. 
        //If any HashMap in the list contains name as a key, return the first associated Sym (i.e., the one from the HashMap that is closest to the front of the list); 
        //otherwise, return null.
        try{
            SymTable testSymTable11 = new SymTable();
            testSymTable11.removeScope();
            Sym returnSym = testSymTable11.lookupGlobal("name2");
            System.out.println("SymTable's lookupGlobal does not throw an EmptySymTableException");
        } catch (EmptySymTableException e){}

        try{
            SymTable testSymTable12 = new SymTable();
            testSymTable12.addDecl("name3", testSym);
            Sym returnSym = testSymTable12.lookupGlobal("name3");
            if (returnSym == null){
                System.out.println("SymTable lookupGlobal failed");
            }
            if (returnSym != testSym){
                System.out.println("SymTable lookupGlobal failed, it returned the wrong Sym");
            }
            Sym returnSym2 = testSymTable12.lookupGlobal("name4");
            if (returnSym2 != null){
                System.out.println("SymTable lookupGlobal failed, it didnt return null");
            }
        } catch (DuplicateSymException | EmptySymTableException e){
            System.out.println("SymTable lookupGlobalfailed with the following exception:" + e);
        }

        //If this SymTable's list is empty, throw an EmptySymTableException; 
        //otherwise, remove the HashMap from the front of the list. 
        //To clarify, throw an exception only if before attempting to remove, the list is empty (i.e. there are no HashMaps to remove).
        //void removeScope() throws EmptySymTableException{}

        try{
            SymTable testSymTable13 = new SymTable();
            testSymTable13.removeScope();
            testSymTable13.removeScope();
            System.out.println("SymTable's removeScope() does not throw an EmptySymTableException");
        } catch (EmptySymTableException e){}

        try{
            SymTable testSymTable14 = new SymTable();
            testSymTable14.addDecl("name3", testSym);
            testSymTable14.removeScope();
            testSymTable14.lookupLocal("name3");
            System.out.println("SymTable's removeScope() does not clear the list");
        } catch (DuplicateSymException | EmptySymTableException e){}
    }
}