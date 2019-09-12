import java.util.*;

public class SymTable {
    private LinkedList<HashMap<String, Sym>> table;

    /**
     * This is the constructor; it should initialize the SymTable's List field to
     * contain a single, empty HashMap.
     */
    SymTable() {
        this.table = new LinkedList<HashMap<String, Sym>>();
        HashMap newHashMap = new HashMap<String, Sym>();
        table.addFirst(newHashMap);
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. If either
     * name or sym (or both) is null, throw a NullPointerException. If the first
     * HashMap in the list already contains the given name as a key, throw a
     * DuplicateSymException. Otherwise, add the given name and sym to the first
     * HashMap in the list.
     * 
     * @param name the string value of the key that is being searched for
     * @param sym  type Sym the symbol that we want to store
     */
    void addDecl(String name, Sym sym) throws DuplicateSymException, EmptySymTableException {
        if (table.isEmpty()) {
            throw new EmptySymTableException();
        }
        if (name == "" | name == null | sym == null) {
            throw new NullPointerException();
        }
        if (lookupLocal(name) != null) {
            throw new DuplicateSymException();
        }
        table.get(0).put(name, sym);
    }

    /**
     * Add a new, empty HashMap to the front of the list.
     */
    void addScope() {
        HashMap newHashMap = new HashMap<String, Sym>();
        table.addFirst(newHashMap);
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. Otherwise,
     * if the first HashMap in the list contains name as a key, return the
     * associated Sym; otherwise, return null.
     * 
     * @param name the string value of the key that is being searched for
     */
    Sym lookupLocal(String name) throws EmptySymTableException {
        if (table.isEmpty()) {
            throw new EmptySymTableException();
        }
        HashMap firstEntry = table.getFirst();
        if (firstEntry.containsKey(name)) {
            Sym value = table.getFirst().get(name);
            return value;
        }
        return null;
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. If any
     * HashMap in the list contains name as a key, return the first associated Sym
     * (i.e., the one from the HashMap that is closest to the front of the list);
     * otherwise, return null.
     * 
     * @param name the string value of the key that is being searched for
     */
    Sym lookupGlobal(String name) throws EmptySymTableException {
        if (table.isEmpty()) {
            throw new EmptySymTableException();
        }
        for (HashMap<String, Sym> entry : table) {
            if (entry.containsKey(name)) {
                return entry.get(name);
            }
        }
        return null;
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException; otherwise,
     * remove the HashMap from the front of the list. To clarify, throw an exception
     * only if before attempting to remove, the list is empty (i.e. there are no
     * HashMaps to remove).
     */
    void removeScope() throws EmptySymTableException {
        if (table.isEmpty()) {
            throw new EmptySymTableException();
        }
        table.clear();
    }

    /**
     * This method is for debugging. First, print “\nSym Table\n”.
     * Then, for each HashMap M in the list, print M.toString() followed by a
     * newline.
     * Finally, print one more newline. All output should go to System.out.
     */
    void print(){
        if (table.getFirst().size() == 0){
            throw new NullPointerException();
        }
        System.out.println("\nSym Table\n");
        for (HashMap<String,Sym> entry : table){
            System.out.println(entry.toString());
        }
        System.out.println("");
    }
}