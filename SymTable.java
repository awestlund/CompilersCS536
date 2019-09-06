import java.util.*;

public class SymTable{
    //This is the constructor; it should initialize the SymTable's List field to contain a single, empty HashMap.
    SymTable(){}

    //If this SymTable's list is empty, throw an EmptySymTableException. 
    //If either name or sym (or both) is null, throw a NullPointerException. 
    //If the first HashMap in the list already contains the given name as a key, throw a DuplicateSymException. 
    //Otherwise, add the given name and sym to the first HashMap in the list.
    void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {}

    //Add a new, empty HashMap to the front of the list.
    void addScope(){}

    //If this SymTable's list is empty, throw an EmptySymTableException. 
    //Otherwise, if the first HashMap in the list contains name as a key, return the associated Sym; otherwise, return null.
    Sym lookupLocal(String name){
        return null;
    }

    //If this SymTable's list is empty, throw an EmptySymTableException. 
    //If any HashMap in the list contains name as a key, return the first associated Sym (i.e., the one from the HashMap that is closest to the front of the list); 
    //otherwise, return null.
    Sym lookupGlobal(String name){
        return null;
    }

    //If this SymTable's list is empty, throw an EmptySymTableException; 
    //otherwise, remove the HashMap from the front of the list. 
    //To clarify, throw an exception only if before attempting to remove, the list is empty (i.e. there are no HashMaps to remove).
    void removeScope() throws EmptySymTableException{}

    //This method is for debugging. First, print “\nSym Table\n”. 
    //Then, for each HashMap M in the list, print M.toString() followed by a newline. 
    //Finally, print one more newline. All output should go to System.out.
    void print(){}
}