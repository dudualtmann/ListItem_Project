import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws IndexListItemOutOfBoundsException{

        List<Integer> lst = new ArrayList<Integer>();
        lst.add(4);
        lst.add(20);
        lst.add(20);


        boolean birosca = Bananinha.foobanana((Integer a, List<Integer> b) -> a* b.get(0),4,20,20,
                (Integer c,  Integer d,  Integer e) -> (c == d && d == e)).apply(5,lst);
        System.out.println(birosca);


        int[] array = {0,2,2,5,-4,5,6,8};
        int test = 4;

        int length = Bananinha.foo(array,0,0);
        System.out.println("Test: "+length);

        int[] array2 = new int[length];
        int result[] = Bananinha.bar(array, 0, array2, 0);

        for(int a : result) {
            System.out.println(a);
        }
        System.out.println(result);
        System.out.println("---------------------------------------------------");
        double[] array6 = {3,4,2,5,6,5,8,9,9,8,8,9};
        double[] result6 = Bananinha.foobar(array6);

        for(double a : result6) {
            System.out.println(a);
        }

        Number n = new Integer(2);
        Integer i = new Integer(7);

        Number p = i;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> list2 = list.stream().filter((item) -> item % 2 == 0).collect(Collectors.toList());
        System.out.println("----------------------- Filter ----------------------------");
        for(int a : list2) {
            System.out.println(a);
        }
        System.out.println("------------------------- ListItem --------------------------");
        Integer[] arr = {3,4,2,5,6,5,8,9,9,8,8,9};
        ListItem<Integer> head = new ListItem<>(arr);
        //head.iterate();
        //head.insertStart(10);
        //head.iterate();
        //head.add(10);
        //head.iterate();
        //head.insert(0,65);
        //head.iterate();
        //System.out.println(head.get(5));
        //head.remove(2);
        //head.iterate();
        //Predicate<Integer> prt = (item) -> item % 2 == 0;
        //ListItem<Integer> filteredList = head.filter(prt);
        //filteredList.iterate();
        String[] strArr = {"casa","casamento", "bolo", "xoxota","banana","boca","tocada","podre"};
        ListItem<String> head2 = new ListItem<>(strArr);
        //head2.iterate();
        //Predicate<String> prtStr = (item) -> item.contains("ca");
        //ListItem<String> filteredStringList = head2.filter(prtStr);
        //filteredStringList.iterate();

        ListItem<Integer> mappedList = head.map((item) -> item * 2);
        mappedList.iterate();


    }
}