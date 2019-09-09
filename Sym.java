public class Sym {
    private String type;

    /**
     * This is the constructor; it should initialize the Sym to have the given type.
     * 
     * @param type the type this symbol is going to be
     */
    Sym(String type) {
        this.type = type;
    }

    /**
     * Return this Sym's type.
     */
    String getType() {
        return this.type;
    }

    /**
     * Return this Sym's type. (This method will be changed later in a future
     * project when more information is stored in a Sym.)
     */
    public String toString() {
        return this.type;
    }
}