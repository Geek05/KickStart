package multiple;

import java.util.Arrays;

public class MultipleInheritanceDemo {

    public static void testAdd(Adder adder) {
        adder.add();
    }

    public static void main(String[] args) {
        int[] array = {43, 19, 98, 3, 21, 70};
        for (int pass = array.length - 1; pass >= 0; pass--) {
            for (int j = 0; j < pass; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
