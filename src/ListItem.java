import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ListItem<T> {

    T key;
    ListItem<T> next;

    public ListItem() {

    }

    public ListItem(T[] items) {
        ListItem<T> t = this.generate(items);
        this.key = t.key;
        this.next = t.next;
    }

    protected <T> ListItem<T> generate(T[] items) {
        ListItem<T> pera = new ListItem<>();
        pera.key = items[0];
        ListItem<T> maca = pera;
        for (int i = 1; i < items.length; i++) {
            maca = maca.next = new ListItem<>();
            maca.key = items[i];
        }
        return pera;
    }

    public void iterate() {
        System.out.println("ITERATOR LIST ITEM");
        for(ListItem<T> p = this; p != null; p = p.next) {
            System.out.println(p.key);
        }
    }

    /**
     *
     * @param key The value to be inserted
     * @return the new ListItem with the key in the start.
     */
    public void insertStart(T key) {

        ListItem<T> tmp = new ListItem<>();
        tmp.key = this.key;
        tmp.next = this.next;

        this.next = tmp;
        this.key = key;

    }

    public void add(T key) {

        for(ListItem<T> p = this; p.next != null; p = p.next) {
            if(p.next.next == null) {
                ListItem<T> item = new ListItem<>();
                item.key = key;
                p.next.next = item;
                break;
            }
        }
    }

    /**
     * Inserts the key in the given index.
     * @param index
     * @param key
     */
    public void add(T key, int index) throws IndexListItemOutOfBoundsException {
        if(index == 0) {
            this.insertStart(key);
            return;
        }

        throwIndexOutOfBounds(index);

        ListItem<T> p = this;
        for(int i = 0; i < index; i++) {
            if(index-1 == i) {
                ListItem<T> tmp = new ListItem<>();
                tmp.key = key;
                tmp.next = p.next;
                p.next = tmp;
                return;
            }
            p = p.next;
        }
    }

    public int length() {
        int counter = 0;
        for (ListItem<T> p = this; p != null; p = p.next) {
            counter++;
        }
        return counter;
    }

    public T get(int index) throws IndexListItemOutOfBoundsException {
        throwIndexOutOfBounds(index);

        ListItem<T> p = this;
        for(int i = 0; i < this.length(); i++) {
            if (index == i)
                return p.key;
            p = p.next;
        }
        return null;
    }

    public void remove(int index) throws IndexListItemOutOfBoundsException {
        throwIndexOutOfBounds(index);

        ListItem<T> p = this;

        for(int i = 0; i < this.length(); i++) {
            if(index-1 == i) {
                p.next = p.next.next;
            }
            p = p.next;
        }
    }

    public void throwIndexOutOfBounds(int index) throws IndexListItemOutOfBoundsException {
        if(index < 0) {
            throw new IndexListItemOutOfBoundsException(index);
        }

        if(index > this.length())
            throw new IndexListItemOutOfBoundsException(index);
    }

    public ListItem<T> filter(Predicate<T> prt) throws IndexListItemOutOfBoundsException {
        ListItem<T> filteredList = new ListItem<>();
        ListItem<T> tail = filteredList;
        boolean lastItemPassedTest = false;
        for(ListItem<T> p = this; p != null; p = p.next) {
            if(prt.test(p.key)) {
                tail.key = p.key;
                tail.next = new ListItem<>();
                tail = tail.next;
                if(p.next == null) {
                    lastItemPassedTest = true;
                }

            }
        }

        if(lastItemPassedTest) {
            return filteredList;
        }

        filteredList.remove(filteredList.length()-1);
        return filteredList;
    }

    public ListItem<T> map(UnaryOperator<T> opt) throws IndexListItemOutOfBoundsException{
        ListItem<T> mappedList = new ListItem<>();
        ListItem<T> pm = mappedList;
        for(ListItem<T> p = this; p != null; p = p.next) {
            pm.key = opt.apply(p.key);
            pm = pm.next = new ListItem<>();
        }

        mappedList.remove(mappedList.length()-1);
        return mappedList;
    }

}
