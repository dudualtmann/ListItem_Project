import java.util.List;
import java.util.function.BiFunction;

public class Bananinha {

    public static BiFunction<Integer, List<Integer>, Boolean> foobanana(Foo foo, Integer t1, Integer t2, Integer t3, Bar<Integer> bar) {

        return (Integer x, List<Integer> y) -> {
            List<Integer> z = y;
            z.add(0, t1);
            return bar.test(foo.apply(x,z),t2,t3);
        };


    }

    public static int foo(int[] array, int index, int length) {
        if(index == array.length)
            return length;
        if(array[index] == index || array[index] == -index)
            return foo(array, ++index,++length);
        return foo(array, ++index, length);
    }

    public static int[] bar(int[] array, int aI, int[] result, int rI) {
        if(array.length == aI)
            return result;
        if(array[aI] == aI || array[aI] == -aI) {
            result[rI] = array[aI];
            return bar(array, ++aI, result, ++rI);
        }
        return bar(array, ++aI, result, rI);
    }

    public static double[] foobar(double[] a) {

        int length = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0)
                length++;
            else if (a[i - 1] > a[i]) {
                length++;
            }
        }
        double[] result = new double[length];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                result[0] = a[0];
                index++;
            } else if (a[i - 1] > a[i]) {
                result[index] = a[i];
                index++;
            }

        }
        return result;
    }

}
