public class IndexListItemOutOfBoundsException extends Exception{

    public IndexListItemOutOfBoundsException(int index) {
        super(index < 0 ? "The given index '"+index+"' is smaller than zero" : "The given index '"+index+"' is out of bounds");
    }
}
