package ora;

import java.util.Arrays;

public class TestQuestions {

    Integer[] array;
    int lastInsertedPosition;

    public TestQuestions(int initialSize){
        array = new Integer[initialSize];
    }

    public TestQuestions(Integer[] array){
        this.array = array;
    }

    public void insertElement(int element, int position){
        if(position > array.length-1 || position < 0){
            throw new ArrayIndexOutOfBoundsException(String.format("element cant be inserted at %s", position));
        }

       /* if(lastInsertedPosition == array.length-1){
            throw new ArrayIndexOutOfBoundsException(String.format("element cant be inserted as array is full"));
        }
        */

        array[position] = element;
    }

    public void printArray(){
        System.out.println("--");
        System.out.println(Arrays.toString(array));
        System.out.println("--");
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,2,3,4,5};
        TestQuestions testQuestions = new TestQuestions(array);
        testQuestions.insertElement(30, 2);
        testQuestions.printArray();




//        testQuestions.insertElement(10,0);
//        testQuestions.insertElement(20,1);
//        testQuestions.insertElement(30,2);
//        testQuestions.printArray();
//        testQuestions.insertElement(40,3);
//        testQuestions.printArray();
//        testQuestions.insertElement(90,5);
//        testQuestions.printArray();
//        testQuestions.insertElement(80,-1);
//        testQuestions.printArray();
    }
}
